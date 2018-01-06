package pro.amberovsky.elements;

import pro.amberovsky.elements.util.data.BinaryTreeNode;
import pro.amberovsky.elements.util.data.JumpListNode;

import java.util.*;

/**
 * Various tasks on stacks and queues
 */
class StacksAndQueues {
    /*
    STACKS
     */



    /*
    EVALUATE RPN EXPRESSIONS
     */

    /**
     * Evaluate RPN expression
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Stack
     *
     * @param text RPN expression
     *
     * @return result
     */
    static int evaluateRPNExpression(String text) {
        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder token = null;
        for (int i = 0; i <= text.length(); i++) {
            char c = (i < text.length()) ? text.charAt(i) : ',';

            if (c == ',') {
                try {
                    stack.push(Integer.parseInt(token.toString()));
                } catch (NumberFormatException NumberFormatException) {
                    switch (token.charAt(0)) {
                        case ',':
                            break;

                        case '+':
                            stack.push(stack.pop() + stack.pop());
                            break;

                        case '-':
                            stack.push(-stack.pop() + stack.pop());
                            break;


                        case '*':
                            stack.push(stack.pop() * stack.pop());
                            break;

                        case '/':
                            Integer op2 = stack.pop();
                            Integer op1 = stack.pop();

                            stack.push(op1 / op2);
                            break;
                    }
                }

                token = null;
            } else {
                if (token == null) token = new StringBuilder();
                token.append(c);

            }
        }

        return stack.pop();
    }

    /**
     * Variant: Polish notation
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Stack
     *
     * @param text expression in Polish notation
     *
     * @return result
     */
    static int evaluateRPNExpression_Polish(String text) {
        String[] tokens = text.split(",");

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            try {
                stack.push(Integer.parseInt(tokens[i]));
            } catch (NumberFormatException NumberFormatException) {
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();

                switch (tokens[i].charAt(0)) {
                    case '+':
                        stack.push(op1 + op2);
                        break;

                    case '-':
                        stack.push(op1 - op2);
                        break;

                    case '*':
                        stack.push(op1 * op2);
                        break;

                    case '/':
                        stack.push(op1 / op2);
                        break;
                }
            }
        }

        return stack.pop();
    }



    /*
    TEST A STRING OVER FOR WELL-FORMEDNESS
     */

    /**
     * Check for parentheses (),{},[] parity
     *
     * @Complexity  O(n), O(n) space
     * @Algorithm Stack
     *
     * @param string text
     *
     * @return true if string is well-formed, false otherwise
     */
    static boolean checkParenthesesParity(String string) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < string.length(); i++) {
            char curr = string.charAt(i);

            switch (curr) {
                case '}':
                case ']':
                case ')':
                    if (stack.isEmpty()) return false;
                    char prev = stack.pop();

                    if (
                            ((curr ==']') && (prev != '[')) ||
                            ((curr == '}') && (prev != '{')) ||
                            ((curr == ')') && (prev != '('))
                    ) {
                        return false;
                    }

                    break;

                default:
                    stack.push(curr);
            }
        }

        return stack.isEmpty();
    }



    /*
    NORMALIZE PATHNAMES
     */

    /**
     * Normalize relative and absolute pathes
     *
     * @Complexity O(n), O(n)
     * @Algorithm Deque
     *
     * @param pathname path to normalize
     *
     * @return normalized path
     */
    static String normalizePathname(String pathname) {
        if (pathname.isEmpty()) return pathname;

        boolean isAbsolute = pathname.startsWith("/");

        StringBuilder result = new StringBuilder("");
        Deque<String> deque = new ArrayDeque<>();

        String tokens[] = pathname.split("/");

        for (String token : tokens) {
            if (token.isEmpty()) { // "/"
                // do nothing
            } else if (token.equals(".")) { // "./"
                // do nothing
            } else if (token.equals("..")) { // "../"
                if (deque.isEmpty()) {
                    if (!isAbsolute) result.append(token).append("/");
                }
                else deque.pop();
            } else deque.push(token);
        }

        while (!deque.isEmpty()) {
            result.append(deque.removeLast());

            if (!deque.isEmpty()) result.append("/");
        }

        return (isAbsolute ? "/" : "") + result;
    }



    /*
    SEARCH A POSTINGS LIST
     */

    /**
     * Helper for the recursive algorithm
     *
     * @param node current node
     * @param order current order
     * @param <T> type
     *
     * @return latest order
     */
    private static <T> int jumpFirstOrderByRecursionHelper(JumpListNode<T> node, int order) {
        if ((node != null) && (node.order == -1)) {
            node.order = order++;

            order = jumpFirstOrderByRecursionHelper(node.jump, order);
            order = jumpFirstOrderByRecursionHelper(node.next, order);
        }

        return order;
    }

    /**
     * Compute jump-first order over a single linked list
     *
     * @Complexity O(n), O(1) space
     * @Algorithm Recursion
     *
     * @param list single linked list with jump nodes
     * @param <T> type
     *
     * @return list with updated order
     */
    static <T> JumpListNode<T> jumpFirstOrderByRecursion(JumpListNode<T> list) {
        jumpFirstOrderByRecursionHelper(list, 1);
        return list;
    }

    /**
     * Compute jump-first order over a single linked list
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Iteration
     *
     * @param list single linked list with jump nodes
     * @param <T> type
     *
     * @return list with updated order
     */
    static <T> JumpListNode<T> jumpFirstOrderByIteration(JumpListNode<T> list) {
        Deque<JumpListNode<T>> stack = new ArrayDeque<>();
        int order = 1;

        stack.push(list);

        while (!stack.isEmpty()) {
            JumpListNode<T> node = stack.pop();

            if (node.order == -1) {
                node.order = order++;

                if (node.next != null) stack.push(node.next);
                if (node.jump != null) stack.push(node.jump);
            }
        }

        return list;
    }



    /*
    COMPUTE BUILDINGS WITH A SUNSET VIEW
     */

    /**
     * Compute buildings with a sunset view, east-to-west direction
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Stack
     *
     * @param buildings heights of buildings
     *
     * @return list of buildings with a sunset view
     */
    static int[] computeBuildingsWithASunsetView(int[] buildings) {
        if (buildings.length < 1) return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(buildings[buildings.length - 1]);

        for (int i = buildings.length - 2; i >= 0; i--) {
            while ((!stack.isEmpty()) && (stack.peek() < buildings[i])) stack.pop();

            stack.push(buildings[i]);
        }

        int result[] = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }


    /**
     * Variant: west to east
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Running maximum
     *
     * @param buildings heights of buildings
     *
     * @return list of buildings with a sunset view
     */
    static Integer[] computeBuildingsWithASunsetView_WestToEast(int[] buildings) {
        List<Integer> list = new ArrayList<>();

        int maximum = -1;

        for (int i = 0; i < buildings.length; i++) {
            if (buildings[i] >= maximum) {
                list.add(buildings[i]);
                maximum = buildings[i];
            }
        }

        return list.toArray(new Integer[0]);
    }



    /*
    QUEUES
     */



    /*
    COMPUTE BINARY TREE NODES IN ORDER OF INCREASING DEPTH
     */

    /**
     * @Complexity O(n), O(n) space
     * @Algorithm Breadth-first search
     *
     * @param tree binary tree
     *
     * @return array of nodes values
     */
    static Integer[] computeBinaryTreeNodesInOrderOfIncreasingDepth(BinaryTreeNode<Integer> tree) {
        Queue<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        queue.add(tree);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.remove();

            result.add(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Variant: alternate direction on each level
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Breadth-first search
     *
     * @param tree binary tree
     *
     * @return array of nodes values
     */
    static Integer[] computeBinaryTreeNodesInOrderOfIncreasingDepth_AlternatingDirection(BinaryTreeNode<Integer> tree) {
        List<Integer> result = new ArrayList<>();

        Queue<BinaryTreeNode<Integer>> currentQueue = new ArrayDeque<>();
        boolean directionIsLeftToRight = true;

        currentQueue.add(tree);
        Deque<BinaryTreeNode<Integer>> nextQueue = new ArrayDeque<>();

        while (!currentQueue.isEmpty()) {
            BinaryTreeNode<Integer> node = currentQueue.remove();

            result.add(node.data);

            if (node.left != null) {
                if (directionIsLeftToRight) nextQueue.addLast(node.left);
                else nextQueue.addFirst(node.left);
            }

            if (node.right != null) {
                if (directionIsLeftToRight) nextQueue.addLast(node.right);
                else nextQueue.addFirst(node.right);
            }

            if (currentQueue.isEmpty()) {
                directionIsLeftToRight = !directionIsLeftToRight;
                currentQueue = nextQueue;
                nextQueue = new ArrayDeque<>();
            }
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Variant: bottom-up left-right direction
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Breadth-first search
     *
     * @param tree binary tree
     * @return array of nodes values
     */
    static Integer[] computeBinaryTreeNodesInOrderOfIncreasingDepth_BottomUpLeftRight(BinaryTreeNode<Integer> tree) {
        Deque<Integer> result = new ArrayDeque<>();

        Queue<BinaryTreeNode<Integer>> currentQueue = new ArrayDeque<>();

        currentQueue.add(tree);

        while (!currentQueue.isEmpty()) {
            BinaryTreeNode<Integer> node = currentQueue.remove();

            result.addFirst(node.data);

            if (node.right != null) currentQueue.add(node.right);
            if (node.left != null) currentQueue.add(node.left);
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Variant: average at each level
     *
     * @Complexity O(n), O(n) space
     * @Algorithm Breadth-first search
     *
     * @param tree binary tree
     * @return array with average values
     */
    static Double[] computeBinaryTreeNodesInOrderOfIncreasingDepth_Average(BinaryTreeNode<Integer> tree) {
        List<Double> result = new ArrayList<>();

        Queue<BinaryTreeNode<Integer>> currentQueue = new ArrayDeque<>();
        Queue<BinaryTreeNode<Integer>> nextQueue = new ArrayDeque<>();

        currentQueue.add(tree);

        int count = 0;
        double value = 0.0;

        while (!currentQueue.isEmpty()) {
            BinaryTreeNode<Integer> node = currentQueue.remove();

            if (node.left != null) nextQueue.add(node.left);
            if (node.right != null) nextQueue.add(node.right);

            count++;
            value += node.data;

            if (currentQueue.isEmpty()) {
                result.add(value / count);
                currentQueue = nextQueue;
                nextQueue = new ArrayDeque<>();

                count = 0;
                value = 0.0;
            }
        }

        return result.toArray(new Double[0]);
    }
}
