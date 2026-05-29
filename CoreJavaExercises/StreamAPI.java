// Q28: Stream API
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                              11, 12, 13, 14, 15, 20, 25, 30);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Original list: " + numbers);
        System.out.println("Even numbers:  " + evenNumbers);

        // Bonus: sum of even numbers using streams
        int sum = evenNumbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers: " + sum);
    }
}
