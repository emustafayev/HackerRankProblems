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
            remove(node);
            res = node.value;
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
                //map is full remove the least used node
                //The least used node is on tail of prev
                map.remove(tail.prev.key);
                remove(tail.prev); // remove method will remove prev of tail and connect remaining least node to tail again
            }// ready to add
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);//insert to head, because we have new node and needs to be in list
        }
    }


    public void insert(Node node) {
        //insert to head
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

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
