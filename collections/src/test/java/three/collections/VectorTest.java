package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class VectorTest {
    private Vector testVector;

    @Test(expected = IllegalArgumentException.class)
    public void testBadCreation() throws Exception {
        testVector = new Vector(-1);
    }

    @Test
    public void testGetCurrentSize() throws Exception {
        testVector = new Vector(3);
        Assert.assertEquals(0, testVector.getCurrentSize());
        testVector.addElement("first");
        testVector.addElement("second");
        Assert.assertEquals(2, testVector.getCurrentSize());
    }

    @Test
    public void testAddElement() throws Exception {
        testVector = new Vector(1);
        testVector.addElement("first");
        testVector.addElement("second");
        testVector.addElement("third");
        Assert.assertEquals("third", testVector.getElement(2));
        Assert.assertEquals(3, testVector.getCurrentSize());
    }

    @Test
    public void testRemoveAt() throws Exception {
        testVector = new Vector(4);
        testVector.addElement("first");
        testVector.addElement("second");
        testVector.addElement("third");
        testVector.addElement("fourth");
        Assert.assertFalse(testVector.removeAt(-1));
        Assert.assertFalse(testVector.removeAt(4));
        Assert.assertTrue(testVector.removeAt(1));
        Assert.assertEquals(3, testVector.getCurrentSize());
        Assert.assertEquals("third", testVector.getElement(1));
        Assert.assertNull(testVector.getElement(3));
        Assert.assertTrue(testVector.removeAt(0));
        Assert.assertEquals("third", testVector.getElement(0));
        Assert.assertTrue(testVector.removeAt(1));
        Assert.assertEquals("third", testVector.getElement(0));
        Assert.assertEquals(1, testVector.getCurrentSize());
    }

    @Test
    public void testInsertAt() throws Exception {
        testVector = new Vector(4);
        testVector.addElement("0");
        testVector.addElement("1");
        testVector.addElement("2");
        testVector.addElement("3");
        Assert.assertFalse(testVector.insertAt(-1, "-1"));
        Assert.assertFalse(testVector.insertAt(4, "4"));
        Assert.assertTrue(testVector.insertAt(0, "initial"));
        Assert.assertEquals(5, testVector.getCurrentSize());
        Assert.assertEquals("3", testVector.getElement(4));
        Assert.assertEquals("initial", testVector.getElement(0));
        Assert.assertTrue(testVector.insertAt(2, "0.5"));
        Assert.assertEquals("0.5", testVector.getElement(2));
        Assert.assertEquals(6, testVector.getCurrentSize());
        Assert.assertTrue(testVector.insertAt(5, "2.5"));
        Assert.assertEquals("2.5", testVector.getElement(5));
        Assert.assertEquals("3", testVector.getElement(6));
    }

    @Test
    public void testSetElement() throws Exception {
        testVector = new Vector(4);
        testVector.addElement("0");
        testVector.addElement("1");
        testVector.addElement("2");
        testVector.addElement("3");
        Assert.assertFalse(testVector.setElement(-1, "-1"));
        Assert.assertFalse(testVector.setElement(4, "4"));
        Assert.assertTrue(testVector.setElement(0, "zero"));
        Assert.assertEquals("zero", testVector.getElement(0));
        Assert.assertTrue(testVector.setElement(3, "three"));
        Assert.assertEquals("three", testVector.getElement(3));
        Assert.assertEquals(4, testVector.getCurrentSize());
    }
}
