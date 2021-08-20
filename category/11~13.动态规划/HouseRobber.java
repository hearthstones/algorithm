package leetcode.editor.cn;

/**
 * [198]打家劫舍
 * @author luchao
 */
public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：打家劫舍，DP
     * 思路：
     * 1.定义状态：dp[i][j], i - 第i间房, j - 偷 or 不偷（0:不偷, 1:偷）
     * 2.状态转移方程：
     *   dp[i][0] = max(dp[i - 1][1], dp[i - 1][0])
     *   dp[i][1] = dp[i - 1][0] + nums[i]
     * 3.边界：dp[0][0] = 0, 不合法为负无穷
     * 4.目标：max(dp[n][0], dp[n][1])
     */
    public int rob(int[] nums) {
        // init
        int n = nums.length;
        int[] copy = new int[n + 1];
        copy[0] = 0;
        for (int i = 1; i <= n; i++) {
            copy[i] = nums[i - 1];
        }
        // 边界
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -1000000000;
        // DP
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + copy[i];
        }
        // target
        return Math.max(dp[n][0], dp[n][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
