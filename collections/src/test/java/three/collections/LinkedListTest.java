package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class LinkedListTest {
    @Test
    public void testAddLast() throws Exception {
        LinkedList testList = new LinkedList();
        Assert.assertNull(testList.getFirst());
        Assert.assertNull(testList.getLast());
        testList.addLast("1");
        Assert.assertEquals("1", testList.getFirst());
        Assert.assertEquals("1", testList.getLast());
        testList.addLast("2");
        testList.addLast("3");
        Assert.assertEquals("1", testList.getFirst());
        Assert.assertEquals("3", testList.getLast());

    }

    @Test
    public void testAddFirst() throws Exception {
        LinkedList testList = new LinkedList();
        testList.addFirst("1");
        Assert.assertEquals("1", testList.getFirst());
        Assert.assertEquals("1", testList.getLast());
        testList.addFirst("2");
        testList.addFirst("3");
        Assert.assertEquals("3", testList.getFirst());
        Assert.assertEquals("1", testList.getLast());
    }

    @Test
    public void testRemoveAt() throws Exception {
        LinkedList testList = new LinkedList();
        Assert.assertFalse(testList.removeAt(0));
        testList.addLast("1");
        testList.addLast("2");
        testList.addLast("3");
        testList.addLast("4");
        testList.addLast("5");
        Assert.assertFalse(testList.removeAt(-1));
        Assert.assertFalse(testList.removeAt(5));
        Assert.assertTrue(testList.removeAt(0));
        Assert.assertEquals("2", testList.getFirst());
        Assert.assertTrue(testList.removeAt(3));
        Assert.assertEquals("4", testList.getLast());
        Assert.assertFalse(testList.removeAt(3));
        Assert.assertTrue(testList.removeAt(1));
        Assert.assertEquals("2", testList.getFirst());
        Assert.assertEquals("4", testList.getLast());
        Assert.assertFalse(testList.removeAt(2));
    }

    @Test
    public void testInsertAt() throws Exception {
        LinkedList testList = new LinkedList();
        Assert.assertTrue(testList.insertAt(0, "0"));
        Assert.assertEquals("0", testList.getFirst());
        Assert.assertEquals("0", testList.getLast());

        Assert.assertTrue(testList.insertAt(0, "initial"));
        Assert.assertEquals("initial", testList.getFirst());
        Assert.assertEquals("0", testList.getLast());

        Assert.assertTrue(testList.insertAt(2, "1"));
        Assert.assertEquals("1", testList.getLast());

        Assert.assertTrue(testList.insertAt(2, "0.5"));
        Assert.assertEquals("initial", testList.getFirst());
        Assert.assertEquals("1", testList.getLast());
        Assert.assertEquals("0.5", testList.getElement(2));

        Assert.assertFalse(testList.insertAt(-1, "-1"));
        Assert.assertFalse(testList.insertAt(5, "5"));
    }

    @Test
    public void testSetGetElement() throws Exception {
        LinkedList testList = new LinkedList();
        Assert.assertFalse(testList.setElement(-1, "-1"));
        Assert.assertFalse(testList.setElement(0, "0"));
        testList.addFirst("zero");
        Assert.assertFalse(testList.setElement(1, "0"));
        Assert.assertNull(testList.getElement(1));
        Assert.assertTrue(testList.setElement(0, "0"));
        Assert.assertEquals("0", testList.getElement(0));
        Assert.assertNull(testList.getElement(-1));
    }

    @Test
    public void testToVector() throws Exception {
        Vector vector;
        LinkedList testList = new LinkedList();
        vector = testList.toVector();
        Assert.assertEquals(0, vector.getCurrentSize());
        testList.addLast("1");
        testList.addLast("2");
        testList.addLast("3");
        testList.addLast("4");
        testList.addLast("5");
        vector = testList.toVector();
        Assert.assertEquals(5, vector.getCurrentSize());
        for (int i = 1; i <= vector.getCurrentSize(); i++) {
            Assert.assertEquals(String.valueOf(i), vector.getElement(i - 1));
        }
    }
}
