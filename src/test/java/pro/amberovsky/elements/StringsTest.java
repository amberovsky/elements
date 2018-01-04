package pro.amberovsky.elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static pro.amberovsky.elements.Strings.*;

class StringsTest {
    /*
    REVERSE
     */
    @Test
    void testReverse() {
        assertArrayEquals(new Character[] { 'A' }, reverse(new Character[] { 'A' }, 0, 0));
        assertArrayEquals(new Character[] { 'A', 'B', 'C' }, reverse(new Character[] { 'A', 'B', 'C' }, 0, 0));
        assertArrayEquals(new Character[] { 'A', 'C', 'B' }, reverse(new Character[] { 'A', 'B', 'C' }, 1, 2));
        assertArrayEquals(new Character[] { 'C', 'B', 'A' }, reverse(new Character[] { 'A', 'B', 'C' }, 0, 2));
        assertArrayEquals(new Character[] { 'D', 'C', 'B', 'A' }, reverse(new Character[] { 'A', 'B', 'C', 'D' }, 0, 3));
    }



    /*
    IS PALINDROME
     */
    @Test
    void testIsPalindrome() {
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("a"));
        assertFalse(isPalindrome("ab"));
        assertTrue(isPalindrome("aba"));
    }



    /*
    INTERCONVERT STRINGS AND INTEGERS
     */
    @Test
    void testAtoi() {
        assertEquals(0, atoi("0"));
        assertEquals(1, atoi("1"));
        assertEquals(-1, atoi("-1"));
        assertEquals(-1999, atoi("-1999"));
    }

    @Test
    void testItoa() {
        assertEquals("0", itoa(0));
        assertEquals("1", itoa(1));
        assertEquals("-1", itoa(-1));
        assertEquals("1999", itoa(1999));
    }


    /*
    BASE CONVERSION
     */
    @Test
    void testConvert() {
        assertEquals("-1A7", convert("-615", 7, 13));
    }



    /*
    COMPUTE THE SPREADSHEET COLUMN ENCODING
     */
    @Test
    void testComputeTheSpreadsheetColumnEncoding() {
        assertEquals(728, computeTheSpreadsheetColumnEncoding("ZZ"));
    }

    @Test
    void testComputeTheSpreadsheetColumnEncoding_AEqualsTo0() {
        assertEquals(675, computeTheSpreadsheetColumnEncoding_AEqualsTo0("ZZ"));
    }

    @Test
    void testComputeTheSpreadsheetColumnEncoding_Decode() {
        assertEquals(
                "AZZZ",
                computeTheSpreadsheetColumnEncoding_Decode(computeTheSpreadsheetColumnEncoding("AZZZ"))
        );
    }



    /*
    REPLACE AND REMOVE
     */
    @Test
    void testReplaceAndRemove() {
        assertArrayEquals(
                new char[] { 'd', 'd', 'c', 'd', 'c', 'd', 'd' },
                replaceAndRemove(new char[] { 'a', 'c', 'd', 'b', 'b', 'c', 'a' }, 7)
        );

        assertArrayEquals(
                new char[] { 'd', 'd', 'c', 'b', 'b', 'c', 'a' },
                replaceAndRemove(new char[] { 'a', 'c', 'b', 'b', 'b', 'c', 'a' }, 3)
        );

    }


    @Test
    void testReplaceAmdRemove_MergeSortedArrays() {
        assertArrayEquals(new int[] { 1, 2, 3 }, replaceAmdRemove_MergeSortedArrays(new int[] { 9, 9, 9 }, 0, new int[] { 1, 2, 3 }));
        assertArrayEquals(new int[] { 1, 2, 3 }, replaceAmdRemove_MergeSortedArrays(new int[] { 1, 2, 3 }, 3, new int[] { }));

        assertArrayEquals(new int[] { 1, 2, 3 }, replaceAmdRemove_MergeSortedArrays(new int[] { 1, 9, 9 }, 1, new int[] { 2, 3 }));
        assertArrayEquals(new int[] { 1, 2, 3 }, replaceAmdRemove_MergeSortedArrays(new int[] { 3, 9, 9 }, 1, new int[] { 1, 2 }));
    }



    /*
    TEST PALINDROMICITY
     */
    @Test
    void testIsPalindromic() {
        assertTrue(isPalindromic(""));
        assertTrue(isPalindromic(","));
        assertTrue(isPalindromic("Aa"));
        assertTrue(isPalindromic("A,a"));
        assertTrue(isPalindromic("Aa,"));
        assertTrue(isPalindromic("A man, a plan, a canal, Panama."));
        assertTrue(isPalindromic("Able was I, ere I saw Elba!"));
        assertFalse(isPalindromic("Ray a Ray"));
    }



    /*
    REVERSE ALL THE WORDS IN A SENTENCE
     */
    private static Stream<Arguments> sourceForReverseAllTheWordsInASentence() {
        return Stream.of(
                Arguments.of("Alice likes Bob", "Bob likes Alice"),
                Arguments.of("Bob", "Bob")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForReverseAllTheWordsInASentence")
    void testReverseAllTheWordsInASentence(String parameter, String expected) {
        Character parameterChar[] = new Character[parameter.length()];
        for (int i = 0; i < parameter.length(); i++) parameterChar[i] = parameter.charAt(i);

        Character expectedChar[] = new Character[expected.length()];
        for (int i = 0; i < expected.length(); i++) expectedChar[i] = expected.charAt(i);

        assertArrayEquals(expectedChar, reverseAllTheWordsInASentence(parameterChar));
    }



    /*
    COMPUTE ALL MNEMONICS FOR A PHONE NUMBER
     */
    private static Stream<Arguments> sourceForComputeAllMnemonicsForAPhoneNumber() {
        return Stream.of(
                Arguments.of(
                        new String[] {
                            "0"
                        },
                        "0"
                ),

                Arguments.of(
                        new String[] {
                                "0A", "0B", "0C"
                        },
                        "02"
                ),

                Arguments.of(
                        new String[] {
                                "A0", "B0", "C0"
                        },
                        "20"
                ),

                Arguments.of(
                        new String[] {
                                "AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"
                        },
                        "23"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForComputeAllMnemonicsForAPhoneNumber")
    void testComputeAllMnemonicsForAPhoneNumber(String[] mnemonics, String number) {
        List<String> result =  computeAllMnemonicsForAPhoneNumber(number);

        assertArrayEquals(mnemonics, result.toArray(new String[0]));
    }

    @ParameterizedTest
    @MethodSource("sourceForComputeAllMnemonicsForAPhoneNumber")
    void testComputeAllMnemonicsForAPhoneNumber_NonRecursive(String[] mnemonics, String number) {
        List<String> result =  computeAllMnemonicsForAPhoneNumber(number);

        assertArrayEquals(mnemonics, result.toArray(new String[0]));
    }



    /*
    THE LOOK-AND-SAY PROBLEM
     */
    @Test
    void testTheLookAndSay() {
        assertEquals("1", theLookAndSay(0));
        assertEquals("11", theLookAndSay(1));
        assertEquals("21", theLookAndSay(2));
        assertEquals("1211", theLookAndSay(3));
        assertEquals("111221", theLookAndSay(4));
        assertEquals("312211", theLookAndSay(5));
        assertEquals("13112221", theLookAndSay(6));
        assertEquals("1113213211", theLookAndSay(7));
    }



    /*
    COMPUTE ALL VALID IP ADDRESSES
     */
    @Test
    void testComputeAllValidIPAddresses() {
        assertArrayEquals(
                new String[] {
                        "1.92.168.11",
                        "19.2.168.11",
                        "19.21.68.11",
                        "19.216.8.11",
                        "19.216.81.1",
                        "192.1.68.11",
                        "192.16.8.11",
                        "192.16.81.1",
                        "192.168.1.1",
                },
                computeAllValidIPAddresses("19216811")
        );
    }

    @Test
    void testComputeAllValidIPAddresses_Unbounded() {
        assertArrayEquals(
                new String[] { },
                computeAllValidIPAddresses_Unbounded("19216811", 1)
        );

        assertArrayEquals(
                new String[] {
                        "192.168.11"
                },
                computeAllValidIPAddresses_Unbounded("19216811", 2)
        );

        assertArrayEquals(
                new String[] {
                        "1.92.168.11",
                        "19.2.168.11",
                        "19.21.68.11",
                        "19.216.8.11",
                        "19.216.81.1",
                        "192.1.68.11",
                        "192.16.8.11",
                        "192.16.81.1",
                        "192.168.1.1",
                },
                computeAllValidIPAddresses_Unbounded("19216811", 3)
        );

        assertArrayEquals(
                new String[] {
                        "1.9.2.1.6.8.1.1",
                },
                computeAllValidIPAddresses_Unbounded("19216811", 7)
        );

        assertArrayEquals(
                new String[] { },
                computeAllValidIPAddresses_Unbounded("19216811", 8)
        );
    }


    /*
    WRITE A STRING SINUSOIDALLY
    */
    @Test
    void testGenerateSnakestring() {
        assertEquals("e lHloWrdlo!", generateSnakestring("Hello World!"));
    }



    /*
    IMPLEMENT RUN-LENGTH ENCODING
     */
    private static Stream<Arguments> sourceForImplementRunLengthEncoding() {
        return Stream.of(
                Arguments.of("e", "1e"),
                Arguments.of("ee", "2e"),
                Arguments.of("eeeeeeeeeeea", "11e1a"),
                Arguments.of("eb", "1e1b"),
                Arguments.of("aaaabcccaa", "4a1b3c2a"),
                Arguments.of("eeeffffee", "3e4f2e")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceForImplementRunLengthEncoding")
    void testEncodeRunLength(String source, String encoded) {
        assertEquals(encoded, encodeRunLength(source));
    }

    @ParameterizedTest
    @MethodSource("sourceForImplementRunLengthEncoding")
    void testDecodeRunLength(String source, String _) {
        assertEquals(source, decodeRunLength(encodeRunLength(source)));
    }



    /*
    FIND THE FIRST OCCURRENCE OF A SUBSTRING
     */
    @Test
    void testFindTheFirstOccurrenceOfASubstring() {
        assertEquals(-1, findTheFirstOccurrenceOfASubstring("theveryteststringtest", "p"));
        assertEquals(0, findTheFirstOccurrenceOfASubstring("theveryteststringtest", "the"));
        assertEquals(7, findTheFirstOccurrenceOfASubstring("theveryteststringtest", "test"));
        assertEquals(16, findTheFirstOccurrenceOfASubstring("theveryteststringtest", "gtest"));
    }
}
