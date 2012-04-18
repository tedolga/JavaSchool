package three.generics;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class Holder<T> {
    private T value;

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
