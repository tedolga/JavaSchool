package two.essential;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BigFactorialExecutorTest {
    @Test
    public void testCalculateZeros() throws Exception {
        Assert.assertEquals(2, BigFactorialExecutor.calculateZerosInFactorial(10));
        Assert.assertEquals(0, BigFactorialExecutor.calculateZerosInFactorial(4));
        Assert.assertEquals(24, BigFactorialExecutor.calculateZerosInFactorial(100));
    }

    @Test
    public void testCalculateZerosString() throws Exception {
        Assert.assertEquals(2, BigFactorialExecutor.calculateZerosInFactorialString(10));
        Assert.assertEquals(0, BigFactorialExecutor.calculateZerosInFactorialString(4));
        Assert.assertEquals(24, BigFactorialExecutor.calculateZerosInFactorialString(100));
    }

    @Test
    public void testTime() {
        long startTime = System.currentTimeMillis();
        int count = BigFactorialExecutor.calculateZerosInFactorial(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("count = " + count);
        System.out.println("calculateZerosInFactorial(1000) duration is:" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        count = BigFactorialExecutor.calculateZerosInFactorialString(1000);
        endTime = System.currentTimeMillis();
        System.out.println("count = " + count);
        System.out.println("calculateZerosInFactorialString(1000) duration is:" + (endTime - startTime));
    }
}
