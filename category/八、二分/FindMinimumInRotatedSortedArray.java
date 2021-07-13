package leetcode.editor.cn;

/**
 * [153]寻找旋转排序数组中的最小值
 * @author luchao
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：原升序，后旋转。两段升序 [3,4,5 | 1,2]，第一段均 > nums[right]，第二段均 <= nums[right]
     * 主体：找第一个 <= nums[right]，二分模板
     * 细节：不存在不合法的情况，所以范围[0, ..., n - 1]
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
