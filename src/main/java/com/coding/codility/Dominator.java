package com.coding.codility;

/**
 * problem: https://app.codility.com/programmers/lessons/8-leader/dominator/
 * solution: https://app.codility.com/demo/results/trainingR3DVK3-ET5/
 *
 * <p>
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.
 * The function should return −1 if array A does not have a dominator.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 *
 * @author acamillo
 * @since 09/07/18.
 */
public class Dominator {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int leader = 0;
        int freq = 0;

        for (int a : A) {
            if (freq == 0) {
                leader = a;
                freq++;
            } else if (leader == a) {
                freq++;
            } else {
                freq--;
            }
        }

        int index = 0;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                counter++;
                index = i;
            }
        }

        if (counter > A.length / 2)
            return index;
        else
            return -1;
    }
}
