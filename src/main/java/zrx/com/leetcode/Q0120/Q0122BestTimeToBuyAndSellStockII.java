package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 *
 * <p>
 * Data
 * 2020年1月4日
 * <p>
 * Say you have an array for which the ith element
 * is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple
 * times).
 * <p>
 * Note: You may not engage in multiple transactions at
 * the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on
 * day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell
 * on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day
 * 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on
 * day 2 and sell them later, as you are
 * engaging multiple transactions at the same
 * time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done,
 * i.e. max profit = 0.
 *
 * @author zrx
 * @version 1.0
 */


public class Q0122BestTimeToBuyAndSellStockII implements Question {

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 1, 5, 3, 6, 4)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1, 2, 3, 4, 5)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 6, 4, 3, 1))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(
                7, 4, 0
        );
    }


    class Solution0122 {
        public int maxProfit(int[] prices) {
            //TODO
            return 0;
        }
    }
}
