package leetcode.editor.cn;

/**
 * [206]反转链表
 * @author luchao
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
     * 特征：反转
     * 主体：遍历链表反转
     * 细节：边界，null
     */
    public ListNode reverseList(ListNode head) {
        ListNode end = null;
        while(head != null) {
            ListNode next = head.next;
            // 反转
            head.next = end;
            // 移动指针
            end = head;
            head = next;
        }
        return end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}