package com.imagine.communications;

import org.junit.Test;

import static com.imagine.communications.Utility.getLargestContiguousSum;
import static org.junit.Assert.assertEquals;

/**
 * Created by venkatesh.muthusamy on 5/5/2016.
 */
public class UtilityTest {

    @Test
    public void testGetLargestContiguousSum(){
        int[] input ={-10, 2, 3, -2, 0, 5, -15};
        assertEquals(8, getLargestContiguousSum(input,input.length));
    }
}
