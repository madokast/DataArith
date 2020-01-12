package zrx.com.leetcode.UtilsTest;

import org.junit.Assert;
import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.LeerCodeTest.EqualMethod;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * TestListEqual
 * <p>
 * Data
 * 18:11
 *
 * @author zrx
 * @version 1.0
 */

public class TestListEqual {
    @Test
    public void test(){
        MyTools.printCurrentMethod(true);

        List<Integer> list = Arrays.asList(1, 1, 2, 2);
        List<Integer> list1 = Arrays.asList(1, 2, 2, 2);

        Assert.assertFalse(EqualMethod.listEqual(list1,list));

        System.out.println("EqualMethod.listEqual(list1,list) = " + EqualMethod.listEqual(list1, list));

    }
}
