package com.coding.codility;

public class ZalandoTwo {
    public int solution(int A, int B) {
        // write your code in Java SE 8

        int min = (int) Math.ceil(Math.sqrt(A));
        int max = (int) Math.floor(Math.sqrt(B));
//
        System.out.println("min: " + min + ", max: " + max);
        System.out.println("min^2: " + min*min + ", max^2: " + max*max);

        int maxRoots = 0;
//        int perfectRoot = 0;
        // the min and max value are already squared, so the counter for perfect squares
        // gets one addition.
        for (int i = min; i <= max; i++) {
            int r = 1 + roots(i);
//            System.out.println("Roots of " + i + ", :" + r);
//            if ( r > maxRoots) {
//                perfectRoot = i;
//            }

            maxRoots = Math.max(r, maxRoots);
        }

//        System.out.println("Perfect root: " + perfectRoot);

        return maxRoots;
    }

    /**
     * recusrively find how many time a number is a perfect square root
     * @param v
     * @return the number of perfect square roots
     */
    private int roots(int v) {
        if (v == 1) return 1;

        int r = (int) Math.sqrt(v);
        if (r * r == v) {
//            System.out.println("Rooting of: " + v);
            return 1 + roots(r);
        }
        else
            return 0;
    }

    public static void main(String[] args) {

        ZalandoTwo t = new ZalandoTwo();

//        System.out.println("Max roots: " + t.solution(6000, 7000));
        System.out.println("Max roots: " + t.solution(1, 256));
//        t.solution(10, 20);
//        t.solution(2, 1000000000);
    }
}
