package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinaryTreeNodeTest {
    @Test
    void testBinaryTreeNodeConstructors() {
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

    @Test
    void testEquals() {
        assertEquals(new BinaryTreeNode<>(100), new BinaryTreeNode<>(100));
        assertNotEquals(new BinaryTreeNode<>(100), new BinaryTreeNode<>(101));

        assertEquals(
                new BinaryTreeNode<>(100, new BinaryTreeNode<>(300), null),
                new BinaryTreeNode<>(100, new BinaryTreeNode<>(300), null)
        );

        assertNotEquals(
                new BinaryTreeNode<>(100, new BinaryTreeNode<>(300), null),
                new BinaryTreeNode<>(100, null, new BinaryTreeNode<>(300 ))
        );
    }

    @Test
    void testPostorderTraversal() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        assertEquals(java.util.Arrays.asList(1), root.postorder());

        root.left = new BinaryTreeNode<>(2);
        assertEquals(java.util.Arrays.asList(2, 1), root.postorder());

        root.right = new BinaryTreeNode<>(3);
        assertEquals(java.util.Arrays.asList(2, 3, 1), root.postorder());

        root.left.right = new BinaryTreeNode<>(4);
        assertEquals(java.util.Arrays.asList(4, 2, 3, 1), root.postorder());
    }

    @Test
    void testPreorderTraversalWithMarkers() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        assertEquals(java.util.Arrays.asList(1, null, null), root.preorderWithMarkers());

        root.left = new BinaryTreeNode<>(2);
        assertEquals(java.util.Arrays.asList(1, 2, null, null, null), root.preorderWithMarkers());

        root.right = new BinaryTreeNode<>(3);
        assertEquals(java.util.Arrays.asList(1, 2, null, null, 3, null, null), root.preorderWithMarkers());

        root.left.right = new BinaryTreeNode<>(4);
        assertEquals(java.util.Arrays.asList(1, 2, null, 4, null, null, 3, null, null), root.preorderWithMarkers());
    }

    @Test
    void testPostorderTraversalWithMarkers() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        assertEquals(java.util.Arrays.asList(null, null, 1), root.postorderWithMarkers());

        root.left = new BinaryTreeNode<>(2);
        assertEquals(java.util.Arrays.asList(null, null, 2, null, 1), root.postorderWithMarkers());

        root.right = new BinaryTreeNode<>(3);
        assertEquals(java.util.Arrays.asList(null, null, 2, null, null, 3, 1), root.postorderWithMarkers());

        root.left.right = new BinaryTreeNode<>(4);
        assertEquals(java.util.Arrays.asList(null, null, null, 4, 2, null, null, 3, 1), root.postorderWithMarkers());
    }
}
