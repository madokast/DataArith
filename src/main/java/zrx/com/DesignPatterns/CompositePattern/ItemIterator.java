package zrx.com.DesignPatterns.CompositePattern;

import java.util.Iterator;
import java.util.Stack;

/**
 * Description
 * ItemIterator
 * <p>
 * Data
 * 12:48
 *
 * @author zrx
 * @version 1.0
 */

public class ItemIterator implements Iterator< Component> {
    Stack<Iterator<Component>> stack = new Stack<>();

    Component root;

    Item item = null;

    public ItemIterator(Component root) {
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
                Component next = peek.next();
                if(next instanceof Item){
                    item = (Item)next;
                    return true;
                }else {
                    stack.push(next.iterator());
                    return hasNext();
                }

            }else {
                stack.pop();
                return hasNext();
            }

        }
    }

    @Override
    public Component next() {
        return item;
    }
}
