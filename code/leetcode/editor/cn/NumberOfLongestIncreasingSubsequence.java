package leetcode.editor.cn;

import java.util.Arrays;

/**
 * [673]最长递增子序列的个数
 * @author luchao
 */
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：LIS个数
     *
     * 思路：DP
     * 1.定义状态：
     *   dp[i], 前i个元素构成的 以nums[i]为结尾的 LIS长度
     *   count[i]用于计数, 前i个元素构成的 以nums[i]为结尾的 LIS个数
     * 2.转移方程：dp[i] = max{dp[j] + 1}, 满足j < i, nums[j] < nums[i]
     * 3.边界：dp[0] = 1
     */
    public int findNumberOfLIS(int[] nums) {
        // init
        int n = nums.length;
        int[] dp = new int[n];
        int[] counts = new int[n];
        // bound
        Arrays.fill(dp, 1);
        Arrays.fill(counts, 1);
        // dp + 计数
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 满足递增条件
                if (nums[j] < nums[i]) {
                    // 转移方程：dp[i] = max{dp[j] + 1}, 满足j < i, nums[j] < nums[i]
                    // 1.dp[i] < dp[j] + 1，重置dp[i]、count[i]
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    // 2.dp[i] = dp[j] + 1，存在长度相同的LIS，count[i]累加
                    } else if (dp[i] == dp[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
        }
        // target
        int max = 1;
        int ans = 0;
        for (int length : dp) {
            max = Math.max(max, length);
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) ans += counts[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
