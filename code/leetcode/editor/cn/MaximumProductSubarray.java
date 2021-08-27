package leetcode.editor.cn;

/**
 * [152]乘积最大子数组
 * @author luchao
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：乘积最大子数组，联想最大子序和
     *
     * 思路：DP
     * 1.定义状态：maxDp[i]\minDp[i], 前i个元素构成的 以nums[i]结尾 的最大乘积\最小乘积
     * 2.转移方程：
     *   maxDp[i] = max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i], nums[i])
     *   minDp[i] = min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i], nums[i])
     * 3.边界：maxDp[0] = minDp[0] = nums[0]
     * 4.目标：max{maxDp[i]}
     *
     * 注意：maxDp[i] = max(maxDp[i - 1] * nums[i], nums[i]) 错误, nums[i]为负数时，max不能推导出max, 不满足最优子结构
     */
    public int maxProduct(int[] nums) {
        // init
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        // bound
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        // dp
        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);
            minDp[i] = Math.min(Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);
        }
        // target
        int ans = -1000000000;
        for (int max : maxDp) {
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
