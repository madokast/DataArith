package zrx.com.DesignPatterns.CompositePattern;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Description
 * 组件
 * <p>
 * Data
 * 12:05
 *
 * @author zrx
 * @version 1.0
 */

public abstract class Component implements Iterable<Component>{

    public void addComponent(Component component){
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public Iterator<Component> iterator() {
        throw new UnsupportedOperationException();
    }
}
