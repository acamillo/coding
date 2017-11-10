package com.coding.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acamillo
 * @since 09/11/17.
 */
public class MissingInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i))
                return i;
        }

        return -1;
    }
}
