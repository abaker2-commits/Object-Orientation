/* multiUse.java
 * CS 3700 - Promotion, Casting, and Overloading | Andrea Baker
 *
 * This program shows one method name, multiUse, doing three jobs.
 * Java picks the right version based on how many arguments are passed.
 * It also shows argument promotion (int to double) and casting (double to int).
 */

class MultiUse {

    // ----- Version 1: one int parameter -----
    // Prints every number from 1 up to n on one line.
    public static void multiUse(int n) {
        if (n < 1) {
            System.out.println("Nothing to print. The number must be 1 or more.");
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // ----- Version 2: two parameters -----
    // Returns the average of two numbers.
    // The parameters are double, so int arguments are promoted to double.
    // This keeps the decimal part, so the average of 3 and 4 is 3.5, not 3.

    public static double multiUse(double a, double b) {
        return (a + b) / 2.0;
    }

    // ----- Version 3: three parameters -----
    // Returns the largest of three numbers.
    // Math.max compares two values at a time.

    public static double multiUse(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    // ----- Main method: demonstrates each version -----

    public static void main(String[] args) {

        // Section 1: one argument prints a count

        System.out.println("1) multiUse(5) prints 1 to 5:");
        multiUse(5);

        // Section 2: casting a double to an int before the call
        // 7.9 is a double. The (int) cast drops the decimal, so 7 is passed.

        double rawValue = 7.9;
        System.out.println("\n2) multiUse((int) 7.9) casts 7.9 down to 7:");
        multiUse((int) rawValue);

        // Section 3: two int arguments are promoted to double

        int x = 3;
        int y = 4;
        System.out.println("\n3) multiUse(3, 4) average (ints promoted to double): "
                + multiUse(x, y));

        // Section 4: two double arguments, no promotion needed

        System.out.println("\n4) multiUse(10.5, 20.25) average: "
                + multiUse(10.5, 20.25));

        // Section 5: casting the average result back to an int
        // The cast cuts off the decimal. It does not round.

        int wholeAverage = (int) multiUse(x, y);
        System.out.println("\n5) (int) multiUse(3, 4) cast to int: " + wholeAverage);

        // Section 6: three arguments find the maximum
        // Mixed int and double arguments. The ints are promoted to double.

        System.out.println("\n6) multiUse(12, 45.5, 30) maximum: "
                + multiUse(12, 45.5, 30));

        // Section 7: three ints, result cast back to int for clean output
        
        System.out.println("\n7) (int) multiUse(8, 2, 6) maximum as int: "
                + (int) multiUse(8, 2, 6));
    }
