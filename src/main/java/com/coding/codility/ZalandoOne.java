package com.coding.codility;

public class ZalandoOne {
    public int solution(int N) {
        // write your code in Java SE 8

        int d = digits(N);
        if (d == 1) return 0;
        return (int)Math.pow(10, d-1);
    }

    private int digits(int N) {
        if (N == 0) return 1;

        int i = 0;
        while(N > 0) {
            N /= 10;
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        ZalandoOne n = new ZalandoOne();

//        System.out.println(n.digits(1234567890));
////        System.out.println(Math.ceil(Math.log10(1234567890)));
//        System.out.println(n.digits(125));
//        System.out.println(n.digits(100));
//        System.out.println(n.digits(99));
//        System.out.println(n.digits(1));
//        System.out.println(n.digits(0));

        System.out.println(n.solution(125));
        System.out.println(n.solution(1234567890));
        System.out.println(n.solution(11));
        System.out.println(n.solution(10));
        System.out.println(n.solution(5));
        System.out.println(n.solution(1));
    }
}
