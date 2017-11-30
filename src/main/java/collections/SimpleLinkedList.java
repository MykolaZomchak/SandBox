package collections;

import java.util.*;

public class SimpleLinkedList<E> extends AbstractList<E> implements Queue<E> {

    private Node start = new Node();
    private Node end = new Node();
    private int size = 0;

    public SimpleLinkedList() {
        start.right = end;
        end.left = start;
    }

    private Node getNode(int index) {
        Node node;
        int i;
        if (index < size() / 2) {
            node = start.right;
            for (i = 0; i < index; i++)
                node = node.right;
        }
        else {
            node = end.left;
            for (i = size() - 1; i > index; i--)
                node = node.left;
        }
        return node;
    }

    private E removeNode(Node node) {
        size--;
        node.left.right = node.right;
        node.right.left = node.left;
        return node.value;
    }

    @Override
    public E get(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException("the index is out of range");
        Node node = start.right;
        for (int i = 0; i < index; i++)
            node = node.right;
        return node.value;
    }

    @Override
    public boolean add(E e) {
        new Node(end.left, e, end);
        size++;
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (isEmpty())
            new Node(start, e, end);
        else {
            Node node = getNode(index);
            new Node(node.left, e, node);
        }
        size++;
    }

    @Override
    public void clear() {
        start.right = end;
        end.left = start;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>();
    }

    @Override
    public E remove(int index) {
        return removeNode(getNode(index));
    }

    @Override
    public E set(int index, E element) {
        Node node = getNode(index);
        E res = node.value;
        node.value = element;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        if (isEmpty()) throw new NoSuchElementException("this queue is empty");
        return removeNode(end.left);
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        return removeNode(end.left);
    }

    @Override
    public E element() {
        if (isEmpty()) throw new NoSuchElementException("this queue is empty");
        return end.left.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return end.left.value;
    }

    private class Node {

        private E value;
        private Node left;
        private Node right;

        private Node() {}

        private Node(Node left, E value, Node right) {
            this.value = value;
            this.left = left;
            left.right = this;
            this.right = right;
            right.left = this;
        }
    }

    private class SimpleLinkedListIterator<T extends E> implements ListIterator<T> {

        private Node node = SimpleLinkedList.this.start;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            node = node.right;
            index++;
            return (T) node.value;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            node = node.left;
            index--;
            return (T) node.value;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            SimpleLinkedList.this.remove(--index);
        }

        @Override
        public void set(T t) {
            SimpleLinkedList.this.set(index, t);
        }

        @Override
        public void add(T t) {
            SimpleLinkedList.this.add(index++, t);
        }
    }

}
