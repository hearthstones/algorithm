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
     * 思路：贪心。今天比昨天的价格高就交易。
     * 注意：贪心只能计算最大利润，而非实际的交易过程
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
