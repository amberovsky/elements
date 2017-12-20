## <a name="linked-lists"></a>3. Linked Lists
#### Various tasks on linked lists

**Class**: [LinkedLists](/src/main/java/pro/amberovsky/elements/LinkedLists.java)  

1. [Merge two sorted lists](#merge-two-sorted-lists)
   * [Variant: double](#merge-two-sorted-lists-double)
2. [Reverse a single sublist](#reverse-a-single-sublist)
   * [Variant: list](#reverse-a-single-sublist-list)
   * Variant: k nodes at a time
3. [Detect cycle in a single linked list](#detect-cycle-in-a-single-linked-list)
4. [Is there a common node in cycle free lists](#is-there-a-common-node-in-cycle-free-lists)
5. [Is there a common node in lists with cycles](#is-there-a-common-node-in-lists-with-cycles)
6. [Delete a node from a single linked list](#delete-a-node-from-a-single-linked-list)
7. [Remove the Kth last element from a list](#remove-the-kth-last-element-from-a-list)
8. [Remove duplicates from a sorted single linked list](#remove-duplicates-from-a-sorted-single-linked-list)
   * [Variant: M](#remove-duplicates-from-a-sorted-single-linked-list-m)
9. [Implement cyclic right shift for single linked list](#implement-cyclic-right-shift-for-single-linked-list)
10. [Implement even-odd merge](#implement-even-odd-merge)
11. [Test whether a single linked list is palindromic](#test-whether-a-single-linked-list-is-palindromic)
   * [Variant: double](#test-whether-a-single-linked-list-is-palindromic-double)
12. [Implement list pivoting](#implement-list-pivoting)
13. [Add list-based integers](#add-list-based-integers)
   * [Variant: most significant digit comes first](#add-list-based-integers-most-significant-digit-comes-first)
      
<br>

### 1. <a name="merge-two-sorted-lists"></a>Merge two sorted lists
**Task**: Merge two sorted lists  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| mergeTwoSortedLists | | O(n + m) | O(1) |

   * ### <a name="merge-two-sorted-lists-double"></a>Variant: double
      **Task**: Merge two double linked lists  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | mergeTwoSortedLists_Double | | O(n + m) | O(1) |
<br>

### 2. <a name="reverse-a-single-sublist"></a>Reverse a single sublist
**Task**: Reverse nodes in a single linked list from index1 to index2 inclusive  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reverseASingleSublist | One iteration | O(n) | O(1) |

   * ### <a name="reverse-a-single-sublist-list"></a>Variant: list
      **Task**: Reverse single linked list  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reverseASingleSublist_List | One iteration | O(n) | O(1) |
<br>

### 3. <a name="detect-cycle-in-a-single-linked-list"></a>Detect cycle in a single linked list
**Task**:  Detect cycle in a single linked list, return null if there is no cycle, first node of the cycle otherwise  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| detectCycleInASingleLinkedList | | O(n) | O(1) |
<br>

### 4. <a name="is-there-a-common-node-in-cycle-free-lists"></a>Is there a common node in cycle free lists
**Task**: Check if single linked lists have a node in common assuming they do not have cycles  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| isThereACommonNodeInCycleFreeLists | Calculate lengths | O(n) | O(1) |
<br>

### 5. <a name="is-there-a-common-node-in-lists-with-cycles"></a>Is there a common node in lists with cycles
**Task**: Check do single linked lists have a node in common, assuming they can have cycles    

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| isThereACommonNodeInListsWithCycles | | O(n + m) | O(1) |
<br>

### 6. <a name="delete-a-node-from-a-single-linked-list"></a>Delete a node from a single linked list
**Task**: Delete a node from a single linked list, assuming it is not the last node  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| deleteANodeFromASingleLinkedList | | O(1) | O(1) |
<br>

### 7. <a name="remove-the-kth-last-element-from-a-list"></a>Remove the Kth last node from a list
**Task**: Remove the Kth last element from a list, assuming the length is at least k. You can not calculate the length of the list  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| removeTheKthElementFromAList | | O(n) | O(1) |
<br>

### 8. <a name="remove-duplicates-from-a-sorted-single-linked-list"></a>Remove duplicates from a sorted single linked list
**Task**: Remove duplicates from a sorted single linked list  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| removeDuplicatesFormASortedList | One iteration | O(n) | O(1) |

   * ### <a name="remove-duplicates-from-a-sorted-single-linked-list-m"></a>Variant: M
      **Task**: Remove only if a numbers appears more than m times 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | removeDuplicatesFormASortedList_M | One iteration | O(n) | O(1) |
<br>

### 9. <a name="implement-cyclic-right-shift-for-single-linked-list"></a>Implement cyclic right shift for single linked list
**Task**: Cyclic right shift for single linked list  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| cycleRightShift | | O(n) | O(1) |
<br>

### 10. <a name="implement-even-odd-merge"></a>Implement even-odd merge
**Task**: Reorganise a single linked list in such a way that even nodes comes first, then odd nodes  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| evenOddMerge | | O(n) | O(1) |
<br>


### 11. <a name="test-whether-a-single-linked-list-is-palindromic"></a>Test whether a single linked list is palindromic
| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| testWhetherASingleLinkedListIsPalindromic | Reverse the second half of the list | O(n) | O(1) |

   * ### <a name="test-whether-a-single-linked-list-is-palindromic-double"></a>Variant: double
      **Task**: Same as above but with double linked list  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | testWhetherASingleLinkedListIsPalindromic_Double | | O(n) | O(1) |
<br>

### 12. <a name="implement-list-pivoting"></a>Implement list pivoting
**Task**: Perform a pivot of a single linked list with respect to given pivot element  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| listPivoting | Dutch flag problem | O(n) | O(1) |
<br>

### 13. <a name="add-list-based-integers"></a>Add list-based integers
**Task**: Add two non-negative integers in list format when the least significant digit comes first  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| addListBasedIntegers | | O(n + m) | O(max(n, m)) |

   * ### <a name="add-list-based-integers-most-significant-digit-comes-first"></a>Variant: most significant digit comes first  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | addListBasedIntegers_MostSignificantDigitComesFirst | | O(n + m) | O(max(n, m)) |
<br>

[Go back to Linked Lists TOC](#linked-lists)  
[Go back](/README.md)
