package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [438]找到字符串中所有字母异位词
 * @author luchao
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：异位词、子串
     * 思路：滑动窗口 + 数组
     */
    public List<Integer> findAnagrams(String s, String p) {
        // init
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return ans;
        }
        char[] need = new char[26];
        char[] window = new char[26];
        // 初始化need、窗口数组
        for (int i = 0; i < n; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        // 滑动窗口，长度为n
        int start = 0;
        int end = n - 1;
        while (end < m) {
            if (Arrays.equals(need, window)) {
                ans.add(start);
            }
            // 滑动，去头加尾
            window[s.charAt(start) - 'a']--;
            start++;
            end++;
            if (end < m) {
                window[s.charAt(end) - 'a']++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
