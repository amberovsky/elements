package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackviaHeapTest {
    StackViaHeap<Integer> stack;

    @BeforeEach
    void initialize() {
        stack = new StackViaHeap<>();
    }

    @Test
    void testConstructor() {
        assertEquals(0, stack.size());
    }

    @Test
    void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2).push(1);
        assertEquals(3, stack.size());
    }

    @Test
    void testPop() {
        stack.push(1).pop();
        assertEquals(0, stack.size());

        stack.push(1).push(3).push(4).push(1);
        assertEquals(4, stack.size());
    }

    @Test
    void testPushAndPop() {
        stack.push(1);
        assertEquals(1, stack.pop().intValue());

        stack.push(1).push(3).push(4).push(1);
        assertEquals(1, stack.pop().intValue());
        assertEquals(4, stack.pop().intValue());
        assertEquals(3, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }
}
