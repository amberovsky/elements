## <a name="binary-trees"></a>6. Binary Trees
#### Various tasks on binary trees

**Class**: [BinaryTrees](/src/main/java/pro/amberovsky/elements/BinaryTrees.java)  

1. [Test if a binary tree is height-balanced](#test-if-a-binary-tree-is-height-balanced)
    * Variant: find size of a largest complete subtree
    * Variant: k-balanced
2. [Check if binary tree is symmetric](#check-if-binary-tree-is-symmetric)
3. [Compute the lowest common ancestor](#compute-the-lowest-common-ancestor)
4. [Compute the LCA when nodes have parent pointers](#compute-the-lca-when-nodes-have-parent-pointers)
5. [Calculate sum the root to leaf paths in a binary tree](#calculate-sum-the-root-to-leaf-paths-in-a-binary-tree)
6. [Find a root to leaf path with specified sum](#find-a-root-to-leaf-path-with-specified-sum)
    * [Variant: return all such paths](#find-a-root-to-leaf-path-with-specified-sum-return-all-such-paths)
7. [Implement an inorder traversal without recursion](#implement-an-inorder-traversal-without-recursion)
8. [Implement a preorder traversal without recursion](#implement-a-preorder-traversal-without-recursion)
9. [Compute the kth node in an inorder traversal](#compute-the-kth-node-in-an-inorder-traversal)
10. [Compute the successor](#compute-the-successor)
11. [Implement an inorder traversal with constant space](#implement-an-inorder-traversal-with-constant-space)
    * [Variant: preorder](#implement-an-inorder-traversal-with-constant-space-preorder)
    * [Variant: postorder](#implement-an-inorder-traversal-with-constant-space-postorder)
12. [Reconstruct a binary tree from traversal data](#reconstruct-a-binary-tree-from-traversal-data)
    * [Variant: postorder](#reconstruct-a-binary-tree-from-traversal-data-postorder)
    * [Variant: maxtree](#reconstruct-a-binary-tree-from-traversal-data-maxtree)
13. [Reconstruct a binary tree from a preorder traversal with markers](#reconstruct-a-binary-tree-from-a-preorder-traversal-with-markers)
    * [Variant: postorder](#reconstruct-a-binary-tree-from-a-preorder-traversal-with-markers-postorder)
14. [Form a linked list from the leaves of a binary tree](#form-a-linked-list-from-the-leaves-of-a-binary-tree)
15. [Compute exterior of a binary tree](#compute-exterior-of-a-binary-tree)
16. [Compute the right sibling tree](#compute-the-right-sibling-tree)
    * Variant: use right
    * [Variant: general tree](#compute-the-right-sibling-tree=general-tree)
17. [Implement locking in a binary tree](#implement-locking-in-a-binary-tree)
      
<br>

### 1. <a name="test-if-a-binary-tree-is-height-balanced"></a>Test if a binary tree is height-balanced
**Task**: Test if a binary tree is height-balanced  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| testIfABinaryTreeIsHeightBalanced | Recursion | O(n) | O(h) |
<br>

### 2. <a name="check-if-binary-tree-is-symmetric"></a>Check if binary tree is symmetric
**Task**: Check if binary tree is symmetric  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| isSymmetric | Recursion | O(n) | O(h) |
<br>

### 3. <a name="compute-the-lowest-common-ancestor"></a>Compute the lowest common ancestor
**Task**:  Compute the lowest common ancestor  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheLowestCommonAncestor | Recursion | O(n) | O(h) |
<br>

### 4. <a name="compute-the-lca-when-nodes-have-parent-pointers"></a>Compute the LCA when nodes have parent pointers
**Task**: Compute the LCA when nodes have parent pointers  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| LCAWithParents | Alight the heights | O(n) | O(1) |
<br>

### 5. <a name="calculate-sum-the-root-to-leaf-paths-in-a-binary-tree"></a>Calculate sum the root to leaf paths in a binary tree
**Task**: Calculate sum the root to leaf paths in a binary tree    

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| sumTheRootToLeafPathsInBinaryTree | Recursion | O(n) | O(h) |
<br>

### 6. <a name="find-a-root-to-leaf-path-with-specified-sum"></a>Find a root to leaf path with specified sum
**Task**: Find a root to leaf path with specified sum  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| findARootToLeafPathWithSpecifiedSum | Recursion | O(n) | O(h) |

   * ### <a name="find-a-root-to-leaf-path-with-specified-sum-return-all-such-paths"></a>Variant: return all such paths
      **Task**: Return all such paths 

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | findARootToLeafPathWithSpecifiedSum_AllPaths | Recursion | O(n) | O(n) |

<br>

### 7. <a name="implement-an-inorder-traversal-without-recursion"></a>Implement an inorder traversal without recursion
**Task**: Implement an inorder traversal without recursion  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| inorderTraversalWithoutRecursion | Stack | O(n) | O(h) |
<br>

### 8. <a name="implement-a-preorder-traversal-without-recursion"></a>Implement a preorder traversal without recursion
**Task**: Implement a preorder traversal without recursion  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| preorderTraversalWithoutRecursion | Stack | O(n) | O(h) |
<br>

### 9. <a name="compute-the-kth-node-in-an-inorder-traversal"></a>Compute the kth node in an inorder traversal
**Task**: Compute the kth node in an inorder traversal  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheKthNodeInAnInorderTraversal | Iteration | O(h) | O(1) |
<br>

### 10. <a name="compute-the-successor"></a>Compute the successor
**Task**: Compute the successor  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheSuccessor | Iteration | O(h) | O(1) |
<br>

### 11. <a name="implement-an-inorder-traversal-with-constant-space"></a>Implement an inorder traversal with constant space
**Task**: Implement an inorder traversal with constant space  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| implementAnInorderTraversalWithConstantSpace | Remember previous | O(h) | O(1) |

   * ### <a name="implement-an-inorder-traversal-with-constant-space-preorder"></a>Variant: preorder
      **Task**: preorder traversal with constant space  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | implementAnInorderTraversalWithConstantSpace_Preorder | Remember previous | O(h) | O(1) |
      
   * ### <a name="implement-an-inorder-traversal-with-constant-space-postorder"></a>Variant: postorder
      **Task**: postorder traversal with constant space  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | implementAnInorderTraversalWithConstantSpace_Postorder | Remember previous | O(h) | O(1) |
<br>

### 12. <a name="reconstruct-a-binary-tree-from-traversal-data"></a>Reconstruct a binary tree from traversal data
**Task**: Reconstruct a binary tree from traversal data, all nodes are distinct  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reconstructABinaryTreeFromTraversalData | HashMap + traversals properties | O(n) | O(n) |

   * ### <a name="reconstruct-a-binary-tree-from-traversal-data-postorder"></a>Variant: postorder
      **Task**: preorder traversal with constant space  

      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reconstructABinaryTreeFromTraversalData_Postorder | HashMap + traversals properties | O(n) | O(n) |
      
   * ### <a name="reconstruct-a-binary-tree-from-traversal-data-maxtree"></a>Variant: build max-tree binary tree  
      **Task**: preorder traversal with constant space  
     
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reconstructABinaryTreeFromTraversalData_MaxTree | One iteration | O(n) | O(n) |
<br>

### 13. <a name="reconstruct-a-binary-tree-from-a-preorder-traversal-with-markers"></a>Reconstruct a binary tree from a preorder traversal with markers]
**Task**: Reconstruct a binary tree from a preorder traversal with null markers  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| reconstructABinaryTreeFromAPreorderTraversalWithMarkers | Recursion | O(n) | O(n) |

   * ### <a name="reconstruct-a-binary-tree-from-a-preorder-traversal-with-markers-postorder"></a>Variant: postorder  
      **Task**: Reconstruct a binary tree from a postorder traversal with null markers  
     
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | reconstructABinaryTreeFromAPreorderTraversalWithMarkers_Postorder | Recursion | O(n) | O(n) |
<br>

### 14. <a name="form-a-linked-list-from-the-leaves-of-a-binary-tree"></a>Form a linked list from the leaves of a binary tree
**Task**: Form a linked list from the leaves of a binary tree in the left-right order  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| formALinkedListFromTheLeavesOfABinaryTree | Depth-first search | O(n) | O(n) |
<br>

### 15. <a name="compute-exterior-of-a-binary-tree"></a>Compute exterior of a binary tree
**Task**: Compute exterior of a binary tree  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| exterior | Traverse | O(n) | O(n) |
<br>

### 16. <a name="compute-the-right-sibling-tree"></a>Compute the right sibling tree
**Task**: Compute the right sibling tree for a perfect binary tree  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| computeTheRightSiblingTree | Level-by-level, left-to-right | O(n) | O(1) |

   * ### <a name="compute-the-right-sibling-tree=general-tree"></a>Variant: general tree  
      **Task**: Same problem for a general tree  
     
      | Method | Algorithm | Time | Space |
      | :--- | :---: | :---: | :-- |
      | computeTheRightSiblingTree_GeneralTree | Breadth-first search | O(n) | O(n) |
<br>

### 17. <a name="implement-locking-in-a-binary-tree"></a>Implement locking in a binary tree
**Task**: Implement locking in a binary tree with parent links  

| Method | Algorithm | Time | Space |
| :--- | :---: | :---: | :-- |
| isLocked | | O(1) | O(1) |
| unlock | | O(h) | O(1) |
| lock | | O(h) | O(1) |
<br>

[Go back to Binary Trees TOC](#binary-trees)  
[Go back](/README.md)
