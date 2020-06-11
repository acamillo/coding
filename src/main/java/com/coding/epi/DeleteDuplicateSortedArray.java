package com.coding.epi;

public class DeleteDuplicateSortedArray {

    public int[] solution(int[] data) {
        int p1 = 0;
        int p2 = 1;
        int size = data.length;

        while (p2 < size) {
            while (data[p1] == data[p2] && p2 < size)
                p2++;

            if (p2 < size) {
                p1++;
                data[p1] = data[p2];
            }
            p2++;
        }

        // fill the remainder with zeros
        for (int i = p1 + 1; i < size; i++)
            data[i] = 0;
        return data;
    }

    public int []v1( int []data, int key) {
        int w = 0;
        int size = data.length;

        for (int i = 1; i < size; ) {
            if (data[w] == key) {
                swap(data, w, i++);
            } else {
                w++;

            }
        }

        while(++w < size) data[w] = 0;
        return data;
    }

    private static void swap(int []a, int i, int j) {
        int t = a[i];

        a[i] = a[j];
        a[j] = t;
    }
}
