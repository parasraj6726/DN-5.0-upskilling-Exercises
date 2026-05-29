// Q22: File Writing
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to write to file: ");
        String text = sc.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(text);
            System.out.println("Data successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        sc.close();
    }
}
