package com.coding.epi;

public class DutchFlag {

    public int [] solution(int []a, int pivotIdx) {
        int smaller = 0;
        int larger = a.length - 1;

        int pivot = a[pivotIdx];

        // first pass move all the elements smaller than pivot at the beginning
        while(smaller < larger) {
            if (a[smaller] < pivot) {
                smaller++;
            } else {
                swap(a, smaller, larger);
                larger--;
            }

//            System.out.println("smaller: " + smaller + ", larger: " + larger);
        }

        // second pass, move all the elements greater than pivot at the bottom
        larger = a.length - 1;

        while(smaller < larger) {
            if (a[smaller] > pivot) {
                swap(a, smaller, larger);
                larger--;
            } else smaller++;
        }

        return a;
    }

    private void swap(int []a, int i, int j) {
        int t = a[i];

        a[i] = a[j];
        a[j] = t;
    }
}
