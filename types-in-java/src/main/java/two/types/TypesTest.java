package two.types;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class TypesTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        printInitialValues();
        printMinMaxValues();


    }

    public static void printInitialValues() throws InvocationTargetException, IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        Method[] methods = Types.class.getDeclaredMethods();
        stringBuilder.append("Initial values:\n");
        stringBuilder.append("-----------------------------------------------\n");
        for (Method method : methods) {
            Object invoke = method.invoke(null);
            stringBuilder.append(method.getName());
            stringBuilder.append(" = ");
            stringBuilder.append(invoke);
            stringBuilder.append("\n");
        }
        stringBuilder.append("-----------------------------------------------\n");
        System.out.println(stringBuilder);
    }

    public static void printMinMaxValues() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Min and Max values:\n");
        stringBuilder.append("-----------------------------------------------\n");
        //Byte
        stringBuilder.append("Max value for byte = ");
        stringBuilder.append(Byte.MAX_VALUE);
        stringBuilder.append("; Min value for byte = ");
        stringBuilder.append(Byte.MIN_VALUE);
        stringBuilder.append("\n");
        //Short
        stringBuilder.append("Max value for Short = ");
        stringBuilder.append(Short.MAX_VALUE);
        stringBuilder.append("; Min value for Short = ");
        stringBuilder.append(Short.MIN_VALUE);
        stringBuilder.append("\n");
        //Integer
        stringBuilder.append("Max value for Integer = ");
        stringBuilder.append(Integer.MAX_VALUE);
        stringBuilder.append("; Min value for Integer = ");
        stringBuilder.append(Integer.MIN_VALUE);
        stringBuilder.append("\n");
        //Long
        stringBuilder.append("Max value for Long = ");
        stringBuilder.append(Long.MAX_VALUE);
        stringBuilder.append("; Min value for Long = ");
        stringBuilder.append(Long.MIN_VALUE);
        stringBuilder.append("\n");
        //Float
        stringBuilder.append("Max value for Float = ");
        stringBuilder.append(Float.MAX_VALUE);
        stringBuilder.append("; Min value for Float = ");
        stringBuilder.append(Float.MIN_VALUE);
        stringBuilder.append("\n");
        //Double
        stringBuilder.append("Max value for Double = ");
        stringBuilder.append(Double.MAX_VALUE);
        stringBuilder.append("; Min value for Double = ");
        stringBuilder.append(Double.MIN_VALUE);
        stringBuilder.append("\n");
        //Character
        stringBuilder.append("Max value for Character = ");
        stringBuilder.append(Character.MAX_VALUE);
        stringBuilder.append("; Min value for Character = ");
        stringBuilder.append(Character.MIN_VALUE);
        stringBuilder.append("\n");
        stringBuilder.append("-----------------------------------------------\n");
        System.out.println(stringBuilder);
    }


}
