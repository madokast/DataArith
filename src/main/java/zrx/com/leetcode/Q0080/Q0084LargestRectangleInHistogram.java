package zrx.com.leetcode.Q0080;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyPrinter;

import java.util.*;

/**
 * Description
 * Given n non-negative integers representing the histogram's
 * bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given
 *  height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * ---------------------
 * 方法一，分治法
 * Runtime: 183 ms, faster than 22.46% of Java online submissions for Largest Rectangle in Histogram.
 * Memory Usage: 42.9 MB, less than 6.82% of Java online submissions for Largest Rectangle in Histogram.
 *
 * 方法二：单调栈
 * Runtime: 22 ms, faster than 25.43% of Java online submissions for Largest Rectangle in Histogram.
 * Memory Usage: 41.3 MB, less than 63.64% of Java online submissions for Largest Rectangle in Histogram.
 *
 * 把栈换成数组
 * Runtime: 3 ms, faster than 91.52% of Java online submissions for Largest Rectangle in Histogram.
 * Memory Usage: 40.9 MB, less than 79.55% of Java online submissions for Largest Rectangle in Histogram.
 * <p>
 * Data
 * 19:15
 *
 * @author zrx
 * @version 1.0
 */

public class Q0084LargestRectangleInHistogram implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2,1,5,6,2,3)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2,1,2))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(10,3);
    }

    public class Solution0084 {
        //方法一，分治法
        //方法二：单调栈
        public int largestRectangleArea(int[] heights) {
            if(heights.length==0)
                return 0;
            if(heights.length==1)
                return heights[0];
            if(heights.length==2)
                return Math.max(Math.max(heights[0],heights[1]),
                        Math.min(heights[0],heights[1])*2);



//            Stack<Integer> leftStack = new Stack<>();
//            Stack<Integer> rightStack = new Stack<>();

            int[] stack = new int[heights.length];
            int si = -1;

            int[] max = new int[heights.length];
            Arrays.fill(max,0);

            int maxMax = 0;
            for (int i = 0; i < heights.length; i++) {
                while (si>=0&&heights[stack[si]]>=heights[i]){
                    System.out.println("单调栈：" + Arrays.toString(Arrays.copyOf(stack,si+1)));
//                    System.out.println("leftStack = " + leftStack);
                    int pop = stack[si--];
                    max[pop] = Math.max(max[pop],heights[pop]*(si==-1?i:i-stack[si]-1));
                    maxMax = Math.max(max[pop],maxMax);

//                    System.out.println("pop = " + pop);
//                    MyPrinter.printIntArray(max);
                }
                ++si;
                stack[si] = i;
            }

            while (si>=0){
                System.out.println("单调栈：" + Arrays.toString(Arrays.copyOf(stack,si+1)));
                int pop = stack[si--];
                max[pop] = Math.max(max[pop],heights[pop]*(si==-1?heights.length:heights.length-stack[si]-1));
                maxMax = Math.max(max[pop],maxMax);

//                System.out.println("pop = " + pop);
//                MyPrinter.printIntArray(max);
            }

//            MyPrinter.printIntArray(max);

//            for (int i = heights.length - 1; i >= 0; i--) {
//                while (si>0&&heights[stack[si]]>heights[i]){
//                    int pop = stack[si--];
//                    max[pop] = Math.max(max[pop],max[pop]+heights[pop]*(pop-i-1));
//                    maxMax = Math.max(max[pop],maxMax);
//                }
//
//                stack[++si] = i;
//            }
//
//            while (si>0){
//                int pop = stack[si--];
//                max[pop] = Math.max(max[pop],max[pop]+heights[pop]*(pop-(-1)-1));
//                maxMax = Math.max(max[pop],maxMax);
//            }
//
//
//            MyPrinter.printIntArray(max);

//            int i = largestRectangleArea(heights, 0, heights.length);

            return maxMax;
        }



        private int largestRectangleArea(int[] heights,int startIncluding, int endExcluding){
            if(endExcluding<=startIncluding)
                return 0;

            int min = heights[startIncluding];
            int minIndex = startIncluding;
            for (int i = startIncluding; i < endExcluding; i++) {
                if(heights[i]<min){
                    min = heights[i];
                    minIndex = i;
                }
            }

//            System.out.println("minIndex = " + minIndex);
//            System.out.println("startIncluding = " + startIncluding);
//            System.out.println("endExcluding = " + endExcluding);
//            System.out.println("------------------");

            return Math.max(
                    min*(endExcluding-startIncluding),
                    Math.max(
                            largestRectangleArea(heights,startIncluding,minIndex),
                            largestRectangleArea(heights,minIndex+1,endExcluding)
                    )
            );
        }
    }
}
