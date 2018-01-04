package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.amberovsky.elements.util.data.BinaryTreeNode;
import pro.amberovsky.elements.util.data.BinaryTreeWithCounts;
import pro.amberovsky.elements.util.data.BinaryTreeWithParentNode;

import java.util.stream.Stream;

import static pro.amberovsky.elements.BinaryTrees.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreesTest {
    /*
    TEST IF A BINARY TREE IS HEIGHT-BALANCED
     */
    @Test
    void testTestIfABinaryTreeIsHeightBalanced() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(1);
        assertTrue(testIfABinaryTreeIsHeightBalanced(tree));

        tree.left = new BinaryTreeNode<>(2);
        assertTrue(testIfABinaryTreeIsHeightBalanced(tree));

        tree.left.left = new BinaryTreeNode<>(3);
        assertFalse(testIfABinaryTreeIsHeightBalanced(tree));

        tree.right = new BinaryTreeNode<>(4);
        assertTrue(testIfABinaryTreeIsHeightBalanced(tree));
    }



    /*
    TEST IF A BINARY TREE IS SYMMETRIC
    */
    @Test
    void testIsSymmetric() {
        assertTrue(isSymmetric(null));
        assertTrue(isSymmetric(new BinaryTreeNode<>(100)));
        assertTrue(isSymmetric(new BinaryTreeNode<>(100, new BinaryTreeNode<>(200), new BinaryTreeNode<>(200))));

        assertFalse(isSymmetric(new BinaryTreeNode<>(100, new BinaryTreeNode<>(200), null)));
        assertFalse(isSymmetric(new BinaryTreeNode<>(100, new BinaryTreeNode<>(200), new BinaryTreeNode<>(201))));
    }


    /*
    COMPUTE THE LOWEST COMMON ANCESTOR IN A BINARY TREE
     */
    @Test
    void testComputeTheLowestCommonAncestor() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(100, new BinaryTreeNode<>(200), new BinaryTreeNode<>(300));

        assertEquals(root, computeTheLowestCommonAncestor(root, root.left, root.right));
        assertEquals(root.left, computeTheLowestCommonAncestor(root, root.left, root.left));
    }


    /*
    COMPUTE THE LCA WHEN NODES HAVE PARENT POINTERS
     */
    @Test
    void testLCAWithParents() {
        BinaryTreeWithParentNode<Integer> root = new BinaryTreeWithParentNode<>(100);

        BinaryTreeWithParentNode<Integer> left = new BinaryTreeWithParentNode<>(200, root, null, null);
        BinaryTreeWithParentNode<Integer> right = new BinaryTreeWithParentNode<>(300, root, null, null);

        root.left = left;
        root.right = right;

        assertEquals(root, LCAWithParents(root, root.left, root.right));
    }


    /*
    SUM THE ROOT-TO-LEAF PATHS IN A BINARY TREE
     */
    @Test
    void testSumTheRootToLeafPathsInBinaryTree() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(
                1,
                new BinaryTreeNode<>(
                        0,
                        new BinaryTreeNode<>(
                                0, new BinaryTreeNode<>(0), new BinaryTreeNode<>(1)
                        ),
                        new BinaryTreeNode<>(
                                1,
                                null,
                                new BinaryTreeNode<>(1, new BinaryTreeNode<>(0), null)
                        )
                ),
                new BinaryTreeNode<>(
                        1,
                        new BinaryTreeNode<>(
                                0,
                                null,
                                new BinaryTreeNode<>(
                                        0,
                                        new BinaryTreeNode<>(1, null, new BinaryTreeNode<>(1)),
                                        new BinaryTreeNode<>(0)
                                )
                        ),
                        new BinaryTreeNode<>(0, null, new BinaryTreeNode<>(0))
                )
        );

        assertEquals(126, sumTheRootToLeafPathsInBinaryTree(tree));
    }


    /*
    FIND A ROOT TO LEAF PATH WITH SPECIFIED SUM
     */
    @Test
    void testFindARootToLeafPathWithSpecifiedSum() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(
                10,
                new BinaryTreeNode<>(
                        15,
                        new BinaryTreeNode<>(30, new BinaryTreeNode<>(40), null),
                        null
                ),
                null
        );

        assertFalse(findARootToLeafPathWithSpecifiedSum(tree, 10));
        assertTrue(findARootToLeafPathWithSpecifiedSum(tree, 95));
    }

    @Test
    void testFindARootToLeafPathWithSpecifiedSum_AllPaths() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(
                10,
                new BinaryTreeNode<>(
                        15,
                        new BinaryTreeNode<>(30, new BinaryTreeNode<>(40), null),
                        null
                ),
                null
        );

        assertEquals(
                java.util.Arrays.asList(java.util.Arrays.asList(10, 15, 30, 40)),
                findARootToLeafPathWithSpecifiedSum_AllPaths(tree, 95)
        );
    }


    /*
    IMPLEMENT AN INORDER TRAVERSAL WITHOUT RECURSION
     */
    @Test
    void testInorderTraversalWithoutRecursion() {
        assertEquals(java.util.Arrays.asList(1, 2, 3), inorderTraversalWithoutRecursion(
                new BinaryTreeNode<>(2, new BinaryTreeNode<>(1), new BinaryTreeNode<>(3))
        ));
    }


    /*
    IMPLEMENT A PREORDER TRAVERSAL WITHOUT RECURSION
     */
    @Test
    void testPreorderTraversalWithoutRecursion() {
        assertEquals(java.util.Arrays.asList(2, 1, 3), preorderTraversalWithoutRecursion(
                new BinaryTreeNode<>(2, new BinaryTreeNode<>(1), new BinaryTreeNode<>(3))
        ));
    }


    /*
    COMPUTE THE kth NODE IN AN INORDER TRAVERSAL
     */
    @Test
    void testComputeTheKthNodeInAnInorderTraversal() {
        assertEquals(10, computeTheKthNodeInAnInorderTraversal(new BinaryTreeWithCounts<>(10, 0, null, null), 1).intValue());

        BinaryTreeWithCounts<Integer> tree = new BinaryTreeWithCounts<>(99, 2, new BinaryTreeWithCounts<>(-100), new BinaryTreeWithCounts<>(100));
        assertEquals(-100, computeTheKthNodeInAnInorderTraversal(tree, 1).intValue());
        assertEquals(99, computeTheKthNodeInAnInorderTraversal(tree, 2).intValue());
        assertEquals(100, computeTheKthNodeInAnInorderTraversal(tree, 3).intValue());
    }


    /*
    COMPUTE THE SUCCESSOR
     */
    @Test
    void testComputeTheSuccessor() {
        BinaryTreeWithParentNode<Integer> root = new BinaryTreeWithParentNode<>(100);

        BinaryTreeWithParentNode<Integer> left = new BinaryTreeWithParentNode<>(200, root, null, null);
        BinaryTreeWithParentNode<Integer> right = new BinaryTreeWithParentNode<>(300, root, null, null);

        root.left = left;
        root.right = right;

        left.right = new BinaryTreeWithParentNode<>(5, left, null, null);

        assertEquals(5, computeTheSuccessor(left).intValue());
        assertEquals(100, computeTheSuccessor(left.right).intValue());
        assertEquals(300, computeTheSuccessor(root).intValue());
        assertNull(computeTheSuccessor(root.right));
    }


    /*
    IMPLEMENT AN INORDER TRAVERSAL WITH O(1) SPACE
     */
    @Test
    void testImplementAnInorderTraversalWithConstantSpace() {
        BinaryTreeWithParentNode<Integer> root = new BinaryTreeWithParentNode<>(1);
        assertEquals(java.util.Arrays.asList(1), implementAnInorderTraversalWithConstantSpace(root));

        root.left = new BinaryTreeWithParentNode<>(2, root, null, null);
        assertEquals(java.util.Arrays.asList(2, 1), implementAnInorderTraversalWithConstantSpace(root));

        root.right = new BinaryTreeWithParentNode<>(3, root, null, null);
        assertEquals(java.util.Arrays.asList(2, 1, 3), implementAnInorderTraversalWithConstantSpace(root));

        root.left.right = new BinaryTreeWithParentNode<>(4, root.left, null, null);
        assertEquals(java.util.Arrays.asList(2, 4, 1, 3), implementAnInorderTraversalWithConstantSpace(root));
    }

    @Test
    void testImplementAnInorderTraversalWithConstantSpace_Preorder() {
        BinaryTreeWithParentNode<Integer> root = new BinaryTreeWithParentNode<>(1);
        assertEquals(java.util.Arrays.asList(1), implementAnInorderTraversalWithConstantSpace_Preorder(root));

        root.left = new BinaryTreeWithParentNode<>(2, root, null, null);
        assertEquals(java.util.Arrays.asList(1, 2), implementAnInorderTraversalWithConstantSpace_Preorder(root));

        root.right = new BinaryTreeWithParentNode<>(3, root, null, null);
        assertEquals(java.util.Arrays.asList(1, 2, 3), implementAnInorderTraversalWithConstantSpace_Preorder(root));

        root.left.right = new BinaryTreeWithParentNode<>(4, root.left, null, null);
        assertEquals(java.util.Arrays.asList(1, 2, 4, 3), implementAnInorderTraversalWithConstantSpace_Preorder(root));
    }

    @Test
    void testImplementAnInorderTraversalWithConstantSpace_Postorder() {
        BinaryTreeWithParentNode<Integer> root = new BinaryTreeWithParentNode<>(1);
        assertEquals(java.util.Arrays.asList(1), implementAnInorderTraversalWithConstantSpace_Postorder(root));

        root.left = new BinaryTreeWithParentNode<>(2, root, null, null);
        assertEquals(java.util.Arrays.asList(2, 1), implementAnInorderTraversalWithConstantSpace_Postorder(root));

        root.right = new BinaryTreeWithParentNode<>(3, root, null, null);
        assertEquals(java.util.Arrays.asList(2, 3, 1), implementAnInorderTraversalWithConstantSpace_Postorder(root));

        root.left.right = new BinaryTreeWithParentNode<>(4, root.left, null, null);
        assertEquals(java.util.Arrays.asList(4, 2, 3, 1), implementAnInorderTraversalWithConstantSpace_Postorder(root));
    }



    /*
    RECONSTRUCT A BINARY TREE FROM TRAVERSAL DATA
     */
    private static Stream<BinaryTreeNode<Integer>> sourceForReconstructABinaryTreeFromTraversalData() {
        BinaryTreeNode<Integer> tree1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> tree2 = new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), null);
        BinaryTreeNode<Integer> tree3 = new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), new BinaryTreeNode<>(3));
        BinaryTreeNode<Integer> tree4 = new BinaryTreeNode<>(1, new BinaryTreeNode<>(2, null, new BinaryTreeNode<>(4)), new BinaryTreeNode<>(3));

        return Stream.of(tree1, tree2, tree3, tree4);
    }

    @ParameterizedTest
    @MethodSource("sourceForReconstructABinaryTreeFromTraversalData")
    void testReconstructABinaryTreeFromTraversalData(BinaryTreeNode<Integer> tree) {
        assertEquals(tree, reconstructABinaryTreeFromTraversalData(tree.inorder(), tree.preorder()));
    }

    @ParameterizedTest
    @MethodSource("sourceForReconstructABinaryTreeFromTraversalData")
    void testReconstructABinaryTreeFromTraversalData_Postorder(BinaryTreeNode<Integer> tree) {
        assertEquals(tree, reconstructABinaryTreeFromTraversalData_Postorder(tree.inorder(), tree.postorder()));
    }

    @Test
    void testReconstructABinaryTreeFromTraversalData_MaxTree() {
        assertEquals(new BinaryTreeNode<>(1), reconstructABinaryTreeFromTraversalData_MaxTree(new int[] { 1 }));
    }



    /*
    RECONSTRUCT A BINARY TREE FROM A PREORDER TRAVERSAL WITH MARKERS
     */
    @ParameterizedTest
    @MethodSource("sourceForReconstructABinaryTreeFromTraversalData")
    void testReconstructABinaryTreeFromAPreorderTraversalWithMarkers(BinaryTreeNode<Integer> tree) {
        assertEquals(tree, reconstructABinaryTreeFromAPreorderTraversalWithMarkers(tree.preorderWithMarkers().toArray()));
    }

    @ParameterizedTest
    @MethodSource("sourceForReconstructABinaryTreeFromTraversalData")
    void testReconstructABinaryTreeFromAPreorderTraversalWithMarkers_Postorder(BinaryTreeNode<Integer> tree) {
        assertEquals(tree, reconstructABinaryTreeFromAPreorderTraversalWithMarkers_Postorder(tree.postorderWithMarkers().toArray()));
    }



    /*
    FORM A LINKED LIST FROM THE LEAVES OF A BINARY TREE
     */
    @Test
    void testFormALinkedListFromTheLeavesOfABinaryTree() {
        assertEquals(java.util.Arrays.asList(1), formALinkedListFromTheLeavesOfABinaryTree(new BinaryTreeNode<>(1)));
        assertEquals(java.util.Arrays.asList(2), formALinkedListFromTheLeavesOfABinaryTree(new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), null)));

        assertEquals(
                java.util.Arrays.asList(10, 15),
                formALinkedListFromTheLeavesOfABinaryTree(
                        new BinaryTreeNode<>(1,
                                new BinaryTreeNode<>(2, null, new BinaryTreeNode<>(10)),
                                new BinaryTreeNode<>(15)
                        )
                )
        );
    }



    /*
    COMPUTE THE EXTERIOR OF A BINARY TREE
     */
    @Test
    void testExterior() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        assertEquals(java.util.Arrays.asList(1), exterior(root));

        root.left = new BinaryTreeNode<>(2);
        assertEquals(java.util.Arrays.asList(1, 2), exterior(root));

        root.right = new BinaryTreeNode<>(3);
        assertEquals(java.util.Arrays.asList(1, 2, 3), exterior(root));

        root.left.right = new BinaryTreeNode<>(4);
        assertEquals(java.util.Arrays.asList(1, 2, 4, 3), exterior(root));

        root.left.right.left = new BinaryTreeNode<>(5);
        assertEquals(java.util.Arrays.asList(1, 2, 4, 5, 3), exterior(root));

        root.left.right.right = new BinaryTreeNode<>(6);
        assertEquals(java.util.Arrays.asList(1, 2, 4, 5, 6, 3), exterior(root));

        root.right.left = new BinaryTreeNode<>(7);
        assertEquals(java.util.Arrays.asList(1, 2, 4, 5, 6, 7, 3), exterior(root));
    }



    /*
    COMPUTE THE RIGHT SIBLING TREE
     */
    @Test
    void testComputeTheRightSiblingTree() {
        BinaryTreeWithParentNode<Integer> tree = new BinaryTreeWithParentNode<>(1);
        tree.left = new BinaryTreeWithParentNode<>(2);
        tree.right = new BinaryTreeWithParentNode<>(3);

        computeTheRightSiblingTree(tree);

        assertNull(tree.parent);
        assertEquals(tree.left.parent, tree.right);
        assertNull(tree.right.parent);
    }

    @Test
    void testComputeTheRightSiblingTree_GeneralTree() {
        BinaryTreeWithParentNode<Character> tree = new BinaryTreeWithParentNode<>(
                'A', null,
                new BinaryTreeWithParentNode<>('B', null, new BinaryTreeWithParentNode<>('C'), null),
                new BinaryTreeWithParentNode<>('D', null,
                        new BinaryTreeWithParentNode<>('E', null, new BinaryTreeWithParentNode<>('F'), null),
                        new BinaryTreeWithParentNode<>('G', null, new BinaryTreeWithParentNode<>('H'), new BinaryTreeWithParentNode<>('I'))
                                                )
        );

        computeTheRightSiblingTree_GeneralTree(tree);

        // first level
        assertNull(tree.parent);
        // second level
        assertEquals(tree.left.parent.data, tree.right.data);
        assertNull(tree.right.parent);
        // third level
        assertEquals(tree.left.left.parent.data, tree.right.left.data);
        assertEquals(tree.right.left.parent.data, tree.right.right.data);
        assertNull(tree.right.right.parent);
        // forth level
        assertEquals(tree.right.left.left.parent.data, tree.right.right.left.data);
        assertEquals(tree.right.right.left.parent.data, tree.right.right.right.data);
        assertNull(tree.right.right.right.parent);
    }
}