package leetcode.editor.cn;

import org.bouncycastle.util.Arrays;

/**
 * [300]最长递增子序列
 * @author luchao
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：LIS，经典DP问题
     *
     * 思路：DP
     * 1.定义状态：dp[i], 前i个数构成的 以nums[i]结尾 的 LIS长度
     * 2.转移方程：dp[i] = max{dp[j] + 1}, 满足0 <= j < i, nums[j] < nums[i]
     * 3.边界：dp[0] = 1
     * 4.目标：max{dp[i]}
     */
    public int lengthOfLIS(int[] nums) {
        // init
        int n = nums.length;
        int[] dp = new int[n];
        // bound
        dp[0] = 1;
        // dp
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 满足递增条件
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // target
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
