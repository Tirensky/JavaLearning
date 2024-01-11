package example.collection.list;

import example.collection.queue.JQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JLinkedList<E> implements JList<E>, JQueue<E> {
    private Node first;
    private Node last;
    private int size;

    public JLinkedList() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(E e) {
        if (size == 0) {
            first = new Node(null, e, null);
            last = first;
        } else {
            Node previous = last;
            last = new Node(previous, e, null);
            previous.next = last;
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
        if (prevNode != null) {
            prevNode.next = node;
        } else {
            first = node;
        }
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (size == 0) throw new NoSuchElementException();
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
    public boolean remove(E e) {
        return findElement(e) != -1 && remove(findElement(e));
    }

    @Override
    public boolean remove(int index) {
        Node node = getNode(index);
        Node nextNode = node.next;
        Node prevNode = node.prev;
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            last = prevNode;
        }
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            first = nextNode;
        }
        size--;
        return true;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean contains(E e) {
        return findElement(e) != -1;
    }

    private int findElement(E e) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(e)) return i;
            node = node.next;
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
            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E e = node.value;
                node = node.next;
                return e;
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private class Node {
        private Node prev;
        private E value;
        private Node next;

        public Node(Node prev, E value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
