package leetcode.editor.cn;

/**
 * [167]两数之和 II - 输入有序数组
 * @author luchao
 */
public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：升序、返回两个下标
     * 主体：双指针遍历，向中间靠拢
     * 细节：边界、numbers的下标从1开始计数
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        // 双指针遍历
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}