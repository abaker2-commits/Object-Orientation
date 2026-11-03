import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * LoopContrl
 * A menu-driven program that lets the user enter two numbers (x and y)
 * and then print the numbers between them, find their average,
 * or list the prime numbers between them.
 * Note: "between x and y" is treated as inclusive (x and y are included).
 * If x is greater than y, the range is handled from the smaller to the larger.
 */
public class LoopContrl {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int x = 0;
            int y = 0;
            boolean numbersEntered = false;
            int choice;

            try {
                do {
                    printMenu();
                    choice = readInt(input, "Enter your choice (1-5): ");

                    switch (choice) {
                        case 1:
                            x = readInt(input, "Enter x: ");
                            y = readInt(input, "Enter y: ");
                            numbersEntered = true;
                            break;

                        case 2:
                            if (checkEntered(numbersEntered)) {
                                printNumbers(x, y);
                            }
                            break;

                        case 3:
                            if (checkEntered(numbersEntered)) {
                                System.out.printf("The average of all numbers between %d and %d is %.2f%n",
                                        x, y, findAverage(x, y));
                            }
                            break;

                        case 4:
                            if (checkEntered(numbersEntered)) {
                                printPrimes(x, y);
                            }
                            break;

                        case 5:
                            System.out.println("Goodbye!");
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    }
                    System.out.println();
                } while (choice != 5);
            } catch (NoSuchElementException e) {
                System.out.println("\nInput ended. Goodbye!");
            }
        }
    }

    // Prints the menu options
    public static void printMenu() {
        System.out.println("========== MENU STEPS ==========");
        System.out.println("1 - Enter two (2) numbers (x and y).");
        System.out.println("2 - Print all numbers between x and y.");
        System.out.println("3 - Find the average of all numbers between x and y.");
        System.out.println("4 - Find all prime numbers between x and y.");
        System.out.println("5 - Exit");
        System.out.println("==========================");
    }

    // Reads an integer, re-prompting until the user enters a valid one
    public static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            if (!input.hasNext()) {
                throw new NoSuchElementException("Input ended while reading an integer.");
            }
            System.out.println("That is not a whole number. Please try again.");
            input.next(); // discard the bad input
        }
    }

    // Makes sure option 1 was used before options 2-4
    public static boolean checkEntered(boolean numbersEntered) {
        if (!numbersEntered) {
            System.out.println("Please choose option 1 to enter x and y first.");
        }
        return numbersEntered;
    }

    // Option 2: print every number from the smaller value to the larger value
    public static void printNumbers(int x, int y) {
        int low = Math.min(x, y);
        int high = Math.max(x, y);

        System.out.print("Numbers between " + x + " and " + y + ": ");
        for (long i = low; i <= high; i++) {
            System.out.print(i);
            if (i < high) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("You have completed the task.");
    }

    // Option 3: average of every number in the range
    public static double findAverage(int x, int y) {
        int low = Math.min(x, y);
        int high = Math.max(x, y);
        return ((long) low + high) / 2.0;
    }

    // Option 4: print every prime number in the range
    public static void printPrimes(int x, int y) {
        int low = Math.min(x, y);
        int high = Math.max(x, y);
        boolean found = false;

        System.out.print("Prime numbers between " + x + " and " + y + ": ");
        for (long i = low; i <= high; i++) {
            if (isPrime((int) i)) {
                if (found) {
                    System.out.print(", ");
                }
                System.out.print(i);
                found = true;
            }
        }
        if (!found) {
            System.out.print("none");
        }
        System.out.println();
    }

    // Returns true if n is a prime number
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
