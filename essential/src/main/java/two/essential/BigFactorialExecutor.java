package two.essential;

import java.math.BigDecimal;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BigFactorialExecutor {

    public static int calculateZerosInFactorial(int number) {
        BigDecimal result = BigDecimal.ONE;
        int countOfZeros = 0;
        for (int i = 1; i <= number; i++) {
            result = result.multiply(new BigDecimal(i));
            while (result.remainder(BigDecimal.TEN).equals(BigDecimal.ZERO)) {
                result = result.divide(BigDecimal.TEN);
                countOfZeros += 1;
            }
        }
        return countOfZeros;
    }

    public static BigDecimal calculateFactorial(int number) {

        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= number; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }
}
