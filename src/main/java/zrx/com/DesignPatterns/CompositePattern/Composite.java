package zrx.com.DesignPatterns.CompositePattern;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description
 * Composite
 * <p>
 * Data
 * 12:08
 *
 * @author zrx
 * @version 1.0
 */

public class Composite extends Component{
    List<Component> list = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        list.add(component);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @NotNull
    @Override
    public Iterator<Component> iterator() {
        return list.iterator();
    }
}
