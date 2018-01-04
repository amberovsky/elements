package pro.amberovsky.elements.util.data;

import pro.amberovsky.elements.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Helper class for various sections
 *
 * Binary tree
 *
 * @param <T> type
 */
public class BinaryTreeNode<T> {
    /** node value */
    public T data;

    /** left child */
    public BinaryTreeNode<T> left;

    /** right child */
    public BinaryTreeNode<T> right;

    /**
     * @param data node data
     */
    public BinaryTreeNode(T data) {
        this(data, null, null);
    }

    /**
     * @param data node data
     * @param left left child
     * @param right right child
     */
    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Equality helper
     *
     * @param tree1 first tree
     * @param tree2 second tree
     *
     * @return true if equals, false otherwise
     */
    private boolean equalsHelper(BinaryTreeNode<T> tree1, BinaryTreeNode<T> tree2) {
        if ((tree1 == null) && (tree2 == null)) return true;

        if ((tree1 != null) && (tree2 != null)) {
            return (tree1.data.equals(tree2.data))
                    && equalsHelper(tree1.left, tree2.left)
                    && equalsHelper(tree1.right, tree2.right);
        }

        return false;
    }

    /**
     * Equality checker
     *
     * @param other other binary tree
     *
     * @return true if equals, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof BinaryTreeNode)) return false;

        return equalsHelper(this, (BinaryTreeNode<T>) other);
    }

    /**
     * @return inorder traversal
     */
    public List<T> inorder() {
        return BinaryTrees.inorderTraversalWithoutRecursion(this);
    }

    /**
     * @return preorder traversal
     */
    public List<T> preorder() {
        return BinaryTrees.preorderTraversalWithoutRecursion(this);
    }

    /**
     * @param node current node
     * @param preorder current preorder traversal
     *
     * @return preorder traversal with null markers
     */
    private List<T> preorderWithMarkers(BinaryTreeNode<T> node, List<T> preorder) {
        if (node == null) preorder.add(null);
        else {
            preorder.add(node.data);
            preorderWithMarkers(node.left, preorder);
            preorderWithMarkers(node.right, preorder);
        }

        return preorder;
    }

    /**
     * @Algorithm Recursion
     * @Complexity O(n), O(h) space
     *
     * @return preorder traversal with null markers
     */
    public List<T> preorderWithMarkers() {
        return preorderWithMarkers(this, new LinkedList<>());
    }

    /**
     * Generate postorder traversal
     *
     * @param node current node
     * @param postorder current traversal
     *
     * @return postorrder traversal
     */
    private List<T> postorder(BinaryTreeNode<T> node, List<T> postorder) {
        if (node != null) {
            postorder(node.left, postorder);
            postorder(node.right, postorder);
            postorder.add(node.data);
        }

        return postorder;
    }

    /**
     * @return postorder traversal
     */
    public List<T> postorder() {
        return postorder( this, new ArrayList<>());
    }

    /**
     * Helper
     *
     * @param node current node
     * @param postorder current postorder traversal with null markers
     *
     * @return postorder traversal with markers
     */
    private List<T> postorderWithMarkers(BinaryTreeNode<T> node, List<T> postorder) {
        if (node == null) postorder.add(null);
        else {
            postorderWithMarkers(node.left, postorder);
            postorderWithMarkers(node.right, postorder);
            postorder.add(node.data);
        }

        return postorder;
    }

    /**
     * @Algorithm  recursion
     * @Complexity O(n), O(n) space
     *
     * @return postorder traversal with null markers
     */
    public List<T> postorderWithMarkers() {
        return postorderWithMarkers(this, new LinkedList<>());
    }
}
