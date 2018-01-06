package pro.amberovsky.elements.util;

/**
 * Auxiliary methods
 */
public class Utilities {

    /**
     * Swap 2 elements in an array
     *
     * @param array array
     * @param from from index
     * @param to to index
     *
     * @return array with swapped elements
     */
    public static int[] swap(int[] array, final int from, final int to) {
        int t = array[to];
        array[to] = array[from];
        array[from] = t;

        return array;
    }

    /**
     * Swap 2 elements in a 2D-array
     *
     * @param array array
     * @param r1 row-coordinate of first element
     * @param c1 column-coordinate of first element
     * @param r2 row-coordinate of second element
     * @param c2 column-coordinate of second element
     * @param <T> type
     *
     * @return array with swapped elements
     */
    public static <T> T[][] swap2D(T[][] array, final int r1, final int c1, final int r2, final int c2) {
        T t = array[r2][c2];
        array[r2][c2] = array[r1][c1];
        array[r1][c1] = t;

        return array;
    }

    /**
     * Swap 2 elements in a generic array
     *
     * @param array array
     * @param from from index
     * @param to to index
     *
     * @return array with swapped elements
     */
    public static <T> T[] swap(T[] array, final int from, final int to) {
        T t = array[to];
        array[to] = array[from];
        array[from] = t;

        return array;
    }


    /**
     * Reverse (sub)array
     *
     * @param array array
     * @param from from index, inclusive
     * @param to to index, inclusive
     * @param <T> type
     *
     * @return array
     */
    public static <T> T[] reverse(T[] array, int from, int to) {
        for (int i = from, j = to; i < j; i++, j--) {
            swap(array, i, j);
        }

        return array;
    }
}
