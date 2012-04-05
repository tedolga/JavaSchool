package two.flow;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class MathTricksTest {
    @Test
    public void testCalculatePrimeInnocent() throws Exception {
        Assert.assertEquals(7, MathTricks.calculatePrimeInnocent(10));
        Assert.assertEquals(3, MathTricks.calculatePrimeInnocent(4));
        Assert.assertEquals(113, MathTricks.calculatePrimeInnocent(120));
        Assert.assertEquals(399989, MathTricks.calculatePrimeInnocent(400000));
        Assert.assertEquals(999999937, MathTricks.calculatePrimeInnocent(999999999));
        try {
            MathTricks.calculatePrimeInnocent(1);
            Assert.assertFalse(true);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testCalculatePrimeAdvanced() throws Exception {
//        Assert.assertEquals(7, MathTricks.calculatePrimeAdvanced(10));
//        Assert.assertEquals(3, MathTricks.calculatePrimeAdvanced(4));
//        Assert.assertEquals(113, MathTricks.calculatePrimeAdvanced(120));
//        Assert.assertEquals(399989, MathTricks.calculatePrimeAdvanced(400000));
//        Assert.assertEquals(999999937, MathTricks.calculatePrimeAdvanced(999999999));
    }

    @Test
    public void testCalculateBinomial() throws Exception {
        try {
            Assert.assertEquals(1, MathTricks.calculateBinomial(1, 0));
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        try {
            Assert.assertEquals(1, MathTricks.calculateBinomial(0, 1));
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        Assert.assertEquals(84, MathTricks.calculateBinomial(9, 3));
    }

    @Test
    public void testCalculateFibonacci() throws Exception {
        Assert.assertEquals(0, MathTricks.calculateFibonacci(0));
        Assert.assertEquals(1, MathTricks.calculateFibonacci(1));
        Assert.assertEquals(8, MathTricks.calculateFibonacci(6));
        Assert.assertEquals(6765, MathTricks.calculateFibonacci(20));

    }

    @Test
    public void testIsPrime() {
        Assert.assertTrue(MathTricks.isPrime(3));
        Assert.assertTrue(MathTricks.isPrime(2));
        Assert.assertFalse(MathTricks.isPrime(6));
        Assert.assertFalse(MathTricks.isPrime(111));
        Assert.assertFalse(MathTricks.isPrime(1));
    }

}
