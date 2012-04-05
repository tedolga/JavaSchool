package two.flow;


import java.util.BitSet;

/**
 * Is aimed to calculate some math functions
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class MathTricks {

    /**
     * Method calculates the highest prime number, which is not bigger than given number.
     * Uses innocent algorithm
     *
     * @param number given number
     * @return highest prime number, which is not bigger than given number
     * @throws IllegalArgumentException in case if number is smaller than 2
     */
    public static long calculatePrimeInnocent(int number) {
        checkValue(number, "parameter should not be smaller than 2", 2);
        while (!isPrime(number)) {
            number -= 1;
        }
        return number;
    }

    /**
     * Method calculates the highest prime number, which is not bigger than given number.
     * Uses sieve of Eratosthenes
     *
     * @param number number given number
     * @return highest prime number, which is not bigger than given number
     * @throws IllegalArgumentException in case if number is smaller than 2
     */
    public static int calculatePrimeAdvanced(int number) {
        checkNatural(number);
        checkValue(number, "parameter should not be smaller than 2", 2);

        BitSet bitSet = new BitSet(number + 1);
        bitSet.set(2, number + 1, true);
        int prime = 2;
        while (prime < number) {
            if (prime <= Math.sqrt(number)) {
                int k = prime * prime;
                while (k <= number) {
                    bitSet.set(k, false);
                    k += prime;
                }
            }
            int nextBit = bitSet.nextSetBit(prime + 1);
            if (nextBit == -1) {
                break;
            }
            prime = nextBit;
        }
        return prime;
    }

    /**
     * Calculates number of combinations of n elements k at a time
     *
     * @param n full number of elements
     * @param k count of elements in combination
     * @return number of combinations of n elements k at a time
     * @throws IllegalArgumentException if n<1 or k<1 or n<k
     */
    public static int calculateBinomial(int n, int k) {
        checkNatural(n);
        checkNatural(k);
        checkValue(n, "parameter shouldn't be smaller", k);
        return calculateFactorial(n) / (calculateFactorial(k) * calculateFactorial(n - k));

    }

    /**
     * Calculates then the program must calculate n-th term of Fibonacci series
     *
     * @param n number of Fibonacci series
     * @return value of n-th term of Fibonacci series
     * @throws IllegalArgumentException in case when n is smaller than 0
     */
    public static int calculateFibonacci(int n) {
        checkValue(n, "parameter should not be smaller", 0);
        return calculateFibonacci1(n);
    }

    /**
     * Calculates then the program must calculate n-th term of Fibonacci series
     *
     * @param n number of Fibonacci series
     * @return value of n-th term of Fibonacci series
     */
    private static int calculateFibonacci1(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    /**
     * Checks if given number is prime
     *
     * @param number given number
     * @return true if given number is prime or false in other case
     * @throws IllegalArgumentException if given number is not natural
     */
    public static boolean isPrime(int number) {
        checkNatural(number);
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates factorial of the given number
     *
     * @param number given number
     * @return factorial of the given number
     */
    private static int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Checks if given number is natural
     *
     * @param number given number
     * @throws IllegalArgumentException if given number is not natural
     */
    private static void checkNatural(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format("Received %d, but parameter should be natural number", number));
        }
    }

    /**
     * Checks if given value is less than expected
     *
     * @param value    given value
     * @param message  error message
     * @param expected expected value
     * @throws IllegalArgumentException in case if given value is less than expected
     */
    private static void checkValue(int value, String message, int expected) {
        if (value < expected) {
            throw new IllegalArgumentException(String.format("Received %d, %s", value, message));
        }
    }

}
