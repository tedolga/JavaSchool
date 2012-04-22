package three.generics;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class Holder<T extends Comparable<? super T>> implements Comparable<Holder<T>> {

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

    @Override
    public String toString() {
        return "Holder{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Holder)) {
            return false;
        }

        Holder holder = (Holder) o;

        return (value != null ? value.equals(holder.value) : holder.value == null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public int compareTo(Holder<T> o) {
        return value.compareTo(o.getValue());
    }
}
