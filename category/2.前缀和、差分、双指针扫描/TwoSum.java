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
    /**
     * 特征：返回数组下标、假设只有一个答案、答案中不能出现同一个元素
     * 主体：nums[i] + nums[j] = target => nums[j] = target - nums[i]
     *      遍历，每次固定右端(i)，是否存在左端j满足 nums[j] = target - nums[i]
     * 细节：0 < j < i，否则会重复计算 => 一边遍历，一边比较
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        // 一边遍历，一边比较及插入map，则每次判断时，j(target - nums[i])都是当前i之前的元素
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}