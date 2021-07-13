package leetcode.editor.cn;

/**
 * [69]x的平方根
 * @author luchao
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：平方根、只保留整数
     * 主体：找最后一个数，使得mid^2 <= x，二分模板
     * 细节：1.mid * mid 存在越界 => mid <= x / mid; 2.+1防止死循环.
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            // +1防止死循环
            int mid = (left + right + 1) >> 1;
            // mid * mid 存在越界 => mid <= x / mid
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
