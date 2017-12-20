## <a name="stacks-and-queues"></a>4. Stacks and Queues
#### Various tasks on stacks and queues

**Class**: [StacksAndQueues](/src/main/java/pro/amberovsky/elements/StacksAndQueues.java)  
**Factory**: [StacksAndQueuesFactory](/src/main/java/pro/amberovsky/elements/StacksAndQueuesFactory.java)  

1. [Implement a stack with max API](#implement-a-stack-with-max-api)
2. [Evaluate RPN expression](#evaluate-rpn-expression)
   * [Variant: Polish notation](#evaluate-rpn-expression-polish-notation)
3. [Test a string over for well-formedness](#test-a-string-over-for-well-formedness)
4. [Normalize pathnames](#normalize-pathnames)
5. [Search a postings list](#search-a-postings-list)
6. [Compute buildings with a sunset view](#compute-buildings-with-a-sunset-view)
   * [Variant: west to east](#compute-buildings-with-a-sunset-view-west-to-east)
7. [Compute binary tree nodes in order of increasing depth](#compute-binary-tree-nodes-in-order-of-increasing-depth)
   * [Variant: alternate direction on each level](#compute-binary-tree-nodes-in-order-of-increasing-depth-alternate-direction-on-each-level)
   * [Variant: bottom-up left-right direction](#compute-binary-tree-nodes-in-order-of-increasing-depth-bottom-up-left-right-direction)
   * [Variant: average at each level](#compute-binary-tree-nodes-in-order-of-increasing-depth-average-at-each-level)
8. [Implement a circular queue](#implement-a-ciruclar-queue)
9. [Implement a queue using stacks](#implement-a-queue-using-stacks)
10. [Implement a queue with max API](#implement-a-queue-with-max-api)
      
<br>

### 1. <a name="implement-a-stack-with-max-api"></a>Implement a stack with max API
**Task**: Implement a a stack with max API  
[StackWithMax](/src/main/java/pro/amberovsky/elements/util/data/StackWithMax.java)  
<br>

### 2. <a name="evaluate-rpn-expression"></a>Evaluate RPN expression
**Task**: Evaluate RPN expression  
**Example**: "1,2,3,4,5,*,*,*,-" -> -119

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| evaluateRPNExpression | Stack | O(n) | O(n) |
<br>

   * ### <a name="evaluate-rpn-expression-polish-notation"></a>Variant: Polish notation
      **Task**: Evaluate expression in the Polish notation  
      **Example**: "-,*,*,*,5,4,3,2,1" -> -119

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | evaluateRPNExpression_Polish | Stack | O(n) | O(n) |
<br>

### 3. <a name="test-a-string-over-for-well-formedness"></a>Test a string over for well-formedness
**Task**:  Check for parentheses (),{},[] parity  
**Example**: "({}[()]){}" -> true

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| checkParenthesesParity | Stack | O(n) | O(n) |
<br>

### 4. <a name="normalize-pathnames"></a>Normalize pathnames
**Task**: Normalize relative and absolute pathes  
**Example**: "/usr/lib/../bin/gcc" -> "/usr/bin/gcc"

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| normalizePathname | Deque | O(n) | O(n) |
<br>

### 5. <a name="search-a-postings-list"></a>Search a postings list
**Task**: Compute jump-first order over a single linked list   

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| jumpFirstOrderByIteration | Iterative | O(n) | O(n) |
| jumpFirstOrderByRecursion | Recursion | O(n) | O(1) |
<br>

### 6. <a name="compute-buildings-with-a-sunset-view"></a>Compute buildings with a sunset view
**Task**: Compute buildings with a sunset view  
**Example**: [10, 1] -> [10]
 
| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeBuildingsWithASunsetView | Stack | O(n) | O(n) |
<br>

   * ### <a name="compute-buildings-with-a-sunset-view-west-to-east"></a>Variant: west to east
      **Task**: Compute in the west to east direction  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeBuildingsWithASunsetView_WestToEast | Running maximum | O(n) | O(n) |
<br>

### 7. <a name="compute-binary-tree-nodes-in-order-of-increasing-depth"></a>Compute binary tree nodes in order of increasing depth
**Task**: Compute binary tree nodes in order of increasing depth  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeBinaryTreeNodesInOrderOfIncreasingDepth | Breadth-first search | O(n) | O(n) |
<br>

   * ### <a name="compute-binary-tree-nodes-in-order-of-increasing-depth-alternate-direction-on-each-level"></a>Variant: alternate direction on each level
      **Task**: Remove only if a numbers appears more than m times 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeBinaryTreeNodesInOrderOfIncreasingDepth_AlternatingDirection | Breadth-first search | O(n) | O(n) |
<br>

   * ### <a name="compute-binary-tree-nodes-in-order-of-increasing-depth-bottom-up-left-right-direction"></a>Variant: bottom-up left-right direction
      **Task**: Remove only if a numbers appears more than m times 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeBinaryTreeNodesInOrderOfIncreasingDepth_BottomUpLeftRight | Breadth-first searchn | O(n) | O(n) |
<br>

   * ### <a name="compute-binary-tree-nodes-in-order-of-increasing-depth-average-at-each-level"></a>Variant: average at each level
      **Task**: Remove only if a numbers appears more than m times 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeBinaryTreeNodesInOrderOfIncreasingDepth_Average | Breadth-first search | O(n) | O(n) |
<br>

### 8. <a name="implement-a-ciruclar-queue"></a>Implement a circular queue
**Task**: Implement a queue over array with dynamical resizing  
[CircularQueue](/src/main/java/pro/amberovsky/elements/util/data/CircularQueue.java)
<br>

### 9. <a name="implement-a-queue-using-stacks"></a>Implement a queue using stacks
**Task**: Implement a queue using already implemented stacks  
[StackQueue](/src/main/java/pro/amberovsky/elements/util/data/StackQueue.java)
<br>

### 10. <a name="implement-a-queue-with-max-api"></a>Implement a queue with max API
**Task**: Implement a queue with max API  
[StackQueue](/src/main/java/pro/amberovsky/elements/util/data/QueueWithMax.java)  
<br>

[Go back to Stacks and Queues TOC](#stacks-and-queues)  
[Go back](/README.md)
