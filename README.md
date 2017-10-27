# Elements of programming interviews in Java [![Build Status](https://travis-ci.org/amberovsky/elements.svg?branch=master)](https://travis-ci.org/amberovsky/elements) [![codecov](https://codecov.io/gh/amberovsky/elements/branch/master/graph/badge.svg)](https://codecov.io/gh/amberovsky/elements)

## <a name="TOC"></a>Table of content

1. [Primitive types](#primitive-types)
2. [Arrays](#arrays)
<br>
<br>
<br>

## <a name="primitive-types"></a>1. Primitive Types
**Class**: [BitOperations](src/main/java/pro/amberovsky/elements/PrimitiveTypes.java)  
**Factory**: [BitOperationsFactory](src/main/java/pro/amberovsky/elements/PrimitiveTypesFactory.java)

1. [Erase lowest set bit](#primitive-types-erase-lowest-set-bit)
2. [Is power of two](#primitive-types-is-power-of-two)
3. [Count number of set bits](#primitive-types-count-number-of-set-bits)
4. [Calculate parity](#primitive-types-calculate-parity)
5. [Swap bits](#primitive-types-swap-bits)
6. [Reverse bits](#primitive-types-reverse-bits)
7. [Get closest number with same weight](#primitive-types-get-closest-number-with-same-weight)
8. [Sum of two non-negative numbers](#primitive-types-sum-of-two-non-negative-numbers)
9. [Product of two non-negative numbers](#primitive-types-product-of-two-non-negative-numbers)
10. [Quotient of two positive numbers](#primitive-types-quotient-of-two-positive-numbers)
11. [Calculate power](#primitive-types-calculate-power)
12. [Reverse digits](#primitive-types-reverse-digits)
13. [Is palindrome](#primitive-types-is-palindrome)
14. [Uniform random number](#primitive-types-uniform-random-number)
15. [Rectangle intersection](#primitive-types-rectangle-intersection)
16. [Do four points form a rectangle](#primitive-types-do-four-points-form-a-rectangle)

<br>

### 1. <a name="primitive-types-erase-lowest-set-bit"></a>Erase lowest set bit
**Task**: Erase lowest set bit for a given number.  
**Example**: 5 (=0110) -> 4 (=0100)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| eraseLowestSetBit | Bit/arithmetic operations | O(1) |
<br>

### 2. <a name="primitive-types-is-power-of-two"></a>Is power of two
**Task**: Return true if given number is a power of two  
**Example**: 512 -> true  
**Example**: 511 -> false

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| isPowerOfTwo | Bit/arithmetic operations | O(1) |
<br>

### 3. <a name="primitive-types-count-number-of-set-bits"></a>Count number of set bits
**Task**: Return the number of 1 in the binary representation of a given number  
**Example**: 256 (=10000000) -> 1  
**Example**: -1 (=111...1) -> Long.SIZE

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| countBitsByShifting | Shift number to the right | O(k), k is the number of set bits |
<br>

### 4. <a name="primitive-types-calculate-parity"></a>Calculate parity
**Task**: Return parity of a given number, parity is 1 if amount of set bits is odd, 0 otherwise  
**Example**: 3 (=11) -> 0  
**Example**: -1 (=111...1) -> 0  
**Example**: 2 (=10) -> 1

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getParityByBruteforce | Shift number to the right | O(k), k is the number of set bits |
| getParityByErasingLowestSetBit | Erase lowest set bit until number is zero | O(k), k is the number of set bits |
| getParityByLookup | Lookup/hashtable | O(n/p), n is the number of bits, p is the number of bits in the LOOKUP_BIT_MASK |
| getParityByXOR | XOR | O(log(n)), n is the number of bits |
<br>

### 5. <a name="primitive-types-swap-bits"></a>Swap bits
**Task**: Swap two bits on given positions for a given number  
**Example**: 584455544 (=100010110101100001010101111000) swap at 8 & 23 -> 584455544 (=100010110101100001010101111000)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| swapByBruteforce | Bit/arithmetic operations | O(1) |
<br>

### 6. <a name="primitive-types-reverse-bits"></a>Reverse bits
**Task**: Reverse bits in a given number  
**Example**: 0 -> 0  
**Example**: Long.MIN_VALUE -> 1

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| reverseBitsByIteration | Iterate all bits | O(n), n is the number of bits |
| reverseBitsByMask | Use mask to iterate all bits | O(n), n is the number of bits |
| reversBitsBySwap | In-place, iterating to the middle | O(n), n is the number of bits |
| reverseBitsByLookup | Lookup/hash table | O(n/p), n is number of bits, p is number of bits in the LOOKUP_BIT_MASK |
<br>

### 7. <a name="primitive-types-get-closest-number-with-same-weight"></a>Get closest number with same weight
**Task**: Given a number, find a closest one (by absolute difference) with same weight. Weight is the number of set bits  
**Example**: 100 (=01100100)-> 98 (01100010)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getClosestLongWithSameWeightByIteration | Iterate all bits | O(n), n is the number of bits |
| getClosestLongWithSameWeightByFast | Change only 2 bits | O(1) |
<br>

### 8. <a name="primitive-types-sum-of-two-non-negative-numbers"></a>Sum of two non-negative numbers
**Task**: Given two numbers, calculate their sum without using arithmetical operations

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getSumOfTwoNonNegativeLongsByIteration | Iterate all bits | O(n), n is the number of bits |
| getSumOfTwoNonNegativeLongsByMask | Using carry mask | O(k), n is number of set bits in the second number |
<br>

### 9. <a name="primitive-types-product-of-two-non-negative-numbers"></a>Product of two non-negative numbers
**Task**: Given two numbers, calculate their product without using arithmetical operations

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getProductOfTwoNonNegativeLongsByBruteforce | Add first number to itself second number times | O(2^n), n is the number of bits |
| getSumOfTwoNonNegativeLongsByMask | Using carry mask | O(k), k is number of set bits in the second number |
| getProductOfTwoNonNegativeLongsBySchoolMethod | Using school method | O(n) * Complexity of addition, n is the number of bits |
<br>

### 10. <a name="primitive-types-quotient-of-two-positive-numbers"></a>Quotient of two positive numbers
**Task**: Given two numbers, calculate their quotient

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getQuotientOfTwoPositiveLongsByBruteforce | Subtract till reach zero | O(2^n), n is the number of bits |
| getQuotientOfTwoPositiveLongsBySchoolMethod | Using school method | O(n), n is the number of bits |
<br>

### 11. <a name="primitive-types-calculate-power"></a>Calculate power
**Task**: Given two numbers x and y, calculate x^y

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getPowerByBruteforce | Multiple x by itself y times | O(2^n), n is the number of bits |
| getPowerByFast | Calculate x^(y/2) * x^(y/2) | O(k), k is number if bits in y |
<br>

### 12. <a name="primitive-types-reverse-digits"></a>Reverse digits
**Task**: Reverse digits in given number  
**Example**: 10 -> 1  
**Example**: 719371291739 -> 937192173917

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| reverseDigits | Iterate all digits | O(p), p is number of digits |
<br>

### 13. <a name="primitive-types-is-palindrome"></a>Is palindrome
**Task**: Return true if given number is a palindrome, false otherwise  
**Example**: 10 -> false  
**Example**: 121 -> true

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| isPalindromeByBruteforce | Iterate all digits | O(p), p is number of digits; O(p) space |
| isPalindromeByDigits | In-place, iterating to the middle | O(p), p is number of digits; O(1) space |
<br>

### 14. <a name="primitive-types-uniform-random-number"></a>Uniform random number
**Task**: Generate a uniform random number in \[from; to\] range using given 0/1 uniform generator

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| generateUniformRandomNumber | Using lowest M such as M = 2^k - 1 and M >= to - from | O(lg(to - from  + 1)) |
<br>

### 15. <a name="primitive-types-rectangle-intersection"></a>Rectangle intersection
**Task**: Determine if given 2 aligned with X-axis and Y-axis rectangles have intersection, return it in such case

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| checkTwoRectanglesHaveIntersection | Check when 2 rectangles do not have intersection | O(1) |
<br>

### 16. <a name="primitive-types-do-four-points-form-a-rectangle"></a>Do four points form a rectangle
**Task**: Give 4 points on a plane determine do they form a rectangle

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| DoFourPointsFormRectangle | Use center of mass | O(1) |
<br>

[Go back to Primitive Types TOC](#primitive-types)  
[Go back to TOC](#TOC)
<br>
<br>
## <a name="arrays"></a>2. Arrays
**Class**: [Arrays](src/main/java/pro/amberovsky/elements/Arrays.java) 

1. [Reorder even](#arrays-reorder-even)
2. [Dutch flag](#arrays-dutch-flag)
   * [Variant: only three values](#arrays-dutch-flag-only-three-values)
   * [Variant: only four values](#arrays-dutch-flag-only-four-values)
   * [Variant: only two (boolean) values](#arrays-dutch-flag-only-boolean-values)
   * [Variant: only two (boolean) values, keep order of true values](#arrays-dutch-flag-only-boolean-values-keep-order-of-true)
3. [Increment an arbitrary-precision integer](#arrays-increment-an-arbitrary-precision-integer)
   * [Variant: add two numbers in binary representation](#arrays-increment-an-arbitrary-precision-integer-add-two-numbers-in-binary-representation)

<br>

### 1. <a name="arrays-reorder-even"></a>Reorder even
**Task**: Reorder array elements so that the even entries appear first 
**Example**: [1, 2, 3, 4] -> [2, 4, 1, 3]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reorderEven | One iteration | O(n) | O(1) space |
<br>

### 2. <a name="arrays-dutch-flag"></a>Dutch flag
**Task**: With given "pivot" value rearrange elements so first goes less than pivot, than equal, then greater  
**Example**: [9, 8, 7, 6, 5, 4, 3, 2, 1], pivot: 8 -> [1, 2, 3, 4, 5, 6, 7, 8, 9]

| Method | Algorithm | Time | Additional space |
| :--- | :---: | :---: | :-- |
| DutchFlag | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-three-values"></a>Variant: only three values
      **Task**: Assuming that elements take one of three values, reorder the array so that all objects with the same key appear together  
      **Example**: [0, 1, 2, 0, 2, 1, 1] -> [0, 0, 1, 1, 2, 2]

      | Method | Algorithm | Time | Additional space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyThreeValues | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-four-values"></a>Variant: only four values
      **Task**: Assuming that elements take one of four values, reorder the array so that all objects with the same key appear together  
      **Example**: [0, 1, 2, 0, 2, 1, 1, 5 ] -> [0, 0, 1, 1, 1, 2, 2, 5]

      | Method | Algorithm | Time | Additional space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyFourValues | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-boolean-values"></a>Variant: only two (boolean) values
      **Task**: Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first  

      | Method | Algorithm | Time | Additional space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyTwoValues | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-boolean-values-keep-order-of-true"></a>Variant: only two (boolean) values, keep order of true values
      **Task**: Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first and maintain the relative order of true  

      | Method | Algorithm | Time | Additional space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyTwoValuesKeepOrderOfOneValue | One iteration | O(n) | O(1) |
<br>

### 3. <a name="aarrays-increment-an-arbitrary-precision-integer"></a>Increment an arbitrary-precision integer
**Task**:  add 1 to given array of digits representing a number of any length  
**Example**: [3, 4, 2, 1] -> [3, 4, 2, 2]

| Method | Algorithm | Time | Additional space |
| :--- | :---: | :---: | :-- |
| addOne | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-increment-an-arbitrary-precision-integer-add-two-numbers-in-binary-representation"></a>Variant: two numbers in binary representation
      **Task**: Add two numbers in binary representations  
      **Example**: "011", "1" -> "100"

      | Method | Algorithm | Time | Additional space |
      | :--- | :---: | :---: | :-- |
      | addOne_TwoBinaryNumbers | One iteration | O(n) | O(n) |
<br>

[Go back to Arrays TOC](#arrays)  
[Go back to TOC](#TOC)
<br>
<br>