package leetcode.editor.cn;

/**
 * [740]删除并获得点数
 * @author luchao
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：删除并获得3, 2、4都不能获得，3重复获取
     *
     * 思路：建模 + 打家劫舍
     * 1.建模：删除并获得nums[i], 则不能获取nums[i]-1 和 nums[i]+1 => 类比&换元，打家劫舍偷第i间，则不能偷第i-1, i+1间
     * 2.sums[nums[i]] + 打家劫舍模板
     */
    public int deleteAndEarn(int[] nums) {
        // 建模
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] sums = new int[maxVal + 1];
        for (int num : nums) {
            sums[num] += num;
        }
        // 打家劫舍
        int[][] dp = new int[maxVal + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -1000000000;
        for (int i = 1; i <= maxVal; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + sums[i];
        }
        return Math.max(dp[maxVal][0], dp[maxVal][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
