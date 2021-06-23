package leetcode.editor.cn;

import java.util.HashMap;

/**
 * [1]两数之和
 * @author luchao
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 固定一端
            int first = target - nums[i];
            if (i == 0 || !map.containsKey(first)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(first), i};
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}