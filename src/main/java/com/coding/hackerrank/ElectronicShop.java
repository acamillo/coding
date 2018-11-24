package com.coding.hackerrank;

import java.util.Arrays;
import java.util.Collections;

public class ElectronicShop {

    // reverse the array
    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            // swap the elements
            int temp = array[i];
            array[i] = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = temp;
        }
    }

    int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        // this is a stupid, but simple, brute force solution
//        int curMax = -1;
//        for (int k = 0; k < keyboards.length; k++)
//            for (int d = 0; d < drives.length; d++) {
//                int exp = keyboards[k] + drives[d];
//                if (exp <= b && exp > curMax)
//                    curMax = exp;
//            }
//
//        return curMax;

        // sort first items in descending order of price
        Arrays.sort(keyboards); // O( K * LOG(K) )
        reverse(keyboards);

        // sort second item in ascending order ot cost
        Arrays.sort(drives); // O(D * LOG(D))


        // let N = max(K,D)
        // total cost <= O(N*LOG(N)) + O(2N) < = O( N * LOG (N) )

        int currMax = -1;
        for (int k = 0, d = 0; k < keyboards.length; k++) { // loops cost O(K + D)
            for (; d < drives.length; d++) { // notice d is NEVER reset to 0

                int cost = keyboards[k] + drives[d];
                if (cost > b) break; // go to next keyboard;
                currMax = Math.max(currMax, cost);
            }
        }

        return currMax;
    }
}
