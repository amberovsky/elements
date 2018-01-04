## <a name="strings"></a>3. Strings
#### Various tasks on strings

**Class**: [Strings](/src/main/java/pro/amberovsky/elements/Strings.java)  

1. [Is palindrome](#is-palindrome)
2. [Interconvert strings and integers](#interconvert-strings-and-integers)
3. [Base conversion](#base-conversion)
4. [Compute the spreadsheet column encoding](#compute-the-spreadsheet-column-encoding)
    * [Variant: "A" equals to 0](#compute-the-spreadsheet-column-encoding-a-equals-to-zero)
    * [Variant: decode](#compute-the-spreadsheet-column-encoding-decode)
5. [Replace and remove](#replace-and-remove)
    * [Variant: merge sorted arrays](#replace-and-remove-merge-sorted-arrays)
6. [Is palindromic](#is-palindromic)
7. [Reverse all the words in a sentence](#reverse-all-the-words-in-a-sentence)
8. [Compute all mnemonics for a phone number](#compute-all-mnemonics-for-a-phone-number)
    * [Variant: non-recursive](#compute-all-mnemonics-for-a-phone-number-non-recursive)
9. [The look-and-say problem](#the-look-and-say-problem)
10. Convert Roman to decimal
11. [Compute all valid IP addresses](#compute-all-valid-ip-addresses)
    * [Variant: unbounded](#compute-all-valid-ip-addresses-unbounded)
12. [Write a string sinusoidally](#write-a-string-sinusoidally)
13. [Implement run-length encoding](#implement-run-length-encoding)
14. [Find the first occurrence of a substring](#find-the-first-occurrence-of-a-substring)
      
<br>

### 1. <a name="is-palindrome"></a>Is palindrome
**Task**: Check if string is a palindrome 
**Example**: "aba" -> true

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| isPalindrome | | O(n) | O(1) |
<br>

### 2. <a name="interconvert-strings-and-integers"></a>Interconvert strings and integers
**Task**: Convert string to int and int to string  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| atoi | | O(n) | O(1) |
| itoa | | O(n) | O(n) |
<br>

### 3. <a name="base-conversion"></a>Base conversion
**Task**:  Convert given number in currentBase to the targetBase  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| convert | Intermediate conversion into decimal | O(n * (1 + log_currentBase(targetBase))) | O(n * log_currentBase(targetBase)) |
<br>

### 4. <a name="compute-the-spreadsheet-column-encoding"></a>Compute the spreadsheet column encoding
**Task**: Convert spreadsheet columns names into unique integer ID. "A" equals to 1  
**Example**: "ZZ" -> 728

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheSpreadsheetColumnEncoding | 27-base system | O(n) | O(1) |
<br>

   * ### <a name="compute-the-spreadsheet-column-encoding-a-equals-to-zero"></a>Variant: "A" equals to 0
      **Task**: Same as above but "A" equals to 0  
      **Example**: "ZZ" -> 675

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheSpreadsheetColumnEncoding_AEqualsTo0 | 26-base system | O(n) | O(1) |
<br>

   * ### <a name="compute-the-spreadsheet-column-encoding-decode"></a>Variant: decode
      **Task**: Decode integer ID back to the column name  
      **Example**: 728 -> "ZZ"

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheSpreadsheetColumnEncoding_Decode | 27-base system | O(log n) | O(1) |
<br>

### 5. <a name="replace-and-remove"></a>Replace and remove
**Task**: Replace each 'a' by 'dd', delete each 'd'  
**Example**: \['a', 'c', 'd', 'b', 'b', 'c', 'a'\], 7 -> \['d', 'd', 'c', 'd', 'c', 'd', 'd'\]  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| replaceAndRemove | | O(n) | O(1) |
<br>

   * ### <a name="replace-and-remove-merge-sorted-arrays"></a>Variant: merge sorted arrays
      **Task**: Merge 2 sorted array of integers. Result - in A, assuming it has enough space  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | replaceAmdRemove_MergeSortedArrays |  | O(n) | O(1) |
<br>

### 6. <a name="is-palindromic"></a>Is palindromic
**Task**: Check if string is a palindromic, case-insensitive and skipping non-alphanum  
**Example**: "Aa," -> true

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| isPalindromic | | O(n) | O(1) |
<br>

### 7. <a name="reverse-all-the-words-in-a-sentence"></a>Reverse all the words in a sentence
**Task**: Reverse words in a string, words are separated by whitespace 
**Example**: "Alice likes Bob" -> "Bob likes Alice"

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reverseAllTheWordsInASentence | | O(n) | O(1) |
<br>
   
### 8. <a name="compute-all-mnemonics-for-a-phone-number"></a>Compute all mnemonics for a phone number
**Task**: Generate all possible mnemonics by given phone number  
**Example**: "02"-> \["0A", "0B", "0C"\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeAllMnemonicsForAPhoneNumber | Recursion | O(n * 4^n) | O(n) |
<br>

   * ### <a name="compute-all-mnemonics-for-a-phone-number-non-recursive"></a>Variant: non-recursive
      **Task**: Reduce space to O(1)  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeAllMnemonicsForAPhoneNumber_NonRecursive | Two stacks | O(4^n) | O(4^n) |
<br>

### 9. <a name="the-look-and-say-problem"></a>The look-and-say problem
**Task**: Generate nth look-and-say number  
**Example**: 5 -> "312211"

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| theLookAndSay | Iterative generation | O(n * 2^n)) | O(n * 2^n) |
<br>

### 11. <a name="compute-all-valid-ip-addresses"></a>Compute all valid IP addresses
**Task**: Generate all possible IP addresses adding dots in the given address  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeAllValidIPAddresses | Iterate all possible variants | O(1) | O(1) |

<br>

   * ### <a name="compute-all-valid-ip-addresses-unbounded"></a>Variant: unbounded
      **Task**: Same as above but string is unbounded and k dots  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeAllValidIPAddresses_Unbounded | Iterate all possible variants | O(n ^ (k + 1)) | O(k + n ^ (k + 1) |
<br>

### 12. <a name="write-a-string-sinusoidally"></a>Write a string sinusoidally
**Task**: Generate snakestring  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| generateSnakestring | One iteration | O(n) | O(n) |
<br>

### 13. <a name="implement-run-length-encoding"></a>Implement run-length encoding
**Task**: Implement run-length encoding and decoding  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| encodeRunLength | One iteration | O(n) | O(n) |
| decodeRunLength | One iteration | O(n) | O(n) |
<br>

### 14. <a name="find-the-first-occurrence-of-a-substring"></a>Find the first occurrence of a substring
**Task**: Find the first occurrence of a substring  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| findTheFirstOccurrenceOfASubstring | Rabin-Karp | O(n + m) | O(1) |
<br>

[Go back to Strings TOC](#strings)  
[Go back](/README.md)
