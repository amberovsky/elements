package pro.amberovsky.elements.util.data;

import java.util.LinkedList;

/**
 * Queue implementation using already implemented stack
 */
public class StackQueue<T> {
    private LinkedList<T> currentStack;
    private LinkedList<T> bufferStack;

    /**
     * Constructor
     */
    public StackQueue() {
        currentStack = new LinkedList<>();
        bufferStack = new LinkedList<>();
    }

    /**
     * Enqueue element
     *
     * @param element element
     */
    public void enqueue(T element) {
        bufferStack.addFirst(element);
    }

    /**
     * Dequeue
     *
     * @return next element
     */
    public T dequeue() {
        if (currentStack.isEmpty()) {
            while (!bufferStack.isEmpty()) {
                currentStack.addFirst(bufferStack.removeFirst());
            }
        }

        return currentStack.removeFirst();
    }

    /**
     * @return size of the queue
     */
    public int size() {
        return currentStack.size() + bufferStack.size();
    }
}
