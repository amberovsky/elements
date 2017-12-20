package pro.amberovsky.elements.util.data;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Queue implementation with MAX API
 */
public class QueueWithMax<T extends Comparable<T>> {
    private LinkedList<T> queue;
    private ArrayDeque<T> max;

    /**
     * Constructor
     */
    public QueueWithMax() {
        queue = new LinkedList<>();
        max = new ArrayDeque<>();
    }

    /**
     * Enqueue element
     *
     * @Complexity O(1) amortized, O(n) space
     *
     * @param element element
     */
    public void enqueue(T element) {
        queue.add(element);

        while ((!max.isEmpty()) && (element.compareTo(max.peekLast()) > 0)) max.removeLast();
        max.add(element);
    }

    /**
     * Dequeue
     *
     * @return next element
     */
    public T dequeue() {
        T element = queue.remove();
        if (element.compareTo(max.peekFirst()) == 0) {
            max.removeFirst();
        }

        return element;
    }

    /**
     * @return size of the queue
     */
    public int size() {
        return queue.size();
    }

    /**
     * @return maximum element in the queue
     */
    public T max() {
        return max.peekFirst();
    }
}
