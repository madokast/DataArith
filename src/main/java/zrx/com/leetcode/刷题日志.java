package zrx.com.leetcode;

import zrx.com.leetcode.Q0000.*;
import zrx.com.leetcode.Q0020.*;
import zrx.com.leetcode.Q0040.Q0042TrappingRainWater;
import zrx.com.leetcode.Q0040.Q0044WildcardMatching;
import zrx.com.leetcode.Q0040.Q0053MaximumSubarray;
import zrx.com.leetcode.Q0060.*;
import zrx.com.leetcode.Q0080.*;
import zrx.com.leetcode.Q0100.Q0115DistinctSubsequences;
import zrx.com.leetcode.Q0120.*;
import zrx.com.leetcode.Q0140.Q0140WordBreakII;
import zrx.com.leetcode.Q0140.Q0152MaximumProductSubarray;
import zrx.com.leetcode.Q0160.Q0167TwoSum2InputArrayIsSorted;
import zrx.com.leetcode.Q0160.Q0174DungeonGame;
import zrx.com.leetcode.Q0180.Q0188BestTimeToBuyAndSellStockIV;
import zrx.com.leetcode.Q0180.Q0198HouseRobber;
import zrx.com.leetcode.Q0220.Q0238ProductOfArrayExceptSelf;
import zrx.com.leetcode.Q0440.Q0454FourSumII;
import zrx.com.leetcode.Q0560.Q0560SubarraySumEqualsK;
import zrx.com.leetcode.Q0620.Q0628MaximumProductOfThreeNumbers;
import zrx.com.leetcode.Q0680.Q0697DegreeOfAnArray;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * 2019年11月6日
 * 0001 两数和问题
 * @see Q0001TwoSum
 * 0167 两数和2 数组有序
 * @see Q0167TwoSum2InputArrayIsSorted
 * 0015 3数和
 * @see Q0015ThreeSum
 *
 * 2019年11月8日
 * 0016 3数和最接近target
 * @see Q0016ThreeSumClosest
 *
 * 2019年11月9日
 * 0018 四数和
 * @see Q0018FourSum
 * 0454 四数组四数和 4Sum II
 * @see Q0454FourSumII
 * 0560 子数组和为k问题
 * @see Q0560SubarraySumEqualsK
 *
 * 2019年11月10日
 * 0011 水桶最大问题11. Container With Most Water
 * @see Q0011ContainerWithMostWater
 * 0003 最长不重复子串
 * @see Q0003LongestSubstringWithoutRepeatingCharacters
 * 0019 19. Remove Nth Node From End of List 移走链表种倒数第n个元素
 * @see Q0019RemoveNthNodeFromEndOfList
 * 0026 26. Remove Duplicates from Sorted Array 移走有序数组中重复项
 * @see Q0026RemoveDuplicatesFromSortedArray
 * 0027 27. Remove Element 移走数组中指定元素(有几个移走几个)
 * @see Q0027RemoveElement
 * 0028 28. Implement strStr() KMP算法
 * @see Q0028ImplementStrStrKMP
 *
 * 2019年11月11日
 * 0030 30. Substring with Concatenation of All Words 好题目
 * @see Q0030SubstringWithConcatenationOfAllWordsMap
 * 0042 42. Trapping Rain Water
 * @see Q0042TrappingRainWater
 *
 *
 * 2019年12月23日
 * 0061 61. Rotate List
 * @see zrx.com.leetcode.Q0060.Q0061RotateList
 * 238. Product of Array Except Self
 * @see zrx.com.leetcode.Q0220.Q0238ProductOfArrayExceptSelf
 * 75. Sort Colors
 * @see zrx.com.leetcode.Q0060.Q0075SortColors
 * 152. Maximum Product Subarray
 * @see zrx.com.leetcode.Q0140.Q0152MaximumProductSubarray
 *
 * 2019年12月24日
 * 628. Maximum Product of Three Numbers
 * @see zrx.com.leetcode.Q0620.Q0628MaximumProductOfThreeNumbers
 * 53. Maximum Subarray
 * @see zrx.com.leetcode.Q0040.Q0053MaximumSubarray
 * 198. House Robber
 * @see zrx.com.leetcode.Q0180.Q0198HouseRobber
 *
 * 2019年12月24日
 * 697. Degree of an Array
 * @see zrx.com.leetcode.Q0680.Q0697DegreeOfAnArray
 * 121. Best Time to Buy and Sell Stock
 * @see zrx.com.leetcode.Q0120.Q0121BestTimeToBuyAndSellStock
 * 5. Longest Palindromic Substring
 * @see Q0005LongestPalindromicSubstring
 *
 * 2020年1月4日
 * 122. Best Time to Buy and Sell Stock II
 * @see zrx.com.leetcode.Q0120.Q0122BestTimeToBuyAndSellStockII
 * 123. Best Time to Buy and Sell Stock III
 * @see zrx.com.leetcode.Q0120.Q0123BestTimeToBuyAndSellStockIII
 *
 * 2020年1月5日 - 继续学习动态规划
 * 188. Best Time to Buy and Sell Stock IV
 * @see zrx.com.leetcode.Q0180.Q0188BestTimeToBuyAndSellStockIV
 *
 *
 * 2020年1月6日
 * 10. Regular Expression Matching
 * @see Q0010RegularExpressionMatching
 * 44. Wildcard Matching
 * @see zrx.com.leetcode.Q0040.Q0044WildcardMatching
 * 62. Unique Paths
 * @see zrx.com.leetcode.Q0060.Q0062UniquePaths
 *
 * 2020年1月9日
 * 32. Longest Valid Parentheses
 * @see zrx.com.leetcode.Q0020.Q0032LongestValidParentheses
 * 63. Unique Paths II
 * @see zrx.com.leetcode.Q0060.Q0063UniquePathsII
 *
 * 2020年1月10日
 * 64. Minimum Path Sum
 * @see zrx.com.leetcode.Q0060.Q0064MinimumPathSum
 * 72. Edit Distance
 * @see zrx.com.leetcode.Q0060.Q0072EditDistance
 *
 * 2020年1月11日
 * 85. Maximal Rectangle
 * @see zrx.com.leetcode.Q0080.Q0085MaximalRectangle
 * 87. Scramble String
 * @see zrx.com.leetcode.Q0080.Q0087ScrambleString
 * 84. Largest Rectangle in Histogram
 * @see zrx.com.leetcode.Q0080.Q0084LargestRectangleInHistogram
 *
 * 2020年1月13日
 * 91. Decode Ways
 * @see zrx.com.leetcode.Q0080.Q0091DecodeWays
 * 95. Unique Binary Search Trees II
 * @see zrx.com.leetcode.Q0080.Q0095UniqueBinarySearchTreesII
 * 96. Unique Binary Search Trees
 * @see zrx.com.leetcode.Q0080.Q0096UniqueBinarySearchTrees
 * 94. Binary Tree Inorder Traversal
 * @see Q0094BinaryTreeInorderTraversal
 *
 * 2020年1月14日
 * 97. Interleaving String
 * @see Q0097InterleavingString
 * 115. Distinct Subsequences
 * @see zrx.com.leetcode.Q0100.Q0115DistinctSubsequences
 * 120. Triangle
 * @see zrx.com.leetcode.Q0120.Q0120Triangle
 * 132. Palindrome Partitioning II
 * @see zrx.com.leetcode.Q0120.Q0132PalindromePartitioningII
 *
 *
 * 139. Word Break
 * @see Q0139WordBreak
 * 140. Word Break II
 * @see zrx.com.leetcode.Q0140.Q0140WordBreakII
 * 174. Dungeon Game
 * @see zrx.com.leetcode.Q0160.Q0174DungeonGame
 * 213. House Robber II
 *
 *
 *
 */

public class 刷题日志{
    private List<Class<? extends Question>> hardQuestion =
            MyArrayTools.asList(Q0140WordBreakII.class);

    private Q0001TwoSum q0001TwoSum;
    private Q0003LongestSubstringWithoutRepeatingCharacters q0003LongestSubstringWithoutRepeatingCharacters;
    private Q0005LongestPalindromicSubstring q0005LongestPalindromicSubstring;
    private Q0010RegularExpressionMatching q0010RegularExpressionMatching;
    private Q0011ContainerWithMostWater q0011ContainerWithMostWater;
    private Q0015ThreeSum q0015ThreeSum;
    private Q0016ThreeSumClosest q0016ThreeSumClosest;
    private Q0018FourSum q0018FourSum;
    private Q0019RemoveNthNodeFromEndOfList q0019RemoveNthNodeFromEndOfList;
    private Q0026RemoveDuplicatesFromSortedArray q0026RemoveDuplicatesFromSortedArray;
    private Q0027RemoveElement q0027RemoveElement;
    private Q0028ImplementStrStrKMP q0028ImplementStrStrKMP;
    private Q0030SubstringWithConcatenationOfAllWordsMap q0030SubstringWithConcatenationOfAllWordsMap;
    private Q0032LongestValidParentheses q0032LongestValidParentheses;
    private Q0042TrappingRainWater q0042TrappingRainWater;
    private Q0044WildcardMatching q0044WildcardMatching;
    private Q0053MaximumSubarray q0053MaximumSubarray;
    private Q0061RotateList q0061RotateList;
    private Q0062UniquePaths q0062UniquePaths;
    private Q0063UniquePathsII q0063UniquePathsII;
    private Q0064MinimumPathSum q0064MinimumPathSum;
    private Q0072EditDistance q0072EditDistance;
    private Q0075SortColors q0075SortColors;
    private Q0084LargestRectangleInHistogram q0084LargestRectangleInHistogram;
    private Q0085MaximalRectangle q0085MaximalRectangle;
    private Q0087ScrambleString q0087ScrambleString;
    private Q0091DecodeWays q0091DecodeWays;
    private Q0094BinaryTreeInorderTraversal q0094BinaryTreeInorderTraversal;
    private Q0095UniqueBinarySearchTreesII q0095UniqueBinarySearchTreesII;
    private Q0096UniqueBinarySearchTrees q0096UniqueBinarySearchTrees;
    private Q0097InterleavingString q0097InterleavingString;
    private Q0115DistinctSubsequences q0115DistinctSubsequences;
    private Q0120Triangle q0120Triangle;
    private Q0121BestTimeToBuyAndSellStock q0121BestTimeToBuyAndSellStock;
    private Q0122BestTimeToBuyAndSellStockII q0122BestTimeToBuyAndSellStockII;
    private Q0123BestTimeToBuyAndSellStockIII q0123BestTimeToBuyAndSellStockIII;
    private Q0132PalindromePartitioningII q0132PalindromePartitioningII;
    private Q0139WordBreak q0139WordBreak;
    private Q0140WordBreakII q0140WordBreakII;
    private Q0152MaximumProductSubarray q0152MaximumProductSubarray;
    private Q0167TwoSum2InputArrayIsSorted q0167TwoSum2InputArrayIsSorted;
    private Q0174DungeonGame q0174DungeonGame;
    private Q0188BestTimeToBuyAndSellStockIV q0188BestTimeToBuyAndSellStockIV;
    private Q0198HouseRobber q0198HouseRobber;
    private Q0238ProductOfArrayExceptSelf q0238ProductOfArrayExceptSelf;
    private Q0454FourSumII q0454FourSumII;
    private Q0560SubarraySumEqualsK q0560SubarraySumEqualsK;
    private Q0628MaximumProductOfThreeNumbers q0628MaximumProductOfThreeNumbers;
    private Q0697DegreeOfAnArray q0697DegreeOfAnArray;
}
