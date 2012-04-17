package three.collections;

import java.util.LinkedList;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class HashTable {
    private static final float OVERLOAD_LIMIT = 0.75f;
    private LinkedList[] buckets;
    private int capacity;

    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        buckets = new LinkedList[capacity];
    }

    public Object put(Object key, Object value) {
        int elementIndex = calculateIndex(key.hashCode());
        LinkedList values = buckets[elementIndex];
        if (values != null) {
            for (Object next : values) {
                TableElement element = (TableElement) next;
                if (key.equals(element.key)) {
                    Object oldValue = element.value;
                    element.value = value;
                    return oldValue;
                }
                values.add(new TableElement(key, value));
            }
        } else {

        }
        return null;
    }

    public int calculateIndex(int hashCode) {
        int index = Math.abs(hashCode);
        while (index > capacity) {
            index = index % capacity;
        }
        return index;
    }

    private static class TableElement {
        private Object key;
        private Object value;

        public TableElement(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
