package com.coding.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acamillo
 * @since 09/11/17.
 */
public class FormPermutations {

    public List<String> apply(final String input) {

        if (input.length() == 1)
            return Arrays.asList(input);

        List<String> permutations = new ArrayList<String>();

        char firstCh = input.charAt(0);
        List<String> perms = apply(input.substring(1));
        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                StringBuffer sb = new StringBuffer(perm);
                String newPerm = sb.insert(i, firstCh).toString();
                permutations.add(newPerm);
            }

        }
        return permutations;
    }
}
