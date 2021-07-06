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
    private List<List<Integer>> ans;
    private List<Integer> per;
    private int[] nums;

    /**
     * DFS遍历整个状态空间
     * 分支 - 选 or 不选。
     * 状态空间 - 每个节点两个分支，该节点到子节点的变化过程。
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.ans = new ArrayList<>();
        this.per = new ArrayList<>();
        this.nums = nums;
        dfs(0);
        return ans;
    }

    // dfs
    private void dfs(int depth) {
        // 终止条件
        if (depth == nums.length) {
            // make a copy
            ans.add(new ArrayList<>(per));
            return;
        }
        // 状态空间
        dfs(depth + 1);
        per.add(nums[depth]);
        dfs(depth + 1);
        // 回溯
        per.remove(per.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
