package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description
 * Given a triangle, find the minimum path sum from top to
 * bottom. Each step you may move to adjacent numbers on
 * the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra
 * space, where n is the total number of rows in the triangle.
 * <p>
 * Data
 * 16:45
 * -------------
 * Runtime: 3 ms, faster than 42.53% of Java online submissions for Triangle.
 * Memory Usage: 38.5 MB, less than 36.74% of Java online submissions for Triangle.
 *
 * @author zrx
 * @version 1.0
 */

public class Q0120Triangle implements Question {
    @Override
    public List<Input[]> getInputsList() {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        return Input.makeInputSet(
                Input.InputSet.build(triangle)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(11);
    }

    public class Solution0120 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int floors = triangle.size();
            if(floors==0)
                return 0;
            if(floors==1)
                return triangle.get(0).get(0);


            List<Integer> curList = new ArrayList<>(floors);
            List<Integer> preList = new ArrayList<>(floors);
            for (int i = 0; i < floors; i++) {
                preList.add(0);
                curList.add(0);
            }

            preList.set(0,triangle.get(0).get(0));

            for (int i = 1; i < floors; i++) {
                //从第二层开始

                List<Integer> curFloor = triangle.get(i);

//                System.out.println("curFloor = " + curFloor);
//                System.out.println("preList = " + preList);
//                System.out.println("curFloor = " + curFloor);


                curList.set(0,curFloor.get(0)+preList.get(0));

                for (int j = 1; j < i; j++) {
                    curList.set(j,Math.min(preList.get(j-1),preList.get(j))+curFloor.get(j));
                }

                curList.set(i,curFloor.get(i)+preList.get(i-1));

//                System.out.println("preList = " + preList);


                preList.clear();
                preList.addAll(curList);
                System.out.println("curList = " + curList);
            }

            int min = preList.get(0);
            for (Integer integer : preList) {
                min = Math.min(min,integer);
            }

            return min;
        }

    }
}
