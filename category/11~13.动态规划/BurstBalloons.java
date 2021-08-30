package leetcode.editor.cn;

/**
 * [312]戳气球
 * @author luchao
 */
public class BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 这题是真不会！
     *
     * 特征：区间DP
     *
     * 思路：区间DP
     * 1.定义状态：dp[l][r], 戳破闭区间[l, r]之间所有气球，所获的最大硬币数量
     * 2.转移方程：
     *   最后戳破p, dp[l][r] = max{dp[l][p - 1] + dp[p + 1][r] + nums[l - 1] * nums[p] * nums[r + 1]}, l <= p <= r
     * 3.边界：当l > r时, dp[l][r] = 0
     * 4.目标：dp[1][n]
     */
    public int maxCoins(int[] nums) {
        // init
        // [0, n - 1] -> [0, n + 1]
        int n = nums.length;
        int[] copy = new int[n + 2];
        copy[0] = 1;
        copy[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            copy[i] = nums[i - 1];
        }
        // bound
        int[][] dp = new int[n + 2][n + 2];
        // dp
        // 区间长度作为"阶段"
        // 0 [1, ..., n] n+1
        for (int len = 1; len <= n; len++) {
            // 区间端点作为"状态"
            for (int l = 1; l <= n - len + 1; l++) {
                // 闭区间[l, r], r - l + 1 = len => r = l + len - 1
                int r = l + len - 1;
                for (int p = l; p <= r; p++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][p - 1] + dp[p + 1][r] + copy[l - 1] * copy[p] * copy[r + 1]);
                }
            }
        }
        return dp[1][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
