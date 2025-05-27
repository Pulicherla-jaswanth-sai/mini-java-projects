import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        do {
            int targetNumber = rand.nextInt(100) + 1; // Random number between 1 and 100
            int guess;
            int attempts = 0;

            System.out.println("\nI've picked a number between 1 and 100. Try to guess it!");

            while (true) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " tries.");
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            sc.nextLine(); // consume newline
            playAgain = sc.nextLine().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("👋 Thanks for playing! Goodbye!");
        sc.close();
    }
}