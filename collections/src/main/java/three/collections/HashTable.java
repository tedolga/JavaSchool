package three.collections;

import java.util.LinkedList;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class HashTable<K, V> {
    private static final float OVERLOAD_LIMIT = 0.75f;
    private LinkedList[] buckets;
    private int capacity;
    private int mod;
    private int size;

    public HashTable(int initialCapacity) {
        this.capacity = (initialCapacity != 0) ? initialCapacity : 1;
        buckets = new LinkedList[capacity];
        mod = capacity;
    }

    public Object put(Object key, Object value) {
        checkNotNull("Key", key);
        checkNotNull("Value", value);
        Object returnValue = putToBuckets(buckets, key, value);
        if (returnValue == null) {
            size++;
        }
        return returnValue;
    }

    public Object get(Object key) {
        checkNotNull("Key", key);
        int elementIndex = calculateIndex(key.hashCode());
        LinkedList values = buckets[elementIndex];
        if (values == null) {
            return null;
        }
        for (Object next : values) {
            TableElement element = (TableElement) next;
            if (element.key.equals(key)) {
                return element.value;
            }
        }
        return null;
    }

    public Object remove(Object key) {
        checkNotNull("Key", key);
        int elementIndex = calculateIndex(key.hashCode());
        LinkedList values = buckets[elementIndex];
        if (values == null) {
            return null;
        }
        for (Object next : values) {
            TableElement element = (TableElement) next;
            if (element.key.equals(key)) {
                Object returnValue = element.value;
                values.remove(element);
                size--;
                return returnValue;
            }
        }
        return null;
    }

    private Object putToBuckets(LinkedList[] buckets, Object key, Object value) {
        int elementIndex = calculateIndex(key.hashCode());
        Object returnValue = putToBucketList(buckets, elementIndex, key, value);
        if (buckets[elementIndex].size() > OVERLOAD_LIMIT * capacity) {
            rehash();
        }
        return returnValue;
    }

    private int calculateIndex(int hashCode) {
        int index = Math.abs(hashCode);
        while (index >= mod) {
            index = index % mod;
        }
        return index;
    }

    private void checkNotNull(String argName, Object argValue) {
        if (argValue == null) {
            throw new NullPointerException(String.format("%s must not be null.", argName));
        }
    }

    private Object putToBucketList(LinkedList[] buckets, int index, Object key, Object value) {
        LinkedList values = buckets[index];
        if (values == null) {
            buckets[index] = new LinkedList<TableElement>();
            buckets[index].add(new TableElement(key, value));
            return null;
        }
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
    }

    private void rehash() {
        capacity = capacity * 2 + 1;
        mod = capacity;
        LinkedList[] newBuckets = new LinkedList[capacity];
        for (LinkedList bucket : buckets) {
            if (bucket != null) {
                for (Object element : bucket) {
                    TableElement tableElement = (TableElement) element;
                    putToBuckets(newBuckets, tableElement.key, tableElement.value);
                }
            }
        }
        buckets = newBuckets;
    }

    public int getSize() {
        return size;
    }

    private static class TableElement {
        private Object key;
        private Object value;

        public TableElement(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
