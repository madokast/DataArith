package zrx.com.leetcode.Q0080;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Given a string s1, we may represent it as a binary tree by
 * partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node
 * and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two
 * children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes
 * "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine
 * if s2 is a scrambled string of s1.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * <p>
 * Data
 * 17:05
 * ------------------
 * 2020年1月12日
 * Runtime: 10 ms, faster than 25.56% of Java online submissions for Scramble String.
 * Memory Usage: 37.8 MB, less than 43.75% of Java online submissions for Scramble String.
 * 居然我做出来了
 *
 * ------------------
 * 看看别人的解法
 * 这道题定义了一种搅乱字符串，就是说假如把一个字符串当做一个二叉树的根
 * ，然后它的非空子字符串是它的子节点，然后交换某个子字符串的两个子节点
 * ，重新爬行回去形成一个新的字符串，这个新字符串和原来的字符串互为搅乱
 * 字符串。这道题可以用递归 Recursion 或是动态规划 Dynamic Programming
 * 来做，我们先来看递归的解法，参见网友 uniEagle 的博客，简单的说，就是
 * s1 和 s2 是 scramble 的话，那么必然存在一个在 s1 上的长度 l1，将
 * s1 分成 s11 和 s12 两段，同样有 s21 和 s22，那么要么 s11 和 s21 是
 * scramble 的并且 s12 和 s22 是 scramble 的；要么 s11 和 s22 是
 * scramble 的并且 s12 和 s21 是 scramble 的。就拿题目中的例子
 * rgeat 和 great 来说，rgeat 可分成 rg 和 eat 两段， great 可分成
 * gr 和 eat 两段，rg 和 gr 是 scrambled 的， eat 和 eat 当然是
 * scrambled。根据这点，我们可以写出代码如下：
 *
 * @author zrx
 * @version 1.0
 */

public class Q0087ScrambleString implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("great", "rgeat"),
                Input.InputSet.build("abcde", "caebd")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(true, false);
    }

    public class Solution0087 {
        Map<Character,List<Integer>> mapS2 = new HashMap<>();

        public boolean isScramble(String s1, String s2) {
            for (int i = 0; i < s2.length(); i++) {
                if(!mapS2.containsKey(s2.charAt(i))){
                    mapS2.put(s2.charAt(i),new ArrayList<>());
                }

                mapS2.get(s2.charAt(i)).add(i);
            }


            return isScramble(s1,0,s1.length(),s2,0,s2.length());
        }

        private boolean isScramble(String s1,int startIncluding1,int endExcluding1,
                                   String s2,int startIncluding2,int endExcluding2){
            if(endExcluding1-startIncluding1!=endExcluding2-startIncluding2)
                throw new RuntimeException("endExcluding1-startIncluding1!=endExcluding2-startIncluding2");

            if(endExcluding1-startIncluding1==1){
                return s1.charAt(startIncluding1)==s2.charAt(startIncluding2);
            }

            //len>1

            List<Integer> list = new ArrayList<>(endExcluding1-startIncluding1);

            for (int i = startIncluding1; i < endExcluding1; i++) {
                char s1i = s1.charAt(i);

                if(!mapS2.containsKey(s1i)){
                    return false;
                }

                List<Integer> listS2 = mapS2.get(s1i);
                for (Integer indexS2 : listS2) {
                    if(indexS2>=startIncluding2&&
                            indexS2<endExcluding2&&
                            !list.contains(indexS2)){
                        list.add(indexS2);
                        break;
                    }
                }

            }

            if(list.size()!=(endExcluding1-startIncluding1)){
                return false;
            }else {
                for (int i = startIncluding1 + 1; i < endExcluding1; i++){


                    if(isScramble(s1,startIncluding1,i,
                            s2,startIncluding2,startIncluding2+(i-startIncluding1))
                            &&
                            isScramble(s1,i,endExcluding1,
                                    s2,endExcluding2-endExcluding1+i,endExcluding2)

                    ){
                        return true;
                    }

                    if(isScramble(s1,startIncluding1,i,
                            s2,endExcluding2+startIncluding1-i,endExcluding2)
                            &&
                            isScramble(s1,i,endExcluding1,
                                    s2,startIncluding2,startIncluding2+(endExcluding1-i))
                    ){
                        return true;
                    }
                }

                return false;
            }
        }
    }
}
