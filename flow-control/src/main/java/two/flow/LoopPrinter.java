package two.flow;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class LoopPrinter {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (double i = 0; i < 10; i += 0.1) {
            builder.append("i = ");
            builder.append(i);
            builder.append("\n");
            builder.append("binary i = ");
            builder.append(Long.toBinaryString(Double.doubleToRawLongBits(i)));
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
