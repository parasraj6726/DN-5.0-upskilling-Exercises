// Q29: Records (Java 16+)
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecordsExample {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 25);
        Person p4 = new Person("Diana", 15);

        System.out.println("All persons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        List<Person> people = Arrays.asList(p1, p2, p3, p4);
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
