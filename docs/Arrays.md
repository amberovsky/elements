## <a name="arrays"></a>2. Arrays
#### Various tasks on arrays

**Class**: [Arrays](/src/main/java/pro/amberovsky/elements/Arrays.java)  
**Factory**: [ArraysFactory](/src/main/java/pro/amberovsky/elements/ArraysFactory.java)

1. [Reorder even](#reorder-even)
2. [Dutch flag](#dutch-flag)
    * [Variant: only three values](#dutch-flag-only-three-values)
    * [Variant: only four values](#dutch-flag-only-four-values)
    * [Variant: only two (boolean) values](#dutch-flag-only-boolean-values)
    * [Variant: only two (boolean) values, keep order of true values](#dutch-flag-only-boolean-values-keep-order-of-true)
3. [Increment an arbitrary-precision integer](#increment-an-arbitrary-precision-integer)
    * [Variant: add two numbers in binary representation](#increment-an-arbitrary-precision-integer-add-two-numbers-in-binary-representation)
4. [Multiply two arbitrary-precision integers](#multiply-two-arbitrary-precision-integers)
5. [Advancing through an array](#advancing-through-an-array)
    * [Variant: compute minimum number of steps](#advancing-through-an-array-compute-minumum-number-of-steps)
6. [Delete duplicates from a sorted array](#delete-duplicates-from-a-sorted-array)
    * [Variant: one key](#delete-duplicates-from-a-sorted-array-one-key)
    * [Variant: min 2m](#delete-duplicates-from-a-sorted-array-min-2m)
7. [Buy and sell a stock once](#buy-and-sell-a-stock-once)
8. [Buy and sell a stock twice](#buy-and-sell-a-stock-twice)
    * [Variant: space](#buy-and-sell-a-stock-twice-space)
9. [Enumerate all primes to n](#enumerate-all-primes-to-n)
10. [Permute the elements of an array](#permute-the-elements-of-an-array)
    * [Variant: inverse a permutation](#permute-the-elements-of-an-array-inverse-a-permutation)
11. [Compute the next permutation](#compute-the-next-permutation)
    * [Variant: compute kth permutation](#compute-the-next-permutation-compute-kth-permutation)
    * [Variant: compute the previous permutation](#compute-the-next-permutation-compute-the-previous-permutation)
12. [Sample offline data](#sample-offline-data)
13. [Sample online data](#sample-online-data)
14. [Compute a random permutation](#compute-a-random-permutation)
15. [Compute a random subset](#compute-a-random-subset)
16. [Generate nonunifrom random numbers](#generate-nonuniform-random-numbers)
17. [The Sudoku checker problem](#the-sudoku-checker-problem)
18. [Compute the spiral ordering of a 2D array](#compute-the-spiral-ordering-of-a-2d-array)
    * [Variant: generate array in the spiral ordering](#compute-the-spiral-ordering-of-a-2d-array-generate-array-in-the-spiral-ordering)
    * [Variant: enumerate first pairs of integers in spiral order](#compute-the-spiral-ordering-of-a-2d-array-enumerate-first-pairs-of-integers-in-spiral-order)
    * [Variant: compute the spiral order for an mxn array](#compute-the-spiral-ordering-of-a-2d-array-compute-the-spiral-order-for-an-mxn-array)
    * [Variant: compute the last element in spiral order for an mxn array](#compute-the-spiral-ordering-of-a-2d-array-compute-the-last-element-in-spiral-order-mxn-array)
19. [Rotate a 2d array](#rotate-a-2d-array)
    * [Variant: reflect 2d array horizontal](#rotate-a-2d-array-reflect-2d-array-horizontal)
    * [Variant: reflect 2d array vertical](#rotate-a-2d-array-reflect-2d-array-vertical)
    * [Variant: reflect 2d array diagonal top-left](#rotate-a-2d-array-reflect-2d-array-diagonal-top-left)
    * [Variant: reflect 2d array diagonal top-right](#rotate-a-2d-array-reflect-2d-array-diagonal-top-right)
20. [Compute rows in Pascal's triangle](#compute-rows-in-pascals-triangle)
    * [Variant: compute the nth row of Pascal's triangle](#compute-rows-in-pascals-triangle-compute-the-nth-row-of-pascal-triangle)
      
<br>

### 1. <a name="reorder-even"></a>Reorder even
**Task**: Reorder array elements so that the even entries appear first  
**Example**: \[1, 2, 3, 4\] -> \[2, 4, 1, 3\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reorderEven | One iteration | O(n) | O(1) |
<br>

### 2. <a name="dutch-flag"></a>Dutch flag
**Task**: With given "pivot" value rearrange elements so first goes less than pivot, than equal, then greater  
**Example**: \[9, 8, 7, 6, 5, 4, 3, 2, 1\], pivot: 8 -> \[1, 2, 3, 4, 5, 6, 7, 8, 9\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| DutchFlag | One iteration | O(n) | O(1) |

   * ### <a name="dutch-flag-only-three-values"></a>Variant: only three values
      **Task**: Assuming that elements take one of three values, reorder the array so that all objects with the same key appear together  
      **Example**: \[0, 1, 2, 0, 2, 1, 1\] -> \[0, 0, 1, 1, 2, 2\]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyThreeValues | One iteration | O(n) | O(1) |

   * ### <a name="dutch-flag-only-four-values"></a>Variant: only four values
      **Task**: Assuming that elements take one of four values, reorder the array so that all objects with the same key appear together  
      **Example**: \[0, 1, 2, 0, 2, 1, 1, 5\] -> \[0, 0, 1, 1, 1, 2, 2, 5\]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyFourValues | One iteration | O(n) | O(1) |

   * ### <a name="dutch-flag-only-boolean-values"></a>Variant: only two (boolean) values
      **Task**: Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyTwoValues | One iteration | O(n) | O(1) |

   * ### <a name="dutch-flag-only-boolean-values-keep-order-of-true"></a>Variant: only two (boolean) values, keep order of true values
      **Task**: Assuming that elements take only 0/1 (false/true), reorder the array so that false comes first and maintain the relative order of true  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | DutchFlag_OnlyTwoValuesKeepOrderOfOneValue | One iteration | O(n) | O(1) |
<br>

### 3. <a name="increment-an-arbitrary-precision-integer"></a>Increment an arbitrary-precision integer
**Task**:  add 1 to given array of digits representing a number of any length  
**Example**: \[3, 4, 2, 1\] -> \[3, 4, 2, 2\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| addOne | One iteration | O(n) | O(1) |

   * ### <a name="increment-an-arbitrary-precision-integer-add-two-numbers-in-binary-representation"></a>Variant: two numbers in binary representation
      **Task**: Add two numbers in binary representations  
      **Example**: "011", "1" -> "100"

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | addOne_TwoBinaryNumbers | One iteration | O(n) | O(n) |
<br>

### 4. <a name="multiply-two-arbitrary-precision-integers"></a>Multiply two arbitrary-precision integers
**Task**: Write a program that takes two arrays representing integers, and returns an integer representing their product  
**Example**: \[1, 9, 3, 7, 0, 7, 7, 2, 1\], \[-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7] -> [-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| multiply | school multiplication | O(mn) | O(mn) |
<br>

### 5. <a name="advancing-through-an-array"></a>Advancing through an array
**Task**: Advance through a board where each element represents maximum number of steps. Determine is it possible to reach the end?  
**Example**: \[3, 3, 1, 0, 2, 0, 1\] -> true  
**Example**: \[3, 2, 0, 0, 2, 0, 1\] -> false

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| boardGame | One iteration | O(n) | O(1) |

   * ### <a name="advancing-through-an-array-compute-minumum-number-of-steps"></a>Variant: compute minimum number of steps
      **Task**: Compute minimum number of steps for the board game  
      **Example**: \[3, 2, 2, 0\] -> 1

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | boardGame_MinimumSteps |  | O(n^2) | O(n) |
<br>

### 6. <a name="delete-duplicates-from-a-sorted-array"></a>Delete duplicates from a sorted array
**Task**: Delete duplicates from a sorted array  
**Example**: \[2, 3, 5, 5, 7, 11, 11, 11, 13\] -> \[2, 3, 5, 7, 11, 13, 0, 0, 0\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| deleteDuplicates_Bruteforce | Bruteforce | O(n^2) | O(1) |
| deleteDuplicates_Fast | One iteration | O(n) | O(1) |

   * ### <a name="delete-duplicates-from-a-sorted-array-one-key"></a>Variant: one key
      **Task**: Implement a function which takes as input an array and a key and updates the array so that all occurrences of the input key have been removed and the remaining elements have been shifted left to fill the emptied indices  
      **Example**: \[2, 3, 5, 5, 7, 11, 11, 11, 13\], 5 -> \[2, 3, 7, 11, 11, 11, 13, 0, 0\]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | deleteDuplicates_OneKey | One iteration | O(n) | O(1) |

   * ### <a name="delete-duplicates-from-a-sorted-array-min-2m"></a>Variant: min 2m
      **Task**: Write a program which takes as input a sorted array A of integers and a positive integer m,and updates A so that if x appears m times in A it appears exactly min(2,m) times in A.  
      **Example**: \[1, 1, 2\], 1 -> \[1, 2, 0\]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | deleteDuplicates_Min2m | One iteration | O(n) | O(1) |
<br>

### 7. <a name="buy-and-sell-a-stock-once"></a>Buy and sell a stock once
**Task**: Problem of optimally buying and selling a stock once  
**Example**: \[310, 315, 275, 295, 260, 270, 290, 230, 255, 250\] -> 30

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| buyAndSellAStockOnce | One iteration | O(n) | O(1) |
<br>

### 8. <a name="buy-and-sell-a-stock-twice"></a>Buy and sell a stock twice
**Task**: Write a program that computes the maximum profit that can be made by buying and selling a share at most twice. The second buy must be made on another date after the first sale.  
**Example**: \[12, 11, 13, 9, 12, 8, 14, 13, 15\] -> 10

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| buyAndSellAStockTwice | One iteration | O(n) | O(n) |

   * ### <a name="buy-and-sell-a-stock-twice-space"></a>Variant: space
      **Task**: Reduce space to O(1)  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | buyAndSellAStockTwice_Space | One iteration | O(n) | O(1) |
<br>

### 9. <a name="enumerate-all-primes-to-n"></a>Enumerate all primes to n
**Task**: Enumerate all primes to n  
**Example**: 20 -> \[1, 2, 3, 5, 7, 11, 13, 17, 19\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| enumerateAllPrimes | Sieve of Eratosthenes | O(n log log n)) | O(n) |
<br>

### 10. <a name="permute-the-elements-of-an-array"></a>Permute the elements of an array
**Task**: Apply given permutation to the given array.  
**Example**: \[4, 10, 3, 100\], \[2, 3, 1, 0\] -> \[100, 3, 4, 10\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| permuteTheElementsOfAnArray | One iteration | O(n) | O(n) |
| permuteTheElementsOfAnArray_Space | One iteration | O(n) | O(1) |

   * ### <a name="permute-the-elements-of-an-array-inverse-a-permutation"></a>Variant: inverse a permutation
      **Task**: Inverse a permutation  
      
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | inversePermutation | One iteration | O(n) | O(1) |
<br>

### 11. <a name="compute-the-next-permutation"></a>Compute the next permutation
**Task**: Compute the next permutation  
**Example**: \[2, 0, 1\] -> \[2, 1, 0\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheNextPermutation | One iteration | O(n) | O(1) |

   * ### <a name="compute-the-next-permutation-compute-kth-permutation"></a>Variant: compute kth permutation
      **Task**: Compute k-th permutation, starting from the identity permutation  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeKthPermutation | Factorial number system | O(n^2) | O(1) |

   * ### <a name="compute-the-next-permutation-compute-the-previous-permutation"></a>Variant: compute the previous permutation
      **Task**: Compute the previous permutation  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | deleteDuplicates_Min2m | One iteration | O(n) | O(1) |
<br>

### 12. <a name="sample-offline-data"></a>Sample offline data
**Task**: Implement an algorithm that takes as input an array of distinct elements and a size, and returns a subset of the given size of the array elements. All subsets should be equally likely. Return the result in input array itself  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sampleOfflineData | | O(size) | O(1) |
<br>

### 13. <a name="sample-online-data"></a>Sample online data
**Task**: Design a program that takes as input a size k, and reads packets, continuously maintaining a uniform random subset of size k of the read packets  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sampleOnlineData | | O(n) | O(k) |
<br>

### 14. <a name="compute-a-random-permutation"></a>Compute a random permutation
**Task**: Create uniformly random permutation of {0, 1, ..., n-1}  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeARandomPermutation | Sample offline data | O(n) | O(1) |
<br>

### 15. <a name="compute-a-random-subset"></a>Compute a random subset
**Task**: Compute a randomly unformed subset size of k  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeARandomSubset | Hashtable | O(k) | O(k) |
<br>

### 16. <a name="generate-nonuniform-random-numbers"></a>Generate nonuniform random number
**Task**: Given a random number generator that produces values in \[0,1\] uniformly, generate one of the n numbers according to the specified probabilities  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| generateNonuniformRandomNumbers | | O(n) | O(n) |
<br>

### 17. <a name="the-sudoku-checker-problem"></a>The SUDOKU checker problem
**Task**: Check if partial sudoku board valid  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| checkPartialSudoku | | O(n^2) | O(n) |
<br>

### 18. <a name="compute-the-spiral-ordering-of-a-2d-array"></a>Compute the spiral ordering of a 2D array
**Task**: Compute the spiral ordering of a 2D array  
**Example**: 2 -> \[1, 2, 4, 3\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheSpiralOrderingOfA2DArray | | O(n^2) | O(1) |

   * ### <a name="compute-the-spiral-ordering-of-a-2d-array-generate-array-in-the-spiral-ordering"></a>Variant: generate array in the spiral ordering
      **Task**: Generate array in the spiral ordering  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | generateArrayInTheSpiralOrdering | | O(n^2) | O(1) |

   * ### <a name="compute-the-spiral-ordering-of-a-2d-array-enumerate-first-pairs-of-integers-in-spiral-order"></a>Variant: enumerate first pairs of integers in spiral order
      **Task**: Write a program to enumerate the first n pairs of integers (a,b) in spiral order  
      **Example**: 2 -> \[(0,0), (1,0)\]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | enumerateFirstPairsOfIntegersInSpiralOrder | | O(n) | O(1) |

   * ### <a name="compute-the-spiral-ordering-of-a-2d-array-compute-the-spiral-order-for-an-mxn-array"></a>Variant: compute the spiral order for an mxn array
      **Task**: Compute the spiral order for an m X n 2D array A  
      **Example**: 1, 5 -> \[1, 2, 3, 4, 5\]

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheSpiralOrderOfMNArray| | O(mn) | O(1) |

   * ### <a name="compute-the-spiral-ordering-of-a-2d-array-compute-the-last-element-in-spiral-order-mxn-array"></a>Variant: compute the last element in spiral order for an mxn array
      **Task**: Compute the last element in spiral order for an m X n 2D array  
      **Example**: 2, 3 -> 4

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheLastElementInSpiralOrderMNArray | | O(1) | O(1) |
<br>

### 19. <a name="rotate-a-2d-array"></a>Rotate a 2d array
**Task**: Rotate the 2D array by 90 degrees clockwise.  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| rotate2DArray | | O(n) | O(1) |

   * ### <a name="rotate-a-2d-array-reflect-2d-array-horizontal"></a>Variant: reflect 2d array horizontal
      **Task**: Reflect 2D array about horizontal axis 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayHorizontal | | O(n) | O(1) |

   * ### <a name="rotate-a-2d-array-reflect-2d-array-vertical"></a>Variant: reflect 2d array vertical
      **Task**: Reflect 2D array about vertical axis  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayVertical | | O(n) | O(1) |

   * ### <a name="rotate-a-2d-array-reflect-2d-array-diagonal-top-left"></a>Variant: reflect 2d array diagonal top-left
      **Task**: Reflect 2D array about diagonal axis from top-left  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayDiagonalTopLeft| | O(n) | O(1) |

   * ### <a name="rotate-a-2d-array-reflect-2d-array-diagonal-top-right"></a>Variant: reflect 2d array diagonal top-right
      **Task**: Reflect 2D array about diagonal axis from top-right  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reflect2DArrayDiagonalTopRight | | O(n) | O(1) |
<br>

### 20. <a name="compute-rows-in-pascals-triangle"></a>Compute rows in Pascal's triangle
**Task**: Generate the first n rows of Pascal's triangle  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeRowsInPascalTriangle | | O(n^2) | O(n^2) |

   * ### <a name="compute-rows-in-pascals-triangle-compute-the-nth-row-of-pascal-triangle"></a>Variant: compute the nth row of Pascal's triangle
      **Task**: Compute the nth row of Pascal's triangle 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeNthRowOfPascalTriangle | | O(n^2) | O(n) |
<br>

[Go back to Arrays TOC](#arrays)  
[Go back](/README.md)
