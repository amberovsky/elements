package pro.amberovsky.elements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arrays {
    /**
     * Swap 2 elements in an array
     *
     * @param array array
     * @param from from index
     * @param to to index
     *
     * @return array with swapped elements
     */
    public static int[] swap(int[] array, final int from, final int to) {
        int t = array[to];
        array[to] = array[from];
        array[from] = t;

        return array;
    }



    /*
    REORDER EVEN
     */
    /**
     * @Complexity O(n), O(1) space
     *
     * @param array
     *
     * @return array with elements reordered so that the even entries appear first
     */
    public static int[] reorderEven(int[] array) {
        int nextEven = 0;
        int nextOdd = array.length - 1;

        while (nextEven < nextOdd) {
            if (array[nextEven] % 2 == 0) nextEven++;
            else swap(array, nextOdd--, nextEven);
        }

        return array;
    }

    /*
    DUTCH FLAG with variants

    Write a program that takes an array A and an index i into A, and rearranges the elements such that
    all elements less than A[i] (the "pivot") appear first, followed by elements equal to the pivot,
    followed by elements greater than the pivot.
     */

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param array array
     * @param pivotIndex index of pivot
     *
     * @return reordered array
     */
    public static int[] DutchFlag(int[] array, final int pivotIndex) {
        int equal = 0;
        int greater = array.length - 1;

        int pivot = array[pivotIndex];
        int curIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[curIndex] < pivot) {
                swap(array, equal++, curIndex);
            } else if (array[curIndex] > pivot) {
                swap(array, greater--, curIndex--);
            }

            curIndex++;
        }

        return array;
    }

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * Assuming that elements take one of three values, reorder the array so that all objects with the same key
     * appear together.
     *
     * @param array array
     * @param value1 value 1
     * @param value2 value 2
     * @param value3 value 3
     *
     * @return reordered array
     */
    public static int[] DutchFlag_OnlyThreeValues(int[] array, final int value1, final int value2, final int value3) {
        int equalToValue2 = 0;
        int equalToValue3 = array.length - 1;

        int currentIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[currentIndex] == value1) swap(array, equalToValue2++, currentIndex);
            else if (array[currentIndex] == value3) swap(array, equalToValue3--, currentIndex--);

            currentIndex++;
        }

        return array;
    }

    /**
     * Assuming that elements take one of four values, reorder the array so that all objects with the same key
     * appear together.
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param array array
     * @param value1 value 1
     * @param value2 value 2
     * @param value3 value 3
     * @param value4 value 4
     *
     * @return reordered array
     */
    public static int[] DutchFlag_OnlyFourValues(
            int[] array,
            final int value1,
            final int value2,
            final int value3,
            final int value4
    ) {
        int value2StartsAt = 0;
        int value3StartsAt = 0;
        int value4EndsAt = array.length - 1;
        int currentIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[currentIndex] == value1) {
                swap(array, currentIndex, value3StartsAt);
                swap(array, value3StartsAt++, value2StartsAt++);
            } else if (array[currentIndex] == value2) {
                swap(array, currentIndex, value3StartsAt++);
            } else if (array[currentIndex] == value4) {
                swap(array, value4EndsAt--, currentIndex--);
            }

            currentIndex++;
        }

        return array;
    }

    /**
     * Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param array array
     *
     * @return reordered array
     */
    public static int[] DutchFlag_OnlyTwoValues(int[] array) {
        int trueIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) { // false
                swap(array, trueIndex++, i);
            }
        }

        return array;
    }

    /**
     * Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first
     *
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param array array
     *
     * @return reordered array
     */
    public static int[] DutchFlag_OnlyTwoValuesKeepOrderOfOneValue(int[] array) {
        int trueIndex = array.length - 1;
        int falseIndex = array.length - 1;

        while (trueIndex >= 0) {
            swap(array, trueIndex, falseIndex);
            while ((falseIndex >= 0) && (array[falseIndex] == 1)) falseIndex--; // Find the position of next false
            trueIndex = Math.min(trueIndex, falseIndex);
            while ((trueIndex >= 0) && (array[trueIndex] == 0)) trueIndex--;
        }

        return array;
    }

    /*
    INCREMENT AN ARBITRARY-PRECISION INTEGER

    The task is add 1 to given array of digits representing a number of any length
     */

    /**
     * @Complexity O(n), n is the number of digits
     * @Algorithm One iteration
     *
     * @param number digit-representation of a number
     *
     * @return number + 1
     */
    public static List<Integer> addOne(List<Integer> number) {
        int carry = 1;
        for (int i = number.size() - 1; (i >= 0) && (carry == 1); i--) {
            int newValue = number.get(i) + carry;
            carry = newValue / 10;
            newValue %= 10;
            number.set(i, newValue);
        }

        if (carry > 0) number.add(0, 1);
        return number;
    }

    /**
     * @Complexity O(n), O(n) space, where n is max(len(number1), len(number2))
     * @Algorithm
     *
     * Add two numbers in binary representations
     *
     * @param number1 first number
     * @param number2 second number
     *
     * @return sum in binary representation
     */
    public static String addOne_TwoBinaryNumbers(String number1, String number2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < Math.max(number1.length(), number2.length()); i++) {
            int value1 = (i < number1.length()) ? number1.charAt(number1.length() - i - 1) - '0' : 0;
            int value2 = (i < number2.length()) ? number2.charAt(number2.length() - i - 1) - '0' : 0;

            int sum;

            if (value1 == value2) {
                sum = carry;
                carry = value1;
            } else {
                sum = value1 ^ value2 ^ carry;
                carry = 1 - ((value1 | value2) ^ carry);
            }

            result.append(sum);
        }

        if (carry == 1) result.append(1);

        return result.reverse().toString();
    }
}
