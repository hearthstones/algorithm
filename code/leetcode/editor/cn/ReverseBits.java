package leetcode.editor.cn;

/**
 * [190]颠倒二进制位
 * @author luchao
 */
public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 有疑问
            ans = (ans << 1) | ((n >> i) & 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
