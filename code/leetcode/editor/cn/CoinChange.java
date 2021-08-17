package leetcode.editor.cn;

/**
 * [322]零钱兑换
 * @author luchao
 */
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：零钱兑换
     * 思路：DP
     * 1.状态：dp[i]，0 <= i <= amount，dp[i]表示凑成金额i所需的最少硬币个数
     * 2.状态转移方程：dp[i] = min(dp[i - coins[0]], ..., dp[i - conins[n]]) + 1
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
