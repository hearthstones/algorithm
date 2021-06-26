package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [146]LRU 缓存机制
 * @author luchao
 */
public class LruCache {
    public static void main(String[] args) {
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 特征：缓存淘汰策略 LRU —— 删除最近最少使用
 *      Java LinkedHashMap
 * 主体：哈希表 + 双向链表。链表维护时间顺序, 哈希表保证 O(1) get/put
 * 细节：1.频繁删除、插入，双向链表更易操作；2.保护结点；3.双向链表需要自己实现。
 */
class LRUCache {

    // 双向链表结点定义
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }
    // 属性
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // 保护性头尾结点
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 维护时间顺序，先删后插
        Node node = map.get(key);
        removeCache(node);
        addCache(node.key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        // 已存在：先删除，再插入，维护时间顺序；不存在：直接插入。
        if (map.containsKey(key)) {
            removeCache(map.get(key));
        }
        addCache(key, value);
        // 缓存容量超过上限，删除最近最少使用缓存
        if (map.size() > this.capacity) {
            removeCache(tail.pre);
        }
    }

    /**
     * 删除缓存
     * <p>
     * 1.删除链表结点；
     * 2.删除map映射。
     * </p>
     *
     * @param node node
     */
    private void removeCache(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        map.remove(node.key);
    }

    /**
     * 添加缓存
     * <p>
     * 1.添加到表头；
     * 2.添加到map。
     * 注意：参数不是node，node带前后指针，添加缓存，只需要key、value即可
     * </p>
     *
     * @param key key
     * @param value value
     */
    private void addCache(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        // 插入头结点后
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
        // 插入map
        map.put(key, node);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
