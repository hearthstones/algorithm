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
     * 特征：Pow(x, n)，可分解
     * 主体：分治。子问题：1.n为偶数，Pow(x, n) = Pow(x, n/2) * Pow(x, n/2); 2.n为奇数，Pow(x, n) = Pow(x, n/2) * Pow(x, n/2) * x.
     * 细节：1.x、n可以为负数 => n < 0时, Pow(x, n) = 1 / Pow(x, -n)
     *      2.int范围[-2147483648, 2147483647]，-(-2147483648)会超出INT_MAX，n改为long。
     */
    public double myPow(double x, long n) {
        // 终止条件
        if (n == 0) {
            return 1;
        }
        // n为负数，转化
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        // 子问题：
        // 1.n为偶数，Pow(x, n) = Pow(x, n/2) * Pow(x, n/2);
        // 2.n为奇数，Pow(x, n) = Pow(x, n/2) * Pow(x, n/2) * x.
        double temp = myPow(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
