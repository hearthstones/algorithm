package leetcode.editor.cn;

/**
 * [1143]最长公共子序列
 * @author luchao
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：最长公共子序列（LCS），典型DP问题
     * 思路：DP
     * 1.定义状态：dp[i][j] 表示 text1[0, i - 1] 与 text2[0, j - 1] 的LCS长度
     * 2.状态转移方程
     * 2.1 text1[i - 1] = text2[j - 1]时，dp[i][j] = dp[i - 1][j - 1] + 1
     * 2.2 text1[i - 1] != text2[j - 1]时，dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
     * 3.边界：dp[0][j] = 0, dp[i][0] = 0
     * 4.目标：dp[m][n]
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 边界（数组元素默认为0）：dp[0][j] = 0, dp[i][0] = 0。
        // DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 目标
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
