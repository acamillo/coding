package com.coding.epi;

public class BinarySearch {
    public int search(int[] a, int k) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < k) {
                low = mid + 1;
            } else if (k < a[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        System.out.println("low: " + low + ", high: " + high);
        return -1;
    }
}
