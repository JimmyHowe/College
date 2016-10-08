/*
    Jimmy Howe
    Programming Fundamentals
    Assessment 3
 */

package com.jimmyhowe.hnc.fundamentals.Assessment1;

public class Main
{
    public static void main(String[] args)
    {
        // Create an array of sizes
        int[] fileSizes = { 12, 102, 43, 56, 33, 2, 45, 22, 13, 88 };

        // use method to get largest file size
        int largestSize = getLargestSize(fileSizes);

        // print out results
        System.out.println("The largest file size is " + largestSize);
    }

    /**
     * Gets the largest int in an array of ints
     *
     * @param sizes
     * @return
     */
    public static int getLargestSize(int[] sizes)
    {
        int largestSize = sizes[0];

        for ( int i = 0; i < sizes.length; i++ )
        {
            if ( sizes[i] > largestSize )
            {
                largestSize = sizes[i];
            }
        }

        return largestSize;
    }
}
