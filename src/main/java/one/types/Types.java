package one.types;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class Types {
    //primitive class members
    private static byte primitiveByte;
    private static short primitiveShort;
    private static int primitiveInt;
    private static long primitiveLong;
    private static float primitiveFloat;
    private static double primitiveDouble;
    private static char primitiveChar;
    private static boolean primitiveBoolean;

    //wrappers
    private static Byte wrappedByte;
    private static Short wrappedShort;
    private static Integer wrappedInt;
    private static Long wrappedLong;
    private static Float wrappedFloat;
    private static Double wrappedDouble;
    private static Character wrappedChar;
    private static Boolean wrappedBoolean;

    public Types() {

    }

    public static byte getPrimitiveByte() {
        return primitiveByte;
    }

    public static short getPrimitiveShort() {
        return primitiveShort;
    }

    public static int getPrimitiveInt() {
        return primitiveInt;
    }

    public static long getPrimitiveLong() {
        return primitiveLong;
    }

    public static float getPrimitiveFloat() {
        return primitiveFloat;
    }

    public static double getPrimitiveDouble() {
        return primitiveDouble;
    }

    public static char getPrimitiveChar() {
        return primitiveChar;
    }

    public static boolean isPrimitiveBoolean() {
        return primitiveBoolean;
    }

    public static Byte getWrappedByte() {
        return wrappedByte;
    }

    public static Short getWrappedShort() {
        return wrappedShort;
    }

    public static Integer getWrappedInt() {
        return wrappedInt;
    }

    public static Long getWrappedLong() {
        return wrappedLong;
    }

    public static Float getWrappedFloat() {
        return wrappedFloat;
    }

    public static Double getWrappedDouble() {
        return wrappedDouble;
    }

    public static Character getWrappedChar() {
        return wrappedChar;
    }

    public static Boolean getWrappedBoolean() {
        return wrappedBoolean;
    }
}
