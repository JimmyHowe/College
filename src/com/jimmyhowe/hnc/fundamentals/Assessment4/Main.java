/*
    Jimmy Howe
    Programming Fundamentals
    Assessment 4
 */

package com.jimmyhowe.hnc.fundamentals.Assessment4;

public class Main
{
    /**
     * Off we go...
     *
     * @param args
     */
    public static void main(String[] args)
    {
        // Create an array of doubles
        double[] timesInMilliseconds = new double[]{ .234, .432, .043, .343, .098, .876 };

        // Sort the doubles
        double[] sortedTimes = BubbleSorter.sortDoubles(timesInMilliseconds);

        // Print out the results
        printResults(sortedTimes);
    }

    /**
     * Prints out the Results
     *
     * @param sortedTimes
     */
    private static void printResults(double[] sortedTimes)
    {
        for ( double time : sortedTimes )
        {
            System.out.println(time);
        }
    }
}
