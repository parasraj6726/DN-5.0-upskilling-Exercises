// Q38: Decompile a Class File
//
// Instructions:
// 1. Compile this file: javac DecompileDemo.java
// 2. Decompile using one of:
//    a) CFR (recommended, free CLI tool):
//       java -jar cfr.jar DecompileDemo.class
//    b) JD-GUI (GUI tool):
//       Open DecompileDemo.class in JD-GUI
//    c) Built-in javap (limited):
//       javap -p -c DecompileDemo
//
// Download CFR: https://github.com/leibnitz27/cfr/releases
//
// The decompiler will reconstruct the source code from bytecode.
// Notice how inner classes, lambdas, and string concatenation
// appear in the decompiled output.

import java.util.Arrays;
import java.util.List;

public class DecompileDemo {

    private String name;
    private int value;

    public DecompileDemo(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return "DecompileDemo{name='" + name + "', value=" + value + "}";
    }

    public static void main(String[] args) {
        DecompileDemo obj = new DecompileDemo("Test", 42);
        System.out.println(obj);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
