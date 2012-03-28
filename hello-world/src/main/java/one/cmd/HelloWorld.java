package one.cmd;

import one.cmd.subpackage.SubPackageClass;

/**
 * This class is aimed to print hello messages and first three command-line parameters.
 * For example
 * <pre>java one.cmd.HelloWorld 2 w 4</pre>
 * we have outputed:
 * <ul>
 * <li>2</li>
 * <li>w</li>
 * <li>4</li>
 * </ul>
 * <strong>Note:</strong>
 * <pre>javadoc -author -private -version -d target/javadoc -sourcepath src/main/java one.cmd</pre>
 *
 * @author Tedikova O.
 * @version 0.1
 * @see SubPackageClass#NAME
 */
public class HelloWorld {

    /**
     * Count of expected command-line parameters
     */
    private static final int COUNT = 3;

    public static void main(String[] args) {
        System.out.print(sayHelloToSomebody(SubPackageClass.NAME));
        System.out.println(PackageClass.HELLO_PHRASE);
        try {
            printSomeElements(args, COUNT);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("You should enter at least" + COUNT + " command line parameters");
        }
    }

    /**
     * Methods builds hello string to specified {@code person}.
     *
     * @param person to whom you want to say hello.
     * @return string with hello message.
     */
    private static String sayHelloToSomebody(String person) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello ");
        builder.append(person);
        builder.append("\n");
        return builder.toString();
    }

    /**
     * Method prints to the output specified count of array {@code elements}.
     *
     * @param elements array, which elements you want to print.
     * @param count    of elements you want to print.
     * @throws ArrayIndexOutOfBoundsException in case if count of element in array is less than {@code count}s parameter.
     */
    private static void printSomeElements(String[] elements, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("[" + i + "] = " + elements[i]);
        }
    }
}