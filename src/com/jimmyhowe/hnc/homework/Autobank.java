package com.jimmyhowe.hnc.homework;

import java.util.Scanner;

/**
 * Created by Jimmy on 27/04/2016.
 */
public class Autobank
{
    static Scanner console = new Scanner(System.in);

    static float balance = 250;

    float total = 0;

    public static void main(String[] args)
    {
        String PIN = askFor("PIN");

        printMenu();

        int menuSelection = console.nextInt();

        switch (menuSelection) {
            case 1:
                displayBalance();
                break;
            case 2:
                withdrawAmount();
                break;
            case 3:
                sayGoodbye();
            default:
                showError("Please choose options 1 - 3");
        }
    }

    private static void displayBalance()
    {
        System.out.println("Balance is...");
        System.out.println(balance);
    }

    private static void withdrawAmount()
    {
        System.out.println("Enter the amount you wish to withdraw...");

        float amount = console.nextFloat();

        if(amount > balance)
        {
            System.out.println("Insufficient Funds!");

            return;
        }

        balance -= amount;

        System.out.println("Your new balance is ");
        System.out.println(balance);

        return;
    }

    /**
     * Print Menu
     * <p>
     * Prints the main menu using the utility methods to clean up the program
     */
    private static void printMenu() {

        printHeader("AutoBank");
        printBlankLine();
        printMenuOption(1, "Display Balance");
        printMenuOption(2, "Withdraw Amount");
        printBlankLine();

    }

    /**
     * UTILITY: Print Header
     * <p>
     * Prints a fancy header surrounded by stars
     *
     * @param headerText
     */
    public static void printHeader(String headerText) {

        String[] headerRows = {"", ""}; // The top and bottom row of stars

        String headerChar = "*";

        String formattedText = "%s %s %s\n"; // the middle row formatted text

        int padding = 4;

        /*
            Build the top and bottom rows by adding the length of the header text to the padding,
            and on each iteration, concatenating the header row with itself, adding the header
            character
         */

        for (int i = 0; i < headerText.length() + padding; i++) {

            headerRows[0] += headerChar;
            headerRows[1] += headerChar;
        }

        // Print out the header rows in order

        System.out.println(headerRows[0]);
        System.out.printf(formattedText, headerChar, headerText, headerChar);
        System.out.println(headerRows[1]);

    }

    /**
     * UTILITY: Print Menu Option
     * <p>
     * Prints a formatted Menu Option
     *
     * @param number
     * @param text
     */
    public static void printMenuOption(int number, String text) {

        System.out.printf("\t%s\t%s\n", number, text);

    }

    /**
     * UTILITY: Print Blank Line
     * <p>
     * Prints a blank line to the console
     */
    private static void printBlankLine() {

        System.out.print('\n');

    }

    /**
     * UTILITY: Show Error
     * <p>
     * Prints a formatted error to the console
     *
     * @param text
     */
    private static void showError(String text) {

        String formattedErrorText = "\t!!! %s !!!\n";

        printBlankLine();
        System.out.printf(formattedErrorText, text);
        printBlankLine();
        System.out.print("\tPress ENTER to return!");
        console.nextLine();
        printBlankLine();
    }

    /**
     * UTILITY: Ask Yes/No
     * <p>
     * Print a yes/no message to the screen and return the response
     *
     * @param question
     * @return
     */
    public static String askYesNo(String question) {

        String formattedText = "\n\t%s (y/n): ";

        System.out.printf(formattedText, question);

        return console.nextLine();
    }

    /**
     * UTILITY: Ask For
     * <p>
     * Print a message to the screen using the passed context string
     * and return a string reply
     *
     * @param context
     * @return
     */
    public static String askFor(String context) {

        String formattedText = "\n\tPlease enter your %s: ";

        System.out.printf(formattedText, context);

        return console.nextLine();
    }

    /**
     * UTILITY: Is Yes
     * <p>
     * This will take a string, and check if it matches y, yes, or true
     * and if it does it will return true and if not return false.
     *
     * @param answer
     * @return
     */
    public static boolean isYes(String answer) {

        String[] possibleYesAnswers = {"y", "yes", "true"};

        for ( String possibleYesAnswer : possibleYesAnswers )
        {
            if ( answer.toLowerCase().equals(possibleYesAnswer) )
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Say Goodbye
     * <p>
     * Exits the Program
     */
    private static void sayGoodbye() {

        printBlankLine();
        printHeader("Bye Bye");

        System.exit(0);
    }
}
