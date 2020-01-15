package zrx.com.leetcode.Q0140;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.*;

/**
 * Description
 * Given a non-empty string s and a dictionary wordDict containing
 * a list of non-empty words, add spaces in s to construct a sentence
 * where each word is a valid dictionary word. Return all such possible
 * sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in
 * the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary
 * word.
 * <p>
 * Data
 * 18:40
 *
 * @author zrx
 * @version 1.0
 */

public class Q0140WordBreakII implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("catsanddog", List.of("cat", "cats", "and", "sand", "dog")),
                Input.InputSet.build("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")),
                Input.InputSet.build("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                        List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))

        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(new ArrayList<>(List.of(
                "cats and dog",
                "cat sand dog")), new ArrayList<>(List.of(
                "pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple")),
                MyArrayTools.asList());
    }

    public class Solution0140 {
        public List<String> wordBreak(String s, List<String> wordDict){
            List<String> list = new ArrayList<>();

            if(s==null||s.length()==0||wordDict==null||wordDict.size()==0)
                return list;

            Set<String> set = new HashSet<>(wordDict);
            StringBuilder sb = new StringBuilder();

            if(canBreak(s,new HashSet<>(set))){
                System.out.println("canBreak");
                breakString(s,set,sb,list);
            }

            return list;
        }

        private void breakString(String s,Set<String> set,StringBuilder sb,List<String> list){
//            System.out.println("Ps = " + Arrays.deepToString(new Object[]{s,sb,list}));
            if(s.length()==0){
                list.add(sb.toString().trim());
                return;
            }

            for (int i = 0; i <= s.length(); i++) {
                String f = s.substring(0, i);
                String e = s.substring(i);
                System.out.println("fe = " + f + " " + e);
                if(set.contains(f)&&canBreak(e,set)){
                    sb.append(f).append(" ");
                    breakString(e,set,sb,list);
                    //------------------------------------

//                    System.out.println("f = " + f);
//                    System.out.println("sb = " + sb);
                    sb.setLength(sb.length()-1-f.length());
//                    System.out.println("sb = " + sb);
                }
            }



            //执行过程见最下面
        }

        private boolean canBreak(String s,Set<String> set){
            if(s.length()==0)
                return true;

            for (int i = 0; i <= s.length(); i++) {
                String f = s.substring(0, i);
                String e = s.substring(i);

                if(set.contains(f)&&canBreak(e,set)){
                    return true;
                }

//                System.out.println("f = " + f);

//                System.out.println("set = " + set);
                //--------这行代码我也没看懂
                set.remove(f);

//                System.out.println("set = " + set);
            }

            return false;
        }


//        ---------------------------------------------------------------------


        private Set<String> stringSet;
        private Set<Integer> lengthSet;
//        private Stack<List<String>> stack;
//        private List<List<String>> lists;

        private Set<String> wordBreakableSet;
        private Set<String> allStringSet;
        private Set<Integer> allWordBreakableLength;

        //超时
        private List<String> wordBreak0(String s, List<String> wordDict) {
            wordDict = new ArrayList<>(wordDict);
            wordDict.sort(Comparator.comparingInt(String::length));

            stringSet = new HashSet<>();
            lengthSet = new HashSet<>();
            wordBreakableSet = new HashSet<>();
            allStringSet = new HashSet<>();
            allWordBreakableLength = new HashSet<>();
            for (String s1 : wordDict) {
                allStringSet.add(s1);
                allWordBreakableLength.add(s1.length());
                if(wordBreak(s1)){
                    wordBreakableSet.add(s1);
                }else {
                    lengthSet.add(s1.length());
                    stringSet.add(s1);
                }
            }

            List<String> empty = new ArrayList<>();

            if(breakWord(s,stringSet,lengthSet).size()==0)
                return empty;
            else return breakWord(s,allStringSet,allWordBreakableLength);
        }

        private List<String> breakWord(String s,Set<String> strings,Set<Integer> lengthSet){
            Stack<List<String>> stack = new Stack<>();
            List<String> temp = new ArrayList<>();
            temp.add(s);
            stack.push(temp);

            List<List<String>> lists =  new ArrayList<>();

            while (!stack.empty()){
                List<String> pop = stack.pop();
                String lastString = pop.get(pop.size() - 1);
                pop.remove(pop.size() - 1);

                for (Integer length : lengthSet) {
                    if(lastString.length()>=length){
                        String substring = lastString.substring(0, length);
                        if(strings.contains(substring)){
                            if(lastString.length()==length){
                                ArrayList<String> ans = new ArrayList<>(pop);
                                ans.add(substring);
                                lists.add(ans);
                            }else {
                                //还有剩余，入栈
                                ArrayList<String> popCopy = new ArrayList<>(pop);
                                popCopy.add(substring);
                                popCopy.add(lastString.substring(length));
                                stack.push(popCopy);
                            }
                        }
                    }
                }
            }

            List<String> ret = new ArrayList<>(lists.size());
            for (List<String> list : lists) {
                StringBuilder sb = new StringBuilder();
                for (String s1 : list) {
                    sb.append(s1).append(" ");
                }
                ret.add(sb.deleteCharAt(sb.length()-1).toString());
            }

            return ret;
        }



        private boolean wordBreak(String s){
            boolean match = false;
            for (Integer length : lengthSet) {
                if(s.length()>=length&&stringSet.contains(s.substring(0,length))){
                    //包含
                    if(s.length()==length)
                        return true;

                    match = match||wordBreak(s.substring(length));
//                    System.out.println("s = " + s);
                }
            }

            return match;
        }


    }

}


//------ 开始测试Q0140WordBreakII ----------------
//***测试第1组
//输入：[catsanddog, [cat, cats, and, sand, dog]]
//canBreak
//Ps = [catsanddog, , []]
//fe =  catsanddog
//fe = c atsanddog
//fe = ca tsanddog
//fe = cat sanddog
//Ps = [sanddog, cat , []]
//fe =  sanddog
//fe = s anddog
//fe = sa nddog
//fe = san ddog
//fe = sand dog
//Ps = [dog, cat sand , []]
//fe =  dog
//fe = d og
//fe = do g
//fe = dog
//Ps = [, cat sand dog , []]
//f = dog
//sb = cat sand dog
//sb = cat sand
//f = sand
//sb = cat sand
//sb = cat
//fe = sandd og
//fe = sanddo g
//fe = sanddog
//f = cat
//sb = cat
//sb =
//fe = cats anddog
//Ps = [anddog, cats , [cat sand dog]]
//fe =  anddog
//fe = a nddog
//fe = an ddog
//fe = and dog
//Ps = [dog, cats and , [cat sand dog]]
//fe =  dog
//fe = d og
//fe = do g
//fe = dog
//Ps = [, cats and dog , [cat sand dog]]
//f = dog
//sb = cats and dog
//sb = cats and
//f = and
//sb = cats and
//sb = cats
//fe = andd og
//fe = anddo g
//fe = anddog
//f = cats
//sb = cats
//sb =
//fe = catsa nddog
//fe = catsan ddog
//fe = catsand dog
//fe = catsandd og
//fe = catsanddo g
//fe = catsanddog
//输出：[cat sand dog, cats and dog]
//答案：[cats and dog, cat sand dog]
//输出正确