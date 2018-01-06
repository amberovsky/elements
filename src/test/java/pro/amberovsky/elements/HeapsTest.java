package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.amberovsky.elements.Heaps.*;

class HeapsTest {
    /*
    BOOTCAMP
     */
    @Test
    void testKLongestString() {
        assertArrayEquals(new String[] { "xx", "qwe" }, kLongestStrings(Stream.of("qwe", "xx"), 10));

        assertArrayEquals(new String[] { "1234567", "12345678" }, kLongestStrings(Stream.of("qwe", "123456", "c", "1234567", "12345678"), 2));
    }



    /*
    MERGE SORTED FILES
     */
    @Test
    void testMergeSortedFiles() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                mergeSortedFiles(Arrays.asList(
                        new Integer[] { 1, 5, 10 },
                        new Integer[] { 7, 8 },
                        new Integer[] { 9 },
                        new Integer[] { 2, 3, 4, 6 }
                ))
        );
    }



    /*
    SORT AN INCREASING-DECREASING ARRAY
     */
    @Test
    void testSortAnIncreasingDecreasingArray() {
        assertEquals(Arrays.asList(57, 131, 190, 221, 294, 339, 418, 442, 452, 493), sortAnIncreasingDecreasingArray(new Integer[] { 57, 131, 493, 294, 221, 339, 418, 452, 442, 190 }));
    }



    /*
    SORT AN ALMOST-SORTED ARRAY
     */
    @Test
    void testSortAnAlmostSortedArray() {
        assertArrayEquals(new Integer[] { -1, 2, 3, 4, 5, 6, 8 }, sortAnAlmostSortedArray(new Integer[] { 3, -1, 2, 6, 4, 5, 8 }, 3));
    }



    /*
    COMPUTE THE k CLOSEST STARS
     */
    @Test
    void testComputeTheKClosestStars() {
        assertArrayEquals(new Integer[] { 9, 5, 3 }, computeTheKClosestStars(new Integer[] { 3, 100, 9, 500, 10, 18, 5 }, 3));
    }

    @Test
    void testComputeTheKClosestStars_KthLargestElements() {
        assertEquals(
                java.util.Arrays.asList(14, 18, 18, 100, 100),
                computeTheKClosestStars_KthLargestElements(
                        new Integer[] {
                                100, 14, 18, 18, 500, 5
                        },
                        2
                )
        );
    }



    /*
    COMPUTE THE MEDIAN OF ONLINE DATA
     */
    @Test
    void testComputeTheMedianOfOnlineData() {
        assertEquals(
                java.util.Arrays.asList(1.0, 0.5, 1.0, 2.0, 2.0, 1.5, 1.0),
                computeTheMedianOfOnlineData(java.util.Arrays.asList(1, 0, 3, 5, 2, 0, 1).iterator())
        );
    }



    /*
    COMPUTE THE k LARGEST ELEMENTS IN A MAX-HEAP
     */
    @Test
    void testComputeTheLLargestElementsInAMaxHeap() {
        assertArrayEquals(
                new Integer[] { 1 },
                computeTheLargestElementsInAMaxHeap(new Integer[] { 1 }, 1)
        );

        assertArrayEquals(
                new Integer[] { 500, 400, 300 },
                computeTheLargestElementsInAMaxHeap(new Integer[] { 500, 100, 400, 50, 10, 300 }, 3)
        );

    }
}