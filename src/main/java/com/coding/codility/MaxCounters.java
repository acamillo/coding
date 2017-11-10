package com.coding.codility;

/**
 * @author acamillo
 * @since 10/11/17.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] results = new int[N];

        int maxCounter = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int aA : A) {
            int elem = aA - 1;

            if (elem == N) {
                if (maxValue > maxCounter) {
                    maxCounter = maxValue;
                }
            } else {
                // have we already seen a maxCounter operation ?
                // if yes, than the counter is supposed to be starting frm that value
                // and not from itw own last value.
                if (results[elem] < maxCounter)
                    results[elem] = maxCounter;

                results[elem]++;

                // check for maximum counter and remember it
                if (results[elem] > maxValue) {
                    maxValue = results[elem];
                }
            }
        }

        for(int i =0; i < N; i++)
            results[i]= Math.max(results[i], maxCounter);

        return  results;
    }
}
