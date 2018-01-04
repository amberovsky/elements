package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackQueueTest {
    StackQueue<Integer> queue;

    @BeforeEach
    void initialize() {
        queue = new StackQueue<>();
    }

    @Test
    void testConstructor() {
        assertEquals(0, queue.size());
    }

    @Test
    void testEnqueueAndDequeue() {
        final int count = 8;

        for (int i = 0; i < count; i++) queue.enqueue(i);

        for (int i = 0; i < count / 2; i++) assertEquals(i, queue.dequeue().intValue());

        for (int i = count; i < 2 * count; i++) queue.enqueue(i);

        for (int i = count / 2; i < count * 2; i++) assertEquals(i, queue.dequeue().intValue());

        assertEquals(0, queue.size());
    }
}
