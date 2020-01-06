package zrx.com.DesignPatterns.CompositePattern;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 12:07
 *
 * @author zrx
 * @version 1.0
 */

public class Item extends Component{
    String s;

    public Item(String s) {
        this.s = s;
    }

    @Override
    public void addComponent(Component component) {
        super.addComponent(component);
    }

    @Override
    public String toString() {
        return s;
    }

    @NotNull
    @Override
    public Iterator<Component> iterator() {
        return new NullIterator();
    }

    private static class NullIterator implements Iterator<Component>{
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }
}
