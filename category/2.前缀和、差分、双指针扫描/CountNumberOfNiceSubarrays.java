package leetcode.editor.cn;

/**
 * [1248]统计「优美子数组」
 * @author luchao
 */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfNiceSubarrays().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：连续子数组恰好有k个奇数数字 => %2, 连续子数组和为k => 求区间和：前缀和
     */
    public int numberOfSubarrays(int[] nums, int k) {
        // init
        int len = nums.length;
        // 前缀和数组
        int[] sum = new int[len + 1];
        // sum[0] = 0;
        // 计数数组
        int[] count = new int[len + 1];
        count[sum[0]]++;
        // 前缀和 & 计数
        for (int i = 1; i < len + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] % 2;
            count[sum[i]]++;
        }
        // 连续子数组和为k => 前缀和数组s[i] - s[j] = k => 固定i端，求满足s[j] = s[i] - k的数目
        int ans = 0;
        for (int i = 0; i < len + 1; i++) {
            if (sum[i] - k >= 0) {
                ans += count[sum[i] - k];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
