package com.jimmyhowe.hnc.fundamentals.Assessment4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Jimmy on 21/02/2016.
 */
public class BubbleSorterTest
{
    private double[] doubles;

    @Before
    public void setUp() throws Exception
    {
        this.doubles = new double[]{ .02, .03, .01 };
    }

    @Test
    public void testSortDoubles() throws Exception
    {
        assertArrayEquals(new double[]{.01, .02, .03}, BubbleSorter.sortDoubles(this.doubles), 0.01);
    }
}