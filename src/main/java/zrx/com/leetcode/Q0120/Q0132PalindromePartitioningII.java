package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * <p>
 * Data
 * 18:35
 *
 * @author zrx
 * @version 1.0
 */

public class Q0132PalindromePartitioningII implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("aab"),
                Input.InputSet.build("aabaa"),
                Input.InputSet.build("abaacaada"),
                Input.InputSet.build("a"),
                Input.InputSet.build("cabababcbc"),
                Input.InputSet.build("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfru" +
                        "qdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgx" +
                        "boycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankx" +
                        "bplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbv" +
                        "mpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxsee" +
                        "yeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjms" +
                        "wvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxr" +
                        "itygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqr" +
                        "tniznemxeahfozp"),
                Input.InputSet.build("abababababab"),
                Input.InputSet.build("aaabaa"),
                Input.InputSet.build("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbd" +
                        "dcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbe" +
                        "adbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddccc" +
                        "baedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebcc" +
                        "acacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadc" +
                        "ccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebd" +
                        "ebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccb" +
                        "ededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(1,0,2,0,3,452,1,1,273);
//        return Answer.makeAnswerList(1,0,2,0,3);
    }

    public class Solution0132 {
        //Runtime: 10 ms, faster than 51.23% of Java online submissions for Palindrome Partitioning II.
        //Memory Usage: 36.9 MB, less than 37.50% of Java online submissions for Palindrome Partitioning II.
        public int minCut(String s){
            if(s==null||s.length()==0)
                return 0;
            if(s.length()==1)
                return 0;

            //dpp[i,j] 表示s[i:j]是不是回文串
            boolean dpp[][] = new boolean[s.length()][];
            for (int i = 0; i < dpp.length; i++) {
                dpp[i] = new boolean[s.length()];
            }

            for (int i = 0; i < s.length(); i++) {
                dpp[i][i]=true;
            }

            for (int i = 0; i < s.length() * 2 - 1; i++) {
//                System.out.println("i = " + i);
                int j = i/2;
                if(i%2==0){
                    int k = 1;
                    while (j+k<s.length()&&j-k>=0){
                        if(s.charAt(j+k)==s.charAt(j-k)){
                            dpp[j-k][j+k] = true;
                            k++;
                        }else
                            break;
                    }
                }else {
                    int k1 = j;
                    int k2 = j+1;

                    while (k1>=0&&k2<s.length()){
                        if(s.charAt(k1)==s.charAt(k2)){
//                            System.out.println("k1k2 = " + k1+k2);
                            dpp[k1][k2] = true;
                            k1--;
                            k2++;
                        }else
                            break;
                    }
                }
            }


            int[] dp = new int[s.length()];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 1; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    // str0 = 0
                    // end0 = j //ex
                    // str1 = j
                    // end1 = i //in

                    if(dpp[j][i]){
//                        System.out.println("ij = " +i+ j);
                        dp[i] = Math.min(dp[i],(j==0?0:dp[j-1]+1));
                    }
                }
            }



            System.out.println("错误答案1：" + minCut0(s));
            System.out.println("错误答案2：" + minCut1(s));
            System.out.println("快速解法：" + minCut2(s));

//            System.out.println("dpp = " + Arrays.deepToString(dpp));
            System.out.println("dp = " + Arrays.toString(dp));

            return dp[dp.length-1];
        }

        //急速法
        //Runtime: 4 ms, faster than 96.72% of Java online submissions for Palindrome Partitioning II.
        //Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Palindrome Partitioning II.
        private int minCut2(String s){
            int[] dp = new int[s.length()+1];
            Arrays.fill(dp,s.length()+1);
            dp[0] = -1;
//            dp[1] = 0;

            char[] chars = s.toCharArray();

            int len;
            for (int i = 0; i < chars.length; i++) {
                len=0;
                while (i+len<chars.length&&i-len>=0&&chars[i+len]==chars[i-len]){

                    dp[i+len+1] = Math.min(dp[i+len+1],dp[i-len]+1);
                    len++;
                }

                len = 0;
                while (i-len>=0&&i+len+1<chars.length&&chars[i-len]==chars[i+len+1]){
                   dp[i+len+2] = Math.min(dp[i+len+2],dp[i-len]+1);

                    len++;
                }
            }

            return dp[dp.length-1];
        }

        //错误答案
        private int minCut1(String s){
            if(s==null||s.length()==0)
                return 0;
            if(s.length()==1)
                return 0;

            //dpp[i,j] 表示s[i:j]是不是回文串
            boolean dpp[][] = new boolean[s.length()][];
            for (int i = 0; i < dpp.length; i++) {
                dpp[i] = new boolean[s.length()];
            }

            for (int i = 0; i < s.length(); i++) {
                dpp[i][i]=true;
            }

            for (int i = 0; i < s.length() * 2 - 1; i++) {
//                System.out.println("i = " + i);
                int j = i/2;
                if(i%2==0){
                    int k = 1;
                    while (j+k<s.length()&&j-k>=0){
                        if(s.charAt(j+k)==s.charAt(j-k)){
                            dpp[j-k][j+k] = true;
                            k++;
                        }else
                            break;
                    }
                }else {
                    int k1 = j;
                    int k2 = j+1;

                    while (k1>=0&&k2<s.length()){
                        if(s.charAt(k1)==s.charAt(k2)){
//                            System.out.println("k1k2 = " + k1+k2);
                            dpp[k1][k2] = true;
                            k1--;
                            k2++;
                        }else
                            break;
                    }
                }
            }

            int ret = 0;
            int i = 0;
            while (i!=s.length()){

                for (int j = s.length()-1; j >= 0; j--) {
                    if(dpp[i][j]){
                        i=j+1;
                        ret++;
                        break;
                    }
                }
            }

            return ret-1;
        }


        //注意这个答案是错误的
        private int minCut0(String s) {
            if(s==null||s.length()==0)
                return 0;
            if(s.length()==1)
                return 0;

            //数组存放的是 回文串的头字母的index
            int[][] cutTails = new int[s.length()][];
            cutTails[0] = new int[]{0};

            char charInLastEqualString = s.charAt(0);

            for (int i = 1; i < s.length(); i++) {
                if(cutTails[i-1].length==1){
                    //s[0:i-1]是回文串
                    if(charInLastEqualString==s.charAt(i)){
                        //单字母回文串继续延长
                        cutTails[i] = cutTails[i-1];
                    }else {
                        charInLastEqualString = s.charAt(i);
                        cutTails[i] = new int[]{0,i};
                    }
                }else {
                    //不止一个回文串了
                    if(charInLastEqualString==s.charAt(i)){
                        //单字母回文串继续延长
                        cutTails[i] = cutTails[i-1];
                    }else {
                        int lastHead = cutTails[i - 1][cutTails[i - 1].length - 1];
                        int lastButHead = cutTails[i - 1][cutTails[i - 1].length - 2];
                        if(s.charAt(lastHead -1)==s.charAt(i)){
                            //合并
                            if((lastHead -1)== lastButHead){
                                //合并两个落单
                                cutTails[i] = Arrays.copyOf(cutTails[i-1],cutTails[i-1].length-1);
                                charInLastEqualString = ' ';//null
                            }else {
                                boolean bug = s.charAt(i)==s.charAt(lastButHead);
                                if(bug){
                                    for (int j = lastButHead+1,k = i-1; j < k; j++,k--) {
                                        if(!(s.charAt(j)==s.charAt(k))){
                                            bug=false;
                                            break;
                                        }
                                    }
                                }
                                if(bug){
                                    cutTails[i] = Arrays.copyOf(cutTails[i-1],cutTails[i-1].length-1);
                                }else {
                                    //出现新宝宝
                                    cutTails[i] = Arrays.copyOf(cutTails[lastHead -2],
                                            cutTails[lastHead -2].length+1);
                                    cutTails[i][cutTails[i].length-1] = lastHead -1;
                                }

                                charInLastEqualString = ' ';//null

                            }
                        }else {
                            //落单了
                            cutTails[i] = Arrays.copyOf(cutTails[i-1],cutTails[i-1].length+1);
                            cutTails[i][cutTails[i-1].length] = i;

                            charInLastEqualString=s.charAt(i);
                        }
                    }
                }
            }

//            System.out.println("cutTails = " + Arrays.deepToString(cutTails));

            return cutTails[s.length()-1].length-1;
        }
    }
}
