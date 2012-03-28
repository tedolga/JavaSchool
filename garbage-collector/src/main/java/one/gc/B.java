package one.gc;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class B {
    public B() {

    }

    public static void main(String[] args) {
        A a = createA();
        a = null;
        System.gc();
        createA();
        System.gc();
    }

    public static A createA() {
        return new A();
    }
}
