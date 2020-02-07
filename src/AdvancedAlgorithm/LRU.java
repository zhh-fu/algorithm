package AdvancedAlgorithm;

import javax.management.RuntimeErrorException;
import java.util.HashMap;

/**
 * 缓存更新问题 LRU
 */
public class LRU {

    private static class Node<K,V>{
        private V value;
        private K key;
        private Node<K,V> before;
        private Node<K,V> next;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<K,V>{
        private Node<K,V> head;
        private Node<K,V> tail;

        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }

        //增加节点
        public void addNode(Node<K,V> newNode){
            if (newNode == null){
                return;
            }

            //头节点为空，证明是链表中的第一个节点
            if (this.head == null){
                this.head = newNode;
                this.tail = newNode;
            }
            //否则更新链表的尾指针
            else{
                this.tail.next = newNode;
                newNode.before = this.tail;
                this.tail = newNode;
            }
        }

        //移动节点到尾部
        public void moveNodeToTail(Node<K,V> node){
            //尾节点则不用变
            if (node == this.tail){
                return;
            }

            //头节点的更新逻辑
            if (node == this.head ){
                this.head = this.head.next;
                this.head.before = null;
            }
            else {
                //中间节点断连
                node.before.next = node.next;
                node.next.before = node.before;
            }

            //尾部节点逻辑变更
            node.before = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        //移除头部并返回新的头部
        public Node<K,V> removeHead(){
            if (this.head == null){
                return null;
            }

            Node<K,V> res = this.head;
            //只有一个节点
            if (this.head == this.tail){
                this.head = null;
                this.tail = null;
            }
            else {
                this.tail = res.next;
                this.tail.before = null;
                res.before = null;
                res.next = null;
            }

            return res;
        }
    }

    public static class MyCache<K,V>{
        //此处的value并不是真的存的Node值，而是内存地址
        //如果类型为基础类型或诸如String等常见引用数据类型，存的是引用
        private HashMap<K,Node<K,V>> keyNodeMap;
        //private HashMap<Node<K,V>,K> nodeKeyMap;
        private NodeDoubleLinkedList<K,V> nodeList;
        private int capacity;

        public MyCache(int capacity){
            if (capacity < 1){
                throw new RuntimeException("capacity should be bigger than 1!");
            }
            this.keyNodeMap = new HashMap<K, Node<K,V>>();
            //this.nodeKeyMap = new HashMap<Node<V>, K>();
            this.nodeList = new NodeDoubleLinkedList<K,V>();
            this.capacity = capacity;
        }

        //得到某个值
        public V get(K key){
            if (this.keyNodeMap.containsKey(key)){
                Node<K,V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        //设置某个值
        public void set(K key,V value){
            //如果包含该节点
            if (this.keyNodeMap.containsKey(key)){
                Node<K,V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            }
            else{
                Node<K,V> newNode = new Node<>(key,value);
                this.keyNodeMap.put(key,newNode);
                this.nodeList.addNode(newNode);
                if (this.keyNodeMap.size() == this.capacity + 1){
                    this.removeMostUnusedCache();
                }
            }
        }

        //令最不常用节点从链表和哈希表中都删除掉
        public void removeMostUnusedCache(){
            Node<K,V> removeNode = this.nodeList.removeHead();
            K removeKey = removeNode.key;
            this.keyNodeMap.remove(removeKey);
        }
    }
}
