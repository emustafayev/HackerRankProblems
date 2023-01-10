package leet_code;

import java.util.HashMap;

public class LRUCache {


    public static void main(String[] args) {

    }


    private final HashMap<Integer, Node> map;
    private final Node head = new Node();
    private final Node tail = new Node();
    int cache_capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        Node node = map.get(key);
        if (node != null) {
            res = node.value;
            remove(node);
            insert(node);
        }

        return res;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            insert(node);
        } else {
            if (map.size() == cache_capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
        }
    }

    private void insert(Node node) {
        Node headNext = head.next; // tail
        // put node between head and tail
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
