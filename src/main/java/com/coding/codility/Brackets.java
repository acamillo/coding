package com.coding.codility;

import java.util.Stack;

/**
 * see problem here: https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * see results here: https://app.codility.com/demo/results/trainingQKMJ5W-UC8/
 *
 *
 * <p>
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 *
 * @author acamillo
 * @since 06/07/18.
 */
public class Brackets {
    public int solution(String S) {
        // write your code in Java SE 8

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            Character ch = S.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                if (stack.empty()) return 0;

                Character cl = stack.pop();

                if (ch == ')' && cl != '(') return 0;
                if (ch == ']' && cl != '[') return 0;
                if (ch == '}' && cl != '{') return 0;
            }
        }

        return stack.empty() ? 1 : 0;
    }
}
