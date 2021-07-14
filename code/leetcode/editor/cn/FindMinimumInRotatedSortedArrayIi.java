package leetcode.editor.cn;

/**
 * [154]寻找旋转排序数组中的最小值II
 * @author luchao
 */
public class FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：原数组有序、允许重复。
     * 主体：1.模板，找第一个 <= nums[right]；
     *      2.[4,4,4,4 | 0,1,4]，只有nums[mid] == nums[right]时，会影响模板的结果。处理该情况。
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // <、>使用模板
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // =，去掉right，即往左移一位
                right--;
            }
        }
        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
