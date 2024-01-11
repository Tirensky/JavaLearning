package base.collection;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class JLinkedList<E> implements JList<E>, JQueue<E> {
    private Node head, tail;
    private int size;

    public JLinkedList() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E) getNode(index).value;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean add(Object e) {
        if (size == 0) {
            head = new Node(null, e, null);
            tail = head;
        } else {
            Node prevNode = tail;
            tail = new Node(prevNode, e, null);
            prevNode.next = tail;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E e, int index) {
        if (index == size) return add(e);
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;
        Node node = new Node(prevNode, e, nextNode);
        nextNode.prev = node;
        if (prevNode != null) prevNode.next = node;
        else head = node;
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        return findElement(e) != -1 && remove(findElement(e));
    }

    @Override
    public boolean remove(int index) {
        Node currNode = getNode(index);
        Node nextNode = currNode.next;
        Node prevNode = currNode.prev;
        if (prevNode != null) prevNode.next = nextNode;
        else head = nextNode;
        if (nextNode != null) nextNode.prev = prevNode;
        else tail = prevNode;
        size--;
        return true;
    }

    @Override
    public E remove() {
        if (size <= 0) throw new NoSuchElementException();
        E e = get(0);
        remove(0);
        return e;
    }

    @Override
    public E peek() {
        return size > 0 ? get(0) : null;
    }

    @Override
    public E poll() {
        return size > 0 ? remove() : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        setDefaultValues();
    }

    private int findElement(E e) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(e)) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        return findElement(e) != -1;
    }

    private class Node<E> {
        private Node prev;
        private E value;
        private Node next;

        public Node(Node prev, E value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E e = (E) node.value;
                node = node.next;
                return e;
            }
        };
    }
}
