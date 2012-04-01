package two.flow;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class MathFunctionsExecutor {
    public static void main(String[] args) {
        if ("prime".equalsIgnoreCase(args[0])) {
            System.out.println(MathTricks.calculatePrimeInnocent(Integer.parseInt(args[1])));
        }
        if ("binomial".equalsIgnoreCase(args[0])) {
            System.out.println(MathTricks.calculateBinomial(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        }
        if ("Fibonacci".equalsIgnoreCase(args[0])) {
            System.out.println(MathTricks.calculateFibonacci(Integer.parseInt(args[1])));
        }
    }


}
