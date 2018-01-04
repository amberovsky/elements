package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static pro.amberovsky.elements.HonorsClass.*;

class HonorsClassTest {
    /*
    FIND THE FIRST MISSING POSITIVE ENTRY
     */
    @Test
    void testFindTheFirstMissingPositiveEntry() {
        assertEquals(1, findTheFirstMissingPositiveEntry(new int[] { 3, 4, 0, 2 }));
        assertEquals(2, findTheFirstMissingPositiveEntry(new int[] { 3, 5, 4, -1, 5, 1, -1 }));
    }

    /*
    COMPUTE THE MAXIMUM PRODUCT OF ALL ENTRIES BUT ONE
    */
    private static Stream<Arguments> sourceForMaximumProductOfAllEntriesButOne() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2 }, 2),
                Arguments.of(new Integer[] { 1, -2, -3, -4, 10 }, 120),
                Arguments.of(new Integer[] { 0, 1 }, 1),
                Arguments.of(new Integer[] { -10, -25, -5 }, 250),
                Arguments.of(new Integer[] { -10, -25, -5, -4 }, -200),
                Arguments.of(new Integer[] { 100, 0, 2, 0 }, 0),
                Arguments.of(new Integer[] { 3, 2, 4, 5 }, 60),
                Arguments.of(new Integer[] { 3, 2, -1, 4 }, 24),
                Arguments.of(new Integer[] { 3, 2, -1, 4, -1, 6 }, 72)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForMaximumProductOfAllEntriesButOne")
    void testMaximumProductOfAllEntriesButOneBySuffixArray(Integer[] array, Integer expected) {
        assertEquals(expected, maximumProductOfAllEntriesButOneBySuffixArray(array));
    }

    @ParameterizedTest
    @MethodSource("sourceForMaximumProductOfAllEntriesButOne")
    void testMaximumProductOfAllEntriesButOneByCountingZeroAndNegatives(Integer[] array, Integer expected) {
        assertEquals(expected, maximumProductOfAllEntriesButOneByCountingZeroAndNegatives(array));
    }

    @Test
    void testMaximumProductOfAllEntriesButOne_ExceptI() {
        assertArrayEquals(new Integer[] { 2, 1 }, maximumProductOfAllEntriesButOne_ExceptI(new Integer[] { 1, 2 }));
        assertArrayEquals(new Integer[] { -200, 20, -50, 40 }, maximumProductOfAllEntriesButOne_ExceptI(new Integer[] { -1, 10, -4, 5 }));
    }



    /*
    ROTATE AN ARRAY
     */
    @Test
    void testRotateAnArray() {
        assertArrayEquals(new Integer[] { 1 }, rotateAnArray(new Integer[] { 1 }, 0));
        assertArrayEquals(new Integer[] { 1 }, rotateAnArray(new Integer[] { 1 }, 1));
        assertArrayEquals(new Integer[] { 1 }, rotateAnArray(new Integer[] { 1 }, 2));


        assertArrayEquals(new Integer[] { 2, 1 }, rotateAnArray(new Integer[] { 1, 2 }, 1));

        assertArrayEquals(new Integer[] { 3, 4, 5, 1, 2 }, rotateAnArray(new Integer[] { 1, 2, 3, 4, 5 }, 3));
    }



    /*
    IDENTIFY POSITIONS ATTACKED BY ROOKS
     */
    @Test
    void testIdentifyPositionsAttackedByRooks() {
        assertArrayEquals(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 0, 1, 1 },
            }, identifyPositionsAttackedByRooks(new int[][] {
                { 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }
            }));
    }



    /*
    JUSTIFY TEXT
     */
    @Test
    void testJustifyText() {
        assertEquals(
                java.util.Arrays.asList(
                        "The   quick", "brown   fox", "jumped over", "the    lazy", "dogs.      "
                ),
                justifyText(
                        new String[] { "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs." },
                        11
                )
        );
    }
}
