package leetcode.editor.cn;

/**
 * [714]买卖股票的最佳时机含手续费
 * @author luchao
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：买卖股票问题，DP
     *
     * 思路：DP，股票Ⅱ + 手续费
     * 1.定义状态：dp[i][j], i - 第i天, j - 仓位（0：空仓; 1:持有）
     * 2.状态转移方程：
     *   不操作：dp[i][j] = dp[i - 1][j]
     *   dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
     *   dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
     * 3.边界：
     * 4.目标：dp[n][0]
     */
    public int maxProfit(int[] prices, int fee) {
        // move prices from [0 ~ n-1] to [1 ~ n]
        int n = prices.length;
        int[] copy = new int[n + 1];
        copy[0] = 0;
        for (int i = 1; i <= n; i++) copy[i] = prices[i - 1];
        // 边界
        int[][] dp = new int[n + 1][2];
        Arrays.fill(dp[0], -1000000000);
        dp[0][0] = 0;
        // DP
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + copy[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - copy[i] - fee);
        }
        // target
        return dp[n][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
