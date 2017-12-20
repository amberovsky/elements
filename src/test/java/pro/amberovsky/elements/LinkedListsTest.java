package pro.amberovsky.elements;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.jupiter.api.Test;
import pro.amberovsky.elements.util.data.DoubleListNode;
import pro.amberovsky.elements.util.data.ListNode;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(DataProviderRunner.class)
public class LinkedListsTest {

    @DataProvider
    public static Object[] dataProviderForTestMergeTwoSortedLists() {
        return new Object[] {
                new Object[] {
                        new Integer[] { 1 },
                        new Integer[] { 1 },
                        new Integer[] { }
                },

                new Object[] {
                        new Integer[] { },
                        new Integer[] { },
                        new Integer[] { }
                },

                new Object[] {
                        new Integer[] { 1 },
                        new Integer[] { },
                        new Integer[] { 1 }
                },

                new Object[] {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        new Integer[] { 1, 2, 3 },
                        new Integer[] { 4, 5, 6 }
                },

                new Object[] {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        new Integer[] { 4, 5, 6 },
                        new Integer[] { 1, 2, 3 }
                },

                new Object[] {
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        new Integer[] { 1, 3, 5 },
                        new Integer[] { 2, 4, 6 }
                },
        };
    }
//
//    @Test
//    @UseDataProvider("dataProviderForTestMergeTwoSortedLists")
//    public void testMergeTwoSortedLists(Object[] data) {
//        assertEquals(
//                ListNode.toListNode((Integer[]) data[0]),
//                LinkedLists.mergeTwoSortedLists(
//                        ListNode.toListNode((Integer[]) data[1]),
//                        ListNode.toListNode((Integer[]) data[2])
//                )
//        );
//    }

//    @Test
//    @UseDataProvider("dataProviderForTestMergeTwoSortedLists")
//    public void testMergeTwoSortedLists_Double(Object[] data) {
//        assertEquals(
//                DoubleListNode.toListNode((Integer[]) data[0]),
//                LinkedLists.mergeTwoSortedLists_Double(
//                        DoubleListNode.toListNode((Integer[]) data[1]),
//                        DoubleListNode.toListNode((Integer[]) data[2])
//                )
//        );
//    }



    /*
    REVERSE A SINGLE SUBLIST
     */
    @Test
    public void testReverseASingleSublist() {
        assertEquals(
                ListNode.toListNode(1),
                LinkedLists.reverseASingleSublist(ListNode.toListNode(1), 0, 0)
        );

        assertEquals(
                ListNode.toListNode(2, 1),
                LinkedLists.reverseASingleSublist(ListNode.toListNode(1, 2), 0, 1)
        );

        assertEquals(
                ListNode.toListNode(1, 2, 3),
                LinkedLists.reverseASingleSublist(ListNode.toListNode(1, 2, 3), 1, 1)
        );

        assertEquals(
                ListNode.toListNode(2, 1, 3, 4),
                LinkedLists.reverseASingleSublist(ListNode.toListNode(1, 2, 3, 4), 0, 1)
        );

        assertEquals(
                ListNode.toListNode(1, 3, 2, 4),
                LinkedLists.reverseASingleSublist(ListNode.toListNode(1, 2, 3, 4), 1, 2)
        );

        assertEquals(
                ListNode.toListNode(1, 2, 4, 3),
                LinkedLists.reverseASingleSublist(ListNode.toListNode(1, 2, 3, 4), 2, 3)
        );
    }

    @Test
    public void testReverseASingleSublist_List() {
        assertEquals(ListNode.toListNode(1), LinkedLists.reverseASingleSublist_List(ListNode.toListNode(1)));

        assertEquals(ListNode.toListNode(2, 1), LinkedLists.reverseASingleSublist_List(ListNode.toListNode(1, 2)));

        assertEquals(ListNode.toListNode(3, 2, 1), LinkedLists.reverseASingleSublist_List(ListNode.toListNode(1, 2, 3)));
    }



    /*
    TEST FOR CYCLICITY
     */
    @Test
    public void testDetectCycleInASingleLinkedList() {
        assertNull(LinkedLists.detectCycleInASingleLinkedList(ListNode.toListNode(1)));

        ListNode<Integer> list = ListNode.toListNode(1);
        list.next = list;
        assertEquals(list, LinkedLists.detectCycleInASingleLinkedList(list));

        list = ListNode.toListNode(1, 2);
        list.next.next = list.next;
        assertEquals(list.next, LinkedLists.detectCycleInASingleLinkedList(list));
    }



    /*
    TEST FOR OVERLAPPING LISTS — LISTS ARE CYCLE-FREE
     */
    @Test
    public void testIsThereACommonNodeInCycleFreeLists() {
        assertNull(LinkedLists.isThereACommonNodeInCycleFreeLists(ListNode.toListNode(1), ListNode.toListNode(1)));

        ListNode<Integer> list1 = ListNode.toListNode(1);
        ListNode<Integer> list2 = list1;
        assertEquals(list1, LinkedLists.isThereACommonNodeInCycleFreeLists(list1, list2));

        list1 = ListNode.toListNode(1, 2, 3);
        list2 = list1.next;
        assertEquals(list1.next, LinkedLists.isThereACommonNodeInCycleFreeLists(list1, list2));

        list1 = ListNode.toListNode(1);
        list2 = ListNode.toListNode(1, 2);
        list1.next = list2.next;
        assertEquals(list1.next, LinkedLists.isThereACommonNodeInCycleFreeLists(list1, list2));
    }



    /*
    TEST FOR OVERLAPPING LISTS — LISTS MAY HAVE CYCLES
     */
    @Test
    public void testIsThereACommonNodeInListsWithCycles() {
        assertNull(LinkedLists.isThereACommonNodeInListsWithCycles(ListNode.toListNode(1), ListNode.toListNode(1)));

        ListNode<Integer> list1 = ListNode.toListNode(1);
        ListNode<Integer> list2 = list1;
        assertEquals(list2, LinkedLists.isThereACommonNodeInListsWithCycles(list1, list2));

        list1 = ListNode.toListNode(1, 2);
        list2 = list1.next;
        assertEquals(list2, LinkedLists.isThereACommonNodeInListsWithCycles(list1, list2));

        list1 = ListNode.toListNode(1, 2, 3);
        list1.next.next = list1.next;
        list2 = list1;
        assertEquals(list2.next, LinkedLists.isThereACommonNodeInListsWithCycles(list1, list2));
    }



    /*
    DELETE A NODE FROM A SINGLE LINKED LIST
     */
    @Test
    public void testDeleteANodeFromASingleLinkedList() {
        ListNode<Integer> list;

        list = ListNode.toListNode(1, 2);
        ListNode<Integer> nextNode = list.next;
        LinkedLists.deleteANodeFromASingleLinkedList(list);
        assertEquals(list, nextNode);


        list = ListNode.toListNode(1, 2, 3);
        LinkedLists.deleteANodeFromASingleLinkedList(list.next);
        assertEquals(ListNode.toListNode(1, 3), list);
    }



    /*
    REMOVE THE KTH LAST ELEMENT FROM A LIST
     */
    @Test
    public void testRemoveTheKthLastElementFromAList() {
        assertEquals(null, LinkedLists.removeTheKthLastElementFromAList(ListNode.toListNode(1), 1));
        assertEquals(ListNode.toListNode(1), LinkedLists.removeTheKthLastElementFromAList(ListNode.toListNode(1, 2), 1));
        assertEquals(ListNode.toListNode(2), LinkedLists.removeTheKthLastElementFromAList(ListNode.toListNode(1, 2), 2));
    }



    /*
    REMOVE DUPLICATES FROM A SORTED LIST
     */
    @Test
    public void testRemoveDuplicatesFormASortedList() {
        assertEquals(ListNode.toListNode(1), LinkedLists.removeDuplicatesFormASortedList(ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(1), LinkedLists.removeDuplicatesFormASortedList(ListNode.toListNode(1, 1)));
        assertEquals(ListNode.toListNode(1), LinkedLists.removeDuplicatesFormASortedList(ListNode.toListNode(1, 1, 1)));

        assertEquals(ListNode.toListNode(1, 2), LinkedLists.removeDuplicatesFormASortedList(ListNode.toListNode(1, 2)));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.removeDuplicatesFormASortedList(ListNode.toListNode(1, 2, 2)));
    }

    @Test
    public void testRemoveDuplicatesFormASortedList_M() {
        assertEquals(ListNode.toListNode(1, 1, 1), LinkedLists.removeDuplicatesFormASortedList_M(ListNode.toListNode(1, 1, 1), 3));
        assertEquals(ListNode.toListNode(1), LinkedLists.removeDuplicatesFormASortedList_M(ListNode.toListNode(1, 1, 1), 2));

        assertEquals(ListNode.toListNode(1, 1, 1, 2), LinkedLists.removeDuplicatesFormASortedList_M(ListNode.toListNode(1, 1, 1, 2, 2, 2, 2), 3));
    }



    /*
    IMPLEMENT CYCLIC RIGHT SHIFT FOR SINGLE LINKED LISTS
     */
    @Test
    public void testCycleRightShift() {
        assertEquals(ListNode.toListNode(1), LinkedLists.cycleRightShift(ListNode.toListNode(1), 0));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2), 0));
        assertEquals(ListNode.toListNode(1, 2, 3), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2, 3), 0));

        assertEquals(ListNode.toListNode(1), LinkedLists.cycleRightShift(ListNode.toListNode(1), 1));
        assertEquals(ListNode.toListNode(2, 1), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2), 1));
        assertEquals(ListNode.toListNode(3, 1, 2), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2, 3), 1));

        assertEquals(ListNode.toListNode(1), LinkedLists.cycleRightShift(ListNode.toListNode(1), 2));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2), 2));
        assertEquals(ListNode.toListNode(2, 3, 1), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2, 3), 2));

        assertEquals(ListNode.toListNode(1), LinkedLists.cycleRightShift(ListNode.toListNode(1), 3));
        assertEquals(ListNode.toListNode(2, 1), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2), 3));
        assertEquals(ListNode.toListNode(1, 2, 3), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2, 3), 3));

        assertEquals(ListNode.toListNode(1), LinkedLists.cycleRightShift(ListNode.toListNode(1), 4));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2), 4));
        assertEquals(ListNode.toListNode(3, 1, 2), LinkedLists.cycleRightShift(ListNode.toListNode(1, 2, 3), 4));
    }



    /*
    IMPLEMENT EVEN-ODD MERGE
     */
    @Test
    public void testEvenOddMerge() {
        assertEquals(ListNode.toListNode(1), LinkedLists.evenOddMerge(ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.evenOddMerge(ListNode.toListNode(1, 2)));
        assertEquals(ListNode.toListNode(1), LinkedLists.evenOddMerge(ListNode.toListNode(1)));
    }



    /*
    TEST WHETHER A SINGLE LINKED LIST IS PALINDROMIC
     */
    @Test
    public void testTestWhetherASingleLinkedListIsPalindromic() {
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 1)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 1, 1)));

        assertFalse(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 2)));
        assertFalse(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 2, 2)));

        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 2, 1)));

        assertFalse(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 1, 2, 2)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(2, 1, 1, 2)));
    }

    @Test
    public void testTestWhetherASingleLinkedListIsPalindromic_Double() {
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 1)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 1, 1)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 1)));
        assertTrue(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 2, 1)));

        assertFalse(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2)));
        assertFalse(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 2)));
        assertFalse(LinkedLists.testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 3)));
    }



    /*
    IMPLEMENT LIST PIVOTING
     */
    @Test
    public void testListPivoting() {
        assertEquals(ListNode.toListNode(1), LinkedLists.listPivoting(ListNode.toListNode(1), -1));
        assertEquals(ListNode.toListNode(1), LinkedLists.listPivoting(ListNode.toListNode(1), 1));
        assertEquals(ListNode.toListNode(1), LinkedLists.listPivoting(ListNode.toListNode(1), 10));

        assertEquals(ListNode.toListNode(1, 2), LinkedLists.listPivoting(ListNode.toListNode(1, 2), -1));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.listPivoting(ListNode.toListNode(1, 2), 1));
        assertEquals(ListNode.toListNode(1, 2), LinkedLists.listPivoting(ListNode.toListNode(1, 2), 2));

        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), LinkedLists.listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), -1));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), LinkedLists.listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 1));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), LinkedLists.listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 3));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), LinkedLists.listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 5));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), LinkedLists.listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 10));

        assertEquals(ListNode.toListNode(1, 2, 4, 5), LinkedLists.listPivoting(ListNode.toListNode(1, 2, 4, 5), 3));

        assertEquals(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), LinkedLists.listPivoting(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), -1));
        assertEquals(ListNode.toListNode(1, 3, 0, 5, 9, 100, 100, 120), LinkedLists.listPivoting(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), 5));
        assertEquals(ListNode.toListNode(5, 1, 9, 3, 0, 100, 100, 120), LinkedLists.listPivoting(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), 100));
    }



    /*
    ADD LIST-BASED INTEGERS
     */
    @Test
    public void testAddListBasedIntegers() {
        assertEquals(ListNode.toListNode(0), LinkedLists.addListBasedIntegers(ListNode.toListNode(-1), ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(9, 7, 3, 0, 1), LinkedLists.addListBasedIntegers(ListNode.toListNode(0, 8, 3), ListNode.toListNode(9, 9, 9, 9)));
    }

    @Test
    public void testAddListBasedIntegers_MostSignificantDigitComesFirst() {
        assertEquals(ListNode.toListNode(0), LinkedLists.addListBasedIntegers(ListNode.toListNode(-1), ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(1, 0, 3, 7, 9), LinkedLists.addListBasedIntegers_MostSignificantDigitComesFirst(ListNode.toListNode(3, 8, 0), ListNode.toListNode(9, 9, 9, 9)));
    }

}
