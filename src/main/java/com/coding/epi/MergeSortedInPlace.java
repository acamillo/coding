package com.coding.epi;

public class MergeSortedInPlace {

    // precondition! A contains enough space, at the end, to hold all b's elements
    // end is the pointer, in array 'a' to the last actual index.
    public int [] merge(int []a, int[]b, int last) {

        int end = a.length - 1;
        int i = last;
        int j = b.length - 1;

        while(i >= 0 && j >= 0) {
            int va = a[i];
            int vb = b[j];
            if (va > vb) {
                a[end--] = va;
                i--;
            } else if (vb > va) {
                a[end--] = vb;
                j--;
            } else {
                a[end--] = va;
                a[end--] = va;
                i--; j--;
            }
        }

        while(i >= 0) a[end--] = a[i--];
        while(j >= 0) a[end--] = b[j--];

        return a;
    }
}
