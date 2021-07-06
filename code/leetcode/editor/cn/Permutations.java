package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [46]全排列
 * @author luchao
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private List<List<Integer>> ans;
    private List<Integer> per;
    private int[] nums;
    private boolean[] used;

    /**
     * 特征：全排列
     * 方案：每次从"未选过的数"中选一个，放到当前位置
     * 实现：DFS
     */
    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        this.per = new ArrayList<>();
        this.nums = nums;
        this.used = new boolean[nums.length];
        dfs(0);
        return ans;
    }

    // dfs
    private void dfs(int depth) {
        // 终止条件
        if (depth == nums.length) {
            ans.add(new ArrayList<>(per));
            return;
        }
        // 状态空间
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            per.add(nums[i]);
            dfs(depth + 1);
            // 回溯
            per.remove(per.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
