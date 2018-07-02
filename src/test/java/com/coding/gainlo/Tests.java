package com.coding.gainlo;

import com.coding.random.FormPermutations;
import org.junit.Test;

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
        assertEquals("cdefgh", t.apply("abccdefgh") );
        assertEquals("bcd", t.apply("abbcbcd") );
        assertEquals("cbd", t.apply("abbcbd") );
    }


    private boolean verifyUniqueness(List<String> elements, int size) {
        Set<String> set = new HashSet<String>();
        for (String s: elements) {
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

//        System.out.println(t.apply("123"));
    }

    @Test
    public void formTheBiggestNumberPossible() throws Exception {
        FormTheBiggestNumberPossible t = new FormTheBiggestNumberPossible();

        assertThat(t.apply("423865")).isEqualTo("865432");
        assertThat(t.apply("42386")).isEqualTo("86432");

        assertThat(t.apply(423865)).isEqualTo(865432);
        assertThat(t.apply(42386)).isEqualTo(86432);
    }
}