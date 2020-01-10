package zrx.com.DesignPatterns.CompositePattern;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyTimer;

/**
 * Description
 * 组合模式
 * <p>
 * Data
 * 12:04
 *
 * @author zrx
 * @version 1.0
 */

public class CompositePatternLearn {
    Component root = new Composite();
    {


        Composite c1 = new Composite();
        Composite c2 = new Composite();

        root.addComponent(c1);
        root.addComponent(c2);

        c1.addComponent(new Item("c1-1"));
        c1.addComponent(new Item("c1-2"));
        c1.addComponent(new Item("c1-3"));

        Composite c21 = new Composite();
        Composite c22 = new Composite();

        c2.addComponent(c21);
        c2.addComponent(c22);

        c21.addComponent(new Item("c21-1"));
        c21.addComponent(new Item("c21-2"));
        c21.addComponent(new Item("c21-3"));

        c22.addComponent(new Item("c22-1"));
        c22.addComponent(new Item("c22-2"));
        c22.addComponent(new Item("c22-3"));
        c22.addComponent(new Item("c22-4"));
        c22.addComponent(new Item("c22-5"));
        c22.addComponent(new Item("c22-6"));
        c22.addComponent(new Item("c22-7"));
        c22.addComponent(new Item("c22-8"));
        c22.addComponent(new Item("c22-9"));
    }

    public void learn(){
        MyTools.printCurrentMethod(true);
        ComponentIterator componentIterator = new ComponentIterator(root);

        while (componentIterator.hasNext()){
            System.out.println(componentIterator.next());
        }

        System.out.println("------------------------------");

        ItemIterator itemIterator = new ItemIterator(root);
        while (itemIterator.hasNext()){
            System.out.println(itemIterator.next());
        }

    }
}
