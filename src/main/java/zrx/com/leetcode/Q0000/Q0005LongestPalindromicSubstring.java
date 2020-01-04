package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given a string s, find the longest palindromic substring
 * in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * Data
 * 2019/12/24 14:54
 * <p>
 * ------------------------
 * 我承认找不到高效的算法
 * 学习：
 * Approach 2: Brute Force
 * The obvious brute force solution is to pick all possible
 * starting and ending positions for a substring, and verify
 * if it is a palindrome.
 * Complexity Analysis
 * Time complexity : O(n^3)O(n3). Assume that nn is the length
 * of the input string, there are a total of \binom{n}{2} =
 * \frac{n(n-1)}{2}(2n)=2n(n−1)
 * such substrings (excluding the trivial solution where a
 * character itself is a palindrome). Since verifying each
 * substring takes O(n)O(n) time, the run time complexity
 * is O(n^3)O(n3).
 * Space complexity : O(1)O(1).
 * <p>
 * Approach 3: Dynamic Programming
 * To improve over the brute force solution, we first observe
 * how we can avoid unnecessary re-computation while validating
 * palindromes. Consider the case "ababa". If we already knew that
 * "bab" is a palindrome, it is obvious that "ababa" must be a
 * palindrome since the two left and right end letters are the same.
 * <p>
 * We define P(i,j)P(i,j) as following:
 * p(i,j) = true if (i,j) is palindrome
 * <p>
 * P(i,j)=(P(i+1,j−1) and Si==sj
 *
 * Runtime: 10 ms, faster than 62.81% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Longest Palindromic Substring.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0005LongestPalindromicSubstring implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("babad"),
                Input.InputSet.build("cbbd"),
                Input.InputSet.build("a"),
                Input.InputSet.build("bb")
        );
    }

    @Override
    public List<Answer> getAnswers() {

        return Answer.makeAnswerList("aba", "bb","a","bb");
    }

    public class Solution0005 {
        public String longestPalindrome(String s) {
            if(s==null||s.length()==0){
                return "";
            }


            int maxLength = -1;
            int right = -1;
            int left = -1;

            for (int i = 0; i < s.length(); i++) {
                int[] arr1 = expend(s, i * 2);
                int[] arr2 = expend(s, i * 2 + 1);

                int len1 = arr1[0];
                int len2 = arr2[0];

                if (len1 > len2) {
                    if (len1 > maxLength) {
                        maxLength = len1;
                        left = arr1[1];
                        right = arr1[2];
                    }
                } else {
                    if (len2 > maxLength) {
                        maxLength = len2;
                        left = arr2[1];
                        right = arr2[2];
                    }
                }
            }

            System.out.println("left = " + left);
            System.out.println("right = " + right);
            return s.substring(left, right + 1);
        }

        private int[] expend(String s, int local) {
            if (local % 2 == 1) {
                //奇数
                int index = local / 2;
                int len = 1;

                int right = index + 1;
                int left = index - 1;

                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        len += 2;
                        left--;
                        right++;
                    } else {
                        break;
//                        return new int[]{len, ++left, --right};
                    }
                }

                return new int[]{len,++left, --right};
            } else {
                //偶数
                int index = local / 2;
                int len = 0;

                int right = index;
                int left = index - 1;

                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        len += 2;
                        left--;
                        right++;
                    } else {
                        break;
//                        return new int[]{len, ++left, --right};
                    }
                }

                return new int[]{len, ++left, --right};
            }

        }
    }
}
