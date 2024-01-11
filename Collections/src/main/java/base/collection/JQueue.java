package base.collection;

public interface JQueue<E> extends JCollection<E> {
    boolean add(Object e);

    /**
     * Retrieves first element and remove it, or throw exception if queue is empty
     * @return the head of this queue
     * @throws java.util.NoSuchElementException  if this queue is empty
     */
    E remove();

    /**
     * Retrieves first element, but doesn't remove it, or return null if queue is empty;
     * @return the head of this queue or null
     */
    E peek();

    /**
     * Retrieves first element and remove it, or return null if queue is empty
     *
     * @return the head of this queue or null
     */
    E poll();
}
