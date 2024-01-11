package base.map;

import base.collection.*;

public class JHashMap<K, V> implements JMap<K, V> {
    private final static double LOAD_FACTOR = 0.75;

    private Object[] array;
    private int size;

    public JHashMap() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        array = new Object[16];
        size = 0;
    }

    @Override
    public V get(K k) {
        int position = getElementPosition(k, array.length);
        Entry existent = (Entry) array[position];
        while (existent != null) {
            if (existent.key.equals(k)) return existent.value;
            existent = existent.next;
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        if (size >= (array.length * LOAD_FACTOR)) expandArray();
        return (put(k, v, array) && (++size > 0)) ? v : null;
    }

    private boolean put(K k, V v, Object[] dest) {
        int position = getElementPosition(k, dest.length);
        if (dest[position] == null) {
            dest[position] = new Entry(k, v, null);
            return true;
        }
        Entry existent = (Entry) dest[position];
        while (true) {
            if (existent.key.equals(k)) {
                existent.value = v;
                return false;
            }
            if (existent.next == null) {
                existent.next = new Entry(k, v, null);
                return true;
            }
            existent = existent.next;
        }
    }

    private void expandArray() {
        Object[] extended = new Object[array.length * 2];
        for (Object elem : array) {
            Entry entry = (Entry) elem;
            while (entry != null) {
                put(entry.key, entry.value, extended);
                entry = entry.next;
            }
        }
        array = extended;
    }

    @Override
    public V remove(K k) {
        int position = getElementPosition(k, array.length);
        Entry existent = (Entry) array[position];
        if (existent != null && existent.key.equals(k)) {
            V v = existent.value;
            array[position] = existent.next;
            size--;
            return v;
        }
        Entry entry; V v;
        while (existent != null) {
            entry = existent.next;
            if (entry.key.equals(k)) {
                v = entry.value;
                existent.next = entry.next;
                size--;
                return v;
            }
            existent = existent.next;
        }
        return null;
    }

    private int getElementPosition(K k, int arrLength) {
        return Math.abs(k.hashCode() % arrLength);
    }

    @Override
    public JSet<K> keySet() {
        JSet<K> keys = new JHashSet<>();
        transferData(keys, true);
        return keys;
    }

    @Override
    public JList<V> values() {
        JList<V> values = new JArrayList<>();
        transferData(values, false);
        return values;
    }

    private <C> void transferData(JCollection<C> collection, boolean isKey) {
        for (Object elem : array) {
            Entry existent = (Entry) elem;
            while (existent != null) {
                if (isKey) collection.add((C) existent.key);
                else collection.add((C) existent.value);
                existent = existent.next;
            }
        }
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
        private K key;
        private V value;
        private Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Object elem : array) {
            Entry existent = (Entry) elem;
            while (existent != null) {
                sb.append(existent.key)
                        .append("=")
                        .append(existent.value)
                        .append(", ");
                existent = existent.next;
            }
        }
        int index = sb.lastIndexOf(", ");
        sb.delete(index, index + 2);
        return sb.append("}").toString();
    }
}
