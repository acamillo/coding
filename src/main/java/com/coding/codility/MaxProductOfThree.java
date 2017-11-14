package com.coding.codility;

import java.util.Arrays;

/**
 * @author acamillo
 * @since 14/11/17.
 */
public class MaxProductOfThree {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int N = A.length;
        // the max prod can come by the two most negative ones times the greates (if positive)
        // or by the three most great elems.
        if (A[0] * A[1] * A[N - 1] > A[N - 1] * A[N - 2] * A[N - 3] && A[N - 1] > 0)
            return A[0] * A[1] * A[N - 1];
        else
            return A[N - 1] * A[N - 2] * A[N - 3];
    }
}
