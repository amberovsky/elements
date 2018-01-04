## <a name="utilities"></a>1. Utilities
#### Auxiliary types 

**Package**: pro.amberovsky.elements.util  

1. [Functions](#functions)
    * [RandomSupplier](#functions-random-supplier)
    * [TriFunction](#functions-tri-function)
2. [Methods](#methods)
    * [Swap](#methods-swap)      
<br>

### 1. <a name="functions"></a>Functions
Auxiliary functions 

   * ### <a name="functions-random-supplier"></a>[RandomSupplier](/src/main/java/pro/amberovsky/elements/util/Function/RandomSupplier.java)
      A functional interface for random values supplier.  
      **Example**  

      ```java
        public static int void f(RandomSupplier<Integer> random) {
             random.get(100);
        }      
 
        f(new RandomSupplier<Integer>() {
            int[] data = new int[] { 4, 3, 3, 4 };
            int pointer = 0;
            
            @Override
            public Integer get(Integer bound) {
                 return data[pointer++];
            }
        });
      ```

   * ### <a name="functions-tri-function"></a>[TriFunction](/src/main/java/pro/amberovsky/elements/util/Function/TriFunction.java)
      Represents a function that accepts 3 arguments and produces a result.
<br>

### 2. <a name="methods"></a>[Methods](/src/main/java/pro/amberovsky/elements/util/Utilities.java)
Auxiliary methods

   * ### <a name="methods-swap"></a>Swap
      Swap elements in an array  
      **Prototypes**  

      ```java
        public static int[] swap(int[] array, final int from, final int to)
      ```

      ```java
        public static <T> T[]swap(T[] array, final int from, final int to)
      ``` 

      ```java
        public static <T> T[][] swap2D(T[][] array, final int r1, final int c1, final int r2, final int c2)
      ```  
<br>

[Go back to Utilities TOC](#utilities)  
[Go back](/README.md)
