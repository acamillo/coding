package com.coding.codility;

import java.util.Arrays;

/**
 * @author acamillo
 * @since 14/11/17.
 */
public class Distinct {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        if ( A.length == 0 ) return 0;

        int sol = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1])
                sol++;
        }
        return  sol;
    }
}
