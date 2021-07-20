package leetcode.editor.cn;

/**
 * [215]数组中的第K个最大元素
 * @author luchao
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：第k个最大的元素 => 第 (n - k)个最小的元素 => 排序后，nums[n - k]，设 target = n - k
     * 主体：快排 + 剪枝
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, nums.length - k, 0, nums.length - 1);
    }

    // 快排改造
    private int quickSort(int[] nums, int target, int l, int r) {
        // 终止
        if (l == r) {
            return nums[l];
        }
        // 基准点下标
        int pivot = partition(nums, l, r);
        // 剪枝：舍弃不满足条件的部分
        if (pivot >= target) {
            return quickSort(nums, target, l, pivot);
        } else {
            return quickSort(nums, target, pivot + 1, r);
        }
    }

    // 快排操作
    private int partition(int[] nums, int l, int r) {
        int pivot = l + (int)(Math.random() * (r - l + 1));
        int val = nums[pivot];
        while (l <= r) {
            while (nums[l] < val) l++;
            while (nums[r] > val) r--;
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
