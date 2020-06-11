package com.coding.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> mkTriangle( int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));

        for(int i= 1; i< n; i++) {
            List<Integer> lvl = next(triangle.get(i-1));
            triangle.add(lvl);
        }

        return triangle;
    }


    private List<Integer> next(List<Integer> xs) {
        List<Integer> l = new ArrayList<>();
        l.add(1);

        for(int i = 1; i < xs.size(); i++) {
            int s = xs.get(i) + xs.get(i-1);
            l.add(s);
        }
        l.add(1);

        return l;
    }
}
