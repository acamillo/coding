package com.coding.hackerrank;

public class SherlockAndSquares {


    int squares(int a, int b) {

        int sqra = (int)Math.floor(Math.sqrt(a));
        int sqrb = (int)Math.floor(Math.sqrt(b));

        int diff = sqrb - sqra;
        if (sqra * sqra == a) diff ++;

        return  diff;
    }
}
