package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * <p>
 * Data
 * 11:15
 *
 * @author zrx
 * @version 1.0
 */

public class Q0064MinimumPathSum implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) new int[][]{
                        new int[]{1,3,1},
                        new int[]{1,5,1},
                        new int[]{4,2,1},
                })
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(7);
    }

    public class Solution {
        public int minPathSum(int[][] grid) {
            //TODO
            return 0;
        }
    }
}
