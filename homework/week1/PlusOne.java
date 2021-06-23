package leetcode.editor.cn;

import java.util.Arrays;

/**
 * [66]加一
 * @author luchao
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = new int[]{9, 2, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 特征：非负整数
 * 主体：从后往前遍历。{等于9，进位} else {不等于9，加一，停止（返回）}
 * 细节：边界，全为9
 */
class Solution {
    public int[] plusOne(int[] digits) {
        // 遍历
        for(int i = digits.length -  1; i >= 0; i--) {
            // 等于9，进位
            if (digits[i] == 9) {
                digits[i] = 0;
            // 不等于9，加一，返回
            } else {
                digits[i]++;
                return digits;
            }
        }
        // 全等于9，经过遍历后，全为0 => 扩容，首位为1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}