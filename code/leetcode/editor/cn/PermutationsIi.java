package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [47]全排列 II
 * @author luchao
 */
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private List<List<Integer>> ans;
    private List<Integer> per;
    private int[] nums;
    private boolean[] used;

    /**
     * 特征：nums包含重复数字，要求返回所有不重复的全排列
     * 主体：全排列模板 + 去重
     * 细节：如何去重 ?
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.ans = new ArrayList<>();
        this.per = new ArrayList<>();
        this.nums = nums;
        // 排序，用于去重
        Arrays.sort(nums);
        this.used = new boolean[nums.length];
        recur(0);
        return ans;
    }

    /**
     * 递归方法
     * @param position 当前位置，范围 [0, ..., n - 1]
     */
    private void recur(int position) {
        // 终止条件
        if (position == nums.length) {
            ans.add(new ArrayList<>(per));  // make a copy
            return;
        }
        // 依次从“未被选择的数”中选一个，放到当前位置
        for (int i = 0; i < nums.length; i++) {
            // 去重含义：在当前位置，重复数字只会被填入一次
            // 重复：排序后，nums[i] 跟 nums[i - 1]重复 && nums[i - 1]被填入过
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                continue;
            }
            used[i] = true;
            per.add(nums[i]);
            recur(position + 1);
            per.remove(per.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
