package base.collection;

import java.util.Iterator;

@Deprecated
public class EHashSet<E> implements JSet<E> {
    private static final double LOAD_FACTOR = 0.75;

    private Object[] array;
    private int size;

    public EHashSet() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        array = new Object[16];
        size = 0;
    }

    private int getElementPosition(E e, int arrLength) {
        return Math.abs(e.hashCode() % arrLength);
    }

    @Override
    public boolean add(E e) {
        if (size >= (array.length * LOAD_FACTOR)) expandArray();
        return add(e, array) && (++size > 0);
    }

    private boolean add(E e, Object[] dest) {
        int position = getElementPosition(e, dest.length);
        if (dest[position] == null) {
            dest[position] = new Entry(e, null);
            return true;
        }
        Entry existent = (Entry) dest[position];
        while (true) {
            if (existent.value.equals(e)) return false;
            if (existent.next == null) {
                existent.next = new Entry(e, null);
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
                add(entry.value, extended);
                entry = entry.next;
            }
        }
        array = extended;
    }

    @Override
    public boolean remove(E e) {
        int position = getElementPosition(e, array.length);
        if (array[position] == null) return false;

        Entry prevEntry = (Entry) array[position];
        Entry nextEntry = prevEntry.next;
        if (prevEntry.value.equals(e)) {
            array[position] = nextEntry;
            size--;
            return true;
        }
        while (nextEntry != null) {
            if (nextEntry.value.equals(e)) {
                prevEntry.next = nextEntry.next;
                size--;
                return true;
            } else {
                prevEntry = nextEntry;
                nextEntry = nextEntry.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        int position = getElementPosition(e, array.length);
        if (array[position] == null) return false;
        Entry prevEntry = (Entry) array[position];
        Entry nextEntry = prevEntry.next;
        if (prevEntry.value.equals(e)) return true;
        while (nextEntry != null) {
            if (nextEntry.value.equals(e)) return true;
            nextEntry = nextEntry.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        setDefaultValues();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Object elem : array) {
            Entry existent = (Entry) elem;
            while (existent != null) {
                sb.append(existent.value).append(", ");
                existent = existent.next;
            }
        }
        int index = sb.lastIndexOf(", ");
        sb.delete(index, index + 2);
        return sb.append("]").toString();
    }

    private class Entry {
        private E value;
        private Entry next;

        public Entry(E value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Entry entry;
            private int index = 0;
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                while (array[pos] == null) pos++;
                if (entry == null) entry = (Entry) array[pos];
                E e = entry.value;
                entry = entry.next;
                if (entry == null) pos++;
                index++;
                return e;
            }
        };
    }
}
