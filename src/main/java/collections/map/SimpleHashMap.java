package collections.map;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private static final int ARRAY_SIZE = 100;

    private Node<K, V>[] table;
    private int size;


    public SimpleHashMap() {
        clear();
    }

    private Node<K, V> getNode(Object key) {
        return table[key.hashCode() % ARRAY_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(Object key) {
        Node<K, V> node = getNode(key);
        while (node != null) {
            if (node.key.equals(key))
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node : table) {
            while (node != null) {
                if (node.value.equals(value))
                    return true;
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = getNode(key);
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % ARRAY_SIZE;
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
        }
        Node<K, V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode() % ARRAY_SIZE;
        Node<K, V> node = table[index];
        if (node == null)
            return null;
        if (node.key.equals(key)) {
            V result = node.value;
            table[index] = node.next;
            return result;
        }
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                V result = node.next.value;
                node.next = node.next.next;
                return result;
            }
        }
        size--;
        return null;
    }

    @Override
    public void clear() {
        table = (Node<K, V>[]) new Node[ARRAY_SIZE];
        size = 0;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> entrySet =  new HashSet<>();
        for(Node<K, V> list : table){
            Node<K, V> node = list;
            while(node!=null){
                entrySet.add(new SimpleMapEntry<>(node.key, node.value));
                node = node.next;
            }
        }
        return null;
    }

    private class Node<T extends K, E extends V> {

        private T key;
        private E value;
        private Node<T, E> next;

        public Node(T key, E value, Node<T, E> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
