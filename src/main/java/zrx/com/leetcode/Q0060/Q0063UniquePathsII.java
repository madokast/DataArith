package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner
 * of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How
 * many unique paths would there be?
 * <p>
 * <p>
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively
 * in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * <p>
 * Data
 * 11:13
 *
 * @author zrx
 * @version 1.0
 */

public class Q0063UniquePathsII implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) new int[][]{
                        new int[]{0, 0, 0},
                        new int[]{0, 1, 0},
                        new int[]{0, 0, 0}
                })
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2);
    }

    public class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //TODO
            return 0;
        }
    }
}
