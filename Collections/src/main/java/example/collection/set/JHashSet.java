package example.collection.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JHashSet<E> implements JSet<E> {
    private Map<E, Object> map;
    private Object object;

    public JHashSet() {
        map = new HashMap<>();
        object = new Object();
    }

    @Override
    public boolean add(E e) {
        if (map.containsKey(e)) return false;
        map.put(e, object);
        return true;
    }

    @Override
    public boolean remove(E e) {
        return map.remove(e, object);
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
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
