package three.generics;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class MinMaxFinder<T extends Comparable<T>> {

    private final Holder<T>[] holderArray;

    public MinMaxFinder(Holder<T>... holderArray) {
        if (holderArray == null || holderArray.length == 0) {
            throw new IllegalArgumentException("Parameter must not be null and must not have zero length");
        }
        this.holderArray = holderArray;
    }

    /**
     * Returns minimum value of holder from holderArray
     *
     * @return minimum value
     */
    public T min() {
        return compare(new MinFunction<T>());
    }

    /**
     * Returns maximum value of holder from holderArray
     *
     * @return maximum value
     */
    public T max() {
        return compare(new MaxFunction<T>());
    }

    /**
     * Finds result of given function on holderArray.
     *
     * @param function function which returns result of comparison according to specified rules.
     * @return result of given function on holder array.
     */
    private T compare(CompressFunction<T> function) {
        T reference = holderArray[0].getValue();
        for (int i = 1; i < holderArray.length; i++) {
            reference = function.compare(reference, holderArray[i].getValue());
        }
        return reference;
    }

    /**
     * Interface for comparing two elements.
     *
     * @param <T> Type of comparing elements.
     */
    interface CompressFunction<T extends Comparable<T>> {
        T compare(T t1, T t2);
    }

    /**
     * Function for determining maximum element.
     *
     * @param <T> Type of comparing elements.
     */
    private class MaxFunction<T extends Comparable<T>> implements CompressFunction<T> {

        /**
         * Returns maximum of 2 given elements
         *
         * @param t1 first element
         * @param t2 second element
         * @return maximum element from 2 given elements
         */
        public T compare(T t1, T t2) {
            return (t1.compareTo(t2) > 0) ? t1 : t2;
        }
    }

    /**
     * Function for determining minimum element.
     *
     * @param <T> Type of comparing elements.
     */
    private class MinFunction<T extends Comparable<T>> implements CompressFunction<T> {
        /**
         * Returns minimum of 2 given elements
         *
         * @param t1 first element
         * @param t2 second element
         * @return minimum element from 2 given elements
         */
        public T compare(T t1, T t2) {
            return (t1.compareTo(t2) < 0) ? t1 : t2;
        }
    }
}
