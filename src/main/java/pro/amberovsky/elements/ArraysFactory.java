package pro.amberovsky.elements;

import java.util.function.*;

/**
 * Factories for PrimitiveTypes class
 */
public class ArraysFactory {
    /**
     * Algorithms for DELETE DUPLICATES
     */
    public enum DELETE_DUPLICATES { BRUTEFORCE, FAST }

    /**
     * @param algorithm which one for DELETE DUPLICATES
     *
     * @return operator to delete duplicates
     */
    public static UnaryOperator<Integer[]> getDeleteDuplicates(DELETE_DUPLICATES algorithm) {
        switch (algorithm) {
            case BRUTEFORCE:
                return Arrays::deleteDuplicates_Bruteforce;

            case FAST:
                return Arrays::deleteDuplicates_Fast;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for BUY AND SELL A STOCK TWICE
     */
    public enum BUY_AND_SELL_A_STOCK_TWICE { ONE_ITERATION, SPACE }

    /**
     * @param algorithm which one for BUY AND SELL A STOCK TWICE
     *
     * @return function to calculate profit
     */
    public static Function<Integer[], Integer> getBuyAndSellAStockTwice(BUY_AND_SELL_A_STOCK_TWICE algorithm) {
        switch (algorithm) {
            case ONE_ITERATION:
                return Arrays::buyAndSellAStockTwice;

            case SPACE:
                return Arrays::buyAndSellAStockTwice_Space;

            default:
                throw new IllegalArgumentException();
        }
    }



    /**
     * Algorithms for PERMUTE THE ELEMENTS OF AN ARRAY
     */
    public enum PERMUTE_THE_ELEMENTS_OF_AN_ARRAY { ONE_ITERATION, SPACE }

    /**
     * @param algorithm which one for PERMUTE THE ELEMENTS OF AN ARRAY
     *
     * @return binary operator to perform permutation
     */
    public static BinaryOperator<Integer[]> getPermuteTheElementsOfAnArray(PERMUTE_THE_ELEMENTS_OF_AN_ARRAY algorithm) {
        switch (algorithm) {
            case ONE_ITERATION:
                return Arrays::permuteTheElementsOfAnArray;

            case SPACE:
                return Arrays::permuteTheElementsOfAnArray_Space;

            default:
                throw new IllegalArgumentException();
        }
    }
}
