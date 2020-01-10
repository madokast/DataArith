package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.ToString;

import java.util.Arrays;
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
 * ----------------
 * Runtime: 1 ms, faster than 99.52% of Java online submissions for Minimum Path Sum.
 * Memory Usage: 40.7 MB, less than 93.24% of Java online submissions for Minimum Path Sum.
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

    public class Solution0064 {
        private int[][] minPathSumArr;
        public int minPathSum(int[][] grid) {
            minPathSumArr = new int[grid.length][];
            for (int i = 0; i < minPathSumArr.length; i++) {
                minPathSumArr[i] = new int[grid[0].length];
                Arrays.fill(minPathSumArr[i],-1);
            }
            minPathSumArr[0][0] = grid[0][0];

            int ret = minPathSum(grid,grid.length-1,grid[0].length-1);

            System.out.println("动态规划数组：" + ToString.intArrArrToString(minPathSumArr));

            return ret;
        }

        private int minPathSum(int[][] grid,int i,int j){
            if(minPathSumArr[i][j]!=-1){
                return minPathSumArr[i][j];
            }

            minPathSumArr[i][j] = Math.min(
                    i>0?minPathSum(grid,i-1,j):Integer.MAX_VALUE,
                    j>0?minPathSum(grid,i,j-1):Integer.MAX_VALUE
            ) + grid[i][j];

            return minPathSumArr[i][j];
        }


    }
}
