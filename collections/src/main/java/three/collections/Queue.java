package three.collections;

/**
 * Emulates behavior of queue
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class Queue<T> {

    /**
     * Reference to the start of the queue
     */
    private QueueElement<T> head;

    /**
     * Reference to the and of the queue
     */
    private QueueElement<T> tail;

    /**
     * Size of the queue
     */
    private int size;

    /**
     * Adds new element to the end of the queue
     *
     * @param element value of the new element
     */
    public void put(T element) {
        if (tail != null) {
            QueueElement newElement = new QueueElement(element, null);
            tail.setNext(newElement);
            tail = newElement;
        } else {
            tail = new QueueElement(element, null);
            head = tail;
        }
        size++;
    }

    /**
     * Returns value of the first element of the queue and removes it from queue. If queue is empty - returns null.
     *
     * @return value of the first element of the queue, if queue is not empty, null - otherwise.
     */
    public T get() {
        if (head != null) {
            T returnValue = head.getValue();
            head = head.getNext();
            size--;
            return returnValue;
        } else {
            return null;
        }
    }

    /**
     * Returns value of the first element of the queue.
     *
     * @return value of the first element of the queue, if queue is not empty, null - otherwise.
     */
    public T peek() {
        return (head != null) ? head.getValue() : null;
    }

    /**
     * Returns count of elements in the list.
     *
     * @return count of elements in the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Represents element of the queue.
     */
    private static class QueueElement<T> {

        /**
         * Value of the element
         */
        private T value;

        /**
         * Reference to the next element of the list.
         */
        private QueueElement next;

        public QueueElement(T value, QueueElement next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public QueueElement getNext() {
            return next;
        }

        public void setNext(QueueElement next) {
            this.next = next;
        }
    }
}
