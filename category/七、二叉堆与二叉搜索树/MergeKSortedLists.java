package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * [23]合并K个升序链表
 * @author luchao
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 特征：合并K个升序
     * 主体：小顶堆（java优先队列）
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // init
        // ans链表保护结点
        ListNode head = new ListNode(-1);
        // ans链表指针
        ListNode curr = head;
        // 优先队列（小顶堆），定义排序规则
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((node1, node2) -> node1.val - node2.val);

        // 入队：K个链表第一个结点
        for (ListNode listHead : lists) {
            if (listHead != null) {
                queue.offer(listHead);
            }
        }

        // 维护ans链表
        while (!queue.isEmpty()) {
            // 最小值出队，添加到ans链表尾部
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            // node下一结点入队
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
