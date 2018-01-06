## <a name="heaps"></a>7. Heaps
#### Various tasks on heaps

**Class**: [Heaps](/src/main/java/pro/amberovsky/elements/Heaps.java)  

1. [Produce top k string with biggest length](#produce-top-k-string-with-biggest-length)
2. [Merge sorted files](#merge-sorted-files)
3. [Sort a k-increasing-decreasing array](#sort-a-k-increasing-decreasing-array)
4. [Sort an almost sorted array](#sort-an-almost-sorted-array)
5. [Compute the k closest stars](#compute-the-k-closest-stars)
    * [Variant: output k-th largest integer from a sequence, starting from k-th element](#compute-the-k-closest-stars-output-k-th-largest-integer-from-a-sequence-starting-from-kth-element)
6. [Compute the median of online data](#compute-the-median-of-online-data)
7. [Compute the largest elements in a MaxHeap](#compute-the-largest-elements-in-a-maxheap)
8. [Implement a stack API using a heap](#implement-a-stack-api-using-a-heap)
    * [Variant: queue API](#implement-a-stack-api-using-a-heap-queue-api)
      
<br>

### 1. <a name="produce-top-k-string-with-biggest-length"></a>Produce top k string with biggest length
**Task**: Produce top k string with biggest length  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| kLongestStrings | Min-heap | O(n * log k) | O(k) |
<br>

### 2. <a name="merge-sorted-files"></a>Merge sorted files
**Task**: Merge sorted files  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| mergeSortedFiles | Min-heap | O(n * log k) | O(k) |
<br>

### 3. <a name="sort-a-k-increasing-decreasing-array"></a>Sort a k-increasing-decreasing array
**Task**:  Sort a k-increasing-decreasing array 

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sortAnIncreasingDecreasingArray | Min-heap | O(n * log k) | O(n) |
<br>

### 4. <a name="sort-an-almost-sorted-array"></a>Sort an almost sorted array
**Task**: Sort an almost sorted array  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sortAnAlmostSortedArray | Min-heap | O(n * log k) | O(n) |
<br>

### 5. <a name="compute-the-k-closest-stars"></a>Compute the k closest stars
**Task**: Compute the k closest stars  
**Example**: \[3, 100, 9, 500, 10, 18, 5\], 3 -> \[9, 5, 3\]
   
| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheKClosestStars | Max-heap | O(n * long k) | O(k) |

   * ### <a name="compute-the-k-closest-stars-output-k-th-largest-integer-from-a-sequence-starting-from-kth-element"></a>Variant: output k-th largest integer from a sequence, starting from k-th element
      **Task**: output k-th largest integer from a sequence, starting from k-th element  
      **Example**: \[100, 14, 18, 18, 500, 5\], 2 -> \[14, 18, 18, 100, 100\]
      
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | findARootToLeafPathWithSpecifiedSum_AllPaths | Recursion | O(n) | O(n) |
<br>

### 6. <a name="compute-the-median-of-online-data"></a>Compute the median of online data
**Task**: Compute the median of online data  
**Example**: \[1, 0, 3, 5, 2, 0, 1\] -> \[1.0, 0.5, 1.0, 2.0, 2.0, 1.5, 1.0\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheMedianOfOnlineData | Max-heap & Min-heap | O(n * log n) | O(n) |
<br>

### 7. <a name="compute-the-largest-elements-in-a-maxheap"></a>Compute the largest elements in a MaxHeap
**Task**: Compute the largest elements in a MaxHeap  
**Example**: \[500, 100, 400, 50, 10, 300\], 3 -> \[500, 400, 300\]

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheLargestElementsInAMaxHeap | Array indices | O(k * log k) | O(k) |
<br>

8. [Implement a stack API using a heap](#implement-a-stack-api-using-a-heap)
    * [Variant: queue API](#implement-a-stack-api-using-a-heap-queue-api)
### 8. <a name="implement-a-stack-api-using-a-heap"></a>Implement a stack API using a heap
**Task**: Implement a stack API using a heap
[StackViaHeap](/src/main/java/pro/amberovsky/elements/util/data/StackViaHeap.java) 

   * ### <a name="implement-a-stack-api-using-a-heap-queue-api"></a>Variant: queue API
      **Task**: Implement a queue API using a heap
      [QueueViaHeap](/src/main/java/pro/amberovsky/elements/util/data/QueueViaHeap.java)  
<br>

[Go back to Heaps TOC](#heaps)  
[Go back](/README.md)
