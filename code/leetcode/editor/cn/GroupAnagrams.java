package leetcode.editor.cn;

import java.util.*;

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
     * 特征：字母异位词、分组
     * 主体：遍历数组，构造 HashMap<String, List<String>>: key - 排序后的词，value - 异位词group
     * 细节：当前时间复杂度 —— 循环中排序，O(nklogk)。
     *      如何降低时间复杂度？遍历n无法去掉，只能从排序(klogk)入手 => 26字母计数
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // key - 排序后的词，value - 异位词group
        Map<String, List<String>> map = new HashMap<>();
        // 遍历
        for (String str : strs) {
            // 排序
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedKey = String.valueOf(arr);
            // 构造map
            List<String> group = map.getOrDefault(sortedKey, new ArrayList<>());
            group.add(str);
            map.put(sortedKey, group);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
