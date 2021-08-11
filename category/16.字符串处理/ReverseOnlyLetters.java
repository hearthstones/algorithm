package leetcode.editor.cn;

/**
 * [917]仅仅反转字母
 * @author luchao
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：双指针
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isLetter(chars[left])) {
                left++;
            } else if (!isLetter(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        Character.isLetter()
        return String.valueOf(chars);
    }

    // 判断是否为字母
    private boolean isLetter(char ch) {
        return (65 <= ch && ch <= 90) || (97 <= ch && ch <= 122);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
