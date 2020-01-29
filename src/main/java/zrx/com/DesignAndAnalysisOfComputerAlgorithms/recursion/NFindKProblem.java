package zrx.com.DesignAndAnalysisOfComputerAlgorithms.recursion;

import zrx.com.DesignAndAnalysisOfComputerAlgorithms.TestForDesignAndAnalysisOfComputerAlgorithms;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyRandom;
import zrx.com.leetcode.utils.MyRequire;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Description
 * 从无序集合中寻找第k大的元素
 * <p>
 * Data
 * 21:20
 *
 * @author zrx
 * @version 1.0
 */

public class NFindKProblem {
    @TestForDesignAndAnalysisOfComputerAlgorithms(value = "从无序集合中寻找第k大的元素",
            detailInfo = "使用堆排序")
    public void selectK() {
        MyTools.justDoIt(5,this::selectKRun);
    }

    public void selectKRun(){
        int k = MyRandom.nextInt(18)+1;
        int[] randomIntArray = MyRandom.randomIntArray(100, 20);
        int[] randomIntArrayCopy = Arrays.copyOf(randomIntArray,randomIntArray.length);

        //堆排序解法
        MyArrayTools.heapSort(randomIntArray,k);
        for (int i = k; i < randomIntArray.length; i++) {
            if(randomIntArray[0]<randomIntArray[i]){
                MyArrayTools.swap(randomIntArray,0,i);
            }
            MyArrayTools.heapSort(randomIntArray,k);
        }
        int k1 = randomIntArray[0];

//        System.out.println(Arrays.toString(randomIntArray));

        //排序解法
        Arrays.sort(randomIntArrayCopy);
        MyArrayTools.reverse(randomIntArrayCopy);

        int k2 = randomIntArrayCopy[k-1];

        System.out.println( "数组"+ Arrays.toString(randomIntArrayCopy) +"，第"+ k  + "大的数是" + k1);
        if(k1!=k2)
            System.err.println("回答错误");
        else
            System.out.println("回答正确");
    }

    @TestForDesignAndAnalysisOfComputerAlgorithms(value = "堆排序",
            detailInfo = {"堆是具有以下性质的完全二叉树",
                    "每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆",
                    "或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆",
                    "大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]",
                    "小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2] ",
                    "堆仅仅使用数组，且不使用指针",
                    "使用堆的目的是将最大（或者最小）的节点放在最前面",
                    "而不是搜索元素，所以平衡二叉树和堆有区别"
            })
    public void heapSort() {
        Stream.generate(Math::random).limit(5).forEach(e->{
            int[] randomIntArray = MyRandom.randomIntArray(100, 20);
            System.out.println("randomArray = " + Arrays.toString(randomIntArray));
            MyArrayTools.heapSort(randomIntArray);
            System.out.println("sortedArray = " + Arrays.toString(randomIntArray));
            if(MyArrayTools.isSorted(randomIntArray)){
                System.out.println("排序成功");
            }
            else {
                System.err.println("排序失败!!!");
            }
        });
    }
}
