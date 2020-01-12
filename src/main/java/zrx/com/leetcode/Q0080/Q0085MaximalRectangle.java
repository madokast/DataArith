package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyPrinter;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Given a 2D binary matrix filled with 0's and 1's, find the
 * largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 * <p>
 * Data
 * 10:21
 * -----------------------
 * 2020年1月9日
 * 没有头绪
 * <p>
 * Runtime: 3 ms, faster than 99.57% of Java online submissions for Maximal Rectangle.
 * Memory Usage: 43.6 MB, less than 80.43% of Java online submissions for Maximal Rectangle.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0085MaximalRectangle implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                })
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(6);
    }

    public class Solution0085 {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return 0;

            final int M = matrix.length;//行
            final int N = matrix[0].length;//列

            Integer[] left = new Integer[N];
            Integer[] right = new Integer[N];
            Arrays.fill(right, null);
            Integer[] height = new Integer[N];

            int max = 0;

            for (int i = 0; i < M; i++) {
                int cur_left = -1, cur_right = N;

                for (int j = N - 1; j >= 0; j--){
                    if (matrix[i][j] == '1'){
                        if(right[j]==null){
                            right[j] = cur_right-1;
                        }else {
                            right[j]=Math.min(right[j],cur_right-1);
                        }
                    }else {
                        right[j]=null;
                        cur_right = j;
                    }
                }

                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] == '1'){
                        if(left[j]==null){
                            left[j]=cur_left+1;
                        }else {
                            left[j]= Math.max(left[j],cur_left+1);
                        }
                    }else {
                        left[j]=null;
                        cur_left = j;
                    }
                }

                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] == '1'){
                        if(height[j]==null){
                            height[j]=1;
                        }else {
                            height[j]++;
                        }
                    }else {
                        height[j]=null;
                    }
                }

                for (int j = 0; j < N; j++) {
                    if(left[j]!=null&&right[j]!=null&&height[j]!=null){
                        max = Math.max(
                                height[j] * (right[j]-left[j]+1),
                                max
                        );
                    }
                }


//                for (int j = N - 1; j >= 0; j--) {
//                    if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
//                    else {
//                        right[j] = N;
//                        cur_right = j;
//                    }
//                }
//
//                for (int j = 0; j < N; j++) {
//                    if (matrix[i][j] == '1') height[j]++;
//                    else height[j] = 0;
//
//                    if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
//                    else {
//                        left[j] = 0;
//                        cur_left = j + 1;
//                    }
//
//                    max = Math.max(max, (right[j] - left[j]) * height[j]);
//                }

                System.out.println("-------------" + i + "-----------");
                System.out.println("height = " + Arrays.toString(height));
                System.out.println("left = " + Arrays.toString(left));
                System.out.println("right = " + Arrays.toString(right));
                System.out.println("max = " + max);
            }

            return max;
        }

        private int maximalRectangle0(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return 0;

            int[] height = new int[matrix[0].length + 1];

            int max = 0;

            for (char[] chars : matrix) {
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '0') {
                        height[i] = 0;
                    } else {
                        height[i]++;
                    }
                }
//                System.out.println("直方图：" + Arrays.toString(height));

                max = Math.max(max, q0084(height));

            }

            return max;
        }

        // the last element is always 0
        private int q0084(int[] height) {
            int[] stack = new int[height.length];
            int si = -1;
            int max = 0;

            for (int i = 0; i < height.length; i++) {
                while (si >= 0 && height[stack[si]] > height[i]) {
                    int h = height[stack[si--]];
                    max = Math.max(
                            max,
                            h * (si == -1 ? i : i - stack[si] - 1)
                    );
                }

                stack[++si] = i;

//                MyPrinter.printIntArray(stack);
            }

//            System.out.println("max = " + max);

            return max;
        }
    }
}
