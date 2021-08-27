package leetcode.editor.cn;

/**
 * [150]逆波兰表达式求值
 * @author luchao
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：1.逆波兰表达式，最近相关性 => 栈；2.整数除法只保留整数部分；3.表达式总是有效的。
     * 主体：1.遇见数字入栈；2.遇见运算符，取栈顶两个元素计算，结果入栈。
     * 细节：1.边界；2.int、Ingeter、String转换.
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        // 遍历
        for (String token : tokens) {
            // 遇见运算符，取栈顶两个元素计算，结果入栈。
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // 第一个元素在运算符右侧，第二个在左侧
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                int res = 0;
                if (token.equals("+")) res = left + right;
                if (token.equals("-")) res = left - right;
                if (token.equals("*")) res = left * right;
                if (token.equals("/")) res = left / right;
                stack.push(String.valueOf(res));
            } else { // 遇见数字入栈
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}