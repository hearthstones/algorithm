package leetcode.editor.cn;

/**
 * [26]删除有序数组中的重复项
 * @author luchao
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征: 有序、原地删除、不考虑超出新长度后面的元素
     * 主体：遍历。双指针，不重复则保留（跟上一个元素比较即可）
     * 细节：边界，第一个必然会保留
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}