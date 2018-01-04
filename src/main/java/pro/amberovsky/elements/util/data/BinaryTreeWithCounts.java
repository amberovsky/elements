package pro.amberovsky.elements.util.data;

/**
 * Helper class for various sections
 *
 * Binary tree where each node knows amount of children
 *
 * @param <T> type
 */
public class BinaryTreeWithCounts<T> {
    /** node value */
    public T data;

    /** left child */
    public BinaryTreeWithCounts<T> left;

    /** right child */
    public BinaryTreeWithCounts<T> right;

    /** amount of children */
    public int children;

    /**
     * @param data node data
     */
    public BinaryTreeWithCounts(T data) {
        this(data, 0, null, null);
    }

    /**
     * @param data node data
     * @param children amount of children
     * @param left left child
     * @param right right child
     */
    public BinaryTreeWithCounts(
            T data,
            int children,
            BinaryTreeWithCounts<T> left,
            BinaryTreeWithCounts<T> right
    ) {
        this.data = data;
        this.children = children;
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
    private boolean equalsHelper(BinaryTreeWithCounts<T> tree1, BinaryTreeWithCounts<T> tree2) {
        if ((tree1 == null) && (tree2 == null)) return true;

        if ((tree1 != null) && (tree2 != null)) {
            return (tree1.data.equals(tree2.data))
                    && (tree1.children == tree2.children)
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
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof BinaryTreeWithCounts)) return false;

        return equalsHelper(this, (BinaryTreeWithCounts<T>) other);
    }
}
