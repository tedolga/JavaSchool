package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class HashTableTest {
    @Test
    public void testPut() throws Exception {
        HashTable<String, Integer> table = new HashTable<String, Integer>(10);
        Assert.assertNull(table.put("1", 1));
        Assert.assertNull(table.put("2", 2));
        Assert.assertNull(table.put("3", 3));
        Assert.assertEquals(3, table.put("3", 6));
        Assert.assertEquals(2, table.put("2", 8));
        Assert.assertEquals(8, table.put("2", 8));
        Assert.assertNull(table.put("51", 3));
        Assert.assertEquals(4, table.getSize());
    }

    @Test
    public void testRehash() throws Exception {
        HashTable<Integer, String> table = new HashTable<Integer, String>(0);
        table.put(1, "1");
        table.put(5, "2");
        table.put(9, "3");
        table.put(13, "4");
        table.put(17, "5");
        Assert.assertEquals(5, table.getSize());
    }

    @Test(expected = NullPointerException.class)
    public void testPutNull() {
        HashTable<Integer, String> table = new HashTable<Integer, String>(5);
        table.put(1, null);
    }

    @Test
    public void testGet() throws Exception {
        HashTable<Integer, String> table = new HashTable<Integer, String>(4);
        Assert.assertNull(table.get(17));
        table.put(1, "1");
        table.put(5, "2");
        table.put(9, "3");
        table.put(13, "4");
        table.put(17, "5");
        Assert.assertEquals("5", table.get(17));
        Assert.assertNull(table.get(18));
        Assert.assertNull(table.get(2));
    }

    @Test
    public void testRemove() throws Exception {
        HashTable<Integer, String> table = new HashTable<Integer, String>(4);
        Assert.assertNull(table.remove(17));
        table.put(1, "1");
        table.put(5, "2");
        table.put(9, "3");
        table.put(13, "4");
        table.put(17, "5");
        Assert.assertEquals("5", table.remove(17));
        Assert.assertNull(table.remove(18));
        Assert.assertNull(table.remove(2));
        Assert.assertEquals(4, table.getSize());
    }
}
