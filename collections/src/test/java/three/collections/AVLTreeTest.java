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
        AVLTree avlTree = new AVLTree(null, null, null);
        avlTree.put(5);
        avlTree.put(7);
        avlTree.put(2);
        avlTree.put(6);
        avlTree.put(8);
        avlTree.put(9);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals((Object) 7, avlTree.getRootValue());

        avlTree = new AVLTree(null, null, null);
        avlTree.put(5);
        avlTree.put(9);
        avlTree.put(2);
        avlTree.put(7);
        avlTree.put(10);
        avlTree.put(6);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals((Object) 7, avlTree.getRootValue());

        avlTree = new AVLTree(null, null, null);
        avlTree.put(7);
        avlTree.put(5);
        avlTree.put(8);
        avlTree.put(6);
        avlTree.put(4);
        avlTree.put(3);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals((Object) 5, avlTree.getRootValue());

        avlTree = new AVLTree(null, null, null);
        avlTree.put(7);
        avlTree.put(3);
        avlTree.put(8);
        avlTree.put(2);
        avlTree.put(4);
        avlTree.put(5);
        Assert.assertTrue(avlTree.getBalance() == 0);
        Assert.assertEquals((Object) 4, avlTree.getRootValue());

        avlTree = new AVLTree(null, null, null);
        avlTree.put(8);
        avlTree.put(7);
        avlTree.put(9);
        avlTree.put(6);
        avlTree.put(5);
        avlTree.put(5);
        Assert.assertTrue(avlTree.getBalance() == 1);
        Assert.assertEquals((Object) 8, avlTree.getRootValue());
    }
}
