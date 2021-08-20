package leetcode.editor.cn;

/**
 * [213]打家劫舍 II
 * @author luchao
 */
public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：打家劫舍，环形DP（滚动型DP）
     *
     * 思路：环形DP => 断链，两次DP
     * 1.定义状态：dp[i][j], i - 第i间, j - 偷 or 不偷（0:不偷, 1:偷）
     * 2.状态转移方程：
     *   dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
     *   dp[i][1] = dp[i - 1][0] + nums[i]
     * 3.边界
     *   3.1 不偷1,可偷n：dp[1][0] = 0, dp[1][1] = -1000000000
     *   3.2 可偷1,不偷n：dp[1][0] = 0, dp[1][1] = nums[0]
     * 4.目标
     *   4.1 不偷1,可偷n：max(dp[n][0], dp[n][1])
     *   4.2 可偷1,不偷n：dp[n][0]
     *   取二者大值
     */
    public int rob(int[] nums) {
        // init
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] copy = new int[n + 1];
        copy[0] = 0;
        for (int i = 1; i <= n; i++) {
            copy[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 1][2];
        // 不偷1，可偷n
        // DP i从2开始，用不到dp[0]
        dp[1][0] = 0;
        dp[1][1] = -1000000000;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + copy[i];
        }
        int ans = Math.max(dp[n][0], dp[n][1]);
        // 可偷1,不偷n
        dp[1][0] = 0;
        dp[1][1] = copy[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + copy[i];
        }
        return Math.max(ans, dp[n][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
