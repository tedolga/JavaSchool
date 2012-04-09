package two.essential;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BigFactorialExecutorTest {
    @Test
    public void testCalculateFactorial() throws Exception {
        Assert.assertEquals(2, BigFactorialExecutor.calculateZerosInFactorial(10));
        Assert.assertEquals(0, BigFactorialExecutor.calculateZerosInFactorial(4));
        Assert.assertEquals(24, BigFactorialExecutor.calculateZerosInFactorial(100));
    }
}
