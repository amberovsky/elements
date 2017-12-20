package pro.amberovsky.elements.util.data;

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
}
