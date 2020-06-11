package com.coding.random;

public class AddBigNumbers {


    // the two addendum are specified as an array of digits.
    public int[] add(int []a, int []b) {
        int aLen = a.length;
        int bLen = b.length;

        // addition can brings in one new digit at most
        int [] sum = new int[Math.max(aLen, bLen) + 1];
        int i = sum.length - 1;

        aLen--;
        bLen--;

        int carry = 0;
        while( aLen >= 0 && bLen >= 0) {
            int s = (a[aLen] + b[bLen] + carry) % 10;
            carry = (a[aLen] + b[bLen]) / 10;
            aLen--;
            bLen--;
            sum[i--] = s;
        }

        while(aLen >= 0) {
            int s = (a[aLen] + carry) % 10;
            carry = (a[aLen] + carry) / 10;

            aLen--;
            sum[i--] = s;
        }

        while(bLen >= 0) {
            int s = (b[bLen] + carry) % 10;
            carry = (b[bLen] + carry) / 10;

            bLen--;
            sum[i--] = s;
        }


        sum[i] = carry;

        // add the remainder of either a or b
        return sum;
    }
}
