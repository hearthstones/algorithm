package leetcode.editor.cn;

import java.util.HashMap;

/**
 * [560]和为K的子数组
 * @author luchao
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：连续的子数组
     * 主体：1.区间和 => 前缀和；2.求个数 => 前缀和计数模版。
     * TODO: 灵活使用模版, 分清场景, 此题可去掉sums[], 先保留两天提醒自己
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 推导: nums(l, r) = s[r] - s[l - 1] = k => s[i] - s[j] = k
        // 前缀和 及 计数
        int[] sums = new int[len + 1];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        sums[0] = 0;
        countMap.put(0, 1);
        int ans = 0;
        for(int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            // s[i] - s[j] = k => s[j] = s[i] - k => 固定右端，求 s[i] - k 的数量
            // 含义: 在当前数(下标i)之前，有多少个前缀和等于s[i] - k
            if (countMap.containsKey(sums[i] - k)) {
                ans += countMap.get(sums[i] - k);
            }
            countMap.put(sums[i], countMap.getOrDefault(sums[i], 0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}