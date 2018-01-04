package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.amberovsky.elements.util.data.DoubleListNode;
import pro.amberovsky.elements.util.data.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static pro.amberovsky.elements.LinkedLists.*;

class LinkedListsTest {
    /*
    MERGE TWO SORTED LISTS
     */
    private static Stream<Arguments> sourceForTestMergeTwoSortedLists() {
        return Stream.of(
                Arguments.of(
                        new Integer[] { 1 },
                        new Integer[] { 1 },
                        new Integer[] { }
                ),

                Arguments.of(
                        new Integer[] { },
                        new Integer[] { },
                        new Integer[] { }
                ),

                Arguments.of(
                        new Integer[] { 1 },
                        new Integer[] { },
                        new Integer[] { 1 }
                ),

                Arguments.of(
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        new Integer[] { 1, 2, 3 },
                        new Integer[] { 4, 5, 6 }
                ),

                Arguments.of(
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        new Integer[] { 4, 5, 6 },
                        new Integer[] { 1, 2, 3 }
                ),

                Arguments.of(
                        new Integer[] { 1, 2, 3, 4, 5, 6 },
                        new Integer[] { 1, 3, 5 },
                        new Integer[] { 2, 4, 6 }
            )
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForTestMergeTwoSortedLists")
    void testMergeTwoSortedLists(Integer expected[], Integer firstList[], Integer secondList[]) {
        assertEquals(
                ListNode.toListNode(expected),
                mergeTwoSortedLists(
                        ListNode.toListNode(firstList),
                        ListNode.toListNode(secondList)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForTestMergeTwoSortedLists")
    void testMergeTwoSortedLists_Double(Integer expected[], Integer firstList[], Integer secondList[]) {
        assertEquals(
                DoubleListNode.toListNode(expected),
                mergeTwoSortedLists_Double(
                        DoubleListNode.toListNode(firstList),
                        DoubleListNode.toListNode(secondList)
                )
        );
    }



    /*
    REVERSE A SINGLE SUBLIST
     */
    @Test
    void testReverseASingleSublist() {
        assertEquals(
                ListNode.toListNode(1),
                reverseASingleSublist(ListNode.toListNode(1), 0, 0)
        );

        assertEquals(
                ListNode.toListNode(2, 1),
                reverseASingleSublist(ListNode.toListNode(1, 2), 0, 1)
        );

        assertEquals(
                ListNode.toListNode(1, 2, 3),
                reverseASingleSublist(ListNode.toListNode(1, 2, 3), 1, 1)
        );

        assertEquals(
                ListNode.toListNode(2, 1, 3, 4),
                reverseASingleSublist(ListNode.toListNode(1, 2, 3, 4), 0, 1)
        );

        assertEquals(
                ListNode.toListNode(1, 3, 2, 4),
                reverseASingleSublist(ListNode.toListNode(1, 2, 3, 4), 1, 2)
        );

        assertEquals(
                ListNode.toListNode(1, 2, 4, 3),
                reverseASingleSublist(ListNode.toListNode(1, 2, 3, 4), 2, 3)
        );
    }

    @Test
    void testReverseASingleSublist_List() {
        assertEquals(ListNode.toListNode(1), reverseASingleSublist_List(ListNode.toListNode(1)));

        assertEquals(ListNode.toListNode(2, 1), reverseASingleSublist_List(ListNode.toListNode(1, 2)));

        assertEquals(ListNode.toListNode(3, 2, 1), reverseASingleSublist_List(ListNode.toListNode(1, 2, 3)));
    }



    /*
    TEST FOR CYCLICITY
     */
    @Test
    void testDetectCycleInASingleLinkedList() {
        assertNull(detectCycleInASingleLinkedList(ListNode.toListNode(1)));

        ListNode<Integer> list = ListNode.toListNode(1);
        list.next = list;
        assertEquals(list, detectCycleInASingleLinkedList(list));

        list = ListNode.toListNode(1, 2);
        list.next.next = list.next;
        assertEquals(list.next, detectCycleInASingleLinkedList(list));
    }



    /*
    TEST FOR OVERLAPPING LISTS — LISTS ARE CYCLE-FREE
     */
    @Test
    void testIsThereACommonNodeInCycleFreeLists() {
        assertNull(isThereACommonNodeInCycleFreeLists(ListNode.toListNode(1), ListNode.toListNode(1)));

        ListNode<Integer> list1 = ListNode.toListNode(1);
        ListNode<Integer> list2 = list1;
        assertEquals(list1, isThereACommonNodeInCycleFreeLists(list1, list2));

        list1 = ListNode.toListNode(1, 2, 3);
        list2 = list1.next;
        assertEquals(list1.next, isThereACommonNodeInCycleFreeLists(list1, list2));

        list1 = ListNode.toListNode(1);
        list2 = ListNode.toListNode(1, 2);
        list1.next = list2.next;
        assertEquals(list1.next, isThereACommonNodeInCycleFreeLists(list1, list2));
    }



    /*
    TEST FOR OVERLAPPING LISTS — LISTS MAY HAVE CYCLES
     */
    @Test
    void testIsThereACommonNodeInListsWithCycles() {
        assertNull(isThereACommonNodeInListsWithCycles(ListNode.toListNode(1), ListNode.toListNode(1)));

        ListNode<Integer> list1 = ListNode.toListNode(1);
        ListNode<Integer> list2 = list1;
        assertEquals(list2, isThereACommonNodeInListsWithCycles(list1, list2));

        list1 = ListNode.toListNode(1, 2);
        list2 = list1.next;
        assertEquals(list2, isThereACommonNodeInListsWithCycles(list1, list2));

        list1 = ListNode.toListNode(1, 2, 3);
        list1.next.next = list1.next;
        list2 = list1;
        assertEquals(list2.next, isThereACommonNodeInListsWithCycles(list1, list2));
    }



    /*
    DELETE A NODE FROM A SINGLE LINKED LIST
     */
    @Test
    void testDeleteANodeFromASingleLinkedList() {
        ListNode<Integer> list;

        list = ListNode.toListNode(1, 2);
        ListNode<Integer> nextNode = list.next;
        deleteANodeFromASingleLinkedList(list);
        assertEquals(list, nextNode);


        list = ListNode.toListNode(1, 2, 3);
        deleteANodeFromASingleLinkedList(list.next);
        assertEquals(ListNode.toListNode(1, 3), list);
    }



    /*
    REMOVE THE KTH LAST ELEMENT FROM A LIST
     */
    @Test
    void testRemoveTheKthLastElementFromAList() {
        assertEquals(null, removeTheKthLastElementFromAList(ListNode.toListNode(1), 1));
        assertEquals(ListNode.toListNode(1), removeTheKthLastElementFromAList(ListNode.toListNode(1, 2), 1));
        assertEquals(ListNode.toListNode(2), removeTheKthLastElementFromAList(ListNode.toListNode(1, 2), 2));
    }



    /*
    REMOVE DUPLICATES FROM A SORTED LIST
     */
    @Test
    void testRemoveDuplicatesFormASortedList() {
        assertEquals(ListNode.toListNode(1), removeDuplicatesFormASortedList(ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(1), removeDuplicatesFormASortedList(ListNode.toListNode(1, 1)));
        assertEquals(ListNode.toListNode(1), removeDuplicatesFormASortedList(ListNode.toListNode(1, 1, 1)));

        assertEquals(ListNode.toListNode(1, 2), removeDuplicatesFormASortedList(ListNode.toListNode(1, 2)));
        assertEquals(ListNode.toListNode(1, 2), removeDuplicatesFormASortedList(ListNode.toListNode(1, 2, 2)));
    }

    @Test
    void testRemoveDuplicatesFormASortedList_M() {
        assertEquals(ListNode.toListNode(1, 1, 1), removeDuplicatesFormASortedList_M(ListNode.toListNode(1, 1, 1), 3));
        assertEquals(ListNode.toListNode(1), removeDuplicatesFormASortedList_M(ListNode.toListNode(1, 1, 1), 2));

        assertEquals(ListNode.toListNode(1, 1, 1, 2), removeDuplicatesFormASortedList_M(ListNode.toListNode(1, 1, 1, 2, 2, 2, 2), 3));
    }



    /*
    IMPLEMENT CYCLIC RIGHT SHIFT FOR SINGLE LINKED LISTS
     */
    @Test
    void testCycleRightShift() {
        assertEquals(ListNode.toListNode(1), cycleRightShift(ListNode.toListNode(1), 0));
        assertEquals(ListNode.toListNode(1, 2), cycleRightShift(ListNode.toListNode(1, 2), 0));
        assertEquals(ListNode.toListNode(1, 2, 3), cycleRightShift(ListNode.toListNode(1, 2, 3), 0));

        assertEquals(ListNode.toListNode(1), cycleRightShift(ListNode.toListNode(1), 1));
        assertEquals(ListNode.toListNode(2, 1), cycleRightShift(ListNode.toListNode(1, 2), 1));
        assertEquals(ListNode.toListNode(3, 1, 2), cycleRightShift(ListNode.toListNode(1, 2, 3), 1));

        assertEquals(ListNode.toListNode(1), cycleRightShift(ListNode.toListNode(1), 2));
        assertEquals(ListNode.toListNode(1, 2), cycleRightShift(ListNode.toListNode(1, 2), 2));
        assertEquals(ListNode.toListNode(2, 3, 1), cycleRightShift(ListNode.toListNode(1, 2, 3), 2));

        assertEquals(ListNode.toListNode(1), cycleRightShift(ListNode.toListNode(1), 3));
        assertEquals(ListNode.toListNode(2, 1), cycleRightShift(ListNode.toListNode(1, 2), 3));
        assertEquals(ListNode.toListNode(1, 2, 3), cycleRightShift(ListNode.toListNode(1, 2, 3), 3));

        assertEquals(ListNode.toListNode(1), cycleRightShift(ListNode.toListNode(1), 4));
        assertEquals(ListNode.toListNode(1, 2), cycleRightShift(ListNode.toListNode(1, 2), 4));
        assertEquals(ListNode.toListNode(3, 1, 2), cycleRightShift(ListNode.toListNode(1, 2, 3), 4));
    }



    /*
    IMPLEMENT EVEN-ODD MERGE
     */
    @Test
    void testEvenOddMerge() {
        assertEquals(ListNode.toListNode(1), evenOddMerge(ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(1, 2), evenOddMerge(ListNode.toListNode(1, 2)));
        assertEquals(ListNode.toListNode(1), evenOddMerge(ListNode.toListNode(1)));
    }



    /*
    TEST WHETHER A SINGLE LINKED LIST IS PALINDROMIC
     */
    @Test
    void testTestWhetherASingleLinkedListIsPalindromic() {
        assertTrue(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 1)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 1, 1)));

        assertFalse(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 2)));
        assertFalse(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 2, 2)));

        assertTrue(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 2, 1)));

        assertFalse(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(1, 1, 2, 2)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic(ListNode.toListNode(2, 1, 1, 2)));
    }

    @Test
    void testTestWhetherASingleLinkedListIsPalindromic_Double() {
        assertTrue(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 1)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 1, 1)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 1)));
        assertTrue(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 2, 1)));

        assertFalse(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2)));
        assertFalse(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 2)));
        assertFalse(testWhetherASingleLinkedListIsPalindromic_Double(DoubleListNode.toListNode(1, 2, 3)));
    }



    /*
    IMPLEMENT LIST PIVOTING
     */
    @Test
    void testListPivoting() {
        assertEquals(ListNode.toListNode(1), listPivoting(ListNode.toListNode(1), -1));
        assertEquals(ListNode.toListNode(1), listPivoting(ListNode.toListNode(1), 1));
        assertEquals(ListNode.toListNode(1), listPivoting(ListNode.toListNode(1), 10));

        assertEquals(ListNode.toListNode(1, 2), listPivoting(ListNode.toListNode(1, 2), -1));
        assertEquals(ListNode.toListNode(1, 2), listPivoting(ListNode.toListNode(1, 2), 1));
        assertEquals(ListNode.toListNode(1, 2), listPivoting(ListNode.toListNode(1, 2), 2));

        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), -1));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 1));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 3));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 5));
        assertEquals(ListNode.toListNode(1, 2, 3, 3, 4, 5), listPivoting(ListNode.toListNode(1, 2, 3, 3, 4, 5), 10));

        assertEquals(ListNode.toListNode(1, 2, 4, 5), listPivoting(ListNode.toListNode(1, 2, 4, 5), 3));

        assertEquals(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), listPivoting(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), -1));
        assertEquals(ListNode.toListNode(1, 3, 0, 5, 9, 100, 100, 120), listPivoting(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), 5));
        assertEquals(ListNode.toListNode(5, 1, 9, 3, 0, 100, 100, 120), listPivoting(ListNode.toListNode(5, 1, 9, 3, 100, 100, 120, 0), 100));
    }



    /*
    ADD LIST-BASED INTEGERS
     */
    @Test
    void testAddListBasedIntegers() {
        assertEquals(ListNode.toListNode(0), addListBasedIntegers(ListNode.toListNode(-1), ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(9, 7, 3, 0, 1), addListBasedIntegers(ListNode.toListNode(0, 8, 3), ListNode.toListNode(9, 9, 9, 9)));
    }

    @Test
    void testAddListBasedIntegers_MostSignificantDigitComesFirst() {
        assertEquals(ListNode.toListNode(0), addListBasedIntegers(ListNode.toListNode(-1), ListNode.toListNode(1)));
        assertEquals(ListNode.toListNode(1, 0, 3, 7, 9), addListBasedIntegers_MostSignificantDigitComesFirst(ListNode.toListNode(3, 8, 0), ListNode.toListNode(9, 9, 9, 9)));
    }

}
