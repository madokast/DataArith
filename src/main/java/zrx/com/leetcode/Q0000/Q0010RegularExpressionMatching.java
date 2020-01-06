package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given an input string (s) and a pattern (p), implement regular
 * expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time.
 * Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * <p>
 * Data
 * 13:22
 *
 * --------------------
 * Runtime: 53 ms, faster than 22.15% of Java online submissions for Regular Expression Matching.
 * Memory Usage: 41.1 MB, less than 34.34% of Java online submissions for Regular Expression Matching.
 * ---------------------
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
                Input.InputSet.build("ab", ".*"),
                Input.InputSet.build("aab", "c*a*b"),
                Input.InputSet.build("mississippi", "mis*is*p*."),
                Input.InputSet.build("ab", ".*c"),
                Input.InputSet.build("a", "..*..a*")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(false, true, true, true, false, false, false);
    }

    public class Solution0010 {
        public boolean isMatch(String s, String p) {
            if (p.length() <= 0) {
                return s.length() <= 0;
            }

            boolean currentMatch = (s.length() > 0 && s.charAt(0) == p.charAt(0))
                    || (p.charAt(0) == '.');

            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) ||
                        (currentMatch && s.length() > 0 && isMatch(s.substring(1), p));
            } else
                return currentMatch && s.length() > 0 && isMatch(s.substring(1), p.substring(1));
        }
    }
}
