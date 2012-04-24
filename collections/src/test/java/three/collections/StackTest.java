package three.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class StackTest {
    @Test
    public void testPushPop() throws Exception {
        Stack<String> testStack = new Stack<String>();
        testStack.push("1");
        testStack.push("2");
        testStack.push("3");
        testStack.push("4");
        for (int i = testStack.getSize(); i > 0; i--) {
            Assert.assertEquals(String.valueOf(i), testStack.pop());
        }
        Assert.assertNull(testStack.pop());
    }

    @Test
    public void testPeek() throws Exception {
        Stack<String> testStack = new Stack<String>();
        Assert.assertNull(testStack.peek());
        testStack.push("1");
        testStack.push("2");
        testStack.push("3");
        testStack.push("4");
        for (int i = testStack.getSize(); i > 0; i--) {
            Assert.assertEquals(String.valueOf(i), testStack.peek());
            testStack.pop();
        }
    }
}
