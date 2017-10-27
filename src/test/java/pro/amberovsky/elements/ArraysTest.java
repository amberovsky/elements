package pro.amberovsky.elements;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class ArraysTest {
    /*
    SWAP
     */
    @Test
    public void testSwap() {
        assertArrayEquals(new int[] { 1 }, Arrays.swap(new int[] { 1 }, 0, 0));
        assertArrayEquals(new int[] { 2, 1 }, Arrays.swap(new int[] { 1, 2 }, 0, 1));
        assertArrayEquals(new int[] { 1, 3, 2, 4 }, Arrays.swap(new int[] { 1, 2, 3, 4 }, 1, 2));
    }



    /*
    REORDER ARRAY
     */
    @DataProvider
    public static Object[] dataProviderForReorderEven() {
        return new Object[] {
                new int[] { 1 },
                new int[] { 1, 2 },
                new int[] { 1, 2, 3 },
                new int[] { 1, 2, 3, 4, 5, 6 }
        };
    }

    @Test
    @UseDataProvider("dataProviderForReorderEven")
    public void testReorderEven(int[] array) {
        int[] reorderedArray = Arrays.reorderEven(array);

        for (int i = 0; i < reorderedArray.length / 2; i++) assertEquals(0, reorderedArray[i] % 2);
        for (int i = (reorderedArray.length + 1) / 2; i < reorderedArray.length; i++) assertEquals(1, reorderedArray[i] % 2);
    }



    /*
    DUTCH FLAG with variants
     */
    @DataProvider
    public static Object[] dataProviderForDutchFlag() {
        return new Object[] {
                new Object[] { new int[] { 0, 1, 2, 0, 2, 1, 1 }, 3 },
                new Object[] { new int[] { 1 }, 0 },
                new Object[] { new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 0 },
                new Object[] { new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 8 }
        };
    }

    enum DUTCH_FLAG_CHECKING_STATUS { LESS, EQUAL, GREATER }

    @Test
    @UseDataProvider("dataProviderForDutchFlag")
    public void testDutchFlag(Object[] data) {
        int[] array = (int[]) data[0];
        int pivotIndex = (int) data[1];
        int pivot = array[pivotIndex];
        DUTCH_FLAG_CHECKING_STATUS status = DUTCH_FLAG_CHECKING_STATUS.LESS;

        Arrays.DutchFlag(array, pivotIndex);

        for (int elem : array) {
            switch (status) {
                case LESS:
                    if (elem >= pivot) status = DUTCH_FLAG_CHECKING_STATUS.EQUAL;

                    break;

                case EQUAL:
                    assertTrue(elem >= pivot);

                    if (elem > pivot) status = DUTCH_FLAG_CHECKING_STATUS.GREATER;
                    break;

                case GREATER:
                    assertTrue(elem > pivot);
                    break;
            }
        }

    }


    /* Elements can have only one of three values */
    enum DUTCH_FLAG_ONLY_THREE_VALUES_CHECKING_STATUS { VALUE1, VALUE2, VALUE3 }

    @DataProvider
    public static Object[] dataProviderForDutchFlag_OnlyThreeValues() {
        return new Object[] {
                new Object[] { new int[] { 0, 1, 2, 0, 2, 1, 1 }, 0, 1, 2 },
                new Object[] { new int[] { 1 }, 1, 1, 1 },
                new Object[] { new int[] { 6, 8, 6, 6, 6, 6, 6, 6, 6 }, 6, 7, 8 },
                new Object[] { new int[] { 9, 9, 2, 2, 1, 1, 2, 1, 1 }, 1, 2, 9 }
        };
    }

    @Test
    @UseDataProvider("dataProviderForDutchFlag_OnlyThreeValues")
    public void testDutchFlag_OnlyThreeValues(Object[] data) {
        int[] array = (int[]) data[0];
        int value1 = (int) data[1];
        int value2 = (int) data[2];
        int value3 = (int) data[3];

        DUTCH_FLAG_ONLY_THREE_VALUES_CHECKING_STATUS status = DUTCH_FLAG_ONLY_THREE_VALUES_CHECKING_STATUS.VALUE1;

        Arrays.DutchFlag_OnlyThreeValues(array, value1, value2, value3);

        for (int elem : array) {
            switch (status) {
                case VALUE1:
                    assertTrue((elem == value1) || (elem == value2) || (elem == value3));
                    if (elem != value1) status = DUTCH_FLAG_ONLY_THREE_VALUES_CHECKING_STATUS.VALUE2;
                    break;

                case VALUE2:
                    assertTrue((elem == value2) || (elem == value3));
                    if (elem == value3) status = DUTCH_FLAG_ONLY_THREE_VALUES_CHECKING_STATUS.VALUE3;
                    break;

                case VALUE3:
                    assertTrue(elem == value3);
                    break;
            }
        }
    }

    /* Elements can have only one of four values */
    enum DUTCH_FLAG_ONLY_FOUR_VALUES_CHECKING_STATUS { VALUE1, VALUE2, VALUE3, VALUE4 }

    @DataProvider
    public static Object[] dataProviderForDutchFlag_OnlyFourValues() {
        return new Object[] {
                new Object[] { new int[] { 0, 1, 2, 0, 2, 1, 1, 5 }, 0, 1, 2, 5 },
                new Object[] { new int[] { 1 }, 1, 1, 1, 1 },
                new Object[] { new int[] { 6, 8, 6, 6, 6, 6, 6, 6, 6 }, 6, 7, 8, 9 },
                new Object[] { new int[] { 9, 9, 2, 2, 1, 4, 4, 4, 1, 2, 1, 1, 4 }, 1, 2, 9, 4 }
        };
    }

    @Test
    @UseDataProvider("dataProviderForDutchFlag_OnlyFourValues")
    public void testDutchFlag_OnlyFourValues(Object[] data) {
        int[] array = (int[]) data[0];
        int value1 = (int) data[1];
        int value2 = (int) data[2];
        int value3 = (int) data[3];
        int value4 = (int) data[4];

        DUTCH_FLAG_ONLY_FOUR_VALUES_CHECKING_STATUS status = DUTCH_FLAG_ONLY_FOUR_VALUES_CHECKING_STATUS.VALUE1;

        Arrays.DutchFlag_OnlyFourValues(array, value1, value2, value3, value4);

        for (int elem : array) {
            switch (status) {
                case VALUE1:
                    assertTrue((elem == value1) || (elem == value2) || (elem == value3) || (elem == value4));
                    if (elem != value1) status = DUTCH_FLAG_ONLY_FOUR_VALUES_CHECKING_STATUS.VALUE2;
                    break;

                case VALUE2:
                    assertTrue((elem == value2) || (elem == value3) || (elem == value4));
                    if (elem == value3) status = DUTCH_FLAG_ONLY_FOUR_VALUES_CHECKING_STATUS.VALUE3;
                    break;

                case VALUE3:
                    assertTrue((elem == value3) || (elem == value4));
                    if (elem == value4) status = DUTCH_FLAG_ONLY_FOUR_VALUES_CHECKING_STATUS.VALUE4;
                    break;

                case VALUE4:
                    assertTrue(elem == value4);
                    break;
            }
        }
    }

    /* Elements can be only 0/1 (false/true) */
    enum DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS { FALSE, TRUE }

    @DataProvider
    public static Object[] dataProviderForDutchFlag_OnlyTwoValues() {
        return new Object[] {
                new int[] { 0, 1, 1, 0, 1, 1, 1, 0 },
                new int[] { 1 },
                new int[] { 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                new int[] { 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }
        };
    }

    @Test
    @UseDataProvider("dataProviderForDutchFlag_OnlyTwoValues")
    public void testDutchFlag_OnlyTwoValues(int[] array) {
        DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS status = DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS.FALSE;

        Arrays.DutchFlag_OnlyTwoValues(array);

        for (int elem : array) {
            switch (status) {
                case FALSE:
                    assertTrue((elem == 0) || (elem == 1));
                    if (elem == 1) status = DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS.TRUE;
                    break;

                case TRUE:
                    assertTrue((elem == 1));
                    break;
            }
        }
    }

    /* Elements can be only 0/1 (false/true) and : false goes first and to maintain relative order of true */
    @DataProvider
    public static Object[] dataProviderForDutchFlag_OnlyTwoValuesKeepOrderOfOneValue() {
        return new Object[] {
                new int[] { 1 },
                new int[] { 0 },
                new int[] {  },
                new int[] { 1, 0, 0, 0 },
                new int[] { 0, 1, 1, 1 },
                new int[] { 1, 0, 1, 0 }
        };
    }

    @Test
    @UseDataProvider("dataProviderForDutchFlag_OnlyTwoValuesKeepOrderOfOneValue")
    public void testDutchFlag_OnlyTwoValuesKeepOrderOfOneValue(int[] array) {
        DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS status = DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS.FALSE;

        Arrays.DutchFlag_OnlyTwoValuesKeepOrderOfOneValue(array);

        for (int elem : array) {
            switch (status) {
                case FALSE:
                    assertTrue((elem == 0) || (elem == 1));
                    if (elem == 1) status = DUTCH_FLAG_ONLY_TWO_VALUES_CHECKING_STATUS.TRUE;
                    break;

                case TRUE:
                    assertTrue((elem == 1));
                    break;
            }
        }
    }



    /*
    INCREMENT AN ARBITRARY-PRECISION INTEGER
     */
    @DataProvider
    public static Object[] dataProviderForAddOne() {
        return new Object[] {
                new Object[] { new Integer[] { 1, 2, 9 }, new Integer[] { 1, 3, 0 } },
                new Object[] { new Integer[] { 0 }, new Integer[] { 1 } },
                new Object[] { new Integer[] { -1 }, new Integer[] { 0 } },
                new Object[] { new Integer[] { 9, 9, 9 }, new Integer[] { 1, 0, 0, 0 } }
        };
    }

    @Test
    @UseDataProvider("dataProviderForAddOne")
    public void testAddOne(Object[] data) {
        List<Integer> array = new ArrayList<>(java.util.Arrays.asList((Integer[]) data[0]));
        Arrays.addOne(array);
        List<Integer> result = java.util.Arrays.asList((Integer[]) data[1]);

        assertEquals(array.size(), result.size());
        for (int i = 0; i < array.size(); i++) assertEquals(array.get(i), result.get(i));
    }

    /*
    Add two numbers in binary representation
     */
    @DataProvider
    public static Object[] dataProviderForAddOne_TwoBinaryNumbers() {
        return new Object[] {
                new Object[] { "00", "00", "00" },
                new Object[] { "0", "1", "1" },
                new Object[] { "11", "00", "11" },
                new Object[] { "11", "10", "101" },
                new Object[] { "11", "11", "110"},
                new Object[] { "11", "1", "100"}
        };
    }

    @Test
    @UseDataProvider("dataProviderForAddOne_TwoBinaryNumbers")
    public void testAddOne_TwoBinaryNumbers(Object[] data) {
        String number1 = (String) data[0];
        String number2 = (String) data[1];
        String result = Arrays.addOne_TwoBinaryNumbers(number1, number2);
        String shouldBe = (String) data[2];

        assertEquals(shouldBe.length(), result.length());

        for (int i = 0; i < result.length(); i++) assertEquals(shouldBe.charAt(i), result.charAt(i));
    }
}