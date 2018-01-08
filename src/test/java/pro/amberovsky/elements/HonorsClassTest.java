package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.amberovsky.elements.util.data.BinaryTreeNode;
import pro.amberovsky.elements.util.data.JumpListNode;
import pro.amberovsky.elements.util.data.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static pro.amberovsky.elements.HonorsClass.*;

class HonorsClassTest {
    /*
    FIND THE FIRST MISSING POSITIVE ENTRY
     */
    @Test
    void testFindTheFirstMissingPositiveEntry() {
        assertEquals(1, findTheFirstMissingPositiveEntry(new int[] { 3, 4, 0, 2 }));
        assertEquals(2, findTheFirstMissingPositiveEntry(new int[] { 3, 5, 4, -1, 5, 1, -1 }));
    }

    /*
    COMPUTE THE MAXIMUM PRODUCT OF ALL ENTRIES BUT ONE
    */
    private static Stream<Arguments> sourceForMaximumProductOfAllEntriesButOne() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2 }, 2),
                Arguments.of(new Integer[] { 1, -2, -3, -4, 10 }, 120),
                Arguments.of(new Integer[] { 0, 1 }, 1),
                Arguments.of(new Integer[] { -10, -25, -5 }, 250),
                Arguments.of(new Integer[] { -10, -25, -5, -4 }, -200),
                Arguments.of(new Integer[] { 100, 0, 2, 0 }, 0),
                Arguments.of(new Integer[] { 3, 2, 4, 5 }, 60),
                Arguments.of(new Integer[] { 3, 2, -1, 4 }, 24),
                Arguments.of(new Integer[] { 3, 2, -1, 4, -1, 6 }, 72)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForMaximumProductOfAllEntriesButOne")
    void testMaximumProductOfAllEntriesButOneBySuffixArray(Integer[] array, Integer expected) {
        assertEquals(expected, maximumProductOfAllEntriesButOneBySuffixArray(array));
    }

    @ParameterizedTest
    @MethodSource("sourceForMaximumProductOfAllEntriesButOne")
    void testMaximumProductOfAllEntriesButOneByCountingZeroAndNegatives(Integer[] array, Integer expected) {
        assertEquals(expected, maximumProductOfAllEntriesButOneByCountingZeroAndNegatives(array));
    }

    @Test
    void testMaximumProductOfAllEntriesButOne_ExceptI() {
        assertArrayEquals(new Integer[] { 2, 1 }, maximumProductOfAllEntriesButOne_ExceptI(new Integer[] { 1, 2 }));
        assertArrayEquals(new Integer[] { -200, 20, -50, 40 }, maximumProductOfAllEntriesButOne_ExceptI(new Integer[] { -1, 10, -4, 5 }));
    }



    /*
    ROTATE AN ARRAY
     */
    @Test
    void testRotateAnArray() {
        assertArrayEquals(new Integer[] { 1 }, rotateAnArray(new Integer[] { 1 }, 0));
        assertArrayEquals(new Integer[] { 1 }, rotateAnArray(new Integer[] { 1 }, 1));
        assertArrayEquals(new Integer[] { 1 }, rotateAnArray(new Integer[] { 1 }, 2));


        assertArrayEquals(new Integer[] { 2, 1 }, rotateAnArray(new Integer[] { 1, 2 }, 1));

        assertArrayEquals(new Integer[] { 3, 4, 5, 1, 2 }, rotateAnArray(new Integer[] { 1, 2, 3, 4, 5 }, 3));
    }



    /*
    IDENTIFY POSITIONS ATTACKED BY ROOKS
     */
    @Test
    void testIdentifyPositionsAttackedByRooks() {
        assertArrayEquals(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
            }, identifyPositionsAttackedByRooks(new int[][] {
                { 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }
            }));
    }



    /*
    JUSTIFY TEXT
     */
    @Test
    void testJustifyText() {
        assertEquals(
                java.util.Arrays.asList(
                        "The   quick", "brown   fox", "jumped over", "the    lazy", "dogs.      "
                ),
                justifyText(
                        new String[] { "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs." },
                        11
                )
        );
    }



    /*
    IMPLEMENT LIST ZIPPING
     */
    @Test
    void testListZipping() {
        assertEquals(
                ListNode.toListNode(1), listZipping(ListNode.toListNode(1))
        );

        assertEquals(
                ListNode.toListNode(1, 2), listZipping(ListNode.toListNode(1, 2))
        );

        assertEquals(
                ListNode.toListNode(1, 2, 3), listZipping(ListNode.toListNode(1, 3, 2))
        );

        assertEquals(
                ListNode.toListNode(1, 2, 3, 4), listZipping(ListNode.toListNode(1, 3, 4, 2))
        );
    }



    /*
    COPY A POSTINGS LIST
     */
    @Test
    void testCopyAPostingList() {
        JumpListNode<Integer> list = new JumpListNode<>(1);
        list.next = new JumpListNode<>(2);
        list.next.next = new JumpListNode<>(3);
        list.next.jump = list.next.next;
        list.next.next.jump = list;

        JumpListNode<Integer> copy = copyAPostingList(list);

        assertEquals(copy.data, list.data);
        assertEquals(copy.next.data, list.next.data);
        assertEquals(copy.next.next.data, list.next.next.data);
        assertEquals(copy.next.jump.data, list.next.jump.data);
        assertEquals(copy.next.next.jump.data, list.next.next.jump.data);
    }



    /*
    COMPUTE THE LONGEST SUBSTRING WITH MATCHING PARENS
     */
    @Test
    void testComputeTheLongestSubstringWithMatchingParens() {
        assertEquals(2, computeTheLongestSubstringWithMatchingParens("()"));
        assertEquals(6, computeTheLongestSubstringWithMatchingParens("((())()(()("));
    }



    /*
    COMPUTE THE MAXIMUM OF A SLIDING WINDOW
     */
    @Test
    void testComputeTheMaximumOfASlidingWindow() {
        assertEquals(
                java.util.Arrays.asList(
                        new TrafficElement(0, 13),
                        new TrafficElement(2, 25),
                        new TrafficElement(3, 37),
                        new TrafficElement(5, 37),
                        new TrafficElement(6, 37),
                        new TrafficElement(8, 26),
                        new TrafficElement(9, 26),
                        new TrafficElement(14, 17)
                ),
                computeTheMaximumOfASlidingWindow(new TrafficElement[] {
                        new TrafficElement(0, 13),
                        new TrafficElement(2, 25),
                        new TrafficElement(3, 37),
                        new TrafficElement(5, 14),
                        new TrafficElement(6, 26),
                        new TrafficElement(8, 22),
                        new TrafficElement(9, 17),
                        new TrafficElement(14, 17)
                }, 3)
        );
    }



    /*
    IMPLEMENT A POSTORDER TRAVERSAL WITHOUT RECURSION
     */
    @Test
    void testImplementAPostorderTraversalWithoutRecursion() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(1);
        assertEquals(java.util.Arrays.asList(1), implementAPostorderTraversalWithoutRecursion(tree));

        tree.left = new BinaryTreeNode<>(2);
        assertEquals(java.util.Arrays.asList(2, 1), implementAPostorderTraversalWithoutRecursion(tree));

        tree.right = new BinaryTreeNode<>(3);
        assertEquals(java.util.Arrays.asList(2, 3, 1), implementAPostorderTraversalWithoutRecursion(tree));

        tree.left.right = new BinaryTreeNode<>(4);
        assertEquals(java.util.Arrays.asList(4, 2, 3, 1), implementAPostorderTraversalWithoutRecursion(tree));

        tree.right.left = new BinaryTreeNode<>(5);
        assertEquals(java.util.Arrays.asList(4, 2, 5, 3, 1), implementAPostorderTraversalWithoutRecursion(tree));

        tree.left.right.right = new BinaryTreeNode<>(6);
        assertEquals(java.util.Arrays.asList(6, 4, 2, 5, 3, 1), implementAPostorderTraversalWithoutRecursion(tree));
    }
}
