package leetcode.editor.cn;

/**
 * [1122]数组的相对排序
 * @author luchao
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：相对顺序、arr2[i]各不相同
     * 主体：计数排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int curr = 0;
        // arr1计数
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }
        // 根据arr2相对顺序排序
        for (int num : arr2) {
            while (count[num] > 0) {
                count[num]--;
                ans[curr++] = num;
            }
        }
        // 剩余元素升序放在末尾
        for (int i = 0; i < 1001; i++) {
            while (count[i] > 0) {
                count[i]--;
                ans[curr++] = i;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
