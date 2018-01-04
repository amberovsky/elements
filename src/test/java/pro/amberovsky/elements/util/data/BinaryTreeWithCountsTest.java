package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeWithCountsTest {
    @Test
    void testBinaryTreeWithParentNodeConstructors() {
        BinaryTreeWithCounts<Integer> node = new BinaryTreeWithCounts<>(100);
        assertEquals(100, node.data.intValue());
        assertEquals(0, node.children);
        assertNull(node.left);
        assertNull(node.right);

        node = new BinaryTreeWithCounts<>(200, 100, null, null);
        assertEquals(200, node.data.intValue());
        assertEquals(100, node.children);
        assertNull(node.left);
        assertNull(node.right);

        BinaryTreeWithCounts<Integer> leftNode = new BinaryTreeWithCounts<>(400);
        BinaryTreeWithCounts<Integer> rightNode = new BinaryTreeWithCounts<>(1000);
        node = new BinaryTreeWithCounts<>(300, 99, leftNode, rightNode);
        assertEquals(300, node.data.intValue());
        assertEquals(99, node.children);
        assertEquals(node.left, leftNode);
        assertEquals(node.right, rightNode);
    }

    @Test
    void testEquals() {
        assertEquals(new BinaryTreeWithCounts<>(100), new BinaryTreeWithCounts<>(100));
        assertNotEquals(new BinaryTreeWithCounts<>(100), new BinaryTreeWithCounts<>(101));

        assertEquals(
                new BinaryTreeWithCounts<>(100, 10, new BinaryTreeWithCounts<>(300), null),
                new BinaryTreeWithCounts<>(100, 10, new BinaryTreeWithCounts<>(300), null)
        );

        assertNotEquals(
                new BinaryTreeWithCounts<>(100, 15, new BinaryTreeWithCounts<>(300), null),
                new BinaryTreeWithCounts<>(100, 15, null, new BinaryTreeWithCounts<>(300 ))
        );
    }
}
