package pro.amberovsky.elements;

import java.util.*;
import java.util.stream.Stream;

/**
 * Various tasks on heaps
 */
class Heaps {
    /*
    BOOTCAMP
     */

    /**
     * Produce top k string with biggest length
     *
     * @Algorithm Min-heap
     * @Complexity O(n * log k), O(k) space
     *
     * @param stream stream of string
     * @param k how many strings to produce
     *
     * @return array of top k strings
     */
    static String[] kLongestStrings(Stream<String> stream, int k) {
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator.comparingInt(String::length));

        stream.forEach(string -> {
            if (heap.size() < k) heap.add(string);
            else if (heap.peek().length() < string.length()) {
                heap.poll();
                heap.add(string);
            }
        });

        return heap.toArray(new String[0]);
    }



    /*
    MERGE SORTED FILES
     */

    /**
     * Helper class
     */
    private static class SortedFilesEntry {
        /** index of the element in the files array */
        int fileIndex;

        /** index of the element in the file array */
        int arrayIndex;

        /**
         * Constr
         *
         * @param fileIndex index of the element in the files array
         * @param arrayIndex index of the element in the file array
         */
        SortedFilesEntry(int fileIndex, int arrayIndex) {
            this.fileIndex = fileIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    /**
     * Merge sorted sequences
     *
     * @Algorithm Min-heap
     * @Complexity O(n * log k), O(k) space
     *
     * @param files array of sorted sequences
     *
     * @return merged sorted sequences
     */
    static List<Integer> mergeSortedFiles(List<Integer[]> files) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<SortedFilesEntry> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> files.get(e.fileIndex)[e.arrayIndex]));

        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).length > 0) minHeap.add(new SortedFilesEntry(i, 0));
        }

        while (!minHeap.isEmpty()) {
            SortedFilesEntry entry = minHeap.poll();

            Integer[] file = files.get(entry.fileIndex);
            if (file.length > entry.arrayIndex + 1) {
                minHeap.add(new SortedFilesEntry(entry.fileIndex, entry.arrayIndex + 1));
            }

            result.add(file[entry.arrayIndex]);
        }

        return result;
    }



    /*
    SORT AN INCREASING-DECREASING ARRAY
     */
    /** Current order of elements in the array */
    private enum ORDER {
        INCREASING, // increasing order
        DECREASING // decreasing order
    }

    /**
     * Sort a k-increasing-decreasing array
     *
     * @Algorithm Min-heap
     * @Complexity O(n * log k), O(n) space
     *
     * @param array k-increasing-decreasing array
     *
     * @return sorted array
     */
    static List<Integer> sortAnIncreasingDecreasingArray(Integer array[]) {
        List<List<Integer>> subArrays = new LinkedList<>();
        List<Integer> currentList = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        currentList.add(array[0]);
        subArrays.add(currentList);

        ORDER order = ORDER.INCREASING;
        for (int i = 1; i < array.length; i++) {
            if (order == ORDER.INCREASING) {
                if (array[i] < array[i - 1]) {
                    order = ORDER.DECREASING;
                    currentList = new LinkedList<>();
                    subArrays.add(currentList);
                }
            } else {
                if (array[i] > array[i - 1]) {
                    order = ORDER.INCREASING;
                    Collections.reverse(currentList);
                    currentList = new LinkedList<>();
                    subArrays.add(currentList);
                }
            }

            currentList.add(array[i]);
        }

        if (order == ORDER.DECREASING) {
            Collections.reverse(currentList);
        }

        PriorityQueue<SortedFilesEntry> minQueue =
                new PriorityQueue<>(Comparator.comparingInt(e -> subArrays.get(e.fileIndex).get(e.arrayIndex)));

        for (int i = 0; i < subArrays.size(); i++) {
            if (subArrays.get(i).size() > 0) minQueue.add(new SortedFilesEntry(i, 0));
        }

        while (!minQueue.isEmpty()) {
            SortedFilesEntry entry = minQueue.poll();
            List<Integer> subArray = subArrays.get(entry.fileIndex);
            result.add(subArray.get(entry.arrayIndex));

            if (subArray.size() > entry.arrayIndex + 1) minQueue.add(new SortedFilesEntry(entry.fileIndex, entry.arrayIndex + 1));
        }

        return result;
    }



    /*
    SORT AN ALMOST-SORTED ARRAY
     */

    /**
     * Sort an almost sorted array
     *
     * @Algorithm Min-heap
     * @Complexity O(n * log k), O(n) space
     *
     * @param array k-sorted array
     * @param k k
     *
     * @return sorted array
     */
    static Integer[] sortAnAlmostSortedArray(Integer array[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Integer result[] = new Integer[array.length];
        int resultIndex = 0;

        int index = 0;
        for (; index < Math.min(array.length, k + 1); index++) minHeap.add(array[index]);

        while (!minHeap.isEmpty()) {
            result[resultIndex++] = minHeap.poll();

            if (index < array.length) minHeap.add(array[index++]);
        }

        return result;
    }



    /*
    COMPUTE THE k CLOSEST STARS
     */

    /**
     * Compute the k closest stars
     *
     * @Algorithm Max-heap
     * @Complexity O(n * log k), O(k) space
     *
     * @param distances array with distances
     * @param k how many starts to return
     *
     * @return k stars with minimal distances
     */
    static Integer[] computeTheKClosestStars(Integer distances[], int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (Integer distance : distances) {
            maxHeap.add(distance);
            if (maxHeap.size() == k + 1) maxHeap.remove();
        }

        return maxHeap.toArray(new Integer[0]);
    }

    /**
     * Variant: output k-th largest integer from a sequence, starting from kth element
     *
     * @Algorithm Min-heap
     * @Complexity O(n * log k), O(k) space
     *
     * @param array array of integers
     * @param k k
     *
     * @return k-largest integers
     */
    static List<Integer> computeTheKClosestStars_KthLargestElements(Integer array[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        List<Integer> result = new ArrayList<>();

        int index = 0;

        while (index < k) minHeap.add(array[index++]);

        while (index < array.length) {
            result.add(minHeap.peek());
            minHeap.add(array[index]);
            minHeap.remove();

            index++;
        }

        result.add(minHeap.peek());

        return result;
    }



    /*
    COMPUTE THE MEDIAN OF ONLINE DATA
     */

    /**
     * Compute the median of online data
     *
     * @Algorithm Max0heap & Min-heap
     * @Complexity O(n * log n), O(n) space
     *
     * @param iterator online data
     *
     * @return running median
     */
    static List<Double> computeTheMedianOfOnlineData(Iterator<Integer> iterator) {
        List<Double> result = new ArrayList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (iterator.hasNext()) {
            minHeap.add(iterator.next());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }

            if (!minHeap.isEmpty() && (minHeap.peek() < maxHeap.peek())) {
                maxHeap.add(minHeap.remove());
                minHeap.add(maxHeap.remove());
            }

            result.add(minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek() * 1.0);
        }

        return result;
    }



    /*
    COMPUTE THE k LARGEST ELEMENTS IN A MAX-HEAP
     */

    /**
     * Compute the largest elements in a MaxHeap
     *
     * @Algorithm Array indices
     * @Complexity O(k * log k), O(k) space
     *
     * @param array max-heap represented by array
     * @param k how many elements to return
     *
     * @return k largest elements in a MaxHeap
     */
    static Integer[] computeTheLargestElementsInAMaxHeap(Integer[] array, int k) {
        Integer[] result = new Integer[k];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(i -> array[i])));
        maxHeap.add(0);

        for (int i = 0; i < k; i++) {
            Integer index = maxHeap.remove();

            result[i] = array[index];
            if (array.length > index * 2 + 1) maxHeap.add(index * 2 + 1);
            if (array.length > index * 2 + 2) maxHeap.add(index * 2 + 2);
        }

        return result;
    }
}
