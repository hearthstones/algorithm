package leetcode.editor.cn;

/**
 * [151]翻转字符串里的单词
 * @author luchao
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] array = s.trim().split("\\s+");
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            String temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
        return String.join(" ", array);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
