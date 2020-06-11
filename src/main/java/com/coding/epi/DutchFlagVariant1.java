package com.coding.epi;

public class DutchFlagVariant1 {

    public int [] solution(int []a) {
        int k2 = 1;
        int k3 = a.length - 1;

        while(k2 < k3) {

            if (a[k2] != a[k2 - 1]) {
                swap(a, k2, k3);
                k3--;
            } else {
                k2++;
            }
        }

        return a;
    }

    private static void swap(int []a, int i, int j) {
        int t = a[i];

        a[i] = a[j];
        a[j] = t;
    }
}
