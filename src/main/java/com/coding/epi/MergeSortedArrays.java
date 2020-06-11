package com.coding.epi;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {

    public List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> r = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.size() & j < b.size()) {
            int va = a.get(i);
            int vb = b.get(j);

            if (va < vb) {
                r.add(va);
                i++;
            } else if (va > vb) {
                r.add(vb);
                j++;
            } else {
                r.add(va);
                r.add(va);
                i++;
                j++;
            }
        }

        // one of the two array is shorter
        while (i < a.size()) r.add(a.get(i++));
        while (j < b.size()) r.add(b.get(j++));

        return r;
    }
}
