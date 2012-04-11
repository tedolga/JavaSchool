package three.collections;

import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class LinkedListTest {
    @Test
    public void testAddLast() throws Exception {
        LinkedList testList = new LinkedList();
        testList.addLast("1");
        testList.addLast("2");
    }

    @Test
    public void testAddFirst() throws Exception {
        LinkedList testList = new LinkedList();
        testList.addFirst("1");
        testList.addFirst("2");
    }
}
