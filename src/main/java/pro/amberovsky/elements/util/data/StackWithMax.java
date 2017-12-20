package pro.amberovsky.elements.util.data;

import java.util.LinkedList;

/**
 * Implement a stack with max API
 *
 * @param <T> type
 */
public class StackWithMax<T extends Comparable<T>> {
    /** stack implementation */
    private LinkedList<T> list = new LinkedList<>();

    /** tracking of max element */
    private LinkedList<T> max = new LinkedList<>();

    /**
     * Push on the top
     *
     * @param elem element
     *
     * @return self
     */
    public StackWithMax<T> push(T elem) {
        list.push(elem);

        if ((max.size() == 0) || (max.peek().compareTo(elem) <= 0)) max.push(elem);
        else max.push(max.peek());

        return this;
    }

    /**
     * @return element from the top
     */
    public T pop() {
        max.pop();
        return list.pop();
    }

    /**
     * @return current maximum value
     */
    public T max() {
        return max.peek();
    }
}
