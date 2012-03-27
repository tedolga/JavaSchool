package one.cmd;

import one.cmd.subpacage.SubPackageClass;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello " + SubPackageClass.NAME + "!");
        System.out.println(System.getProperty("test"));
        System.out.println("args = " + Arrays.toString(args));
    }
}