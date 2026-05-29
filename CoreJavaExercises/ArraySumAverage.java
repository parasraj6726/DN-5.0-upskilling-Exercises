// Q14: Array Sum and Average
import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }

        double sum = 0;
        for (double val : arr) sum += val;
        double average = sum / n;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        sc.close();
    }
}
