package zrx.com.others.dateAndArith;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyRandom;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description
 * 单调栈
 * <p>
 * Data
 * 22:55
 *
 * @author zrx
 * @version 1.0
 */

public class MonotonicStack {

    public static void learn(){
        new MonotonicStack().test();
    }

    private void test(){
        MyTools.printCurrentMethod(true);
        int[] randomIntArray = MyRandom.randomIntArray(100, 10);
        System.out.println(Arrays.toString(randomIntArray));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < randomIntArray.length; i++) {
            while (!stack.empty()&&randomIntArray[stack.peek()]>randomIntArray[i])
                stack.pop();

            if(stack.size()==0){
                System.out.println(String.format("在%d[%d]左边没有比他更小的元素了",randomIntArray[i],i));
            }else {
                System.out.println(String.format("比%d[%d]小的左边的、最近的元素是%d[%d]",
                        randomIntArray[i],i,randomIntArray[stack.peek()],stack.peek().intValue()
                ));
            }

            stack.push(i);
        }
    }

}
