package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;

import pro.amberovsky.elements.util.data.BinaryTreeNode;
import pro.amberovsky.elements.util.data.JumpListNode;
import pro.amberovsky.elements.util.data.StackWithMax;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

import static pro.amberovsky.elements.StacksAndQueues.*;

class StacksAndQueuesTest {
    /*
    IMPLEMENT A STACK WITH MAX API
     */
    @Test
    void testStackMax() {
        assertEquals(1, new StackWithMax<Integer>().push(1).max().intValue());

        assertEquals(
                2,
                new StackWithMax<Integer>().push(1).push(2).max().intValue()
        );

        assertEquals(
                10,
                new StackWithMax<Integer>().push(1).push(10).push(5).max().intValue()
        );

        StackWithMax<Integer> stack;
        stack = new StackWithMax<>();
        stack.push(1).push(10).push(5).pop();
        assertEquals(10, stack.max().intValue());
        stack.pop();
        assertEquals(1, stack.max().intValue());
    }

    @Test
    void testStackPushAndPop() {
        assertEquals(10, new StackWithMax<Integer>().push(10).pop().intValue());
    }



    /*
    EVALUATE RPN EXPRESSIONS
     */
    @Test
    void testEvaluateRPNExpression() {
        assertEquals(1, evaluateRPNExpression("1"));
        assertEquals(1, evaluateRPNExpression("1,0,+"));
        assertEquals(15, evaluateRPNExpression("3,4,+,2,*,1,+"));
        assertEquals(-4, evaluateRPNExpression("1,1,+,-2,*"));
        assertEquals(-3, evaluateRPNExpression("-641,6,/,28,/"));
        assertEquals(-119, evaluateRPNExpression("1,2,3,4,5,*,*,*,-"));
    }

    @Test
    void testEvaluateRPNExpression_Polish() {
        assertEquals(1, evaluateRPNExpression_Polish("1"));
        assertEquals(1, evaluateRPNExpression_Polish("+,1,0"));
        assertEquals(15, evaluateRPNExpression_Polish("+,1,*,2,+,3,4"));
        assertEquals(-4, evaluateRPNExpression_Polish("*,-2,+,1,1"));
        assertEquals(-3, evaluateRPNExpression_Polish("/,28,/,6,-641"));
        assertEquals(-119, evaluateRPNExpression_Polish("-,*,*,*,5,4,3,2,1"));
    }



    /*
    TEST A STRING OVER FOR WELL-FORMEDNESS
     */
    @Test
    void testCheckParenthesesParity() {
        assertTrue(checkParenthesesParity(""));
        assertTrue(checkParenthesesParity("()"));
        assertTrue(checkParenthesesParity("({})"));
        assertTrue(checkParenthesesParity("({}[()]){}"));

        assertFalse(checkParenthesesParity("{"));
        assertFalse(checkParenthesesParity("{)"));
        assertFalse(checkParenthesesParity("[()[]{()()"));
    }



    /*
    NORMALIZE PATHNAMES
     */
    @Test
    void testNormalizePathname() {
        assertEquals("qwe", normalizePathname("qwe"));
        assertEquals("/usr/bin/gcc", normalizePathname("/usr/lib/../bin/gcc"));
        assertEquals("/", normalizePathname("/../"));
        assertEquals("/", normalizePathname("/../qwe/tre/../../../"));
        assertEquals("scripts/awkscripts", normalizePathname("scripts//./../scripts/awkscripts/././"));
    }



    /*
    SEARCH A POSTINGS LIST
     */
    private void runTestJumpFirstOrder(UnaryOperator<JumpListNode<Integer>> algorithm) {
        JumpListNode<Integer> list = new JumpListNode<>(10);
        list.next = new JumpListNode<>(99);
        list.next.next = new JumpListNode<>(199);
        list.jump = list.next.next;

        algorithm.apply(list);

        assertEquals(1, list.order);
        assertEquals(2, list.jump.order);
        assertEquals(3, list.next.order);
    }

    @Test
    void testJumpFirstOrder() {
        runTestJumpFirstOrder(StacksAndQueuesFactory.getSearchAPostingList(StacksAndQueuesFactory.SEARCH_A_POSTING_LIST.RECURSION));
        runTestJumpFirstOrder(StacksAndQueuesFactory.getSearchAPostingList(StacksAndQueuesFactory.SEARCH_A_POSTING_LIST.ITERATIVE));
    }



    /*
    COMPUTE BUILDINGS WITH A SUNSET VIEW
     */
    @Test
    void testComputeBuildingsWithASunsetView() {
        assertArrayEquals(new int[] { 1 }, computeBuildingsWithASunsetView(new int[] { 1 }));
        assertArrayEquals(new int[] { 1, 10 }, computeBuildingsWithASunsetView(new int[] { 1, 10 }));
        assertArrayEquals(new int[] { 10 }, computeBuildingsWithASunsetView(new int[] { 10, 1 }));
        assertArrayEquals(new int[] { 10, 100, 200 }, computeBuildingsWithASunsetView(new int[] { 10, 1, 100, 200, 150, 100 }));
    }

    @Test
    void testComputeBuildingsWithASunsetView_WestToEast() {
        assertArrayEquals(new Integer[] { 1 }, computeBuildingsWithASunsetView_WestToEast(new int[] { 1 }));
        assertArrayEquals(new Integer[] { 1, 10 }, computeBuildingsWithASunsetView_WestToEast(new int[] { 1, 10 }));
        assertArrayEquals(new Integer[] { 10 }, computeBuildingsWithASunsetView_WestToEast(new int[] { 10, 1 }));
        assertArrayEquals(new Integer[] { 10, 100, 200 }, computeBuildingsWithASunsetView_WestToEast(new int[] { 10, 1, 100, 200, 150, 100 }));
    }



    /*
    COMPUTE BINARY TREE NODES IN ORDER OF INCREASING DEPTH
     */
    @Test
    void testBreadthFirstSearch() {
        assertArrayEquals(new Integer[] { 1 }, computeBinaryTreeNodesInOrderOfIncreasingDepth(new BinaryTreeNode<>(1)));

        assertArrayEquals(
                new Integer[] { 50, 4, 88, 44, 123 },
                computeBinaryTreeNodesInOrderOfIncreasingDepth(
                    new BinaryTreeNode<>(
                            50,
                            new BinaryTreeNode<>(4, null, new BinaryTreeNode<>(44)),
                            new BinaryTreeNode<>(88, new BinaryTreeNode<>(123), null)
                    )
                )
        );
    }

    @Test
    void testComputeBinaryTreeNodesInOrderOfIncreasingDepth_AlternatingDirection() {
        assertArrayEquals(new Integer[] { 1 }, computeBinaryTreeNodesInOrderOfIncreasingDepth_AlternatingDirection(new BinaryTreeNode<>(1)));

        assertArrayEquals(
                new Integer[] { 50, 4, 88, 123, 44 },
                computeBinaryTreeNodesInOrderOfIncreasingDepth_AlternatingDirection(
                        new BinaryTreeNode<>(
                                50,
                                new BinaryTreeNode<>(4, null, new BinaryTreeNode<>(44)),
                                new BinaryTreeNode<>(88, new BinaryTreeNode<>(123), null)
                        )
                )
        );
    }

    @Test
    void testComputeBinaryTreeNodesInOrderOfIncreasingDepth_BottomUpLeftRight() {
        assertArrayEquals(new Integer[] { 1 }, computeBinaryTreeNodesInOrderOfIncreasingDepth_BottomUpLeftRight(new BinaryTreeNode<>(1)));

        assertArrayEquals(
                new Integer[] { 44, 123, 4, 88, 50 },
                computeBinaryTreeNodesInOrderOfIncreasingDepth_BottomUpLeftRight(
                        new BinaryTreeNode<>(
                                50,
                                new BinaryTreeNode<>(4, null, new BinaryTreeNode<>(44)),
                                new BinaryTreeNode<>(88, new BinaryTreeNode<>(123), null)
                        )
                )
        );
    }

    @Test
    void testComputeBinaryTreeNodesInOrderOfIncreasingDepth_Average() {
        assertArrayEquals(new Double[] { 1.0 }, computeBinaryTreeNodesInOrderOfIncreasingDepth_Average(new BinaryTreeNode<>(1)));

        assertArrayEquals(
                new Double[] { 50.0, 46.0, 83.5 },
                computeBinaryTreeNodesInOrderOfIncreasingDepth_Average(
                        new BinaryTreeNode<>(
                                50,
                                new BinaryTreeNode<>(4, null, new BinaryTreeNode<>(44)),
                                new BinaryTreeNode<>(88, new BinaryTreeNode<>(123), null)
                        )
                )
        );
    }
}
