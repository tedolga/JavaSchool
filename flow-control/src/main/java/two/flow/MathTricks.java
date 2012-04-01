package two.flow;


import java.util.BitSet;

/**
 * Is aimed to calculate some math functions
 *
 * @author O. Tedikova
 * @version 1.0
 */
public class MathTricks {

    public static long calculatePrimeInnocent(int number) {
        checkValue(number, "parameter should not be smaller than 2", 2);
        while (!isPrime(number)) {
            number -= 1;
        }
        return number;
    }

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


    public static int calculateBinomial(int n, int k) {
        checkNatural(n);
        checkNatural(k);
        checkValue(n, "parameter shouldn't be smaller", k);
        return calculateFactorial(n) / (calculateFactorial(k) * calculateFactorial(n - k));

    }

    public static int calculateFibonacci(int n) {
        checkValue(n, "parameter should not be smaller", 0);
        return calculateFibonacci1(n);
    }

    private static int calculateFibonacci1(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

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

    public static int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static void checkNatural(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format("Received %d, but parameter should be natural number", number));
        }
    }

    private static void checkValue(int value, String message, int expected) {
        if (value < expected) {
            throw new IllegalArgumentException(String.format("Received %d, %s", value, message));
        }
    }

}
