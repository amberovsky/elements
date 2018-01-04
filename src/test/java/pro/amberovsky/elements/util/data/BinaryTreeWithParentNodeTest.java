package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeWithParentNodeTest {
    @Test
    void testBinaryTreeWithParentNodeConstructors() {
        BinaryTreeWithParentNode<Integer> node = new BinaryTreeWithParentNode<>(100);
        assertEquals(100, node.data.intValue());
        assertNull(node.parent);
        assertNull(node.left);
        assertNull(node.right);
        assertFalse(node.isLocked());

        node = new BinaryTreeWithParentNode<>(200, null, null, null);
        assertEquals(200, node.data.intValue());
        assertNull(node.parent);
        assertNull(node.left);
        assertNull(node.right);
        assertFalse(node.isLocked());

        BinaryTreeWithParentNode<Integer> leftNode = new BinaryTreeWithParentNode<>(400);
        BinaryTreeWithParentNode<Integer> rightNode = new BinaryTreeWithParentNode<>(1000);
        BinaryTreeWithParentNode<Integer> parent = new BinaryTreeWithParentNode<>(-100);
        node = new BinaryTreeWithParentNode<>(300, parent, leftNode, rightNode);
        assertEquals(300, node.data.intValue());
        assertEquals(node.parent, parent);
        assertEquals(node.left, leftNode);
        assertEquals(node.right, rightNode);
        assertFalse(node.isLocked());
    }

    @Test
    void testEquals() {
        assertEquals(new BinaryTreeWithParentNode<>(100), new BinaryTreeWithParentNode<>(100));
        assertNotEquals(new BinaryTreeWithParentNode<>(100), new BinaryTreeWithParentNode<>(101));

        assertEquals(
                new BinaryTreeWithParentNode<>(100, null, new BinaryTreeWithParentNode<>(300), null),
                new BinaryTreeWithParentNode<>(100, null, new BinaryTreeWithParentNode<>(300), null)
        );

        assertNotEquals(
                new BinaryTreeWithParentNode<>(100, null, new BinaryTreeWithParentNode<>(300), null),
                new BinaryTreeWithParentNode<>(100, null, null, new BinaryTreeWithParentNode<>(300 ))
        );
    }

    @Test
    void testLocks() {
        BinaryTreeWithParentNode<Integer> root = new BinaryTreeWithParentNode<>(-100);
        BinaryTreeWithParentNode<Integer> leftNode = new BinaryTreeWithParentNode<>(400, root, null, null);
        BinaryTreeWithParentNode<Integer> rightNode = new BinaryTreeWithParentNode<>(1000, root, null, null);
        BinaryTreeWithParentNode<Integer> leftLeftNode = new BinaryTreeWithParentNode<>(7, leftNode, null, null);

        leftNode.left = leftLeftNode;
        root.left = leftNode;
        root.right = rightNode;

        assertTrue(root.lock());
        assertTrue(root.isLocked());
        root.unlock();
        assertFalse(root.isLocked());

        assertTrue(leftLeftNode.lock());
        assertFalse(root.lock());
        leftLeftNode.unlock();

        root.lock();
        assertFalse(rightNode.lock());
        assertFalse(rightNode.isLocked());

        root.unlock();
        assertTrue(leftNode.lock());
        assertTrue(rightNode.lock());
    }
}
