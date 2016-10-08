package com.jimmyhowe.hnc.fundamentals.Assessment1;

/**
 * Created by Jimmy on 26/01/2016.
 */
public class LargestFileSizeTest
{
    public static void main(String[] args)
    {
        int[] fileSizes = { 1, 3, 2, 4, 5 };

        if( assertEquals(5, Main.getLargestSize(fileSizes)) )
        {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        };
    }

    /**
     * ASSERT: Asserts two values are equal
     *
     * @param expected
     * @param actual
     * @return
     */
    private static boolean assertEquals(int expected, int actual)
    {
        if (expected == actual) return true;

        return false;
    }
}
