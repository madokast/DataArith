package zrx.com.leetcode.Q0160;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

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
                })
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(7);
    }

    public class Solution {
        public int calculateMinimumHP(int[][] dungeon) {

            //TODO
            return 0;
        }
    }

}
