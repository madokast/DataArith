package zrx.com.leetcode.Q0120;

import org.jetbrains.annotations.NotNull;
import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description
 * <p>
 * Say you have an array for which the ith element
 * is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions
 * at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell
 * on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and
 * sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell
 * on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1,
 * buy on day 2 and sell them later, as you are
 * engaging multiple transactions at
 * the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is
 * done, i.e. max profit = 0.
 * <p>
 * 不会做
 * <p>
 * ----------------
 * class Solution {
 * public int maxProfit(int[] prices) {
 * int min1=Integer.MAX_VALUE;
 * int profit1=0;
 * int min_combined=Integer.MAX_VALUE;
 * int profit_combined=0;
 * for(int p:prices){
 * min1=Math.min(min1,p);
 * profit1=Math.max(profit1,p-min1);
 * min_combined=Math.min(min_combined,p-profit1);
 * profit_combined=Math.max(profit_combined,p-min_combined);
 * }
 * return profit_combined;
 * }
 * }
 * ----------------------
 *
 * 状态转移万岁
 *
 * Runtime: 1 ms, faster than 99.55% of Java online submissions for Best Time to Buy and Sell Stock III.
 * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock III.
 *
 *
 *
 * <p>
 * Data
 * 2020年1月4日
 * <p>
 *
 * @author zrx
 * @version 1.0
 */


public class Q0123BestTimeToBuyAndSellStockIII implements Question {

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(3, 3, 5, 0, 0, 3, 1, 4)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1, 2, 3, 4, 5)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 6, 4, 3, 1)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(
                6, 4, 0, 11, 17
        );
    }

    public class Solution0123 {
        public int maxProfit(int[] prices) {
            int buy1 = Integer.MIN_VALUE;
            int sell1 = 0;
            int buy2 = Integer.MIN_VALUE;
            int sell2 = 0;

            for (int price : prices) {
                buy1 = Math.max(buy1, -price);
                sell1 = Math.max(sell1,buy1+price);
                buy2 = Math.max(buy2,sell1 - price);
                sell2 = Math.max(sell2,buy2+price);
            }

            return sell2;
        }
    }

    private class 错误解法 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }

            int times = 2;

            TreeMap<Integer, Integer> ifLinkTransportMap = new TreeMap<>();
            TreeMap<Integer, Transaction> transactionTreeMap = new TreeMap<>();
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
            transactionTreeMap.put(transactionList.get(0).profit, transactionList.get(0));

            for (int i = 1; i < transactionList.size(); i++) {
                profit += transactionList.get(i).profit;
                transactionTreeMap.put(transactionList.get(i).profit, transactionList.get(i));

                Transaction previousTransaction = transactionList.get(i - 1);
                Transaction currentTransaction = transactionList.get(i);


                Transaction linkTransaction = linkTransaction(previousTransaction, currentTransaction);

                int key = linkTransaction.profit - previousTransaction.profit - currentTransaction.profit;

                Integer value = ifLinkTransportMap.getOrDefault(
                        key,
                        0
                );

                ifLinkTransportMap.put(key, value + 1);


            }

            int size = transactionList.size();

            printTransactions(transactionList);
            System.out.println("ifLinkTransportMap = " + ifLinkTransportMap);

            while (size > times) {
                Map.Entry<Integer, Integer> entry = ifLinkTransportMap.lastEntry();
                Map.Entry<Integer, Transaction> firstEntry = transactionTreeMap.firstEntry();

                Integer key = entry.getKey();
                Integer firstEntryKey = firstEntry.getKey();

                if (-key < firstEntryKey) {
                    profit += key;

                    Integer value = entry.getValue();
                    value--;
                    if (value == 0) {
                        ifLinkTransportMap.remove(key);
                    }
                } else {
                    profit -= firstEntryKey;

                    Transaction value = firstEntry.getValue();
                    int index = value.index;
                    if (index != 0) {
                        int previous = index - 1;

                        Transaction t1 = transactionList.get(previous);
                        Transaction t2 = transactionList.get(index);

                        Transaction linktransaction = linkTransaction(t1, t2);

                        int kkey = linktransaction.profit - t1.profit - t2.profit;

                        Integer integer = ifLinkTransportMap.get(kkey);

                        ifLinkTransportMap.put(kkey, integer - 1);
                    }
                }


                size--;
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
            public int compareTo(Transaction o) {
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
