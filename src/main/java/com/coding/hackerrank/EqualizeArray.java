package com.coding.hackerrank;

/**
 *
 * problem: https://www.hackerrank.com/challenges/equality-in-a-array
 */
public class EqualizeArray {

    int equalizeArray(int[] arr) {
        final int size = 101;
        int[] cc = new int[size];

        // count frequency
        for(int v: arr) {
            cc[v]++;
        }

        int curMax = 0;
        // get max frequent.
        for(int i=0;i < size; i++) {
            if (cc[i] > curMax) {
                curMax = cc[i];
            }
        }

        return arr.length - curMax;

    }
}
