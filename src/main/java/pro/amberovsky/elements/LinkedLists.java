package pro.amberovsky.elements;

import pro.amberovsky.elements.util.data.DoubleListNode;
import pro.amberovsky.elements.util.data.ListNode;

/**
 * Various tasks on linked lists
 */
public class LinkedLists {
    /*
    MERGE TWO SORTED LISTS
     */

    /**
     * Merge two sorted single linked lists
     *
     * @Complexity  O(n + m), O(1) space
     *
     * @param list1 first list
     * @param list2 second list
     *
     * @return merged lists
     */
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> result = new ListNode<>(0, null);
        ListNode<Integer> current = result;

        while ((list1 != null) && (list2 != null)) {
            if (list1.data < list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = (list1 == null) ? list2 : list1;

        return result.next;
    }

    /**
     * Variant: double-linked lists
     *
     * @Complexity O(n + m), O(1) space
     *
     * @param list1 first list
     * @param list2 second list
     *
     * @return merged lists
     */
    public static DoubleListNode<Integer> mergeTwoSortedLists_Double(
            DoubleListNode<Integer> list1, DoubleListNode<Integer> list2
    ) {
        DoubleListNode<Integer> result = new DoubleListNode<>(0);

        DoubleListNode<Integer> current = result;

        while ((list1 != null) && (list2 != null)) {
            if (list1.data < list2.data) {
                current.next = list1;
                current.next.prev = current;

                list1 = list1.next;
            } else {
                current.next = list2;
                current.next.prev = current;

                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = (list1 == null) ? list2 : list1;
        if (current.next != null) current.next.prev = current;

        return result.next;
    }



    /*
    REVERSE A SINGLE SUBLIST
     */

    /**
     * Reverse a single sublist
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param list single linked list
     * @param index1 sublist start index
     * @param index2 sublist end index
     * @param <T> type
     *
     * @return list with reversed sublist
     */
    public static <T> ListNode<T> reverseASingleSublist(ListNode<T> list, int index1, int index2) {
        ListNode<T> dummyNode = new ListNode<>(null, list);

        ListNode<T> prev = dummyNode;

        for (int i = 0; i < index1; i++) prev = prev.next;

        ListNode<T> curr = prev.next;

        for (int i = index1; i < index2; i++) {
            ListNode<T>  next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummyNode.next;
    }

    /**
     * Reverse single linked list
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param list single linked list
     * @param <T> type
     *
     * @return reversed single linked list
     */
    public static <T> ListNode<T> reverseASingleSublist_List(ListNode<T> list) {
        ListNode<T> current = list;

        while (current.next != null) {
            ListNode<T> next = current.next;
            current.next = next.next;
            next.next = list;
            list = next;
        }

        return list;
    }



    /*
    TEST FOR CYCLICITY
     */

    /**
     * Detect cycle in a single linked list
     *
     * @Complexity O(n), O(1) space
     *
     * @param list single linked list
     * @param <T> type
     *
     * @return null if there is no cycle, first node of the cycle otherwise
     */
    public static <T> ListNode<T> detectCycleInASingleLinkedList(ListNode<T> list) {
        ListNode<T> p1 = list;
        ListNode<T> p2 = list;

        while ((p2 != null) && (p2.next != null)) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                int length = 0;

                do {
                    length++;
                    p2 = p2.next;
                }
                while (p2 != p1);

                ListNode<T> firstIter = list;
                while (length-- > 0) firstIter = firstIter.next;

                ListNode<T> secondIter = list;

                while (secondIter != firstIter) {
                    firstIter = firstIter.next;
                    secondIter = secondIter.next;
                }

                return firstIter;
            }
        }

        return null;
    }



    /*
    TEST FOR OVERLAPPING LISTS — LISTS ARE CYCLE-FREE
     */

    /**
     * Check do single linked lists overlap assuming they do not have cycles
     *
     * @Complexity O(n), O(1) space
     * @Algorithm Calculate lengths
     *
     * @param list1 first list
     * @param list2 second list
     * @param <T> type
     *
     * @return common node, null otherwise
     */
    public static <T> ListNode<T> isThereACommonNodeInCycleFreeLists(ListNode<T> list1, ListNode<T> list2) {
        int len1 = 0;
        ListNode<T> p;

        p = list1;
        while (p != null) {
            len1++;
            p = p.next;
        }

        int len2 = 0;
        p = list2;
        while (p != null) {
            len2++;
            p = p.next;
        }


        if (len1 < len2) {
            while (len2-- > len1) list2 = list2.next;
        } else if (len2 < len1) {
            while (len1-- > len2) list1 = list1.next;
        } else {
            len1--;
        }

        while (len1-- >= 0) {
            if (list1 == list2) return list1;

            list1 = list1.next;
            list2 = list2.next;
        }

        return null;
    }



    /*
    TEST FOR OVERLAPPING LISTS — LISTS MAY HAVE CYCLES
     */

    /**
     * Check do single linked lists have a node in common, assuming they can have cycles
     *
     * @Algorithm O(n + m), O(1) space
     *
     * @param list1 first list
     * @param list2 second list
     * @param <T> type
     *
     * @return a common node, null otherwise
     */
    public static <T> ListNode<T> isThereACommonNodeInListsWithCycles(ListNode<T> list1, ListNode<T> list2) {
        // Check is there a cycle in each list
        ListNode<T> cycle1 = detectCycleInASingleLinkedList(list1);
        ListNode<T> cycle2 = detectCycleInASingleLinkedList(list2);

        if ((cycle1 == null) && (cycle2 == null)) {
            // Both lists do not have cycle
            return isThereACommonNodeInCycleFreeLists(list1, list2);
        } else if ((cycle1 != null) && (cycle2 != null)) {
            // Both lists have cycle
            ListNode<T> p = cycle2;

            do {
                p = p.next;
            }
            while ((p != cycle2) && (p != cycle1));

            if (p != cycle1) return null; // Different cycles

            return cycle2;
        } else {
            // If one list has a cycle and other doesn't - they don't have a node in common
            return null;
        }
    }



    /*
    DELETE A NODE FROM A SINGLE LINKED LIST
     */

    /**
     * Delete a node from a single linked list, assuming it is not the last node
     *
     * @Complexity O(1), O(1) space
     *
     * @param node node to delete
     * @param <T> type
     */
    public static <T> void deleteANodeFromASingleLinkedList(ListNode<T> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }



    /*
    REMOVE THE KTH LAST ELEMENT FROM A LIST
     */

    /**
     * Remove the Kth last node from a list, assuming the length is at least k. You can not calculate the length of the
     *  list
     *
     * @Complexity O(n), O(1) space
     *
     * @param list single linked list
     * @param k node number
     * @param <T> type
     *
     * @return list with removed node
     */
    public static <T> ListNode<T> removeTheKthLastElementFromAList(ListNode<T> list, int k) {
        ListNode<T> dummyHead = new ListNode<>(null, list);
        ListNode<T> p2 = list;

        while (k-- > 0) p2 = p2.next;

        ListNode<T> p1 = dummyHead;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;

        return dummyHead.next;
    }




    /*
    REMOVE DUPLICATES FROM A SORTED LIST
     */

    /**
     * Remove duplicates from a sorted single linked list
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param list list
     * @param <T> type
     *
     * @return updated list
     */
    public static <T> ListNode<T> removeDuplicatesFormASortedList(ListNode<T> list) {
        ListNode<T> p = list;

        while (p != null) {
            ListNode<T> next = p.next;

            while ((next != null) && (next.data == p.data)) {
                next = next.next;
            }

            p.next = next;
            p = next;
        }

        return list;
    }


    /**
     * Variant: remove only if number occurs more than m times
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param list sorted single singled list
     * @param m number of same nodes
     * @param <T> types
     *
     * @return updated list
     */
    public static <T> ListNode<T> removeDuplicatesFormASortedList_M(ListNode<T> list, int m) {
        ListNode<T> p = list;

        while (p != null) {
            ListNode<T> next = p.next;
            int count = 1;

            while ((next != null) && (next.data == p.data)) {
                next = next.next;
                count++;
            }

            if (count > m) {
                p.next = next;
            }

            p = next;
        }

        return list;
    }



    /*
    IMPLEMENT CYCLIC RIGHT SHIFT FOR SINGLE LINKED LISTS
     */

    /**
     * Cyclic right shift for single linked list
     *
     * @Complexity O(n), O(1) space
     *
     * @param list single linked list
     * @param k rotation
     * @param <T> type
     *
     * @return rotated list
     */
    public static <T> ListNode<T> cycleRightShift(ListNode<T> list, int k) {
        ListNode<T> last = list;
        int length = 1;

        while (last.next != null) {
            length++;
            last = last.next;
        }

        int actualShift = k % length;
        if (actualShift == 0) return list;

        ListNode<T> p = list;

        for (int i = 0; i < length - actualShift - 1; i++) {
            p = p.next;
        }

        last.next = list;
        list = p.next;
        p.next = null;

        return list;
    }



    /*
    IMPLEMENT EVEN-ODD MERGE
     */

    /**
     * Reorganise a single linked list in such a way that even nodes comes first, then odd nodes
     *
     * @Complexity O(n), O(1) space
     *
     * @param list list
     * @param <T> type
     *
     * @return reorganised list
     */
    public static <T> ListNode<T> evenOddMerge(ListNode<T> list) {
        ListNode<T> tailOdd = null;
        ListNode<T> headOdd = null;
        ListNode<T> tailEven = null;

        ListNode<T> p = list;
        int index = 0;

        while (p != null) {
            ListNode<T> next = p.next;
            p.next = null;

            if (index % 2 == 0) {
                if (tailEven != null) tailEven.next = p;
                tailEven = p;
            } else {
                if (tailOdd != null) tailOdd.next = p;
                else headOdd = p;

                tailOdd = p;
            }

            p = next;
            index++;
        }

        tailEven.next = headOdd;

        return list;
    }



    /*
    TEST WHETHER A SINGLE LINKED LIST IS PALINDROMIC
     */

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm Reverse the second half of the list
     *
     * @param list single linked list
     * @param <T> type
     *
     * @return bool if the list is palindromic, false otherwise
     */
    public static <T> boolean testWhetherASingleLinkedListIsPalindromic(ListNode<T> list) {
        int length = 1;

        ListNode<T> p = list;
        while (p.next != null) {
            length++;
            p = p.next;
        }

        if (length == 1) return true;

        // Find the middle
        p = list;
        for (int i = 0; i < length/ 2; i++) p = p.next;

        ListNode<T> tail = p;

        // Reverse the tail
        while (p.next != null) {
            ListNode<T> tmp = p.next;
            p.next = tmp.next;
            tmp.next = tail;
            tail = tmp;
        }

        while (tail != null) {
            if (!tail.data.equals(list.data)) return false;
            tail = tail.next;
            list = list.next;
        }

        return true;
    }

    /**
     * Variant: Double linked list
     *
     * @param list double linked list
     * @param <T> type
     *
     * @return true if the list is palindromic, false otherwise
     */
    public static <T> boolean testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode<T> list) {
        DoubleListNode<T> p = list;
        int length = 1;

        while (p.next != null) {
            length++;
            p = p.next;
        }

        while ((length-- / 2) > 0) {
            if (!list.data.equals(p.data)) return false;
            list = list.next;
            p = p.prev;
        }

        return true;
    }



    /*
    IMPLEMENT LIST PIVOTING
     */

    /**
     * Perform a pivot of a single linked list with respect to given pivot element
     *
     * @Complexity O(n), O(1) space
     * @Algorithm Dutch flag problem
     *
     * @param list single linked list
     * @param pivot pivot element
     * @param <T> type
     *
     * @return reorganised list
     */
    public static <T extends Comparable<T>> ListNode<T> listPivoting(ListNode<T> list, T pivot) {
        ListNode<T> headLess = new ListNode<>(null);
        ListNode<T> tailLess = headLess;
        ListNode<T> headEqual = new ListNode<>(null);
        ListNode<T> tailEqual = headEqual;
        ListNode<T> headMore = new ListNode<>(null);
        ListNode<T> tailMore = headMore;

        while (list != null) {
            int compare = list.data.compareTo(pivot);
            if (compare < 0) {
                tailLess.next = list;
                tailLess = list;
            } else if (compare == 0) {
                tailEqual.next = list;
                tailEqual = list;
            } else {
                tailMore.next = list;
                tailMore = list;
            }

            list = list.next;
        }

        tailMore.next = null;
        tailEqual.next = headMore.next;
        tailLess.next = headEqual.next;

        return headLess.next;
    }



    /*
    ADD LIST-BASED INTEGERS
     */

    /**
     * Add two non-negative integers in list format when the least significant digit comes first
     *
     * @Complexity O(n + m), O(max(n, m)) space
     *
     * @param number1 first number
     * @param number2 second number
     *
     * @return sum
     */
    public static ListNode<Integer> addListBasedIntegers(ListNode<Integer> number1, ListNode<Integer> number2) {
        ListNode<Integer> result = new ListNode<>(0);
        ListNode<Integer> resultTail = result;

        int carry = 0;

        while ((number1 != null) || (number2 != null)) {
            int sum = carry;

            if (number1 != null) {
                sum += number1.data;
                number1 = number1.next;
            }

            if (number2 != null) {
                sum += number2.data;
                number2 = number2.next;
            }

            carry = sum / 10;
            sum %= 10;

            resultTail.next = new ListNode<>(sum);
            resultTail = resultTail.next;
        }

        if (carry > 0) {
            resultTail.next = new ListNode<>(carry);
        }

        return result.next;
    }

    /**
     * Variant: most significant digit comes first
     *
     * @Complexity O(n + m), O(max(n, m)) space
     *
     * @param number1 first number
     * @param number2 second number
     *
     * @return sum
     */
    public static ListNode<Integer> addListBasedIntegers_MostSignificantDigitComesFirst(ListNode<Integer> number1, ListNode<Integer> number2) {
        // Reverse number1
        ListNode<Integer> number1Head = number1;

        while (number1.next != null) {
            ListNode<Integer> tmp = number1.next;
            number1.next = tmp.next;
            tmp.next = number1Head;
            number1Head = tmp;
        }


        // Reverse number2
        ListNode<Integer> number2Head = number2;

        while (number2.next != null) {
            ListNode<Integer> tmp = number2.next;
            number2.next = tmp.next;
            tmp.next = number2Head;
            number2Head = tmp;
        }

        ListNode<Integer> result = addListBasedIntegers(number1Head, number2Head);

        // Reverse the result
        ListNode<Integer> resultHead = result;
        while (result.next != null) {
            ListNode<Integer> tmp = result.next;
            result.next = tmp.next;
            tmp.next = resultHead;
            resultHead = tmp;
        }

        return resultHead;
    }
}
