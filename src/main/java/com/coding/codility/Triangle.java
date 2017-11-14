package com.coding.codility;

import java.util.Arrays;

/**
 * @author acamillo
 * @since 14/11/17.
 */
public class Triangle {
    public int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            int P = i, Q = i + 1, R = i + 2;
            if ( ((long)A[P] + A[Q] > A[R]) && ((long)A[Q] + A[R] > A[P]) && ((long)A[R] + A[P] > A[Q]) ) {
                return 1;
            }
        }
        return  0;
    }

}
