package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.amberovsky.elements.util.Function.TriFunction;

import java.util.function.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static pro.amberovsky.elements.PrimitiveTypes.*;

class PrimitiveTypesTest {
    /*
    ERASE LOWEST SET BIT
     */
    @Test
    void testEraseLowestSetBit_PositiveNumbers() {
        assertEquals(0, eraseLowestSetBit(0));
        assertEquals(0, eraseLowestSetBit(1));
        assertEquals(0, eraseLowestSetBit(2));
        assertEquals(6, eraseLowestSetBit(7));
    }

    @Test
    void testEraseLowestSetBit_NegativeNumbers() {
        assertEquals(-2, eraseLowestSetBit(-1));
        assertEquals(-4, eraseLowestSetBit(-2));
        assertEquals(-8, eraseLowestSetBit(-7));
    }



    /*
    IS POWER OF TWO
     */
    @Test
    void testIsPowerOfTwoReturnsTrueOnPositivePowersOfTwo() {
        assertTrue(isPowerOfTwo(1));
        assertTrue(isPowerOfTwo(2));
        assertTrue(isPowerOfTwo(4));
        assertTrue(isPowerOfTwo(16));
        assertTrue(isPowerOfTwo(32));
    }

    @Test
    void testIsPowerOfTwoReturnsFalseOnPositiveNonPowersOfTwo() {
        assertFalse(isPowerOfTwo(0));
        assertFalse(isPowerOfTwo(101));
        assertFalse(isPowerOfTwo(500));
        assertFalse(isPowerOfTwo(1023));
        assertFalse(isPowerOfTwo(9999));
    }

    @Test
    void testIsPowerOfTwoReturnsFalseOnNegativeNumbers() {
        assertFalse(isPowerOfTwo(-1));
        assertFalse(isPowerOfTwo(-2));
        assertFalse(isPowerOfTwo(-4));
        assertFalse(isPowerOfTwo(-1023));
    }



    /*
    COUNT BITS
     */
    @Test
    void testCountBitsByShifting_PositiveNumbers() {
        assertEquals(1, countBitsByShifting(2));
        assertEquals(1, countBitsByShifting(256));
        assertEquals(2, countBitsByShifting(257));
        assertEquals(9, countBitsByShifting(511));
    }

    @Test
    void testCountBitsByShifting_CornerCases() {
        assertEquals(0, countBitsByShifting(0));
        assertEquals(1, countBitsByShifting(1));
        assertEquals(Long.SIZE, countBitsByShifting(-1));
    }

    @Test
    void testCountBitsByShifting_NegativeNumber() {
        assertEquals(Long.SIZE - 1, countBitsByShifting(-2));
        assertEquals(Long.SIZE - 8 + 1, countBitsByShifting(-255));
        assertEquals(Long.SIZE - 8, countBitsByShifting(-256));
        assertEquals(Long.SIZE - 1, countBitsByShifting(-257));
    }



    /*
    PARITY
     */
    void runGetParity_PositiveNumbers(final Function<Integer, Short> algorithm) {
        assertEquals(0, algorithm.apply(0).intValue());
        assertEquals(1, algorithm.apply(1).intValue());
        assertEquals(1, algorithm.apply(2).intValue());
        assertEquals(0, algorithm.apply(3).intValue());
        assertEquals(1, algorithm.apply(Short.MAX_VALUE + 1).intValue());
    }

    void runGetParity_NegativeNumbers(final Function<Integer, Short> algorithm) {
        assertEquals(0, algorithm.apply(-1).intValue());
        assertEquals(1, algorithm.apply(-2).intValue());
        assertEquals(1, algorithm.apply(-3).intValue());
        assertEquals(1, algorithm.apply(-Short.MAX_VALUE - 1).intValue());
    }

    @Test
    void testGetParity_Bruteforce() {
        runGetParity_PositiveNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.BRUTEFORCE));
        runGetParity_NegativeNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.BRUTEFORCE));
    }

    @Test
    void testGetParity_EraseLowestSetBit() {
        runGetParity_PositiveNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.BRUTEFORCE));
        runGetParity_NegativeNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.BRUTEFORCE));
    }

    @Test
    void testGetParity_LookupTable() {
        runGetParity_PositiveNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.LOOKUP));
        runGetParity_NegativeNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.LOOKUP));
    }

    @Test
    void testGetParity_XOR() {
        runGetParity_PositiveNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.XOR));
        runGetParity_NegativeNumbers(PrimitiveTypesFactory.getParity(PrimitiveTypesFactory.PARITY.XOR));
    }



    /*
    SWAP
     */
    private void runSwap_PositiveNumbers(final TriFunction<Integer, Integer, Integer, Integer> algorithm) {
        assertEquals(0, algorithm.apply(0, 0, 0).intValue());
        assertEquals(1, algorithm.apply(1, 0, 0).intValue());
        assertEquals(2, algorithm.apply(1, 0, 1).intValue());
        assertEquals(1, algorithm.apply(2, 0, 1).intValue());
        assertEquals(584455544, algorithm.apply(584455544, 8, 23).intValue());
        assertEquals(852890744, algorithm.apply(584455544, 8, 28).intValue());
    }

    private void runSwap_NegativeNumbers(final TriFunction<Integer, Integer, Integer, Integer> algorithm) {
        assertEquals(3, algorithm.apply(-Integer.MAX_VALUE + 1, 31, 0).intValue());
        assertEquals(-1, algorithm.apply(-1, 0, 0).intValue());
        assertEquals(-1, algorithm.apply(-1, 0, 1).intValue());
        assertEquals(-3, algorithm.apply(-2, 0, 1).intValue());
    }

    @Test
    void testSwap_Bruteforce() {
        runSwap_PositiveNumbers(PrimitiveTypesFactory.getSwap(PrimitiveTypesFactory.SWAP.BRUTEFORCE));
        runSwap_NegativeNumbers(PrimitiveTypesFactory.getSwap(PrimitiveTypesFactory.SWAP.BRUTEFORCE));
    }



    /*
    REVERSE BITS
     */
    private void runReverseBits_PositiveNumbers(LongUnaryOperator algorithm) {
        assertEquals(0, algorithm.applyAsLong(0L));
        assertEquals(Long.MIN_VALUE, algorithm.applyAsLong(1L));
        assertEquals(2170071905260637924L, algorithm.applyAsLong(2842255555444455544L));
    }

    private void runReverseBits_NegativeNumbers(LongUnaryOperator algorithm) {
        assertEquals(-1, algorithm.applyAsLong(-1L));
        assertEquals(Long.MAX_VALUE, algorithm.applyAsLong(-2L));
        assertEquals(1288692608559903003L, algorithm.applyAsLong(-2842255555444455544L));
    }

    @Test
    void testReverseBits_Iteration() {
        runReverseBits_PositiveNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.ITERATION));
        runReverseBits_NegativeNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.ITERATION));
    }

    @Test
    void testReverseBits_Mask() {
        runReverseBits_PositiveNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.MASK));
        runReverseBits_NegativeNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.MASK));
    }

    @Test
    void testReverseBits_Swap() {
        runReverseBits_PositiveNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.SWAP));
        runReverseBits_NegativeNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.SWAP));
    }

    @Test
    void testReverseBits_Lookup() {
        runReverseBits_PositiveNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.LOOKUP));
        runReverseBits_NegativeNumbers(PrimitiveTypesFactory.getReverseBits(PrimitiveTypesFactory.REVERSE_BITS.LOOKUP));
    }



    /*
    CLOSEST NUMBER WITH SAME WEIGHT
     */
    private static Stream<LongUnaryOperator> sourceForClosestLongWithSameWeight() {
        return Stream.of(
                PrimitiveTypesFactory.getClosestWithSameWeight(PrimitiveTypesFactory.CLOSEST_WITH_SAME_WEIGHT.ITERATION),
                PrimitiveTypesFactory.getClosestWithSameWeight(PrimitiveTypesFactory.CLOSEST_WITH_SAME_WEIGHT.FAST)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForClosestLongWithSameWeight")
    void testGetClosestLongWithSameWeight_throwsExceptionOnAllZero(LongUnaryOperator algorithm) {
        assertThrows(IllegalArgumentException.class, () -> algorithm.applyAsLong(0L));
    }

    @ParameterizedTest
    @MethodSource("sourceForClosestLongWithSameWeight")
    void testGetClosestLongWithSameWeight_throwsExceptionOnAllOne(LongUnaryOperator algorithm) {
        assertThrows(IllegalArgumentException.class, () -> algorithm.applyAsLong(-1L));
    }

    @ParameterizedTest
    @MethodSource("sourceForClosestLongWithSameWeight")
    void testGetClosestLongWithSameWeight(LongUnaryOperator algorithm) {
        long[][] numbers = new long[][]{
                {1, 2},
                {100, 98},
                {-100, -102},
                {500, 498},
                {Long.MAX_VALUE - 1, Long.MAX_VALUE - 2},
                {-2, -3},
                {-739292838311L, -739292838312L}
        };
        for (long[] number : numbers) {
            long result = algorithm.applyAsLong(number[0]);

            assertEquals(
                    Math.abs(result - number[0]),
                    Math.abs(number[0] - number[1]),
                    "Wrong difference on number " + number[0] + ", got the closest " + result +
                            " but expected is " + number[1]
            );
            assertEquals(
                    countBitsByShifting(result),
                    countBitsByShifting(number[0]),
                    "Wrong bits count on number " + number[0] + ", got the closest " + result
            );
        }
    }



    /*
    SUM OF TWO NON-NEGATIVE NUMBERS
     */
    private static Stream<LongBinaryOperator> sourceForGetSumOfTwoNonNegativeLongs() {
        return Stream.of(
                PrimitiveTypesFactory.getSum(PrimitiveTypesFactory.SUM.ITERATION),
                PrimitiveTypesFactory.getSum(PrimitiveTypesFactory.SUM.MASK)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForGetSumOfTwoNonNegativeLongs")
    void testGetSumOfTwoNonNegativeLongs(LongBinaryOperator algorithm) {
        assertEquals(2, algorithm.applyAsLong(1, 1));
        assertEquals(1, algorithm.applyAsLong(1, 0));
        assertEquals(1, algorithm.applyAsLong(0, 1));
        assertEquals(7, algorithm.applyAsLong(2, 5));
        assertEquals(200, algorithm.applyAsLong(100, 100));
        assertEquals(79164837199872L, algorithm.applyAsLong(8796093022208L, 70368744177664L));
    }



    /*
    PRODUCT OF TWO NON-NEGATIVE NUMBERS
     */
    private static Stream<LongBinaryOperator> sourceForGetProductOfTwoNonNegativeLongs() {
        return Stream.of(
                PrimitiveTypesFactory.getProduct(PrimitiveTypesFactory.PRODUCT.BRUTEFORCE, PrimitiveTypesFactory.SUM.MASK),
                PrimitiveTypesFactory.getProduct(PrimitiveTypesFactory.PRODUCT.SCHOOL_METHOD, PrimitiveTypesFactory.SUM.MASK)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForGetProductOfTwoNonNegativeLongs")
    void testGetProductOfTwoNonNegativeLongs(LongBinaryOperator algorithm) {
        assertEquals(1, algorithm.applyAsLong(1, 1));
        assertEquals(0, algorithm.applyAsLong(1, 0));
        assertEquals(0, algorithm.applyAsLong(0, 1));
        assertEquals(10, algorithm.applyAsLong(2, 5));
        assertEquals(10000, algorithm.applyAsLong(100, 100));
        assertEquals(16, algorithm.applyAsLong(4, 4));
        assertEquals(1024 * 1024, algorithm.applyAsLong(1024, 1024));
    }



    /*
    QUOTIENT OF TWO POSITIVE NUMBERS
     */
    private static Stream<LongBinaryOperator> sourceForGetQuotientOfTwoPositiveLongs() {
        return Stream.of(
                PrimitiveTypesFactory.getQuotient(PrimitiveTypesFactory.QUOTIENT.BRUTEFORCE),
                PrimitiveTypesFactory.getQuotient(PrimitiveTypesFactory.QUOTIENT.SCHOOL_METHOD)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForGetQuotientOfTwoPositiveLongs")
    void testGetQuotientOfTwoPositiveLongs(LongBinaryOperator algorithm) {
        assertEquals(2, algorithm.applyAsLong(10, 5));
        assertEquals(1, algorithm.applyAsLong(10, 10));
        assertEquals(12438085, algorithm.applyAsLong(7912873491783L, 636181));
        assertEquals(100, algorithm.applyAsLong(100, 1));
        assertEquals(0, algorithm.applyAsLong(10, 100));
    }



    /*
    POWER
     */
    private static Stream<ToDoubleBiFunction<Double, Integer>> sourceForGetPower() {
        return Stream.of(
                PrimitiveTypesFactory.getPower(PrimitiveTypesFactory.POWER.BRUTEFORCE),
                PrimitiveTypesFactory.getPower(PrimitiveTypesFactory.POWER.FAST)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForGetPower")
    void testGetPower(ToDoubleBiFunction<Double, Integer> algorithm) {
        assertEquals(1.0, algorithm.applyAsDouble(10.0, 0), 1.e-10);
        assertEquals(10.0, algorithm.applyAsDouble(10.0, 1), 1.e-10);
        assertEquals(100000.0, algorithm.applyAsDouble(10.0, 5), 1.e-10);
        assertEquals(1, algorithm.applyAsDouble(-35.4, 0), 1.e-10);
        assertEquals(4747561509943.0, algorithm.applyAsDouble(7.0, 15), 1.e-10);
        assertEquals(833577583.1236198, algorithm.applyAsDouble(7.8, 10), 1.e-6);
    }



    /*
    REVERSE DIGITS
    */
    @Test
    void testGetReverseDigits() {
        assertEquals(0, reverseDigits(0));
        assertEquals(1, reverseDigits(1));
        assertEquals(-1, reverseDigits(-1));
        assertEquals(1, reverseDigits(10));
        assertEquals(937192173917L, reverseDigits(719371291739L));

    }



    /*
    IS PALINDROME
     */
    private static Stream<LongPredicate> sourceForIsPalindrome() {
        return Stream.of(
                PrimitiveTypesFactory.getIsPalindrome(PrimitiveTypesFactory.IS_PALINDROME.BRUTEFORCE),
                PrimitiveTypesFactory.getIsPalindrome(PrimitiveTypesFactory.IS_PALINDROME.DIGITS)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForIsPalindrome")
    void testIsPalindrome(LongPredicate algorithm) {
        assertFalse(algorithm.test(-10));
        assertTrue(algorithm.test(0));
        assertTrue(algorithm.test(1));
        assertTrue(algorithm.test(121L));
        assertFalse(algorithm.test(1231L));
        assertTrue(algorithm.test(7435665347L));
        assertTrue(algorithm.test(74356265347L));
        assertFalse(algorithm.test(7435865347L));
    }



    /*
    UNIFORM RANDOM NUMBER
     */
    @Test
    void testGenerateUniformRandomNumber() {
        // Damn, randomness tests are quite complex, maybe later when I'll have more time
    }



    /*
    CHECK INTERSECTION OF TWO RECTANGLES
     */
    @Test
    void testRectangleClass() {
        Rectangle rectangle = new Rectangle(100, 300, 800, -999);

        assertEquals(100, rectangle.x);
        assertEquals(300, rectangle.y);
        assertEquals(800, rectangle.width);
        assertEquals(-999, rectangle.height);
    }

    @Test
    void testCheckTwoRectanglesHaveIntersectionReturnsNull() {
        assertNull(checkTwoRectanglesHaveIntersection(
                new Rectangle(0, 0, 10, 20),
                new Rectangle(100, 100, 40, 30)
        ));
    }

    @Test
    void testCheckTwoRectanglesHaveIntersectionReturnsRectangle() {
        assertEquals(
                new Rectangle(10, 10, 4, 5),
                checkTwoRectanglesHaveIntersection(
                    new Rectangle(0, 0, 20, 20),
                    new Rectangle(10, 10, 4, 5)
                )
        );
    }



    /*
    CHECK ARW FOUR POINTS FORM AN ALIGNED RECTANGLE ON A PLANE
     */
    @Test
    void testPointClass() {
        Point point = new Point(100, 300);

        assertEquals(100, point.x);
        assertEquals(300, point.y);
    }

    @Test
    void testAreForPointsFormRectangleReturnsFalse() {
        assertFalse(DoFourPointsFormRectangle(
                new Point(0, 0), new Point(1, 10),
                new Point(1, 0), new Point(0, 1)
        ));
    }

    @Test
    void testDoForPointsFormRectangleReturnsTrue() {
        assertTrue(DoFourPointsFormRectangle(
                new Point(10, 10), new Point(0, 10),
                new Point(10, 0), new Point(0, 0)
        ));
    }
}
