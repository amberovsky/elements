package pro.amberovsky.elements;

import java.util.function.BooleanSupplier;
import java.util.function.LongBinaryOperator;

/**
 * Basic tasks with numbers & bits
 */
public class PrimitiveTypes {

    /**
     * @Complexity O(1)
     *
     * @param value 32-bit number
     *
     * @return number with lowest set bit erased
     */
    public static int eraseLowestSetBit(final int value) {
        return value & (value - 1);
    }

    /**
     * @Complexity O(1)
     *
     * @param value 32-bit number
     *
     * @return true if the number is power of two, false otherwise
     */
    public static boolean isPowerOfTwo(final int value) {
        return (value > 0) && ((value & (value - 1)) == 0);
    }

    /**
     * @Complexity O(k), k is the number of set bits
     * @Algorithm Shifting
     *
     * @param value 64-bit number
     *
     * @return amount of set bits in the number
     */
    public static short countBitsByShifting(long value) {
        short count = 0;

        while (value != 0) {
            count += value & 1;
            value >>>= 1;
        }

        return count;
    }


    /**
     * Bitmask used for lookup tables to get 16-bit number from 32/64 bits
     */
    final static int LOOKUP_BIT_MASK = 0xFFFF;


    /*
    PARITY:

    Parity of a number is 1 if amount of set bits of a given number is odd, 0 otherwise
     */

    /**
     * @Complexity O(k), k is the number of set bits
     * @Algorithm Bruteforce
     *
     * @param value 32-bit number
     *
     * @return parity
     */
    public static short getParityByBruteforce(int value) {
        short count = 0;

        while (value != 0) {
            count ^= value & 1;
            value >>>= 1;
        }

        return count;
    }

    /**
     * @Complexity O(k), k is the number of set bits
     * @Algorithm ErasingLowestSetBit
     *
     * @param value 32-bit number
     *
     * @return parity
     */
    public static short getParityByErasingLowestSetBit(int value) {
        short count = 0;

        while (value != 0) {
            count ^= 1;
            value &= (value - 1);
        }

        return count;
    }

    /**
     * Lookup table for parity
     */
    private static short lookupTableForParity[] = null;

    /**
     * @return lookup table for parity. Initializes on request if empty. Thread-safe
     */
    private static short[] getLookupTableForParity() {
        if (lookupTableForParity == null) {
            synchronized ("lookupTableForParity") {
                if (lookupTableForParity == null) {
                    lookupTableForParity = new short[LOOKUP_BIT_MASK + 1];

                    for (int i = 0; i <= LOOKUP_BIT_MASK; i++) {
                        lookupTableForParity[i] = getParityByErasingLowestSetBit(i);
                    }
                }
            }
        }

        return lookupTableForParity;
    }

    /**
     * @Complexity O(n/p), n is the number of bits, p is the number of bits in the LOOKUP_BIT_MASK
     * @Algorithm Lookup (hash)
     *
     * @param value 32-bit number
     *
     * @return parity
     */
    public static short getParityByLookup(int value) {
        short[] lookup = getLookupTableForParity();

        short result = 0;

        while (value != 0) {
            result ^= lookup[value & LOOKUP_BIT_MASK];
            value >>>= 16;
        }

        return result;
    }

    /**
     * @Complexity
     *
     * @Algorithm XOR
     *
     * @param value 32-bit number
     *
     * @return parity
     */
    public static short getParityByXOR(int value) {
        value ^= value >>> 16;
        value ^= value >>> 8;
        value ^= value >>> 4;
        value ^= value >>> 2;
        value ^= value >>> 1;

        return (short) (value & 1);
    }



    /*
    SWAP

    The task is to swap two bits in a number
     */

    /**
     * @Complexity O(1)
     *
     * @param value 32-bit number
     * @param i position of the first bit to swap
     * @param j position of the second bit to swap
     *
     * @return value with swapped bits
     */
    public static int swapByBruteforce(int value, final int i, final int j) {
        if (((value >>> i) & 1) != ((value >>> j) & 1)) {
            int mask = (1 << i) | (1 << j);
            return value ^ mask;
        }

        return value;
    }



    /*
    REVERSE BITS

    The task is to reverse bits in a given number
     */

    /**
     * @Complexity O(n), n is the number of bits
     * @Algorithm Iteration
     *
     * @param value 64-bit number
     *
     * @return reversed
     */
    public static long reverseBitsByIteration(long value) {
        long result = value & 1;

        for (int i = 1; i < Long.SIZE; i++) {
            result <<= 1;
            value >>>= 1;

            result += value & 1;
        }

        return result;
    }

    /**
     * @Complexity O(n), n is the number of bits
     * @Algorithm Mask
     *
     * @param value 64-bit number
     *
     * @return reversed
     */
    public static long reverseBitsByMask(final long value) {
        long vmask = 1;
        long rmask = Long.MIN_VALUE;

        long result = 0L;

        while (vmask != 0) {
            if ((value & vmask) != 0) result |= rmask;

            vmask <<= 1;
            rmask >>>= 1;
        }

        return result;
    }

    /**
     * @Complexity O(n), n is the number of bits
     * @Algorithm Swap
     *
     * @param value 64-bit value
     *
     * @return reversed
     */
    public static long reversBitsBySwap(long value) {
        for (int i = 0; i < 32; i++) {
            long b1 = (value & (1L << i)) >>> i;
            long b2 = ((value & (1L << (63 - i)))) >>> (63 - i);
            if (b1 != b2) {
                value ^= 1 << i;
                value ^= 1L << (63 - i);
            }
        }

        return value;
    }

    /**
     * Lookup table for reverse bits
     */
    private static int[] lookupTableForReverseBits = null;

    /**
     * @return lookup table for reverse bits. Initializes on request if empty. Thread-safe
     */
    private static int[] getLookupTableForReverseBits() {
        if (lookupTableForReverseBits == null) {
            synchronized("lookupTableForReverseBits") {
                if (lookupTableForReverseBits == null) {
                    lookupTableForReverseBits = new int[LOOKUP_BIT_MASK + 1];

                    for (int i = 0; i < LOOKUP_BIT_MASK + 1; i++) {
                        lookupTableForReverseBits[i] = (int) (reverseBitsByMask(i) >>> Short.SIZE * 3);
                    }
                }
            }
        }

        return lookupTableForReverseBits;
    }

    /**
     * @Complexity
     *
     * @Algorithm Lookup (hash)
     *
     * @param value 64-bit number
     *
     * @return reversed
     */
    public static long reverseBitsByLookup(long value) {
        int[] lookupTable = getLookupTableForReverseBits();

        long w1 = lookupTable[(int) (value >>> Short.SIZE * 3)];
        long w2 = lookupTable[(int) ((value >>> Short.SIZE * 2) & LOOKUP_BIT_MASK)];
        long w3 = lookupTable[(int) ((value >>> Short.SIZE) & LOOKUP_BIT_MASK)];
        long w4 = lookupTable[(int) (value & LOOKUP_BIT_MASK)];

        return  w1 + (w2 << Short.SIZE) + (w3 << Short.SIZE * 2) + (w4 << Short.SIZE * 3);
    }



    /*
     Closest number with same weight.

     The task is top find a number with minimum absolute difference to the given value and with same weight.
     */

    /**
     * @Complexity  O(n), n is the number of bits
     * @Algorithm Iteration
     *
     * @param value 64-bit number
     *
     * @return closest number
     */
    public static long getClosestLongWithSameWeightByIteration(long value) {
        long mask = 1L;

        if ((value & mask) == 1) {
            while ((mask != 0) && ((value & mask) == mask)) mask <<= 1;
        } else {
            while ((mask != 0) && ((value & mask) != mask)) mask <<= 1;
        }

        if (mask != 0) return value ^ mask ^ (mask >>> 1);

        throw new IllegalArgumentException();
    }

    /**
     * @Complexity O(1)
     * @Algorithm Fast
     *
     * @param value 64-bit number
     *
     * @return closest number
     */
    public static long getClosestLongWithSameWeightByFast(long value) {
        // For Long.MAX_VALUE we can find a suitable constant although
        if ((value == Long.MAX_VALUE) || (value == 0) || (value == -1)) throw new IllegalArgumentException();

        long value2 = value;

        if (value % 2 != 0) {
            value2 = value + 1;
        }

        long lastBit = value2 & ~(value2 - 1);
        return value ^ lastBit ^ (lastBit >>> 1);
    }



    /*
    SUM:

    Sum of two non-negative numbers
     */

    /**
     * @Complexity O(n), n is the number of bits
     * @Algorithm Iteration
     *
     * @param x first 64-bit non-negative number
     * @param y second 64-bit non-negative number
     *
     * @return sum of the numbers
     */
    public static long getSumOfTwoNonNegativeLongsByIteration(final long x, final long y) {
        long result = y;
        long carry = 0L;

        for (long mask = 1L; mask > 0; mask <<= 1) {
            long resultBit = result & mask;
            long xBit = x & mask;

            if ((resultBit == 0L) && (xBit == 0L)) {
                result = result | carry;
                carry = 0L;
            } else if ((resultBit > 0) && (xBit > 0)) {
                result = result ^ mask | carry;
                carry = mask << 1;
            } else {
                result = (result | xBit) ^ carry;
                if (carry > 0) carry = mask << 1;
            }
        }

        return result;
    }

    /**
     * @Complexity O(k), n is the number of set bits in the second number
     * @Algorithm mask
     *
     * @param x first 64-bit non-negative number
     * @param y second 64-bit non-negative number
     *
     * @return sum of the numbers
     */
    public static long getSumOfTwoNonNegativeLongsByMask(long x, long y) {
        while (y != 0) {
            long t = x & y;
            x ^= y;
            y = t << 1;
        }

        return x;
    }



    /*
    PRODUCT

    Product of two non-negative numbers
     */

    /**
     * @Complexity O(2^n), n is the number of bits
     * @Algorithm Bruteforce
     *
     * @param x first 64-bit non-negative number
     * @param y second 64-bit non-negative number
     * @param sum algorithm for addition
     *
     * @return product of the numbers
     */
    public static long getProductOfTwoNonNegativeLongsByBruteforce(
            final long x,
            final long y,
            PrimitiveTypesFactory.SUM sum
    ) {
        long result = 0;
        long counter = 0L;

        LongBinaryOperator sumAlgorithm = PrimitiveTypesFactory.getSum(sum);

        while ((counter ^ y) != 0) {
            counter = sumAlgorithm.applyAsLong(counter, 1);
            result = sumAlgorithm.applyAsLong(result, x);
        }

        return result;
    }

    /**
     * @Complexity O(n) * Complexity of addition, n is the number of bits
     * @Algorithm SchoolMethod
     *
     * @param x first 64-bit non-negative number
     * @param y second 64-bit non-negative number
     * @param sum algorithm for addition
     *
     * @return product of the numbers
     */
    public static long getProductOfTwoNonNegativeLongsBySchoolMethod(long x, long y, PrimitiveTypesFactory.SUM sum) {
        long result = 0;

        LongBinaryOperator sumAlgorithm = PrimitiveTypesFactory.getSum(sum);

        while (x != 0) {
            if ((x & 1) == 1) {
                result = sumAlgorithm.applyAsLong(result, y);
            }

            x >>>= 1;
            y <<= 1;
        }
        return result;
    }



    /*
    QUOTIENT

    Task is to find a quotient for two positive numbers
     */

    /**
     * @Complexity O(2^n), n is the number of bits
     * @Algorithm Bruteforce
     *
     * @param x divident
     * @param y divisor
     *
     * @return quotient
     */
    public static long getQuotientOfTwoPositiveLongsByBruteforce(long x, long y) {
        long result = 0;

        while (x >= y) {
            result++;
            x -=y;
        }

        return result;
    }

    /**
     * @Complexity O(n), n is the number of bits
     * @Algorithm Fast
     *
     * @param x divident
     * @param y divisor
     *
     * @return quotient
     */
    public static long getQuotientOfTwoPositiveLongsBySchoolMethod(long x, long y) {
        long result = 0;
        long k = 1L << Integer.SIZE;

        while (x >= y) {
            while (k * y > x) k >>>= 1;

            x -= k * y;
            result |= k;
        }

        return result;
    }



    /*
    POWER

    Given double x and non-negative integer y calculate x^y assuming there are no overflows
     */

    /**
     * @Complexity O(2^n), n is number of bit in y
     * @Algorithm Bruteforce
     *
     * @param x base
     * @param y exponent
     *
     * @return x^y
     */
    public static double getPowerByBruteforce(double x, int y) {
        if (y < 0) return getPowerByBruteforce(1.0 / x, -y);

        if (y == 0) return 1;

        double result = 1;

        while (y-- > 0) {
            result *= x;
        }

        return result;
    }


    /**
     * @Complexity O(k), k is number if bits in y
     * @Algorithm fast
     *
     * @param x base
     * @param y exponent
     *
     * @return x^y
     */
    public static double getPowerByFast(double x, int y) {

        if (y < 0) {
            x = 1.0 / x;
            y = -y;
        }

        double result = 1.0;

        while (y > 0) {
            if ((y & 1) == 1) result *= x;

            x *= x;
            y >>>= 1;
        }

        return result;
    }


    /*
    REVERSE DIGITS

    The task is to reverse digits
     */

    /**
     * @Complexity O(p), p is the number of digits
     *
     * @param value 64-bit number
     *
     * @return reversed
     */
    public static long reverseDigits(long value) {
        long result = 0;

        while (value != 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }

        return result;
    }


    /*
    IS PALINDROME

    The task is to check is number a palindrome
     */

    /**
     * @Complexity O(p), p is the number of digits; O(p) space
     * @Algorithm Bruteforce (via string representation)
     *
     * @param value
     *
     * @return is palindrome
     */
    public static boolean isPalindromeByBruteforce(long value) {
        if (value < 0) return false;

        String s = Long.toString(value);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }

        return true;
    }

    /**
     * @Complexity O(p), p is the number of digits; O(1) space
     * @Algorithm Digits (extract digits)
     *
     * @param value
     *
     * @return is palindrome
     */
    public static boolean isPalindromeByDigits(long value) {
        if (value < 0) return false;

        int length = (int) Math.floor(Math.log10(value));
        long mask = (long) Math.pow(10, length);

        for (int i = 0; i < (length + 1)/ 2; i++) {
            if ((value % 10) != ((value / mask) % 10)) return false;

            value /= 10;
            mask /= 100;
        }

        return true;
    }



    /*
    UNIFORM RANDOM NUMBER
     */

    /**
     * @Complexity O(lg(to - from  + 1))
     *
     * @param from lower bound, inclusive
     * @param to upper bound, inclusive
     * @param coinGenerator uniform 0/1 generator
     *
     * @return uniform random number
     */
    public static long generateUniformRandomNumber(final long from, final long to, BooleanSupplier coinGenerator) {
        long normalizedTo = to - from + 1;
        long result = 0;

        do {
            for (int i = 0; (1 << i) < normalizedTo; i++) {
                result = result << 1 + (coinGenerator.getAsBoolean() ? 1 : 0);
            }
        } while (result >= normalizedTo);

        return result + from;
    }



    /*
    RECTANGLE INTERSECTION
     */

    /**
     * Helper class for a rectangle aligned with the X and Y axises
     */
    static class Rectangle {
        int x, y;
        int width, height;

        /**
         * @param x x-coordinate
         * @param y y-coordinate
         * @param width width
         * @param height height
         */
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if ((o != null) && (o instanceof Rectangle)) {
                Rectangle rec = (Rectangle) o;
                return (x == rec.x) && (y == rec.y) && (width == rec.width) && (height == rec.height);
            }

            return false;
        }
    }

    /**
     * @Complexity O(1)
     *
     * @param rec1 first rectangle
     * @param rec2 second rectangle
     *
     * @return null if rectangles do not intersect, intersection otherwise
     */
    public static Rectangle checkTwoRectanglesHaveIntersection(Rectangle rec1, Rectangle rec2) {
        boolean noIntersection =
                ((rec2.x > rec1.x + rec1.width) || (rec2.x + rec2.width < rec1.x)) &&
                        ((rec2.y > rec1.y + rec1.height) || (rec2.y + rec2.height < rec1.y));

        if (noIntersection) return null;

        return new Rectangle(
                Math.max(rec1.x, rec2.x),
                Math.max(rec1.y, rec2.y),
                Math.min(rec1.x + rec1.width, rec2.x + rec2.width) - Math.max(rec1.x, rec2.x),
                Math.min(rec1.y + rec1.height, rec2.y + rec2.height) - Math.max(rec1.y, rec2.y)
                );
    }


    /**
     * Helper class - representation of a point on a plane
     */
    static class Point {
        int x;
        int y;

        /**
         * @param x x-coordinate
         * @param y y-coordinate
         */
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * @Complexity O(1)
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @param p4 fourth point
     *
     * @return true if 4 points form a rectangle, false otherwise
     */
    public static boolean DoFourPointsFormRectangle(Point p1, Point p2, Point p3, Point p4) {
        // The center of mass
        double x = (p1.x + p2.x + p3.x + p4.x) / 4.0;
        double y = (p1.y + p2.y + p3.y + p4.y) / 4.0;

        double d1 = (p1.x - x) * (p1.x - x) + (p1.y - y) * (p1.y - y);
        double d2 = (p2.x - x) * (p2.x - x) + (p2.y - y) * (p2.y - y);
        double d3 = (p3.x - x) * (p3.x - x) + (p3.y - y) * (p3.y - y);
        double d4 = (p4.x - x) * (p4.x - x) + (p4.y - y) * (p4.y - y);

        return (Double.compare(d1, d2) == 0) && (Double.compare(d1, d3) == 0) &&
                (Double.compare(d1, d4) == 0);
    }
}
