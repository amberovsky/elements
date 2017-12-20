package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JumpListNodeTest {
    @Test
    public void testJumpListNodeConstructors() {
        JumpListNode<Integer> node = new JumpListNode<>(100);
        assertEquals(100, node.data.intValue());
        assertNull(node.next);
        assertNull(node.jump);

        node = new JumpListNode<>(200, null, null);
        assertEquals(200, node.data.intValue());
        assertNull(node.next);
        assertNull(node.jump);

        JumpListNode<Integer> nextNode = new JumpListNode<>(400);
        JumpListNode<Integer> jumpNode = new JumpListNode<>(1000);
        node = new JumpListNode<>(300, nextNode, jumpNode);
        assertEquals(300, node.data.intValue());
        assertEquals(node.next, nextNode);
        assertEquals(node.jump, jumpNode);
    }
}
