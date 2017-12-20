package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.amberovsky.elements.util.data.ListNode.*;

public class ListNodeTest {
    @Test
    public void testListNodeConstructors() {
        ListNode<Integer> node = new ListNode<>(100);
        assertEquals(100, node.data.intValue());
        assertNull(node.next);

        node = new ListNode<>(200, null);
        assertEquals(200, node.data.intValue());
        assertNull(node.next);

        ListNode<Integer> nextNode = new ListNode<>(400);
        node = new ListNode<>(300, nextNode);
        assertEquals(300, node.data.intValue());
        assertEquals(node.next, nextNode);
    }

    @Test
    public void testListNodeEquals() {
        assertFalse(new ListNode<>(100).equals(null));
        assertFalse(new ListNode<>(100).equals("qwe"));
        assertFalse(new ListNode<>(100).equals(new ListNode<>(200)));


        assertTrue(new ListNode<>(100).equals(new ListNode<>(100)));
    }

    @Test
    public void testToListNode() {
        assertNull(toListNode());

        assertEquals(new ListNode<>(100), toListNode(100));
        assertEquals(new ListNode<>(100, new ListNode<>(200)), toListNode(100, 200));
    }


    /*
    BOOT CAMP
    */
    @Test
    public void testSearch() {
        assertNull(search(toListNode(), 10));
        assertNull(search(toListNode(20), 10));

        ListNode<Integer> node;

        node = new ListNode<>(10);
        assertEquals(node, search(node, 10));

        node = new ListNode<>(10, new ListNode<>(20));
        assertEquals(node, search(node, 10));
        assertEquals(node.next, search(node, 20));
    }

    @Test
    public void testInsertAfter() {
        ListNode<Integer> node3 = new ListNode<>(300);
        ListNode<Integer> node2 = new ListNode<>(200);

        insertAfter(node2, node3);

        assertEquals(toListNode(200, 300), node2);
    }

    @Test
    public void testDeleteAfter() {
        ListNode<Integer> node = toListNode(100, 200);
        deleteAfter(node);
        assertEquals(toListNode(100), node);


        node = toListNode(100, 200, 300);
        deleteAfter(node);
        assertEquals(toListNode(100, 300), node);
    }
}
