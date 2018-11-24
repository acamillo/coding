package com.coding.hackerrank;

/**
 * problem: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */
public class DivisibleSumPairs {

    // Complete the divisibleSumPairs function below.
    int divisibleSumPairs(int n, int k, int[] ar) {


        int[] remainders = new int[k];

        for (int i = 0; i < ar.length; i++) {
            int rem = ar[i] % k;
            remainders[rem]++;
        }


        int cc = 0;
//        for (int i = 1; i < k; i++) {
        for (int i = 1; i <= k / 2 && i != k - i; i++) {
            cc += remainders[i] * remainders[k - i];
        }

        // count every pairs twice
//        cc /= 2;

//        if (remainders.length == 2) {
//            cc = (remainders[1] * (remainders[1] - 1)) / 2;
//        }

        if (k % 2 == 0)
            cc += (remainders[k / 2] * (remainders[k / 2] - 1)) / 2;

        cc += (remainders[0] * (remainders[0] - 1)) / 2;

        return cc;
    }

}
