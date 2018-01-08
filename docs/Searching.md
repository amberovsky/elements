## <a name="searching"></a>8. Searching
#### Various searching tasks

**Class**: [Searching](/src/main/java/pro/amberovsky/elements/Searching.java)  

1. [Search a sorted array for first occurrence of k](#search-a-sorted-array-for-first-occurrence-of-k)
    * Variant: greater than the key
    * Variant: local minimum
    * Variant: enclosing interval
    * Variant: prefix
2. [Search a sorted array for entry equal to its index](#search-a-sorted-array-for-entry-equal-to-its-index)
    * Variant: duplicates
3. [Search a cyclically sorted array](#search-a-cyclically-sorted-array)
    * Variant: maximum element
    * Variant: find the position
4. [Compute the integer square root](#compute-the-integer-square-root)
5. [Compute the real square root](#compute-the-real-square-root)
    * Variant: without division operator
6. [Search in a 2D sorted array](#search-in-a-2d-sorted-array)
7. [Find the min and max simultaneously](#find-the-min-and-max-simultaneously)
8. [Find the kth largest element](#find-the-kth-largest-element)
    * Variant: median
    * Variant: kth largest with duplicates
    * Variant: mailboxes
9. [Find the missing IP address](#find-the-missing-ip-address)
10. [Find the duplicate and missing elements](#find-the-duplicate-and-missing-elements)
      
<br>

### 1. <a name="search-a-sorted-array-for-first-occurrence-of-k"></a>Search a sorted array for first occurrence of k
**Task**: Search a sorted array for first occurrence of k  
**Example**: \[-14, -10, 2, 108, 108, 243, 285, 285, 285, 401\], 108 -> 3
| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| testFirstOccurrenceOfK | Binary search | O(log n) | O(1) |
<br>

### 2. <a name="search-a-sorted-array-for-entry-equal-to-its-index"></a>Search a sorted array for entry equal to its index
**Task**: Search a sorted array for entry equal to its index  
**Example**: \[-2, 0, 2, 3, 6, 7, 9\] -> 2 | 3

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| searchASortedArrayForEntryEqualToItsIndex | Binary search | O(log n) | O(1) |
<br>

### 3. <a name="search-a-cyclically-sorted-array"></a>Search a cyclically sorted array
**Task**:  Search a cyclically sorted array  
**Example**: \[9, 3\] -> 1  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| searchACyclicallySortedArray | Binary search | O(log n) | O(1) |
<br>

### 4. <a name="compute-the-integer-square-root"></a>Compute the integer square root
**Task**: Compute the integer square root  
**Example**: 17 -> 4

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| squareRoot | Binary search | O(log n) | O(1) |
<br>

### 5. <a name="compute-the-real-square-root"></a>Compute the real square root
**Task**: Compute the real square root  
**Example**: 9.0 -> 3.0
   
| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| squareRoot | Binary search | O(log n/epsilon) | O(1) |
<br>

### 6. <a name="search-in-a-2d-sorted-array"></a>Search in a 2D sorted array
**Task**: Search in a 2D sorted array  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| searchInA2dSortedArray | One iteration | O(n + m) | O(1) |
<br>

### 7. <a name="find-the-min-and-max-simultaneously"></a>Find the min and max simultaneously
**Task**: Find the min and max simultaneously  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| findTheMinAndMaxSimultaneously | Pairs comparison | O(3/2 * n - 2) | O(1) |
<br>

### 8. <a name="find-the-kth-largest-element"></a>Find the kth largest element
**Task**: Find the kth largest element  
**Example**: \[3, 2, 1, 5, 4\], 1 -> 5

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| quickselect | Quickselect | O(n) | O(1) |
<br>

### 9. <a name="find-the-missing-ip-address"></a>Find the missing IP address
**Task**: Find the missing IP address  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| findTheMissingIPAddress | Countsort-like | O(n) | O(1) |
<br>

### 10. <a name="find-the-duplicate-and-missing-elements"></a>Find the duplicate and missing elements
**Task**: Find the duplicate and missing elements  
**Example**: \[0, 1, 1\] -> \[1, 2\] 

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| findTheDuplicateAndMissingElements | XOR | O(n) | O(1) |
<br>


[Go back to Searching TOC](#searching)  
[Go back](/README.md)
