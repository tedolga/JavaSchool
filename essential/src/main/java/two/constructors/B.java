package two.constructors;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class B extends A {
    public Logger field = new Logger("B.field");
    public static Logger CONSTANT = new Logger("B.CONSTANT");

    {
        System.out.println("B.block");
    }

    {
        System.out.println("B.anotherBlock ");
    }

    static {
        System.out.println("B.block - static");
    }

    public B() {
        System.out.println("B.constructor");
    }

    public void method() {
        super.method();
        System.out.println("B.method");
    }
}

