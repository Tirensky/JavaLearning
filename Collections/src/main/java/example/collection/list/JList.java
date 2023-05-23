package example.collection.list;

import example.collection.JCollection;

public interface JList<E> extends JCollection<E> {
    E get(int index);

    boolean add(E e);

    boolean add(E e, int index);

    boolean remove(E e);

    boolean remove(int index);

    int size();

    void clear();
}
