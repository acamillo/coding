package com.coding.hackerrank;

/**
 * problem: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * <p>
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
 * She tabulates the number of times she breaks her season record for most points and least points in a game.
 * Points scored in the first game establish her record for the season, and she begins counting from there.
 * <p>
 * For example, assume her scores for the season are represented in the array scores =[12,24,10,24].
 * Scores are in the same order as the games played. She would tabulate her results as follows:
 * <p>
 * Count
 * Game  Score  Minimum  Maximum   Min Max
 * 0      12     12       12       0   0
 * 1      24     12       24       0   1
 * 2      10     10       24       1   1
 * 3      24     10       24       1   1
 * <p>
 * Given Maria's scores for a season, find and print the number of times she breaks her records for most and least
 * points scored during the season.
 * <p>
 * Function Description
 * <p>
 * Complete the breakingRecords function in the editor below. It must return an integer array containing the numbers
 * of times she broke her records. Index  is for breaking most points records, and index  is for breaking least
 * points records.
 * <p>
 * breakingRecords has the following parameter(s):
 * <p>
 * scores: an array of integers
 *
 * @author acamillo
 * @since  7/11/2018
 */
public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    int[] breakingRecords(int[] scores) {

        int curMin = scores[0];
        int curMax = scores[0];

        int bestBreak = 0;
        int worstBreak = 0;

        for (int score : scores) {
            if (score < curMin) {
                curMin = score;
                worstBreak++;
            } else if (score > curMax) {
                curMax = score;
                bestBreak++;
            }
        }

        return new int[]{bestBreak, worstBreak};

    }
}
