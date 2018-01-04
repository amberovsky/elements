package pro.amberovsky.elements.util.data;

/**
 * Helper class for various sections
 *
 * Binary tree with parent pointers with locking
 *
 * @param <T> type
 */
public class BinaryTreeWithParentNode<T> {
    /** node value */
    public T data;

    /** left child */
    public BinaryTreeWithParentNode<T> left;

    /** right child */
    public BinaryTreeWithParentNode<T> right;

    /** parent node */
    public BinaryTreeWithParentNode<T> parent;

    /** state of the node */
    private boolean isLocked;

    /** how many descendant are locked */
    private int lockedDescendant;

    /**
     * @param data node data
     */
    public BinaryTreeWithParentNode(T data) {
        this(data, null, null, null);
    }

    /**
     * @param data node data
     * @param parent parent node
     * @param left left child
     * @param right right child
     */
    public BinaryTreeWithParentNode(
            T data,
            BinaryTreeWithParentNode<T> parent,
            BinaryTreeWithParentNode<T> left,
            BinaryTreeWithParentNode<T> right
    ) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;

        this.isLocked = false;
        this.lockedDescendant = 0;
    }

    /**
     * Equality helper
     *
     * @param tree1 first tree
     * @param tree2 second tree
     *
     * @return true if equals, false otherwise
     */
    private boolean equalsHelper(BinaryTreeWithParentNode<T> tree1, BinaryTreeWithParentNode<T> tree2) {
        if ((tree1 == null) && (tree2 == null)) return true;

        if ((tree1 != null) && (tree2 != null)) {
            return (tree1.data.equals(tree2.data))
                    && (tree1.parent == tree2.parent)
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
        if ((other == null) || !(other instanceof BinaryTreeWithParentNode)) return false;

        return equalsHelper(this, (BinaryTreeWithParentNode<T>) other);
    }

    /**
     * @Complexity O(1), O(1) space
     *
     * @return state of the node
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * @Complexity O(h), O(1) space
     *
     * Unlock the node, if locked
     */
    public void unlock() {
        if (isLocked) {
            isLocked = false;
            BinaryTreeWithParentNode<T> pointer = this.parent;

            while (pointer != null) {
                pointer.lockedDescendant--;
                pointer = pointer.parent;
            }
        }
    }

    /**
     * Lock the node
     *
     * @Complexity O(h), O(1) space
     *
     * @return false if node can not be locked, true otherwise
     */
    public boolean lock() {
        if (isLocked || (lockedDescendant > 0)) return false;

        BinaryTreeWithParentNode<T> pointer = this.parent;
        while (pointer != null) {
            if (pointer.isLocked) return false;
            pointer = pointer.parent;
        }

        pointer = this.parent;
        while (pointer != null) {
            pointer.lockedDescendant++;
            pointer = pointer.parent;
        }

        isLocked = true;

        return true;
    }
}
