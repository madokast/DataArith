package zrx.com.leetcode.Q0040;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given an input string (s) and a pattern (p), implement wildcard
 * pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z,
 * and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a',
 * which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while
 * the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * <p>
 * Data
 * 9:36
 *
 * ---------------------------
 * Runtime: 33 ms, faster than 11.33% of Java online submissions for Wildcard Matching.
 * Memory Usage: 40.8 MB, less than 37.21% of Java online submissions for Wildcard Matching.
 * ---------------------------
 * 我真厉害
 *
 * @author zrx
 * @version 1.0
 */

public class Q0044WildcardMatching implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("aa", "a"),
                Input.InputSet.build("aa", "*"),
                Input.InputSet.build("cb", "?a"),
                Input.InputSet.build("adceb", "*a*b"),
                Input.InputSet.build("acdcb", "a*c?b"),
                Input.InputSet.build("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"),
                Input.InputSet.build("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb")
        );
    }

//    @Override
//    public int[] reprintInputs() {
//        return new int[]{1};
//    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(false, true, false, true, false, false, false);
    }


    public class Solution0044 {
        private String preWork(String p) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);

                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '*' && c == '*') {
                    continue;
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }

        private Boolean[][] memo;

        public boolean isMatch(String s, String p) {
            memo = new Boolean[s.length() + 1][p.length() + 1];
            return isMatch0(s, 0, preWork(p), 0);
        }

        private boolean isMatch0(String s, int si, String p, int pi) {
//            if (p.length() == 0) {
//                return s.length() == 0;
//            }

            if (pi == p.length()) {
                return si==s.length();
            }


//            if (p.charAt(0) == '*') {
//                return isMatch(s, p.substring(1)) ||
//                        (s.length() > 0 && isMatch(s.substring(1), p));
//            } else
//                return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') &&
//                        isMatch(s.substring(1), p.substring(1));

            if (p.charAt(pi) == '*') {
                if (memo[si][pi + 1] == null) {
                    memo[si][pi + 1] = isMatch0(s, si, p, pi + 1);
                }

                if (si != s.length() && memo[si + 1][pi] == null) {
                    memo[si + 1][pi] = isMatch0(s, si + 1, p, pi);
                }

                return memo[si][pi + 1] || si != s.length() && memo[si + 1][pi];
            } else {
                if (si != s.length() && memo[si + 1][pi + 1] == null) {
                    memo[si + 1][pi + 1] = isMatch0(s, si + 1, p, pi + 1);
                }

                return si != s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') &&
                        memo[si + 1][pi + 1];
            }
        }
    }
}
