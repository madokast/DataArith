package zrx.com.leetcode.Q0020;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyRequire;
import zrx.com.others.COSY.SR;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Description
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * <p>
 * Data
 * 13:25
 * <p>
 * ---------------------------------
 * 两个方法，栈法/动态规划
 *
 * @author zrx
 * @version 1.0
 */

public class Q0032LongestValidParentheses implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("(()"),
                Input.InputSet.build(")()())"),
                Input.InputSet.build("()()"),
                Input.InputSet.build("(()()"),
                Input.InputSet.build("(()()(())(("),
                Input.InputSet.build(")()(((())))(")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2, 4, 4, 4, 8, 10);
    }

    public class Solution0032 {
        public int longestValidParentheses(String s) {
            int dynamic = dynamic(s);
            int stack = stack(s);
            System.out.println("dynamic = " + dynamic);
            System.out.println("stack = " + stack);
//            MyRequire.requireTrue(dynamic==stack);
            return stack;
        }

        //栈法
        //Runtime: 7 ms, faster than 21.59% of Java online submissions for Longest Valid Parentheses.
        //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Longest Valid Parentheses.
        private int stack(String s) {
            Stack<Integer> stack = new Stack<>();
            int empty = -1;
            int max = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else {
                    //')'
                    if (stack.empty()) {
                        max = Math.max(max, i - empty - 1);
                        empty = i;
                    } else {
                        int pop = stack.pop();
                        max = Math.max(max, i - pop + 1);
                    }
                }
            }

            if (stack.empty()) {
                max = Math.max(max, s.length() - empty - 1);
            } else {
                int pop = stack.pop();
                max = Math.max(max, s.length() - pop - 1);
                while (!stack.empty()) {
                    int pop2 = stack.pop();
                    max = Math.max(max, pop - pop2 - 1);
                    pop = pop2;
                }

                max = Math.max(max, pop - empty - 1);
            }

            return max;
        }

        private int[] longestMathAt;

        //动态规划
        //Runtime: 2 ms, faster than 70.47% of Java online submissions for Longest Valid Parentheses.
        //Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Longest Valid Parentheses.
        private int dynamic(String s) {
            longestMathAt = new int[s.length()];
            Arrays.fill(longestMathAt, 0);

            int max = 0;
            for (int i = 0; i < longestMathAt.length; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    longestMathAt[i] = 0;
                } else {//')'
                    if (i >= 1 && s.charAt(i - 1) == '(') {
                        longestMathAt[i] = 2 + (i >= 2 ? longestMathAt[i - 2] : 0);
                    } else if (i >= 1 && s.charAt(i - 1) == ')' &&
                            (i - longestMathAt[i - 1] - 1 >= 0) &&
                            s.charAt(i - longestMathAt[i - 1] - 1) == '(') {//'))'
                        longestMathAt[i] = 2 + longestMathAt[i - 1] +
                                ((i - longestMathAt[i - 1] - 2) >= 0 ? longestMathAt[i - longestMathAt[i - 1] - 2] : 0);
                    }
                }

                max = Math.max(max, longestMathAt[i]);
            }


            return max;
        }
    }
}
