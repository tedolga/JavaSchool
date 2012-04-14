package three.collections;

/**
 * Bidirectional linked list
 *
 * @author Tedikova O.
 * @version 1.0
 */
public class LinkedList {

    /**
     * Reference to the first element of the list
     */
    private ListElement head = null;

    /**
     * Reference to the last element of the list
     */
    private ListElement tail = null;

    /**
     * Count of elements in the list
     */
    private int size = 0;

    /**
     * Adds new element to the end of the list.
     *
     * @param element element to add
     */
    public void addLast(Object element) {
        if (tail == null) {
            head = new ListElement(element, null, null);
            tail = head;
        } else {
            ListElement newElement = new ListElement(element, tail, null);
            tail.setNext(newElement);
            tail = newElement;
        }
        size++;
    }

    /**
     * Adds new element to the start of the list
     *
     * @param element element to add
     */
    public void addFirst(Object element) {
        if (head == null) {
            head = new ListElement(element, null, null);
            tail = head;
        } else {
            ListElement newElement = new ListElement(element, null, head);
            head.setPrevious(newElement);
            head = newElement;
        }
        size++;
    }

    /**
     * Returns value of the first element of the list. If the list is empty, returns null.
     *
     * @return value of the first element of the list, if the list is not empty, returns null - otherwise.
     */
    public Object getFirst() {
        return (head != null) ? head.getValue() : null;
    }

    /**
     * Returns value of the last element of the list. If the list is empty, returns null.
     *
     * @return value of the last element of the list, if the list is not empty, returns null - otherwise.
     */
    public Object getLast() {
        return (tail != null) ? tail.getValue() : null;
    }

    /**
     * Removes element at specified position and returns true, if element with specified position exists, otherwise
     * returns false.
     *
     * @param index position of the element
     * @return true, if element with specified position exists, otherwise returns false.
     */
    public boolean removeAt(int index) {
        if (index >= 0 && index < size) {
            ListElement currentElement = getListElement(index);
            ListElement previousElement = currentElement.getPrevious();
            ListElement nextElement = currentElement.getNext();
            if (previousElement == null) {
                nextElement.setPrevious(previousElement);
                head = nextElement;
            } else if (nextElement == null) {
                previousElement.setNext(nextElement);
                tail = previousElement;
            } else {
                nextElement.setPrevious(previousElement);
                previousElement.setNext(nextElement);
            }
            size--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserts new element with given value at the specified position.
     *
     * @param index   position
     * @param element value of the new element
     * @return true if position >0 and <= size of the list, otherwise returns false
     */
    public boolean insertAt(int index, Object element) {
        if (index >= 0 && index <= size) {
            ListElement currentElement = getListElement(index);
            ListElement previousElement = (currentElement != null) ? currentElement.getPrevious() : null;
            if (index == size) {
                addLast(element);
            } else if (previousElement == null) {
                addFirst(element);
            } else {
                ListElement newElement = new ListElement(element, previousElement, currentElement);
                previousElement.setNext(newElement);
                currentElement.setPrevious(newElement);
                size++;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets given value to the element at the specified position.
     *
     * @param index   position
     * @param element value to be set
     * @return true, if element with specified index exists in the list, false-otherwise
     */
    public boolean setElement(int index, Object element) {
        if (index >= 0 && index < size) {
            getListElement(index).setValue(element);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Copies all the elements of the list to the {@link three.collections.Vector} instance
     *
     * @return {@link three.collections.Vector} instance, containing all elements of the list
     */
    public Vector toVector() {
        Vector vector = new Vector(size);
        int elementIndex = 0;
        ListElement currentElement = head;
        while (elementIndex < size) {
            vector.addElement(currentElement.getValue());
            currentElement = currentElement.getNext();
            elementIndex++;
        }
        return vector;
    }

    /**
     * Returns value of element at the specified position
     *
     * @param index position of the element
     * @return value of element at the specified position, if element at the specified position exists in list, null
     *         - otherwise
     */
    public Object getElement(int index) {
        ListElement element = getListElement(index);
        return (element != null) ? element.getValue() : null;
    }

    /**
     * Returns element of the list at the specified position
     *
     * @param index position of the element
     * @return element at the specified position, if element at the specified position exists in list, null
     *         - otherwise
     */
    private ListElement getListElement(int index) {
        if (index >= 0 && index < size) {
            int elementIndex = 0;
            ListElement currentElement = head;
            while (elementIndex != index) {
                currentElement = currentElement.getNext();
                elementIndex++;
            }
            return currentElement;
        } else {
            return null;
        }
    }

    /**
     * Inner class which performs element of the list.
     */
    private static class ListElement {

        /**
         * Value of the element.
         */
        private Object value;

        /**
         * Reference to the previous element of the list.
         */
        private ListElement previous;

        /**
         * Reference to the next element of the list.
         */
        private ListElement next;

        private ListElement(Object value, ListElement previous, ListElement next) {

            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        private Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        private ListElement getPrevious() {
            return previous;
        }

        private void setPrevious(ListElement previous) {
            this.previous = previous;
        }

        private ListElement getNext() {
            return next;
        }

        private void setNext(ListElement next) {
            this.next = next;
        }
    }
}
