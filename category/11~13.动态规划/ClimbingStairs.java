package leetcode.editor.cn;

/**
 * [70]爬楼梯
 * @author luchao
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：爬楼梯，递归 或 DP
     * 思路：DP
     * 1.定义状态：dp[i], 0 <= i <= n, 从0阶到第i阶有dp[i]种方法
     * 2.状态转移方程：dp[i] = dp[i - 1] + dp[i - 2]
     * 3.边界：dp[0] = 0, dp[1] = 1, dp[2] = 2
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        // 边界
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // DP
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 目标
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
