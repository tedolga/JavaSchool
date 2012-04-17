package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class HashTableTest {
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
