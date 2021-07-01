package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [811]子域名访问计数
 * @author luchao
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {
        Solution solution = new SubdomainVisitCount().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 主体：多级域名 + 哈希表计数
     * 细节：正则
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        // key - 域名，value - 计数
        HashMap<String, Integer> map = new HashMap<>();
        // 遍历
        for (String domain : cpdomains) {
            String[] arr = domain.split("\\s+");
            Integer count = Integer.valueOf(arr[0]);
            String[] frags = arr[1].split("\\.");
            // 多级域名计数
            String level = "";
            for (int i = frags.length - 1; i >= 0; i--) {
                level = frags[i] + (i == frags.length - 1 ? "" : ".") + level;
                map.put(level, map.getOrDefault(level, 0) + count);
            }
        }
        // 构造ans
        List<String> ans = new ArrayList<>();
        map.forEach((key, value) -> ans.add(value + " " + key));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}