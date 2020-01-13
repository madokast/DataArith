package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * A message containing letters from A-Z is being encoded
 * to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits,
 * determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or
 * "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF"
 * (22 6), or "BBF" (2 2 6).
 * <p>
 * Data
 * 14:19
 * ----------------
 * 动态规划
 * Runtime: 77 ms, faster than 6.85% of Java online submissions for Decode Ways.
 * Memory Usage: 36.6 MB, less than 67.92% of Java online submissions for Decode Ways.
 *
 * 奇技淫巧
 * Runtime: 1 ms, faster than 97.10% of Java online submissions for Decode Ways.
 * Memory Usage: 35 MB, less than 100.00% of Java online submissions for Decode Ways.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0091DecodeWays implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("12"),
                Input.InputSet.build("226"),
                Input.InputSet.build("0"),
                Input.InputSet.build("10"),
                Input.InputSet.build("4085393587263438197362839792" +
                        "65118737953821195131857788416471329114397" +
                        "6212416731331985661435443671959")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2, 3, 0, 1,0);
    }

    public class Solution0091 {
        int[] arr;

        public int numDecodings(String s){
            if (s == null || s.length() == 0) return 0;

            if(s.charAt(0)=='0') return 0;

            if(s.length()==1) return 1;

            int p = 1; // n[0:i-1]
            int pp = 1;// n[0:i-2]
            for (int i = 1,cur; i < s.length(); i++) {
                cur = (s.charAt(i)=='0'?0:p) +
                        (isLetter(s.charAt(i-1),s.charAt(i))?pp:0);

                // if n[0:i]==n[0:i-1]==0, the n[len-1] is zero, quick out
                if(cur==0&&p==0) return 0;

                pp = p;
                p = cur;
            }
            return p;
        }

        private int numDecodings0(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            if(s.charAt(0)=='0')
                return 0;

            arr = new int[s.length()];


            if (s.charAt(0) == '0')
                arr[0]= 0;
            else
                arr[0]= 1;


            int decodings = numDecodings(s, s.length() - 1);
            System.out.println("动态规划：" + Arrays.toString(arr));
            return decodings;
        }

        private int numDecodings(String s, int i) {
            if (i < 0)
                return 1;

            if (arr[i] == 0) {
                arr[i] = (s.charAt(i) != '0' ? numDecodings(s, i - 1) : 0) +
                        (i > 0 && isLetter(s.charAt(i - 1), s.charAt(i)) ? (numDecodings(s, i - 2)) : 0);
            }


            return arr[i];
        }

        private boolean isLetter(char c1, char c2) {
            if (c1 == '1') return true;
            else return c1 == '2' && c2 <= '6';
        }
    }
}
