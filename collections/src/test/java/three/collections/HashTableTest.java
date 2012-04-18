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
        HashTable table = new HashTable(10);
        Assert.assertNull(table.put("1", 1));
        Assert.assertNull(table.put("2", 2));
        Assert.assertNull(table.put("3", 3));
        Assert.assertEquals(3, table.put("3", "3"));
        Assert.assertEquals(2, table.put("2", "2"));
        Assert.assertNull(table.put(51, 3));
    }

    @Test
    public void testCalculateIndex() throws Exception {
        HashTable table = new HashTable(1);
        Assert.assertEquals(0, table.calculateIndex(28));
        table = new HashTable(10);
        Assert.assertEquals(1, table.calculateIndex(11));
        Assert.assertEquals(0, table.calculateIndex(0));
        Assert.assertEquals(1, table.calculateIndex(-1));
    }
}
