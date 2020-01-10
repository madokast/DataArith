package zrx.com.leetcode.utils.LeerCodeTest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface EqualMethod {
    boolean equal(Object o1,Object o2);

    static boolean listEqual(Object o1,Object o2){
        List<?> list1 = (List<?>)o1;
        List<?> list2 = (List<?>)o2;

//        Set<?> set1 = new HashSet<>();
//        Set<?> set2 = new HashSet<>();

        if(list1.size()==0&&list2.size()==0)
            return true;

        if(list1.size()!=list2.size())
            return false;

        list1.sort((Comparator.comparingInt(Object::hashCode)));
        list2.sort((Comparator.comparingInt(Object::hashCode)));

        return list1.equals(list2);
    }
}
