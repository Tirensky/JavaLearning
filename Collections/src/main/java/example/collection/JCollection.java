package example.collection;

public interface JCollection<E> extends Iterable<E> {
    boolean add(E e);

    boolean remove(E e);

    int size();

    void clear();

    boolean contains(E e);
}
