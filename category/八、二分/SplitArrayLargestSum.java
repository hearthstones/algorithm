package leetcode.editor.cn;

/**
 * [410]分割数组的最大值
 * @author luchao
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：最小化 "m个子数组各自和的最大值"
     * 主体：二分答案，最优性问题转化为判定问题 => 给定一个数T，"m个子数组各自和的最大值 <= T" 是否合法
     */
    public int splitArray(int[] nums, int m) {
        // 下界，每个元素为一组，则 left = nums中最大元素
        int left = Integer.MIN_VALUE;
        // 上界，所有元素为一组，则 right = nums元素和
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        // 二分
        while (left < right) {
            int mid = (left + right) >> 1;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 判定：给定一个数T，"<= m 个子数组各自和的最大值 <= T" 是否合法
     *
     * <p>
     * 设：nums=[7,2,5,10,8], m=2, t=20
     * 得：子数组 [7,2,5][10,8], groupCount=2
     * </p>
     */
    private boolean isValid(int[] nums, int m, int t) {
        int groupSum = 0;
        int groupCount = 1;
        for (int i = 0; i < nums.length; i++) {
            // 不超，放进当前子数组
            if (groupSum + nums[i] <= t) {
                groupSum += nums[i];
            // 超了，开启下一个子数组
            } else {
                groupCount++;
                groupSum = nums[i];
            }
        }
        // 此处是groupCount <= m，而非groupCount == m
        return groupCount <= m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
