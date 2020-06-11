package com.coding.epi;

import java.util.List;

public class RotateMatrix {

    public List<List<Integer>> rotate(List<List<Integer>> m) {
        // matrix is square hence no of rows = no. cols
        int rows = m.size();

        // external layer terminates half wayc
        for (int row = 0; row < Math.ceil(rows / 2.0); row++) {
            // internal layer decreases two units at time, one for the col layer,
            // another one for the external row layer
            for (int col = row; col < rows - row - 1; col++) {
                int t1 = m.get(col).get(rows - row - 1);
                int t2 = m.get(rows - row - 1).get(rows - col - 1);
                int t3 = m.get(rows - col - 1).get(row);
                int t4 = m.get(row).get(col);


                m.get(col).set(rows - row - 1, t4);
                m.get(rows - row - 1).set(rows - col - 1, t1);
                m.get(rows - col - 1).set(row, t2);
                m.get(row).set(col, t3);

//                System.out.println(m.toString());
            }
        }

        return m;
    }
}
