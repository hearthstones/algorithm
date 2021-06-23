package leetcode.editor.cn;

/**
 * [155]最小栈
 * @author luchao
 */
public class MinStack {
    public static void main(String[] args) {
        Solution solution = new MinStack().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 特征：常数时间检索最小元素
     * 主体：两个栈，一个正常，一个维护最小元素
     * 细节：边界
     */
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(minStack.peek() <= val ? minStack.peek() : val);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}