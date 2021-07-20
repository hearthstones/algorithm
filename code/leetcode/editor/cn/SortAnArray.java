package leetcode.editor.cn;

/**
 * [912]排序数组
 * @author luchao
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 快排
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot);
        quickSort(nums, pivot + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        // 随机选取基准
        int pivot = l + (int)(Math.random() * (r - l + 1));
        int value = nums[pivot];
        // 排序
        while (l <= r) {
            while (nums[l] < value) l++;
            while (nums[r] > value) r--;
            if (l <= r) {
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = temp;
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
