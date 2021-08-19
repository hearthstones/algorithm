package leetcode.editor.cn;

/**
 * [121]买卖股票的最佳时机
 * @author luchao
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：买卖股票问题，一次
     * 思路：找最大差值
     */
    public int maxProfit(int[] prices) {
        // 历史最低价格 - 前i天的最低价格
        int minPrice = Integer.MAX_VALUE;
        // 最大差值
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
