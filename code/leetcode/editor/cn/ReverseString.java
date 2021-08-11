package leetcode.editor.cn;

/**
 * [344]反转字符串
 * @author luchao
 */
public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：反转字符串，双指针
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
