package com.coding.codility;

/**
 * @author acamillo
 * @since 06/07/18.
 */
public class Nesting {

    // see here the solution: https://app.codility.com/demo/results/training96S62Z-SDU/
    public int solution(String S) {
        // write your code in Java SE 8
        int stack = 0;

        for(int i=0; i < S.length(); i++) {
            if ( S.charAt(i) == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    return 0;
                } else
                    stack--;
            }
        }

        return stack == 0 ? 1 : 0;
    }
}
