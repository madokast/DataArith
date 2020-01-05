package zrx.com.leetcode.Q0120;

import org.jetbrains.annotations.NotNull;
import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

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
 * ----------------------------
 * Runtime: 6 ms, faster than 5.10% of Java online submissions for Best Time to Buy and Sell Stock II.
 * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
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
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 6, 4, 3, 1)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(3, 3))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(
                7, 4, 0, 0
        );
    }


    public class Solution0122 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }

            int times = Integer.MAX_VALUE;

            TreeMap<Integer, List<Transaction>> ifLinkTransportMap = new TreeMap<>();
            List<Transaction> transactionList = new ArrayList<>();

            int transactionIndex = 0;
            int upStart = -1;
            int upEnd = -1;
            Boolean isUp = null;
            int profit = 0;

            for (int i = 1; i < prices.length; i++) {
                int lastPrice = prices[i - 1];
                int currentPrice = prices[i];

                if (currentPrice > lastPrice) {
                    //上升
                    if (isUp == null) {
                        upStart = i - 1;
                    } else if (isUp == false) {
                        //上升之前是下降
                        upStart = i - 1;
                    } else {
                        //前面也是上升
                        //do nothing
                    }

                    isUp = true;
                } else if (currentPrice < lastPrice) {
                    //下降
                    if (isUp == null) {
                        //do nothing
                    } else if (isUp == true) {
                        //下降之前是上升
                        //记录交易
                        transactionList.add(new Transaction(transactionIndex++, prices[upStart], lastPrice));
                    } else {
                        //下降之前是下降
                        //do nothing
                    }
                    isUp = false;
                }
            }
            if (isUp != null && isUp) {
                //最后还是上升
                //则还有交易
                transactionList.add(new Transaction(transactionIndex, prices[upStart], prices[prices.length - 1]));
            }


//            printTransactions(transactionList);

            if (transactionList.size() == 0)
                return 0;

            profit += transactionList.get(0).profit;

            for (int i = 1; i < transactionList.size(); i++) {
                profit += transactionList.get(i).profit;
                Transaction linkTransaction = linkTransaction(transactionList.get(i - 1), transactionList.get(i));
                List<Transaction> linkTransportList = ifLinkTransportMap.getOrDefault(linkTransaction.profit, new ArrayList<>());
                linkTransportList.add(linkTransaction);
            }


            return profit;
        }

        //交易序列
        //可能的上升沿
        private class Transaction implements Comparable<Transaction> {
            int index;
            int min;
            int max;
            int profit;

            public Transaction(int index, int min, int max) {
                this.index = index;
                this.min = min;
                this.max = max;
                this.profit = max - min;
            }

            @Override
            public int compareTo(@NotNull Q0122BestTimeToBuyAndSellStockII.Solution0122.Transaction o) {
                return Integer.compare(index, o.index);
            }

            @Override
            public String toString() {
                return "Transaction{" +
                        "index=" + index +
                        ", min=" + min +
                        ", max=" + max +
                        ", profit=" + profit +
                        '}';
            }
        }

        private Transaction linkTransaction(Transaction t1, Transaction t2) {
            return new Transaction(t1.index, t1.min, t2.max);
        }

        private void printTransactions(List<Transaction> list) {
            System.out.println("*** 打印List<Transaction>");
            for (Transaction transaction : list) {
                System.out.println("*** " + transaction);
            }
            System.out.println("*** 打印完毕");
        }
    }
}
