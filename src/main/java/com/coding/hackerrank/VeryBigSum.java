package com.coding.hackerrank;

import java.util.Arrays;

/**
 * @author acamillo
 * @since 22/02/18.
 */
public class VeryBigSum
{
    static long solution(int n, long[] ar) {
        // Complete this function

        long sum = 0;
        for( long v: ar) {
            sum += v;
        }

        return sum;
//        long sum = Arrays.stream(ar).sum();
//        return sum;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        long[] ar = new long[n];
//        for(int ar_i = 0; ar_i < n; ar_i++){
//            ar[ar_i] = in.nextLong();
//        }
//        long result = aVeryBigSum(n, ar);
//        System.out.println(result);
//    }
}
