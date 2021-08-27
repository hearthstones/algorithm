package leetcode.editor.cn;

/**
 * [283]移动零
 * @author luchao
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：原地操作、保持非零元素相对顺序
     * 主体：遍历，双指针，保留非零（不存在覆盖）
     * 细节：边界、补零
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        // 遍历，保留非零
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        // 补零
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}