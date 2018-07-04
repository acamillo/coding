package com.coding.gainlo;

import com.coding.random.FormPermutations;
import com.coding.random.WeightedActivitySelection;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author acamillo
 * @since 16/10/17.
 */
public class Tests {
    @Test
    public void longestSubStringWithoutRepeatingChars() throws Exception {
        LongestSubstringWoRepeatingChars t = new LongestSubstringWoRepeatingChars();


        assertThat(t.apply("abcdef")).isEqualTo("abcdef");

        assertEquals("abcdef", t.apply("abcdef"));
        assertEquals("cdefgh", t.apply("abccdefgh"));
        assertEquals("bcd", t.apply("abbcbcd"));
        assertEquals("cbd", t.apply("abbcbd"));
    }


    private boolean verifyUniqueness(List<String> elements, int size) {
        Set<String> set = new HashSet<String>();
        for (String s : elements) {
            if (!set.add(s))
                return false;
        }
        return elements.size() == size;
    }

    @Test
    public void formPermutations() throws Exception {
        Set<String> perms = new HashSet<String>();
        FormPermutations t = new FormPermutations();

        assertThat(t.apply("1234").size()).isEqualTo(24);
        assertThat(t.apply("12345").size()).isEqualTo(120);
        assertThat(verifyUniqueness(t.apply("12345"), 120)).isEqualTo(true);

        System.out.println(t.apply("1234"));
    }

    @Test
    public void formCombinations() throws Exception {
        FormPermutations t = new FormPermutations();

        System.out.println(t.apply("12345", 3));
    }

    @Test
    public void formTheBiggestNumberPossible() throws Exception {
        FormTheBiggestNumberPossible t = new FormTheBiggestNumberPossible();

        assertThat(t.apply("423865")).isEqualTo("865432");
        assertThat(t.apply("42386")).isEqualTo("86432");

        assertThat(t.apply(423865)).isEqualTo(865432);
        assertThat(t.apply(42386)).isEqualTo(86432);
    }

    @Test
    public void weightedActivitySelection() {
        WeightedActivitySelection t = new WeightedActivitySelection();

        WeightedActivitySelection.Job[] jobs = new WeightedActivitySelection.Job[] {

                new WeightedActivitySelection.Job(6, 7, 4),
                new WeightedActivitySelection.Job(4, 6, 5),
                new WeightedActivitySelection.Job(5, 8, 11),
                new WeightedActivitySelection.Job(7, 9, 2),
                new WeightedActivitySelection.Job(2, 5, 6),
                new WeightedActivitySelection.Job(1, 3, 5)
        };

        System.out.println(t.maximum(jobs));
    }
}