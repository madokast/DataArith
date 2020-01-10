package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;
import java.util.Stack;

@FunctionalInterface
public interface ToString {
    String fun(Object t);

    static String intArrArrToString(Object aa){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int[] ints : (int[][])aa) {
            stringBuilder.append(Arrays.toString(ints));
            stringBuilder.append(',');
        }

        stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"]");

        return stringBuilder.toString();
    }
}
