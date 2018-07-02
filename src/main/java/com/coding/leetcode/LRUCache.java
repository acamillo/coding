package com.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author acamillo
 * @since 29/06/18.
 */
public class LRUCache<K, V> {

    class Node<K, V> {

        Node<K,V> before;
        Node<K,V> after;

        K key;
        V value;

        public Node(K key, V value) {
            this.before = null;
            this.after = null;
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private int size;

    private  Node<K,V> head, tail;
    private final Map<K, Node<K,V>> map = new HashMap<K, Node<K, V>>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = tail = null;
        size = 0;
    }

    void put(K key, V value) {
        Node<K,V> node = new Node<K, V>(key, value);
        map.put(key, node);

        if (size < capacity) {
            size++;
        } else {
            // need to delete the LRU element.
            map.remove(head.key);
            removeFromHead();
        }

        afterNodeInsert(node);
    }

    private void removeFromHead() {
        Node<K,V> first = head;

        head = head.after;
        if (head != null)
            head.before = null;
        first.before = null;
        first.after = null;
    }

    V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null)
            return null;

        afterNodeAccess(node);

        return node.value;
    }

    private void afterNodeInsert(Node<K,V> node) {
        if (head == null) {
            head = node;
        }

        if (tail != null) {
            tail.after = node;
            node.before = tail;
            node.after = null;

        }
        tail = node;
    }

    private void afterNodeAccess(Node<K,V> node) {
        Node<K,V> last = tail;
        if (node != last) {
            Node<K,V> a = node.after, b = node.before;

            if (node == head) {
                head = node.after;
                head.before = null;

                node.before = last;
            } else {
                b.after = node.after;
                a.before = node.before;
            }

            last.after = node;
            node.before = last;
            tail = node;
            node.after = null;
        }
    }
}
