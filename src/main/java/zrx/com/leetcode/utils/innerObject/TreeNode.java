package zrx.com.leetcode.utils.innerObject;

import zrx.com.leetcode.utils.MyRequire;

import java.nio.channels.Pipe;
import java.util.*;

/**
 * Description
 * 内置对象
 * /**
 *  * Definition for a binary tree node.
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 *
 * <p>
 * Data
 * 14:23
 *
 * @author zrx
 * @version 1.0
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 利用数组建立二叉树
     * 2020年1月10日 测试通过
     * @param leetCodeForm leetcode 里数组表示的二叉树
     * @return 二叉树
     */
    public static TreeNode make(Integer[] leetCodeForm){
        if(leetCodeForm.length==0||leetCodeForm[0]==null){
            return null;
        }

        TreeNode root = new TreeNode(leetCodeForm[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < leetCodeForm.length; i+=2) {
            Integer left = leetCodeForm[i];
            Integer right = i>=leetCodeForm.length-1?null:leetCodeForm[i+1];

            TreeNode poll = queue.poll();

            if(left!=null){
                Objects.requireNonNull(poll).left = new TreeNode(left);
                queue.add(Objects.requireNonNull(poll).left);
            }

            if(right!=null){
                Objects.requireNonNull(poll).right = new TreeNode(right);
                queue.add(Objects.requireNonNull(poll).right);
            }
        }


        return root;
    }

    /**
     * 将二叉树转换成 leetcode数组形式
     * 2020年1月10日 测试通过
     * @return leetcode 数组形式
     */
    public String toLeetCodeForm(){
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();

            if(poll==null){
                list.add(null);
            }else {
                list.add(poll.val);
                queue.add(poll.left);
                queue.add(poll.right);
            }

            boolean allNull = true;
            for (TreeNode treeNode : queue) {
                if(treeNode!=null){
                    allNull=false;
                }
            }
            if(allNull){
                break;
            }
        }

        return list.toString();
    }

    //错误的代码啊，哭哭哭
//    private static void make0(TreeNode root,Integer[] leetCodeForm,int i){
//        Integer left = i>=leetCodeForm.length?null:leetCodeForm[i];
//        Integer right = i+1>=leetCodeForm.length?null:leetCodeForm[i+1];
//
//        if(left==null&&right==null)
//            return;
//
//        if(left!=null){
//            root.left = new TreeNode(left);
//            make0(root.left,leetCodeForm,i+2);
//        }
//
//        if(right!=null){
//            root.right = new TreeNode(right);
//            make0(root.right,leetCodeForm,left==null?i+4:i+5);
//        }
//    }

    /**
     * 2020年1月10日 测试通过
     * @return 格式化打印数组
     */
    @Override
    public String toString(){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        queue.add(this);

        stringBuilder.append(nullOrVal(this)).append('\n');

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode left = getLeft(poll);
                TreeNode right = getRight(poll);

                queue2.add(left);
                queue2.add(right);
            }

            MyRequire.requireTrue(queue.size()==0);

            boolean allNull = true;
            for (TreeNode treeNode : queue2) {
                if(treeNode!=null){
                    allNull=false;
                }
            }

            if(!allNull){

                while (queue2.size()>0){
                    TreeNode poll = queue2.poll();
                    stringBuilder.append(nullOrVal(poll)).append("\t");
                    queue.add(poll);
                }
                stringBuilder.append('\n');
            }
        }

        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    private static String nullOrVal(TreeNode node){
        if(node==null)
            return "null";
        else
            return String.format("%4d",node.val);
    }

    private static TreeNode getLeft(TreeNode node){
        return node==null?null:node.left;
    }

    private static TreeNode getRight(TreeNode node){
        return node==null?null:node.right;
    }



    public String toStringParentAndChildren() {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.add(this);

        while (!queue.isEmpty()){
            TreeNode pop = queue.poll();
            TreeNode left = pop.left;
            TreeNode right = pop.right;

            if(right!=null||left!=null){
                stringBuilder.append(pointString(pop, left, right)).append('\n');
            }
            if(left!=null)
                queue.add(left);
            if(right!=null)
                queue.add(right);
        }

        return stringBuilder.toString();
    }

    private String pointString(TreeNode root,TreeNode left,TreeNode right){
        Objects.requireNonNull(root);

        return "{" + root.val + "->" +
                "(" + (left==null?null:left.val) + ", " +
                (right==null?null:right.val) +")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return this.toLeetCodeForm().equals(((TreeNode) o).toLeetCodeForm());
    }

    @Override
    public int hashCode() {
        return this.toLeetCodeForm().hashCode();
    }
}
