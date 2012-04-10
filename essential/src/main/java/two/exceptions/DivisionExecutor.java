package two.exceptions;

import java.util.Random;

/**
 * Is aimed to divide 2 integers
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class DivisionExecutor {

    private static int COUNT_OF_PARAMETERS = 1000;

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < COUNT_OF_PARAMETERS; i++) {
            try {
                Integer dividend = random.nextInt();
                Integer divisor = random.nextInt();
                System.out.println(String.format("%d/%d = %d", dividend, divisor, divide(dividend, divisor)));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Divides {@code dividend} on {@code divisor}
     *
     * @param dividend integer which should be divided
     * @param divisor  integer which should be divisor
     * @return integer result of division
     * @throws IllegalArgumentException in case when {@code divisor} equals to {@literal 0}
     */
    public static Integer divide(Integer dividend, Integer divisor) {
        checkDivisor(divisor);
        return dividend / divisor;
    }

    /**
     * Checks if {@code divisor} doesn't equal to {@literal 0}.
     *
     * @param divisor checked parameter
     * @throws IllegalArgumentException in case when {@code divisor} equals to {@literal 0}
     */
    private static void checkDivisor(Integer divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor mustn't be 0!");
        }
    }
}
