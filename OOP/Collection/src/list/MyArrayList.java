package list;

public class MyArrayList implements MyList {
    private String[] array;
    int size;

    public MyArrayList() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        array = new String[10];
        size = 0;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean add(String s) {
        if (isSizeLimit()) System.arraycopy(array, 0, array, 0, array.length * 2);
        array[size++] = s;
        return true;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(String s) {
        if (s != null) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(s)) return remove(i);
            }
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

    private boolean isSizeLimit() {
        return size >= array.length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            strBld.append(array[i]);
            if (i < size - 1) strBld.append(", ");
        }
        strBld.append("]");
        return strBld.toString();
    }
}
