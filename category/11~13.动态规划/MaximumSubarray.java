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
     * 思路：DP
     * 1.定义状态：dp[i]，0 <= i < n，dp[i]表示[0, i]下标范围内最大子序和；
     * 2.状态转移方程：dp[i] = max(dp[i - 1] + nums[i], nums[i]);
     * 3.ans = max(dp[0], ..., dp[n - 1])。
     */
    public int maxSubArray(int[] nums) {
        // init
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        // DP
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
