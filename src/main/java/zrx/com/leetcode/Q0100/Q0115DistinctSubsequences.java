package zrx.com.leetcode.Q0100;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.Arrays;
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
 * ---------
 * Runtime: 86 ms, faster than 5.08% of Java online submissions for Distinct Subsequences.
 * Memory Usage: 39.8 MB, less than 7.69% of Java online submissions for Distinct Subsequences.
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
            if(s.length()==0||t.length()==0)
                return 0;

            int[] dp = new int[t.length()];
            char t0 = t.charAt(0);

            dp[0] = t0 ==s.charAt(0)?1:0;

            for (int i = 1; i < s.length(); i++) {

                System.out.println("dp = " + Arrays.toString(dp));

//                for (int i1 = 1; i1 < dp.length; i1++) {
//                    if(t.charAt(i1)==s.charAt(i))
//                        dp[i1]+=dp[i1-1];
//                }

                for (int i1 = dp.length - 1; i1 >= 1; i1--) {
                    if(t.charAt(i1)==s.charAt(i))
                        dp[i1]+=dp[i1-1];
                }

                if(t0==s.charAt(i)) dp[0]++;
            }
            System.out.println("dp = " + Arrays.toString(dp));

            return dp[dp.length-1];

//            int[][] dp = new int[s.length()][];
//            for (int i = 0; i < dp.length; i++) {
//                dp[i] = new int[t.length()];
//            }
//
//            dp[0][0] = s.charAt(0)==t.charAt(0)?1:0;
//
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = 0; j < t.length(); j++) {
//                    if(i==0&&j==0)
//                        continue;
//
//                    dp[i][j] =
//                            ((i>0&&j>0&&s.charAt(i)==t.charAt(j))?dp[i-1][j-1]:0)
//                            + ((i>0)?dp[i-1][j]:0);
//                }
//            }
//
//            return dp[s.length()-1][t.length()-1];
        }
    }
}
