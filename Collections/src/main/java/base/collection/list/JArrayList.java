package example.collection.list;

import java.util.Arrays;
import java.util.Iterator;

public class JArrayList<E> implements JList<E> {
    private Object[] array;
    private int size;
    
    public JArrayList() {
        setDefaultValues();
    }
    
    private void setDefaultValues() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(E e) {
        resizeWhenFilled();
        array[size++] = e;
        return true;
    }

    @Override
    public boolean add(E e, int index) {
        resizeWhenFilled();
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Object[] src = array;
        int fromPos = index;
        Object[] dest = array;
        int toPos = index + 1;
        int shiftLength = size - index;

        System.arraycopy(src, fromPos, dest, toPos, shiftLength);
        array[index] = e;
        size++;
        return true;
    }

    private void resizeWhenFilled() {
        if (size >= array.length)
            array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public boolean remove(E e) {
        return findElement(e) != -1 && remove(findElement(e));
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public boolean contains(E e) {
        return findElement(e) != -1;
    }

    private int findElement(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) return i;
        }
        return -1;
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
