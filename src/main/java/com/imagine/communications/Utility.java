package com.imagine.communications;

/**
 * Created by venkatesh.muthusamy on 5/5/2016.
 */
public class Utility {

    public static int getLargestContiguousSum(int[] input, int length) {

        int localMaximum = 0;
        int globalMaximum = 0;

        for(int i=0;i<length;i++) {

            localMaximum+=input[i];
            if(localMaximum<0) {
                localMaximum=0;
            }
            if(localMaximum>globalMaximum) {
                globalMaximum=localMaximum;
            }


        }

        return globalMaximum;
    }
}
