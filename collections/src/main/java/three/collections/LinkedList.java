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
            int elementIndex = 0;
            ListElement currentElement = head;
            while (elementIndex != index) {
                currentElement = currentElement.getNext();
            }
            ListElement previousElement = currentElement.getPrevious();
            ListElement nextElement = currentElement.getNext();
            if (previousElement == null) {
                nextElement.setPrevious(null);
                head = nextElement;
            } else if (nextElement == null) {
                previousElement.setNext(null);
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
            return true;
        } else {
            return false;
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

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public ListElement getPrevious() {
            return previous;
        }

        public void setPrevious(ListElement previous) {
            this.previous = previous;
        }

        public ListElement getNext() {
            return next;
        }

        public void setNext(ListElement next) {
            this.next = next;
        }
    }
}
