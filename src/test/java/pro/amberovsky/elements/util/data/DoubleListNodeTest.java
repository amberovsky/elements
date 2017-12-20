package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.amberovsky.elements.util.data.DoubleListNode.*;

public class DoubleListNodeTest {
    @Test
    public void testDoubleListNodeConstructors() {
        DoubleListNode<Integer> node = new DoubleListNode<>(100);
        assertEquals(100, node.data.intValue());
        assertNull(node.next);
        assertNull(node.prev);

        node = new DoubleListNode<>(200, null, null);
        assertEquals(200, node.data.intValue());
        assertNull(node.next);
        assertNull(node.prev);

        DoubleListNode<Integer> nextNode = new DoubleListNode<>(400);
        node = new DoubleListNode<>(300, nextNode, null);
        assertEquals(300, node.data.intValue());
        assertEquals(node.next, nextNode);
        assertEquals(node, nextNode.prev);
        assertNull(node.prev);


        DoubleListNode<Integer> prevNode = new DoubleListNode<>(500);
        node = new DoubleListNode<>(300, nextNode, prevNode);
        assertEquals(300, node.data.intValue());
        assertEquals(node.next, nextNode);
        assertEquals(node, nextNode.prev);
        assertEquals(node.prev, prevNode);
        assertEquals(node, prevNode.next);

    }

    @Test
    public void testListNodeEquals() {
        assertFalse(new DoubleListNode<>(100).equals(null));
        assertFalse(new DoubleListNode<>(100).equals("qwe"));
        assertFalse(new DoubleListNode<>(100).equals(new DoubleListNode<>(200)));


        assertTrue(new DoubleListNode<>(100).equals(new DoubleListNode<>(100)));

        assertTrue(
                new DoubleListNode<>(100, new DoubleListNode<>(200), new DoubleListNode<>(50))
                        .equals(new DoubleListNode<>(100, new DoubleListNode<>(200), new DoubleListNode<>(50))));
    }

    @Test
    public void testToListNode() {
        assertNull(toListNode());

        assertEquals(new DoubleListNode<>(100), toListNode(100));

        assertEquals(
                new DoubleListNode<>(100, new DoubleListNode<>(200), new DoubleListNode<>(50)).prev,
                toListNode(50, 100, 200)
        );
    }
}
