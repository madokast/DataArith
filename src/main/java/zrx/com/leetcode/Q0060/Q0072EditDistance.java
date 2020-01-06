package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given two words word1 and word2, find the minimum number
 * of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * <p>
 * Data
 * 11:22
 *
 * @author zrx
 * @version 1.0
 */

public class Q0072EditDistance implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("horse","ros"),
                Input.InputSet.build("ros","horse"),
                Input.InputSet.build("intention","execution"),
                Input.InputSet.build("execution","intention")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(3,3,5,5);
    }

    public class Solution {
        public int minDistance(String word1, String word2) {
            //TODO
            return 0;
        }
    }
}
