package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Given two words word1 and word2, find the minimum number
 * of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * <p>
 * Data
 * 11:22
 * -----------------------------
 * Runtime: 7 ms, faster than 40.76% of Java online submissions for Edit Distance.
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Edit Distance.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0072EditDistance implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("horse","ros"),
                Input.InputSet.build("ros","horse"),
                Input.InputSet.build("intention","execution"),
                Input.InputSet.build("execution","intention"),
                Input.InputSet.build("","i"),
                Input.InputSet.build("a","a")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(3,3,5,5,1,0);
    }

    public class Solution0072 {
        private int[][] arr;

        public int minDistance(String word1, String word2) {
            if(word1.length()==0){
                return word2.length();
            }
            if(word2.length()==0){
                return word1.length();
            }

            arr = new int[word1.length()+1][];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new int[word2.length()+1];
                Arrays.fill(arr[i],-1);
            }

            int ret = minDistance(word1,word1.length(),word2,word2.length());

            System.out.println("动态规划数组：" + ToString.intArrArrToString(arr));

            return ret;
        }

        private int minDistance(String word1,int i, String word2 ,int j){
            if(arr[i][j]!=-1){
                return arr[i][j];
            }

            arr[i][j]=min(
                    i>0?minDistance(word1,i-1,word2,j)+1:j,
                    j>0?minDistance(word1,i,word2,j-1)+1:i,
                    i>0&&j>0?minDistance(word1,i-1,word2,j-1)+(word1.charAt(i-1)==word2.charAt(j-1)?0:1):Math.max(i,j)
            );

            return arr[i][j];
        }

        private int min(int x,int y,int z){
            return Math.min(Math.min(x,y),z);
        }
    }
}
