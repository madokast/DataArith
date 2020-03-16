package zrx.com.others;

import zrx.com.MultiThread.MyTools;
import zrx.com.others.COSY.SR;
import zrx.com.others.dateAndArith.MonotonicStack;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description
 * test
 * <p>
 * Data
 * 2019/11/27 22:04
 *
 * @author zrx
 * @version 1.0
 */

public class Test {

    @org.junit.Test
    public void fullCpu() throws Exception {
        Set<Integer> set = new HashSet<>();
        Thread[] new_threads = IntStream.range(0, 160).parallel().mapToObj(i -> MyTools.runItInThread(() ->
                        set.add(MyTools.hardWork(new Date().toString().length())),
                false)).collect(Collectors.toList()).toArray(new Thread[160]);

        MyTools.joinAll(new_threads);

        int sum = set.stream().mapToInt(i -> i).sum();
        MyTools.printMsgWithThreadAndTime(String.valueOf(sum));
    }

    @org.junit.Test
    public void helloVM() {
        MyTools.printMsgWithThreadAndTime("2020年2月14日 项目迁移成功");
    }


    @org.junit.Test
    public void deepInComing() {
        MyTools.infoWithTime("deepin更新");
    }

    @org.junit.Test
    public void testOut() {
//        int[][] arr = new int[2][10];
//
//        arr[4] = new int[] {1,2,3};
//
//
    }

    @org.junit.Test
    public void testMonotonicStack() {
        MonotonicStack.learn();
    }

    @org.junit.Test
    public void test11() {
        SR.main(null);
    }

    @org.junit.Test
    public void test01() {
        int x = 3;
        if (x == (x = 4)) {
            System.out.println(true + " " + x);
        } else {
            System.out.println(false + " " + x);
        }

        System.out.println((x == (x = 5)));

        //false4

//        for (int i = 0; i < 1000000; i++) {
//            System.out.print((x==(x=i)));
//            System.out.println(x);
//        }

    }

    @org.junit.Test
    public void PermutationTest() {
        Permutation.go();
    }

    @org.junit.Test
    public void equal() {
        MyTools.printCurrentMethod(true);
        String s = "abc";
        CharSequence charSequence = s;
        System.out.println("s = " + s);
        System.out.println("charSequence = " + charSequence);
        System.out.println("(charSequence==s) = " + (charSequence == s));

    }

    @org.junit.Test
    public void MyDualPivotQuicksortTest() {
        MyDualPivotQuicksort.go();
    }
}
