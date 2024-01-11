package base.map;

import base.collection.JList;
import base.collection.JSet;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface JMap<K, V> {
    V get(K k);

    V put(K k, V v);

    V remove(K k);

    JSet<K> keySet();

    JList<V> values();

    boolean containsKey(K k);

    int size();

    void clear();
}
