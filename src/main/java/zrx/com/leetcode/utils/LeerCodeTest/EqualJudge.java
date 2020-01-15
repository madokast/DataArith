package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyRequire;
import zrx.com.leetcode.utils.singlyLinkedList.ListNode;

import java.util.*;

/**
 * Description
 * 判断相同的方法
 * <p>
 * Data
 * 2019/11/10 16:35
 *
 * @author zrx
 * @version 1.0
 */

public class EqualJudge {
    private static Map<Class, EqualMethod> map = new HashMap<>();

    static {
        map.put(int[].class, (o1, o2) -> MyRequire.isEqual((int[]) o1, (int[]) o2));
        map.put(ListNode.class, (o1, o2) -> ListNode.equals((ListNode) o1, (ListNode) o2));
        map.put(List.class,EqualMethod::listEqual);
    }


    static boolean judge(Class clazz, Object o1, Object o2) {
        EqualMethod equalMethod = Object::equals;

        for (Class anInterface : clazz.getInterfaces()) {
            if(map.containsKey(anInterface)){
                equalMethod = map.get(anInterface);
            }
        }

        if(map.containsKey(clazz)){
            equalMethod = map.get(clazz);
        }

        return equalMethod.equal(o1,o2);
    }
}
