package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [697]数组的度
 * @author luchao
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：最短连续子数组的度 = nums的度 => 假设 元素x的频数 = nums的度，则 sub = [x, ..., x]，且sub中x个数 = 度
     * 主体：HashMap计数，key - 重复的元素, value - [count, start, end]
     * 细节：Integer int
     */
    public int findShortestSubArray(int[] nums) {
        // key - 重复的元素, value - [count, start, end]
        Map<Integer, Integer[]> map = new HashMap<>();
        // 遍历计数
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{1, i, i});
            } else {
                Integer[] arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
                map.put(nums[i], arr);
            }
        }
        // 找出 符合度的最短连续子数组 的长度
        int maxCount = 0;
        int minLength = Integer.MAX_VALUE;
        for (Integer[] arr : map.values()) {
            if (arr[0] > maxCount) {
                maxCount = arr[0];
                minLength = arr[2] - arr[1] + 1;
            }
            if (arr[0] == maxCount) {
                minLength = Math.min(arr[2] - arr[1] + 1, minLength);
            }
        }

        return minLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
