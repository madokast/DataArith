package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.innerObject.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Given an integer n, generate all structurally unique BST's
 * (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * Data
 * 14:22
 *
 * @author zrx
 * @version 1.0
 */

public class Q0095UniqueBinarySearchTreesII implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build(3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        List<TreeNode> list = new ArrayList<>(5);
        list.add(TreeNode.make(new Integer[]{1, null, 3, 2}));
        list.add(TreeNode.make(new Integer[]{3, 2, null, 1}));
        list.add(TreeNode.make(new Integer[]{3, 1, null, null, 2}));
        list.add(TreeNode.make(new Integer[]{2, 1, 3}));
        list.add(TreeNode.make(new Integer[]{1, null, 2, null, 3}));
        return Answer.makeAnswerList(list);
    }

    public class Solution0095 {
        public List<TreeNode> generateTrees(int n) {
            //TODO
            return null;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
}
