package pro.amberovsky.elements.util.Function;

/**
 * Represents a function that provides random values
 *
 * @param <T> type of values
 */
@FunctionalInterface
public interface RandomSupplier<T> {
    T get(T bound);
}
