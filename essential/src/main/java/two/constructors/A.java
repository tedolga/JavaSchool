package two.constructors;


/**
 * @author Tedikova O.
 * @version 1.0
 */
public class A {
    public Logger field = new Logger("A.field");
    public static Logger CONSTANT = new Logger("A.CONSTANT");

    {
        System.out.println("A.block");
    }

    static {
        System.out.println("A.block - static");
    }

    public A() {
        System.out.println("A.constructor");
    }

    public void method() {
        System.out.println("A.method");
    }
}

