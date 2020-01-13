package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description
 * Given a triangle, find the minimum path sum from top to
 * bottom. Each step you may move to adjacent numbers on
 * the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra
 * space, where n is the total number of rows in the triangle.
 * <p>
 * Data
 * 16:45
 *
 * @author zrx
 * @version 1.0
 */

public class Q0120Triangle implements Question {
    @Override
    public List<Input[]> getInputsList() {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,7,5));
        triangle.add(Arrays.asList(4,1,8,3));

        return Input.makeInputSet(
                Input.InputSet.build(triangle)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(11);
    }

    public class Solution0120 {
        public int minimumTotal(List<List<Integer>> triangle) {

            //TODO
            return 0;
        }
    }
}
