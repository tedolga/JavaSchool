package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class ArrayTest {
    private Array testArray;

    @Test(expected = IllegalArgumentException.class)
    public void testWrongCreation() throws Exception {
        testArray = new Array(-1);
    }

    @Test
    public void testGetSize() throws Exception {
        testArray = new Array(0);
        Assert.assertEquals(0, testArray.getSize());
        System.out.println(Integer.MAX_VALUE);
        testArray = new Array(1000);
        Assert.assertEquals(1000, testArray.getSize());
        testArray = null;
    }

    @Test
    public void testGetSetElement() throws Exception {
        testArray = new Array(5);
        Assert.assertFalse(testArray.setElement(-1, "-1"));
        Assert.assertFalse(testArray.setElement(5, "5"));
        Assert.assertTrue(testArray.setElement(0, "0"));
        Assert.assertTrue(testArray.setElement(4, "4"));
        Assert.assertNull(testArray.getElement(-1));
        Assert.assertNull(testArray.getElement(5));
        Assert.assertNull(testArray.getElement(1));
        Assert.assertEquals("0", testArray.getElement(0));
        Assert.assertEquals("4", testArray.getElement(4));
    }

}