package com.coding.codility;

/**
 * problem: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 * solution: https://app.codility.com/demo/results/trainingZXSMS9-2NJ/
 * 
 * <p>
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 * <p>
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Assume that:
 * <p>
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 *
 * @author acamillo
 * @since 20/07/18.
 */
public class MaxSliceSum {
    public int solution(int[] A) {
        int[] dp = new int[A.length];

        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
        }

        int maxSlice = Integer.MIN_VALUE;
        for (int value : dp) maxSlice = Math.max(maxSlice, value);

        return maxSlice;
    }
}
