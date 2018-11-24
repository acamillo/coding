package com.coding.hackerrank;

/**
 *
 * problem: https://www.hackerrank.com/challenges/sock-merchant
 */
public class SockMerchant {
    // Complete the sockMerchant function below.
    int sockMerchant(int n, int[] ar) {

        // 1 <= n <= 100;
        // 1 <= ar[n] < = 100

        int []sockPerColor = new int[100];

        for(int color: ar) {
            sockPerColor[color-1]++;
        }

        int pairs = 0;

        for(int socks: sockPerColor) {
            pairs += (socks / 2);
        }

        return  pairs;
    }
}
