## <a name="data-structures"></a>2. Data Structures
#### Auxiliary data structures

**Package**: pro.amberovsky.elements.data  

1. [Lists](#lists)
   * [Single linked list](#lists-single-linked-list)
   * [Double linked list](#lists-double-linked-list)
   * [Jump linked list](#lists-jump-linked-list)
2. [Stacks](#stacks)
   * [Stack with max API](#stacks-stack-with-max-api)
   * [Stack via heap API](#stacks-stack-via-heap-api)
3. [Queues](#queues)
   * [Circular queue](#queues-circular-queue)
   * [Stack queue](#queues-stack-queue)
   * [Queue via heap API](#queues-queue-via-heap-api)
   * [Queue with max API](#queues-queue-with-max-api)
4. [Trees](#trees)
   * [Binary tree](#trees-binary-tree)
   * [Binary tree with parent pointers](#trees-binary-tree-with-parent-pointers)
   * [Binary tree with amount of child nodes](#trees-binary-tree-with-amount-of-child-nodes)
   
<br>

### 1. <a name="lists"></a>Lists
   * ### <a name="lists-single-linked-list"></a>[ListNode](/src/main/java/pro/amberovsky/elements/util/data/ListNode.java)
      Single linked list  

   * ### <a name="lists-double-linked-list"></a>[DoubleListNode](/src/main/java/pro/amberovsky/elements/util/data/DoubleListNode.java)
      Double linked list

   * ### <a name="lists-jump-linked-list"></a>[JumpListNode](/src/main/java/pro/amberovsky/elements/util/data/JumpListNode.java)
      Jump linked list where each node has a "jump" pointer to any node of list
<br>

### 2. <a name="stacks"></a>Stacks
   * ### <a name="stacks-stack-with-max-api"></a>[StackWithMax](/src/main/java/pro/amberovsky/elements/util/data/StackWithMax.java)
      Stack which tracks current maximum element
      
   * ### <a name="stacks-stack-via-heap-api"></a>[StackViaHeap](/src/main/java/pro/amberovsky/elements/util/data/StackViaHeap.java)
      Stack implementation using heap API            
<br>

### 3. <a name="queues"></a>Queues
   * ### <a name="queues-circular-queue"></a>[CircularQueue](/src/main/java/pro/amberovsky/elements/util/data/CircularQueue.java)
      Circular queue over array with resizing   

   * ### <a name="queues-stack-queue"></a>[StackQueue](/src/main/java/pro/amberovsky/elements/util/data/StackQueue.java)
      Queue implementation using stacks   

   * ### <a name="queues-queue-via-heap-api"></a>[QueueViaHeap](/src/main/java/pro/amberovsky/elements/util/data/QueueViaHeap.java)
      Queue implementation using heap API   

   * ### <a name="queues-queue-with-max-api"></a>[QueueWithMax](/src/main/java/pro/amberovsky/elements/util/data/QueueWithMax.java)
      Queue which tracks current maximum element in O(1)   
<br>
   
### 4. <a name="trees"></a>Trees
   * ### <a name="trees-binary-tree"></a>[BinaryTreeNode](/src/main/java/pro/amberovsky/elements/util/data/BinaryTreeNode.java)
      Simple binary tree implementation   

   * ### <a name="trees-binary-tree-with-parent-pointers"></a>[BinaryTreeWithParentNode](/src/main/java/pro/amberovsky/elements/util/data/BinaryTreeWithParentNode.java)
      Binary tree with pointers to parent nodes and locking

   * ### <a name="trees-binary-tree-with-amount-of-child-nodes"></a>[BinaryTreeWithCounts](/src/main/java/pro/amberovsky/elements/util/data/BinaryTreeWithCounts.java)
      Binary tree where each node knows amount of children   
<br>

[Go back to Data Structures TOC](#data-structures)  
[Go back](/README.md)
