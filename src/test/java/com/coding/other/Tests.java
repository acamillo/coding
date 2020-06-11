package com.coding.other;

import com.coding.random.AddBigNumbers;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    public void addBigNumbers() {

        AddBigNumbers t = new AddBigNumbers();

        int[] a1 = new int[]{9, 9, 9};
        int[] b1 = new int[]{9};
        int[] res1 = new int[]{1, 0, 0, 8};
        assertThat(t.add(a1, b1)).isEqualTo(res1);
        assertThat(t.add(b1, a1)).isEqualTo(res1);

        int[] a2 = new int[]{9, 9, 9};
        int[] b2 = new int[]{9, 9, 9};
        int[] res2 = new int[]{1, 9, 9, 8};

        assertThat(t.add(a2, b2)).isEqualTo(res2);

    }
}
