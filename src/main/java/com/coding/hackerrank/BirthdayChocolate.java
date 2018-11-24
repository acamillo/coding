package com.coding.hackerrank;

import java.util.List;

/**
 * problem: https://www.hackerrank.com/challenges/the-birthday-bar/problem
 * solutionL https://www.hackerrank.com/challenges/the-birthday-bar/submissions/code/89992695
 * <p>
 * Lily has a chocolate bar that she wants to share it with Ron for his birthday. Each of the squares has an integer
 * on it. She decides to share a contiguous segment of the bar selected such that the length of the segment matches
 * Ron's birth month and the sum of the integers on the squares is equal to his birth day. You must determine how
 * many ways she can divide the chocolate.
 * <p>
 * Consider the chocolate bar as an array of squares, s =[2,2,1,3,2]. She wants to find segments summing to Ron's birth day,
 * d = 4with a length equalling his birth month, m = 2. In this case, there are two segments meeting her
 * criteria: [2,2] and [1,3].
 * <p>
 * Function Description
 * <p>
 * Complete the birthday function in the editor below. It should return an integer denoting the number of ways Lily can divide the chocolate bar.
 * <p>
 * birthday has the following parameter(s):
 * <p>
 * 1. s: an array of integers, the numbers on each of the squares of chocolate
 * 2. d: an integer, Ron's birth day
 * 3. m: an integer, Ron's birth month
 */
public class BirthdayChocolate {


    // Prefix Sum
    int birthday(List<Integer> s, int d, int m) {


        int cc = 0;

        int[] prefix = new int[s.size() + 1];
        prefix[0] = 0;

        for (int i = 0; i < s.size(); i++) {
            prefix[i + 1] = prefix[i] + s.get(i);
        }


        for (int i = 0; i + m <= s.size(); i++) {
            if (prefix[i + m] - prefix[i] == d)
                cc++;
        }

        return cc;

    }

//    // STUPID SOLUTION BRUTE FORCE.
//    // Complete the birthday function below.
//    int birthday(List<Integer> s, int d, int m) {
//
//        int tm = m;
//        int td = d;
//        int cc = 0;
//        for (int i = 0; i < s.size(); i++) {
//
//            int j= i;
//            while (tm > 0 && j < s.size()) {
//                td -= s.get(j);
//                tm--;
//                j++;
//            }
//            if (td == 0 && tm == 0) {
//                cc++;
//            } //else if (td > 0) i -= 1;
//
//            td = d;
//            tm = m;
//        }
//
//        return cc;
//    }

}
