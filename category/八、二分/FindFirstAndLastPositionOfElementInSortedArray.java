package leetcode.editor.cn;

/**
 * [34]在排序数组中查找元素的第一个和最后一个位置
 * @author luchao
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：升序、有重复、开始位置 和 结束位置
     * 主体：1.开始位置：找第一个 >= target; 2.结束位置：找最后一个 <= target.
     * 细节：模板边界
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        // 开始位置：找第一个 >= target
        // 范围：[0, ..., n - 1] + [n不合法]
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans[0] = right;
        // 结束位置：找最后一个 <= target
        // 范围：[-1不合法] + [0, ..., n - 1]
        left = -1;
        right = nums.length - 1;
        while (left < right) {
            // +1防止死循环
            int mid = (left + right + 1) >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = left;
        // ans[0] > ans[1] 不存在目标值
        return ans[0] > ans[1] ? new int[]{-1, -1} : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
