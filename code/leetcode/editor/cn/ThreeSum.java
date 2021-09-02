package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [15]三数之和
 * @author luchao
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：排序 + 双指针
     * 重点：排序、去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // init
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        // 排序
        Arrays.sort(nums);
        // 遍历
        // 固定一端，求nums[i] + b + c = 0
        for (int i = 0; i < len - 2; i++) {
            // 排序后，第一个数 > 0, 三数之和一定 > 0
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 双指针
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 移动双指针
                    l++;
                    r--;
                    // 去重
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
