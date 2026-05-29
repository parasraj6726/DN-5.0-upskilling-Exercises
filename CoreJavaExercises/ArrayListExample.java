// Q24: ArrayList Example
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student names (type 'done' to stop):");
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) break;
            names.add(name);
        }

        System.out.println("\nAll student names:");
        for (String name : names) {
            System.out.println("- " + name);
        }
        sc.close();
    }
}
