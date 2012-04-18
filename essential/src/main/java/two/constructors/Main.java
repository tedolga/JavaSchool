package two.constructors;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        A a = new B();
        a.method();
        C c = null;
        System.out.println(C.ANOTHER_CONSTANT);
    }
}

