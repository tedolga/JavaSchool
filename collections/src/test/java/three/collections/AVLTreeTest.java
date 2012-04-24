package three.collections;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class AVLTreeTest {
    @Test
    public void testPut() throws Exception {
        AVLTree<Integer> avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(5);
        avlTree.put(7);
        avlTree.put(2);
        avlTree.put(6);
        avlTree.put(8);
        avlTree.put(9);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals(6, avlTree.getSize());
        Assert.assertEquals((Object) 7, avlTree.getRootValue());

        avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(5);
        avlTree.put(9);
        avlTree.put(2);
        avlTree.put(7);
        avlTree.put(10);
        avlTree.put(6);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals(6, avlTree.getSize());
        Assert.assertEquals((Object) 7, avlTree.getRootValue());

        avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(7);
        avlTree.put(5);
        avlTree.put(8);
        avlTree.put(6);
        avlTree.put(2);
        avlTree.put(1);
        avlTree.put(3);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals(7, avlTree.getSize());
        Assert.assertEquals((Object) 5, avlTree.getRootValue());
        Vector vector = avlTree.toVector();
        Assert.assertEquals(7, vector.getCurrentSize());

        avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(7);
        avlTree.put(3);
        avlTree.put(8);
        avlTree.put(2);
        avlTree.put(4);
        avlTree.put(5);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals((Object) 4, avlTree.getRootValue());

        avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(8);
        avlTree.put(7);
        avlTree.put(9);
        avlTree.put(6);
        avlTree.put(5);
        avlTree.put(5);
        Assert.assertTrue(avlTree.getBalance() == 1);
        Assert.assertEquals(5, avlTree.getSize());
        Assert.assertEquals((Object) 8, avlTree.getRootValue());
    }

    @Test
    public void testToVector() throws Exception {
        AVLTree<Integer> avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(1);
        avlTree.put(2);
        avlTree.put(3);
        avlTree.put(4);
        avlTree.put(5);
        avlTree.put(6);
        Vector vector = avlTree.toVector();
        Assert.assertEquals(6, vector.getCurrentSize());
        for (int i = 1; i <= vector.getCurrentSize(); i++) {
            Assert.assertEquals(i, vector.getElement(i - 1));
        }

        avlTree = new AVLTree<Integer>(null, null, null);
        avlTree.put(1);
        avlTree.put(2);
        vector = avlTree.toVector();
        Assert.assertEquals(2, vector.getCurrentSize());
        for (int i = 1; i <= vector.getCurrentSize(); i++) {
            Assert.assertEquals(i, vector.getElement(i - 1));
        }

        avlTree = new AVLTree<Integer>(null, null, null);
        vector = avlTree.toVector();
        Assert.assertEquals(1, vector.getCurrentSize());
        Assert.assertNull(vector.getElement(0));
    }
}
