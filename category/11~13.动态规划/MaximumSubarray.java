package leetcode.editor.cn;

/**
 * [53]最大子序和
 * @author luchao
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：最大子序和
     *
     * 思路：DP
     * 1.定义状态：dp[i], 前i个元素构成的 以nums[i]结束 的最大子序和
     *   "连续"子数组，定义中以nums[i]结束
     * 2.转移方程：dp[i] = max(dp[i - 1] + nums[i], nums[i])
     * 3.边界：dp[0] = nums[0]
     * 4.目标：max{dp[i]}
     */
    public int maxSubArray(int[] nums) {
        // init
        int n = nums.length;
        int[] dp = new int[n];
        // bound
        dp[0] = nums[0];
        // dp
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        // target
        int ans = -1000000000;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
