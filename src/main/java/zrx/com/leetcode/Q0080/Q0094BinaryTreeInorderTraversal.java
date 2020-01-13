package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.innerObject.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * Given a binary tree, return the inorder
 * traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * <p>
 * Data
 * 15:08
 * ------------------
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 35.4 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0094BinaryTreeInorderTraversal implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build(TreeNode.make(new Integer[]{1, null, 2, 3}))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(Arrays.asList(1, 3, 2));
    }

    public class Solution0094 {
        public List<Integer> inorderTraversal(TreeNode root){
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;

            Stack<TreeNode> stack = new Stack<>();

//            stack.push(root);

            TreeNode p = root;
            while (p!=null||!stack.isEmpty()){
                while (p!=null){
                    stack.push(p);
                    p = p.left;
                }

                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }

            System.out.println("递归和非递归：" + inorderTraversal0(root));
            return list;
        }

        private List<Integer> inorderTraversal0(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            if (root == null)
                return list;

            inorderTraversal(root, list);
            return list;
        }

        private void inorderTraversal(TreeNode root, List<Integer> list) {
            if (root.left != null) inorderTraversal(root.left, list);
            list.add(root.val);
            if (root.right != null) inorderTraversal(root.right, list);
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
