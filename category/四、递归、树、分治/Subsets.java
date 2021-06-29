package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [78]子集
 * @author luchao
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private List<List<Integer>> ans;
    private List<Integer> temp;

    /**
     * 特征：子集
     * 主体：选 or 不选，树形结构 => 递归
     * 细节：递归模版
     */
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        recur(0, nums);
        return ans;
    }

    // 递归方法
    private void recur(int level, int[] nums) {
        // 终止条件
        if (level == nums.length) {
            // make a copy，并非原temp
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 本层逻辑 - 不选。走下层递归
        recur(level + 1, nums);
        // 本层逻辑 - 选，temp.add(nums[level])。走下层递归
        temp.add(nums[level]);
        recur(level + 1, nums);
        // 回溯，还原现场（技巧：add/remove成对出现）
        temp.remove(temp.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}