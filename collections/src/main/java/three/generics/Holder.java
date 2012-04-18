package three.generics;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class Holder<T> {

    private T value;

    public Holder(T value) {
        if (value == null) {
            throw new NullPointerException("Value must not be null");
        }
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
