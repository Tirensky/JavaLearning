package example.collection.queue;

import example.collection.JCollection;

public interface JQueue<E> extends JCollection<E> {
    // Retrieves first element and remove, or returns exception if list is empty
    E remove();

    // Retrieves first element, but doesn't remove, or returns null if list is empty
    E peek();

    // Retrieves first element and remove, or returns null if list is empty
    E poll();
}
