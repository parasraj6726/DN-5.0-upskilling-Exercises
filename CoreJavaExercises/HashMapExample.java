// Q25: HashMap Example
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Add students (enter 0 as ID to stop):");
        while (true) {
            System.out.print("Student ID: ");
            int id = sc.nextInt();
            if (id == 0) break;
            sc.nextLine();
            System.out.print("Student Name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("\nEnter ID to look up: ");
        int searchId = sc.nextInt();
        String found = studentMap.get(searchId);
        if (found != null)
            System.out.println("Student found: " + found);
        else
            System.out.println("No student found with ID " + searchId);
        sc.close();
    }
}
