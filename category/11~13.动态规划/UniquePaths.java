package leetcode.editor.cn;

/**
 * [62]不同路径
 * @author luchao
 */
public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP - 路径问题
    public int uniquePaths(int m, int n) {
        // 定义状态：dp[i][j], Start到坐标(i,j)的不同路径
        int[][] dp = new int[m][n];
        // DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[0][0] = 1;
                else if (i != 0 && j != 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        // target
        return dp[m - 1][n -1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
