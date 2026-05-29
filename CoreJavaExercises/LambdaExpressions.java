// Q27: Lambda Expressions
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zebra", "Apple", "Mango", "Banana", "Cherry");

        System.out.println("Before sorting: " + names);
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("After sorting (A-Z): " + names);

        // Sort in reverse using lambda
        names.sort((a, b) -> b.compareTo(a));
        System.out.println("After sorting (Z-A): " + names);
    }
}
