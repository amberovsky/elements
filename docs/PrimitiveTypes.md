## <a name="primitive-types"></a>1. Primitive Types
#### Basic tasks with numbers & bits 

**Class**: [PrimitiveTypes](/src/main/java/pro/amberovsky/elements/PrimitiveTypes.java)  
**Factory**: [PrimitiveTypesFactory](/src/main/java/pro/amberovsky/elements/PrimitiveTypesFactory.java)

1. [Erase lowest set bit](#erase-lowest-set-bit)
2. [Is power of two](#is-power-of-two)
3. [Count number of set bits](#count-number-of-set-bits)
4. [Calculate parity](#calculate-parity)
5. [Swap bits](#swap-bits)
6. [Reverse bits](#reverse-bits)
7. [Get closest number with same weight](#get-closest-number-with-same-weight)
8. [Sum of two non-negative numbers](#sum-of-two-non-negative-numbers)
9. [Product of two non-negative numbers](#product-of-two-non-negative-numbers)
10. [Quotient of two positive numbers](#quotient-of-two-positive-numbers)
11. [Calculate power](#calculate-power)
12. [Reverse digits](#reverse-digits)
13. [Is palindrome](#is-palindrome)
14. [Uniform random number](#uniform-random-number)
15. [Rectangle intersection](#rectangle-intersection)
16. [Do four points form a rectangle](#do-four-points-form-a-rectangle)

<br>

### 1. <a name="erase-lowest-set-bit"></a>Erase lowest set bit
**Task**: Erase lowest set bit for a given number.  
**Example**: 5 (=0110) -> 4 (=0100)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| eraseLowestSetBit | Bit/arithmetic operations | O(1) |
<br>

### 2. <a name="is-power-of-two"></a>Is power of two
**Task**: Return true if given number is a power of two  
**Example**: 512 -> true  
**Example**: 511 -> false

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| isPowerOfTwo | Bit/arithmetic operations | O(1) |
<br>

### 3. <a name="count-number-of-set-bits"></a>Count number of set bits
**Task**: Return the number of 1 in the binary representation of a given number  
**Example**: 256 (=10000000) -> 1  
**Example**: -1 (=111...1) -> Long.SIZE

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| countBitsByShifting | Shift number to the right | O(k), k is the number of set bits |
<br>

### 4. <a name="calculate-parity"></a>Calculate parity
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

### 5. <a name="swap-bits"></a>Swap bits
**Task**: Swap two bits on given positions for a given number  
**Example**: 584455544 (=100010110101100001010101111000) swap at 8 & 23 -> 584455544 (=100010110101100001010101111000)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| swapByBruteforce | Bit/arithmetic operations | O(1) |
<br>

### 6. <a name="reverse-bits"></a>Reverse bits
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

### 7. <a name="get-closest-number-with-same-weight"></a>Get closest number with same weight
**Task**: Given a number, find a closest one (by absolute difference) with same weight. Weight is the number of set bits  
**Example**: 100 (=01100100)-> 98 (01100010)

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getClosestLongWithSameWeightByIteration | Iterate all bits | O(n), n is the number of bits |
| getClosestLongWithSameWeightByFast | Change only 2 bits | O(1) |
<br>

### 8. <a name="sum-of-two-non-negative-numbers"></a>Sum of two non-negative numbers
**Task**: Given two numbers, calculate their sum without using arithmetical operations

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getSumOfTwoNonNegativeLongsByIteration | Iterate all bits | O(n), n is the number of bits |
| getSumOfTwoNonNegativeLongsByMask | Using carry mask | O(k), n is number of set bits in the second number |
<br>

### 9. <a name="product-of-two-non-negative-numbers"></a>Product of two non-negative numbers
**Task**: Given two numbers, calculate their product without using arithmetical operations

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getProductOfTwoNonNegativeLongsByBruteforce | Add first number to itself second number times | O(2^n), n is the number of bits |
| getSumOfTwoNonNegativeLongsByMask | Using carry mask | O(k), k is number of set bits in the second number |
| getProductOfTwoNonNegativeLongsBySchoolMethod | Using school method | O(n) * Complexity of addition, n is the number of bits |
<br>

### 10. <a name="quotient-of-two-positive-numbers"></a>Quotient of two positive numbers
**Task**: Given two numbers, calculate their quotient

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getQuotientOfTwoPositiveLongsByBruteforce | Subtract till reach zero | O(2^n), n is the number of bits |
| getQuotientOfTwoPositiveLongsBySchoolMethod | Using school method | O(n), n is the number of bits |
<br>

### 11. <a name="calculate-power"></a>Calculate power
**Task**: Given two numbers x and y, calculate x^y

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| getPowerByBruteforce | Multiple x by itself y times | O(2^n), n is the number of bits |
| getPowerByFast | Calculate x^(y/2) * x^(y/2) | O(k), k is number if bits in y |
<br>

### 12. <a name="reverse-digits"></a>Reverse digits
**Task**: Reverse digits in given number  
**Example**: 10 -> 1  
**Example**: 719371291739 -> 937192173917

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| reverseDigits | Iterate all digits | O(p), p is number of digits |
<br>

### 13. <a name="is-palindrome"></a>Is palindrome
**Task**: Return true if given number is a palindrome, false otherwise  
**Example**: 10 -> false  
**Example**: 121 -> true

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| isPalindromeByBruteforce | Iterate all digits | O(p), p is number of digits; O(p) space |
| isPalindromeByDigits | In-place, iterating to the middle | O(p), p is number of digits; O(1) space |
<br>

### 14. <a name="uniform-random-number"></a>Uniform random number
**Task**: Generate a uniform random number in \[from; to\] range using given 0/1 uniform generator

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| generateUniformRandomNumber | Using lowest M such as M = 2^k - 1 and M >= to - from | O(lg(to - from  + 1)) |
<br>

### 15. <a name="rectangle-intersection"></a>Rectangle intersection
**Task**: Determine if given 2 aligned with X-axis and Y-axis rectangles have intersection, return it in such case

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| checkTwoRectanglesHaveIntersection | Check when 2 rectangles do not have intersection | O(1) |
<br>

### 16. <a name="do-four-points-form-a-rectangle"></a>Do four points form a rectangle
**Task**: Give 4 points on a plane determine do they form a rectangle

| Method | Algorithm | Complexity |
| :--- | :---: | :--- |
| DoFourPointsFormRectangle | Use center of mass | O(1) |
<br>

[Go back to Primitive Types TOC](#primitive-types)  
[Go back](/README.md)
