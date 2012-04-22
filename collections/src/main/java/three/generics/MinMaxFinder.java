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

    public T min() {
        return compare(new MinFunction<T>());
    }

    public T max() {
        return compare(new MaxFunction<T>());
    }

    private T compare(CompressFunction<T> function) {
        T reference = holderArray[0].getValue();
        for (int i = 1; i < holderArray.length; i++) {
            reference = function.compare(reference, holderArray[i].getValue());
        }
        return reference;
    }


    interface CompressFunction<T extends Comparable<T>> {
        T compare(T t1, T t2);
    }

    private class MaxFunction<T extends Comparable<T>> implements CompressFunction<T> {

        public T compare(T t1, T t2) {
            return (t1.compareTo(t2) > 0) ? t1 : t2;
        }
    }

    private class MinFunction<T extends Comparable<T>> implements CompressFunction<T> {

        public T compare(T t1, T t2) {
            return (t1.compareTo(t2) < 0) ? t1 : t2;
        }
    }
}
