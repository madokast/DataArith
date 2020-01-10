package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner
 * of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How
 * many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively
 * in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
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
 * -----------------------
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
 * Memory Usage: 38.2 MB, less than 98.46% of Java online submissions for Unique Paths II.
 * -------------------
 * 秒杀~~~~~~~~~~
 *
 * @author zrx
 * @version 1.0
 */

public class Q0063UniquePathsII implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object)new int[][]{
                        new int[] {0,0,0},
                        new int[] {0,1,0},
                        new int[] {0,0,0}
                })
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2);
    }

    public class Solution0063 {
        private int[][] pathNum;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
                return 0;
            }

            pathNum = new int[obstacleGrid.length][];
            for (int i = 0; i < pathNum.length; i++) {
                pathNum[i] = new int[obstacleGrid[0].length];
                Arrays.fill(pathNum[i],-1);
            }
            pathNum[0][0]=1;

            int ret = uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);

            System.out.println("动态规划："+ToString.intArrArrToString(pathNum));

            return ret;
        }

        private int uniquePathsWithObstacles(int[][] obstacleGrid,int i,int j){
            if(pathNum[i][j]!=-1){
                return pathNum[i][j];
            }

            int num = 0;
            if(i>0&&obstacleGrid[i-1][j]==0){
                if(pathNum[i-1][j]==-1){
                    pathNum[i-1][j] = uniquePathsWithObstacles(obstacleGrid,i-1,j);
                }

                num+=pathNum[i-1][j];
            }
            if(j>0&&obstacleGrid[i][j-1]==0){
                if(pathNum[i][j-1]==-1){
                    pathNum[i][j-1] = uniquePathsWithObstacles(obstacleGrid,i,j-1);
                }

                num+=pathNum[i][j-1];
            }

            pathNum[i][j]=num;
            return num;
        }


    }
}
