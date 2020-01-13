package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
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
                Input.InputSet.build("aabcc","dbbca","aadbbcbcac"),
                Input.InputSet.build("aabcc","dbbca","aadbbbaccc")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(true,false);
    }

    public class Solution0097 {
        public boolean isInterleave(String s1, String s2, String s3) {

            //TODO

            return false;
        }
    }
}
