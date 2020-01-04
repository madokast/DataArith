package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * Say you have an array for which the ith element is
 * the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one
 * transaction (i.e., buy one and sell one share of the
 * stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day
 * 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than
 * buying price.
 * <p>
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done,
 * i.e. max profit = 0.
 * <p>
 * Data
 * 2019/12/24 14:50
 * ----------------------
 *
 * Runtime: 1 ms, faster than 62.37% of Java online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 37.9 MB, less than 98.23% of Java online submissions for Best Time to Buy and Sell Stock.
 *
 * 我成了
 *
 * ---------------------------
 * 最优解法
 *
 class Solution {
 public int maxProfit(int[] prices) {
 if (prices == null || prices.length < 1) {
 return 0;
 }
 int max = 0;
 int min = prices[0];
 for(int i = 0; i <prices.length ; i++){
 if (prices[i] < min)
 min = prices[i];
 else{
 if(max < prices[i] - min)
 max = prices[i] - min;
 }
 }
 return max;
 }

 ————————————————
 版权声明：本文为CSDN博主「想做程序媛的小太阳」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/weixin_41876155/article/details/80036893
 *
 * @author zrx
 * @version 1.0
 */

public class Q0121BestTimeToBuyAndSellStock implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 1, 5, 3, 6, 4)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 6, 4, 3, 1))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(5, 0);
    }

    public class Solution0121 {
        public int maxProfit(int[] prices) {
            if(prices.length==0)
                return 0;

            int currentMin = prices[0];
            Integer theMaxAfterCurrentMin = null;

            int result = 0;

            for (int i = 1; i < prices.length; i++) {
                if(prices[i]<currentMin){
                    //更小的值出现了
                    currentMin = prices[i];
                    theMaxAfterCurrentMin = null;
                }else {
                    theMaxAfterCurrentMin = prices[i];
                }

                //计算收益
                if(theMaxAfterCurrentMin!=null){
                    int currentResult = theMaxAfterCurrentMin - currentMin;
                    if(currentResult>result){
                        result  = currentResult;
                    }
                }
            }

            return result;
        }
    }
}
