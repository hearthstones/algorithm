package leetcode.editor.cn;

/**
 * [231]2的幂
 * @author luchao
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        // n是2的幂 => n>0 且 n的二进制表示中仅包含1个1
        // 清零最低位的1：n = n & (n - 1)
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
