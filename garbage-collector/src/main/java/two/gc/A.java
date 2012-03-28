package two.gc;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class A {

    public A() {

    }

    @Override
    public void finalize() {
        System.out.println("A.finalize");
    }
}
