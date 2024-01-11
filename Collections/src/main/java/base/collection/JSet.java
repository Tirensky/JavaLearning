package base.collection;

public interface JSet<E> extends JCollection<E> {
    boolean add(E e);

    boolean remove(E e);

    int size();

    void clear();
}