package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given n, how many structurally unique BST's (binary search trees)
 * that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * <p>
 * Data
 * 14:34
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
 * Memory Usage: 33.6 MB, less than 5.55% of Java online submissions for Unique Binary Search Trees.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0096UniqueBinarySearchTrees implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build(3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(5);
    }

    public class Solution0096 {
        public int numTrees(int n) {
            if(n<=0) return 0;
            int[] arr = new int[n+1];
            arr[0] = 1;
            arr[1] = 1;
            if(n==1) return 1;
            arr[2] = 2;
            if(n==2) return 2;

            for (int i = 3; i <=n ; i++) {
                for (int j = 0; j <= i-1; j++) {
                    arr[i]+= arr[j]*arr[i-1-j];
                }
            }

            return arr[n];
        }
    }

}
