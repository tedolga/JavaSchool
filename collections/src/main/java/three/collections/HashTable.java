package three.collections;

import java.util.LinkedList;

/**
 * Emulates HashTable
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class HashTable<K, V> {

    /**
     * Limit quotient for rehashing
     */
    private static final float OVERLOAD_LIMIT = 0.75f;

    /**
     * Array for element storing according to it's hashCodes
     */
    private LinkedList<TableElement<K, V>>[] buckets;

    /**
     * Number of buckets
     */
    private int capacity;

    /**
     * Module which is been used to determine which bucket corresponds to element hashCode
     */
    private int mod;

    /**
     * Number of elements in HashTable
     */
    private int size;

    /**
     * Creates HashTable with initial capacity
     *
     * @param initialCapacity capacity of HashTable
     */
    public HashTable(int initialCapacity) {
        this.capacity = (initialCapacity != 0) ? initialCapacity : 1;
        buckets = new LinkedList[capacity];
        mod = capacity;
    }

    /**
     * Puts new element with given key and value to the HashTable. If element with specified key already exists,
     * returns old value of that key and sets it to given value, otherwise-returns null. Restricts adding of null keys
     * and null values.
     *
     * @param key   key for new element
     * @param value value for new element
     * @return old value of given key, if element with specified key already exists, otherwise - returns null.
     */
    public Object put(K key, V value) {
        checkNotNull("Key", key);
        checkNotNull("Value", value);
        V returnValue = putToBuckets(buckets, key, value);
        if (returnValue == null) {
            size++;
        }
        return returnValue;
    }

    /**
     * Returns value of the given key, if element with specified key exists in table.
     *
     * @param key key to element search.
     * @return value of the given key, if element with specified key exists in table, null-otherwise
     */
    public V get(K key) {
        checkNotNull("Key", key);
        int elementIndex = calculateIndex(key.hashCode());
        LinkedList<TableElement<K, V>> values = buckets[elementIndex];
        if (values == null) {
            return null;
        }
        for (TableElement<K, V> next : values) {
            if (next.key.equals(key)) {
                return next.value;
            }
        }
        return null;
    }

    /**
     * Removes element with given key and returns it's value, if element with specified key exists in table.
     *
     * @param key key to element search.
     * @return value of the given key, if element with specified key exists in table, null-otherwise
     */
    public V remove(Object key) {
        checkNotNull("Key", key);
        int elementIndex = calculateIndex(key.hashCode());
        LinkedList<TableElement<K, V>> values = buckets[elementIndex];
        if (values == null) {
            return null;
        }
        for (TableElement<K, V> next : values) {
            if (next.key.equals(key)) {
                V returnValue = next.value;
                values.remove(next);
                size--;
                return returnValue;
            }
        }
        return null;
    }

    /**
     * Puts given element to the specified array of buckets.
     *
     * @param buckets array of buckets
     * @param key     key for a new element
     * @param value   value for a new element
     * @return value of the given key, if element with specified key exists in table, null-otherwise
     */
    private V putToBuckets(LinkedList[] buckets, K key, V value) {
        int elementIndex = calculateIndex(key.hashCode());
        V returnValue = putToBucketList(buckets, elementIndex, key, value);
        if (buckets[elementIndex].size() > OVERLOAD_LIMIT * capacity) {
            rehash();
        }
        return returnValue;
    }

    /**
     * Calculates index of the bucket for a given hashCode. Uses {@link three.collections.HashTable#mod} value as
     * divider and makes division on it until remainder will be less than mod.
     *
     * @param hashCode hashcode of the element key
     * @return index of the bucket
     */
    private int calculateIndex(int hashCode) {
        int index = Math.abs(hashCode);
        while (index >= mod) {
            index = index % mod;
        }
        return index;
    }

    /**
     * Checks if given element is not null
     *
     * @param argName  name of the argument to be used in error message
     * @param argValue value of the argument
     * @throws NullPointerException in case when value == null
     */
    private void checkNotNull(String argName, Object argValue) {
        if (argValue == null) {
            throw new NullPointerException(String.format("%s must not be null.", argName));
        }
    }

    /**
     * Puts given element to the specified bucket in array of buckets.
     *
     * @param buckets array of buckets.
     * @param index   index of required bucket.
     * @param key     key of the element.
     * @param value   value of the element.
     * @return value of the given key, if element with specified key exists in table, null-otherwise
     */
    private V putToBucketList(LinkedList[] buckets, int index, K key, V value) {
        LinkedList<TableElement<K, V>> values = buckets[index];
        if (values == null) {
            buckets[index] = new LinkedList<TableElement<K, V>>();
            buckets[index].add(new TableElement<K, V>(key, value));
            return null;
        }
        for (TableElement<K, V> next : values) {
            if (next.key.equals(key)) {
                V oldValue = next.value;
                next.value = value;
                return oldValue;
            }
        }
        values.add(new TableElement<K, V>(key, value));
        return null;
    }

    /**
     * Doubles table capacity and relocate elements of table to new buckets.
     */
    private void rehash() {
        capacity = capacity * 2 + 1;
        mod = capacity;
        LinkedList<TableElement<K, V>>[] newBuckets = new LinkedList[capacity];
        for (LinkedList<TableElement<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (TableElement<K, V> element : bucket) {
                    putToBuckets(newBuckets, element.key, element.value);
                }
            }
        }
        buckets = newBuckets;
    }

    public int getSize() {
        return size;
    }

    /**
     * Represents element of the table.
     *
     * @param <K> key of the element.
     * @param <V> value of the element.
     */
    private static class TableElement<K, V> {
        private K key;
        private V value;

        public TableElement(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
