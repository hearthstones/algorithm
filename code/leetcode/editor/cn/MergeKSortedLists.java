package leetcode.editor.cn;

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
    // 全局
    private ListNode[] lists;

    /**
     * 特征：升序、合并两个 -> 合并k个
     * 主体：1.分治，递归实现。
     *      推导：mid = (0 + k - 1) / 2, 合并(k) = merge(0, k - 1) = merge(merge(0, mid), merge(mid + 1, k - 1))
     *      通项（换元）：mid = (lower + upper) / 2, merge(lower, upper) = merge(merge(lower, mid), merge(mid + 1, upper))
     *      2.合并两个升序链表。
     * 细节：边界，举例确定边界
     */
    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        if (lists.length == 0) {
            return null;
        }
        return recur(0, lists.length - 1);
    }

    /**
     * 分治，递归方法
     *
     * @param lower 左边界
     * @param upper 右边界
     * @return ListNode
     */
    private ListNode recur(int lower, int upper) {
//        System.out.println("lower: " + lower + ", upper:" + upper);
        // 终止条件
        if (lower == upper) {
            return lists[lower];
        }
        // 通项：mid = (lower + upper) / 2, merge(lower, upper) = merge(merge(lower, mid), merge(mid + 1, upper))
        int mid = (lower + upper) >> 1;
        return mergeTwoLists(recur(lower, mid), recur(mid + 1, upper));
    }

    /**
     * 合并两个升序链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的新链表
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 哨兵结点
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        // 双指针分别遍历，谁小放谁
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 遍历完任一链表后，另一个直接加到新链表末尾
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
