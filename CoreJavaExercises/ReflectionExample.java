// Q39: Reflection in Java
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {

    // A sample class to inspect at runtime
    static class Calculator {
        public int add(int a, int b) { return a + b; }
        public double multiply(double x, double y) { return x * y; }
        private String secret() { return "hidden!"; }
    }

    public static void main(String[] args) throws Exception {
        // Load the class dynamically
        Class<?> clazz = Class.forName("ReflectionExample$Calculator");
        System.out.println("Class: " + clazz.getName());

        // List all declared methods
        System.out.println("\nDeclared Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.print("  " + method.getReturnType().getSimpleName()
                    + " " + method.getName() + "(");
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getType().getSimpleName() + " " + params[i].getName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Invoke a method dynamically
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method addMethod = clazz.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(instance, 10, 20);
        System.out.println("\nDynamically invoked add(10, 20) = " + result);

        // Access private method using reflection
        Method secretMethod = clazz.getDeclaredMethod("secret");
        secretMethod.setAccessible(true);
        Object secret = secretMethod.invoke(instance);
        System.out.println("Private method secret() = " + secret);
    }
}
