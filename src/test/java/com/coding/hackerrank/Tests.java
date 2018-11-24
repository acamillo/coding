package com.coding.hackerrank;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void birthdayChocolate() {
        BirthdayChocolate t = new BirthdayChocolate();

        assertThat(t.birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2)).isEqualTo(2);
        assertThat(t.birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2)).isEqualTo(2);
        assertThat(t.birthday(Arrays.asList(4), 4, 1)).isEqualTo(1);
    }

    @Test
    public void divisibleSumPairs() {
        DivisibleSumPairs t = new DivisibleSumPairs();

        assertThat(t.divisibleSumPairs(0, 3, new int[]{1, 3, 2, 6, 1, 2})).isEqualTo(5);
        assertThat(t.divisibleSumPairs(0, 5, new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(3);
        assertThat(t.divisibleSumPairs(0, 2, new int[]{5, 9, 10, 7, 4})).isEqualTo(4);
    }

    @Test
    public void migratoryBirds() {
        MigratoryBirds t = new MigratoryBirds();

        assertThat(t.migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3))).isEqualTo(4);
    }

    @Test
    public void drawingBook() {
        DrawingBook t = new DrawingBook();

        assertThat(t.pageCount(6, 2)).isEqualTo(1);
        assertThat(t.pageCount(5, 4)).isEqualTo(0);
    }

    @Test
    public void countingValley() {
        CountingValley t = new CountingValley();

        assertThat(t.countingValleys(8, "UDDDUDUU")).isEqualTo(1);
        assertThat(t.countingValleys(8, "DDUUUUDD")).isEqualTo(1);
    }

    @Test
    public void electronicShop() {
        ElectronicShop t = new ElectronicShop();
        assertThat(t.getMoneySpent(new int[]{40, 50, 60}, new int[]{4, 8, 12}, 60)).isEqualTo(58);
        assertThat(t.getMoneySpent(new int[]{40, 50, 60, 80}, new int[]{4, 8, 12, 20}, 60)).isEqualTo(60);
        assertThat(t.getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10)).isEqualTo(9);
    }

    @Test
    public void pickingNumbers() {
        PickingNumbers t = new PickingNumbers();
        assertThat(t.pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2))).isEqualTo(5);
        assertThat(t.pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2,3,3,3))).isEqualTo(7);
        assertThat(t.pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1))).isEqualTo(3);
        assertThat(t.pickingNumbers(Arrays.asList(98, 3, 99, 1, 97, 2))).isEqualTo(2);
        assertThat(t.pickingNumbers(Arrays.asList(4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98,
                2, 98, 3, 9, 9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4, 9, 1, 98, 98, 4, 2, 3, 98,
                98, 1, 99, 9, 98, 98, 3, 98, 98, 4, 98, 2, 98, 4, 2, 1, 1, 9, 2, 4))).isEqualTo(22);
    }

    @Test
    public void bigFactorials() {
        ExtraLongFactorials t= new ExtraLongFactorials();

        t.extraLongFactorials(25);
    }

    @Test
    public void sherlockAndSquares() {
        SherlockAndSquares t= new SherlockAndSquares();

        assertThat(t.squares(3,9)).isEqualTo(2);
        assertThat(t.squares(17, 24)).isEqualTo(0);
        assertThat(t.squares(35, 70)).isEqualTo(3);
        assertThat(t.squares(100, 1000)).isEqualTo(22);
    }
}
