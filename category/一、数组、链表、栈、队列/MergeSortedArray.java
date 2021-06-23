package leetcode.editor.cn;

/**
 * [88]合并两个有序数组
 * @author luchao
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：有序、假设nums1空间为 m + n
     * 主体：遍历。ij双指针，谁小放谁 + 正放会覆盖 => ij双指针，谁大放谁（倒放）
     * 细节：边界
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        // 遍历
        for (int k = m + n - 1; k >= 0; k--) {
            // 谁大放谁，并移动指针。注意边界。
            nums1[k] = j < 0 || (i >= 0 && nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}