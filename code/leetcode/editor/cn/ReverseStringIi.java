package leetcode.editor.cn;

/**
 * [541]反转字符串 II
 * @author luchao
 */
public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：按块翻转
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        // 每个块开始于2k的倍数：0、2k、4k...
        for (int start = 0; start < s.length(); start += 2 * k) {
            // 翻转，范围[left, right]
            int left = start;
            // 1.每个块 >= k时（每个2k块 及 剩余数>=k 两种情况），right = left + k - 1
            // 2.块 < k时（只有剩余不足k的情况），right = s.length() - 1
            int right = Math.min(left + k - 1, s.length() - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
