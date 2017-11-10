package com.coding.gainlo;

import java.util.Arrays;

/**
 * @author acamillo
 * @since 17/10/17.
 */
public class FormTheBiggestNumberPossible {
    public int apply(int i) {
        int ints[] = new int[(int)Math.ceil(Math.log10(i))];

        int cc = 0;
        while(i > 0) {
            ints[cc++] = i % 10;
            i /= 10;
        }

        Arrays.sort(ints);
        reverse(ints);

        cc = 0;
        int result = 0;

        while(cc < ints.length) {
            result = result * 10 + ints[cc++];
        }

        return result;
    }

    public String apply(String s) {
        char []chs = s.toCharArray();
        Arrays.sort(chs);

        String sorted = new String(reverse(chs));

        return  sorted;
    }

    private char [] reverse(char [] a) {
        for(int i = 0; i < a.length / 2; i++) {
            char tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
        return a;
    }

    private int [] reverse(int [] a) {
        for(int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
        return a;
    }
}
