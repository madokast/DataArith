package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * <p>
 * Data
 * 13:22
 *
 * @author zrx
 * @version 1.0
 */

public class Q0010RegularExpressionMatching implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("aa", "a"),
                Input.InputSet.build("aa", "a*"),
                Input.InputSet.build("ab", "."),
                Input.InputSet.build("aab", "c*a*b"),
                Input.InputSet.build("mississippi", "mis*is*p*.")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(false, true, true, true, false);
    }

    public class Solution0010 {
        public boolean isMatch(String s, String p) {
            //TODO
            return false;
        }
    }
}
