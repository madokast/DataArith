package zrx.com.leetcode.utils.LeerCodeTest;

import java.util.*;

public interface EqualMethod {
    boolean equal(Object o1,Object o2);

    static boolean listEqual(Object o1,Object o2){
        List<?> list1 = (List<?>)o1;
        List<?> list2 = (List<?>)o2;

        if(list1==list2)
            return true;

        if(list1==null&&list2!=null&&list2.size()==0||
        list2==null&&list1!=null&&list1.size()==0)
            return true;

        if(list1.size()!=list2.size())
            return false;

        Map<Object,Integer> map1 = new HashMap<>();
        Map<Object,Integer> map2 = new HashMap<>();

        for (Object o : list1) {
            map1.put(o,map1.getOrDefault(o,0)+1);
        }

        for (Object o : list2) {
            map2.put(o,map2.getOrDefault(o,0)+1);
        }

        for (Map.Entry<Object, Integer> entry : map1.entrySet()) {
            Object key = entry.getKey();
            Integer value = entry.getValue();

            if(!map2.containsKey(key))
                return false;
            else if(value!=map2.get(key))
                return false;
        }

        return true;

    }
}
