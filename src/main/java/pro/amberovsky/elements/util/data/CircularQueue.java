package pro.amberovsky.elements.util.data;

/**
 * A queue over an array with dynamical resizing
 */
public class CircularQueue<T> {
    /** current queue size */
    private int size;

    /** queue data */
    public Object data[];

    /** pointer to the current head */
    private int head;

    /** pointer to the next place in the array after last element */
    private int tail;

    /** minimum queue size */
    public final static int MINIMUM_ELEMENTS = 2;

    /**
     * Constructor
     */
    public CircularQueue() {
        size = 0;
        head = 0;
        tail = 0;
        data = new Object[MINIMUM_ELEMENTS];
    }

    /**
     * Enqueue element and resize, if needed
     *
     * @param element element
     */
    public void enqueue(T element) {
        if (size == data.length) {
            Object newData[] = new Object[data.length * 2];
            System.arraycopy(data, head, newData, 0, data.length - head);
            System.arraycopy(data, 0, newData, data.length - head, tail);
            head = 0;
            tail = data.length;
            data = newData;
        }

        data[tail] = element;
        tail = (tail + 1) % data.length;

        size++;
    }

    /**
     * Dequeue and resize, if needed
     *
     * @return next element
     */
    public T dequeue() {
        T element = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;

        if ((size * 2 == data.length) && (size >= MINIMUM_ELEMENTS)) {
            Object newData[] = new Object[size];
            if (head < tail) {
                System.arraycopy(data, head, newData, 0, size);
            } else {
                System.arraycopy(data, head, newData, 0, data.length - head);
                System.arraycopy(data, 0, newData, data.length - head, tail);
            }

            head = 0;
            tail = 0;
            data = newData;
        }

        return element;
    }

    /**
     * @return size of the queue
     */
    public int size() {
        return size;
    }
}
