package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.others.COSY.SR;

import java.util.*;

/**
 * Description
 * Given a non-empty string s and a dictionary wordDict containing a
 * list of non-empty words, determine if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in
 * the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as
 * "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented
 * as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and",
 * "cat"]
 * Output: false
 * <p>
 * Data
 * 18:37
 * -------------------
 * Runtime: 4 ms, faster than 80.60% of Java online submissions for Word Break.
 * Memory Usage: 38.2 MB, less than 13.77% of Java online submissions for Word Break.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0139WordBreak implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("leetcode",List.of("leet", "code")),
                Input.InputSet.build("applepenapple",List.of("apple", "pen")),
                Input.InputSet.build("catsandog",List.of("cats", "dog", "sand", "and", "cat")),
                Input.InputSet.build("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaab",List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa",
                        "aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")),
                Input.InputSet.build("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaa",List.of("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa",
                        "aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"))
        );
    }

    @Override
    public List<Answer> getAnswers() {

//        return Answer.makeAnswerList(true);
        return Answer.makeAnswerList(true,true,false,false,false);
    }

    public class Solution0139 {

        private Set<String> stringSet;
        private Set<Integer> lengthSet;
        private int[][] dp;

        public boolean wordBreak(String s, List<String> wordDict) {
            stringSet = new HashSet<>();
            lengthSet = new HashSet<>();
            for (String s1 : wordDict) {
                if(!wordBreak(s1)){
                    lengthSet.add(s1.length());
                    stringSet.add(s1);
                }
            }

            dp = new int[s.length()+1][s.length()+1];

            boolean b = wordBreak_dp(s);
            System.out.println("动态规划：" + b);
            System.out.println("workBreak_break：" + workBreak_break(s));

            return wordBreak(s,0,s.length());
        }

        //拆分法
        //这个方法最舒服
        private boolean workBreak_break(String s){
            if(s.length()==0)
                return true;

            for (int i = 0; i <= s.length(); i++) {
                String front = s.substring(0,i);
                String back = s.substring(i);
//                System.out.println("front = " + front);
//                System.out.println("back = " + back);
                if(stringSet.contains(front)&&workBreak_break(back)){
                    return true;
                }

                stringSet.remove(front);
            }

            return false;
        }

        //动态规划
        private boolean wordBreak_dp(String s){
            int[] dp = new int[s.length()+1];
            dp[0] = 1;
            // 1 - true
            // 0 - null
            // 2 - false

            // dp[i] means the s[0:i] can be break

            for (int i = 0; i < s.length(); i++) {
                //s[0:j]
                for (int j = 0; j < i; j++) {
                    if(dp[j]==1&&stringSet.contains(s.substring(j,i+1))){
                        dp[i+1] = 1;
                    }
                }
                if(dp[i]==0)
                    dp[i]=2;
            }

            System.out.println("dp = " + Arrays.toString(dp));

            return dp[s.length()]==1;
        }

        //超时
        private boolean wordBreak(String s){
            boolean match = false;
            for (Integer length : lengthSet) {
                if(s.length()>=length&&stringSet.contains(s.substring(0,length))){
                    //包含
                    if(s.length()==length)
                        return true;

                    match = match||wordBreak(s.substring(length));
//                    System.out.println("s = " + s);
                }
            }

            return match;
        }

        private boolean wordBreak(String s,int i,int j){
            // 1 for true
            if(dp[i][j]==0){
//                System.out.println("dp = " + Arrays.deepToString(dp));
                boolean match = false;
                for (Integer length : lengthSet) {
                    if(j-i>=length&&stringSet.contains(s.substring(i,i+length))){
//                        System.out.println("s.substring(i,i+length) = " + s.substring(i, i + length));
                        if(j-i==length){
                            match=true;
                            break;
                        }

                        match = match||wordBreak(s,i+length,j);
                    }
                }

                dp[i][j] = match?1:2;

            }

            return dp[i][j]==1;
        }
    }
}
