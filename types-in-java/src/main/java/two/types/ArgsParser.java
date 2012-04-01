package two.types;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class ArgsParser {

    public static void main(String[] args) {
        try {
            Byte.parseByte(args[0]);
        } catch (NumberFormatException nfe) {
            handleError(args[0], "Byte");
        }
        try {
            Short.parseShort(args[0]);
        } catch (NumberFormatException nfe) {
            handleError(args[0], "Short");
        }
        try {
            Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            handleError(args[0], "Integer");
        }
        try {
            Float.parseFloat(args[0]);
        } catch (NumberFormatException nfe) {
            handleError(args[0], "Float");
        }
        try {
            Double.parseDouble(args[0]);
        } catch (NumberFormatException nfe) {
            handleError(args[0], "Double");
        }
    }

    private static void handleError(String value, String type) {
        System.err.println("The value " + value + " cannot be convert to " + type);
    }

}
