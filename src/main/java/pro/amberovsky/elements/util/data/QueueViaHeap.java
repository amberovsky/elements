package pro.amberovsky.elements.util.data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implement a queue using heap
 *
 * @param <T> type
 */
public class QueueViaHeap<T extends Comparable<T>> {
    /** Element in the queue */
    private class Entry {
        /** current index in the queue */
        int index;

        /** value */
        T value;

        /**
         * Constr
         *
         * @param index current index in the queue
         * @param value value
         */
        private Entry(int index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    /** min-heap */
    private PriorityQueue<Entry> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.index));

    /** last inserted id */
    private int lastId = 0;

    /**
     * Enqueue element
     *
     * @Complexity O(log n)
     *
     * @param elem element
     *
     * @return self
     */
    public QueueViaHeap<T> enqueue(T elem) {
        minHeap.add(new Entry(lastId++, elem));

        return this;
    }

    /**
     * Dequeue element
     *
     * @Complexity O(log n)
     *
     * @return next element
     */
    public T dequeue() {
        return minHeap.remove().value;
    }

    /**
     * @Complexity O(1)
     *
     * @return size of the queue
     */
    public int size() {
        return minHeap.size();
    }
}
