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
**Factory**: [ArraysFactory](src/main/java/pro/amberovsky/elements/ArraysFactory.java)

1. [Reorder even](#arrays-reorder-even)
2. [Dutch flag](#arrays-dutch-flag)
   * [Variant: only three values](#arrays-dutch-flag-only-three-values)
   * [Variant: only four values](#arrays-dutch-flag-only-four-values)
   * [Variant: only two (boolean) values](#arrays-dutch-flag-only-boolean-values)
   * [Variant: only two (boolean) values, keep order of true values](#arrays-dutch-flag-only-boolean-values-keep-order-of-true)
3. [Increment an arbitrary-precision integer](#arrays-increment-an-arbitrary-precision-integer)
   * [Variant: add two numbers in binary representation](#arrays-increment-an-arbitrary-precision-integer-add-two-numbers-in-binary-representation)
4. [Multiply two arbitrary-precision integers](#arrays-multiply-two-arbitrary-precision-integers)
5. [Advancing through an array](#arrays-advancing-through-an-array)
   * [Variant: compute minimum number of steps](#arrays-advancing-through-an-array-compute-minumum-number-of-steps)
6. [Delete duplicates from a sorted array](#arrays-delete-duplicates-from-a-sorted-array)
   * [Variant: one key](#arrays-delete-duplicates-from-a-sorted-array-one-key)
   * [Variant: min 2m](#arrays-delete-duplicates-from-a-sorted-array-min-2m)
7. [Buy and sell a stock once](#arrays-buy-and-sell-a-stock-once)
8. [Buy and sell a stock twice](#arrays-buy-and-sell-a-stock-twice)
   * [Variant: space](#arrays-buy-and-sell-a-stock-twice-space)
9. [Enumerate all primes to n](#arrays-enumerate-all-primes-to-n)
10. [Permute the elements of an array](#arrays-permute-the-elements-of-an-array)
   * [Variant: inverse a permutation](#arrays-permute-the-elements-of-an-array-inverse-a-permutation)
11. [Compute the next permutation](#arrays-compute-the-next-permutation)
   * [Variant: compute kth permutation](#arrays-compute-the-next-permutation-compute-kth-permutation)
   * [Variant: compute the previous permutation](#arrays-compute-the-next-permutation-compute-the-previous-permutation)
12. [Sample offline data](#arrays-sample-offline-data)
13. [Sample online data](#arrays-sample-online-data)
14. [Compute a random permutation](#arrays-compute-a-random-permutation)
15. [Compute a random subset](#arrays-compute-a-random-subset)
16. [Generate nonunifrom random numbers](#arrays-generate-nonuniform-random-numbers)
17. [The Sudoku checker problem](#arrays-the-sudoku-checker-problem)
18. [Compute the spiral ordering of a 2D array](#arrays-compute-the-spiral-ordering-of-a-2d-array)
   * [Variant: generate array in the spiral ordering](#arrays-compute-the-spiral-ordering-of-a-2d-array-generate-array-in-the-spiral-ordering)
   * [Variant: enumerate first pairs of integers in spiral order](#arrays-compute-the-spiral-ordering-of-a-2d-array-enumerate-first-pairs-of-integers-in-spiral-order)
   * [Variant: compute the spiral order for an mxn array](#arrays-compute-the-spiral-ordering-of-a-2d-array-compute-the-spiral-order-for-an-mxn-array)
   * [Variant: compute the last element in spiral order for an mxn array](#arrays-compute-the-spiral-ordering-of-a-2d-array-compute-the-last-element-in-spiral-order-mxn-array)
19. [Rotate a 2d array](#arrays-rotate-a-2d-array)
   * [Variant: reflect 2d array horizontal](#arrays-rotate-a-2d-array-reflect-2d-array-horizontal)
   * [Variant: reflect 2d array vertical](#arrays-rotate-a-2d-array-reflect-2d-array-vertical)
   * [Variant: reflect 2d array diagonal top-left](#arrays-rotate-a-2d-array-reflect-2d-array-diagonal-top-left)
   * [Variant: reflect 2d array diagonal top-right](#arrays-rotate-a-2d-array-reflect-2d-array-diagonal-top-right)
20. [Compute rows in Pascal's triangle](#arrays-compute-rows-in-pascals-triangle)
   * [Variant: compute the nth row of Pascal's triangle](#arrays-compute-rows-in-pascals-triangle-compute-the-nth-row-of-pascal-triangle)
      
<br>

### 1. <a name="arrays-reorder-even"></a>Reorder even
**Task**: Reorder array elements so that the even entries appear first 
**Example**: [1, 2, 3, 4] -> [2, 4, 1, 3]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reorderEven | One iteration | O(n) | O(1) |
<br>

### 2. <a name="arrays-dutch-flag"></a>Dutch flag
**Task**: With given "pivot" value rearrange elements so first goes less than pivot, than equal, then greater  
**Example**: [9, 8, 7, 6, 5, 4, 3, 2, 1], pivot: 8 -> [1, 2, 3, 4, 5, 6, 7, 8, 9]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| DutchFlag | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-three-values"></a>Variant: only three values
      **Task**: Assuming that elements take one of three values, reorder the array so that all objects with the same key appear together  
      **Example**: [0, 1, 2, 0, 2, 1, 1] -> [0, 0, 1, 1, 2, 2]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyThreeValues | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-four-values"></a>Variant: only four values
      **Task**: Assuming that elements take one of four values, reorder the array so that all objects with the same key appear together  
      **Example**: [0, 1, 2, 0, 2, 1, 1, 5] -> [0, 0, 1, 1, 1, 2, 2, 5]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyFourValues | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-boolean-values"></a>Variant: only two (boolean) values
      **Task**: Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyTwoValues | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-dutch-flag-only-boolean-values-keep-order-of-true"></a>Variant: only two (boolean) values, keep order of true values
      **Task**: Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first and maintain the relative order of true  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyTwoValuesKeepOrderOfOneValue | One iteration | O(n) | O(1) |
<br>

### 3. <a name="arrays-increment-an-arbitrary-precision-integer"></a>Increment an arbitrary-precision integer
**Task**:  add 1 to given array of digits representing a number of any length  
**Example**: [3, 4, 2, 1] -> [3, 4, 2, 2]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| addOne | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-increment-an-arbitrary-precision-integer-add-two-numbers-in-binary-representation"></a>Variant: two numbers in binary representation
      **Task**: Add two numbers in binary representations  
      **Example**: "011", "1" -> "100"

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | addOne_TwoBinaryNumbers | One iteration | O(n) | O(n) |
<br>

### 4. <a name="arrays-multiply-two-arbitrary-precision-integers"></a>Multiply two arbitrary-precision integers
**Task**: Write a program that takes two arrays representing integers, and returns an integer representing their product  
**Example**: [1, 9, 3, 7, 0, 7, 7, 2, 1], [-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7] -> [-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| multiply | school multiplication | O(mn) | O(mn) |
<br>

### 5. <a name="arrays-advancing-through-an-array"></a>Advancing through an array
**Task**: Advance through a board where each element represents maximum number of steps. Determine is it possible to reach the end?  
**Example**: [3, 3, 1, 0, 2, 0, 1] -> true  
**Example**: [3, 2, 0, 0, 2, 0, 1] -> false

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| boardGame | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-advancing-through-an-array-compute-minumum-number-of-steps"></a>Variant: compute minimum number of steps
      **Task**: Compute minimum number of steps for the board game  
      **Example**: [3, 2, 2, 0] -> 1

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | boardGame_MinimumSteps |  | O(n^2) | O(n) |
<br>

### 6. <a name="arrays-delete-duplicates-from-a-sorted-array"></a>Delete duplicates from a sorted array
**Task**: Delete duplicates from a sorted array  
**Example**: [2, 3, 5, 5, 7, 11, 11, 11, 13] -> [2, 3, 5, 7, 11, 13, 0, 0, 0]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| deleteDuplicates_Bruteforce | Bruteforce | O(n^2) | O(1) |
| deleteDuplicates_Fast | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-delete-duplicates-from-a-sorted-array-one-key"></a>Variant: one key
      **Task**: Implement a function which takes as input an array and a key and updates the array so that all occurrences of the input key have been removed and the remaining elements have been shifted left to fill the emptied indices  
      **Example**: [2, 3, 5, 5, 7, 11, 11, 11, 13], 5 -> [2, 3, 7, 11, 11, 11, 13, 0, 0]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | deleteDuplicates_OneKey | One iteration | O(n) | O(1) |
<br>

   * ### <a name="arrays-delete-duplicates-from-a-sorted-array-min-2m"></a>Variant: min 2m
      **Task**: Write a program which takes as input a sorted array A of integers and a positive integer m,and updates A so that if x appears m times in A it appears exactly min(2,m) times in A.  
      **Example**: [1, 1, 2], 1 -> [1, 2, 0]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | deleteDuplicates_Min2m | One iteration | O(n) | O(1) |
<br>

### 7. <a name="arrays-buy-and-sell-a-stock-once"></a>Buy and sell a stock once
**Task**: Problem of optimally buying and selling a stock once  
**Example**: [310, 315, 275, 295, 260, 270, 290, 230, 255, 250] -> 30

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| buyAndSellAStockOnce | One iteration | O(n) | O(1) |
<br>

### 8. <a name="arrays-buy-and-sell-a-stock-twice"></a>Buy and sell a stock twice
**Task**: Write a program that computes the maximum profit that can be made by buying and selling a share at most twice. The second buy must be made on another date after the first sale.  
**Example**: [12, 11, 13, 9, 12, 8, 14, 13, 15] -> 10

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| buyAndSellAStockTwice | One iteration | O(n) | O(n) |
<br>

   * ### <a name="arrays-buy-and-sell-a-stock-twice-space"></a>Variant: space
      **Task**: Reduce space to O(1)  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | buyAndSellAStockTwice_Space | One iteration | O(n) | O(1) |
<br>

### 9. <a name="arrays-enumerate-all-primes-to-n"></a>Enumerate all primes to n
**Task**: Enumerate all primes to n  
**Example**: 20 -> [1, 2, 3, 5, 7, 11, 13, 17, 19]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| enumerateAllPrimes | Sieve of Eratosthenes | O(n log log n)) | O(n) |
<br>

### 10. <a name="arrays-permute-the-elements-of-an-array"></a>Permute the elements of an array
**Task**: Apply given permutation to the given array.  
**Example**: [4, 10, 3, 100], [2, 3, 1, 0] -> [100, 3, 4, 10]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| permuteTheElementsOfAnArray | One iteration | O(n) | O(n) |
| permuteTheElementsOfAnArray_Space | One iteration | O(n) | O(1) |

<br>

   * ### <a name="arrays-permute-the-elements-of-an-array-inverse-a-permutation"></a>Variant: inverse a permutation
      **Task**: Inverse a permutation  
      
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | inversePermutation | One iteration | O(n) | O(1) |
<br>

### 11. <a name="arrays-compute-the-next-permutation"></a>Compute the next permutation
**Task**: Compute the next permutation  
**Example**: [2, 0, 1] -> [2, 1, 0]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheNextPermutation | One iteration | O(n) | O(1) |

<br>

   * ### <a name="arrays-compute-the-next-permutation-compute-kth-permutation"></a>Variant: compute kth permutation
      **Task**: Compute k-th permutation, starting from the identity permutation  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeKthPermutation | Factorial number system | O(n^2) | O(1) |
<br>

   * ### <a name="arrays-compute-the-next-permutation-compute-the-previous-permutation"></a>Variant: compute the previous permutation
      **Task**: Compute the previous permutation  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | deleteDuplicates_Min2m | One iteration | O(n) | O(1) |
<br>

### 12. <a name="arrays-sample-offline-data"></a>Sample offline data
**Task**: Implement an algorithm that takes as input an array of distinct elements and a size, and returns a subset of the given size of the array elements. All subsets should be equally likely. Return the result in input array itself  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sampleOfflineData | | O(size) | O(1) |
<br>

### 13. <a name="arrays-sample-online-data"></a>Sample online data
**Task**: Design a program that takes as input a size k, and reads packets, continuously maintaining a uniform random subset of size k of the read packets  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sampleOnlineData | | O(n) | O(k) |
<br>

### 14. <a name="arrays-compute-a-random-permutation"></a>Compute a random permutation
**Task**: Create uniformly random permutation of {0, 1, ..., n-1}  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeARandomPermutation | Sample offline data | O(n) | O(1) |
<br>

### 15. <a name="arrays-compute-a-random-subset"></a>Compute a random subset
**Task**: Compute a randomly unformed subset size of k  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeARandomSubset | Hashtable | O(k) | O(k) |
<br>

### 16. <a name="arrays-generate-nonuniform-random-numbers"></a>Generate nonuniform random number
**Task**: Given a random number generator that produces values in [0,1] uniformly, generate one of the n numbers according to the specified probabilities  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| generateNonuniformRandomNumbers | | O(n) | O(n) |
<br>

### 17. <a name="arrays-the-sudoku-checker-problem"></a>The SUDOKU checker problem
**Task**: Check if partial sudoku board valid  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| checkPartialSudoku | | O(n^2) | O(n) |
<br>

### 18. <a name="arrays-compute-the-spiral-ordering-of-a-2d-array"></a>Compute the spiral ordering of a 2D array
**Task**: Compute the spiral ordering of a 2D array  
**Example**: 2 -> [1, 2, 4, 3]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheSpiralOrderingOfA2DArray | | O(n^2) | O(1) |
<br>

   * ### <a name="arrays-compute-the-spiral-ordering-of-a-2d-array-generate-array-in-the-spiral-ordering"></a>Variant: generate array in the spiral ordering
      **Task**: Generate array in the spiral ordering  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | generateArrayInTheSpiralOrdering | | O(n^2) | O(1) |
<br>

   * ### <a name="arrays-compute-the-spiral-ordering-of-a-2d-array-enumerate-first-pairs-of-integers-in-spiral-order"></a>Variant: enumerate first pairs of integers in spiral order
      **Task**: Write a program to enumerate the first n pairs of integers (a,b) in spiral order  
      **Example**: 2 -> [(0,0), (1,0)]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | enumerateFirstPairsOfIntegersInSpiralOrder | | O(n) | O(1) |
<br>

   * ### <a name="arrays-compute-the-spiral-ordering-of-a-2d-array-compute-the-spiral-order-for-an-mxn-array"></a>Variant: compute the spiral order for an mxn array
      **Task**: Compute the spiral order for an m X n 2D array A  
      **Example**: 1, 5 -> [1, 2, 3, 4, 5]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheSpiralOrderOfMNArray| | O(mn) | O(1) |
<br>

   * ### <a name="arrays-compute-the-spiral-ordering-of-a-2d-array-compute-the-last-element-in-spiral-order-mxn-array"></a>Variant: compute the last element in spiral order for an mxn array
      **Task**: Compute the last element in spiral order for an m X n 2D array  
      **Example**: 2, 3 -> 4

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheLastElementInSpiralOrderMNArray | | O(1) | O(1) |
<br>

### 19. <a name="arrays-rotate-a-2d-array"></a>Rotate a 2d array
**Task**: Rotate the 2D array by 90 degrees clockwise.  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| rotate2DArray | | O(n) | O(1) |
<br>

   * ### <a name="arrays-rotate-a-2d-array-reflect-2d-array-horizontal"></a>Variant: reflect 2d array horizontal
      **Task**: Reflect 2D array about horizontal axis 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayHorizontal | | O(n) | O(1) |
<br>

   * ### <a name="arrays-rotate-a-2d-array-reflect-2d-array-vertical"></a>Variant: reflect 2d array vertical
      **Task**: Reflect 2D array about vertical axis  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayVertical | | O(n) | O(1) |
<br>

   * ### <a name="arrays-rotate-a-2d-array-reflect-2d-array-diagonal-top-left"></a>Variant: reflect 2d array diagonal top-left
      **Task**: Reflect 2D array about diagonal axis from top-left  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayDiagonalTopLeft| | O(n) | O(1) |
<br>

   * ### <a name="arrays-rotate-a-2d-array-reflect-2d-array-diagonal-top-right"></a>Variant: reflect 2d array diagonal top-right
      **Task**: Reflect 2D array about diagonal axis from top-right  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayDiagonalTopRight | | O(n) | O(1) |
<br>

### 20. <a name="arrays-compute-rows-in-pascals-triangle"></a>Compute rows in Pascal's triangle
**Task**: Generate the first n rows of Pascal's triangle  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeRowsInPascalTriangle | | O(n^2) | O(n^2) |
<br>

   * ### <a name="arrays-compute-rows-in-pascals-triangle-compute-the-nth-row-of-pascal-triangle"></a>Variant: compute the nth row of Pascal's triangle
      **Task**: Compute the nth row of Pascal's triangle 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeNthRowOfPascalTriangle | | O(n^2) | O(n) |
<br>

[Go back to Arrays TOC](#arrays)  
[Go back to TOC](#TOC)
<br>
<br>