package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

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
                Input.InputSet.build("catsandog",List.of("cats", "dog", "sand", "and", "cat"))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(true,true,false);
    }

    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            //TODO

            return false;
        }
    }
}
