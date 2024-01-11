package base.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JHashSet<E> implements JSet<E> {
    private Map<E, Object> map;
    private static final Object object = new Object();

    public JHashSet() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        map = new HashMap<>();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, object) != null;
    }

    @Override
    public boolean remove(E e) {
        return map.remove(e) != null;
    }

    @Override
    public boolean contains(E e) {
        return map.containsKey(e);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Object elem : map.keySet()) {
            sb.append(elem).append(", ");
        }
        int index = sb.lastIndexOf(", ");
        sb.delete(index, index + 2);
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
