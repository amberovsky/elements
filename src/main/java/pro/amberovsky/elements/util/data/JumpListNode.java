package pro.amberovsky.elements.util.data;

/**
 * Helper class for the StacksAndQueues section
 *
 * Single linked list with jump nodes
 *
 * @param <T> type
 */
public class JumpListNode<T> {
    /** node value */
    public T data;

    /** next node */
    public JumpListNode<T> next;

    /** jump node */
    public JumpListNode<T> jump;

    /** order in the jump-first order */
    public int order;

    /**
     * @param data node data
     */
    public JumpListNode(T data) {
        this(data, null, null);
    }

    /**
     * @param data node data
     * @param next next node
     * @param jump jump node
     */
    public JumpListNode(T data, JumpListNode<T> next, JumpListNode<T> jump) {
        this.data = data;
        this.next = next;
        this.jump = jump;
        order = -1;
    }
}
