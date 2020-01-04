package zrx.com.leetcode.Q0680;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * Description
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum
 * frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of
 * a (contiguous) subarray of nums, that has the same
 * degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements
 * 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1],
 * [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * <p>
 * Data
 * 2019/12/24 14:46
 *
 * ---------------------------------------
 * 既然告诉了数字的范围，我的想法是计数，然后分析
 *
 * @author zrx
 * @version 1.0
 */

public class Q0697DegreeOfAnArray implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1, 2, 2, 3, 1)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1,2,2,3,1,4,2))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2,6);
    }

    public class Solution0697 {
        public int findShortestSubArray(int[] nums) {
            //计数，范围 0 and 49,999
            int[] count = new int[50000];
            Arrays.fill(count,0);

            for (int num : nums) {
                count[num]++;
            }

            //需要找数组 count 中最大的项，还可能有多项...
            //首先找到最大值
//            OptionalInt max = Arrays.stream(count).max();
//            int maxAsInt = max.getAsInt();
            int maxAsInt = 0;
            for (int i : count) {
                if(i>maxAsInt){
                    maxAsInt = i;
                }
            }

            //然后对所有属于这个最大值的分析
            int minLength = nums.length;

            for (int i = 0; i < count.length; i++) {
                if(count[i]==maxAsInt){
                    // i 出现了 maxAsInt 次，是出现次数最多的
                    //从两边删去非 i 的数
                    int j = 0;
                    while (nums[j]!=i){
                        j++;
                    }
                    int k = nums.length-1;
                    while (nums[k]!=i){
                        k--;
                    }

                    int currentLength = k-j+1;
                    if(currentLength<minLength){
                        minLength = currentLength;
                    }
                }
            }


            return minLength;
        }
    }
}
