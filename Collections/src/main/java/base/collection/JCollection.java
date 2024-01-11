package base.collection;

public interface JCollection<E> extends Iterable<E> {
    boolean add(E e);

    boolean remove(E e);

    boolean contains(E e);

    int size();

    void clear();
}
