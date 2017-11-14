package com.coding.codility;

/**
 * @author acamillo
 * @since 12/11/17.
 */
public class MinAvgTwoSlice {
    int solution(int[] A) {

        int[] P = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            P[i + 1] = A[i] + P[i];
        }

        int min = 0;
        int max = A.length - 1;
        boolean over = false;
        float minAvg = Float.MAX_VALUE;
        int minAvgIdx = 0;

//        for (int i = 0; i < A.length - 1; i++) {
//            float avg = (float) (P[max + 1] - P[i]) / (max - i + 1);
//            if (avg < minAvg) {
//                minAvg = avg;
//                minAvgIdx = i;
//            }
//        }

//        return minAvgIdx;

        do {
            float avg = (float) (P[max + 1] - P[min]) / (max - min + 1);
            if (A[min] > avg && ((max - min) > 1)) min++;
            else if (A[max] > avg && ((max - min) > 1)) max--;
            else {
                if (avg < minAvg) {
                    minAvg = avg;
                    minAvgIdx = min;
                }

                min++;
//                over = true;
            }


        } while ((max - min) > 1 && !over);

//        return minAvgIdx;
        return Math.max(minAvgIdx, min);

    }
}
