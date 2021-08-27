package leetcode.editor.cn;

/**
 * [21]合并两个有序链表
 * @author luchao
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
     * 特征：升序
     * 主体：双指针分别遍历两个链表，谁小放在新链表后
     * 细节：1.哨兵结点; 2.任一为空，另一个剩下的结点直接放新链表后.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 哨兵结点
        ListNode head = new ListNode(-1);
        // 新链表指针
        ListNode curr = head;
        // 双指针遍历
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // l1,l2任一遍历完
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}