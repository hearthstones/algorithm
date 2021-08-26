package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * [120]三角形最小路径和
 * @author luchao
 */
public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：DP路径问题
     *
     * 思路：DP
     * 1.定义状态：dp[i][j], i - 层数, j - 当前行下标
     * 2.状态转移方程：
     *   j == 0, dp[i][j] = dp[i - 1][j] + triangle[i][j]
     *   j != 0, dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
     * 3.边界：dp[0][0] = triangle[0][0], 不合法为正无穷
     * 4.目标：min(dp[m - 1][0], ..., dp[m - 1][n - 1])
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // init
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // 边界
        Arrays.fill(dp[0], 1000000000);
        dp[0][0] = triangle.get(0).get(0);
        // DP
        for (int i = 1; i < n; i++) {
            // 每层第一个只能由上层第一个过来
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < n; j++) {
                if (j <= i) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                else dp[i][j] = 1000000000;  // 不合法
            }
        }
        // target
        int ans = 1000000000;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
