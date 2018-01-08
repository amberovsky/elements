package pro.amberovsky.elements;

import java.util.Arrays;

import static pro.amberovsky.elements.util.Utilities.*;

/**
 * Various tasks on heaps
 */
class Searching {
    /*
    SEARCH A SORTED ARRAY FOR FIRST OCCURRENCE OF k
     */

    /**
     * Search a sorted array for first occurrence of k
     *
     * @Algorithm Binary search
     * @Complexity O(log n), O(1) space
     *
     * @param array array
     * @param k search element
     *
     * @return first occurrence
     */
    static int firstOccurrenceOfK(int array[], int k) {
        int start = 0;
        int end = array.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == k) {
                result = mid;
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }



    /*
    SEARCH A SORTED ARRAY FOR ENTRY EQUAL TO ITS INDEX
     */

    /**
     * Search a sorted array for entry equal to its index
     *
     * @Algorithm Binary search
     * @Complexity O(log n), O(1) space
     *
     * @param array sorted array
     *
     * @return index, -1 if not found
     */
    static int searchASortedArrayForEntryEqualToItsIndex(int array[]) {
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == mid) return mid;

            if (array[mid] > mid) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    static int searchASortedArrayForEntryEqualToItsIndex_Duplicates() {
        // TODO
        return -1;
    }



    /*
    SEARCH A CYCLICALLY SORTED ARRAY
     */

    /**
     * Search a cyclically sorted array
     *
     * @Algorithm Binary search
     * @Complexity O(log n), O(1) space
     *
     * @param array cyclically sorted array
     *
     * @return minimum element
     */
    static int searchACyclicallySortedArray(int array[]) {
        if (array.length == 1) return 0;

        int low = 0, high = array.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (array[mid] > array[high]) low = mid + 1;
            else high = mid; // 2 3 4 5 1
        }

        return low;
    }

    // Variant 1 : TODO
    // Variant 2 : TODO



    /*
    COMPUTE THE INTEGER SQUARE ROOT
     */

    /**
     * Compute the integer square root
     *
     * @Algorithm Binary search
     * @Complexity O(log n), O(1) space
     *
     * @param value integer
     *
     * @return square root
     */
    static int squareRoot(int value) {
        int low = 0, high = value;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid > value) high = mid - 1;
            else low = mid + 1;
        }

        return low - 1;
    }



    /*
    COMPUTE THE REAL SQUARE ROOT
     */

    /**
     * Compare two doubles
     *
     * @param a first double
     * @param b second double
     *
     * @return -1 if less, 0 of equal, 1 if greater
     */
    private static int compare(double a, double b) {
        double epsilon = 0.00001;

        double diff = (a - b) / b;
        return diff < -epsilon
                ? -1
                : (diff > epsilon ? 1 : 0);
    }

    /**
     * Compute the real square root
     *
     * @Algorithm Binary search
     * @Complexity O(log n/epsilon), O(1) space
     *
     * @param value double
     *
     * @return square root
     */
    static double squareRoot(double value) {
        double left, right;

        if (value < 1.0) {
            left = value;
            right = 1.0;
        } else {
            left = 1.0;
            right = value;
        }

        while (Double.compare(left, right) == -1) {
            double mid = left + (right - left) * 0.5;

            double square = mid * mid;
            int compareResult = compare(square, value);

            if (compareResult == 0) return mid;

            if (compareResult == -1) left = mid;
            else right = mid;
        }

        return left;
    }

    // Variant



    /*
    SEARCH IN A 2D SORTED ARRAY
     */

    /**
     * Search in a 2D sorted array
     *
     * @Algorithm One iteration
     * @Complexity O(n + m). O(1) space
     *
     * @param array 2D sorted array
     * @param number number to find
     *
     * @return true if exists, false otherwise
     */
    static boolean searchInA2dSortedArray(int array[][], int number) {
        int column = array[0].length - 1;
        int row = 0;

        while ((column != -1) && (row != array.length)) {
            if (array[row][column] == number) return true;

            if (array[row][column] < number) row++;
            else if (array[row][column] > number) column--;
        }

        return false;
    }



    /*
    FIND THE MIN AND MAX SIMULTANEOUSLY
     */

    /**
     * Find the min and max simultaneously
     *
     * @Algorithm Pairs comparison
     * @Complexity O(3/2 * n - 2), O(1) space
     *
     * @param array data
     *
     * @return [min, max]
     */
    static int[] findTheMinAndMaxSimultaneously(int array[]) {
        int result[] = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int MIN_INDEX = 0;
        int MAX_INDEX = 1;

        for (int i = 0; i < (array.length + 1) / 2; i += 2) {
            int min, max;

            if (i == array.length - 1) {
                min = max = array[i];
            } else {
                if (array[i] < array[i + 1]) {
                    min = array[i];
                    max = array[i + 1];
                } else {
                    min = array[i + 1];
                    max = array[i];
                }
            }

            if (result[MIN_INDEX] > min) result[MIN_INDEX] = min;
            if (result[MAX_INDEX] < max) result[MAX_INDEX] = max;
        }

        return result;
    }



    /*
    FIND THE kTH LARGEST ELEMENT
     */

    /**
     * Find the kth largest element
     *
     * @Algorithm Quickselect
     * @Complexity O(n), O(1) space
     *
     * @param array data
     * @param k kth largest element to find
     *
     * @return kth largest element
     */
    static int quickselect(int array[], int k) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int pivot = start + (end - start) / 2;

            int startComparing = start;
            int endComparing = end;
            int pivotValue = array[pivot];

            swap(array, pivot, endComparing);

            for (int i = startComparing; i < endComparing; i++) {
                if (array[startComparing] > pivotValue) swap(array, startComparing++, i);
            }

            swap(array, startComparing, endComparing);

            if (startComparing == k - 1) return array[startComparing];

            if (startComparing > k - 1) {
                end = startComparing - 1;
            } else {
                start = startComparing + 1;
            }
        }

        return -1;
    }



    /*
    FIND THE MISSING IP ADDRESS
     */

    /**
     * Find the missing IP address
     *
     * @Algorithm Countsort-like
     * @Complexity O(n), O(1) space
     *
     * @param sequence sequence of IPs
     *
     * @return missing IP address
     */
    static Integer findTheMissingIPAddress(Iterable<Integer> sequence) {
        int BUCKET_SIZE = 1 << 16;

        int buckets[] = new int [BUCKET_SIZE];

        for (int ip : sequence) {
            buckets[ip >> 16]++;
        }

        int index;
        for (index = 0; index < buckets.length; index++) {
            if (buckets[index] != BUCKET_SIZE) break;
        }

        buckets = new int[BUCKET_SIZE];
        for (int ip : sequence) {
            if ((ip >> 16) == index) buckets[(BUCKET_SIZE - 1) & ip]++;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == 0) return (index << 16) + i;
        }

        return -1;
    }



    /*
    FIND THE DUPLICATE AND MISSING ELEMENTS
     */

    /**
     * Find the duplicate and missing elements
     *
     * @Algorithm XOR
     * @Complexity O(n), O(1) storage
     *
     * @param array data
     *
     * @return [DUPLICATE, MISSING]
     */
    static int[] findTheDuplicateAndMissingElements(int array[]) {
        int shouldBe = 0;
        for (int i = 1; i < array.length; i++) shouldBe ^= i;

        int actual = array[0];
        for (int i = 1; i < array.length; i++) actual ^= array[i];

        int together = shouldBe ^ actual;


        int mask = together & (~(together - 1));

        int potential = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i & mask) == mask) {
                potential ^= i;
            }

            if ((array[i] & mask) == mask) {
                potential ^= array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == potential) {
                return new int[] { potential, together ^ potential };

            }
        }

        return new int[] { together ^ potential, potential };
    }
}
