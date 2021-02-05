package com.coding.deliveroo;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DeliverooTest  {

    @Test
    public void solution() {
        Deliveroo sol = new Deliveroo();

        assertThat(sol.solution()).isEqualTo(42);
    }
}