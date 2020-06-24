package com.coding.epi;

public class RLECodec {

    // Assume string != ""
    public String encode(final String s) {
        char ch = s.charAt(0);
        int cc = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                cc++;
            } else {
                sb.append(cc).append(ch);
                cc = 1;
                ch = s.charAt(i);
            }
        }
        sb.append(cc).append(ch);

        return sb.toString();
    }

    public String decode(final String s) {
        return "decoder";
    }
}
