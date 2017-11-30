package collections.map;

import java.util.Map;

public class SimpleMapEntry<K,V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    public SimpleMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V result = this.value;
        this.value = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleMapEntry)) return false;

        SimpleMapEntry<?, ?> that = (SimpleMapEntry<?, ?>) o;

        return getKey().equals(that.getKey()) && (getValue() != null ? getValue().equals(that.getValue()) : that.getValue() == null);
    }

    @Override
    public int hashCode() {
        int result = getKey().hashCode();
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }
}
