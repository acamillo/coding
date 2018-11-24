package com.coding.hackerrank;

/**
 *
 * problem: https://www.hackerrank.com/challenges/find-digits/problem
 */
public class FindDigits {
    int findDigits(int n) {

        int v = n;

        int result = 0;
        while(v > 0) {
            int d = v % 10;
            if (d != 0 && n % d == 0) result++;
            v /= 10;
        }

        return result;
    }
}
