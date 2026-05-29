// Q10: Number Guessing Game
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100!");
        do {
            System.out.print("Your guess: ");
            guess = sc.nextInt();
            attempts++;
            if (guess < target)
                System.out.println("Too low! Try again.");
            else if (guess > target)
                System.out.println("Too high! Try again.");
            else
                System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
        } while (guess != target);
        sc.close();
    }
}
