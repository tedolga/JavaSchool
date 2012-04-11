package three.collections;

/**
 * Emulates the behavior of an array o values
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class Array {
    private Object[] array;
    private int size;

    /**
     * Creates an array of {@link java.lang.Object Objects} with the specified size
     *
     * @param size of array
     * @throws IllegalArgumentException if specified size is negative
     */
    public Array(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal size: " + size);
        }
        this.size = size;
        this.array = new Object[this.size];
    }

    /**
     * Returns size of array
     *
     * @return size of array
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns element of array with specified index
     *
     * @param index of required element
     * @return element of array with specified index, if index is in bounds of array, or {@literal null} in other case.
     */
    public Object getElement(int index) {
        return (0 <= index && index < size) ? array[index] : null;
    }

    /**
     * Sets given value to the specified element of array
     *
     * @param index   of the element
     * @param element value
     * @return true, if specified index is in array bounds, or false in other case
     */
    public boolean setElement(int index, Object element) {
        if (0 <= index && index < size) {
            array[index] = element;
            return true;
        } else {
            return false;
        }
    }
}
