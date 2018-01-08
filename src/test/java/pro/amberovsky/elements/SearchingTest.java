package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.oneOf;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static pro.amberovsky.elements.Searching.*;

class SearchingTest {
    /*
    SEARCH A SORTED ARRAY FOR FIRST OCCURRENCE OF k
     */
    @Test
    void testFirstOccurrenceOfK() {
        assertEquals(0, firstOccurrenceOfK(new int[] { 1 }, 1));
        assertEquals(0, firstOccurrenceOfK(new int[] { 1, 1, 1, 1, 1 }, 1));
        assertEquals(2, firstOccurrenceOfK(new int[] { 1, 1, 5, 5, 5, 5, 5, 5 }, 5));
        assertEquals(3, firstOccurrenceOfK(new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 }, 108));
    }



    /*
    SEARCH A SORTED ARRAY FOR ENTRY EQUAL TO ITS INDEX
     */
    @Test
    void testSearchASortedArrayForEntryEqualToItsIndex() {
        assertEquals(-1, searchASortedArrayForEntryEqualToItsIndex(new int[] { 4 }));
        assertEquals(-1, searchASortedArrayForEntryEqualToItsIndex(new int[] { 4, 5 }));
        assertEquals(-1, searchASortedArrayForEntryEqualToItsIndex(new int[] { 4, 5, 100 }));

        assertEquals(0, searchASortedArrayForEntryEqualToItsIndex(new int[] { 0 }));
        assertEquals(0, searchASortedArrayForEntryEqualToItsIndex(new int[] { 0, 4 }));

        assertThat(
                searchASortedArrayForEntryEqualToItsIndex(new int[] { -2, 0, 2, 3, 6, 7, 9 }),
                is(oneOf(2, 3))
        );
    }



    /*
    SEARCH A CYCLICALLY SORTED ARRAY
     */
    @Test
    void testSearchACyclicallySortedArray() {
        assertEquals(0, searchACyclicallySortedArray(new int[] { 3 }));
        assertEquals(0, searchACyclicallySortedArray(new int[] { 3, 9 }));
        assertEquals(1, searchACyclicallySortedArray(new int[] { 9, 3 }));
        assertEquals(
                4,
                searchACyclicallySortedArray(new int[] { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 })
        );
    }



    /*
    COMPUTE THE INTEGER SQUARE ROOT
     */
    @Test
    void testSquareRoot() {
        assertEquals(0, squareRoot(0));
        assertEquals(1, squareRoot(1));
        assertEquals(3, squareRoot(9));
        assertEquals(4, squareRoot(23));
    }



    /*
    COMPUTE THE REAL SQUARE ROOT
     */
    @Test
    void testSquareRootReal() {
        assertEquals(0.0, squareRoot(0.0), 0.001);
        assertEquals(1.0, squareRoot(1.0), 0.001);
        assertEquals(3.0, squareRoot(9.0), 0.001);
        assertEquals(4.795, squareRoot(23.0), 0.001);
    }



    /*
    SEARCH IN A 2D SORTED ARRAY
     */
    @Test
    void testSearchInA2dSortedArray() {
        assertTrue(searchInA2dSortedArray(new int[][] { { 1 } }, 1));
        assertFalse(searchInA2dSortedArray(new int[][] { { 1 } }, 3));

        assertFalse(searchInA2dSortedArray(
                new int[][] {
                        { 1,  2,  4,  4,  6 },
                        { 1,  5,  5,  9, 21 },
                        { 3,  6,  6,  9, 22 },
                        { 3,  6,  8, 10, 24 },
                        { 6,  8,  9, 12, 25 },
                        { 8, 10, 12, 13, 40 },
                        },
                7)
        );

        assertTrue(searchInA2dSortedArray(
                new int[][] {
                        { 1,  2,  4,  4,  6 },
                        { 1,  5,  5,  9, 21 },
                        { 3,  6,  6,  9, 22 },
                        { 3,  6,  8, 10, 24 },
                        { 6,  8,  9, 12, 25 },
                        { 8, 10, 12, 13, 40 },
                },
                8)
        );
    }



    /*
    FIND THE MIN AND MAX SIMULTANEOUSLY
     */
    @Test
    void testFindTheMinAndMaxSimultaneously() {
        assertArrayEquals(new int[] { 1, 1 }, findTheMinAndMaxSimultaneously(new int[] { 1 }));
        assertArrayEquals(new int[] { 1, 2 }, findTheMinAndMaxSimultaneously(new int[] { 2, 1 }));

        assertArrayEquals(new int[] { 1, 5 }, findTheMinAndMaxSimultaneously(new int[] { 3, 2, 5, 1, 2, 4 }));
    }



    /*
    FIND THE kTH LARGEST ELEMENT
     */
    @Test
    void testQuickselect() {
        assertEquals(1, quickselect(new int[] { 1 }, 1));
        assertEquals(-1, quickselect(new int[] { 1 }, 2));

        assertEquals(2, quickselect(new int[] { 1, 2 }, 1));
        assertEquals(1, quickselect(new int[] { 1, 2 }, 2));

        assertEquals(2, quickselect(new int[] { 2, 1 }, 1));

        assertEquals(5, quickselect(new int[] { 3, 2, 1, 5, 4 }, 1));
        assertEquals(4, quickselect(new int[] { 3, 2, 1, 5, 4 }, 2));
        assertEquals(3, quickselect(new int[] { 3, 2, 1, 5, 4 }, 3));
        assertEquals(2, quickselect(new int[] { 3, 2, 1, 5, 4 }, 4));
        assertEquals(1, quickselect(new int[] { 3, 2, 1, 5, 4 }, 5));
    }



    /*
    FIND THE DUPLICATE AND MISSING ELEMENTS
     */
    @Test
    void testFindTheDuplicateAndMissingElements() {
        assertArrayEquals(new int[] { 1, 2 }, findTheDuplicateAndMissingElements(new int[] { 0, 1, 1 }));
    }
}