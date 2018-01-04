## <a name="honors-class"></a>17. Honors Class
#### Difficult problems. In bolds are super-difficult problems

**Class**: [HonorsClass](/src/main/java/pro/amberovsky/elements/HonorsClass.java)  

1.
2. [Find the first missing positive entry](#find-the-first-missing-positive-entry)
3.
4. [Compute the maximum product of all entries but one](#compute-the-maximum-product-of-all-entries-but-one)
    * [Variant: compute an array where ith element is a product of all elements except ith](#compute-the-maximum-product-of-all-entries-but-one-compute-an-array-where-ith-element-is-a-product-of-all-elements-except-ith)
    * Variant: compute the maximum over the products of all triples of distinct elements
5.
6. [Rotate an array](#rotate-an-array)
7. [Identify positions attacked by rocks](#identify-positions-attacked-by-rocks)
8. [Justify text](#justify-text)
         
<br>

### 1.
<br>

### 2. <a name="find-the-first-missing-positive-entry"></a>Find the first missing positive entry
**Task**: Find the first smallest missing positive entry  
**Example**: \[3, 5, 3, -10\] -> 1  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| findTheFirstMissingPositiveEntry | One iteration | O(n) | O(1) |
<br>

### 3.
<br>

### 4. <a name="compute-the-maximum-product-of-all-entries-but-one"></a>Compute the maximum product of all entries but one
**Task**: Compute the maximum product of all entries but one  
**Example**: \[1, 2\] -> 2  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| maximumProductOfAllEntriesButOneBySuffixArray | Suffix array | O(n) | O(n) |
| maximumProductOfAllEntriesButOneByCountingZeroAndNegatives | Count zero and negative entries | O(n) | O(1) |

   * ### <a name="compute-the-maximum-product-of-all-entries-but-one-compute-an-array-where-ith-element-is-a-product-of-all-elements-except-ith"></a>Variant: compute an array where ith element is a product of all elements except ith
      **Task**: compute an array where ith element is a product of all elements except ith  
      **Example**: \[1, 2\] -> \[2, 1\] 
      
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | maximumProductOfAllEntriesButOne_ExceptI | Two iterations | O(n) | O(1) |
<br>

### 5.
<br>

### 6. <a name="rotate-an-array"></a>Rotate an array
**Task**: Rotate an array to the right  
**Example**: \[1, 2, 3, 4, 5\], 3 -> \[3, 4, 5, 1, 2\]  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| rotateAnArray | Reverse | O(n) | O(1) |
<br>

### 7. <a name="identify-positions-attacked-by-rocks"></a>Identify positions attacked by rocks
**Task**: Identify positions attacked by rocks  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| identifyPositionsAttackedByRooks | Use first row and column | O(nm) | O(1) |
<br>

### 7. <a name="justify-text"></a>Justify text
**Task**: Justify text  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| justifyText | Look ahead | O(n) | O(n) |
<br>


[Go back to Honors Class TOC](#honors-class)  
[Go back](/README.md)
