package one.types;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class TypesTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        System.out.println(Double.NaN > 1);
        System.out.println(Double.NaN == 1);
        System.out.println(Double.NaN < 1);
        System.out.println(Double.NaN == Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN == Double.POSITIVE_INFINITY);

        Method[] methods = Types.class.getDeclaredMethods();
        System.out.println("methods = " + Arrays.toString(methods));
        for (Method method : methods) {
            Object invoke = method.invoke(null);
            System.out.println("invoke = " + invoke);
        }
    }
}
