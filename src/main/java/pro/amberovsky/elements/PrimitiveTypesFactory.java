package pro.amberovsky.elements;

import pro.amberovsky.elements.util.Function.TriFunction;

import java.util.function.*;

/**
 * Factories for PrimitiveTypes class
 */
public class PrimitiveTypesFactory {
    /**
     * Algorithms for PARITY
     */
    public enum PARITY { BRUTEFORCE, ERASELOWESTSETBIT, LOOKUP, XOR }

    /**
     * @param algorithm which one for PARITY
     *
     * @return function to calculate PARITY
     */
    public static Function<Integer, Short> getParity(PARITY algorithm) {
        switch (algorithm) {
            case BRUTEFORCE:
                return PrimitiveTypes::getParityByBruteforce;

            case ERASELOWESTSETBIT:
                return PrimitiveTypes::getParityByErasingLowestSetBit;

            case LOOKUP:
                return PrimitiveTypes::getParityByLookup;

            case XOR:
                return PrimitiveTypes::getParityByXOR;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for SWAP
     */
    public enum SWAP { BRUTEFORCE }

    /**
     * @param algorithm which one for SWAP
     *
     * @return function to perform SWAP
     */
    public static TriFunction<Integer, Integer, Integer, Integer> getSwap(SWAP algorithm) {
        switch (algorithm) {
            case BRUTEFORCE:
                return PrimitiveTypes::swapByBruteforce;

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Algorithms for REVERSE_BITS
     */
    public enum REVERSE_BITS { ITERATION, MASK, SWAP, LOOKUP }

    /**
     * @param algorithm which one for REVERSE_BITS
     *
     * @return operator to perform REVERSE_BITS
     */
    public static LongUnaryOperator getReverseBits(REVERSE_BITS algorithm) {
        switch (algorithm) {
            case ITERATION:
                return PrimitiveTypes::reverseBitsByIteration;

            case MASK:
                return PrimitiveTypes::reverseBitsByMask;

            case SWAP:
                return PrimitiveTypes::reversBitsBySwap;

            case LOOKUP:
                return PrimitiveTypes::reverseBitsByLookup;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for CLOSEST NUMBER WITH SAME WEIGHT
     */
    public enum CLOSEST_WITH_SAME_WEIGHT { ITERATION, FAST }

    /**
     * @param algorithm which one for CLOSEST NUMBER WITH SAME WEIGHT
     *
     * @return operator to perform CLOSEST NUMBER WITH SAME WEIGHT
     */
    public static LongUnaryOperator getClosestWithSameWeight(CLOSEST_WITH_SAME_WEIGHT algorithm) {
        switch (algorithm) {
            case ITERATION:
                return PrimitiveTypes::getClosestLongWithSameWeightByIteration;

            case FAST:
                return PrimitiveTypes::getClosestLongWithSameWeightByFast;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for SUM
     */
    public enum SUM { ITERATION, MASK }

    /**
     * @param algorithm which one for SUM
     *
     * @return operator to perform SUM
     */
    public static LongBinaryOperator getSum(SUM algorithm) {
        switch (algorithm) {
            case ITERATION:
                return PrimitiveTypes::getSumOfTwoNonNegativeLongsByIteration;

            case MASK:
                return PrimitiveTypes::getSumOfTwoNonNegativeLongsByMask;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for PRODUCT
     */
    public enum PRODUCT { BRUTEFORCE, SCHOOL_METHOD }

    /**
     * @param productAlgorithm which one for PRODUCT
     * @param sumAlgorithm which one for SUM
     *
     * @return operator to perform PRODUCT
     */
    public static LongBinaryOperator getProduct(PRODUCT productAlgorithm, SUM sumAlgorithm) {

        /*
         * Intermediate class to use lambda method binding in the switch later
         */
        class Operator implements LongBinaryOperator {
            private TriFunction<Long, Long, SUM, Long> productOperator;

            private Operator(TriFunction<Long, Long, SUM, Long> productOperator) {
                this.productOperator = productOperator;
            }

            @Override
            public long applyAsLong(long left, long right) {
                return productOperator.apply(left, right, sumAlgorithm);
            }
        }

        switch (productAlgorithm) {
            case BRUTEFORCE:
                return new Operator(PrimitiveTypes::getProductOfTwoNonNegativeLongsByBruteforce);

            case SCHOOL_METHOD:
                return new Operator(PrimitiveTypes::getProductOfTwoNonNegativeLongsBySchoolMethod);

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for QUOTIENT
     */
    public enum QUOTIENT { BRUTEFORCE, SCHOOL_METHOD }

    /**
     * @param algorithm which one for QUOTIENT
     *
     * @return operator to perform QUOTIENT
     */
    public static LongBinaryOperator getQuotient(QUOTIENT algorithm) {
        switch (algorithm) {
            case BRUTEFORCE:
                return PrimitiveTypes::getQuotientOfTwoPositiveLongsByBruteforce;

            case SCHOOL_METHOD:
                return PrimitiveTypes::getQuotientOfTwoPositiveLongsBySchoolMethod;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for POWER
     */
    public enum POWER { BRUTEFORCE, FAST }

    /**
     * @param algorithm which one for POWER
     *
     * @return function to perform POWER
     */
    public static ToDoubleBiFunction<Double, Integer> getPower(POWER algorithm) {
        switch (algorithm) {
            case BRUTEFORCE:
                return PrimitiveTypes::getPowerByBruteforce;

            case FAST:
                return PrimitiveTypes::getPowerByFast;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for IS_PALINDROME
     */
    public enum IS_PALINDROME { BRUTEFORCE , DIGITS }

    /**
     * @param algorithm which one for IS_PALINDROME
     *
     * @return predicate to perform IS_PALINDROME
     */
    public static LongPredicate getIsPalindrome(IS_PALINDROME algorithm) {
        switch (algorithm) {
            case BRUTEFORCE:
                return PrimitiveTypes::isPalindromeByBruteforce;

            case DIGITS:
                return PrimitiveTypes::isPalindromeByDigits;

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * @return BiFunction which generates uniform random number [from, to]
     */
    public static ToLongBiFunction<Long, Long> getGenerateUnifromRandomNumber() {
        return (from, to) -> PrimitiveTypes.generateUniformRandomNumber(from, to, () -> Math.random() < 0.5);
    }
}
