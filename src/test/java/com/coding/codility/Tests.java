package com.coding.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author acamillo
 * @since 09/11/17.
 */
public class Tests {

    @Test
    public void missingInteger() throws Exception {
        MissingInteger t = new MissingInteger();

        int[] data = new int[]{1, 3, 6, 4, 1, 2};
        assertThat(t.solution(data)).isEqualTo(5);

    }
}