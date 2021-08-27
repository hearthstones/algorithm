package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [77]组合
 * @author luchao
 */
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private List<List<Integer>> ans;
    private List<Integer> per;
    private int n;
    private int k;

    /**
     * 特征：[1, ..., n] 中 所有可能的 k 个数的组合 => 特殊的子集
     * 主体：子集模板 + 组合特殊条件 (per.size() == k)
     * 细节：剪枝。per.size() == k => 剪枝条件
     */
    public List<List<Integer>> combine(int n, int k) {
        this.ans = new ArrayList<>();
        this.per = new ArrayList<>();
        this.n = n;
        this.k = k;
        recur(1);
        return ans;
    }

    /**
     * 递归方法
     *
     * @param level 层级，范围 [1, ..., n]
     */
    private void recur(int level) {
        // 剪枝：已选超过k个数 或 已选加上剩下的元素都不足k个数
        // 树形结构，不满足条件的分支不会继续下探
        if (per.size() > k || per.size() + n + 1 - level < k) {
            return;
        }
        // 终止条件
        if (level == n + 1) {
            // make a copy
            ans.add(new ArrayList<>(per));
            return;
        }
        // 本层逻辑 - 不选。下层递归。
        recur(level + 1);
        // 本层逻辑 - 选，加入per。下层递归。
        per.add(level);
        recur(level + 1);
        // 还原现场
        per.remove(per.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}