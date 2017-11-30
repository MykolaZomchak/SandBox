package collections;


import java.util.*;

public class SimpleArrayList<E> implements List<E> {

    private Object[] array = new Object[10];
    private int size = 0;

    public SimpleArrayList() {}

    private SimpleArrayList(E[] array) {
        this.array = array;
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++)
            if (array[i].equals(o))
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayListIterator<>();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size())
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size());
        return a;
    }

    private void makeRoom(int size) {
        if (array.length < size) {
            Object[] temp = array;
            array = new Object[array.length * 3 / 2];
            System.arraycopy(temp, 0, array, 0, size());
        }
    }

    @Override
    public boolean add(E e) {
        makeRoom(1);
        array[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0)
            return false;
        System.arraycopy(array, index + 1, array, index, size-- - index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c)
            if (!contains(o))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        makeRoom(c.size());
        int i;
        for (i = size() - 1; i >= index; i--)
            array[i + c.size()] = array[i];
        i++;
        for (Object o : c)
            array[i++] = o;
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o : c)
            if (remove(o))
                changed = true;
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int diff = 0;
        for (int i = 0; i < size(); i++)
            if (!c.contains(array[i])) {
                array[i] = array[++diff + i--];
                size--;
            }
        return diff > 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= size())
            throw new IndexOutOfBoundsException("the index is out of range");
        E result = (E) array[index];
        array[index] = element;
        return result;
    }

    @Override
    public void add(int index, E element) {
        if (index > size())
            throw new IndexOutOfBoundsException("the index is out of range");
        makeRoom(1);
        System.arraycopy(array, index, array, index + 1, size++ - index);
        array[index] = element;
    }

    @Override
    public E remove(int index) {
        if (index > size())
            throw new IndexOutOfBoundsException("the index is out of range");
        E result = (E) array[index];
        System.arraycopy(array, index + 1, array, index + 1 - 1, size-- - (index + 1));
        return result;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++)
            if (array[i].equals(o))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--)
            if (array[i].equals(o))
                return i;
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new SimpleArrayListIterator<>();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new SimpleArrayListIterator<>(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return new SimpleArrayList<>((E[]) Arrays.copyOfRange(array, fromIndex, toIndex));
    }

    private class SimpleArrayListIterator<T extends E> implements ListIterator<T> {

        private int index = 0;

        private SimpleArrayListIterator() {

        }

        private SimpleArrayListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return (T) array[index++];
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            return (T) array[--index];
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
            SimpleArrayList.this.remove(index - 1);
        }

        @Override
        public void set(T e) {
            SimpleArrayList.this.set(index - 1, e);
        }

        @Override
        public void add(T e) {
            SimpleArrayList.this.add(index++, e);
        }
    }
}