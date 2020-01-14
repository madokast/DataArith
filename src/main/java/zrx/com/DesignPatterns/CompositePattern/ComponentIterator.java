package zrx.com.DesignPatterns.CompositePattern;

import java.util.Iterator;
import java.util.Stack;

/**
 * Description
 * ComponentIterator
 * <p>
 * Data
 * 12:16
 *
 * @author zrx
 * @version 1.0
 */

public class ComponentIterator implements Iterator< Component> {
    Stack<Iterator<Component>> stack = new Stack<>();

    Component root;

    public ComponentIterator(Component root) {
        this.root = root;
        stack.push(root.iterator());
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }else {
            Iterator<Component> peek = stack.peek();

            if(peek.hasNext()){
                return true;
            }else {
                stack.pop();
                return hasNext();
            }

        }
    }

    @Override
    public Component next() {
//        System.out.println("stack = " + stack);
        if(hasNext()){
            Iterator<Component> peek = stack.peek();

            Component next = peek.next();
            stack.push(next.iterator());
            return next;
        }else
            return null;
    }
}
