package com.coding.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author acamillo
 * @since 29/06/18.
 */
public class LRUCacheTest {

    private LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(2);

    @Test
    public void testCacheStartsEmpty() {
        assertThat(cache.get(1)).isEqualTo(null);
    }

    @Test
    public void testSetBelowCapacity() {
        cache.put(1, 1);
        assertThat(cache.get(1)).isEqualTo(1);
        assertThat(cache.get(2)).isEqualTo(null);

        cache.put(2, 4);
        assertThat(cache.get(1)).isEqualTo(1);
        assertThat(cache.get(2)).isEqualTo(4);
    }

    @Test
    public void testCapacityReachedOldestRemoved() {
        cache.put(1, 1);
        cache.put(2, 4);
        cache.put(3, 9);
        assertThat(cache.get(1)).isEqualTo(null);
        assertThat(cache.get(2)).isEqualTo(4);
        assertThat(cache.get(3)).isEqualTo(9);
    }

    @Test
    public void testGetRenewsEntry() {
        cache.put(1, 1);
        cache.put(2, 4);
        assertThat(cache.get(1)).isEqualTo(1);

        cache.put(3, 9);
        assertThat(cache.get(1)).isEqualTo(1);
        assertThat(cache.get(2)).isEqualTo(null);
        assertThat(cache.get(3)).isEqualTo(9);
    }
}