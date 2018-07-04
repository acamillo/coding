package com.coding.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author acamillo
 * @since 04/07/18.
 */
public class WeightedActivitySelection {

    public static class Job {
        int start;
        int end;
        int weight;

        public Job(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("{s:%d, e:%d, w:%d}", start, end, weight);
        }
    }

    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job weight plus weight till last non overlapping job is greater
     * than weight till last job.
     *
     * @param jobs
     * @return
     */
    public List<Job> maximum(Job[] jobs) {
        int[] W = new int[jobs.length];
        int[] J = new int[jobs.length];

        Arrays.sort(jobs, Comparator.comparing(job -> job.end));

        for (int i = 0; i < jobs.length; i++) {
            W[i] = jobs[i].weight;

            // by default, at step 'i' take the i-th job
            J[i] = i;
        }

        for (int i = 1; i < jobs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
//                    T[i] = Math.max(T[i], jobs[i].weight + T[j]);
//                    W[i] = Math.max(W[i - 1], jobs[i].weight + W[j]);

                    // can we improve the solution if we take job j-th ?
                    if (jobs[i].weight + W[j] > W[i - 1]) {
                        J[i] = j;
                        W[i] = jobs[i].weight + W[j];
                    } else {
                        // taking the i-th and j-th jobs together, doesn't improve the maximum weight,
                        // computed so, far; i.e. the weight of the previous job W[i - 1]
                        W[i] = W[i - 1];
                    }

                    break;
                }
            }
        }

        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < W.length; i++) {
            if (maxVal < W[i]) {
                maxVal = W[i];
                maxIndex = i;
            }
        }

        List<Job> sol = new ArrayList<>();
        while (J[maxIndex] != maxIndex) {
            sol.add(jobs[maxIndex]);
            maxIndex = J[maxIndex];
        }
        sol.add(jobs[maxIndex]);

//        sol.forEach(System.out::println);

//        for (int ii : T) {
//            System.out.print(ii + ",");
//
//        }
//        System.out.println();
//
//        for (int ii : P) {
//            System.out.print(ii + ",");
//        }

//        System.out.println();

        return sol;
    }

}
