package three.collections;

import java.util.Arrays;

/**
 * Emulates behavior of Vector.
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class Vector {
    /**
     * Storage of elements
     */
    private Object[] elements;

    /**
     * Capacity of elements storage
     */
    private int capacity;

    /**
     * Count of elements actually existing in vector
     */
    private int elementsCount;

    /**
     * Creates a vector with specified initial capacity
     *
     * @param initialCapacity initial capacity of vector
     */
    public Vector(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initialCapacity: " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.elements = new Object[initialCapacity];
    }

    /**
     * Returns a count of elements actually existing in vector
     *
     * @return count of elements actually existing in vector
     */
    public int getCurrentSize() {
        return elementsCount;
    }

    /**
     * Adds element to the end of the vector and increases it's capacity if it is needed
     *
     * @param element adding element
     */
    public void addElement(Object element) {
        provideCapacity(elementsCount + 1);
        elements[elementsCount++] = element;
    }

    /**
     * Removes an element from the specified position
     *
     * @param index position of removing element
     * @return true, if index is in vector bounds, or false in other case
     */
    public boolean removeAt(int index) {
        if (index >= 0 && index < elementsCount) {
            int right = elementsCount - index - 1;
            if (right > 0) {
                System.arraycopy(elements, index + 1, elements, index, right);
            }
            elements[--elementsCount] = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserts element to the specified position
     *
     * @param index   position where element will be inserted
     * @param element element to be inserted
     * @return true, if index is in vector bounds, or false in other case
     */
    public boolean insertAt(int index, Object element) {
        if (index >= 0 && index < elementsCount) {
            provideCapacity(elementsCount + 1);
            System.arraycopy(elements, index, elements, index + 1, elementsCount - index);
            elements[index] = element;
            elementsCount++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the element from specified position
     *
     * @param index position of the required element
     * @return the element from specified position
     */
    public Object getElement(int index) {
        return (index >= 0 && index < elementsCount) ? elements[index] : null;
    }

    /**
     * Sets a given value for the element in specified position
     *
     * @param index   position of the element
     * @param element value which will be set to the element
     * @return true if index is in vector bounds, or false -in other case
     */
    public boolean setElement(int index, Object element) {
        if (index >= 0 && index < elementsCount) {
            elements[index] = element;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if vector capacity is enough to provide required capacity. If it is not so, vector capacity increases
     * doubles.
     *
     * @param requiredCapacity required capacity
     */
    private void provideCapacity(int requiredCapacity) {
        if (requiredCapacity > capacity) {
            capacity = (capacity != 0) ? capacity * 2 : 1;
            elements = Arrays.copyOf(elements, capacity);
        }
    }

}
