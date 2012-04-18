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
        T min = holderArray[0].getValue();
        for (int i = 1; i < holderArray.length; i++) {
            if (min.compareTo(holderArray[i].getValue()) > 0) {
                min = holderArray[i].getValue();
            }
        }
        return min;
    }

    public T max() {
        T max = holderArray[0].getValue();
        for (int i = 1; i < holderArray.length; i++) {
            if (max.compareTo(holderArray[i].getValue()) < 0) {
                max = holderArray[i].getValue();
            }
        }
        return max;
    }

}
