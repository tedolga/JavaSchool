package two.constructors;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class C extends A {
    public Logger field = new Logger("C.field");
    public static Logger CONSTANT = new Logger("C.CONSTANT");

    {
        System.out.println("C.block - 1");
    }

    {
        System.out.println("C.block - 2");
    }

    static {
        System.out.println("C.block - static");
    }

    public C() {
        System.out.println("C.constructor");
    }

    public static final String ANOTHER_CONSTANT = "C.constant";
}

