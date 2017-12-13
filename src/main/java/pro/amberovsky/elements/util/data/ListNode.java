package pro.amberovsky.elements.util.data;

/**
 * Helper class for the LinkedLists section
 *
 * Single linked list
 *
 * @param <T> type
 */
public class ListNode<T> {
    /** node value */
    public T data;

    /** next node */
    public ListNode<T> next;

    /**
     * @param data node data
     */
    public ListNode(T data) {
        this(data, null);
    }

    /**
     * @param data node data
     * @param next next node
     */
    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Equality checks
     *
     * @param o other object
     *
     * @return true if both are single linked lists with nodes in the same order
     */
    @Override
    public boolean equals(Object o) {
        if ((o == null) || !(o instanceof ListNode)) return false;

        if (o == this) return true;

        ListNode<T> p1 = this;
        ListNode<?> p2 = (ListNode<?>) o;

        while ((p1 != null) && (p2 != null)) {
            if (!p1.data.equals(p2.data)) return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return (p1 == null) && (p2 == null);
    }

    /**
     * Creates single linked list from values
     *
     * @param values values
     * @param <T> type
     *
     * @return single linked list
     */
    public static <T> ListNode<T> toListNode(T... values) {
        ListNode<T> root = new ListNode<>(null);
        ListNode<T> current = root;

        for (T value : values) {
            current.next = new ListNode<>(value);
            current = current.next;
        }

        return root.next;
    }



    /*
    BOOT CAMP
    */

    /**
     * Search for an element in a LinkedList
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param list LinkedList to search in
     * @param element element to search for
     * @param <T> type
     *
     * @return node, if found null otherwise
     */
    public static <T> ListNode<T> search(ListNode<T> list, T element) {
        while ((list != null) && (!list.data.equals(element))) {
            list = list.next;
        }

        return list;
    }

    /**
     * Insert a new node immediately after given one
     *
     * @Complexity O(1), O(1) space
     *
     * @param node insert immediately after this node
     * @param newNode new node
     * @param <T> type
     */
    public static <T> void insertAfter(ListNode<T> node, ListNode<T> newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * Delete node following given one
     *
     * @Complexity O(1), O(1) space
     *
     * @param node delete node after this one
     * @param <T> type
     */
    public static <T> void deleteAfter(ListNode<T> node) {
        if (node.next != null) node.next = node.next.next;
    }
}
