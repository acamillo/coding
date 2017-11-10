package com.coding.codility;

/**
 * @author acamillo
 * @since 10/11/17.
 */
public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int N = S.length();
        int[] A = new int[N + 1];
        int[] C = new int[N + 1];
        int[] G = new int[N + 1];
        int[] T = new int[N + 1];

        for (int i = 0; i < N; i++) {
            // carry over the previous computation result
            A[i + 1] = A[i];
            C[i + 1] = C[i];
            G[i + 1] = G[i];
            T[i + 1] = T[i];

            char ch = S.charAt(i);
            switch (ch) {
                case 'A':
                    A[i + 1]++;
                    break;
                case 'C':
                    C[i + 1]++;
                    break;
                case 'G':
                    G[i + 1]++;
                    break;
                case 'T':
                    T[i + 1]++;
                    break;
            }
        }

        // compute the amount of genes between P and Q.
        int[] results = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int nA = A[Q[i] + 1] - A[P[i]];
            int nC = C[Q[i] + 1] - C[P[i]];
            int nG = G[Q[i] + 1] - G[P[i]];
            int nT = T[Q[i] + 1] - T[P[i]];

            if (nA > 0) results[i] = 1;
            else if (nC > 0) results[i] = 2;
            else if (nG > 0) results[i] = 3;
            else
                results[i] = 4;
        }

        return results;
    }
}
