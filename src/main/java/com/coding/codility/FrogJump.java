package com.coding.codility;

/**
 * @author acamillo
 * @since 09/11/17.
 */
public class FrogJump {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8

        return ((Y - X) / D + ((Y - X) % D > 0 ? 1 : 0));
    }
}
