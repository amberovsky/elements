package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pro.amberovsky.elements.util.Function.RandomSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraysTest {
    /*
    REORDER ARRAY
     */
    private void runTestReorderEven(Integer array[]) {
        Integer[] reorderedArray = Arrays.reorderEven(array);

        for (int i = 0; i < reorderedArray.length / 2; i++) assertEquals(0, reorderedArray[i] % 2);
        for (int i = (reorderedArray.length + 1) / 2; i < reorderedArray.length; i++) assertEquals(1, reorderedArray[i] % 2);
    }

    @Test
    void testReorderEven() {
        runTestReorderEven(new Integer[] { 1 });
        runTestReorderEven(new Integer[] { 1, 2 });
        runTestReorderEven(new Integer[] { 1, 2, 3 });
        runTestReorderEven(new Integer[] { 1, 2, 3, 4, 5, 6 });
    }



    /*
    DUTCH FLAG with variants
     */
    private static Stream<Arguments> sourceForDutchFlag() {
        return Stream.of(
                Arguments.of(new Integer[] { 0, 1, 2, 0, 2, 1, 1 }, 3),
                Arguments.of(new Integer[] { 1 }, 0),
                Arguments.of(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 0),
                Arguments.of(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 8)
        );
    }

    enum DUTCH_FLAG_CHECKING_STATUS { LESS, EQUAL, GREATER }

    @ParameterizedTest
    @MethodSource("sourceForDutchFlag")
    void testDutchFlag(Integer array[], int pivotIndex) {
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

    private static Stream<Arguments> sourceForDutchFlag_OnlyThreeValues() {
        return Stream.of(
                Arguments.of(new Integer[] { 0, 1, 2, 0, 2, 1, 1 }, 0, 1, 2),
                Arguments.of(new Integer[] { 1 }, 1, 1, 1),
                Arguments.of(new Integer[] { 6, 8, 6, 6, 6, 6, 6, 6, 6 }, 6, 7, 8),
                Arguments.of(new Integer[] { 9, 9, 2, 2, 1, 1, 2, 1, 1 }, 1, 2, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForDutchFlag_OnlyThreeValues")
    void testDutchFlag_OnlyThreeValues(Integer array[], int value1, int value2, int value3) {
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

    private static Stream<Arguments> sourceForDutchFlag_OnlyFourValues() {
        return Stream.of(
                Arguments.of(new Integer[] { 0, 1, 2, 0, 2, 1, 1, 5 }, 0, 1, 2, 5),
                Arguments.of(new Integer[] { 1 }, 1, 1, 1, 1),
                Arguments.of(new Integer[] { 6, 8, 6, 6, 6, 6, 6, 6, 6 }, 6, 7, 8, 9),
                Arguments.of(new Integer[] { 9, 9, 2, 2, 1, 4, 4, 4, 1, 2, 1, 1, 4 }, 1, 2, 9, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForDutchFlag_OnlyFourValues")
    void testDutchFlag_OnlyFourValues(Integer array[], int value1, int value2, int value3, int value4) {
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

    private static Stream<Arguments> sourceForDutchFlag_OnlyTwoValues() {
        return Stream.of(
                Arguments.of((Object) new Integer[] { 0, 1, 1, 0, 1, 1, 1, 0 }),
                Arguments.of((Object) new Integer[] { 1 }),
                Arguments.of((Object) new Integer[] { 1, 0, 1, 1, 1, 1, 1, 1, 1 }),
                Arguments.of((Object) new Integer[] { 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 })
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForDutchFlag_OnlyTwoValues")
    void testDutchFlag_OnlyTwoValues(Integer[] array) {
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
    private static Stream<Arguments> sourceForDutchFlag_OnlyTwoValuesKeepOrderOfOneValue() {
        return Stream.of(
                Arguments.of((Object) new Integer[] { 1 }),
                Arguments.of((Object) new Integer[] { 0 }),
                Arguments.of((Object) new Integer[] {  }),
                Arguments.of((Object) new Integer[] { 1, 0, 0, 0 }),
                Arguments.of((Object) new Integer[] { 0, 1, 1, 1 }),
                Arguments.of((Object) new Integer[] { 1, 0, 1, 0 })
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForDutchFlag_OnlyTwoValuesKeepOrderOfOneValue")
    void testDutchFlag_OnlyTwoValuesKeepOrderOfOneValue(Integer array[]) {
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
    private static Stream<Arguments> sourceForAddOne() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 9 }, new Integer[] { 1, 3, 0 }),
                Arguments.of(new Integer[] { 0 }, new Integer[] { 1 }),
                Arguments.of(new Integer[] { -1 }, new Integer[] { 0 }),
                Arguments.of(new Integer[] { 9, 9, 9 }, new Integer[] { 1, 0, 0, 0 })
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForAddOne")
    void testAddOne(Integer source[], Integer expected[]) {
        List<Integer> array = new ArrayList<>(java.util.Arrays.asList(source));
        Arrays.addOne(array);
        List<Integer> result = java.util.Arrays.asList(expected);

        assertEquals(array.size(), result.size());
        for (int i = 0; i < array.size(); i++) assertEquals(array.get(i), result.get(i));
    }

    /*
    Add two numbers in binary representation
     */
    private static Stream<Arguments> sourceForAddOne_TwoBinaryNumbers() {
        return Stream.of(
                Arguments.of("00", "00", "00"),
                Arguments.of("0", "1", "1"),
                Arguments.of("11", "00", "11"),
                Arguments.of("11", "10", "101"),
                Arguments.of("11", "11", "110"),
                Arguments.of("11", "1", "100")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForAddOne_TwoBinaryNumbers")
    void testAddOne_TwoBinaryNumbers(String number1, String number2, String shouldBe) {
        String result = Arrays.addOne_TwoBinaryNumbers(number1, number2);

        assertEquals(shouldBe.length(), result.length());

        for (int i = 0; i < result.length(); i++) assertEquals(shouldBe.charAt(i), result.charAt(i));
    }



    /*
    MULTIPLY TWO ARBITRARY-PRECISION INTEGERS
     */
    @Test
    void testMultiply() {
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
    private static Stream<Arguments> sourceForBoardGame() {
        return Stream.of(
                Arguments.of(
                        new Integer[] { 3, 3, 1, 0, 2, 0, 1 }, true
                ),
                Arguments.of(
                        new Integer[] { 3, 2, 0, 0, 2, 0, 1 }, false
                ),
                Arguments.of(
                        new Integer[] { 1 }, true
                ),
                Arguments.of(
                        new Integer[] { 2, 0, 0 }, true
                ),
                Arguments.of(
                        new Integer[] { 0 }, true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForBoardGame")
    void testBoardGame(Integer array[], boolean result) {
        assertEquals(result, Arrays.boardGame(array));
    }


    @Test
    void testBoardGame_MinimumSteps() {
        assertEquals(Integer.MAX_VALUE, Arrays.boardGame_MinimumSteps(new int[] { 0, 1 }));
        assertEquals(1, Arrays.boardGame_MinimumSteps(new int[] { 3, 2, 2, 0 }));
    }



    /*
    DELETE DUPLICATES FROM AN ARRAY
     */
    private static Stream<Arguments> sourceForDeleteDuplicates() {
        return Stream.of(
                Arguments.of(
                        new Integer[] { 2, 3, 5, 5, 7, 11, 11, 11, 13 },
                        new Integer[] { 2, 3, 5, 7, 11, 13, 0, 0, 0 }
                ),
                Arguments.of(
                        new Integer[] { },
                        new Integer[] { }
                ),
                Arguments.of(
                        new Integer[] { 1 },
                        new Integer[] { 1 }
                ),
                Arguments.of(
                        new Integer[] { 1, 1 },
                        new Integer[] { 1, 0 }
                ),
                Arguments.of(
                        new Integer[] { 1, 2, 2 },
                        new Integer[] { 1, 2, 0 }
                )
        );
    }

    void runDeleteDuplicates(Integer array[], Integer shouldBe[], UnaryOperator<Integer[]> operator) {
        operator.apply(array);

        assertArrayEquals(shouldBe, array);
    }

    @ParameterizedTest
    @MethodSource("sourceForDeleteDuplicates")
    void testDeleteDuplicates_Bruteforce(Integer array[], Integer shouldBe[]) {
        runDeleteDuplicates(array, shouldBe, ArraysFactory.getDeleteDuplicates(ArraysFactory.DELETE_DUPLICATES.BRUTEFORCE));
    }

    @ParameterizedTest
    @MethodSource("sourceForDeleteDuplicates")
    void testDeleteDuplicates_Fast(Integer array[], Integer shouldBe[]) {
        runDeleteDuplicates(array, shouldBe, ArraysFactory.getDeleteDuplicates(ArraysFactory.DELETE_DUPLICATES.FAST));
    }


    private static Stream<Arguments> sourceForDeleteDuplicates_OneKey() {
        return Stream.of(
                Arguments.of(
                        new Integer[] { 2, 3, 5,  5,  7, 11, 11, 11, 13 },
                        new Integer[] { 2, 3, 7, 11, 11, 11,  13,  0,  0 },
                        5
                ),
                Arguments.of(
                        new Integer[] { },
                        new Integer[] { },
                        10
                ),
                Arguments.of(
                        new Integer[] { 1 },
                        new Integer[] { 1 },
                        20
                ),
                Arguments.of(
                        new Integer[] { 1, 5 },
                        new Integer[] { 1, 0 },
                        5
                ),
                Arguments.of(
                        new Integer[] { 5, 1 },
                        new Integer[] { 1, 0 },
                        5
                ),
                Arguments.of(
                        new Integer[] { 1, 1 },
                        new Integer[] { 0, 0 },
                        1
                ),
                Arguments.of(
                        new Integer[] { 1, 2, 3, 3, 6, 7, 3, 5, 1, 3, 4, 5, 3, 3, 3, 1 },
                        new Integer[] { 1, 2, 6, 7, 5, 1, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0 },
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForDeleteDuplicates_OneKey")
    void testDeleteDuplicates_OneKey(Integer array[], Integer expected[], int key) {
        Arrays.deleteDuplicates_OneKey(array, key);

        assertArrayEquals(expected, array);
    }


    private static Stream<Arguments> sourceForDeleteDuplicates_Min2m() {
        return Stream.of(
                Arguments.of(
                        new Integer[] { },
                        new Integer[] { },
                        10
                ),
                Arguments.of(
                        new Integer[] { 1 },
                        new Integer[] { 1 },
                        20
                ),
                Arguments.of(
                        new Integer[] { 1, 2 },
                        new Integer[] { 1, 2 },
                        1
                ),
                Arguments.of(
                        new Integer[] { 1, 1, 2 },
                        new Integer[] { 1, 2, 0 },
                        1
                ),
                Arguments.of(
                        new Integer[] { 1, 2, 2 },
                        new Integer[] { 1, 2, 0 },
                        1
                ),
                Arguments.of(
                        new Integer[] { 1, 1, 2, 2 },
                        new Integer[] { 1, 2, 0, 0 },
                        1
                ),
                Arguments.of(
                        new Integer[] { 2, 3, 5, 5, 7, 11, 11, 11, 13 },
                        new Integer[] { 2, 3, 5, 5, 7, 11, 11, 13,  0 },
                        2
                ),
                Arguments.of(
                        new Integer[] { 2, 3, 5, 5, 5,  5,  11, 11, 13 },
                        new Integer[] { 2, 3, 5, 5, 11, 11, 13,  0,  0 },
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForDeleteDuplicates_Min2m")
    void testDeleteDuplicates_Min2m(Integer array[], Integer expected[], int m) {
        Arrays.deleteDuplicates_Min2m(array, m);

        assertArrayEquals(expected, array);
    }



    /*
    BUY AND SELL A STOCK ONCE
     */
    @Test
    void testBuyAndSellAStockOnce() {
        assertEquals(30, Arrays.buyAndSellAStockOnce(new int[] { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 }));
    }



    /*
    BUY AND SELL A STOCK TWICE
    */
    @ParameterizedTest
    @EnumSource(ArraysFactory.BUY_AND_SELL_A_STOCK_TWICE.class)
    void testBuyAndSellAStockTwice(ArraysFactory.BUY_AND_SELL_A_STOCK_TWICE algorithm) {
        Function<Integer[], Integer> function = ArraysFactory.getBuyAndSellAStockTwice(algorithm);
        assertEquals(10, function.apply(new Integer[] { 12, 11, 13, 9, 12, 8, 14, 13, 15 }).intValue());
    }



    /*
    ENUMERATE ALL PRIMES TO n
     */
    @Test
    void testEnumerateAllPrimesToN() {
        assertEquals(java.util.Arrays.asList(), Arrays.enumerateAllPrimes(0));
        assertEquals(java.util.Arrays.asList(1), Arrays.enumerateAllPrimes(1));
        assertEquals(java.util.Arrays.asList(1, 2, 3, 5), Arrays.enumerateAllPrimes(5));
        assertEquals(java.util.Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19), Arrays.enumerateAllPrimes(20));
    }



    /*
    PERMUTE THE ELEMENTS OF AN ARRAY
     */
    @ParameterizedTest
    @EnumSource(ArraysFactory.PERMUTE_THE_ELEMENTS_OF_AN_ARRAY.class)
    void testPermuteTheElementsOfAnArray(ArraysFactory.PERMUTE_THE_ELEMENTS_OF_AN_ARRAY algorithm) {
        BinaryOperator<Integer[]> operator = ArraysFactory.getPermuteTheElementsOfAnArray(algorithm);
        assertArrayEquals(new Integer[] { 9 }, operator.apply(new Integer[] { 9 }, new Integer[] { 0 }));
        assertArrayEquals(new Integer[] { 2, 1 }, operator.apply(new Integer[] { 1, 2 }, new Integer[] { 1, 0 }));
        assertArrayEquals(new Integer[] { 3, 10, 4 }, operator.apply(new Integer[] { 4, 10, 3 }, new Integer[] { 2, 1, 0 }));
        assertArrayEquals(new Integer[] { 100, 3, 4, 10 }, operator.apply(new Integer[] { 4, 10, 3, 100 }, new Integer[] { 2, 3, 1, 0 }));
        assertArrayEquals(new Integer[] { 2, 3, 1, 4 }, operator.apply(new Integer[] { 1, 2, 3, 4 }, new Integer[] { 2, 0, 1, 3 }));
    }

    @Test
    void testInversePermutation() {
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
    void testComputeTheNextPermutation() {
        assertArrayEquals(new int[] { }, Arrays.computeTheNextPermutation(new int[] { 1 }));
        assertArrayEquals(new int[] { }, Arrays.computeTheNextPermutation(new int[] { 3, 2, 1 }));
        assertArrayEquals(new int[] { 3, 2 }, Arrays.computeTheNextPermutation(new int[] { 2, 3 }));
        assertArrayEquals(new int[] { 2, 1, 0 }, Arrays.computeTheNextPermutation(new int[] { 2, 0, 1 }));
        assertArrayEquals(new int[] { 1, 2, 0, 3 }, Arrays.computeTheNextPermutation(new int[] { 1, 0, 3, 2 }));
        assertArrayEquals(new int[] { 6, 2, 3, 0, 1, 4, 5 }, Arrays.computeTheNextPermutation(new int[] { 6, 2, 1, 5, 4, 3, 0 }));
    }

    @Test
    void testComputeKthPermutation() {
        assertArrayEquals(new int[] { 0, 2, 1 }, Arrays.computeKthPermutation(3, 1));
        assertArrayEquals(new int[] { 4, 0, 3, 1, 2 }, Arrays.computeKthPermutation(5, 100));
    }

    @Test
    void testComputeThePreviousPermutation() {
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
    void testSampleOfflineData() {
        // Really hard to test random stuff
    }



    /*
    SAMPLE ONLINE DATA
    */
    @Test
    void testSampleOnlineData() {
        // Really hard to test random stuff
    }



    /*
    COMPUTE A RANDOM PERMUTATION
    */
    @Test
    void testComputeARandomPermutation() {
        // Really hard to test random stuff
    }



    /*
    COMPUTE A RANDOM SUBSET

    Assuming that k << n
     */
    @Test
    void testComputeARandomSubset() {
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
    void testGenerateNonuniformRandomNumbers() {
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
    void testCheckPartialSudoku() {
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
    void testComputeTheSpiralOrderingOfA2DArray() {
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
    void testGenerateArrayInTheSpiralOrdering() {

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
    void testEnumerateFirstPairsOfIntegersInSpiralOrder() {
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
    void testComputeTheSpiralOrderOfMNArray() {
        assertArrayEquals(new Integer[] { 1 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(1, 1), 1, 1));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(1, 5), 1, 5));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(5, 1), 5, 1));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(2, 5), 2, 5));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9 }, Arrays.computeTheSpiralOrderOfMNArray(generateArrayForSpiralMN(3, 5), 3, 5));
    }


    @Test
    void testComputeTheLastElementInSpiralOrderMNArray() {
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
    void testRotate2DArray() {
        assertArrayEquals(
                new Integer[][] {
                        { 3, 1 },
                        { 4, 2 },
                },
                Arrays.rotate2DArray(generateArrayForSpiral(2))
        );

        assertArrayEquals(
                new Integer[][] {
                        { 7, 4, 1 },
                        { 8, 5, 2 },
                        { 9, 6, 3 }
                },
                Arrays.rotate2DArray(generateArrayForSpiral(3))
        );

        assertArrayEquals(
            new Integer[][] {
                { 13,  9, 5, 1 },
                { 14, 10, 6, 2 },
                { 15, 11, 7, 3 },
                { 16, 12, 8, 4 }
            },
            Arrays.rotate2DArray(generateArrayForSpiral(4))
        );
    }

    @Test
    void testReflect2DArrayHorizontal() {
        assertArrayEquals(new Integer[][] { { 1 } }, Arrays.reflect2DArrayHorizontal(generateArrayForSpiral(1)));

        assertArrayEquals(
                new Integer[][] {
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
    void testReflect2DArrayVertical() {
        assertArrayEquals(new Integer[][] { { 1 } }, Arrays.reflect2DArrayVertical(generateArrayForSpiral(1)));

        assertArrayEquals(
                new Integer[][] {
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
    void testReflect2DArrayDiagonalTopLeft() {
        assertArrayEquals(new Integer[][] { { 1 } }, Arrays.reflect2DArrayDiagonalTopLeft(generateArrayForSpiral(1)));

        assertArrayEquals(
                new Integer[][] {
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
    void testReflect2DArrayDiagonalTopRight() {
        assertArrayEquals(new Integer[][] { { 1 } }, Arrays.reflect2DArrayDiagonalTopRight(generateArrayForSpiral(1)));

        assertArrayEquals(
                new Integer[][] {
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
    void testComputeRowsInPascalTriangle() {
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
    void testComputeNthRowOfPascalTriangle() {
        assertArrayEquals(new int[] { 1 }, Arrays.computeNthRowOfPascalTriangle(1));
        assertArrayEquals(new int[] { 1, 1 }, Arrays.computeNthRowOfPascalTriangle(2));
        assertArrayEquals(new int[] { 1, 2, 1 }, Arrays.computeNthRowOfPascalTriangle(3));
        assertArrayEquals(new int[] { 1, 3, 3, 1 }, Arrays.computeNthRowOfPascalTriangle(4));
        assertArrayEquals(new int[] { 1, 4, 6, 4, 1 }, Arrays.computeNthRowOfPascalTriangle(5));
    }
}
