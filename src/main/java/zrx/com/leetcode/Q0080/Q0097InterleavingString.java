package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.ToString;

import java.util.List;

/**
 * Description
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * <p>
 * Data
 * 16:40
 *
 * @author zrx
 * @version 1.0
 */

public class Q0097InterleavingString implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("aabcc", "dbbca", "aadbbcbcac"),
                Input.InputSet.build("aabcc", "dbbca", "aadbbbaccc"),
                Input.InputSet.build("", "", "a"),
                Input.InputSet.build("a", "b", "a"),
                Input.InputSet.build("a", "b", "cc")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(true, false, false, false, false);
    }

    public class Solution0097 {

        //Runtime: 2 ms, faster than 83.42% of Java online submissions for Interleaving String.
        //Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Interleaving String.
        // 飞速
        public boolean isInterleave(String s1, String s2, String s3) {
            int s1L = s1.length();
            int s2L = s2.length();
            int s3L = s3.length();

            if (s1L + s2L != s3L)
                return false;

            if (s1L == s3L)
                return s1.equals(s3);

            if (s2L == s3L)
                return s2.equals(s3);


            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char[] chars3 = s3.toCharArray();

            boolean[][] dp = new boolean[s1L + 1][];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new boolean[s2L + 1];
            }

            dp[0][0] = true;

            for (int i = 0; i < s1L; i++) {
                if (chars1[i] == chars3[i]) {
                    dp[i + 1][0] = true;
                } else
                    break;
            }

            for (int i = 0; i < s2L; i++) {
                if (chars2[i] == chars3[i]) {
                    dp[0][i + 1] = true;
                } else
                    break;
            }


            for (int i = 0; i < s1L; i++) {
                for (int j = 0; j < s2L; j++) {
                    dp[i + 1][j + 1] = (dp[i][j + 1] && chars1[i] == chars3[i + j + 1]) ||
                            (dp[i + 1][j] && chars2[j] == chars3[i + j + 1]);
                }
            }

            System.out.println("dp = " + ToString.booleanArrArrToString(dp));


            System.out.println("递归算法 = " + isInterleave0(s1, s2, s3));

            return dp[s1L][s2L];


        }

        //Runtime: 840 ms, faster than 7.31% of Java online submissions for Interleaving String.
        //Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Interleaving String.
        //垃圾算法
        private boolean isInterleave0(String s1, String s2, String s3) {


            boolean interleave = isInterleave(s1, 0, s2, 0, s3);
            return interleave;
        }

        private boolean isInterleave(String s1, int i, String s2, int j, String s3) {


            if (i == s1.length() && j == s2.length())
                return i + j == s3.length();

            if (i + j >= s3.length())
                return false;

            return (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) &&
                    isInterleave(s1, i + 1, s2, j, s3))
                    ||
                    (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) &&
                            isInterleave(s1, i, s2, j + 1, s3));
        }
    }
}
