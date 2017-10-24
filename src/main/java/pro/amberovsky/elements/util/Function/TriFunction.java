package pro.amberovsky.elements.util.Function;

/**
 * Represents a function that accepts 3 arguments and produces a result.
 *
 * This is a functional interface whose functional method is apply(Object).
 *
 * @param <T> the type of the first input to the function
 * @param <U> the type of the second input to the function
 * @param <V> the type of the third input to the function
 * @param <R> the type of the result of the function
 *
 * @since 1.8
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
