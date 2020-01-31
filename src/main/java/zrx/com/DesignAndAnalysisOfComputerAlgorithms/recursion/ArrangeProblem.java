package zrx.com.DesignAndAnalysisOfComputerAlgorithms.recursion;

import zrx.com.DesignAndAnalysisOfComputerAlgorithms.TestForDesignAndAnalysisOfComputerAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Description
 * 递归
 * 排列问题
 * <p>
 * Data
 * 18:42
 *
 * @author zrx
 * @version 1.0
 */

public class ArrangeProblem {
    @TestForDesignAndAnalysisOfComputerAlgorithms(value = "这是一个空测试",page = 0)
    public void run() {
        System.out.println("hello DesignAndAnalysisOfComputerAlgorithms");
    }

    @TestForDesignAndAnalysisOfComputerAlgorithms(value = "排列问题，递归解法",page = 18)
    public void arrange() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
            System.out.println("对" + list + "的排列：" + arrange(list));
        }
    }

    /**
     * 对list全排列
     *
     * @param list 要排列的
     * @return 全排列
     */
    public List<List<Integer>> arrange(final List<Integer> list) {
        List<List<Integer>> ret = new ArrayList<>();

        if (list.size() == 1) {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(list.get(0));
            ret.add(oneList);
        } else {
            for (Integer i : list) {
                List<Integer> listExceptI = new ArrayList<>(list.size());
                listExceptI.addAll(list);
                listExceptI.remove((Object)i);

                List<List<Integer>> arranges = arrange(listExceptI);
                for (List<Integer> arrange : arranges) {
                    arrange.add(0, i);
                    ret.add(arrange);
                }
            }
        }

        return ret;
    }
}
