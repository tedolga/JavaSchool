package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class QueueTest {
    @Test
    public void testPutGet() throws Exception {
        Queue<String> queue = new Queue<String>();
        Assert.assertNull(queue.get());
        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.put("4");
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(String.valueOf(i), queue.get());
        }
        Assert.assertNull(queue.get());
    }

    @Test
    public void testPeek() throws Exception {
        Queue<String> queue = new Queue<String>();
        Assert.assertNull(queue.peek());
        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.put("4");
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(String.valueOf(i), queue.peek());
            queue.get();
        }
        Assert.assertNull(queue.peek());
    }
}
