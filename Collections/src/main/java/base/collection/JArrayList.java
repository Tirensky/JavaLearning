package base.collection;

import java.util.Arrays;
import java.util.Iterator;

public class JArrayList<E> implements JList<E> {
    private Object[] array;
    private int size;

    public JArrayList() {
        setDefaultValues();
    }

    public void setDefaultValues() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index, index >= size);
        return (E) array[index];
    }

    private void checkIndex(int index, boolean condition) {
        if (index < 0 || condition) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(E e) {
        growOnFill(size);
        array[size++] = e;
        return true;
    }

    private void growOnFill(int index) {
        if (size >= array.length)
            array = Arrays.copyOf(array, array.length * 2);
        checkIndex(index, index > size);
    }

    @Override
    public boolean add(E e, int index) {
        growOnFill(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        return findElement(e) != -1 && remove(findElement(e));
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index, index >= size);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    private int findElement(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        return findElement(e) != -1;
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
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return (E) array[index++];
            }
        };
    }
}
