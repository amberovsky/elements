package pro.amberovsky.elements;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Various tasks on strings
 */
class Strings {
    /*
    REVERSE
     */

    /**
     * Reverse a subarray of an array
     *
     * @param array array
     * @param start start index, inclusive
     * @param end end index, inclusive
     * @param <T> type
     *
     * @return array with a reversed subarray
     */
    static <T> T[] reverse(T[] array, int start, int end) {
        for (int i = 0; i < (end + 1 - start) / 2; i++) {
            T t = array[start + i];
            array[start + i] = array[end - i];
            array[end - i] = t;
        }

        return array;
    }



    /*
    IS PALINDROME
     */

    /**
     * @Complexity O(n), O(1) space
     *
     * @param s string
     *
     * @return true if the string is a palindrome, false otherwise
     */
    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }

        return true;
    }

    /*
    INTERCONVERT STRINGS AND INTEGERS
     */

    /**
     * Convert string to int
     *
     * @Complexity O(n), O(1) space
     *
     * @param s string
     *
     * @return int
     */
    static int atoi(String s) {
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '-') {
                sign = -1;
                continue;
            }

            result = result * 10 + (c - '0');
        }

        return result * sign;
    }

    /**
     * Convert int to string
     *
     * @Complexity O(n), O(n) space
     *
     * @param v int
     *
     * @return string
     */
    static String itoa(int v) {
        StringBuilder string = new StringBuilder();
        String sign = v < 0 ? "-" : "";

        v = Math.abs(v);

        do {
            string.append(v % 10);
            v /= 10;

        }
        while (v != 0);

        return string.append(sign).reverse().toString();
    }



    /*
    BASE CONVERSION
     */

    /**
     * Convert given number in currentBase to the targetBase
     *
     * @Complexity O(n * (1 + log_currentBase(targetBase))), O(n * log_currentBase(targetBase)) space
     * @Algorithm Intermediate conversion into decimal
     *
     * @param number given number
     * @param currentBase current base
     * @param targetBase target base
     *
     * @return the number in targetBase
     */
    static String convert(String number, int currentBase, int targetBase) {
        int value = 0;

        boolean isNegative = number.startsWith("-");

        for (int i = isNegative ? 1 : 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            int digitValue = ((digit < '0') || (digit > '9')) ? (digit - 'A' + 10) : (digit - '0');

            value *= currentBase;
            value += digitValue;
        }

        if (value == 0) return "0";

        StringBuilder result = new StringBuilder();

        while (value > 0) {
            int digitValue = value % targetBase;
            result.append((char) (digitValue > 9 ? ('A' + digitValue - 10) : (digitValue + '0')));
            value /= targetBase;
        }

        if (isNegative) result.append("-");

        return result.reverse().toString();
    }



    /*
    COMPUTE THE SPREADSHEET COLUMN ENCODING
     */

    /**
     * Convert spreadsheet columns names into unique integer ID. "A" equals to 1
     *
     * @Complexity O(n), O(1) space
     * @Algorithm 27-base system
     *
     * @param column column name
     *
     * @return unique integer ID
     */
    static int computeTheSpreadsheetColumnEncoding(String column) {
        int result = 0;

        for (int i = 0; i < column.length(); i++) {
            result *= 27;
            result += (column.charAt(i) - 'A' + 1);
        }

        return result;
    }

    /**
     * Variant: "A" equals to 0
     *
     * @Complexity O(n), O(1) space
     * @Algorithm 26-base system
     *
     * @param column column name
     *
     * @return unique integer ID
     */
    static int computeTheSpreadsheetColumnEncoding_AEqualsTo0(String column) {
        int result = 0;

        for (int i = 0; i < column.length(); i++) {
            result *= 26;
            result += (column.charAt(i) - 'A');
        }

        return result;
    }

    /**
     * Variant: Decode integer ID back to the column name
     *
     * @Complexity O(log n), O(1) space
     * @Algorithm 27-base system
     *
     * @param id unique ID
     *
     * @return decoded column name
     */
    static String computeTheSpreadsheetColumnEncoding_Decode(int id) {
        StringBuilder result = new StringBuilder();

        while (id > 0) {
            result.append((char) ((id % 27) - 1 + 'A'));
            id /= 27;
        }

        return result.reverse().toString();
    }



    /*
    REPLACE AND REMOVE
     */

    /**
     * Replace each 'a' by 'dd', delete each 'd'
     *
     * @Complexity O(n), O(1) space
     *
     * @param array array of characters
     * @param size how many elements to check
     *
     * @return transformed array
     */
    static char[] replaceAndRemove(char[] array, int size) {
        // Remove b's
        int curIndex = 0;
        int countOfA = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] != 'b') array[curIndex++] = array[i];

            if (array[i] == 'a') countOfA++;
        }

        // Expand a's
        for (int i = curIndex - 1; i>= 0; i--) {
            if (array[i] != 'a') array[i + countOfA] = array[i];
            else {
                array[i + countOfA--] = 'd';
                array[i + countOfA] = 'd';
            }
        }

        return array;
    }


    /**
     * Variant: Merge 2 sorted array of integers. Result - in A, assuming it has enough space
     *
     * @param array1 first array
     * @param array1Length how many elements in the first array
     * @param array2 second array
     *
     * @return merged array
     */
    static int[] replaceAmdRemove_MergeSortedArrays(int array1[], int array1Length, int array2[]) {
        int array2Index = array2.length - 1;
        int resultIndex = array1.length - 1;

        while ((array1Length > 0) && (array2Index >= 0)) {
            if (array1[array1Length - 1] < array2[array2Index]) array1[resultIndex] = array2[array2Index--];
            else array1[resultIndex] = array1[--array1Length];

            resultIndex--;
        }

        for (int i = 0; i <= array2Index; i++) array1[i] = array2[i];

        return array1;
    }



    /*
    TEST PALINDROMICITY
     */

    /**
     * Check if string is a palindromic, case-insensitive and skipping non-alphanum
     *
     * @Complexity O(n), O(1) space
     *
     * @param s string
     *
     * @return is palindromic
     */
    static boolean isPalindromic(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            if (!Character.isLetterOrDigit(startChar)) {
                start++;
                continue;
            }

            char endChar = s.charAt(end);
            if (!Character.isLetterOrDigit(endChar)) {
                end--;
                continue;
            }

            if (Character.toUpperCase(startChar) != Character.toUpperCase(endChar)) return false;

            start++;
            end--;
        }

        return true;
    }



    /*
    REVERSE ALL THE WORDS IN A SENTENCE
     */

    /**
     * Reverse words in a string, words are separated by ]whitespace
     *
     * @Complexity O(n), O(1) space
     *
     * @param string string with words
     *
     * @return reversed string
     */
    static Character[] reverseAllTheWordsInASentence(Character string[]) {
        // Reverse the whole string
        reverse(string, 0, string.length - 1);

        int endIndex = string.length - 1;
        int startIndex = endIndex;

        // Reverse words one by one
        do {
            while ((startIndex >= 0) && (string[startIndex] != ' ')) startIndex--;

            reverse(string, startIndex + 1, endIndex);
            startIndex--;
            endIndex = startIndex;
        } while (startIndex >= 0);

        return string;
    }



    /*
    COMPUTE ALL MNEMONICS FOR A PHONE NUMBER
     */
    /** mapping from phone digits to possible letters */
    private static String[] phoneDigitsMapping = new String[] { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    /**
     * Recursively computes all mnemonics
     *
     * @param number original number, in digits
     * @param index current working digit
     * @param partialMnemonic partial mnemonic so far
     * @param mnemonics generated mnemonics so far
     *
     * @return generated mnemonics
     */
    private static List<String> computeAllMnemonicsForAPhoneNumberHelper(
            String number, int index, char[] partialMnemonic, List<String> mnemonics
    ) {
        if (index == number.length()) {
            mnemonics.add(new String(partialMnemonic));
        } else {

            String options = phoneDigitsMapping[number.charAt(index) - '0'];

            for (int i = 0; i < options.length(); i++) {
                partialMnemonic[index] = options.charAt(i);

                computeAllMnemonicsForAPhoneNumberHelper(number, index + 1, partialMnemonic, mnemonics);
            }
        }

        return mnemonics;

    }

    /**
     * Generate all possible mnemonics by given phone number
     *
     * @Complexity O(n * 4^n), O(n) space where n is the number length
     * @Algorithm Recursion
     *
     * @param number phone number
     *
     * @return all possible mnemonics
     */
    static List<String> computeAllMnemonicsForAPhoneNumber(String number) {
        return computeAllMnemonicsForAPhoneNumberHelper(
                number,
                0,
                new char[number.length()],
                new ArrayList<>()
        );
    }


    /**
     * Same as above but without recursion
     *
     * @Complexity O(4^n), O(4^n) space
     * @Algorithm Two stacks
     *
     * @param number phone number
     *
     * @return all possible mnemonics
     */
    static List<String> computeAllMnemonicsForAPhoneNumber_NonRecursive(String number) {
        ArrayDeque<StringBuilder> queue = new ArrayDeque<>();
        queue.add(new StringBuilder());

        for (int i = number.length() - 1; i >= 0; i--) {
            ArrayDeque<StringBuilder> newQueue = new ArrayDeque<>();

            char digit = number.charAt(i);

            for (int q = 0; q < phoneDigitsMapping[digit].length(); q++) {

                for (StringBuilder mnemonic : queue) {
                    newQueue.add(mnemonic.append(phoneDigitsMapping[digit].charAt(q)));
                }
            }

            queue = newQueue;
        }

        ArrayList<String> result = new ArrayList<>(queue.size());
        for (StringBuilder mnemonic : queue) result.add(mnemonic.reverse().toString());

        return result;
    }



    /*
    THE LOOK-AND-SAY PROBLEM
     */

    /**
     * Generate nth look-and-say number
     *
     * @Complexity O(n * 2^n), O(n * 2^n) space
     * @Algorithm Iterative generation
     *
     * @param n number to generate
     *
     * @return generated number
     */
    static String theLookAndSay(int n) {
        StringBuilder result = new StringBuilder("1");

        for (int i = 0; i < n; i++) {
            StringBuilder newString = new StringBuilder();

            char currentChar = result.charAt(0);
            int length = 1;


            for (int k = 1; k <= result.length(); k++) {
                if ((k == result.length()) || (result.charAt(k) != currentChar)) {
                    newString.append(Integer.toString(length) +  currentChar);

                    if (k < result.length()) {
                        currentChar = result.charAt(k);
                        length = 1;
                    }
                } else length++;
            }

            result = newString;
        }


        return result.toString();
    }



    /*
    COMPUTE ALL VALID IP ADDRESSES
     */

    /**
     * Generate all possible IP addresses adding dots in the given address
     *
     * @Complexity O(1), O(1) space
     * @Algorithm Iterate all possible variants
     *
     * @param address address
     *
     * @return array of possible IPs
     */
    static String[] computeAllValidIPAddresses(String address) {
        List<String> addresses = new ArrayList<>();

        for (int p1 = 1; (p1 < 4) && (p1 < address.length()); p1++) {
            for (int p2 = p1 + 1; (p2 < p1 + 4) && (p2 < address.length()); p2++) {
                for (int p3 = p2 + 1; (p3 < p2 + 4) && (p3 < address.length()); p3++) {
                    String s1 = address.substring(0, p1);
                    String s2 = address.substring(p1, p2);
                    String s3 = address.substring(p2, p3);
                    String s4 = address.substring(p3);


                    int num1 = Integer.parseInt(s1);
                    int num2 = Integer.parseInt(s2);
                    int num3 = Integer.parseInt(s3);
                    int num4 = Integer.parseInt(s4);

                    if (
                            (num1 >= 0) && (num1 <= 255) &&
                            (num2 >= 0) && (num2 <= 255) &&
                            (num3 >= 0) && (num3 <= 255) &&
                            (num4 >= 0) && (num4 <= 255)
                    ) {
                        addresses.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }

        return addresses.toArray(new String[0]);
    }

    /**
     * Recursive method for unbound variant
     *
     * @param address address
     * @param k how many points have been processed so far
     * @param startPosition position for the current point
     * @param positions array with positions for points
     * @param addresses result list
     *
     * @return result list
     */
    private static List<String> computeAllValidIPAddresses_UnboundedHelper(String address, int k, int startPosition, int positions[], List<String> addresses) {
        if (k == positions.length) {
            StringBuilder result = new StringBuilder(address.length() + k);
            int prevPosition = 0;

            for (int i = 0; i <= positions.length; i++) {
                String substr = (i == positions.length)
                        ? address.substring(positions[i - 1])
                        : address.substring(prevPosition, positions[i]);

                Integer num = Integer.parseInt(substr);

                if ((num >= 0) && (num <= 255)) {

                    result.append(substr);
                    if (i < positions.length) {
                        result.append(".");
                        prevPosition = positions[i];
                    }
                } else
                    return addresses;
            }

            addresses.add(result.toString());
        } else {
            for (int i = 1; i < 4; i++) {
                if (startPosition + i < address.length()) {
                    positions[k] = startPosition + i;

                    computeAllValidIPAddresses_UnboundedHelper(address, k + 1, startPosition + i, positions, addresses);
                }
            }
        }


        return addresses;
    }

    /**
     * Variant: same as above but with unbounded string and k dots
     *
     * @Complexity O(n ^ (k + 1)), O(k + n ^ (k + 1)) space
     * @Algorithm Iterate all possible variants
     *
     * @param address address
     * @param k how many dots to put
     *
     * @return array of possible IPs
     */
    static String[] computeAllValidIPAddresses_Unbounded(String address, int k) {
        return computeAllValidIPAddresses_UnboundedHelper(address, 0, 0, new int[k], new ArrayList<>())
                .toArray(new String[0]);
    }



    /*
    WRITE A STRING SINUSOIDALLY
     */

    /**
     * @Complexity O(n), O(n) space
     * @Algorithm One iteration
     *
     * @param s
     * @return
     */
    static String generateSnakestring(String s) {
        StringBuilder top = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if ((i - 1) % 4 == 0)
                top.append(s.charAt(i));
            else if (i % 2 == 0)
                middle.append(s.charAt(i));
            else
                bottom.append(s.charAt(i));
        }

        return top.append(middle).append(bottom).toString();
    }



    /*
    IMPLEMENT RUN-LENGTH ENCODING
     */

    /**
     * Run-length encoding
     *
     * @Complexity O(n), O(n) space
     * @Algorithm One iteration
     *
     * @param s string
     *
     * @return encoded string
     */
    static String encodeRunLength(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            int k = 1;

            while ((k + i < s.length()) && (s.charAt(k + i) == s.charAt(i))) {
                k++;
            }

            result.append(k);
            result.append(s.charAt(i));

            i += k - 1;
        }

        return result.toString();
    }

    /**
     * Run-length decoding
     *
     * @Complexity O(n), O(n) space
     * @Algorithm One iteration
     *
     * @param s encoded string
     *
     * @return decoded string
     */
    static String decodeRunLength(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int digitPosition = i + 1;
            while (Character.isDigit(s.charAt(digitPosition))) digitPosition++;

            int amount = Integer.parseInt(s.substring(i, digitPosition));
            for (int k = 0; k < amount; k++) result.append(s.charAt(digitPosition));

            i = digitPosition;
        }

        return result.toString();
    }



    /*
    FIND THE FIRST OCCURRENCE OF A SUBSTRING
     */

    /**
     * Find first occurrence of a substring
     *
     * @Complexity O(n + m), O(1) space
     * @Algorithm Rabin-Karp
     *
     * @param text text to search in
     * @param pattern pattern to search
     *
     * @return index of the first occurrence, -1 otherwise
     */
    static int findTheFirstOccurrenceOfASubstring(String text, String pattern) {
        if (text.length() < pattern.length()) return -1;

        int hash = 0;
        int patternHash = 0;
        final int base = 26;

        int power = 1;
        for (int i = 0; i < pattern.length(); i++) {
            hash = hash * base + text.charAt(i);
            patternHash = patternHash * base + pattern.charAt(i);

            power *= (i > 0) ? base : 1;
        }

        for (int i = pattern.length();  i < text.length(); i++) {
            if ((hash == patternHash) && (pattern.equals(text.substring(i - pattern.length(), i)))) {
                return i - pattern.length();
            }

            hash = (hash - power * text.charAt(i - pattern.length())) * base;
            hash += text.charAt(i);
        }


        if ((hash == patternHash) && (pattern.equals(text.substring(text.length() - pattern.length())))) {
            return text.length() - pattern.length();
        }

        return -1;

    }
}
