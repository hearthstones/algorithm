package leetcode.editor.cn;

/**
 * [50]Pow(x, n)
 * @author luchao
 */
public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：快速幂
     * @see <link>https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/</>
     */
    public double myPow(double x, long n) {
        if (n == 0L) {
            return 1;
        }
        if (n < 0L) {
            return 1 / myPow(x, -n);
        }
        // 快速幂
        double ans = 1.0;
        while (n > 0L) {
            // 判断最右一位是否为1
            if ((n & 1) == 1) ans = ans * x;
            // n右移一位（可理解为删除最后一位）
            n = n >> 1;
            // 从右遍历二进制位时，上一位x = x * x
            x = x * x;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
