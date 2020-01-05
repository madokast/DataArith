package zrx.com.leetcode.Q0180;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Say you have an array for which the i-th element
 * is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on
 * day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on
 * day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell
 *              on day 6 (price = 3), profit = 3-0 = 3.
 * <p>
 * Data
 * 18:54
 *
 * @author zrx
 * @version 1.0
 */

public class Q0188BestTimeToBuyAndSellStockIV implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build(2,(Object) MyArrayTools.getIntArray(2,4,1)),
                Input.InputSet.build(2,(Object) MyArrayTools.getIntArray(3,2,6,5,0,3)),
                Input.InputSet.build(1000,(Object) MyArrayTools.getIntArray(7,1,5,3,6,4)),
                Input.InputSet.build(500,(Object) MyArrayTools.getIntArray(1,2,3,4,5)),
                Input.InputSet.build(0,(Object) MyArrayTools.getIntArray(1,2,3,4,5)),
                Input.InputSet.build(1000000000,(Object) MyArrayTools.getIntArray(1,2,3,4,5))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2,7,7,4,0,4);
    }

    public class Solution01888 {
        public int maxProfit(int k, int[] prices) {
            if(k<=0){
                return 0;
            }

            int max = 0;
            k = Math.min(k,prices.length);

            int[] buy = new int[k];
            int[] sell = new int[k];

            Arrays.fill(buy,Integer.MIN_VALUE);
            Arrays.fill(sell,0);

            for (int price : prices) {
                buy[0] = Math.max(buy[0],-price);
                sell[0] = Math.max(sell[0],buy[0]+price);
                max = Math.max(max,sell[0]);

                for (int i = 1; i < k; i++) {
                    buy[i] = Math.max(buy[i],sell[i-1]-price);
                    sell[i] = Math.max(sell[i],buy[i]+price);
                    max = Math.max(max,sell[i]);
                }

            }

            return max;
        }
    }
}
