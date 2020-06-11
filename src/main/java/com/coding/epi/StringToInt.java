package com.coding.epi;

public class StringToInt {

    public int stringToInt(String s) {
        if (s.length() == 0) return 0;

        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }

        int value = 0;
        for(int i = start; i < s.length(); i++ ) {
            value = value * 10 + (s.charAt(i) - '0');
        }

        return value * sign;
    }

    public String intToString(Integer v) {
        boolean negative = v < 0;

        if (negative) v *= -1;

        StringBuilder sb = new StringBuilder();
        while(v > 0) {
            sb.append(v % 10);
            v /= 10;
        }
        if (negative) sb.append('-');
        return sb.reverse().toString();
    }
}
