package three.collections;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class LinkedList {
    private ListElement head = null;
    private ListElement tail = null;
    private int size = 0;

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

    public Object getFirst() {
        return (head != null) ? head.getValue() : null;
    }

    public Object getLast() {
        return (tail != null) ? tail.getValue() : null;
    }

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

    public boolean setElement(int index, Object element) {
        if (index >= 0 && index < size) {
            getListElement(index).setValue(element);
            return true;
        } else {
            return false;
        }
    }

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

    public Object getElement(int index) {
        ListElement element = getListElement(index);
        return (element != null) ? element.getValue() : null;
    }

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

    private static class ListElement {
        private Object value;
        private ListElement previous;
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
