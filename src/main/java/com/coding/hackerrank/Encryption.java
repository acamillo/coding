package com.coding.hackerrank;

public class Encryption {
    String encryption(String s) {

        int lb = (int) Math.floor(Math.sqrt(s.length()));
        int ub = (int) Math.ceil(Math.sqrt(s.length()));


        if (lb * ub < s.length()) lb = ub;

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < ub; c++) { // O(SQRT(N)
            for (int r = 0; r < lb && (c + r * ub) < s.length(); r++) { // O(SQRT(N))
                sb.append(s.charAt(c + r * ub));
            }
            sb.append(' ');

        }

        return sb.toString().trim();
    }
}
