package com.coding.hackerrank;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    int pageCount(int n, int p) {
        /*
         * Write your code here.
         */

        int fromFront = p / 2;
//        int fromBack = (n -p) /2;
        int fromBack = (n / 2 - p / 2);

        return Math.min(fromBack, fromFront);
    }
}
