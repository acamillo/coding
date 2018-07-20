package com.coding.codility;

import java.util.Stack;

/**
 * problem: https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 * solution: https://app.codility.com/demo/results/trainingBE8XKR-WG4/
 *
 *
 * <p>
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * int solution(int H[], int N);
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * <p>
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 *
 * @author acamillo
 * @since 06/07/18.
 */
public class StoneWall {
    public int solution(int[] H) {
        // write your code in Java SE 8

        Stack<Integer> s = new Stack<>();

        int blocks = 0;
        s.push(0);

        // the rational is the following:
        // when a new height comes it checks whether it's lower than the last one.
        // in case it pops all the heights that are taller until it find a lower, or equal point.
        // if the new height matches the one on top of the stack, then we can continue using the previous block,
        // otherwise we need a new block and the new height is also added to thee stack.

        // In case the new height is greater than the last on the stack, it's east.
        // we need a new block and keep track of the new current height pushing it onto the stack.

        // In case the new height is the same as before.. nothing happens
        for (int h : H) {
            if (h < s.peek()) {
                while (s.peek() > h)
                    s.pop();

                if (h != s.peek()) {
                    blocks++;
                    s.push(h);
                }
            } else if (h > s.peek()) {
                s.push(h);
                blocks++;
            }
        }

        return blocks;
    }
}
