package com.coding.epi;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddress {
    public List<String> getValidIpAddress(String s) {

        List<String> ips = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            final String p1 = s.substring(0, i);
            if (isValid(p1))
                for (int j = 1; j <= 3; j++) {
                    final String p2 = s.substring(i, i + j);
                    if (isValid(p2))
                        for (int k = 1; k <= 3 && i + j + k < s.length(); k++) {
                            String p3 = s.substring(i + j, i + j + k);
                            String p4 = s.substring(i + j + k);

                            if (isValid(p3) && isValid(p4)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(p1).append('.').append(p2).append('.').append(p3).append('.').append(p4);

                                String ip = sb.toString();
                                ips.add(sb.toString());
                            }
                        }

                }

        }

        return ips;
    }

    private static boolean isValid(String s) {
        if (s.length() > 3) return false;

        int value = Integer.parseInt(s);
        return value >= 0 && value <= 255;
    }

}
