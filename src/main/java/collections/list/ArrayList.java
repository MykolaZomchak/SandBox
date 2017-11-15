package collections.list;

import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class ArrayList<E> implements List<E> {

    private E[] array;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }

    public Object[] toArray() {
        return array;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length > size) {
            return (T[]) array.clone();
        }
        System.arraycopy(array, 0, a, 0, size);
        return a;

    }

    public boolean add(E e) {
        prepareSize(size+1);
        array[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            for (int i = index + 1; i < size; i++) {
                array[i-1] = array[i];
            }
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        for(Object e : c){
            if(indexOf(e) <0){
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        prepareSize(size + c.size());
        for(E e : c){
            add(e);
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        prepareSize(size + c.size());

        return true;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E element) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void prepareSize(int newSize) {
        throw new NotImplementedException();
    }

    private class ArrayListIterator<E> implements ListIterator<E> {

        public boolean hasNext() {
            return false;
        }

        public E next() {
            return null;
        }

        public boolean hasPrevious() {
            return false;
        }

        public E previous() {
            return null;
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return 0;
        }

        public void remove() {

        }

        public void set(E e) {

        }

        public void add(E e) {

        }

        public void insert(int index, E e){

        }
    }
}
