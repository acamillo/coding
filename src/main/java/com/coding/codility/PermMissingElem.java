package com.coding.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acamillo
 * @since 09/11/17.
 */
public class PermMissingElem {
    public int apply(int[] A) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++)
            set.add(A[i]);

        for (int i = 0; i < A.length; i++)
            if (!set.contains(i)) {
                return i;
            }

        return -1;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        long N = A.length;
        long sum = 0;

        for (int i = 0; i < N; i++)
            sum += A[i];

        // care with this computation. the result will overflow into a long
        long total = (N + 2) * (N + 1) / 2;

        return (int) (total - sum);
    }
}
