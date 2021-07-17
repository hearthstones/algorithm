package leetcode.editor.cn;

/**
 * [162]寻找峰值
 * @author luchao
 */
public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：峰值、多个返回任一个、nums[i] != nums[i + 1]
     * 主体：峰值问题 => 三分查找
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int lmid = (left + right) >> 1;
            int rmid = lmid + 1;
            // 1.nums[lmid] <= nums[rmid]，在lmid处单调递增，极值在[rmid, right]上
            // 2.nums[lmid] > nums[rmid]，在rmid处单调递减，极值在[left, lmid]上
            if (nums[lmid] <= nums[rmid]) {
                left = rmid;
            } else {
                right = lmid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
