package com.coding.hackerrank;

import java.util.Collections;
import java.util.List;

/**
 * problem: https://www.hackerrank.com/challenges/picking-numbers/problem
 */
public class PickingNumbers {
    int pickingNumbers(List<Integer> a) {
        // Write your code here

        Collections.sort(a);

        int currWindow = 1;
        int maxWindow = 0;
        int flag = a.get(0);
        int nextWindow = 0;

        for (int i = 1; i < a.size(); i++) {
            int elem = a.get(i);

            if (elem - flag == 0) {
                currWindow++;
            } else if (elem - flag == 1) {
                currWindow++;
                nextWindow++;
            } else {
                maxWindow = Math.max(currWindow, maxWindow);
                if (elem - a.get(i - 1) == 1) { // this element could continue the window
                    currWindow = nextWindow;
                    i -= 1; // elaborate the same item again
                } else { // this element starts a new incompatible sliding window
                    currWindow = 1;
                    nextWindow = 0;
                }
                flag = a.get(i);
            }
        }

        return Math.max(currWindow, maxWindow);
    }
}
