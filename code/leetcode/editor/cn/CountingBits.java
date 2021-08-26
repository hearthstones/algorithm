package leetcode.editor.cn;

/**
 * [338]比特位计数
 * @author luchao
 */
public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP + 位运算
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
