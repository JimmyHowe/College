/**
 * Jimmy Howe
 * HNC Software Development
 * Assessment 1
 * <p>
 * Ticket Program
 * <p>
 * Finished 1-10-2015
 */

package com.jimmyhowe.hnc.introduction.Assessment1;

import java.util.Scanner;

/**
 * The Main Class
 */
public class Main
{
    /**
     * The Scanner Object for reading input from console
     */
    private static Scanner console = new Scanner(System.in);

    /**
     * The Exit Flag
     * <p>
     * The exit flag is used to tell the main loop that its time to exit
     * the loop, and exit the program, the default is set to false
     */
    private static boolean exitFlag = false;

    /**
     * The Main Program entry point.
     * <p>
     * Off we go...
     *
     * @param args
     */
    public static void main(String[] args)
    {
        /*
            Sets the standard ticket price
         */
        Ticket.setFee(50);

        /*
            This is the main program loop. we perform the following operations until
            option 4 is selected, when it is we set the exitFlag boolean to true,
            and that cancels the while loop thus ending the program.
         */

        do
        {
            printMenu(); // First print the menu

            System.out.print("\tPlease select an option: ");

            int menuSelection = console.nextInt(); // Read the menu selection

            // Fixes Scanner problem where it doesn't read the
            // newline from nextInt()
            console.nextLine();

            /*
                The switch statement: we want to choose a method based on what the user
                enters into the console, and show an error if the wrong option is entered
             */
            switch ( menuSelection )
            {
                case 1:
                    calculateStudentDiscount();
                    break;
                case 2:
                    calculateChildDiscount();
                    break;
                case 3:
                    displayTicketPrice();
                    break;
                case 4:
                    exitFlag = true;
                    sayGoodbye();
                default:
                    showError("Please choose options 1 - 4");
            }

        } while ( ! exitFlag ); // do while the exit flag is NOT true, eg false
    }

    /**
     * Calculate Student Discount
     * <p>
     * This method will allow the student discount to be set if they are
     * a student
     */
    private static void calculateStudentDiscount()
    {
        // Is the user a student?
        String answer = askYesNo("Are you a student?");

        // what did they answer?
        if ( isYes(answer) )
        {

            // YES: bump student discount
            Ticket.setStudentDiscount(15);

        } else
        {

            // NO: student discount to 0
            Ticket.setStudentDiscount(0);
        }

        // print out results
        System.out.printf("\n\tStudent Discount Set to %.2f%%\n", Ticket.getStudentDiscount());
        printBlankLine();
    }

    /**
     * Calculate Child Discount
     * <p>
     * This method will allow the child discount to be set if they are
     * a child
     */
    private static void calculateChildDiscount()
    {
        // Is the user a child?
        String answer = askYesNo("Are you a child under 16 years?");

        // what did the answer?
        if ( isYes(answer) )
        {

            // bump child discount
            Ticket.setChildDiscount(25);

        } else
        {

            // set discount to 0
            Ticket.setChildDiscount(0);
        }

        // print out results
        System.out.printf("\n\tChild Discount Set to %.2f%%\n", Ticket.getChildDiscount());
        printBlankLine();
    }

    /**
     * Display Ticket Price
     * <p>
     * This method will take the users names and address and print
     * out the ticket details
     */
    private static void displayTicketPrice()
    {
        /*
            Ask for the first & last name and address, and store them in the static Ticket object.
            We use the askFor utility method to print out the question, get the answer and return
            as a string which is then passed to the setter method on the static Ticket class
         */
        Ticket.setFirstName(askFor("first name"));
        Ticket.setLastName(askFor("last name"));
        Ticket.setAddress(askFor("address"));

        printBlankLine();

        /*
            First we workout the calculated amounts for the prices using the data stored in
            the static Ticket class.
         */

        double calculatedStudentDiscount = Ticket.getFee() * Ticket.getStudentDiscount() / 100;
        double calculatedStudentFee = Ticket.getFee() - calculatedStudentDiscount;

        double calculatedChildDiscount = Ticket.getFee() * Ticket.getChildDiscount() / 100;
        double calculatedChildFee = Ticket.getFee() - calculatedChildDiscount;

        /*
            Then we print the results to the screen
         */

        System.out.printf("Your details: %s %s\n", Ticket.getFirstName(), Ticket.getLastName());
        System.out.printf("Address: %s\n", Ticket.getAddress());

        System.out.printf("Normal Fees with no discount are: %.2f\n", Ticket.getFee());
        System.out.printf("Student discount = %.2f pounds, Student total fee due: %.2f pounds\n", calculatedStudentDiscount, calculatedStudentFee);
        System.out.printf("Child discount = %.2f pounds, Child total fee due: %.2f pounds\n", calculatedChildDiscount, calculatedChildFee);

        printBlankLine();
    }

    /**
     * Print Menu
     * <p>
     * Prints the main menu using the utility methods to clean up the program
     */
    private static void printMenu()
    {
        printHeader("MENU For Anniesland Commonwealth Games Ticket Enquiry Centre");
        printBlankLine();
        printMenuOption(1, "Calculate Student Discount");
        printMenuOption(2, "Calculate Child Discount");
        printMenuOption(3, "Display Ticket Price");
        printMenuOption(4, "Exit Menu");
        printBlankLine();
    }

    /**
     * UTILITY: Print Header
     * <p>
     * Prints a fancy header surrounded by stars
     *
     * @param headerText
     */
    public static void printHeader(String headerText)
    {
        String[] headerRows = { "", "" }; // The top and bottom row of stars

        String headerChar = "*";

        String formattedText = "%s %s %s\n"; // the middle row formatted text

        int padding = 4;

        /*
            Build the top and bottom rows by adding the length of the header text to the padding,
            and on each iteration, concatenating the header row with itself, adding the header
            character
         */

        for ( int i = 0; i < headerText.length() + padding; i++ )
        {

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
    public static void printMenuOption(int number, String text)
    {
        System.out.printf("\t%s\t%s\n", number, text);
    }

    /**
     * UTILITY: Print Blank Line
     * <p>
     * Prints a blank line to the console
     */
    private static void printBlankLine()
    {
        System.out.print('\n');

    }

    /**
     * UTILITY: Show Error
     * <p>
     * Prints a formatted error to the console
     *
     * @param text
     */
    private static void showError(String text)
    {
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
    public static String askYesNo(String question)
    {
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
    public static String askFor(String context)
    {
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
    public static boolean isYes(String answer)
    {
        String[] possibleYesAnswers = { "y", "yes", "true" };

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
    private static void sayGoodbye()
    {
        printBlankLine();
        printHeader("Bye Bye");

        System.exit(0);
    }
}
