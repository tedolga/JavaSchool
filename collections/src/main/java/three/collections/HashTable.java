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
    private int mod;

    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        buckets = new LinkedList[capacity];
        mod = capacity;
    }

    public Object put(Object key, Object value) {
        checkNotNull("Key", key);
        checkNotNull("Value", value);
        int elementIndex = calculateIndex(key.hashCode());
        Object returnValue = putToBucket(elementIndex, key, value);
        if (buckets[elementIndex].size() > OVERLOAD_LIMIT * capacity) {
            rehash();
        }
        return returnValue;
    }


    public int calculateIndex(int hashCode) {
        int index = Math.abs(hashCode);
        while (index > mod) {
            index = index % mod;
        }
        return index;
    }

    private void checkNotNull(String argName, Object argValue) {
        if (argValue == null) {
            throw new NullPointerException(String.format("%s must not be null.", argName));
        }
    }

    private Object putToBucket(int index, Object key, Object value) {
        LinkedList values = buckets[index];
        if (values != null) {
            for (Object next : values) {
                TableElement element = (TableElement) next;
                if (element.key.equals(key)) {
                    Object oldValue = element.value;
                    element.value = value;
                    return oldValue;
                }
            }
            values.add(new TableElement(key, value));
            return null;
        } else {
            buckets[index] = new LinkedList<TableElement>();
            buckets[index].add(new TableElement(key, value));
            return null;
        }
    }

    private void rehash() {

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
