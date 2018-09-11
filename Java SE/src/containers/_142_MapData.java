package containers;

import java.util.LinkedHashMap;

import generics._109_Generator;

public class _142_MapData<K, V> extends LinkedHashMap<K, V> {
    // A single Pair Generator:
    public _142_MapData(_109_Generator<_141_Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            _141_Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    // Two separate Generators:
    public _142_MapData(_109_Generator<K> genK, _109_Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    // A key Generator and a single value:
    public _142_MapData(_109_Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }

    // An Iterable and a value Generator:
    public _142_MapData(Iterable<K> genK, _109_Generator<V> genV) {
        for (K key : genK) {
            put(key, genV.next());
        }
    }

    // An Iterable and a single value:
    public _142_MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }

    // Generic convenience methods:
    public static <K, V> _142_MapData<K, V> map(_109_Generator<_141_Pair<K, V>> gen, int quantity) {
        return new _142_MapData<K, V>(gen, quantity);
    }

    public static <K, V> _142_MapData<K, V> map(_109_Generator<K> genK, _109_Generator<V> genV, int quantity) {
        return new _142_MapData<K, V>(genK, genV, quantity);
    }

    public static <K, V> _142_MapData<K, V> map(_109_Generator<K> genK, V value, int quantity) {
        return new _142_MapData<K, V>(genK, value, quantity);
    }

    public static <K, V> _142_MapData<K, V> map(Iterable<K> genK, _109_Generator<V> genV) {
        return new _142_MapData<K, V>(genK, genV);
    }

    public static <K, V> _142_MapData<K, V> map(Iterable<K> genK, V value) {
        return new _142_MapData<K, V>(genK, value);
    }
}