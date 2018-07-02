package com.coding.hackerrank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author acamillo
 * @since 22/02/18.
 */
public class Tests {

    @Test
    public void veryBigSum() throws Exception {
        VeryBigSum t = new VeryBigSum();

        long[] data = new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        assertThat(t.solution(data.length, data)).isEqualTo(5000000015L);

    }

}
