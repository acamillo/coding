package com.coding.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * problem: https://app.codility.com/programmers/lessons/8-leader/equi_leader/
 * solution: https://app.codility.com/demo/results/training9CQQGQ-JZF/
 *
 *
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * <p>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 *
 * @author acamillo
 * @since 09/07/18.
 */
public class EquiLeader {

    class Counter {
        int freq;

        int inc() {
            freq++;
            return freq;
        }

        void dec() {
            freq--;
        }

        int getFrequency() {
            return freq;
        }

        Counter(int a) {
            freq = 0;
        }
    }

    public int findLeader(int[] A) {
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

    public int solution(int[] A) {
        int leaderIndex = findLeader(A);
        if (leaderIndex == -1) {
            return 0;
        }

        Map<Integer, Counter> right = new HashMap<>();
        // calculate frequencies
        for (int a : A) {
            right.computeIfAbsent(a, Counter::new).inc();
        }


        // algorithm explanation:
        // 1. find the leader, if exists and calculate elements frequency.
        // 2. iterate all over the array elements.
        // 3. for each element  split the array A into two part, the left and right.
        // 4. decrease the frequency on the right part of array A.
        // 5. keep a running a freq of the leader on the left part of the array.
        // 6. verify if the full array leader  it is still an actual leader on the left part
        // 7. to do this, compare the running freq of the leader against the size of the left part.
        // 8. if we still have a leader on the left side, check whether we also do have a leader on the right side.


        int leader = A[leaderIndex];
        int freq = 0;
        int candidates = 0;

        for (int i = 0; i < A.length; i++) {

            // decrease the frequency of the element being removed, from the right side.
            right.get(A[i]).dec();

            // keep a freq of the running potential leader.
            if (A[i] == leader) {
                freq++;
            }

            // the potential leader is still an actual leader ?
            // if yes. it is a leader of the right part of the array as well ?
            if (freq > (i + 1) / 2 && right.get(leader).getFrequency() > (A.length - (i + 1)) / 2) {
                candidates++;
            }
        }

        return candidates;
    }
}
