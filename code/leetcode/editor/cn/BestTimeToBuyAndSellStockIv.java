package leetcode.editor.cn;

/**
 * [188]买卖股票的最佳时机 IV
 * @author luchao
 */
public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：买卖股票问题，DP
     *
     * 思路：DP
     * 1.定义状态：dp[i][j][c], i - 第i天, j - 仓位(0:空仓, 1:持有), c - 交易次数（买卖算一次）
     * 2.状态转移方程：
     *   dp[i][0][c] = max(dp[i - 1][0][c], dp[i - 1][1][c] + prices[i])
     *   dp[i][1][c] = max(dp[i - 1][1][c], dp[i - 1][0][c - 1] - prices[i])
     * 3.边界：dp[0][0][0] = 0, 不合法为负无穷
     * 4.目标：max(dp[n][0][c]), 0 <= c <= k
     */
    public int maxProfit(int k, int[] prices) {
        // move prices from [0, ..., n - 1] to [1, ..., n]
        int n = prices.length;
        int[] copy = new int[n + 1];
        copy[0] = 0;
        for (int i = 1; i < n + 1; i++) copy[i] = prices[i - 1];
        // 边界
        int[][][] dp = new int[n + 1][2][k + 1];
        Arrays.fill(dp[0][0], -1000000000);
        Arrays.fill(dp[0][1], -1000000000);
        dp[0][0][0] = 0;
        // DP
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int c = 0; c <= k; c++) {
                    // dp[i][j][c] = dp[i - 1][j][c];
                    if (c == 0) dp[i][j][c] = dp[i - 1][j][c];
                    if (j == 0) dp[i][j][c] = Math.max(dp[i - 1][0][c], dp[i - 1][1][c] + copy[i]);
                    if (j == 1 && c > 0) dp[i][j][c] = Math.max(dp[i - 1][1][c], dp[i - 1][0][c - 1] - copy[i]);
                }
            }
        }
        // target
        int ans = 0;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[n][0][c]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
