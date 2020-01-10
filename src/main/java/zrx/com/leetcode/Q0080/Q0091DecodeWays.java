package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * A message containing letters from A-Z is being encoded
 * to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits,
 * determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or
 * "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF"
 * (22 6), or "BBF" (2 2 6).
 * <p>
 * Data
 * 14:19
 *
 * @author zrx
 * @version 1.0
 */

public class Q0091DecodeWays implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("12"),
                Input.InputSet.build("226")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2,3);
    }

    public class Solution0091 {
        public int numDecodings(String s) {
            //TODO

            return 0;
        }
    }
}
