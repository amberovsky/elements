package pro.amberovsky.elements.util.data;

/**
 * Helper class for the LinkedLists section
 *
 * Double linked list
 *
 * @param <T> type
 */
public class DoubleListNode<T> {
    /** node value */
    public T data;

    /** next node */
    public DoubleListNode<T> next;

    /** previous node */
    public DoubleListNode<T> prev;

    /**
     * @param data node data
     */
    public DoubleListNode(T data) {
        this(data, null, null);
    }

    /**
     * @param data node data
     * @param next next node
     * @param prev prev node
     */
    public DoubleListNode(T data, DoubleListNode<T> next, DoubleListNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;

        if (next != null) {
            next.prev = this;
        }

        if (prev != null) {
            prev.next = this;
        }
    }

    /**
     * Equality checks
     *
     * @param o other object
     *
     * @return true if both are double linked lists with nodes in the same order
     */
    @Override
    public boolean equals(Object o) {
        if ((o == null) || !(o instanceof DoubleListNode)) return false;

        if (o == this) return true;

        DoubleListNode<T> p1 = this;
        DoubleListNode<?> p2 = (DoubleListNode<?>) o;

        DoubleListNode<T> p1prev = p1.prev;
        DoubleListNode<?> p2prev = p2.prev;


        while ((p1 != null) && (p2 != null)) {
            if (!p1.data.equals(p2.data)) return false;

            if (p1.prev != p1prev) return false;
            if (p2.prev != p2prev) return false;

            p1prev = p1;
            p2prev = p2;
            p1 = p1.next;
            p2 = p2.next;
        }

        return (p1 == null) && (p2 == null);
    }

    /**
     * Creates double linked list from values
     *
     * @param values values
     * @param <T> type
     *
     * @return double linked list
     */
    public static <T> DoubleListNode<T> toListNode(T... values) {
        DoubleListNode<T> root = new DoubleListNode<>(null);
        DoubleListNode<T> current = root;

        for (T value : values) {
            current.next = new DoubleListNode<>(value, null, current);
            current = current.next;
        }

        return root.next;
    }
}
