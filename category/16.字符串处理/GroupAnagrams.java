package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [49]字母异位词分组
 * @author luchao
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：字母异位词组
     * 思路：排序 + 哈希
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // key - 排序后的词，value - 异位词group
        HashMap<String, List<String>> map = new HashMap<>();
        // 遍历
        for (String str : strs) {
            // 排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);
            // 分组
            List<String> group = map.getOrDefault(sortedKey, new ArrayList<>());
            group.add(str);
            map.put(sortedKey, group);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
