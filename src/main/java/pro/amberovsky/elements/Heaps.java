package pro.amberovsky.elements;

import pro.amberovsky.elements.util.data.BinaryTreeNode;
import pro.amberovsky.elements.util.data.BinaryTreeWithCounts;
import pro.amberovsky.elements.util.data.BinaryTreeWithParentNode;

import java.util.*;

/**
 * Various tasks on binary trees
 */
public class BinaryTrees {
    /*
    TEST IF A BINARY TREE IS HEIGHT-BALANCED
     */

    /**
     * Helper class for the height-balanced problem
     */
    private static class BalanceStatusWithHeight {
        /** is subtree balanced */
        boolean isBalanced;

        /** height of the subtree */
        int height;

        /**
         * Constr
         *
         * @param isBalanced is subtree balanced
         * @param height height of the subtree
         */
        BalanceStatusWithHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * Helper
     *
     * @param node current node
     * @param height current explored height
     * @param <T> type
     *
     * @return helper class with the status and height
     */
    static <T> BalanceStatusWithHeight testIfABinaryTreeIsHeightBalancedHelper(BinaryTreeNode<T> node, int height) {
        if (node == null) return new BalanceStatusWithHeight(true, height);

        BalanceStatusWithHeight left = testIfABinaryTreeIsHeightBalancedHelper(node.left, height + 1);
        if (!left.isBalanced) return left;

        BalanceStatusWithHeight right = testIfABinaryTreeIsHeightBalancedHelper(node.right, height + 1);
        if (!right.isBalanced) return right;

        return new BalanceStatusWithHeight(Math.abs(left.height - right.height) <= 1, Math.max(left.height, right.height));
    }

    /**
     * Test if a binary tree is height-balanced
     *
     * @Algorithm Recursion
     * @Complexity O(n), O(h) space
     *
     * @param tree binary tree
     * @param <T> type
     *
     * @return true if it is height-balanced, false otherwise
     */
    static <T> boolean testIfABinaryTreeIsHeightBalanced(BinaryTreeNode<T> tree) {
        BalanceStatusWithHeight balanceStatusWithHeight = testIfABinaryTreeIsHeightBalancedHelper(tree, 0);

        return balanceStatusWithHeight.isBalanced;
    }



    /*
    TEST IF A BINARY TREE IS SYMMETRIC
     */

    /**
     * Helper
     *
     * @param tree1 first tree
     * @param tree2 second tree
     * @param <T>   type
     *
     * @return true if symmetric, false otherwise
     */
    private static <T> boolean isSymmetricHelper(BinaryTreeNode<T> tree1, BinaryTreeNode<T> tree2) {
        if ((tree1 == null) && (tree2 == null)) return true;

        if ((tree1 != null) && (tree2 != null)) {
            return (tree1.data.equals(tree2.data)) &&
                    isSymmetricHelper(tree1.left, tree2.left) &&
                    isSymmetricHelper(tree1.right, tree2.right);
        }

        return false;
    }

    /**
     * Check if binary tree is symmetric
     *
     * @Algorithm recursion
     * @Complexity O(n), O(h) space
     *
     * @param tree binary tree
     * @param <T>  type
     *
     * @return true if symmetric, false otherwise
     */
    static <T> boolean isSymmetric(BinaryTreeNode<T> tree) {
        return (tree == null) || isSymmetricHelper(tree.left, tree.right);
    }



    /*
    COMPUTE THE LOWEST COMMON ANCESTOR IN A BINARY TREE
     */

    /**
     * Helper class for the LCA problem
     *
     * @param <T>
     */
    private static class LCAStatus<T> {
        /**
         * Found LCA
         */
        BinaryTreeNode<T> lca;

        /**
         * How many matching nodes
         */
        int nodes;

        /**
         * Constr
         *
         * @param lca   LCA
         * @param nodes how many matching nodes
         */
        public LCAStatus(BinaryTreeNode<T> lca, int nodes) {
            this.lca = lca;
            this.nodes = nodes;
        }
    }

    /**
     * Helper for the LCA problem
     *
     * @param root  root node
     * @param node1 first node
     * @param node2 second node
     * @param <T>   type
     *
     * @return status for the current root
     */
    private static <T> LCAStatus<T> LCAHelper(BinaryTreeNode<T> root, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        if (root == null) return new LCAStatus<>(null, 0);

        LCAStatus<T> left = LCAHelper(root.left, node1, node2);
        if (left.nodes == 2) return left;

        LCAStatus<T> right = LCAHelper(root.right, node1, node2);
        if (right.nodes == 2) return right;

        int nodes = left.nodes + right.nodes +
                ((root == node1) ? 1 : 0) +
                ((root == node2) ? 1 : 0);

        return new LCAStatus<>(nodes == 2 ? root : null, nodes);
    }

    /**
     * Compute the lowest common ancestor
     *
     * @Algorithm recursion
     * @Complexity O(n), O(h) space
     *
     * @param root  root
     * @param node1 first node
     * @param node2 second node
     * @param <T>   type
     *
     * @return LCA, if present, null otherwise
     */
    static <T> BinaryTreeNode<T> computeTheLowestCommonAncestor(
            BinaryTreeNode<T> root, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2
    ) {
        return LCAHelper(root, node1, node2).lca;
    }



    /*
    COMPUTE THE LCA WHEN NODES HAVE PARENT POINTERS
     */

    /**
     * Compute the LCA when nodes have parent pointers
     *
     * @Algorithm Alight the height
     * @Complexity O(n), O(1) space
     *
     * @param root  root node
     * @param node1 first node
     * @param node2 second node
     * @param <T>   type
     *
     * @return LCA, if present, null otherwise
     */
    static <T> BinaryTreeWithParentNode<T> LCAWithParents(
            BinaryTreeWithParentNode<T> root, BinaryTreeWithParentNode<T> node1, BinaryTreeWithParentNode<T> node2
    ) {
        int height1 = 0;
        BinaryTreeWithParentNode<T> pointer = node1;
        while (pointer != root) {
            height1++;
            pointer = pointer.parent;
        }

        int height2 = 0;
        pointer = node2;
        while (pointer != root) {
            height2++;
            pointer = pointer.parent;
        }

        while (height1 > height2) {
            height1--;
            node1 = node1.parent;
        }

        while (height2 > height1) {
            height2--;
            node2 = node2.parent;
        }

        while (node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;
    }



    /*
    SUM THE ROOT-TO-LEAF PATHS IN A BINARY TREE
     */

    /**
     * Helper
     *
     * @param node current node
     * @param sum  sum of numbers
     *
     * @return updated sum of numbers
     */
    private static int sumTheRootToLeafPathsInBinaryTreeHelper(BinaryTreeNode<Integer> node, int sum) {
        if (node == null) return 0;

        sum = sum * 2 + node.data;

        if ((node.left == null) && (node.right == null)) return sum;

        return sumTheRootToLeafPathsInBinaryTreeHelper(node.left, sum) +
                sumTheRootToLeafPathsInBinaryTreeHelper(node.right, sum);
    }

    /**
     * Calculate sum the root to leaf paths in a binary tree
     *
     * @Algorithm Recursion
     * @Complexity O(n), O(h) space
     *
     * @param tree binary tree
     *
     * @return the sum
     */
    static int sumTheRootToLeafPathsInBinaryTree(BinaryTreeNode<Integer> tree) {
        return sumTheRootToLeafPathsInBinaryTreeHelper(tree, 0);
    }



    /*
    FIND A ROOT TO LEAF PATH WITH SPECIFIED SUM
     */

    /**
     * Helper
     *
     * @param node       current node
     * @param currentSum current sum
     * @param sum        target sum
     *
     * @return true if such path has been found, false otherwise
     */
    private static boolean findARootToLeafPathWithSpecifiedSumHelper(BinaryTreeNode<Integer> node, int currentSum, int sum) {
        if (node == null) return false;

        currentSum += node.data;
        if ((node.left == null) && (node.right == null)) return (currentSum == sum);


        return
                findARootToLeafPathWithSpecifiedSumHelper(node.left, currentSum, sum) ||
                        findARootToLeafPathWithSpecifiedSumHelper(node.right, currentSum, sum);
    }

    /**
     * Find a root to leaf path with specified sum
     *
     * @Algorithm Recursion
     * @Complexity O(n), O(h) space
     *
     * @param tree binary tree
     * @param sum  target sum
     *
     * @return true if such path has been found, false otherwise
     */
    static boolean findARootToLeafPathWithSpecifiedSum(BinaryTreeNode<Integer> tree, int sum) {
        return findARootToLeafPathWithSpecifiedSumHelper(tree, 0, sum);
    }

    /**
     * Helper
     *
     * @param node       current node
     * @param paths      list of discovered paths
     * @param path       current path
     * @param currentSum current sum
     * @param sum        target sum
     *
     * @return list of discovered paths
     */
    private static List<List<Integer>> findARootToLeafPathWithSpecifiedSum_AllPathsHelper(
            BinaryTreeNode<Integer> node, List<List<Integer>> paths, LinkedList<Integer> path, int currentSum, int sum
    ) {
        if (node == null) return paths;

        currentSum += node.data;
        path.addLast(node.data);

        if ((node.left == null) && (node.right == null)) {
            if (currentSum == sum) paths.add(new LinkedList<>(path));
        }

        findARootToLeafPathWithSpecifiedSum_AllPathsHelper(node.left, paths, path, currentSum, sum);
        findARootToLeafPathWithSpecifiedSum_AllPathsHelper(node.right, paths, path, currentSum, sum);

        path.removeLast();

        return paths;
    }

    /**
     * Variant: return all paths with target sum
     *
     * @Algorithm Recursion
     * @Complexity O(n), O(n) space
     *
     * @param tree binary tree
     * @param sum  target sum
     *
     * @return list of discovered paths
     */
    static List<List<Integer>> findARootToLeafPathWithSpecifiedSum_AllPaths(
            BinaryTreeNode<Integer> tree, int sum
    ) {
        return findARootToLeafPathWithSpecifiedSum_AllPathsHelper(tree, new ArrayList<>(), new LinkedList<>(), 0, sum);
    }



    /*
    IMPLEMENT AN INORDER TRAVERSAL WITHOUT RECURSION
     */

    /**
     * Implement an inorder traversal without recursion
     *
     * @Algorithm Stack
     * @Complexity O(n), O(h) space
     *
     * @param tree binary tree
     * @param <T>  type
     *
     * @return inorder traversal
     */
    public static <T> List<T> inorderTraversalWithoutRecursion(BinaryTreeNode<T> tree) {
        Deque<BinaryTreeNode<T>> queue = new LinkedList<>();
        List<T> result = new LinkedList<>();

        while (!queue.isEmpty() || (tree != null)) {
            if (tree != null) {
                queue.addFirst(tree);
                tree = tree.left;
            } else {
                tree = queue.removeFirst();
                result.add(tree.data);
                tree = tree.right;
            }
        }

        return result;
    }



    /*
    IMPLEMENT A PREORDER TRAVERSAL WITHOUT RECURSION
     */

    /**
     * Implement a preorder traversal without recursion
     *
     * @Algorithm Stack
     * @Complexity O(n), O(h)
     *
     * @param tree binary tree
     * @param <T>  type
     *
     * @return preorder traversal
     */
    public static <T> List<T> preorderTraversalWithoutRecursion(BinaryTreeNode<T> tree) {
        List<T> result = new LinkedList<>();

        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        stack.addFirst(tree);

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.removeFirst();
            result.add(node.data);
            if (node.right != null) stack.addFirst(node.right);
            if (node.left != null) stack.addFirst(node.left);
        }

        return result;
    }



    /*
    COMPUTE THE kth NODE IN AN INORDER TRAVERSAL
     */

    /**
     * Compute the kth node in an inorder traversal
     *
     * @Algorithm Iteration
     * @Complexity O(h), O(1) space
     *
     * @param tree   binary tree with children counts
     * @param target kth node
     * @param <T>    type
     *
     * @return kth node
     */
    static <T> T computeTheKthNodeInAnInorderTraversal(BinaryTreeWithCounts<T> tree, int target) {
        BinaryTreeWithCounts<T> node = tree;

        while (node != null) {
            int totalNodesInLeft = (node.left == null) ? 0 : (node.left.children + 1);

            if (target == totalNodesInLeft + 1) return node.data;

            if (totalNodesInLeft >= target) {
                node = node.left;
            } else {
                node = node.right;
                target -= (totalNodesInLeft + 1);
            }
        }

        return null;
    }



    /*
    COMPUTE THE SUCCESSOR
     */

    /**
     * Compute the successor
     *
     * @Algorithm Iteration
     * @Complexity O(h), O(1) space
     *
     * @param node binary tree with parent links
     * @param <T>  type
     *
     * @return successor node, null otherwise
     */
    static <T> T computeTheSuccessor(BinaryTreeWithParentNode<T> node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
        } else {
            BinaryTreeWithParentNode<T> currentNode = node;
            while ((node != null) && ((node.right == null) || (node.right == currentNode))) node = node.parent;
        }

        return (node == null) ? null : node.data;
    }



    /*
    IMPLEMENT AN INORDER TRAVERSAL WITH O(1) SPACE
     */

    /**
     * Implement an inorder traversal with constant space
     *
     * @Algorithm Remember previous
     * @Complexity O(n), O(1) space
     *
     * @param tree binary tree with parent links
     * @param <T>  type
     *
     * @return inorder traversal
     */
    static <T> List<T> implementAnInorderTraversalWithConstantSpace(BinaryTreeWithParentNode<T> tree) {
        List<T> inorder = new ArrayList<>();

        BinaryTreeWithParentNode<T> previous = null;

        while (tree != null) {
            if (previous == tree.parent) {
                while (tree.left != null) {
                    tree = tree.left;
                }

                previous = null;
            }


            if (previous == tree.left) {
                inorder.add(tree.data);
                previous = tree;
                tree = tree.right != null ? tree.right : tree.parent;
            } else {
                previous = tree;
                tree = tree.parent;
            }
        }

        return inorder;
    }

    /**
     * Variant: preorder traversal with constant space
     *
     * @Algorithm Remember previous
     * @Complexity O(n), O(1) space
     *
     * @param tree binary tree with parent links
     * @param <T>  type
     *
     * @return preorder traversal
     */
    static <T> List<T> implementAnInorderTraversalWithConstantSpace_Preorder(BinaryTreeWithParentNode<T> tree) {
        List<T> preorder = new ArrayList<>();

        BinaryTreeWithParentNode<T> previous = null;

        while (tree != null) {
            if (previous == tree.parent) {
                while (true) {
                    preorder.add(tree.data);
                    if (tree.left == null) break;
                    tree = tree.left;
                }

                previous = null;
            }

            if (tree.left == previous) {
                previous = tree;
                tree = tree.right == null ? tree.parent : tree.right;
            } else {
                previous = tree;
                tree = tree.parent;
            }
        }

        return preorder;
    }

    /**
     * Variant: postorder traversal with constant space
     *
     * @Algorithm Remember previous
     * @Complexity O(n), O(1) space
     *
     * @param tree binary tree with parent links
     * @param <T> type
     *
     * @return postorder traversal
     */
    static <T> List<T> implementAnInorderTraversalWithConstantSpace_Postorder(BinaryTreeWithParentNode<T> tree) {
        List<T> postorder = new ArrayList<>();

        BinaryTreeWithParentNode<T> previous = null;

        while (tree != null) {
            if (previous == tree.parent) {
                while (tree.left != null) tree = tree.left;

                previous = null;
            }

            if (previous == tree.left) {
                previous = tree;

                if (tree.right == null) {
                    postorder.add(tree.data);
                    tree = tree.parent;
                } else {
                    tree = tree.right;
                }
            } else {
                postorder.add(tree.data);
                previous = tree;
                tree = tree.parent;
            }
        }

        return postorder;
    }



    /*
    RECONSTRUCT A BINARY TREE FROM TRAVERSAL DATA
     */

    /**
     * Helper
     *
     * @param inorderNodeToIndexMap hashmap from node values to indices
     * @param preorderStart preorder start index
     * @param preorderEnd preorder end index
     * @param inorderStart inorder start index
     * @param inorderEnd inorder end index
     * @param preorder preorder traversal
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    private static <T> BinaryTreeNode<T> reconstructABinaryTreeFromTraversalDataHelper(
            Map<T, Integer> inorderNodeToIndexMap,
            int preorderStart,
            int preorderEnd,
            int inorderStart,
            int inorderEnd,
            List<T> preorder
    ) {

        if ((preorderStart > preorderEnd) || (inorderStart > inorderEnd)) return null;

        BinaryTreeNode<T> root = new BinaryTreeNode<>(preorder.get(preorderStart));

        int rootIndex = inorderNodeToIndexMap.get(root.data);
        int leftSubTreeLength = rootIndex - inorderStart;

        root.left = reconstructABinaryTreeFromTraversalDataHelper(
                inorderNodeToIndexMap,
                preorderStart + 1, preorderStart + leftSubTreeLength,
                inorderStart, rootIndex - 1,
                preorder
        );

        root.right = reconstructABinaryTreeFromTraversalDataHelper(
                inorderNodeToIndexMap,
                preorderStart + leftSubTreeLength + 1, preorderEnd,
                rootIndex + 1, inorderEnd,
                preorder
        );

        return root;
    }


    /**
     * Reconstruct a binary tree from inorder + preorder traversals, assuming all nodes values are unique
     *
     * @Algorithm HashMap + traversals properties
     * @Complexity O(n), O(n) space
     *
     * @param inorder  inorder traversal
     * @param preorder preorder traversal
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    static <T> BinaryTreeNode<T> reconstructABinaryTreeFromTraversalData(List<T> inorder, List<T> preorder) {
        Map<T, Integer> inorderNodeToIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.size(); i++) inorderNodeToIndexMap.put(inorder.get(i), i);

        return reconstructABinaryTreeFromTraversalDataHelper(
                inorderNodeToIndexMap,
                0, preorder.size() - 1,
                0, inorder.size() - 1,
                preorder
        );
    }


    /**
     * Helper
     *
     * @param inorderNodeToIndexMap hashmap from node values to indices
     * @param inorderStart inorder start index
     * @param inorderEnd inorder end index
     * @param postorderStart preorder start index
     * @param postorderEnd preorder end index
     * @param postorder postorder traversal
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    private static <T> BinaryTreeNode<T> reconstructABinaryTreeFromTraversalData_PostorderHelper(
            Map<T, Integer> inorderNodeToIndexMap, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, List<T> postorder
    ) {
        if ((postorderStart > postorderEnd) || (inorderStart > inorderEnd)) return null;

        BinaryTreeNode<T> root = new BinaryTreeNode<>(postorder.get(postorderEnd));

        int rootIndex = inorderNodeToIndexMap.get(root.data);
        int rightSubTreeLength = inorderEnd - rootIndex;

        root.right = reconstructABinaryTreeFromTraversalData_PostorderHelper(
                inorderNodeToIndexMap,
                rootIndex + 1, inorderEnd,
                postorderEnd - rightSubTreeLength, postorderEnd - 1,
                postorder

        );

        root.left = reconstructABinaryTreeFromTraversalData_PostorderHelper(
                inorderNodeToIndexMap,
                inorderStart, rootIndex - 1,
                postorderStart, postorderEnd - rightSubTreeLength - 1,
                postorder
        );

        return root;
    }

    /**
     * Variant: Reconstruct a binary tree from inorder + postorder traversals, assuming all nodes values are unique
     *
     * @Algorithm HashMap + traversals properties
     * @Complexity O(n), O(n) space
     *
     * @param inorder inorder traversal
     * @param postorder postorder traversal
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    static <T> BinaryTreeNode<T> reconstructABinaryTreeFromTraversalData_Postorder(
            List<T> inorder, List<T> postorder
    ) {
        Map<T, Integer> inorderNodeToIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.size(); i++) inorderNodeToIndexMap.put(inorder.get(i), i);

        return reconstructABinaryTreeFromTraversalData_PostorderHelper(
                inorderNodeToIndexMap,
                0, postorder.size() - 1,
                0, postorder.size() - 1,
                postorder
        );
    }

    /** Index of current element in the array */
    private static int maxTreeIndex = 0;

    /**
     * Helper
     *
     * @param array array with values
     * @param maximum current maximum element
     *
     * @return reconstructed binary tree
     */
    private static BinaryTreeNode<Integer> reconstructABinaryTreeFromTraversalData_MaxTreeHelper(int array[], int maximum) {
        if (maxTreeIndex >= array.length) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(array[maxTreeIndex++]);

        while ((maxTreeIndex < array.length) && (array[maxTreeIndex] < maximum)) {
            if (array[maxTreeIndex] > root.data) {
                root = new BinaryTreeNode<>(array[maxTreeIndex++], root, null);
            } else {
                root.right = reconstructABinaryTreeFromTraversalData_MaxTreeHelper(array, root.data);
            }
        }

        return root;
    }

    /**
     * Variant: build max-tree binary tree
     *
     * @Algorithm One iteration
     * @Complexity O(n), O(n) space
     *
     * @param array array with values
     *
     * @return reconstructed binary tree
     */
    static BinaryTreeNode<Integer> reconstructABinaryTreeFromTraversalData_MaxTree(int array[]) {
        maxTreeIndex = 0;
        return reconstructABinaryTreeFromTraversalData_MaxTreeHelper(array, Integer.MAX_VALUE);
    }



    /*
    RECONSTRUCT A BINARY TREE FROM A PREORDER TRAVERSAL WITH MARKERS
     */
    /** Index of current element in the traversal array */
    private static int reconstructFromPreorderIndex = 0;

    /**
     * Helper
     *
     * @param preorder preorder traversal with null markers
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    private static <T> BinaryTreeNode<T> reconstructABinaryTreeFromAPreorderTraversalWithMarkersHelper(T preorder[]) {
        if ((reconstructFromPreorderIndex >= preorder.length) || (preorder[reconstructFromPreorderIndex++] == null)) return null;

        return new BinaryTreeNode<>(
                preorder[reconstructFromPreorderIndex - 1],
                reconstructABinaryTreeFromAPreorderTraversalWithMarkersHelper(preorder),
                reconstructABinaryTreeFromAPreorderTraversalWithMarkersHelper(preorder)
        );
    }

    /**
     * Reconstruct a binary tree from a preorder traversal with markers
     *
     * @Algorithm Recursion
     * @Complexity O(n), O(n) space
     *
     * @param preorder preorder traversal with markers
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    static <T> BinaryTreeNode<T> reconstructABinaryTreeFromAPreorderTraversalWithMarkers(T preorder[]) {
        reconstructFromPreorderIndex = 0;

        return reconstructABinaryTreeFromAPreorderTraversalWithMarkersHelper(preorder);
    }

    /** Index of current element in the traversal array */
    private static int reconstructFromPostorderIndex = 0;

    /**
     * Helper
     *
     * @param postorder postorder traversal with markers
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    private static <T> BinaryTreeNode<T> reconstructABinaryTreeFromAPreorderTraversalWithMarkers_PostorderHelper(T postorder[]) {
        if ((reconstructFromPostorderIndex < 0) || (postorder[reconstructFromPostorderIndex--] == null)) return null;

        T value = postorder[reconstructFromPostorderIndex + 1];
        BinaryTreeNode<T> right = reconstructABinaryTreeFromAPreorderTraversalWithMarkers_PostorderHelper(postorder);

        return new BinaryTreeNode<>(
                value,
                reconstructABinaryTreeFromAPreorderTraversalWithMarkers_PostorderHelper(postorder),
                right
        );
    }

    /**
     * Variant: from postorder traversal
     *
     * @Algorithm Recursion
     * @Complexity O(n), O(n) space
     *
     * @param postorder postorder traversal with markers
     * @param <T> type
     *
     * @return reconstructed binary tree
     */
    static <T> BinaryTreeNode<T> reconstructABinaryTreeFromAPreorderTraversalWithMarkers_Postorder(T postorder[]) {
        reconstructFromPostorderIndex = postorder.length - 1;

        return reconstructABinaryTreeFromAPreorderTraversalWithMarkers_PostorderHelper(postorder);
    }



    /*
    FORM A LINKED LIST FROM THE LEAVES OF A BINARY TREE
     */

    /**
     * Form a linked list from the leaves of a binary tree in the left-right order
     *
     * @Algorithm Depth-first search
     * @Complexity O(n), O(n) space
     *
     * @param tree binary tree
     * @param <T> type
     *
     * @return linked list formed of leaves in the left-right order
     */
    static <T> List<T> formALinkedListFromTheLeavesOfABinaryTree(BinaryTreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();

        stack.addLast(tree);

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.removeLast();

            if ((node.left == null) && (node.right == null)) result.add(node.data);
            else {
                if (node.right != null) stack.addLast(node.right);
                if (node.left != null) stack.addLast(node.left);
            }
        }

        return result;
    }



    /*
    COMPUTE THE EXTERIOR OF A BINARY TREE
     */

    /**
     * Compute exterior of the left part of the tree
     *
     * @param node current node
     * @param exterior exterior
     * @param isBorder flag if the node is part of the left border
     * @param <T> type
     */
    private static <T> void exteriorComputeLeft(BinaryTreeNode<T> node, LinkedList<T> exterior, boolean isBorder) {
        if (node != null) {
            if (isBorder || ((node.left == null) && (node.right == null))) exterior.add(node.data);

            exteriorComputeLeft(node.left, exterior, isBorder);
            exteriorComputeLeft(node.right, exterior, isBorder && (node.left == null));
        }
    }

    /**
     * Compute exterior of the left part of the tree
     *
     * @param node current node
     * @param exterior exterior
     * @param isBorder flag if the node is part of the left border
     * @param <T> type
     */
    private static <T> void exteriorComputeRight(BinaryTreeNode<T> node, LinkedList<T> exterior, boolean isBorder) {
        if (node != null) {
            exteriorComputeRight(node.left, exterior, isBorder && (node.right == null));
            exteriorComputeRight(node.right, exterior, isBorder);

            if (isBorder || ((node.left == null) && (node.right == null))) exterior.add(node.data);
        }
    }

    /**
     * Compute exterior of a binary tree
     *
     * @Algorithm Traverse
     * @Complexity O(n), O(n) space
     *
     * @param tree binary tree
     * @param <T> type
     *
     * @return exterior
     */
    static <T> List<T> exterior(BinaryTreeNode<T> tree) {
        LinkedList<T> result = new LinkedList<>();
        result.addFirst(tree.data);
        exteriorComputeLeft(tree.left, result, true);
        exteriorComputeRight(tree.right, result, true);

        return result;
    }



    /*
    COMPUTE THE RIGHT SIBLING TREE
     */

    /**
     * Helper.
     * Process all nodes from next level of current level
     *
     * @param node current node
     * @param <T> type
     */
    private static <T> void processLowerLevel(BinaryTreeWithParentNode<T> node) {
        BinaryTreeWithParentNode<T> iterator = node;
        while (iterator != null) {
            iterator.left.parent = iterator.right;
            if (iterator.parent != null) iterator.right.parent = iterator.parent.left;

            iterator = iterator.parent;
        }
    }

    /**
     * Compute the right sibling tree for a perfect tree
     *
     * @Algorithm Level-by-level, left-to-right
     * @Complexity O(n), O(1) space
     *
     * @param tree binary tree with links to the right nodes. I'm using parent links for that
     * @param <T> type
     */
    static <T> void computeTheRightSiblingTree(BinaryTreeWithParentNode<T> tree) {
        BinaryTreeWithParentNode<T> current = tree;
        while ((current != null) && (current.left != null)) {
            processLowerLevel(current);
            current = current.left;
        }
    }

    /**
     * Variant: same problem for a general tree
     *
     * @Algorithm Breadth-first search
     * @Complexity O(n), O(n) space
     *
     * @param tree binary tree with links to the right nodes. I'm using parent links for that
     * @param <T> type
     */
    static <T> void computeTheRightSiblingTree_GeneralTree(BinaryTreeWithParentNode<T> tree) {
        Deque<BinaryTreeWithParentNode<T>> queue = new LinkedList<>();

        queue.addLast(tree);
        queue.addLast(null);

        BinaryTreeWithParentNode<T> last = null;
        while (!queue.isEmpty()) {
            BinaryTreeWithParentNode<T> next = queue.removeFirst();
            if (next == null) {
                last = null;
                if (!queue.isEmpty()) queue.addLast(null);
            } else {
                if (last != null) last.parent = next;
                last = next;

                if (next.left != null) queue.addLast(next.left);
                if (next.right != null) queue.addLast(next.right);
            }
        }
    }
}
