package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.DesignPatterns.CompositePattern.ItemIterator;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.innerObject.TreeNode;

import java.util.Objects;

/**
 * Description
 * TreeNodeTest
 * @see zrx.com.leetcode.utils.innerObject.TreeNode
 * <p>
 * Data
 * 15:02
 *
 * @author zrx
 * @version 1.0
 */

public class TreeNodeTest {
    @Test
    public void test01(){
        MyTools.printCurrentMethod(true);
        Integer[][] integers = new Integer[][]{
                new Integer[]{1,null,3,2},
                new Integer[]{3,2,null,1},
                new Integer[]{3,1,null,null,2},
                new Integer[]{2,1,3},
                new Integer[]{1,null,2,null,3},
        };

        for (Integer[] integer : integers) {
            System.out.println(Objects.requireNonNull(TreeNode.make(integer)).toLeetCodeForm());
            System.out.println(TreeNode.make(integer));
        }
    }

    @Test
    public void toLeetCodeFormTest(){
        MyTools.printCurrentMethod(true);

        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};

        TreeNode make = TreeNode.make(nums);

        System.out.println(make.toLeetCodeForm());
    }

    @Test
    public void testLeetCodeForm(){
        MyTools.printCurrentMethod(true);

        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};

        TreeNode make = TreeNode.make(nums);

        System.out.println(make);
    }

    @Test
    public void testToString(){
        MyTools.printCurrentMethod(true);
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(root.toStringParentAndChildren());
        System.out.println(root);
    }
}
