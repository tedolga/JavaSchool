package one.cmd;

import one.cmd.subpackage.SubPackageClass;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello " + SubPackageClass.NAME + "!");
        System.out.println(PackageClass.HELLO_PHRASE);
        System.out.println("args = " + Arrays.toString(args));
    }


}