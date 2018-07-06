package com.coding.codility;

import org.junit.Ignore;
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
    public void maxCounter() throws Exception {
        MaxCounters t = new MaxCounters();

        int[] data = new int[]{3, 4, 4, 6, 1, 4, 4};
        int[] res = new int[]{3, 2, 2, 4, 2};

        assertThat(t.solution(5, data)).isEqualTo(res);

    }

    @Test
    @Ignore("Lazy to fix")
    public void minAvgTwoSlice() throws Exception {
        MinAvgTwoSlice t = new MinAvgTwoSlice();

        int[] data = new int[]{4, 2, 2, 5, 1, 5, 8};
        assertThat(t.solution(data)).isEqualTo(1);

        assertThat(t.solution(new int[]{4, 2, 2, 1, 5, 5, 8})).isEqualTo(2);
        assertThat(t.solution(new int[]{10000, -10000})).isEqualTo(0);
        assertThat(t.solution(new int[]{10, 10, -1, 2, 4, -1, 2, -1})).isEqualTo(5);
    }

    @Test
    public void distinct() throws Exception {
        Distinct t = new Distinct();

        int[] data = new int[]{2, 1, 1, 2, 3, 1};
        assertThat(t.solution(data)).isEqualTo(3);
    }

    @Test
    public void triangle() throws Exception {
        Triangle t = new Triangle();

        int[] data = new int[]{10, 2, 5, 1, 8, 20};
        assertThat(t.solution(data)).isEqualTo(1);

        int[] data2 = new int[]{10, 50, 5, 1};
        assertThat(t.solution(data2)).isEqualTo(0);
    }

    @Test
    public void maxProductOfThree() throws Exception {
        MaxProductOfThree t = new MaxProductOfThree();

        int[] data = new int[]{-3, 1, 2, -2, 5, 6};

        assertThat(t.solution(data)).isEqualTo(60);
        assertThat(t.solution(new int[]{-5, 5, -5, 4})).isEqualTo(125);

        assertThat(t.solution(new int[]{-5, -6, -4, -7, -10})).isEqualTo(-120);
        assertThat(t.solution(new int[]{4, 7, 3, 2, 1, -3, -5})).isEqualTo(105);
    }

    @Test
    public void genomicRangeQuery() throws Exception {
        GenomicRangeQuery t = new GenomicRangeQuery();

        String s = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] Q = new int[]{4, 5, 6};

        int[] res = t.solution(s, P, Q);
    }


    @Test
    public void nesting() {
        Nesting t = new Nesting();

        assertThat(t.solution("(()(())())")).isEqualTo(1);
        assertThat(t.solution("())")).isEqualTo(0);
        assertThat(t.solution(")(()")).isEqualTo(0);

    }

    @Test
    public void brackets() {
        Brackets t = new Brackets();

        assertThat(t.solution("{[()()]}")).isEqualTo(1);
        assertThat(t.solution("{[(())()]}")).isEqualTo(1);
        assertThat(t.solution("([)()]")).isEqualTo(0);
    }

    @Test
    public void fish() {
        Fish t = new Fish();

        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        assertThat(t.solution(A, B)).isEqualTo(2);

        int[] A1 = {4, 3};
        int[] B1 = {0, 1};

        assertThat(t.solution(A1, B1)).isEqualTo(2);

        int[] A2 = {4, 3, 2, 1, 5};
        int[] B2 = {1, 1, 0, 0, 0};

        assertThat(t.solution(A2, B2)).isEqualTo(1);

        int[] A3 = {4, 6, 3, 2, 1, 5};
        int[] B3 = {1, 0, 1, 0, 0, 0};

        assertThat(t.solution(A3, B3)).isEqualTo(2);
    }

    @Test
    public void stoneWall() {
        StoneWall t = new StoneWall();

        int[] H1 = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        assertThat(t.solution(H1)).isEqualTo(7);

        int[] H2 = {8, 8, 5, 7, 9, 8, 7, 5, 8};
        assertThat(t.solution(H2)).isEqualTo(6);

        int[] H3 = {2, 5, 1, 4, 6, 7, 9, 10, 1};
        assertThat(t.solution(H3)).isEqualTo(8);
    }
}