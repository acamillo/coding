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

    public List<String> apply(final String input, int limit) {
        recursion = 1;
        List<String> combinations = apply(input, limit, "", 0, new ArrayList<String>());
        System.out.println("Recursion lev: " + recursion);
        return combinations;
    }

    private int recursion;

    /*
    This is classical backtracking strategy. Explore all the possible solutions and cutting away
    solution evaluation's branch that would not eventually reach a desired solution.
     */
    private List<String> apply(final String input, int limit, String group, int pos, List<String> newGroups) {
        recursion++;
        // if i have formed a long enough group string, then let's take it
        if (group.length() == limit) {
            newGroups.add(group);
        } else // if (pos < input.length())
        { // stop recursion when there isn't any other input char available.

            // i leave only if there are enough symbols to eventually make it up to "limit" elements.
            if (group.length() + (input.length() - (pos + 1)) >= limit )
                // leave
                apply(input, limit, group, pos + 1, newGroups);

            if (group.length() < limit) {
                // take
                StringBuffer sb = new StringBuffer(group);
                sb.append(input.charAt(pos));
                apply(input, limit, sb.toString(), pos + 1, newGroups);
            }
        }

        return newGroups;

    }

}
