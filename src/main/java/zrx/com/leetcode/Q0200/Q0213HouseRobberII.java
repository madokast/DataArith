package zrx.com.leetcode.Q0200;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * You are a professional robber planning to rob houses along
 * a street. Each house has a certain amount of money stashed
 * . All houses at this place are arranged in a circle. That
 * means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were
 * broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount
 * of money of each house, determine the maximum amount of money
 * you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob
 * house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3
 * (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Data
 * 22:24
 *
 * @author zrx
 * @version 1.0
 */

public class Q0213HouseRobberII implements Question {

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2,3,2)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1,2,3,1))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(3,4);
    }


    public class Solution0213 {
        public int rob(int[] nums) {

            //TODO
            return 0;
        }
    }
}
