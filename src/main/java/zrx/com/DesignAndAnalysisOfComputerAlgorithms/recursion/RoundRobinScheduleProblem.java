package zrx.com.DesignAndAnalysisOfComputerAlgorithms.recursion;

import zrx.com.DesignAndAnalysisOfComputerAlgorithms.TestForDesignAndAnalysisOfComputerAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description
 * 循环赛日程表问题
 * <p>
 * Data
 * 22:04
 *
 * @author zrx
 * @version 1.0
 */

public class RoundRobinScheduleProblem {

    @TestForDesignAndAnalysisOfComputerAlgorithms(value = "循环赛日程表问题", page = 43)
    public void solve() {
        for (int i = 1; i < 4; i++) {
            System.out.println("k = "+ i);
            solve(i);
        }
    }

    private void solve(int k) {
        List<int[]> ans = new ArrayList<>();
        int number = (int) Math.pow(2, k);
//        System.out.println("number = " + number);
        int[] arr = new int[number];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }


        ans.add(Arrays.copyOf(arr, arr.length));

        //-----------------------------------
        for (int i = 1; i <= k; i++) {
            int range = (int) Math.pow(2, i);
            int num = number / range;

            List<int[]> temps = new ArrayList<>();
            for (int[] an : ans) {
                int[] temp = new int[number];
                for (int j = 0; j < num; j++) {
                    int start = j * range;
                    int end = start + range;

                    int mid = (start+end)/2;

//                    System.out.println("start = " + start);
//                    System.out.println("end = " + end);
//                    System.out.println("mid = " + mid);


                    System.arraycopy(an,start,temp,mid,mid-start);
                    System.arraycopy(an,mid,temp,start,mid-start);

//                    System.out.println("an = " + Arrays.toString(an));
//                    System.out.println("temp = " + Arrays.toString(temp));
                }

                temps.add(temp);
            }

            ans.addAll(temps);
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(i + " " + Arrays.toString(ans.get(i)));
        }
    }
}
