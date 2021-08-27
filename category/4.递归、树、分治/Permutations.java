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
     * 主体：递归。本层逻辑 - 每次从未选过的数中选择一个放到当前位置
     * 细节：位置、回溯
     */
    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        this.per = new ArrayList<>();
        this.nums = nums;
        this.used = new boolean[nums.length];
        recur(0);
        return ans;
    }

    /**
     * 递归方法
     * @param position 当前位置，范围[0, ..., nums.length - 1]
     */
    private void recur(int position) {
        // 终止条件
        if (position == nums.length) {
            ans.add(new ArrayList<>(per));  //make a copy
            return;
        }
        // 依次，从"未被选过的数"中选择一个，放在当前位置
        for (int i = 0; i < nums.length; i++) {
            // 被选过
            if (used[i]) {
                continue;
            }
            // 选择nums[i]
            used[i] = true;
            per.add(nums[i]);
            // 下层递归
            recur(position + 1);
            // 回溯，还原现场
            per.remove(per.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}