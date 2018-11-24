package com.coding.hackerrank;

import java.util.List;

/**
 * problem: https://www.hackerrank.com/challenges/migratory-birds
 */
public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    int migratoryBirds(List<Integer> arr) {

        // it is guaranteed that each type is 1,2, 3, 4, or 5.
        // int n>= 5
        int[] birds = new int[5];

        for (int currVal : arr) {
            birds[currVal - 1]++;
        }

        int maxSights = 0;
        int currMax = Integer.MIN_VALUE;
        for (int i = birds.length - 1; i >= 0; i--) {
            if (birds[i] >= currMax) {
                currMax = birds[i];
                maxSights = i + 1;
            }
        }

        return maxSights;
    }
}
