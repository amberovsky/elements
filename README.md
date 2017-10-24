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

* [Erase lowest set bit](#primitive-types-erase-lowest-set-bit)
* [Is power of two](#primitive-types-is-power-of-two)
* [Count number of set bits](#primitive-types-count-number-of-set-bits)
* [Calculate parity](#primitive-types-calculate-parity)
* [Swap bits](#primitive-types-swap-bits)
* [Reverse bits](#primitive-types-reverse-bits)
* [Get closest number with same weight](#primitive-types-get-closest-number-with-same-weight)
* [Sum of two non-negative numbers](#primitive-types-sum-of-two-non-negative-numbers)
* [Product of two non-negative numbers](#primitive-types-product-of-two-non-negative-numbers)
* [Quotient of two positive numbers](#primitive-types-quotient-of-two-positive-numbers)
* [Calculate power](#primitive-types-calculate-power)
* [Reverse digits](#primitive-types-reverse-digits)
* [Is palindrome](#primitive-types-is-palindrome)
* [Uniform random number](#primitive-types-uniform-random-number)
* [Rectangle intersection](#primitive-types-rectangle-intersection)
* [Do four points form a rectangle](#primitive-types-do-four-points-form-a-rectangle)


<br>

### <a name="primitive-types-erase-lowest-set-bit"></a>Erase lowest set bit
**Task**: Erase lowest set bit for a given number.  
**Example**: 5 (=0110) -> 4 (=0100)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| eraseLowestSetBit | Bit/arithmetic operations | O(1) |
<br>

### <a name="primitive-types-is-power-of-two"></a>Is power of two
**Task**: Return true if given number is a power of two  
**Example**: 512 -> true  
**Example**: 511 -> false

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| isPowerOfTwo | Bit/arithmetic operations | O(1) |
<br>

### <a name="primitive-types-count-number-of-set-bits"></a>Count number of set bits
**Task**: Return the number of 1 in the binary representation of a given number  
**Example**: 256 (=10000000) -> 1  
**Example**: -1 (=111...1) -> Long.SIZE

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| countBitsByShifting | Shift number to the right | O(k), k is the number of set bits |
<br>

### <a name="primitive-types-calculate-parity"></a>Calculate parity
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

### <a name="primitive-types-swap-bits"></a>Swap bits
**Task**: Swap two bits on given positions for a given number  
**Example**: 584455544 (=100010110101100001010101111000) swap at 8 & 23 -> 584455544 (=100010110101100001010101111000)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| swapByBruteforce | Bit/arithmetic operations | O(1) |
<br>

### <a name="primitive-types-reverse-bits"></a>Reverse bits
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

### <a name="primitive-types-get-closest-number-with-same-weight"></a>Get closest number with same weight
**Task**: Given a number, find a closest one (by absolute difference) with same weight. Weight is the number of set bits  
**Example**: 100 (=01100100)-> 98 (01100010)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getClosestLongWithSameWeightByIteration | Iterate all bits | O(n), n is the number of bits |
| getClosestLongWithSameWeightByFast | Change only 2 bits | O(1) |
<br>

### <a name="primitive-types-sum-of-two-non-negative-numbers"></a>Sum of two non-negative numbers
**Task**: Given two numbers, calculate their sum without using arithmetical operations

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getSumOfTwoNonNegativeLongsByIteration | Iterate all bits | O(n), n is the number of bits |
| getSumOfTwoNonNegativeLongsByMask | Using carry mask | O(k), n is number of set bits in the second number |
<br>

### <a name="primitive-types-product-of-two-non-negative-numbers"></a>Product of two non-negative numbers
**Task**: Given two numbers, calculate their product without using arithmetical operations

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getProductOfTwoNonNegativeLongsByBruteforce | Add first number to itself second number times | O(2^n), n is the number of bits |
| getSumOfTwoNonNegativeLongsByMask | Using carry mask | O(k), k is number of set bits in the second number |
| getProductOfTwoNonNegativeLongsBySchoolMethod | Using school method | O(n) * Complexity of addition, n is the number of bits |
<br>

### <a name="primitive-types-quotient-of-two-positive-numbers"></a>Quotient of two positive numbers
**Task**: Given two numbers, calculate their quotient

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getQuotientOfTwoPositiveLongsByBruteforce | Subtract till reach zero | O(2^n), n is the number of bits |
| getQuotientOfTwoPositiveLongsBySchoolMethod | Using school method | O(n), n is the number of bits |
<br>

### <a name="primitive-types-calculate-power"></a>Calculate power
**Task**: Given two numbers x and y, calculate x^y

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getPowerByBruteforce | Multiple x by itself y times | O(2^n), n is the number of bits |
| getPowerByFast | Calculate x^(y/2) * x^(y/2) | O(k), k is number if bits in y |
<br>

### <a name="primitive-types-reverse-digits"></a>Reverse digits
**Task**: Reverse digits in given number  
**Example**: 10 -> 1  
**Example**: 719371291739 -> 937192173917

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| reverseDigits | Iterate all digits | O(p), p is number of digits |
<br>

### <a name="primitive-types-is-palindrome"></a>Is palindrome
**Task**: Return true if given number is a palindrome, false otherwise  
**Example**: 10 -> false  
**Example**: 121 -> true

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| isPalindromeByBruteforce | Iterate all digits | O(p), p is number of digits; O(p) space |
| isPalindromeByDigits | In-place, iterating to the middle | O(p), p is number of digits; O(1) space |
<br>

### <a name="primitive-types-uniform-random-number"></a>Uniform random number
**Task**: Generate a uniform random number in \[from; to\] range using given 0/1 uniform generator

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| generateUniformRandomNumber | Using lowest M such as M = 2^k - 1 and M >= to - from | O(lg(to - from  + 1)) |
<br>

### <a name="primitive-types-rectangle-intersection"></a>Rectangle intersection
**Task**: Determine if given 2 aligned with X-axis and Y-axis rectangles have intersection, return it in such case

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| checkTwoRectanglesHaveIntersection | Check when 2 rectangles do not have intersection | O(1) |
<br>

### <a name="primitive-types-do-four-points-form-a-rectangle"></a>Do four points form a rectangle
**Task**: Give 4 points on a plane determine do they form a rectangle

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| DoFourPointsFormRectangle | Use center of mass | O(1) |
<br>

[Go back to Primitive Types TOC](#primitive-types)  
[Go back to TOC](#TOC)
<br>
<br>
## <a name="arrays"></a>Arrays


WIP