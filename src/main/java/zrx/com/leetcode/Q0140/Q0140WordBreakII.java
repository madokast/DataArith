package zrx.com.leetcode.Q0140;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given a non-empty string s and a dictionary wordDict containing
 * a list of non-empty words, add spaces in s to construct a sentence
 * where each word is a valid dictionary word. Return all such possible
 * sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in
 * the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary
 * word.
 * <p>
 * Data
 * 18:40
 *
 * @author zrx
 * @version 1.0
 */

public class Q0140WordBreakII implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("catsanddog", List.of("cat", "cats", "and", "sand", "dog")),
                Input.InputSet.build("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(List.of(
                "cats and dog",
                "cat sand dog"), List.of(
                        "pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple"));
    }

    public class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            //TODO

            return null;
        }
    }

}
