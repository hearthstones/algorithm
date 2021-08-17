package leetcode.editor.cn;

/**
 * [63]不同路径 II
 * @author luchao
 */
public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：不同路径、有障碍物
     * 思路：DP，bottom-up
     * 1.定义状态：dp[i][j]，Start点到坐标点(i,j)有dp[i][j]条不同路径；
     * 2.状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，需要考虑各种情况。
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // init
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 障碍物
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                // 空位置
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
