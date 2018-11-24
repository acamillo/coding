package com.coding.hackerrank;

public class CatsAndMouse {
    String catAndMouse(int x, int y, int z) {

        int catA = Math.abs(z - x);
        int catB = Math.abs(z - y);

        if (catA < catB)
            return "Cat A";
        else if (catB < catA)
            return "Cat B";
        else
            return "Mouse C";


    }
}
