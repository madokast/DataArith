package zrx.com.leetcode;

import org.junit.Test;
import zrx.com.leetcode.Q0000.Q0005LongestPalindromicSubstring;
import zrx.com.leetcode.Q0000.Q0010RegularExpressionMatching;
import zrx.com.leetcode.Q0020.*;
import zrx.com.leetcode.Q0040.Q0042TrappingRainWater;
import zrx.com.leetcode.Q0040.Q0044WildcardMatching;
import zrx.com.leetcode.Q0040.Q0053MaximumSubarray;
import zrx.com.leetcode.Q0060.*;
import zrx.com.leetcode.Q0080.Q0084LargestRectangleInHistogram;
import zrx.com.leetcode.Q0080.Q0085MaximalRectangle;
import zrx.com.leetcode.Q0080.Q0087ScrambleString;
import zrx.com.leetcode.Q0120.Q0121BestTimeToBuyAndSellStock;
import zrx.com.leetcode.Q0120.Q0122BestTimeToBuyAndSellStockII;
import zrx.com.leetcode.Q0120.Q0123BestTimeToBuyAndSellStockIII;
import zrx.com.leetcode.Q0140.Q0152MaximumProductSubarray;
import zrx.com.leetcode.Q0180.Q0188BestTimeToBuyAndSellStockIV;
import zrx.com.leetcode.Q0180.Q0198HouseRobber;
import zrx.com.leetcode.Q0220.Q0238ProductOfArrayExceptSelf;
import zrx.com.leetcode.Q0620.Q0628MaximumProductOfThreeNumbers;
import zrx.com.leetcode.Q0680.Q0697DegreeOfAnArray;
import zrx.com.leetcode.UtilsTest.MyArrayAddOneTest;
import zrx.com.leetcode.UtilsTest.MyStringAllIndexOfTest;
import zrx.com.leetcode.utils.LeerCodeTest.QuestionDemo;
import zrx.com.leetcode.utils.LeerCodeTest.TestForLeetCode;

/**
 * Description
 * leetcode 全新测试
 * <p>
 * Data
 * 2019/11/10 16:43
 *
 * @author zrx
 * @version 1.0
 */

public class AllTest {
    @Test
    public void test20200112(){
        TestForLeetCode.happy(Q0087ScrambleString.class);
    }

    @Test
    public void test20200111(){
        TestForLeetCode.happy(Q0084LargestRectangleInHistogram.class);
        TestForLeetCode.happy(Q0085MaximalRectangle.class);
    }

    @Test
    public void test20200110(){
        TestForLeetCode.happy(Q0064MinimumPathSum.class);
        TestForLeetCode.happy(Q0072EditDistance.class);
    }

    @Test
    public void test20200109(){
        TestForLeetCode.happy(Q0032LongestValidParentheses.class);
        TestForLeetCode.happy(Q0063UniquePathsII.class);
    }

    @Test
    public void test20200106(){
        TestForLeetCode.happy(Q0010RegularExpressionMatching.class);
        TestForLeetCode.happy(Q0044WildcardMatching.class);
        TestForLeetCode.happy(Q0062UniquePaths.class);
    }

    @Test
    public void test20200105(){
        TestForLeetCode.happy(Q0122BestTimeToBuyAndSellStockII.class);
        TestForLeetCode.happy(Q0123BestTimeToBuyAndSellStockIII.class);
        TestForLeetCode.happy(Q0188BestTimeToBuyAndSellStockIV.class);
    }

    @Test
    public void test20200104(){
        TestForLeetCode.happy(Q0697DegreeOfAnArray.class);
        TestForLeetCode.happy(Q0121BestTimeToBuyAndSellStock.class);
        TestForLeetCode.happy(Q0005LongestPalindromicSubstring.class);
    }

    @Test
    public void test() {
        TestForLeetCode.happy(new QuestionDemo());
        TestForLeetCode.happy(new Q0026RemoveDuplicatesFromSortedArray());
        TestForLeetCode.happy(new Q0027RemoveElement());
        TestForLeetCode.happy(new Q0028ImplementStrStrBrute());
        TestForLeetCode.happyTimeLimit(new Q0028ImplementStrStrKMP(),2);
        TestForLeetCode.happyTimeLimit(new Q0030SubstringWithConcatenationOfAllWordsBrute(),2);
        TestForLeetCode.happyTimeLimit(new Q0030SubstringWithConcatenationOfAllWordsMap(),5);
        TestForLeetCode.happyTimeLimit(new Q0042TrappingRainWater(),5);
        TestForLeetCode.happy(Q0061RotateList.class);
        TestForLeetCode.happy(Q0238ProductOfArrayExceptSelf.class);
        TestForLeetCode.happy(Q0075SortColors.class);
        TestForLeetCode.happy(Q0152MaximumProductSubarray.class);
        TestForLeetCode.happy(Q0198HouseRobber.class);
        TestForLeetCode.happy(Q0053MaximumSubarray.class);
        TestForLeetCode.happy(Q0628MaximumProductOfThreeNumbers.class);
    }

    @Test
    public void todayTest(){

    }

    @Test
    public void utilsTest(){
        TestForLeetCode.happy(new MyStringAllIndexOfTest());
        TestForLeetCode.happy(new MyArrayAddOneTest());
    }


}
