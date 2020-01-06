package zrx.com.leetcode.Q0060;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner
 * of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach
 * the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 * <p>
 * Data
 * 10:24
 *
 * -----------------
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
 * Memory Usage: 32.7 MB, less than 5.10% of Java online submissions for Unique Paths.
 * ------------------
 *
 * @author zrx
 * @version 1.0
 */

public class Q0062UniquePaths implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build(3, 2),
                Input.InputSet.build(7, 3),
                Input.InputSet.build(10, 10),
                Input.InputSet.build(23, 12)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(3, 28, 48620, 193536720);
    }

    public class Solution0062 {
        public int uniquePaths(int m, int n) {
//            System.out.println("p(m+n-2) = " + p(m + n - 2));
//
//            return (int)(p(m+n-2)/p(m-1)/p(n-1));

//            BigInteger[] map = map(m + n - 2);
//
//            return map[m+n-2].divide(map[m-1]).divide(map[n-1]).intValue();

//            int max = Math.max(m,n);
//            int min = Math.min(m,n);
//
//            return (int)(p(m+n+2,max)/p(min-1));

//            List<Integer> mnL = new ArrayList<>(m + n);
//            for (int i = 0; i < m + n - 2; i++) {
//                mnL.add(i + 1);
//            }
//
//            List<Integer> mL = new ArrayList<>(m);
//            for (int i = 0; i < m-1; i++) {
//                mL.add(i + 1);
//            }
//
//            List<Integer> nL = new ArrayList<>(n);
//            for (int i = 0; i < n-1; i++) {
//                nL.add(i + 1);
//            }
//
//            long ret = 1;
//            long tryAns;
//
//            System.out.println("mnL = " + mnL);
//            System.out.println("nL = " + nL);
//            System.out.println("mL = " + mL);
//
//            while (mnL.size() > 0 || nL.size() > 0 || mL.size() > 0) {
//                for (Integer integer : mnL) {
//                    tryAns = ret;
//                    tryAns *= integer;
//                    if (tryAns / integer == ret) {
//                        ret = tryAns;
//                        mnL.remove(integer);
//                        break;
//                    }
//                }
//
//                for (Integer integer : nL) {
//                    tryAns = ret;
//                    tryAns /= integer;
//                    if (tryAns * integer == ret) {
//                        ret = tryAns;
//                        nL.remove(integer);
//                        break;
//                    }
//                }
//
//
//                for (Integer integer : mL) {
//                    tryAns = ret;
//                    tryAns /= integer;
//                    if (tryAns * integer == ret) {
//                        ret = tryAns;
//                        mL.remove(integer);
//                        break;
//                    }
//                }
//            }
//
//            System.out.println("mnL = " + mnL);
//            System.out.println("nL = " + nL);
//            System.out.println("mL = " + mL);

            long ret = 1;
            long tryAns;
            int mul = m+n-2;
            m--;n--;

            while (mul>1||m>1||n>1){
                while (mul>1){
                    tryAns = ret;
                    tryAns*=mul;
                    if(tryAns/mul==ret){
                        ret=tryAns;
                        mul--;
                    }else
                        break;
                }

                while (m>1){
                    tryAns = ret;
                    tryAns/=m;
                    if(tryAns*m==ret){
                        ret=tryAns;
                        m--;
                    }else
                        break;
                }

                while (n>1){
                    tryAns = ret;
                    tryAns/=n;
                    if(tryAns*n==ret){
                        ret=tryAns;
                        n--;
                    }else
                        break;
                }
            }

            return (int) ret;

        }

        private long p(long n) {
            long ret = 1;
            while (n > 1) {
                ret *= n;
                n--;
            }

            return ret;
        }

        private long p(long n, long m) {
            long ret = m;
            while (n > m) {
                ret *= n;
                n--;
            }

            return ret;
        }

//        private BigInteger[] map(int max){
//            BigInteger[] bigIntegers = new BigInteger[max+1];
//            bigIntegers[1] = BigInteger.valueOf(1);
//
//            for (int i = 2; i < bigIntegers.length; i++) {
//                bigIntegers[i] = bigIntegers[i-1].multiply(BigInteger.valueOf(i));
//            }
//
//            return bigIntegers;
//        }
    }
}
