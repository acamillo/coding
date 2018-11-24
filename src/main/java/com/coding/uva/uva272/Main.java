package com.coding.uva.uva272;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean b = true;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            int pos = s.indexOf('\"');
            int start = 0;

            while (pos != -1) {
                sb.append(s.substring(start, pos));
                if (b) {
                    sb.append("``");
                } else
                    sb.append("''");

                b = !b;

                start = pos + 1;
                pos = s.indexOf('\"', start);
            }

            sb.append(s.substring(start, s.length()));

            System.out.println(sb.toString() );
        }

        System.out.flush();
    }
}
