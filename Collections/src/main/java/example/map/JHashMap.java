package example.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JHashMap<K, V> implements JMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Object[] array;
    private int size;

    public JHashMap() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public V put(K k, V v) {
        if (size >= (array.length * LOAD_FACTOR)) resizeArray();;
        if (put(k, v, array)) size++;
        return v;
    }

    private boolean put(K k, V v, Object[] dest) {
        int position = getPosition(k, dest.length);
        Entry existent = (Entry) dest[position];
        if (existent == null) {
            dest[position] = new Entry(k, v, null);
            return true;
        } else {
            while (true) {
                if (existent.k.equals(k)) {
                    existent.v = v;
                    return false;
                }
                if (existent.next == null) {
                    existent.next = new Entry(k, v, null);
                    return true;
                }
                existent = existent.next;
            }
        }
    }

    @Override
    public V get(K k) {
        int position = getPosition(k, array.length);
        Entry existent = (Entry) array[position];
        while (existent != null) {
            if (existent.k.equals(k)) return existent.v;
            existent = existent.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object entry : array) {
            Entry existent = (Entry) entry;
            while (existent != null) {
                result.add(existent.k);
                existent = existent.next;
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> result = new ArrayList<>();
        for (Object entry : array) {
            Entry existent = (Entry) entry;
            while (existent != null) {
                result.add(existent.v);
                existent = existent.next;
            }
        }
        return result;
    }

    @Override
    public V remove(K k) {
        int position = getPosition(k, array.length);
        Entry existent = (Entry) array[position];
        if (existent != null && existent.k.equals(k)) {
            V car = existent.v;
            array[position] = existent.next;
            size--;
            return car;
        } else {
            while (existent != null) {
                Entry entry = existent.next;
                if (entry.k.equals(k)) {
                    V car = entry.v;
                    existent.next = entry.next;
                    size--;
                    return car;
                }
                existent = existent.next;
            }
        }
        return null;
    }

    private int getPosition(K k, int arrayLength) {
        return Math.abs(k.hashCode() % arrayLength);
    }

    private void resizeArray() {
        Object[] newArray = new Object[array.length * 2];
        for (Object entry : array) {
            Entry existent = (Entry) entry;
            while (existent != null) {
                put(existent.k, existent.v, newArray);
                existent = existent.next;
            }
        }
        array = newArray;
    }

    @Override
    public boolean containsKey(K k) {
        return get(k) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        setDefaultValues();
    }

    private class Entry {
        private K k;
        private V v;
        private Entry next;

        public Entry(K k, V v, Entry next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }
}
