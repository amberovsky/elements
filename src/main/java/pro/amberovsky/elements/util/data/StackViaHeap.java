package pro.amberovsky.elements.util.data;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implement a stack using heap
 *
 * @param <T> type
 */
public class StackViaHeap<T extends Comparable<T>> {
    /** Element in the stack */
    private class Entry {
        /** current index in the stack */
        int index;

        /** value */
        T value;

        /**
         * Constr
         *
         * @param index current index in the stack
         * @param value value
         */
        private Entry(int index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    /** max-heap */
    private PriorityQueue<Entry> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(e -> e.index)));

    /**
     * Push on the top
     *
     * @Complexity O(log n)
     *
     * @param elem element
     *
     * @return self
     */
    public StackViaHeap<T> push(T elem) {
        maxHeap.add(new Entry(maxHeap.size(), elem));

        return this;
    }

    /**
     * @Complexity O(log n)
     *
     * @return element from the top
     */
    public T pop() {
        return maxHeap.remove().value;
    }

    /**
     * @Complexity O(1)
     *
     * @return size of the stack
     */
    public int size() {
        return maxHeap.size();
    }
}
