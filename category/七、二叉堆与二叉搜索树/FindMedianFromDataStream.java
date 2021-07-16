package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * [295]数据流的中位数
 * @author luchao
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        Solution solution = new FindMedianFromDataStream().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 特征：中位数是有序列表中间的数。1.size=奇数，中间的数；2.size=偶数，中间两个数的平均值.
 * 主体：中位数 => 对顶堆
 * 细节：维护大小堆的平衡
 */
class MedianFinder {
    // 大根堆维护小的一半元素，小根堆维护大的一半元素
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    /**
     * 插入，注意维护大小堆的平衡
     * @param num num
     */
    public void addNum(int num) {
        // init 第一个元素
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        // 初步划分
        if (num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        // 维护大小堆的平衡，调整该元素
        // 总size为奇数时，maxHeap.size() = minHeap.size() + 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * 获取中位数 O(1)
     * @return 中位数
     */
    public double findMedian() {
        // 总size=奇数，中位数为maxHeap堆顶
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {  // 总size=偶数，中位数是中间两个数的平均值
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
