package com.coding.codility;

/**
 * problem: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 * solution:
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * <p>
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 * <p>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 *
 * @author acamillo
 * @since 10/07/18.
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int[] L = new int[A.length];
        int[] R = new int[A.length];

        L[0] = Math.max(0, A[0]);
        R[0] = Math.max(0, A[A.length - 1]);
        for (int i = 1; i < A.length; i++) {
            L[i] = Math.max(0, L[i - 1] + A[i]);
            R[i] = Math.max(0, R[i - 1] + A[A.length - (i + 1)]);
        }

        int N = A.length - 2;
        int maxSlice = 0;
        for (int i = 1; i < N; i++) {
            int l = L[i] - L[0], r = R[A.length - 1] - R[i + 2];
            maxSlice = Math.max(maxSlice, l + r);
        }

        return maxSlice;
    }
//    public int solution(int[] A) {
//        int[] M = new int[A.length];
//
//        int minElem = Integer.MAX_VALUE;
//        M[0] = Math.max(0, A[0]);
//        for (int i = 1; i < A.length; i++) {
//            M[i] = Math.max(0, M[i - 1] + A[i]);
//            if (A[i] < minElem) minElem = A[i];
//        }
//
//        int maxSlide = 0;
//        int runningCounter = 0;
//        boolean middleElem = false;
//        for (int i = 1; i < A.length - 1; i++) {
//            if (M[i] > M[i - 1]) {
//                runningCounter += M[i] - Math.abs(M[i - 1]);
//
//            } else {
//                if (runningCounter > 0)
//                    maxSlide += runningCounter;
//                runningCounter = 0;
//                middleElem = true;
//            }
//        }
//        if (middleElem)
//            return maxSlide;
//        else
//            return runningCounter - minElem;
//    }
}
