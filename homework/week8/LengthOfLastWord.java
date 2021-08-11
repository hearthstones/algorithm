package leetcode.editor.cn;

/**
 * [58]最后一个单词的长度
 * @author luchao
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 方法一：split
//        String[] words = s.split("\\s");
//        return words[words.length - 1].length();

        // 方法二：遍历，从后往前
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                else break;
            }
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
