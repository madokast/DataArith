package zrx.com.leetcode.Q0100;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given a string S and a string T, count the number of
 * distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed
 * from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit"
 * from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 * <p>
 * Data
 * 16:42
 *
 * @author zrx
 * @version 1.0
 */

public class Q0115DistinctSubsequences implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("rabbbit","rabbit"),
                Input.InputSet.build("babgbag","bag")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(3,5);
    }

    public class Solution0115 {
        public int numDistinct(String s, String t) {

            //TODO

            return 0;
        }
    }
}
