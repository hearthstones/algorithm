package leetcode.editor.cn;

/**
 * [191]位1的个数
 * @author luchao
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        // 遍历
        for (int i = 0; i < 32; i++) {
            // 得到n在二进制下的第i位：(n >> i) & 1
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
