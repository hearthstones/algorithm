package leetcode.editor.cn;

/**
 * [123]买卖股票的最佳时机 III
 * @author luchao
 */
public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：买卖股票问题，DP
     *
     * 思路：DP
     * 1.定义状态：dp[i][j][k], i - 第i天, j - 仓位（0:空仓, 1:持有）, k - 交易次数
     * 2.状态转移方程：
     *   dp[i][0][k] = max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i])
     *   dp[i][1][k] = max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i])
     * 3.边界：dp[0][0][0] = 0, 不合法为负无穷
     * 4.目标：max(dp[n][0][k])
     */
    public int maxProfit(int[] prices) {
        // init
        int n = prices.length;
        int[] copy = new int[n + 1];
        copy[0] = 0;
        for (int i = 1; i <= n; i++) copy[i] = prices[i - 1];
        // 边界
        int[][][] dp = new int[n + 1][2][3];
        Arrays.fill(dp[0][0], -1000000000);
        Arrays.fill(dp[0][1], -1000000000);
        dp[0][0][0] = 0;
        // DP
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <=2; k++) {
                    if (k == 0) dp[i][j][k] = dp[i - 1][j][k];  // 交易0次
                    if (j == 0) dp[i][j][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + copy[i]);
                    if (j == 1 && k > 0) dp[i][j][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - copy[i]);
                }
            }
        }
        // target
        int ans = 0;
        for (int k = 0; k <= 2; k++) {
            ans = Math.max(ans, dp[n][0][k]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
