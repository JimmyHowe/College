package com.jimmyhowe.hnc.fundamentals.Assessment4;

/**
 * The Bubble Sorter Class is used to contain the sorting code,
 * and cleans up the main program
 */
class BubbleSorter
{
    /**
     * Sort
     *
     * This is the main sorting method, it takes an array of doubles
     * and sorts them using the bubble sort method
     *
     * @param doubles
     * @return
     */
    public static double[] sortDoubles(double[] doubles)
    {
        // The outer loop
        for ( int outer = 0; outer < doubles.length; outer++ )
        {
            //the inner loop
            for ( int inner = 0; inner < doubles.length - 1; inner++ )
            {
                // Is the first array member greater then the next member
                if(doubles[inner] > doubles[inner + 1])
                {
                    // then swap their position, pushing the higher numbers
                    // to the end of the array
                    double temp = doubles[inner + 1];
                    doubles[inner + 1] = doubles[inner];
                    doubles[inner] = temp;
                }
            }
        }

        return doubles;
    }
}