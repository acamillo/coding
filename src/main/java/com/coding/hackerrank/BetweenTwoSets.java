package com.coding.hackerrank;

/**
 * problem: https://www.hackerrank.com/challenges/between-two-sets/problem
 * solution:
 * <p>
 * You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
 * <p>
 * 1. The elements of the first array are all factors of the integer being considered
 * 2. The integer being considered is a factor of all elements of the second array
 * <p>
 * These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
 * <p>
 * For example, given the arrays a[2,6] and b = [24,36] , there are two numbers between them: 6 and 12. 6%2 = 0,
 * 6%6 = 0 ,24%6 =0 ,  and  36%6 =0 for the first value. Similarly, 12%2 =0 , 12%6=0 and 24%12=0, 36%12 = 0.
 * <p>
 * Function Description
 * <p>
 * Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
 * <p>
 * getTotalX has the following parameter(s):
 * <p>
 * 1. a: an array of integers
 * 2. b: an array of integers
 */
public class BetweenTwoSets {

    // Recursive function to return gcd of a and b
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        int bGcd = b[0];
        for (int i = 1; i < b.length; i++)
            bGcd = gcd(bGcd, b[i]);

        int lcmA = a[0];
        for (int i = 1; i < a.length; i++)
            lcmA = lcm(lcmA, a[i]);

        int res = 0;
        for (int i = lcmA; i <= bGcd; i+= lcmA) {
            boolean okA = true;
            boolean okB = true;

            if( i % lcmA != 0) okA = false;
            if (bGcd % i != 0) okB = false;

            if (okA && okB)
                res++;
        }

        return res;
    }

    // BRUTE Force solution.
//    /*
//     * Complete the getTotalX function below.
//     */
//    static int getTotalX(int[] a, int[] b) {
//        /*
//         * Write your code here.
//         */
//
//
//        int maxA = Integer.MIN_VALUE;
//        for (int va : a) {
//            maxA = Math.max(maxA, va);
//        }
//
//        int minB = Integer.MAX_VALUE;
//        for (int vb : b) {
//            minB = Math.min(minB, vb);
//        }
//
//        int res = 0;
//        for (int i = maxA; i <= minB; i++) {
//            boolean okA = true;
//            boolean okB = true;
//            for (int va : a) {
//                if (i % va != 0) okA = false;
//            }
//            for (int vb : b) {
//                if (vb % i != 0) okB = false;
//            }
//            if (okA && okB)
//                res++;
//        }
//
//        return res;
//    }
}
