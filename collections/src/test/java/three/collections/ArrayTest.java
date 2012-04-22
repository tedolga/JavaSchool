package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class ArrayTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWrongCreation() throws Exception {
        Array<Integer> testArray = new Array<Integer>(-1);
    }

    @Test
    public void testGetSize() throws Exception {
        Array testArray = new Array(0);
        Assert.assertEquals(0, testArray.getSize());
        testArray = new Array(1000);
        Assert.assertEquals(1000, testArray.getSize());
    }

    @Test
    public void testGetSetElement() throws Exception {
        Array<String> testArray = new Array<String>(5);
        Assert.assertFalse(testArray.setElement(-1, "-1.0"));
        Assert.assertFalse(testArray.setElement(5, "5"));
        Assert.assertTrue(testArray.setElement(0, "0"));
        Assert.assertTrue(testArray.setElement(4, "4"));
        Assert.assertNull(testArray.getElement(-1));
        Assert.assertNull(testArray.getElement(5));
        Assert.assertNull(testArray.getElement(1));
        Assert.assertEquals("0", testArray.getElement(0));
        Assert.assertEquals("4", testArray.getElement(4));
    }

    @Test
    public void testRandom() throws Exception {
        Array<Integer> array = new Array<Integer>(3);
        array.setElement(0, 0);
        array.setElement(1, 1);
        array.setElement(2, 2);
        Integer value = Array.random(array);
        Assert.assertTrue(0 <= value && value <= 2);
    }
}
