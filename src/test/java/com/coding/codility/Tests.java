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

    @Test
    public void maxCounter() throws  Exception{
        MaxCounters t = new MaxCounters();

        int[] data = new int[]{3, 4, 4, 6, 1, 4, 4};
        int[] res = new int[]{3, 2, 2, 4, 2};

        assertThat(t.solution(5, data)).isEqualTo(res);

    }

    @Test
    public void genomicRangeQuery() throws  Exception {
        GenomicRangeQuery t = new GenomicRangeQuery();

        String s = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] Q = new int[]{4, 5, 6};

        int[] res = t.solution(s, P, Q);
    }
}