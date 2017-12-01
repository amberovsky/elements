package pro.amberovsky.elements;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import pro.amberovsky.elements.util.Function.RandomSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

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

    @Test
    public void testGenericSwap() {
        assertArrayEquals(new Integer[] { 1 }, Arrays.swap(new Integer[] { 1 }, 0, 0));
        assertArrayEquals(new Integer[] { 2, 1 }, Arrays.swap(new Integer[] { 1, 2 }, 0, 1));
        assertArrayEquals(new Integer[] { 1, 3, 2, 4 }, Arrays.swap(new Integer[] { 1, 2, 3, 4 }, 1, 2));
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



    /*
    MULTIPLY TWO ARBITRARY-PRECISION INTEGERS
     */
    @Test
    public void testMultiply() {
        assertEquals(java.util.Arrays.asList(0), Arrays.multiply(java.util.Arrays.asList(0), java.util.Arrays.asList(0)));
        assertEquals(java.util.Arrays.asList(0), Arrays.multiply(java.util.Arrays.asList(0), java.util.Arrays.asList(1)));

        assertEquals(
                java.util.Arrays.asList(-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7),
                Arrays.multiply(
                        java.util.Arrays.asList(1, 9, 3, 7, 0, 7, 7, 2, 1),
                        java.util.Arrays.asList(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7)
                )
        );
    }


    /*
    ADVANCING THROUGH AN ARRAY
     */
    @DataProvider
    public static Object[] dataProviderForBoardGame() {
        return new Object[] {
                new Object[] {
                        new int[] { 3, 3, 1, 0, 2, 0, 1 }, true
                },
                new Object[] {
                        new int[] { 3, 2, 0, 0, 2, 0, 1 }, false
                },
                new Object[] {
                        new int[] { 1 }, true
                },
                new Object[] {
                        new int[] { 2, 0, 0 }, true
                },
                new Object[] {
                        new int[] { 0 }, true
                },
        };
    }

    @Test
    @UseDataProvider("dataProviderForBoardGame")
    public void testBoardGame(Object[] data) {
        int[] array = (int[]) data[0];
        boolean result = (boolean) data[1];

        assertEquals(result, Arrays.boardGame(array));
    }


    @Test
    public void testBoardGame_MinimumSteps() {
        assertEquals(Integer.MAX_VALUE, Arrays.boardGame_MinimumSteps(new int[] { 0, 1 }));
        assertEquals(1, Arrays.boardGame_MinimumSteps(new int[] { 3, 2, 2, 0 }));
    }



    /*
    DELETE DUPLICATES FROM AN ARRAY
     */
    @DataProvider
    public static Object[] dataProviderForDeleteDuplicates() {
        return new Object[] {
                new Object[] {
                        new Integer[] { 2, 3, 5, 5, 7, 11, 11, 11, 13 },
                        new Integer[] { 2, 3, 5, 7, 11, 13, 0, 0, 0 }
                },
                new Object[] {
                        new Integer[] { },
                        new Integer[] { }
                },
                new Object[] {
                        new Integer[] { 1 },
                        new Integer[] { 1 }
                },
                new Object[] {
                        new Integer[] { 1, 1 },
                        new Integer[] { 1, 0 }
                },
                new Object[] {
                        new Integer[] { 1, 2, 2 },
                        new Integer[] { 1, 2, 0 }
                },
        };
    }

    public void runDeleteDuplicates(Object[] data, UnaryOperator<Integer[]> algorithm) {
        Integer[] array = (Integer[]) data[0];
        Integer[] shouldBe = (Integer[]) data[1];
        algorithm.apply(array);

        assertArrayEquals(shouldBe, array);
    }

    @Test
    @UseDataProvider("dataProviderForDeleteDuplicates")
    public void testDeleteDuplicates_Bruteforce(Object[] data) {
        runDeleteDuplicates(data, ArraysFactory.getDeleteDuplicates(ArraysFactory.DELETE_DUPLICATES.BRUTEFORCE));
    }

    @Test
    @UseDataProvider("dataProviderForDeleteDuplicates")
    public void testDeleteDuplicates_Fast(Object[] data) {
        runDeleteDuplicates(data, ArraysFactory.getDeleteDuplicates(ArraysFactory.DELETE_DUPLICATES.FAST));
    }


    @DataProvider
    public static Object[] dataProviderForDeleteDuplicates_OneKey() {
        return new Object[] {
                new Object[] {
                        new Integer[] { 2, 3, 5,  5,  7, 11, 11, 11, 13 },
                        new Integer[] { 2, 3, 7, 11, 11, 11,  13,  0,  0 },
                        5
                },
                new Object[] {
                        new Integer[] { },
                        new Integer[] { },
                        10
                },
                new Object[] {
                        new Integer[] { 1 },
                        new Integer[] { 1 },
                        20
                },
                new Object[] {
                        new Integer[] { 1, 5 },
                        new Integer[] { 1, 0 },
                        5
                },
                new Object[] {
                        new Integer[] { 5, 1 },
                        new Integer[] { 1, 0 },
                        5
                },
                new Object[] {
                        new Integer[] { 1, 1 },
                        new Integer[] { 0, 0 },
                        1
                },
                new Object[] {
                        new Integer[] { 1, 2, 3, 3, 6, 7, 3, 5, 1, 3, 4, 5, 3, 3, 3, 1 },
                        new Integer[] { 1, 2, 6, 7, 5, 1, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0 },
                        3
                },

        };
    }

    @Test
    @UseDataProvider("dataProviderForDeleteDuplicates_OneKey")
    public void testDeleteDuplicates_OneKey(Object[] data) {
        Integer[] array = (Integer[]) data[0];
        Integer[] shouldBe = (Integer[]) data[1];
        int key = (int) data[2];

        Arrays.deleteDuplicates_OneKey(array, key);

        assertArrayEquals(shouldBe, array);
    }


    @DataProvider
    public static Object[] dataProviderForDeleteDuplicates_Min2m() {
        return new Object[] {
                new Object[] {
                        new Integer[] { },
                        new Integer[] { },
                        10
                },
                new Object[] {
                        new Integer[] { 1 },
                        new Integer[] { 1 },
                        20
                },
                new Object[] {
                        new Integer[] { 1, 2 },
                        new Integer[] { 1, 2 },
                        1
                },
                new Object[] {
                        new Integer[] { 1, 1, 2 },
                        new Integer[] { 1, 2, 0 },
                        1
                },
                new Object[] {
                        new Integer[] { 1, 2, 2 },
                        new Integer[] { 1, 2, 0 },
                        1
                },
                new Object[] {
                        new Integer[] { 1, 1, 2, 2 },
                        new Integer[] { 1, 2, 0, 0 },
                        1
                },
                new Object[] {
                        new Integer[] { 2, 3, 5, 5, 7, 11, 11, 11, 13 },
                        new Integer[] { 2, 3, 5, 5, 7, 11, 11, 13,  0 },
                        2
                },
                new Object[] {
                        new Integer[] { 2, 3, 5, 5, 5,  5,  11, 11, 13 },
                        new Integer[] { 2, 3, 5, 5, 11, 11, 13,  0,  0 },
                        3
                },
        };
    }

    @Test
    @UseDataProvider("dataProviderForDeleteDuplicates_Min2m")
    public void testDeleteDuplicates_Min2m(Object[] data) {
        Integer[] array = (Integer[]) data[0];
        Integer[] shouldBe = (Integer[]) data[1];
        int m = (int) data[2];

        Arrays.deleteDuplicates_Min2m(array, m);

        assertArrayEquals(shouldBe, array);
    }



    /*
    BUY AND SELL A STOCK ONCE
     */
    @Test
    public void testBuyAndSellAStockOnce() {
        assertEquals(30, Arrays.buyAndSellAStockOnce(new int[] { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 }));
    }



    /*
    BUY AND SELL A STOCK TWICE
    */
    @DataProvider
    public static Object[] dataProviderForRunBuyAndSellAStockTwice() {
        return new Object[] {
                ArraysFactory.getBuyAndSellAStockTwice(ArraysFactory.BUY_AND_SELL_A_STOCK_TWICE.ONE_ITERATION),
                ArraysFactory.getBuyAndSellAStockTwice(ArraysFactory.BUY_AND_SELL_A_STOCK_TWICE.SPACE)
        };
    }

    @Test
    @UseDataProvider("dataProviderForRunBuyAndSellAStockTwice")
    public void testBuyAndSellAStockTwice(Function<Integer[], Integer> algorithm) {
        assertEquals(10, algorithm.apply(new Integer[] { 12, 11, 13, 9, 12, 8, 14, 13, 15 }).intValue());
    }



    /*
    ENUMERATE ALL PRIMES TO n
     */
    @Test
    public void testEnumerateAllPrimesToN() {
        assertEquals(java.util.Arrays.asList(), Arrays.enumerateAllPrimes(0));
        assertEquals(java.util.Arrays.asList(1), Arrays.enumerateAllPrimes(1));
        assertEquals(java.util.Arrays.asList(1, 2, 3, 5), Arrays.enumerateAllPrimes(5));
        assertEquals(java.util.Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19), Arrays.enumerateAllPrimes(20));
    }



    /*
    PERMUTE THE ELEMENTS OF AN ARRAY
     */
    @DataProvider
    public static Object[] dataProviderForPermuteTheElementsOfAnArray() {
        return new Object[] {
                ArraysFactory.getPermuteTheElementsOfAnArray(ArraysFactory.PERMUTE_THE_ELEMENTS_OF_AN_ARRAY.ONE_ITERATION),
                ArraysFactory.getPermuteTheElementsOfAnArray(ArraysFactory.PERMUTE_THE_ELEMENTS_OF_AN_ARRAY.SPACE)
        };
    }

    @Test
    @UseDataProvider("dataProviderForPermuteTheElementsOfAnArray")
    public void testPermuteTheElementsOfAnArray(BinaryOperator<Integer[]> algorithm) {
        assertArrayEquals(new Integer[] { 9 }, algorithm.apply(new Integer[] { 9 }, new Integer[] { 0 }));
        assertArrayEquals(new Integer[] { 2, 1 }, algorithm.apply(new Integer[] { 1, 2 }, new Integer[] { 1, 0 }));
        assertArrayEquals(new Integer[] { 3, 10, 4 }, algorithm.apply(new Integer[] { 4, 10, 3 }, new Integer[] { 2, 1, 0 }));
        assertArrayEquals(new Integer[] { 100, 3, 4, 10 }, algorithm.apply(new Integer[] { 4, 10, 3, 100 }, new Integer[] { 2, 3, 1, 0 }));
        assertArrayEquals(new Integer[] { 2, 3, 1, 4 }, algorithm.apply(new Integer[] { 1, 2, 3, 4 }, new Integer[] { 2, 0, 1, 3 }));
    }

    @Test
    public void testInversePermutation() {
        BinaryOperator<Integer[]> algorithm = ArraysFactory.getPermuteTheElementsOfAnArray(ArraysFactory.PERMUTE_THE_ELEMENTS_OF_AN_ARRAY.SPACE);
        Integer array[];
        Integer permutation[];

        array = new Integer[] { 4, 10, 3, 100 };
        permutation = new Integer[] { 2, 3, 1, 0 };
        assertArrayEquals(
                array,
                algorithm.apply(algorithm.apply(array, permutation), Arrays.inversePermutation(permutation))
        );

        array = new Integer[] { 2, 3, 1, 4 };
        permutation = new Integer[] { 2, 0, 1, 3 };
        assertArrayEquals(
                array,
                algorithm.apply(algorithm.apply(array, permutation), Arrays.inversePermutation(permutation))
        );
    }



    /*
    COMPUTE THE NEXT PERMUTATION
     */
    @Test
    public void testComputeTheNextPermutation() {
        assertArrayEquals(new int[] { }, Arrays.computeTheNextPermutation(new int[] { 1 }));
        assertArrayEquals(new int[] { }, Arrays.computeTheNextPermutation(new int[] { 3, 2, 1 }));
        assertArrayEquals(new int[] { 3, 2 }, Arrays.computeTheNextPermutation(new int[] { 2, 3 }));
        assertArrayEquals(new int[] { 2, 1, 0 }, Arrays.computeTheNextPermutation(new int[] { 2, 0, 1 }));
        assertArrayEquals(new int[] { 1, 2, 0, 3 }, Arrays.computeTheNextPermutation(new int[] { 1, 0, 3, 2 }));
        assertArrayEquals(new int[] { 6, 2, 3, 0, 1, 4, 5 }, Arrays.computeTheNextPermutation(new int[] { 6, 2, 1, 5, 4, 3, 0 }));
    }

    @Test
    public void testComputeKthPermutation() {
        assertArrayEquals(new int[] { 0, 2, 1 }, Arrays.computeKthPermutation(3, 1));
        assertArrayEquals(new int[] { 4, 0, 3, 1, 2 }, Arrays.computeKthPermutation(5, 100));
    }

    @Test
    public void testComputeThePreviousPermutation() {
        assertArrayEquals(new int[] { }, Arrays.computeThePreviousPermutation(new int[] { 1 }));
        assertArrayEquals(new int[] { 2, 3 }, Arrays.computeThePreviousPermutation(Arrays.computeTheNextPermutation(new int[] { 2, 3 })));
        assertArrayEquals(new int[] { 2, 0, 1 }, Arrays.computeThePreviousPermutation(Arrays.computeTheNextPermutation(new int[] { 2, 0, 1 })));
        assertArrayEquals(new int[] { 1, 0, 3, 2 }, Arrays.computeThePreviousPermutation((Arrays.computeTheNextPermutation(new int[] { 1, 0, 3, 2 }))));
        assertArrayEquals(new int[] { 6, 2, 1, 5, 4, 3, 0 }, Arrays.computeThePreviousPermutation((Arrays.computeTheNextPermutation(new int[] { 6, 2, 1, 5, 4, 3, 0 }))));
    }



    /*
    SAMPLE OFFLINE DATA
     */
    @Test
    public void testSampleOfflineData() {
        // Really hard to test random stuff
    }



    /*
    SAMPLE ONLINE DATA
    */
    @Test
    public void testSampleOnlineData() {
        // Really hard to test random stuff
    }



    /*
    COMPUTE A RANDOM PERMUTATION
    */
    @Test
    public void testComputeARandomPermutation() {
        // Really hard to test random stuff
    }



    /*
    COMPUTE A RANDOM SUBSET

    Assuming that k << n
     */
    @Test
    public void testComputeARandomSubset() {
        int[] result = Arrays.computeARandomSubset(5, 4, new RandomSupplier<Integer>() {
            int[] data = new int[] { 4, 3, 3, 4 };
            int pointer = 0;

            @Override
            public Integer get(Integer bound) {
                return data[pointer] - pointer++; // need to subtract pointer because it is added in the code
            }
        });

        assertArrayEquals(new int[] { 4, 3, 1, 0 }, result);
    }



    /*
    GENERATE NONUNIFORM RANDOM NUMBERS
     */
    @Test
    public void testGenerateNonuniformRandomNumbers() {
        RandomSupplier<Double> random = new RandomSupplier<Double>() {
            double data[] = new double[] { 0.1, 0.0, 0.3, 0.4, 0.6, 0.7 };
            int pointer = 0;

            @Override
            public Double get(Double bound) {
                return data[pointer++];
            }
        };

        int numbers[] = new int[] { 88, -100, 500, 0 };
        double probabilities[] = new double[] { 0.3, 0.3, 0.3, 0.1 };
        assertEquals(88, Arrays.generateNonuniformRandomNumbers(numbers, probabilities, random));
        assertEquals(88, Arrays.generateNonuniformRandomNumbers(numbers, probabilities, random));
        assertEquals(-100, Arrays.generateNonuniformRandomNumbers(numbers, probabilities, random));
        assertEquals(-100, Arrays.generateNonuniformRandomNumbers(numbers, probabilities, random));
        assertEquals(500, Arrays.generateNonuniformRandomNumbers(numbers, probabilities, random));
        assertEquals(500, Arrays.generateNonuniformRandomNumbers(numbers, probabilities, random));
    }



    /*
    THE SUDOKU CHECKER PROBLEM
     */
    @Test
    public void testCheckPartialSudoku() {
        assertTrue(Arrays.checkPartialSudoku(new int[][] {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 },
        }));
    }



    /*
    COMPUTE THE SPIRAL ORDERING OF A 2D ARRAY
     */

    /**
     * Generate nxn array
     *
     * @param n dimension
     *
     * @return nxn array
     */
    private Integer[][] generateArrayForSpiral(int n) {
        Integer array[][] = new Integer[n][n];

        for (int i = 0; i < n * n; i++) array[i / n][i % n] = i + 1;

        return array;
    }

    @Test
    public void testComputeTheSpiralOrderingOfA2DArray() {
        assertArrayEquals(
                new Integer[] { 1 },
                Arrays.computeTheSpiralOrderingOfA2DArray(generateArrayForSpiral(1), 1).toArray(new Integer[0])
        );

        assertArrayEquals(
                new Integer[] { 1, 2, 4, 3 },
                Arrays.computeTheSpiralOrderingOfA2DArray(generateArrayForSpiral(2), 2).toArray(new Integer[0])
        );

        assertArrayEquals(
                new Integer[] { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 },
                Arrays.computeTheSpiralOrderingOfA2DArray(generateArrayForSpiral(4), 4).toArray(new Integer[0])
        );

        assertArrayEquals(
                new Integer[] { 1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13 },
                Arrays.computeTheSpiralOrderingOfA2DArray(generateArrayForSpiral(5), 5).toArray(new Integer[0])
        );
    }


    @Test
    public void testGenerateArrayInTheSpiralOrdering() {

        for (int i = 0; i < 10; i++) {
            Integer array[] = new Integer[i * i];
            for (int k = 1; k <= i * i; k++) array[k - 1] = k;

            assertArrayEquals(
                    array,
                    Arrays.computeTheSpiralOrderingOfA2DArray(Arrays.generateArrayInTheSpiralOrdering(i), i).toArray(new Integer[0])
            );

        }
    }


    @Test
    public void testEnumerateFirstPairsOfIntegersInSpiralOrder() {
        assertArrayEquals(new String[] { "(0,0)"}, Arrays.enumerateFirstPairsOfIntegersInSpiralOrder(1).toArray(new String[0]));
        assertArrayEquals(new String[] { "(0,0)", "(1,0)" }, Arrays.enumerateFirstPairsOfIntegersInSpiralOrder(2).toArray(new String[0]));
        assertArrayEquals(
                new String[] { "(0,0)", "(1,0)", "(1,-1)", "(0,-1)", "(-1,-1)", "(-1,0)", "(-1,1)", "(0,1)", "(1,1)", "(2,1)" },
                Arrays.enumerateFirstPairsOfIntegersInSpiralOrder(10).toArray(new String[0])
        );
    }


    /**
     * Generate mxn array
     *
     * @param m rows
     * @param n columns
     *
     * @return mxn array
     */
    private Integer[][] generateArrayForSpiralMN(int m, int n) {
        Integer array[][] = new Integer[m][n];

        for (int i = 0; i < m * n; i++) array[i / n][i % n] = i + 1;

        return array;
    }

    @Test
    public void testComputeTheSpiralOrderOfMNArray() {
        assertArrayEquals(new Integer[] { 1 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(1, 1), 1, 1));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(1, 5), 1, 5));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(5, 1), 5, 1));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(2, 5), 2, 5));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(3, 5), 3, 5));
    }


    @Test
    public void testComputeTheLastElementInSpiralOrderMNArray() {
        assertEquals(1, Arrays.computeTheLastElementInSpiralOrderMNArray(generateArrayForSpiralMN(1, 1), 1, 1));
        assertEquals(4, Arrays.computeTheLastElementInSpiralOrderMNArray(generateArrayForSpiralMN(2, 3), 2, 3));
        assertEquals(5, Arrays.computeTheLastElementInSpiralOrderMNArray(generateArrayForSpiralMN(3, 3), 3, 3));
        assertEquals(9, Arrays.computeTheLastElementInSpiralOrderMNArray(generateArrayForSpiralMN(3, 5), 3, 5));
        assertEquals(11, Arrays.computeTheLastElementInSpiralOrderMNArray(generateArrayForSpiralMN(5, 3), 5, 3));
    }



    /*
    Rotate the 2D array by 90 degrees clockwise.
     */
    @Test
    public void testRotate2DArray() {
        assertArrayEquals(
                new int[][] {
                        { 3, 1 },
                        { 4, 2 },
                },
                Arrays.rotate2DArray(generateArrayForSpiral(2))
        );

        assertArrayEquals(
                new int[][] {
                        { 7, 4, 1 },
                        { 8, 5, 2 },
                        { 9, 6, 3 }
                },
                Arrays.rotate2DArray(generateArrayForSpiral(3))
        );

        assertArrayEquals(
            new int[][] {
                { 13,  9, 5, 1 },
                { 14, 10, 6, 2 },
                { 15, 11, 7, 3 },
                { 16, 12, 8, 4 }
            },
            Arrays.rotate2DArray(generateArrayForSpiral(4))
        );
    }

    @Test
    public void testReflect2DArrayHorizontal() {
        assertArrayEquals(new int[][] { { 1 } }, Arrays.reflect2DArrayHorizontal(generateArrayForSpiral(1)));

        assertArrayEquals(
                new int[][] {
                    { 21, 22, 23, 24, 25 },
                    { 16, 17, 18, 19, 20 },
                    { 11, 12, 13, 14, 15 },
                    {  6,  7,  8,  9, 10 },
                    {  1,  2,  3,  4,  5 }
                },
                Arrays.reflect2DArrayHorizontal(generateArrayForSpiral(5))
        );
    }

    @Test
    public void testReflect2DArrayVertical() {
        assertArrayEquals(new int[][] { { 1 } }, Arrays.reflect2DArrayVertical(generateArrayForSpiral(1)));

        assertArrayEquals(
                new int[][] {
                    {  5,  4,  3,  2,  1 },
                    { 10,  9,  8,  7,  6 },
                    { 15, 14, 13, 12, 11 },
                    { 20, 19, 18, 17, 16 },
                    { 25, 24, 23, 22, 21 }
                },
                Arrays.reflect2DArrayVertical(generateArrayForSpiral(5))
        );
    }

    @Test
    public void testReflect2DArrayDiagonalTopLeft() {
        assertArrayEquals(new int[][] { { 1 } }, Arrays.reflect2DArrayDiagonalTopLeft(generateArrayForSpiral(1)));

        assertArrayEquals(
                new int[][] {
                        { 25, 20, 15, 10, 5 },
                        { 24, 19, 14,  9, 4 },
                        { 23, 18, 13,  8, 3 },
                        { 22, 17, 12,  7, 2 },
                        { 21, 16, 11,  6, 1 }
                },
                Arrays.reflect2DArrayDiagonalTopLeft(generateArrayForSpiral(5))
        );
    }

    @Test
    public void testReflect2DArrayDiagonalTopRight() {
        assertArrayEquals(new int[][] { { 1 } }, Arrays.reflect2DArrayDiagonalTopRight(generateArrayForSpiral(1)));

        assertArrayEquals(
                new int[][] {
                        { 1,  6, 11, 16, 21 },
                        { 2,  7, 12, 17, 22 },
                        { 3,  8, 13, 18, 23 },
                        { 4,  9, 14, 19, 24 },
                        { 5, 10, 15, 20, 25 }
                },
                Arrays.reflect2DArrayDiagonalTopRight(generateArrayForSpiral(5))
        );
    }



    /*
    COMPUTE ROWS IN PASCAL'S TRIANGLE
     */
    @Test
    public void testComputeRowsInPascalTriangle() {
        assertArrayEquals(new int[][] { { 1 } }, Arrays.computeRowsInPascalTriangle(1));

        assertArrayEquals(
                new int[][] {
                        { 1 },
                        { 1, 1 },
                        { 1, 2, 1 },
                        { 1, 3, 3, 1 },
                        { 1, 4, 6, 4, 1 }
                    },
                Arrays.computeRowsInPascalTriangle(5)
        );
    }


    @Test
    public void testComputeNthRowOfPascalTriangle() {
        assertArrayEquals(new int[] { 1 }, Arrays.computeNthRowOfPascalTriangle(1));
        assertArrayEquals(new int[] { 1, 1 }, Arrays.computeNthRowOfPascalTriangle(2));
        assertArrayEquals(new int[] { 1, 2, 1 }, Arrays.computeNthRowOfPascalTriangle(3));
        assertArrayEquals(new int[] { 1, 3, 3, 1 }, Arrays.computeNthRowOfPascalTriangle(4));
        assertArrayEquals(new int[] { 1, 4, 6, 4, 1 }, Arrays.computeNthRowOfPascalTriangle(5));
    }
}
