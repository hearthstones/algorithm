package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [239]滑动窗口最大值
 * @author luchao
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：暴力，双循环，O(kn)，超时
     *     => 优化，找冗余：下标 j1 < j2（时间单调性），且 nums[j1] <= nums[j2]，j1就没用了
     *     => 单调性：下标递增，对应的nums[i]递减
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        // 单调队列，存放下标（代表时间）
        Deque<Integer> deque = new LinkedList<>();
        // 1,3,-1,-3,2,3,6,7  k=3
        // i = 0, d: {0}, 窗口未形成
        // i = 1, d: {1}, 窗口未形成
        // i = 2, d: {1, 2}, ans: {nums[1]}
        // i = 3, d: {1, 2, 3}, ans: {nums[1], nums[1]}
        // i = 4, d: {4}, ans: {nums[1], nums[1], nums[4]}。d{1,2,3}中1过期，nums[2]、nums[3] <= nums[4]
        // ...
        for (int i = 0; i < len; i++) {
            // 维护队列单调性
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) deque.removeLast();
            deque.addLast(i);
            // 保证队头合法性，去掉过期的下标
            while (!deque.isEmpty() && deque.getFirst() <= i - k) deque.removeFirst();
            // 取队头更新答案
            if (i >= k - 1) ans[i - k + 1] = nums[deque.getFirst()];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
