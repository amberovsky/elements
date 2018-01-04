package pro.amberovsky.elements;

import pro.amberovsky.elements.util.data.JumpListNode;

import java.util.function.*;

/**
 * Factories for StacksAndQueues class
 */
class StacksAndQueuesFactory {
    /**
     * Algorithms for SEARCH A POSTING LIST
     */
    enum SEARCH_A_POSTING_LIST { ITERATIVE, RECURSION }

    /**
     * @param algorithm which one for SEARCH A POSTING LIST
     *
     * @return operator to calculate jump-first order
     */
    static <T> UnaryOperator<JumpListNode<T>> getSearchAPostingList(SEARCH_A_POSTING_LIST algorithm) {
        switch (algorithm) {
            case ITERATIVE:
                return StacksAndQueues::jumpFirstOrderByIteration;

            case RECURSION:
                return StacksAndQueues::jumpFirstOrderByRecursion;

            default:
                throw new IllegalArgumentException();
        }
    }
}
