package three.collections;

/**
 * Emulate behavior of Stack.
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class Stack<T> {

    /**
     * Reference to the last element of the stack
     */
    private StackElement<T> top;

    /**
     * Size of the stack
     */
    private int size;

    /**
     * Adds new element to the end of the stack
     *
     * @param element value of the new element
     */
    public void push(T element) {
        if (top == null) {
            top = new StackElement<T>(element, null);
        } else {
            top = new StackElement<T>(element, top);
        }
        size++;
    }

    /**
     * Returns value of the top element and removes it from the stack. If stack is empty-returns null.
     *
     * @return value of the top element, if stack is not empty, otherwise - returns null.
     */
    public T pop() {
        if (top != null) {
            T removable = top.getValue();
            top = top.getPrevious();
            size--;
            return removable;
        } else {
            return null;
        }
    }

    /**
     * Returns value of the top element, if stack is not empty, otherwise - returns null.
     *
     * @return value of the top element, if stack is not empty, otherwise - returns null.
     */
    public T peek() {
        return (top != null) ? top.getValue() : null;
    }

    /**
     * Returns size of the stack
     *
     * @return size of the stack
     */
    public int getSize() {
        return size;
    }

    /**
     * Represents an element of the stack
     */
    private static class StackElement<T> {

        /**
         * Value of the stack element
         */
        private T value;

        /**
         * Reference to the previous element of the stack
         */
        private StackElement previous;


        public StackElement(T value, StackElement previous) {
            this.value = value;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }


        public StackElement getPrevious() {
            return previous;
        }

    }
}
