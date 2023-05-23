package example.map;

import java.util.List;
import java.util.Set;

public interface JMap<K, V> {
    V put(K k, V v);

    V get(K k);

    Set<K> keySet();

    List<V> values();

    V remove(K k);

    boolean containsKey(K k);

    int size();

    void clear();
}
