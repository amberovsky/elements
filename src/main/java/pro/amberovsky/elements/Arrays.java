package pro.amberovsky.elements;

import pro.amberovsky.elements.util.Function.RandomSupplier;

import java.util.*;

/**
 * Various tasks on arrays
 */
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

    public static <T> T[][] swap2D(T[][] array, final int r1, final int c1, final int r2, final int c2) {
        T t = array[r2][c2];
        array[r2][c2] = array[r1][c1];
        array[r1][c1] = t;

        return array;
    }


    /**
     * Swap 2 elements in a generic array
     *
     * @param array array
     * @param from from index
     * @param to to index
     *
     * @return array with swapped elements
     */
    public static <T> T[]swap(T[] array, final int from, final int to) {
        T t = array[to];
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
    public static Integer[] reorderEven(Integer[] array) {
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
     * @Complexity O(n), n is the number of digits, O(1) space
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



    /*
    MULTIPLY TWO ARBITRARY-PRECISION INTEGERS
     */

    /**
     * @Complexity O(mn), O(mn) space
     * @Algorithm school multiplication
     *
     * @param number1 first number
     * @param number2 second number
     *
     * @return product
     */
    public static List<Integer> multiply(List<Integer> number1, List<Integer> number2) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(number1.size() + number2.size(), 0));

        int sign = Integer.signum(number1.get(0)) * Integer.signum(number2.get(0));

        number1.set(0, Math.abs(number1.get(0)));
        number2.set(0, Math.abs(number2.get(0)));

        for (int i = number1.size() - 1; i >= 0; i--) {
            for (int k = number2.size() - 1; k>= 0; k--) {
                result.set(i + k + 1, result.get(i + k + 1) + number1.get(i) * number2.get(k));
                result.set(i + k, result.get(i + k) + result.get(i + k + 1) / 10);
                result.set(i + k + 1, result.get(i + k + 1) % 10);
            }
        }

        int nonzero_pos = 0;

        while ((nonzero_pos < result.size()) && (result.get(nonzero_pos) == 0))
            nonzero_pos++;

        result = result.subList(nonzero_pos, result.size());
        if (result.isEmpty()) {
            return java.util.Arrays.asList(0);
        }

        result.set(0, result.get(0) * sign);
        return result;
    }



    /*
    ADVANCING THROUGH AN ARRAY
     */

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * In a particular board game, a player has to try to advance through a sequence of positions. Each position has a
     * nonnegative integer associated with it, representing the maximum you can advance from that position in one move.
     * You begin at the first position,and win by getting to the last position.

     *
     * @param array board
     *
     * @return can you win the game
     */
    public static boolean boardGame(int[] array) {
        int maximum = 0;

        for (int i = 0; (i <= maximum) && (maximum < array.length); i++) {
            maximum = Math.max(maximum, i + array[i]);
        }

        return (maximum >= array.length - 1);
    }

    // Variant : write a program to compute minimum

    /**
     * @Complexity O(n^2), O(n) space
     *
     * @param array array with steps
     *
     * @return minimum steps to reach the end
     */
    public static int boardGame_MinimumSteps(int[] array) {
        int[] steps = new int[array.length];

        steps[0] = 0;
        for (int i = 1; i < array.length; i++) steps[i] = Integer.MAX_VALUE;


        for (int i = 0; i < array.length; i++) {
            for (int k = 1; k <= array[i]; k++) {
                if (i + k < array.length) steps[i + k] = Math.min(steps[i + k], 1 + steps[i]);
            }
        }

        return steps[array.length - 1];
    }



    /*
    DELETE DUPLICATES FROM SORTED ARRAY
     */

    /**
     * @Complexity O(n^2), O(1) space
     * @Algorithm Bruteforce
     *
     * @param array array
     *
     * @return array with removed duplicates
     */
    public static Integer[] deleteDuplicates_Bruteforce(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i + 1;

            while ((k < array.length) && (array[k].equals(array[i]))) k++;

            if (k != i + 1) {
                for (int p = k; p < array.length; p++) array[i + p - k + 1] = array[p];
                for (int p = array.length - k + i + 1; p < array.length; p++) array[p] = 0;
            }
        }

        return array;
    }

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param array array
     *
     * @return array with removed duplicates
     */
    public static Integer[] deleteDuplicates_Fast(Integer[] array) {
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[index])) array[++index] = array[i];
        }

        for (int i = index + 1; i < array.length; i++) array[i] = 0;

        return array;
    }

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * Implement a function which takes as input an array and a key and updates the array so that all occurrences
     *  of the input key have been removed and the remaining elements have been shifted left to fill the emptied
     *  indices.
     *
     * @param array array
     * @param key input key
     *
     * @return array with removed duplicates
     */
    public static Integer[] deleteDuplicates_OneKey(Integer[] array, int key) {
        int diff = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) diff++;
            else array[i - diff] = array[i];
        }

        for (int i = array.length - diff; i < array.length; i++) array[i] = 0;

        return array;
    }

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * Write a program which takes as input a sorted array A of integers and a positive integer m,and updates A so
     * that if x appears m times in A it appears exactly min(2,m) times in A.
     *
     * @param array array
     * @param m positive integer
     *
     * @return array with removed duplicates
     */
    public static Integer[] deleteDuplicates_Min2m(Integer[] array, int m) {
        int lastIndex = 0;
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[lastIndex])) {
                array[lastIndex + count] = array[i];
                count++;
            }
            else {
                lastIndex += count < m ? count : Math.min(2, m);
                count = 1;
                array[lastIndex] = array[i];
            }
        }

        for (int i = lastIndex + (count < m ? count : Math.min(2, m)); i < array.length; i++) array[i] = 0;

        return array;
    }



    /*
    BUY AND SELL A STOCK ONCE

    without variant
     */

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param stocks array with stocks
     *
     * @return maximum profit
     */
    public static int buyAndSellAStockOnce(int[] stocks) {
        int profit = 0;
        int lowestMin = Integer.MAX_VALUE;

        for (int stock : stocks) {
            lowestMin = Math.min(lowestMin, stock);
            profit = Math.max(profit, stock - lowestMin);
        }

        return profit;
    }



    /*
    BUY AND SELL A STOCK TWICE

    Write a program that computes the maximum profit that can be made by buying and selling a share at most twice.
    The second buy must be made on another date after the first sale.
     */

    /**
     * @Complexity O(n), O(n) space
     * @Algorithm One iteration
     *
     * @param stocks array of stocks
     *
     * @return maximum profit
     */
    public static int buyAndSellAStockTwice(Integer[] stocks) {
        int profit1[] = new int[stocks.length];
        int profit2[] = new int[stocks.length];

        int profit = 0;
        int lowestMin = Integer.MAX_VALUE;

        for (int i = 0; i < stocks.length; i++) {
            lowestMin = Math.min(lowestMin, stocks[i]);
            profit1[i] = profit = Math.max(profit, stocks[i] - lowestMin);
        }


        profit = 0;
        int biggerMax = 0;

        for (int i = stocks.length - 1; i >= 0; i--) {
            profit2[i] = profit = Math.max(profit, biggerMax - stocks[i]);
            biggerMax = Math.max(biggerMax, stocks[i]);

        }

        profit = 0;

        for (int i = 0; i < stocks.length - 1; i++) {
            profit = Math.max(profit, profit1[i] + profit2[i + 1]);
        }

        return profit;
    }


    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param stocks array of stocks
     *
     * @return max profit
     */
    public static int buyAndSellAStockTwice_Space(Integer[] stocks) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int stock: stocks) {
            buy1 = Math.max(buy1, -stock);
            sell1 = Math.max(sell1, stock + buy1);
            buy2 = Math.max(buy2, sell1 - stock);
            sell2 = Math.max(sell2, stock + buy2);
        }

        return sell2;
    }



    /*
    ENUMERATE ALL PRIMES TO n
     */

    /**
     * @Complexity O(n log log n), O(n) space
     * @Algorithm Sieve of Eratosthenes
     *
     * @param n number, inclusive
     *
     * @return list of prime numbers
     */
    public static List<Integer> enumerateAllPrimes(int n) {
        List<Integer> list = new ArrayList<>();

        boolean numbers[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) numbers[i] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (numbers[i] && ((i == 2) || ((i & 1) == 1))) {
                for (int k = i; k <= n / i; k++) {
                    numbers[i * k] = false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (numbers[i]) list.add(i);
        }

        return list;
    }



    /*
    PERMUTE THE ELEMENTS OF AN ARRAY
     */

    /**
     * @Complexity O(n), O(n) space
     * @Algorithm One iteration
     *
     * @param array array with numbers
     * @param p permutation array
     *
     * @return permutated array
     */
    public static Integer[] permuteTheElementsOfAnArray(Integer array[], Integer[] p) {
        Integer copy[] = array.clone();

        for (int i = 0; i < p.length; i++) {
            array[p[i]] = copy[i];
        }

        return array;
    }

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param array array with numbers
     * @param p permutation array
     *
     * @return permutated array
     */
    public static Integer[] permuteTheElementsOfAnArray_Space(Integer array[], Integer[] p) {
        for (int i = 0; i < array.length; i++) {
                int j = i;
                while (p[j] >= 0) {
                    swap(array, i, p[j]);
                    int curr = p[j];
                    p[j] -= array.length;
                    j = curr;
                }
        }

        // Restore permutation array
        for (int i = 0; i < array.length; i++) p[i] += array.length;

        return array;
    }

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm One iteration
     *
     * @param p permutation array
     *
     * @return inversed permutation
     */
    public static Integer[] inversePermutation(Integer[] p) {
        for (int i = 0; i < p.length/2; i++) swap(p, i, p.length - i - 1);

        return p;
    }



    /*
    COMPUTE THE NEXT PERMUTATION
     */

    /**
     * @Complexity O(n), O(1) space
     *
     * @param p permutation
     *
     * @return next permutation
     */
    public static int[] computeTheNextPermutation(int[] p) {
        int index = p.length - 2;

        while ((index >= 0) && (p[index] >= p[index + 1])) index--;

        if (index < 0) return new int[0];

        for (int i = p.length - 1; i > index; i--) {
            if (p[i] > p[index]) {
                swap(p, index, i);
                break;
            }
        }

        // Reverse the suffix
        for (int i = 1; i <= (p.length - index) / 2; i++) {
            swap(p, index + i, p.length - i);
        }

        return p;
    }

    /**
     * Compute k-th permutation, starting from the identity permutation
     *
     * @Complexity O(n^2), O(1) space
     * @Algorithm Factorial number system
     *
     * @param length size of permutation
     * @param k permutation index, starts from 0
     *
     * @return permutation
     */
    public static int[] computeKthPermutation(int length, int k) {
        int indices[] = new int[length];
        int numbers[] = new int[length];

        int divisor = 1;
        for (int i = 1; i <= length; i++) {
            if (k / divisor == 0) break;

            indices[length - i] = (k / divisor) % i;
            divisor *= i;
        }

        for (int i = 0; i < length; i++) numbers[i] = i;

        for (int i = 0; i < length; i++) {
            int index = indices[i] + i;

            if (index != i) {
                int tmp = numbers[index];

                for (int j = index; j > i; j--) numbers[j] = numbers[j - 1];

                numbers[i] = tmp;
            }
        }

        return numbers;

    }


    /**
     * @Complexity O(n), O(1) space
     *
     * @param p permutation
     *
     * @return previous permutation
     */
    public static int[] computeThePreviousPermutation(int p[]) {
        int index = p.length - 2;

        while ((index >= 0) && (p[index] <= p[index + 1])) index--;

        if (index == -1) return new int[0];

        for (int i = p.length - 1; i > index; i--) {
            if (p[i] < p[index]) {
                swap(p, index, i);
                break;
            }
        }

        for (int i = 1; i <= (p.length - index) / 2; i++) {
            swap(p, index + i, p.length - i);
        }

        return p;
    }



    /*
    SAMPLE OFFLINE DATA
     */

    /**
     * @Complexity O(size), O(1) space
     *
     * @param array data
     * @param size length of sample
     *
     * @return array where first size elements are uniformly selected
     */
    public static int[] sampleOfflineData(int[] array, int size) {
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            swap(array, i, random.nextInt(array.length - i) + i);
        }

        return array;
    }



    /*
    SAMPLE ONLINE DATA
     */

    /**
     * @Complexity O(n), O(k) space
     *
     * @param k sizeof the set
     * @param iterator input
     *
     * @return uniform random subset of size k
     */
    public static int[] sampleOnlineData(int k, Iterator<Integer> iterator) {
        int array[] = new int[k];

        for (int i = 0; i < k; i++) array[i] = iterator.next();

        int processed = k;
        Random random = new Random();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            processed++;
            int index = random.nextInt(processed);

            if (index < k) array[index] = next;
        }

        return array;
    }



    /*
    COMPUTE A RANDOM PERMUTATION
     */

    /**
     * @Complexity O(n), O(1) space
     * @Algorithm Sample offline data
     *
     * @param size size of permutation
     *
     * @return permutation
     */
    public static int[] computeARandomPermutation(int size) {
        int permutation[] = new int[size];
        for (int i = 0; i < size; i++) permutation[i] = i;

        Random random = new Random();
        for (int i = 0; i < size - 1; i++) {
            swap(permutation, i, random.nextInt(size - i) + i);
        }

        return permutation;
    }



    /*
    COMPUTE A RANDOM SUBSET

    Assuming that k << n
     */
    /**
     * @Complexity O(k), (k) space
     * @Algorithm Hashtable
     *
     * @param n size of the set
     * @param k size of the requested subset
     * @param random RandomGenerator
     *
     * @return randomly unformed subset size of k
     */
    public static int[] computeARandomSubset(int n, int k, RandomSupplier<Integer> random) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(k * 2);
        int array[] = new int[k];

        for (int i = 0; i < k; i++) {
            int index = i + random.get(n - i);

            int indexValue = hashMap.getOrDefault(index, index);
            hashMap.put(index, hashMap.getOrDefault(i, i));
            hashMap.put(i, indexValue);
        }

        for (int i = 0; i < k; i++) {
            array[i] = hashMap.getOrDefault(i, i);
        }

        return array;
    }



    /*
    GENERATE NONUNIFORM RANDOM NUMBERS
     */

    /**
     * Given a random number generator that produces values in [0,1] uniformly, generate one of the n numbers according
     * to the specified probabilities
     *
     * @Complexity O(n) (Can be O(logn) for subsequent calls), O(n) space
     *
     * @param numbers numbers
     * @param probabilities probabilities for numbers
     * @param random random generator
     *
     * @return selected number
     */
    public static int generateNonuniformRandomNumbers(int numbers[], double probabilities[], RandomSupplier<Double> random) {
        int n = probabilities.length;
        List<Double> intervals = new ArrayList<>(n);
        intervals.add(0.0);

        for (int i = 0; i < n - 1; i++) intervals.add(intervals.get(i) + probabilities[i]);

        double v = random.get(1.0);
        int position = Collections.binarySearch(intervals, v);
        position = (position >= 0) ? position : -(position + 2);

        return numbers[position];

    }



    /*
    THE SUDOKU CHECKER PROBLEM
     */

    /**
     * Check if partial sudoku board valid
     *
     * @Complexity O(n^2), O(n) space
     *
     * @param board sudoku board
     *
     * @return is it valid or not
     */
    public static boolean checkPartialSudoku(int [][]board) {
        for (int i = 0; i < 9; i++) {
            int row[] = new int[9];
            int column[] = new int[9];

            int squareStartColumn = 3 * (i % 3);
            int squareStartRow = 3 * (i / 3);

            int square[] = new int[9];

            // Check row
            for (int k = 0; k < 9; k++) {
                int numberRow = board[i][k];
                int numberColumn = board[k][i];

                if (numberRow != 0) {
                    if (row[numberRow - 1] == 1) return false;
                    row[numberRow - 1] = 1;
                }

                if (numberColumn != 0) {
                    if (column[numberColumn - 1] == 1) return false;
                    column[numberColumn - 1] = 1;
                }

                int numberSquare = board[squareStartRow + k / 3][squareStartColumn + k % 3];
                if (numberSquare != 0) {
                    if (square[numberSquare - 1] == 1) return false;
                    square[numberSquare - 1] = 1;
                }
            }
        }

        return true;
    }


    /*
    COMPUTE THE SPIRAL ORDERING OF A 2D ARRAY
     */

    /**
     * @Complexity O(n^2), O(1) space
     *
     * @param array array of data
     * @param n dimension
     *
     * @return elements of array in the spiral ordering
     */
    public static List<Integer> computeTheSpiralOrderingOfA2DArray(Integer array[][], int n) {
        ArrayList<Integer> list = new ArrayList<>(n * n);

        for (int i = 0; i <= (n - 1) / 2; i++) {
            int length = n - i * 2;

            if (length == 1) list.add(array[i][i]);
            else {
                // Top
                for (int k = 0; k < length; k++) list.add(array[i][k + i]);

                // Right
                for (int k = 1; k < length - 1; k++) list.add(array[k + i][n - 1 - i]);

                // Bottom
                for (int k = length - 1; k >= 0; k--) list.add(array[n - 1 - i][k + i]);

                // Left
                for (int k = length - 2; k >= 1; k--) list.add(array[k + i][i]);
            }
        };

        return list;
    }

    /**
     * Generate 2D array in the spiral order
     *
     * @Complexity O(n^2), O(1) space
     *
     * @param n dimension
     *
     * @return array in the spiral order
     */
    public static Integer[][] generateArrayInTheSpiralOrdering(int n) {
        Integer array[][] = new Integer[n][n];

        int row = 0;
        int column = 0;
        int length = n;
        int iteration = 0;

        final int DIRECTION_RIGHT = 0;
        final int DIRECTION_DOWN = 1;
        final int DIRECTION_LEFT = 2;
        final int DIRECTION_UP = 3;
        int direction = DIRECTION_RIGHT;

        int delta[][] = new int[][] {
                { 0, 1 }, // right
                { 1, 0 }, // down
                { 0, -1 }, // left
                { -1, 0 } // up
        };


        for (int i = 1; i <= n * n; i++) {
            array[row][column] = i;

            int nextRow = row + delta[direction][0];
            int nextColumn = column + delta[direction][1];

            if (
                    (nextColumn == iteration + length) ||
                    (nextColumn < iteration) ||
                    (nextRow == iteration + length) ||
                    ((direction == DIRECTION_UP) && (nextRow == iteration))
            ) {
                if (direction == DIRECTION_UP) {
                    iteration++;
                    length -= 2;
                }

                direction = (direction + 1) % 4;

                nextColumn = column + delta[direction][1];
                nextRow = row + delta[direction][0];
            }

            column = nextColumn;
            row = nextRow;
        }

        return array;
    }

    /**
     * Write a program to enumerate the first n pairs of integers (a,b) in spiral order
     *
     * @Complexity O(n), O(1) space
     *
     * @param n amount of required pairs
     *
     * @return List of first n pairs
     */
    public static List<String> enumerateFirstPairsOfIntegersInSpiralOrder(int n) {
        List<String> list = new ArrayList<>(n);

        int iteration = 0;
        int delta[][] = new int[][] {
                { 1, 0 }, //right
                { 0, -1 }, // down
                { -1, 0 }, // left
                { 0, 1 } // up
        };

        final int DIRECTION_RIGHT = 0;
        final int DIRECTION_DOWN = 1;
        final int DIRECTION_LEFT = 2;
        final int DIRECTION_UP = 3;

        int direction = DIRECTION_RIGHT;

        int x = 0;
        int y = 0;

        int length = 1;
        int points = 0;

        for (int i = 0; i < n; i++) {
            list.add("(" + x + "," + y + ")");


            if (points == length * 2 + (length - 2) * 2) {
                iteration++;
                x = iteration;
                y = iteration - 1;
                length = iteration * 2 + 1;
                direction = DIRECTION_DOWN;
                points = 1;
            } else {
                points++;

                if (points == length) {
                    direction = DIRECTION_LEFT;
                } else if (points == length + length - 1) {
                    direction = DIRECTION_UP;
                } else if (points == length + length - 1 + length - 1) {
                    direction = DIRECTION_RIGHT;
                }

                x += delta[direction][0];
                y += delta[direction][1];
            }
        }

        return list;
    }


    /**
     * Compute the spiral order for an m X n 2D array A
     *
     * @Complexity O(mn), O(1) space
     *
     * @param array array with data
     * @param m rows
     * @param n columns
     *
     * @return spiral order
     */
    public static Integer[] computeTheSpiralOrderOfMNArray(Integer array[][], int m, int n) {
        Integer order[] = new Integer[m * n];

        final int DIRECTION_RIGHT = 0;
        final int DIRECTION_DOWN = 1;
        final int DIRECTION_LEFT = 2;
        final int DIRECTION_UP = 3;

        int direction = DIRECTION_RIGHT;

        int delta[][] = new int[][] {
                { 1, 0 }, // right
                { 0, 1 }, // down
                { -1, 0 }, // left
                { 0, -1 } // up
        };

        int row = 0;
        int column = 0;

        int iteration = 0;
        int columnLength = n;
        int rowLength = m;

        for (int i = 0; i < m * n; i++) {
            order[i] = array[row][column];

            int nextColumn = column + delta[direction][0];
            int nextRow = row + delta[direction][1];

            if (
                    (nextColumn == iteration + columnLength) ||
                    (nextRow == iteration + rowLength) ||
                    (nextColumn < iteration) ||
                    ((direction == DIRECTION_UP) && (nextRow == iteration))
                ) {

                if (direction == DIRECTION_UP) {
                    iteration++;
                    columnLength -= 2;
                    rowLength -= 2;
                }

                direction = (direction + 1) % 4;
                nextColumn = column + delta[direction][0];
                nextRow = row + delta[direction][1];
            }

            column = nextColumn;
            row = nextRow;
        }

        return order;
    }


    /**
     * Compute the last element in spiral order for an m X n 2D array
     *
     * @Complexity O(1), O(1) space
     *
     * @param array given array
     * @param m rows
     * @param n columns
     *
     * @return last element in the spiral order
     */
    public static int computeTheLastElementInSpiralOrderMNArray(Integer[][] array, int m, int n) {
        boolean rotated = false;

        if (m > n) {
            int t = m;
            m = n;
            n = t;
            rotated = true;
        }

        int row = m / 2;
        int column = m % 2 == 0 ? (m / 2 - 1) : n - (m / 2 + 1);

        return rotated ? array[column][row] : array[row][column];
    }



    /*
    Rotate the 2D array by 90 degrees clockwise.
     */

    /**
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return rotated array
     */
    public static Integer[][] rotate2DArray(Integer array[][]) {
        for (int i = 0; i < array.length / 2; i++) {
            for (int k = i; k < array.length - i - 1; k++) {
                swap2D(array, i, k, k, array.length - i - 1);
                swap2D(array, i, k, array.length - i - 1, array.length - k - 1);
                swap2D(array, i, k, array.length - k - 1, i);
            }
        }

        return array;
    }

    /**
     * Reflect 2D array about horizontal axis
     *
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return reflected array
     */
    public static Integer[][] reflect2DArrayHorizontal(Integer[][] array) {
        for (int i = 0; i < array.length / 2; i++) {
            for (int j = 0; j < array.length; j++) {
                swap2D(array, i, j, array.length - i - 1, j);
            }
        }

        return array;
    }

    /**
     * Reflect 2D array about vertical axis
     *
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return reflected array
     */
    public static Integer[][] reflect2DArrayVertical(Integer[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length / 2; j++) {
                swap2D(array, i, j, i, array.length - j - 1);
            }
        }

        return array;
    }

    /**
     * Reflect 2D array about diagonal axis from top-left
     *
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return reflected array
     */
    public static Integer[][] reflect2DArrayDiagonalTopLeft(Integer[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                swap2D(array, i, j, array.length - j - 1, array.length - i - 1);
            }
        }

        return array;
    }

    /**
     * Reflect 2D array about diagonal axis from top-right
     *
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return reflected array
     */
    public static Integer[][] reflect2DArrayDiagonalTopRight(Integer[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                swap2D(array, i, j, j, i);
            }
        }

        return array;
    }



    /*
    COMPUTE ROWS IN PASCAL'S TRIANGLE
     */

    /**
     * @Complexity O(n^2), O(n^2) space
     *
     * @param rows how many rows to generate
     *
     * @return rows
     */
    public static int[][] computeRowsInPascalTriangle(int rows) {
        int triangle[][] = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int row[] = new int[i + 1];
            row[0] = 1;

            if (i > 0) {
                for (int k = 1; k < i; k++) {
                    row[k] = triangle[i - 1][k - 1] + triangle[i - 1][k];
                }

                row[i] = 1;
            }

            triangle[i] = row;
        }

        return triangle;
    }


    /**
     * Compute the nth row of Pascal's triangle
     *
     * @Complexity O(n^2), O(n) space
     *
     * @param n row's number
     *
     * @return nth row
     */
    public static int[] computeNthRowOfPascalTriangle(int n) {
        int row[] = new int[n];

        row[0] = 1;
        row[n - 1] = 1;

        int prevNumber = 1;

        for (int i = 1; i < n; i++) {
            for (int k = 1; k < i; k++) {
                int t = row[k];
                row[k] += prevNumber;

                prevNumber = t;
            }

            row[i] = 1;
        }

        return row;
    }
}
