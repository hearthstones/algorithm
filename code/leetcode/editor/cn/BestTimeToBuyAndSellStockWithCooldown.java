package leetcode.editor.cn;

/**
 * [309]最佳买卖股票时机含冷冻期
 * @author luchao
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：买卖股票问题，DP
     *
     * 思路：DP
     * 1.定义状态：dp[i][j][l], i - 第i天, j - 仓位（0:空仓, 1:持有）, l - 是否在冷冻期（0:不在, 1:在）
     * 2.状态转移方程：
     *   dp[i][0][0] = max(dp[i - 1][0][0], dp[i - 1][0][1])
     *   dp[i][0][1] = dp[i - 1][1][0] + prices[i]
     *   dp[i][1][0] = max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i])
     *   dp[i][1][1] 不合法
     * 3.边界：dp[0][0][0] = 0, 其余为负无穷
     * 4.目标：max(dp[n][0][0], dp[n][0][1])
     */
    public int maxProfit(int[] prices) {
        // init
        int n = prices.length;
        int[] copy = new int[n + 1];
        copy[0] = 0;
        for (int i = 1; i <= n; i++) copy[i] = prices[i - 1];
        // 边界
        int[][][] dp = new int[n + 1][2][2];
        Arrays.fill(dp[0][0], -1000000000);
        Arrays.fill(dp[0][1], -1000000000);
        dp[0][0][0] = 0;
        // DP
        for (int i = 1; i <= n; i++) {
            // 持有且在冷冻期，不合法
            dp[i][1][1] = -1000000000;
            // 持有且不在冷冻期
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - copy[i]);
            // 空仓且在冷冻期，只有前一天持有且在今天卖出的情况
            dp[i][0][1] = dp[i - 1][1][0] + copy[i];
            // 空仓且不在冷冻期，前一天不能有任何操作
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
        }
        // target
        return Math.max(dp[n][0][0], dp[n][0][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
