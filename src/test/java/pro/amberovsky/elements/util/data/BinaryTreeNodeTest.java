package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryTreeNodeTest {
    @Test
    public void testBinaryTreeNodeConstructors() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(100);
        assertEquals(100, node.data.intValue());
        assertNull(node.left);
        assertNull(node.right);

        node = new BinaryTreeNode<>(200, null, null);
        assertEquals(200, node.data.intValue());
        assertNull(node.left);
        assertNull(node.right);

        BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(400);
        BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(1000);
        node = new BinaryTreeNode<>(300, leftNode, rightNode);
        assertEquals(300, node.data.intValue());
        assertEquals(node.left, leftNode);
        assertEquals(node.right, rightNode);
    }
}
