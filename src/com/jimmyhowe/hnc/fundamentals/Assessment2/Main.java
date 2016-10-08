/*
    Jimmy Howe
    Programming Fundamentals
    Assessment 2
 */

package com.jimmyhowe.hnc.fundamentals.Assessment2;

public class Main
{
    public static void main(String[] args)
    {
        // Create an array of sizes
        int[] fileSizes = { 12, 102, 43, 56, 33, 2, 45, 22, 13, 88 };

        System.out.println("There are " + getCount(fileSizes) + " files");
        System.out.println("With a total of " + getTotal(fileSizes) + " MB");
        System.out.println("With an average of " + getAverage(fileSizes) + " MB per file");
    }

    /**
     * Returns the count of sizes
     *
     * @param fileSizes
     * @return
     */
    private static int getCount(int[] fileSizes)
    {
        int count = 0;

        for ( int size : fileSizes )
        {
            count++;
        }

        return count;
    }

    /**
     * Returns the Total
     *
     * @param fileSizes
     * @return
     */
    private static int getTotal(int[] fileSizes)
    {
        int total = 0;

        for ( int size : fileSizes )
        {
            total += size;
        }

        return total;
    }

    /**
     * Returns the Average Size
     *
     * @param fileSizes
     * @return
     */
    private static int getAverage(int[] fileSizes)
    {
        return getTotal(fileSizes) / getCount(fileSizes);
    }
}
