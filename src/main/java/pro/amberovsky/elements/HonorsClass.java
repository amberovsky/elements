package pro.amberovsky.elements;

import pro.amberovsky.elements.util.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Difficult problems
 */
class HonorsClass {
    /*
    FIND THE FIRST MISSING POSITIVE ENTRY
     */

    /**
     * Find the first missing positive entry
     *
     * @Algorithm One iteration
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return first missing positive entry
     */
    static int findTheFirstMissingPositiveEntry(int array[]) {
        for (int i = 0; i < array.length; i++) {
            while ((array[i] > 0) && (array[i] != i + 1)) {
                int elem = array[i];
                if (array[elem - 1] == elem) break;

                Utilities.swap(array, i, elem - 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) return i + 1;
        }

        return 0;
    }



    /*
    COMPUTE THE MAXIMUM PRODUCT OF ALL ENTRIES BUT ONE
     */

    /**
     * Compute maximum product of all entries but one
     *
     * @Algorithm Suffix array
     * @Complexity O(n), O(n) space
     *
     * @param array array
     *
     * @return maximum product of all entries but one
     */
    static Integer maximumProductOfAllEntriesButOneBySuffixArray(Integer array[]) {
        int suffix[] = new int[array.length];
        suffix[array.length - 1] = 1;

        for (int i = array.length - 1; i > 0; i--) {
            suffix[i - 1] = suffix[i] * array[i];
        }

        int prefixProduct = 1;
        int maximumProduct = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int currentProduct = prefixProduct * suffix[i];
            if (maximumProduct < currentProduct) maximumProduct = currentProduct;

            prefixProduct *= array[i];
        }

        return maximumProduct;
    }

    /**
     * Compute maximum product of all entries but one
     *
     * @Algorithm Count zero and negative entries
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return maximum product of all entries but one
     */
    static Integer maximumProductOfAllEntriesButOneByCountingZeroAndNegatives(Integer array[]) {
        int zeroes = 0;
        int negatives = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) negatives++;
            else if (array[i] == 0) zeroes++;
        }

        if (zeroes > 1) return 0;

        int indexToExclude = -1;

        if ((negatives % 2 == 1)) {
            // find the greatest negative and discard it
            for (int i = 0; i < array.length; i++) {
                if ((array[i] < 0) && ((indexToExclude == -1) || (array[i] > array[indexToExclude]))) indexToExclude = i;
            }
        } else {
            // find the minimum non-negative and discard it

            if (array.length - negatives > 0) {
                for (int i = 0; i < array.length; i++) {
                    if ((array[i] >= 0) && ((indexToExclude == -1) || (array[i] < array[indexToExclude]))) indexToExclude = i;
                }
            } else { // all negatives
                // find the lowest negative and discard

                for (int i = 0; i < array.length; i++) {
                    if ((array[i] < 0) && ((indexToExclude == -1) || (array[i] < array[indexToExclude]))) indexToExclude = i;
                }
            }
        }

        int product = 1;
        for (int i = 0; i < array.length; i++) {
            if (i != indexToExclude) product *= array[i];
        }

        return product;
    }

    /**
     * Variant: compute an array where ith element is a product of all elements except ith
     *
     * @Algorithm Two iterations
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return computed array
     */
    static Integer[] maximumProductOfAllEntriesButOne_ExceptI(Integer array[]) {
        Integer result[] = new Integer[array.length];
        result[0] = 1;

        for (int i = 1; i < array.length; i++) {
            result[i] = array[i - 1] * result[i - 1];
        }

        Integer suffix = 1;

        for (int i = array.length - 2; i >= 0; i--) {
            suffix *= array[i + 1];
            result[i] *= suffix;
        }

        return result;
    }



    /*
    ROTATE AN ARRAY
     */

    /**
     * Rotate array to the right
     *
     * @Algorithm Reverse
     * @Complexity O(n), O(1) space
     *
     * @param array array
     * @param shift how many positions to rotate
     * @param <T> type
     *
     * @return rotated array
     */
    static <T> T[] rotateAnArray(T array[], int shift) {
        shift %= array.length;

        for (int i = 0; i < array.length / 2; i++) Utilities.swap(array, i, array.length - i - 1);

        for (int i = 0; i < shift / 2; i++) Utilities.swap(array, i, shift - i - 1);
        for (int i = shift; i < shift + (array.length - shift) / 2; i++) Utilities.swap(array, i, array.length - i + shift - 1);

        return array;
    }



    /*
    IDENTIFY POSITIONS ATTACKED BY ROOKS
     */

    /**
     * Identify positions attacked by rocks
     *
     * @Algorithm Use first row and column
     * @Complexity O(nm), O(1) space
     *
     * @param board board with zeroes where rocks are
     *
     * @return updated board
     */
    static int[][] identifyPositionsAttackedByRooks(int board[][]) {
        int columns = board[0].length;
        int rows = board.length;



        boolean row0ToBeCleared = false;
        boolean column0ToBeCleared = false;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 0) {
                    if (row == 0) row0ToBeCleared = true;
                    board[0][column] = 0;

                    if (column == 0) column0ToBeCleared = true;
                    board[row][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (board[i][0] == 0) {
                for (int k = 0; k < columns; k++) board[i][k] = 0;
            }
        }

        for (int i = 1; i < columns; i++) {
            if (board[0][i] == 0) {
                for (int k = 0; k < rows; k++) board[k][i] = 0;
            }
        }

        if (row0ToBeCleared) {
            for (int i = 0; i < columns; i++) board[0][i] = 0;
        }

        if (column0ToBeCleared) {
            for (int i = 0; i < rows; i++) board[i][0] = 0;
        }

        return board;
    }



    /*
    JUSTIFY TEXT
     */

    /**
     * Create string with spaces
     *
     * @param words array of words
     * @param startIndex first word
     * @param endIndex second word
     * @param amountOfSpaces how many spaces to distribute
     *
     * @return new string
     */
    private static String formNewLineWithSpaces(String words[], int startIndex, int endIndex, int amountOfSpaces) {
        int numWordsCurrLine = endIndex - startIndex + 1;
        StringBuilder line = new StringBuilder();

        for (int i = startIndex; i < endIndex; ++i) {
            line.append(words[i]);
            --numWordsCurrLine ;
            int numCurrSpace = (int) Math.ceil((double)amountOfSpaces / numWordsCurrLine);

            for (int j = 0; j < numCurrSpace; j++) {
                line.append(" ");
            }

            amountOfSpaces -= numCurrSpace;
        }

        line.append(words[endIndex]);
        for (int i = 0; i < amountOfSpaces; i++) line.append(" ");

        return line.toString();
    }

    /**
     * Justify text
     *
     * @Algorithm Lookahead
     * @Complexity O(n), O(n) space
     *
     * @param words array of words
     * @param maxLength maximum length of each line
     *
     * @return justified lines
     */
    static List<String> justifyText(String words[], int maxLength) {
        int currLineStart = 0;
        int numWordsCurrLine = 0;
        int currLineLength = 0;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; ++i) {
            ++numWordsCurrLine;
            int lookaheadLineLength = currLineLength + words[i].length() + (numWordsCurrLine - 1);

            if (lookaheadLineLength == maxLength) {
                result.add(formNewLineWithSpaces(words, currLineStart, i, i - currLineStart));

                currLineStart = i + 1;
                numWordsCurrLine = 0;
                currLineLength = 0;
            } else if (lookaheadLineLength > maxLength) {
                result.add(formNewLineWithSpaces(words, currLineStart, i - 1, maxLength - currLineLength));

                currLineStart = i;
                numWordsCurrLine = 1;
                currLineLength = words[i].length();
            } else {
                currLineLength += words[i].length();
            }
        }

        if (numWordsCurrLine > 0) {
            StringBuilder line = new StringBuilder(formNewLineWithSpaces(words, currLineStart, words.length - 1, numWordsCurrLine - 1));
            for (int i = 0; i < maxLength - currLineLength - (numWordsCurrLine - 1); i++) {
                line.append(" ");
            }

            result.add(line.toString());
        }

        return result;
    }
}
