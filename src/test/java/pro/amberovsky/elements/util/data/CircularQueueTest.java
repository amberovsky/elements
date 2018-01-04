package pro.amberovsky.elements.util.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircularQueueTest {
    CircularQueue<Integer> queue;

    @BeforeEach
    void initialize() {
        queue = new CircularQueue<>();
    }

    @Test
    void testConstructor() {
        assertEquals(0, queue.size());
        assertEquals(CircularQueue.MINIMUM_ELEMENTS, queue.data.length);
    }

    @Test
    void testCapacityGrowths() {
        for (int i = 0 ; i < CircularQueue.MINIMUM_ELEMENTS; i++) {
            queue.enqueue(i);
        }

        assertEquals(CircularQueue.MINIMUM_ELEMENTS, queue.size());
        assertEquals(CircularQueue.MINIMUM_ELEMENTS, queue.data.length);

        queue.enqueue(CircularQueue.MINIMUM_ELEMENTS);

        assertEquals(CircularQueue.MINIMUM_ELEMENTS + 1, queue.size());
        assertEquals(CircularQueue.MINIMUM_ELEMENTS * 2, queue.data.length);
    }

    @Test
    void testCapacityDecreases() {
        for (int i = 0 ; i < CircularQueue.MINIMUM_ELEMENTS + 1; i++) {
            queue.enqueue(i);
        }

        queue.dequeue();

        assertEquals(CircularQueue.MINIMUM_ELEMENTS, queue.size());
        assertEquals(CircularQueue.MINIMUM_ELEMENTS, queue.data.length);
    }

    @Test
    void testDequeue() {
        queue.enqueue(10);
        assertEquals(10, queue.dequeue().intValue());
    }

    @Test
    void testDequeueWhenCapacityIsChanging() {
        int count = CircularQueue.MINIMUM_ELEMENTS * 4;
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < count / 2; i++) {
            assertEquals(i, queue.dequeue().intValue());
        }

        for (int i = count; i < count * 2; i++) {
            queue.enqueue(i);
        }

        for (int i = count / 2; i < count * 2; i++) {
            assertEquals(i, queue.dequeue().intValue());
        }
    }
}
