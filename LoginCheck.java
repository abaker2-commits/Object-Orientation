/*
 * LoginCheck.java
 * CS 3700 - Module 4 Assignment 2: JOptionPane
 * Author: Andrea Baker
 *
 * This program asks for a username and a password using JOptionPane dialogs.
 * It compares them to the correct values and shows the result in a dialog.
 */
import javax.swing.JOptionPane;

public class LoginCheck {

    // ----- Constants: the correct login values -----
    // final means these values cannot change while the program runs.
    private static final String CORRECT_USERNAME = "Hero";
    private static final String CORRECT_PASSWORD = "Zero";

    public static void main(String[] args) {

        // ----- Step 1: ask for the username -----
        // showInputDialog returns the text typed, or null if the user clicks Cancel.
        String enteredUsername = JOptionPane.showInputDialog(
                null, "Enter your username:", "Login", JOptionPane.QUESTION_MESSAGE);

        // ----- Step 2: ask for the password -----
        String enteredPassword = JOptionPane.showInputDialog(
                null, "Enter your password:", "Login", JOptionPane.QUESTION_MESSAGE);

        // ----- Step 3: compare the input to the correct values -----
        // equals() compares the text inside the Strings. Using == would compare
        // memory locations instead, which is a common mistake.
        // Calling equals() on the constant avoids an error if the input is null.
        boolean usernameMatches = CORRECT_USERNAME.equals(enteredUsername);
        boolean passwordMatches = CORRECT_PASSWORD.equals(enteredPassword);

        // ----- Step 4: show the result -----
        // Both values must match for access to be granted.
        if (usernameMatches && passwordMatches) {
            JOptionPane.showMessageDialog(
                    null, "Access Granted", "Login Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null, "Incorrect Credentials", "Login Result", JOptionPane.ERROR_MESSAGE);
        }
    }
}
