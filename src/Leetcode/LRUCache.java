package Leetcode;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 *
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字/值」。当
 * 缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 */
public class LRUCache {

    private HashMap<Integer, Node> map;
    private NodeDoubleLinkedList cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        //map和链表要同时更新数据
        this.map = new HashMap<Integer, Node>(capacity);
        this.cache = new NodeDoubleLinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)){
            //更新记录
            int val = map.get(key).value;
            put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //生成新元素，因为你不能确定是真的新加入的元素还是对原来元素的使用
        Node newNode = new Node(key, value);

        //包含该键值
        if (map.containsKey(key)){
            //删除原来的元素
            cache.remove(map.get(key));
            //更新到头部
            cache.addNode(newNode);
            //更新map
            map.put(key, newNode);
        } else{
            //满了，则从链表和map中同时删除数据
            if (cache.size() == this.capacity){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            //map和链表同时更新数据
            cache.addNode(newNode);
            map.put(key, newNode);
        }

    }

    class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class NodeDoubleLinkedList{
        private Node head;
        private Node tail;
        private int size;

        public NodeDoubleLinkedList(){
            //此处设为0可以减少中间逻辑
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
            this.size = 0;
        }

        //加入新节点
        public void addNode(Node newNode){
            //新元素移动到链表头部
            newNode.next = head.next;
            newNode.next.pre = newNode;
            newNode.pre = head;
            head.next = newNode;
            size++;

        }

        //删除某一个节点
        public void remove(Node delNode){
            delNode.pre.next = delNode.next;
            delNode.next.pre = delNode.pre;
            size--;
        }

        //删除链表最后一个节点并返回
        public Node removeLast(){
            //没有一个节点时
            if (this.head.next == tail){
                return null;
            } else{
                //删除最后一个节点
                Node last = tail.pre;
                remove(last);
                return last;
            }
        }

        public int size(){
            return size;
        }
    }
}