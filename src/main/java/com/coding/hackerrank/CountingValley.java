package com.coding.hackerrank;

public class CountingValley {
    int countingValleys(int n, String s) {

        int level = 0;
        int valleys = 0;
        boolean intoValley = false;

        for (char dir : s.toCharArray()) {
            if (dir == 'U') {
                level++;
            } else level--;
            if (level < 0 && !intoValley) {
                intoValley = true;
                valleys++;
            } else if (level >= 0 && intoValley) {
                intoValley = false;
            }

        }

        return valleys;
    }

}
