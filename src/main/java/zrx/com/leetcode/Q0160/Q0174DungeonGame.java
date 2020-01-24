package zrx.com.leetcode.Q0160;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * The demons had captured the princess (P) and imprisoned her in
 * the bottom-right corner of a dungeon. The dungeon consists of
 * M x N rooms laid out in a 2D grid. Our valiant knight (K) was
 * initially positioned in the top-left room and must fight his way
 * through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive
 * integer. If at any point his health point drops to 0 or below,
 * he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses
 * health (negative integers) upon entering these rooms; other
 * rooms are either empty (0's) or contain magic orbs that increase
 * the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the
 * knight decides to move only rightward or downward in each step.
 * <p>
 * <p>
 * <p>
 * Write a function to determine the knight's minimum initial
 * health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the
 * knight must be at least 7 if he follows the optimal path RIGHT->
 * RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * <p>
 * Note:
 * <p>
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room
 * the knight enters and the bottom-right room where the princess
 * is imprisoned.
 * <p>
 * Data
 * 18:43
 * <p>
 * <p>
 * * -2 (K)	-3	3
 * * -5	-10	1
 * * -100	300	-5 (P)
 *
 * @author zrx
 * @version 1.0
 */

public class Q0174DungeonGame implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) new int[][]{
                        new int[]{-2, -3, 3},
                        new int[]{-5, -10, 1},
                        new int[]{10, 30, -5}
                }),
                Input.InputSet.build((Object) new int[][]{
                        new int[]{1, -3, 3},
                        new int[]{0, -2, 0},
                        new int[]{-3, -3, -3}
                })
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(7, 3);
    }

    public class Solution0174 {


        //Runtime: 14 ms, faster than 5.11% of Java online submissions for Dungeon Game.
        //Memory Usage: 49.1 MB, less than 5.88% of Java online submissions for Dungeon Game.
        public int calculateMinimumHP(int[][] dungeon) {
            final int xMax = dungeon.length;
            final int yMax = dungeon[0].length;
            int[][] dp = new int[xMax][yMax];

            dp[xMax - 1][yMax - 1] = 1;

            for (int x = xMax - 2; x >= 0; x--) {
                dp[x][yMax - 1] = dp[x + 1][yMax - 1] - dungeon[x + 1][yMax - 1];
                if (dp[x][yMax - 1] <= 0) {
                    dp[x][yMax - 1] = 1;
                }
            }

            for (int y = yMax - 2; y >= 0; y--) {
                dp[xMax - 1][y] = dp[xMax - 1][y + 1] - dungeon[xMax - 1][y + 1];
                if (dp[xMax - 1][y] <= 0) {
                    dp[xMax - 1][y] = 1;
                }
            }

            for (int x = xMax - 2; x >= 0; x--){
                for (int y = yMax - 2; y >= 0; y--){
                    dp[x][y] = Math.min(
                          dp[x+1][y] - dungeon[x+1][y] ,
                          dp[x][y+1] - dungeon[x][y+1]
                    );

                    if(dp[x][y]<=0){
                        dp[x][y] = 1;
                    }
                }
            }

            System.out.println("dp = " + Arrays.deepToString(dp));


            int ans = dp[0][0] - dungeon[0][0];

            return ans<=0?1:ans;
        }


        //以下是错误做法
        //----------------------------------------------------------

        int[][][][] dp;

        //我需要记录，走到某个点时，我的最低生命是多少，还要记录当前生命是多少
        private int calculateMinimumHP0(int[][] dungeon) {

            dp = new int[dungeon.length][dungeon[0].length][2][2];

            int[][] intss = minHealthToPoint(dungeon, dungeon.length - 1, dungeon[0].length - 1);

            int[] ints = intss[0][0] > intss[1][0] ? intss[0] : intss[1];

//            for (int i = 0; i < dungeon.length; i++) {
//                for (int j = 0; j < dungeon[0].length; j++) {
//                    System.out.println("(" + i + "," + j + ") = "
//                            + Arrays.toString(minHealthToPoint(dungeon, i, j)));
//                }
//            }


            return ints[0] >= 0 ? 1 : -ints[0] + 1;
        }

        private int[][] minHealthToPoint(int[][] dungeon, int i, int j) {
            if (dp[i][j][0][0] != 0) {
//                System.out.println("dp[i][j] = " + Arrays.deepToString(dp[i][j]));
                return dp[i][j];
            }

            if (i == 0) {
                if (j == 0) {
                    return dp[i][j] = new int[][]{
                            new int[]{dungeon[0][0], dungeon[0][0]},
                            new int[]{dungeon[0][0], dungeon[0][0]}
                    };
                } else {
                    int[] pj = minHealthToPoint(dungeon, i, j - 1)[0];
                    return dp[i][j] = new int[][]{
                            new int[]{Math.min(pj[0], pj[1] + dungeon[i][j]),
                                    pj[1] + dungeon[i][j]},
                            new int[]{Math.min(pj[0], pj[1] + dungeon[i][j]),
                                    pj[1] + dungeon[i][j]}
                    };
                }
            }

            if (j == 0) {
                int[] pi = minHealthToPoint(dungeon, i - 1, j)[0];
                return dp[i][j] = new int[][]{
                        new int[]{Math.min(pi[0], pi[1] + dungeon[i][j]),
                                pi[1] + dungeon[i][j]},
                        new int[]{
                                Math.min(pi[0], pi[1] + dungeon[i][j]),
                                pi[1] + dungeon[i][j]
                        }
                };
            }

            int[] pj0 = minHealthToPoint(dungeon, i, j - 1)[0];
            int[] pj1 = minHealthToPoint(dungeon, i, j - 1)[1];
            int[] pi0 = minHealthToPoint(dungeon, i - 1, j)[0];
            int[] pi1 = minHealthToPoint(dungeon, i - 1, j)[1];


            int[] goj0 = new int[]{
                    Math.min(pj0[0], pj0[1] + dungeon[i][j]),
                    pj0[1] + dungeon[i][j]
            };

            int[] goi0 = new int[]{
                    Math.min(pi0[0], pi0[1] + dungeon[i][j]),
                    pi0[1] + dungeon[i][j]
            };

            int[] ans0;

            if (goi0[0] > goj0[0]) {
                ans0 = goi0;
            } else if (goi0[0] < goj0[0]) {
                ans0 = goj0;
            } else {
                ans0 = goi0[1] > goj0[1] ? goi0 : goj0;
            }

            int[] ans1;

            if (pi1[1] > pj1[1]) {
                ans1 = new int[]{
                        Math.min(pi1[0], pi1[1] + dungeon[i][j]),
                        pi1[1] + dungeon[i][j]
                };
            } else if (pi1[1] < pj1[1]) {
                ans1 = new int[]{
                        Math.min(pj1[0], pj1[1] + dungeon[i][j]),
                        pj1[1] + dungeon[i][j]
                };
            } else {
                int t1 = Math.min(pi1[0], pi1[1] + dungeon[i][j]);
                int t2 = Math.min(pj1[0], pj1[1] + dungeon[i][j]);

                ans1 = new int[]{
                        Math.min(t1, t2),
                        pj1[1] + dungeon[i][j]
                };
            }

//            return (new int[][]{ans0,ans1});
            return (dp[i][j] = new int[][]{ans0, ans1});

        }
    }

}
