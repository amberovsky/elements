package pro.amberovsky.elements;

import pro.amberovsky.elements.util.Utilities;
import pro.amberovsky.elements.util.data.BinaryTreeNode;
import pro.amberovsky.elements.util.data.JumpListNode;
import pro.amberovsky.elements.util.data.ListNode;

import java.util.*;

/**
 * Difficult problems
 */
class HonorsClass {
    /*
    FIND THE FIRST MISSING POSITIVE ENTRY
     */

    /**
     * Find the first missing positive entry
     *
     * @Algorithm One iteration
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return first missing positive entry
     */
    static int findTheFirstMissingPositiveEntry(int array[]) {
        for (int i = 0; i < array.length; i++) {
            while ((array[i] > 0) && (array[i] != i + 1)) {
                int elem = array[i];
                if (array[elem - 1] == elem) break;

                Utilities.swap(array, i, elem - 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) return i + 1;
        }

        return 0;
    }



    /*
    COMPUTE THE MAXIMUM PRODUCT OF ALL ENTRIES BUT ONE
     */

    /**
     * Compute maximum product of all entries but one
     *
     * @Algorithm Suffix array
     * @Complexity O(n), O(n) space
     *
     * @param array array
     *
     * @return maximum product of all entries but one
     */
    static Integer maximumProductOfAllEntriesButOneBySuffixArray(Integer array[]) {
        int suffix[] = new int[array.length];
        suffix[array.length - 1] = 1;

        for (int i = array.length - 1; i > 0; i--) {
            suffix[i - 1] = suffix[i] * array[i];
        }

        int prefixProduct = 1;
        int maximumProduct = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int currentProduct = prefixProduct * suffix[i];
            if (maximumProduct < currentProduct) maximumProduct = currentProduct;

            prefixProduct *= array[i];
        }

        return maximumProduct;
    }

    /**
     * Compute maximum product of all entries but one
     *
     * @Algorithm Count zero and negative entries
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return maximum product of all entries but one
     */
    static Integer maximumProductOfAllEntriesButOneByCountingZeroAndNegatives(Integer array[]) {
        int zeroes = 0;
        int negatives = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) negatives++;
            else if (array[i] == 0) zeroes++;
        }

        if (zeroes > 1) return 0;

        int indexToExclude = -1;

        if ((negatives % 2 == 1)) {
            // find the greatest negative and discard it
            for (int i = 0; i < array.length; i++) {
                if ((array[i] < 0) && ((indexToExclude == -1) || (array[i] > array[indexToExclude]))) indexToExclude = i;
            }
        } else {
            // find the minimum non-negative and discard it

            if (array.length - negatives > 0) {
                for (int i = 0; i < array.length; i++) {
                    if ((array[i] >= 0) && ((indexToExclude == -1) || (array[i] < array[indexToExclude]))) indexToExclude = i;
                }
            } else { // all negatives
                // find the lowest negative and discard

                for (int i = 0; i < array.length; i++) {
                    if ((array[i] < 0) && ((indexToExclude == -1) || (array[i] < array[indexToExclude]))) indexToExclude = i;
                }
            }
        }

        int product = 1;
        for (int i = 0; i < array.length; i++) {
            if (i != indexToExclude) product *= array[i];
        }

        return product;
    }

    /**
     * Variant: compute an array where ith element is a product of all elements except ith
     *
     * @Algorithm Two iterations
     * @Complexity O(n), O(1) space
     *
     * @param array array
     *
     * @return computed array
     */
    static Integer[] maximumProductOfAllEntriesButOne_ExceptI(Integer array[]) {
        Integer result[] = new Integer[array.length];
        result[0] = 1;

        for (int i = 1; i < array.length; i++) {
            result[i] = array[i - 1] * result[i - 1];
        }

        Integer suffix = 1;

        for (int i = array.length - 2; i >= 0; i--) {
            suffix *= array[i + 1];
            result[i] *= suffix;
        }

        return result;
    }



    /*
    ROTATE AN ARRAY
     */

    /**
     * Rotate array to the right
     *
     * @Algorithm Reverse
     * @Complexity O(n), O(1) space
     *
     * @param array array
     * @param shift how many positions to rotate
     * @param <T> type
     *
     * @return rotated array
     */
    static <T> T[] rotateAnArray(T array[], int shift) {
        shift %= array.length;

        for (int i = 0; i < array.length / 2; i++) Utilities.swap(array, i, array.length - i - 1);

        for (int i = 0; i < shift / 2; i++) Utilities.swap(array, i, shift - i - 1);
        for (int i = shift; i < shift + (array.length - shift) / 2; i++) Utilities.swap(array, i, array.length - i + shift - 1);

        return array;
    }



    /*
    IDENTIFY POSITIONS ATTACKED BY ROOKS
     */

    /**
     * Identify positions attacked by rocks
     *
     * @Algorithm Use first row and column
     * @Complexity O(nm), O(1) space
     *
     * @param board board with zeroes where rocks are
     *
     * @return updated board
     */
    static int[][] identifyPositionsAttackedByRooks(int board[][]) {
        int columns = board[0].length;
        int rows = board.length;



        boolean row0ToBeCleared = false;
        boolean column0ToBeCleared = false;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 0) {
                    if (row == 0) row0ToBeCleared = true;
                    board[0][column] = 0;

                    if (column == 0) column0ToBeCleared = true;
                    board[row][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (board[i][0] == 0) {
                for (int k = 0; k < columns; k++) board[i][k] = 0;
            }
        }

        for (int i = 1; i < columns; i++) {
            if (board[0][i] == 0) {
                for (int k = 0; k < rows; k++) board[k][i] = 0;
            }
        }

        if (row0ToBeCleared) {
            for (int i = 0; i < columns; i++) board[0][i] = 0;
        }

        if (column0ToBeCleared) {
            for (int i = 0; i < rows; i++) board[i][0] = 0;
        }

        return board;
    }



    /*
    JUSTIFY TEXT
     */

    /**
     * Create string with spaces
     *
     * @param words array of words
     * @param startIndex first word
     * @param endIndex second word
     * @param amountOfSpaces how many spaces to distribute
     *
     * @return new string
     */
    private static String formNewLineWithSpaces(String words[], int startIndex, int endIndex, int amountOfSpaces) {
        int numWordsCurrLine = endIndex - startIndex + 1;
        StringBuilder line = new StringBuilder();

        for (int i = startIndex; i < endIndex; ++i) {
            line.append(words[i]);
            --numWordsCurrLine ;
            int numCurrSpace = (int) Math.ceil((double)amountOfSpaces / numWordsCurrLine);

            for (int j = 0; j < numCurrSpace; j++) {
                line.append(" ");
            }

            amountOfSpaces -= numCurrSpace;
        }

        line.append(words[endIndex]);
        for (int i = 0; i < amountOfSpaces; i++) line.append(" ");

        return line.toString();
    }

    /**
     * Justify text
     *
     * @Algorithm Lookahead
     * @Complexity O(n), O(n) space
     *
     * @param words array of words
     * @param maxLength maximum length of each line
     *
     * @return justified lines
     */
    static List<String> justifyText(String words[], int maxLength) {
        int currLineStart = 0;
        int numWordsCurrLine = 0;
        int currLineLength = 0;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; ++i) {
            ++numWordsCurrLine;
            int lookaheadLineLength = currLineLength + words[i].length() + (numWordsCurrLine - 1);

            if (lookaheadLineLength == maxLength) {
                result.add(formNewLineWithSpaces(words, currLineStart, i, i - currLineStart));

                currLineStart = i + 1;
                numWordsCurrLine = 0;
                currLineLength = 0;
            } else if (lookaheadLineLength > maxLength) {
                result.add(formNewLineWithSpaces(words, currLineStart, i - 1, maxLength - currLineLength));

                currLineStart = i;
                numWordsCurrLine = 1;
                currLineLength = words[i].length();
            } else {
                currLineLength += words[i].length();
            }
        }

        if (numWordsCurrLine > 0) {
            StringBuilder line = new StringBuilder(formNewLineWithSpaces(words, currLineStart, words.length - 1, numWordsCurrLine - 1));
            for (int i = 0; i < maxLength - currLineLength - (numWordsCurrLine - 1); i++) {
                line.append(" ");
            }

            result.add(line.toString());
        }

        return result;
    }



    /*
    IMPLEMENT LIST ZIPPING
     */

    /**
     * Implement list zipping
     *
     * @Algorithm Reverse list
     * @Complexity O(n), O(1) space
     *
     * @param list linked list
     * @param <T> type
     *
     * @return zipped list
     */
    static <T> ListNode<T> listZipping(ListNode<T> list) {
        int size = 1;

        ListNode<T> current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }

        if (size < 2) return list;

        current = list;
        for (int i = 0; i < (size - 1) / 2; i++) current = current.next;

        ListNode<T> secondHalf = current.next;
        current.next = null;

        // reverse the second half
        current = secondHalf;
        while (current.next != null) {
            ListNode<T> tmp = current.next;
            current.next = tmp.next;
            tmp.next = secondHalf;
            secondHalf = tmp;
        }

        // merge
        ListNode<T> firstHalf = list;
        for (int i = 0; i < size / 2; i++) {
            ListNode<T> firstHalfNext = firstHalf.next;
            firstHalf.next = secondHalf;
            ListNode<T> secondHalfNext = secondHalf.next;
            secondHalf.next = firstHalfNext;

            firstHalf = firstHalfNext;
            secondHalf = secondHalfNext;
        }


        return list;
    }



    /*
    COPY A POSTINGS LIST
     */

    /**
     * Copy a posting list (with jump nodes)
     *
     * @Algorithm In-place
     * @Complexity O(n), O(1) space
     *
     * @param list posting list
     * @param <T> type
     *
     * @return copy
     */
    static <T> JumpListNode<T> copyAPostingList(JumpListNode<T> list) {
        JumpListNode<T> pointer = list;

        // Copy/change next links
        while (pointer != null) {
            JumpListNode<T>  pointerCopy = new JumpListNode<>(pointer.data);
            pointerCopy.next = pointer.next;

            pointer.next = pointerCopy;
            pointer = pointerCopy.next;
        }


        // Set jump nodes
        pointer = list;
        while (pointer != null) {
            if (pointer.jump != null) pointer.next.jump = pointer.jump.next;
            pointer = pointer.next.next;
        }

        // Restore values
        JumpListNode<T> copy = list.next;
        pointer = list;
        while (pointer != null) {
            JumpListNode<T> copyNode = pointer.next;
            pointer.next = copyNode.next;

            if (copyNode.next != null) copyNode.next = copyNode.next.next;

            pointer = pointer.next;
        }

        return copy;
    }



    /*
    COMPUTE THE LONGEST SUBSTRING WITH MATCHING PARENS
     */

    /**
     * Compute the longest substring with matching parens
     *
     * @Algorithm Stack
     * @Complexity O(n), O(n) space
     *
     * @param string string with parens
     *
     * @return length of the longest substring
     */
    static int computeTheLongestSubstringWithMatchingParens(String string) {
        Deque<Integer> stack = new ArrayDeque<>();

        int length = 0;
        int endIndex = -1;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) {
                    endIndex = i;
                } else {
                    stack.pop();

                    int start = stack.isEmpty() ? endIndex : stack.peek();
                    length = Math.max(length, i - start);
                }
            }
        }

        return length;
    }



    /*
    COMPUTE THE MAXIMUM OF A SLIDING WINDOW
     */

    /**
     * Helper class
     */
    static class TrafficElement {
        /** timestamp when traffic arrived */
        int timestamp;

        /** amount of arrived traffic */
        int volume;

        /**
         * Constr
         *
         * @param timestamp timestamp when traffic arrived
         * @param volume amount of arrived traffic
         */
        public TrafficElement(int timestamp, int volume) {
            this.timestamp = timestamp;
            this.volume = volume;
        }

        @Override
        public boolean equals(Object o) {
            if ((o == null) || !(o instanceof TrafficElement)) return false;

            TrafficElement element = (TrafficElement) o;

            return ((this.timestamp == element.timestamp) && (this.volume == element.volume));
        }
    }


    /**
     * Add elements to the max queue
     *
     * @param max queue with max elements
     * @param elem element to add
     */
    private static void addToTheMax(Deque<TrafficElement> max, TrafficElement elem) {
        while (!max.isEmpty() && (max.getLast().volume < elem.volume)) max.removeLast();

        max.addLast(elem);
    }

    /**
     * Compute the maximum of a sliding window
     *
     * @Algorithm Queue with MAX
     * @Complexity O(n), O(w) space
     *
     *
     * @param traffic traffic data
     * @param w size of the sliding window
     *
     * @return maximum of a sliding window
     */
    static List<TrafficElement> computeTheMaximumOfASlidingWindow(TrafficElement traffic[], int w) {
        List<TrafficElement> result = new ArrayList<>();

        Deque<TrafficElement> queue = new ArrayDeque<>();
        ArrayDeque<TrafficElement> max = new ArrayDeque<>();

        for (int i = 0; i < traffic.length; i++) {
            queue.addLast(traffic[i]);
            addToTheMax(max, traffic[i]);

            while (traffic[i].timestamp - queue.peek().timestamp > w) {
                TrafficElement element = queue.removeFirst();
                if (element == max.peek()) max.removeFirst();

            }

            result.add(new TrafficElement(traffic[i].timestamp, max.peek().volume));

        }

        return result;
    }



    /*
    IMPLEMENT A POSTORDER TRAVERSAL WITHOUT RECURSION
     */

    /**
     * Implement a postorder traversal without recursion
     *
     * @Algorithm Stack
     * @Complexity O(n), O(h) space
     *
     * @param tree binary tree
     * @param <T> type
     *
     * @return postorder traversal
     */
    static <T> List<T> implementAPostorderTraversalWithoutRecursion(BinaryTreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        BinaryTreeNode<T> previous = tree;

        stack.push(tree);

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.peek();

            if ((node.left == null) && (node.right == null)) { // leaf
                result.add(stack.pop().data);
            } else {
                if ((node.right != null) && (previous == node.right)) { // returning from right child
                    result.add(stack.pop().data);
                } else if ((node.right == null) && (previous == node.left)) { // returning from left when right is null
                    result.add(stack.pop().data);
                } else {
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                }
            }

            previous = node;
        }

        return result;
    }
}
