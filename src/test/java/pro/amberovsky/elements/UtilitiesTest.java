package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.amberovsky.elements.util.Utilities.*;

class UtilitiesTest {
    /*
    SWAP
     */
    @Test
    void testSwap() {
        assertArrayEquals(new int[] { 1 }, swap(new int[] { 1 }, 0, 0));
        assertArrayEquals(new int[] { 2, 1 }, swap(new int[] { 1, 2 }, 0, 1));
        assertArrayEquals(new int[] { 1, 3, 2, 4 }, swap(new int[] { 1, 2, 3, 4 }, 1, 2));
    }

    @Test
    void testSwap2D() {
        assertArrayEquals(new Integer[][] { { 1 } }, swap2D(new Integer[][] { { 1 } }, 0, 0, 0, 0));
        assertArrayEquals(new Integer[][] { { 2 } , { 1 } }, swap2D(new Integer[][] { { 1 }, { 2 } }, 0, 0, 1, 0));
        assertArrayEquals(new Integer[][] { { 1, 3 }, { 2, 4 } }, swap2D(new Integer[][] { { 1, 2 }, { 3, 4 } }, 0, 1, 1, 0));
    }

    @Test
    void testGenericSwap() {
        assertArrayEquals(new Integer[] { 1 }, swap(new Integer[] { 1 }, 0, 0));
        assertArrayEquals(new Integer[] { 2, 1 }, swap(new Integer[] { 1, 2 }, 0, 1));
        assertArrayEquals(new Integer[] { 1, 3, 2, 4 }, swap(new Integer[] { 1, 2, 3, 4 }, 1, 2));
    }
}
