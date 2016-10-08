/*
    Jimmy Howe
    Programming Fundamentals
    Assessment 3
 */

package com.jimmyhowe.hnc.fundamentals.Assessment3;

import java.util.Scanner;

public class Main
{
    static Scanner console = new Scanner(System.in);

    static String shortName =  "";

    public static void main(String[] args)
    {
        String fullName = askFor("Full Name");

        shortName = getShortName(fullName);

        System.out.println("\n\tNew string is... " + shortName);
    }

    /**
     * Gets the Short Name from the Full Name
     *
     * @param fullName
     * @return
     */
    private static String getShortName(String fullName)
    {
        // Get the position of the last name
        int lastNameIndex = fullName.indexOf(' ') + 1;

        // append to shortName the first segment
        shortName += getFirstSegmentOfName(fullName);
        // append to shortName the last segment
        shortName += getLastSegmentOfName(fullName, lastNameIndex);

        return shortName;
    }

    /**
     * Returns the First Segment of the Full name
     *
     * This method gets the first character of the first name,
     * then makes sure it is in lowercase.
     *
     * @param fullName
     * @return
     */
    private static String getFirstSegmentOfName(String fullName)
    {
        return fullName.substring(0, 1).toLowerCase();
    }

    /**
     * Returns the Last Segment of the Full Name
     *
     * This method takes the full name and the index of the last name,
     * then gets the first character of the last name substring and
     * converts it to uppercase.Then gets the rest of the string and
     * returns the last segment as one.
     *
     * @param fullName
     * @param lastNameIndex
     * @return
     */
    private static String getLastSegmentOfName(String fullName, int lastNameIndex)
    {
        return fullName.substring(lastNameIndex).toUpperCase().charAt(0) + fullName.substring(lastNameIndex + 1);
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
    private static String askFor(String context)
    {
        String formattedText = "\n\tPlease enter your %s: ";

        System.out.printf(formattedText, context);

        return console.nextLine();
    }
}
