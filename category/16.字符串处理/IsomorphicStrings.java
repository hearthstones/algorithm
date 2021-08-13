package leetcode.editor.cn;

import java.util.HashMap;

/**
 * [205]同构字符串
 * @author luchao
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：同构
     * 思路：映射 => 哈希表
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 遍历s、t
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sch = s.charAt(i);
            Character tch = t.charAt(i);
            if (map.containsKey(sch)) {
                if (!tch.equals(map.get(sch))) {
                    return false;
                }
            } else {
                if (map.containsValue(tch)) {
                    return false;
                }
                map.put(sch, tch);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
