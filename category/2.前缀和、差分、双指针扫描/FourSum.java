package leetcode.editor.cn;

/**
 * [18]四数之和
 * @author luchao
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：四元组不重复
     * 思路：排序 + 固定端点 + 双指针 + 去重
     * 注意：1.去重；2.细节太多；3.可以优化，剪枝
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // init
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        // 排序
        Arrays.sort(nums);
        // 遍历
        // 固定端点a
        for (int a = 0; a < len - 3; a++) {
            // a去重
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            // 固定端点b
            for (int b = a + 1; b < len - 2; b++) {
                // b去重
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                // 双指针，求c、d
                int l = b + 1;
                int r = len - 1;
                int temp = target - nums[a] - nums[b];
                while (l < r) {
                    if (nums[l] + nums[r] == temp) {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[l], nums[r]));
                        l++;
                        r--;
                        // cd去重
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (nums[l] + nums[r] < temp) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
