package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.EqualMethod;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.innerObject.TreeNode;

import java.util.*;

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
 *
 * ------------------
 * Runtime: 2 ms, faster than 37.87% of Java online submissions for Unique Binary Search Trees II.
 * Memory Usage: 39.7 MB, less than 50.00% of Java online submissions for Unique Binary Search Trees II.
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
        public List<TreeNode> generateTrees(int n){
            if(n==0) return new LinkedList<>();
            List<TreeNode> list = generateTrees(1, n);
            System.out.println("和暴力法对比：" +
                    (EqualMethod.listEqual(list,generateTrees0(n))));
            return list;
        }

        private List<TreeNode> generateTrees(int startIn, int endIn){
            List<TreeNode> list = new LinkedList<>();

            if(startIn>endIn)
                list.add(null);

            for (int i = startIn; i <= endIn ; i++) {
                List<TreeNode> leftList = generateTrees(startIn, i - 1);
                List<TreeNode> rightList = generateTrees(i + 1, endIn);

                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }

            return list;
        }

        private List<TreeNode> generateTrees0(int n) {
            List<TreeNode> list = new LinkedList<>();
            if(n==0) return list;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=i+1;
            }

            list.add(TreeNode.makeSearchTree(arr));

            if(n==1) return list;

            while (true){
                if(arr[n-1]>arr[n-2]){
                    swap(arr,n-1,n-2);
                }
                else {
                    int head = -1;
                    for (int i = arr.length - 1; i >= 1; i--) {
                        if(arr[i]>arr[i-1]){
                            head = i-1;
                            break;
                        }
                    }
                    if(head==-1){
                        for (TreeNode treeNode : list) {
                            System.out.println(treeNode.toLeetCodeForm());
                        }
                        return list;
                    }

                    int swap = head;
                    for (int i = head + 1; i < arr.length; i++) {
                        if(arr[i]<arr[head]){
                            swap = i-1;
                            break;
                        }
                    }
                    if(swap==head){
                        swap = arr.length-1;
                    }

                    swap(arr,swap,head);

                    Arrays.sort(arr,head+1,arr.length);
                }

//                System.out.println("arr = " + Arrays.toString(arr));

                TreeNode treeNode = TreeNode.makeSearchTree(arr);
                if(!list.contains(treeNode))
                    list.add(treeNode);

//                boolean e = false;
//                for (TreeNode node : list) {
//                    if(equals(node,treeNode)){
//                        e=true;
//                    }
//                }
//                if(!e){
//                    list.add(treeNode);
//                }
            }
        }


//        private int[][] arrange(int n){
//            if(n==1){
//                return new int[][]{
//                        new int[]{1}
//                };
//            }
//
//            if(n==2){
//                return new int[][]{
//                        new int[]{1,2},
//                        new int[]{2,1}
//                };
//            }
//
//            int[][] ret = new int[factorial(n)][];
//
//            int[] arr = new int[n];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = i+1;
//            }
//
//            ret[0] = arr;
//
//            int[] temp = Arrays.copyOf(arr,arr.length);
//            for (int i = 0; i < ret.length-1; i++) {
//                if(temp[temp.length-1]>temp[temp.length-2]){
//                    swap(temp,temp.length-1,temp.length-2);
//                }else {
//                    for (int i1 = temp.length - 1; i1 >= 0; i1--) {
//
//                    }
//                }
//            }
//        }

        private void swap(int[] ints,int i,int j){
//            System.out.println("---------");
//            System.out.println("ints/i/j = " + Arrays.toString(ints)+"/"+i+'/'+j);

            if(i==j)
                return;

            ints[i] = ints[i]^ints[j];
            ints[j] = ints[i]^ints[j];
            ints[i] = ints[i]^ints[j];

//            System.out.println("ints/i/j = " + Arrays.toString(ints)+"/"+i+'/'+j);
        }

        private int factorial(int n){
            if(n==1)
                return 1;
            else
                return factorial(n-1)*n;
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
