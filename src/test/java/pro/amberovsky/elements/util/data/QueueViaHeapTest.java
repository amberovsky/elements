package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueViaHeapTest {
    QueueViaHeap<Integer> queue;

    @BeforeEach
    void initialize() {
        queue = new QueueViaHeap<>();
    }

    @Test
    void testConstructor() {
        assertEquals(0, queue.size());
    }

    @Test
    void testEnqueue() {
        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.enqueue(2).enqueue(1);
        assertEquals(3, queue.size());
    }

    @Test
    void testDequeue() {
        queue.enqueue(1).dequeue();
        assertEquals(0, queue.size());

        queue.enqueue(1).enqueue(3).enqueue(4).enqueue(1);
        assertEquals(4, queue.size());
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue().intValue());

        queue.enqueue(1).enqueue(3).enqueue(4).enqueue(1);
        assertEquals(1, queue.dequeue().intValue());
        assertEquals(3, queue.dequeue().intValue());
        assertEquals(4, queue.dequeue().intValue());
        assertEquals(1, queue.dequeue().intValue());
    }
}
