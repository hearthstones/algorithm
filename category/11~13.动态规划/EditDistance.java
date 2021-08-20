package leetcode.editor.cn;

/**
 * [72]编辑距离
 * @author luchao
 */
public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：字符串DP
     *
     * 思路：DP
     * 1.定义状态：dp[i][j], i - word1[1, i], j - word2[1, j]
     * 2.状态转移方程：
     *   插入 - dp[i][j - 1] + 1, ab -> abc
     *   删除 - dp[i - 1][j] + 1, abc -> ab
     *   替换 - dp[i - 1][j - 1] + 1, abc -> abd
     *   不变 - dp[i - 1][j - 1], abc -> abc
     *   dp[i][j] = min(dp[i][j - 1] + 1, dp[i - 1][j] + 1, dp[i - 1][j - 1] + eq)
     * 3.边界：
     *   dp[i][0] = i, abc -> [], 删除i次
     *   dp[0][j] = j, [] -> abc, 插入j次
     * 4.目标：dp[m][n]
     */
    public int minDistance(String word1, String word2) {
        // init
        int m = word1.length();
        int n = word2.length();
        word1 = " " + word1;
        word2 = " " + word2;
        int[][] dp = new int[m + 1][n + 1];
        // 边界
        // abc -> [], 删除i次
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // [] -> abc, 插入j次
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 插入, ab -> abc
                int insert = dp[i][j - 1] + 1;
                // 删除, abc -> ab
                int delete = dp[i - 1][j] + 1;
                // 不变：abc -> abc，替换：abc -> abd
                int replace = dp[i - 1][j - 1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                dp[i][j] = Math.min(Math.min(insert, delete), replace);
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
