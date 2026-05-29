// Q37: Using javap to Inspect Bytecode
//
// Step 1: Compile this file
//   javac BytecodeInspect.java
//
// Step 2: Inspect with javap
//   javap BytecodeInspect          <- shows method signatures
//   javap -c BytecodeInspect       <- shows bytecode instructions
//   javap -verbose BytecodeInspect <- shows full class file info
//
// Sample javap -c output explanation is in the comments below.

public class BytecodeInspect {

    public int add(int a, int b) {
        return a + b;
    }

    public String greet(String name) {
        return "Hello, " + name;
    }

    public static void main(String[] args) {
        BytecodeInspect obj = new BytecodeInspect();
        System.out.println(obj.add(3, 4));
        System.out.println(obj.greet("Java"));

        // After compiling, run: javap -c BytecodeInspect
        // You will see instructions like:
        //   iload_1    <- load int variable from slot 1
        //   iload_2    <- load int variable from slot 2
        //   iadd       <- integer add
        //   ireturn    <- return int result
    }
}
