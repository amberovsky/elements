package pro.amberovsky.elements;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(DataProviderRunner.class)
public class StringsTest {
    /*
    REVERSE
     */
    @Test
    public void testReverse() {
        assertArrayEquals(new Character[] { 'A' }, Strings.reverse(new Character[] { 'A' }, 0, 0));
        assertArrayEquals(new Character[] { 'A', 'B', 'C' }, Strings.reverse(new Character[] { 'A', 'B', 'C' }, 0, 0));
        assertArrayEquals(new Character[] { 'A', 'C', 'B' }, Strings.reverse(new Character[] { 'A', 'B', 'C' }, 1, 2));
        assertArrayEquals(new Character[] { 'C', 'B', 'A' }, Strings.reverse(new Character[] { 'A', 'B', 'C' }, 0, 2));
        assertArrayEquals(new Character[] { 'D', 'C', 'B', 'A' }, Strings.reverse(new Character[] { 'A', 'B', 'C', 'D' }, 0, 3));
    }



    /*
    IS PALINDROME
     */
    @Test
    public void testIsPalindrome() {
        assertTrue(Strings.isPalindrome(""));
        assertTrue(Strings.isPalindrome("a"));
        assertFalse(Strings.isPalindrome("ab"));
        assertTrue(Strings.isPalindrome("aba"));
    }



    /*
    INTERCONVERT STRINGS AND INTEGERS
     */
    @Test
    public void testAtoi() {
        assertEquals(0, Strings.atoi("0"));
        assertEquals(1, Strings.atoi("1"));
        assertEquals(-1, Strings.atoi("-1"));
        assertEquals(-1999, Strings.atoi("-1999"));
    }

    @Test
    public void testItoa() {
        assertEquals("0", Strings.itoa(0));
        assertEquals("1", Strings.itoa(1));
        assertEquals("-1", Strings.itoa(-1));
        assertEquals("1999", Strings.itoa(1999));
    }


    /*
    BASE CONVERSION
     */
    @Test
    public void testConvert() {
        assertEquals("-1A7", Strings.convert("-615", 7, 13));
    }



    /*
    COMPUTE THE SPREADSHEET COLUMN ENCODING
     */
    @Test
    public void testComputeTheSpreadsheetColumnEncoding() {
        assertEquals(728, Strings.computeTheSpreadsheetColumnEncoding("ZZ"));
    }

    @Test
    public void testComputeTheSpreadsheetColumnEncoding_AEqualsTo0() {
        assertEquals(675, Strings.computeTheSpreadsheetColumnEncoding_AEqualsTo0("ZZ"));
    }

    @Test
    public void testComputeTheSpreadsheetColumnEncoding_Decode() {
        assertEquals(
                "AZZZ",
                Strings.computeTheSpreadsheetColumnEncoding_Decode(Strings.computeTheSpreadsheetColumnEncoding("AZZZ"))
        );
    }



    /*
    REPLACE AND REMOVE
     */
    @Test
    public void testReplaceAndRemove() {
        assertArrayEquals(
                new char[] { 'd', 'd', 'c', 'd', 'c', 'd', 'd' },
                Strings.replaceAndRemove(new char[] { 'a', 'c', 'd', 'b', 'b', 'c', 'a' }, 7)
        );

        assertArrayEquals(
                new char[] { 'd', 'd', 'c', 'b', 'b', 'c', 'a' },
                Strings.replaceAndRemove(new char[] { 'a', 'c', 'b', 'b', 'b', 'c', 'a' }, 3)
        );

    }


    @Test
    public void testReplaceAmdRemove_MergeSortedArrays() {
        assertArrayEquals(new int[] { 1, 2, 3 }, Strings.replaceAmdRemove_MergeSortedArrays(new int[] { 9, 9, 9 }, 0, new int[] { 1, 2, 3 }));
        assertArrayEquals(new int[] { 1, 2, 3 }, Strings.replaceAmdRemove_MergeSortedArrays(new int[] { 1, 2, 3 }, 3, new int[] { }));

        assertArrayEquals(new int[] { 1, 2, 3 }, Strings.replaceAmdRemove_MergeSortedArrays(new int[] { 1, 9, 9 }, 1, new int[] { 2, 3 }));
        assertArrayEquals(new int[] { 1, 2, 3 }, Strings.replaceAmdRemove_MergeSortedArrays(new int[] { 3, 9, 9 }, 1, new int[] { 1, 2 }));
    }



    /*
    TEST PALINDROMICITY
     */
    @Test
    public void testIsPalindromic() {
        assertTrue(Strings.isPalindromic(""));
        assertTrue(Strings.isPalindromic(","));
        assertTrue(Strings.isPalindromic("Aa"));
        assertTrue(Strings.isPalindromic("A,a"));
        assertTrue(Strings.isPalindromic("Aa,"));
        assertTrue(Strings.isPalindromic("A man, a plan, a canal, Panama."));
        assertTrue(Strings.isPalindromic("Able was I, ere I saw Elba!"));
        assertFalse(Strings.isPalindromic("Ray a Ray"));
    }



    /*
    REVERSE ALL THE WORDS IN A SENTENCE
     */
    @DataProvider
    public static Object[] dataProviderForReverseAllTheWordsInASentence() {
        return new Object[] {
                new Object[] { "Alice likes Bob", "Bob likes Alice" },
                new Object[] { "Bob", "Bob" },
        };
    }

//    @Test
//    @UseDataProvider("dataProviderForReverseAllTheWordsInASentence")
//    public void testReverseAllTheWordsInASentence(Object[] data) {
//        String parameter = (String) data[0];
//        String expected = (String) data[1];
//
//        Character parameterChar[] = new Character[parameter.length()];
//        for (int i = 0; i < parameter.length(); i++) parameterChar[i] = parameter.charAt(i);
//
//        Character expectedChar[] = new Character[expected.length()];
//        for (int i = 0; i < expected.length(); i++) expectedChar[i] = expected.charAt(i);
//
//
//        assertArrayEquals(expectedChar, Strings.reverseAllTheWordsInASentence(parameterChar));
//    }



    /*
    COMPUTE ALL MNEMONICS FOR A PHONE NUMBER
     */
    @DataProvider
    public static Object[] dataProviderForComputeAllMnemonicsForAPhoneNumber() {
        return new Object[] {
                new Object[] {
                        new String[] {
                            "0"
                        },
                        "0"
                },

                new Object[] {
                        new String[] {
                                "0A", "0B", "0C"
                        },
                        "02"
                },

                new Object[] {
                        new String[] {
                                "A0", "B0", "C0"
                        },
                        "20"
                },

                new Object[] {
                        new String[] {
                                "AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"
                        },
                        "23"
                },

        };
    }

//    @Test
//    @UseDataProvider("dataProviderForComputeAllMnemonicsForAPhoneNumber")
//    public void testComputeAllMnemonicsForAPhoneNumber(Object[] data) {
//        List<String> result =  Strings.computeAllMnemonicsForAPhoneNumber((String) data[1]);
//
//        assertArrayEquals((String[]) data[0], result.toArray(new String[0]));
//    }

//    @Test
//    @UseDataProvider("dataProviderForComputeAllMnemonicsForAPhoneNumber")
//    public void testComputeAllMnemonicsForAPhoneNumber_NonRecursive(Object[] data) {
//        List<String> result =  Strings.computeAllMnemonicsForAPhoneNumber((String) data[1]);
//
//        assertArrayEquals((String[]) data[0], result.toArray(new String[0]));
//    }



    /*
    THE LOOK-AND-SAY PROBLEM
     */
    @Test
    public void testTheLookAndSay() {
        assertEquals("1", Strings.theLookAndSay(0));
        assertEquals("11", Strings.theLookAndSay(1));
        assertEquals("21", Strings.theLookAndSay(2));
        assertEquals("1211", Strings.theLookAndSay(3));
        assertEquals("111221", Strings.theLookAndSay(4));
        assertEquals("312211", Strings.theLookAndSay(5));
        assertEquals("13112221", Strings.theLookAndSay(6));
        assertEquals("1113213211", Strings.theLookAndSay(7));
    }



    /*
    COMPUTE ALL VALID IP ADDRESSES
     */
    @Test
    public void testComputeAllValidIPAddresses() {
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
                Strings.computeAllValidIPAddresses("19216811")
        );
    }

    @Test
    public void testComputeAllValidIPAddresses_Unbounded() {
        assertArrayEquals(
                new String[] { },
                Strings.computeAllValidIPAddresses_Unbounded("19216811", 1)
        );

        assertArrayEquals(
                new String[] {
                        "192.168.11"
                },
                Strings.computeAllValidIPAddresses_Unbounded("19216811", 2)
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
                Strings.computeAllValidIPAddresses_Unbounded("19216811", 3)
        );

        assertArrayEquals(
                new String[] {
                        "1.9.2.1.6.8.1.1",
                },
                Strings.computeAllValidIPAddresses_Unbounded("19216811", 7)
        );

        assertArrayEquals(
                new String[] { },
                Strings.computeAllValidIPAddresses_Unbounded("19216811", 8)
        );
    }


    /*
    WRITE A STRING SINUSOIDALLY
    */
    @Test
    public void testGenerateSnakestring() {
        assertEquals("e lHloWrdlo!", Strings.generateSnakestring("Hello World!"));
    }



    /*
    IMPLEMENT RUN-LENGTH ENCODING
     */
    @DataProvider
    public static Object[] dataProviderForImplementRunLengthEncoding() {
        return new Object[] {
                new Object[] { "e", "1e" },
                new Object[] { "ee", "2e" },
                new Object[] { "eeeeeeeeeeea", "11e1a" },
                new Object[] { "eb", "1e1b" },
                new Object[] { "aaaabcccaa", "4a1b3c2a" },
                new Object[] { "eeeffffee", "3e4f2e" },
        };
    }

//    @Test
//    @UseDataProvider("dataProviderForImplementRunLengthEncoding")
//    public void testEncodeRunLength(Object[] data) {
//        assertEquals((String) data[1], Strings.encodeRunLength((String) data[0]));
//    }

//    @Test
//    @UseDataProvider("dataProviderForImplementRunLengthEncoding")
//    public void testDecodeRunLength(Object[] data) {
//        assertEquals((String) data[0], Strings.decodeRunLength(Strings.encodeRunLength((String) data[0])));
//    }



    /*
    FIND THE FIRST OCCURRENCE OF A SUBSTRING
     */
    @Test
    public void testFindTheFirstOccurenceOfASubstring() {
        assertEquals(-1, Strings.findTheFirstOccurrenceOfASubstring("theveryteststringtest", "p"));
        assertEquals(0, Strings.findTheFirstOccurrenceOfASubstring("theveryteststringtest", "the"));
        assertEquals(7, Strings.findTheFirstOccurrenceOfASubstring("theveryteststringtest", "test"));
        assertEquals(16, Strings.findTheFirstOccurrenceOfASubstring("theveryteststringtest", "gtest"));
    }
}
