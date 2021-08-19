package leetcode.editor.cn;

/**
 * [122]买卖股票的最佳时机 II
 * @author luchao
 */
public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：买卖股票系列问题，DP
     *
     * 思路：通解DP
     * 1.定义状态：dp[i][0]表示第i天结束时没有股票的最大利润，dp[i][1]表示第i天结束时持有股票的最大利润。
     * 2.状态转移方程：
     *  dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
     *  dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
     * 3.边界：dp[0][0] = 0, dp[0][1] = - prices[0]
     * 4.目标：最后一天不持有 - dp[length - 1][0]
     *
     * 优化：贪心
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 边界
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        // DP
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 目标，最后一天不持有
        return dp[length - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
