/*
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 * 1. 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 2. 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */

package solFrom201To300.sol295;

import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> largeNums;
    private final PriorityQueue<Integer> smallNums;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 小顶堆，存放较大的数
        largeNums = new PriorityQueue<>();
        // 大顶堆，存放较小的数
        smallNums = new PriorityQueue<>((a, b) -> b - a);
    }


    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (largeNums.size() != smallNums.size())
            return largeNums.size() > smallNums.size() ? largeNums.peek() : smallNums.peek();
        // 如果元素一样多，两个堆堆顶元素的平均数为中位数
        return (largeNums.peek() + smallNums.peek()) / 2.0;
    }

    public void addNum(int num) {
        if (smallNums.size() >= largeNums.size()) {
            smallNums.offer(num);
            largeNums.offer(smallNums.poll());
        } else {
            largeNums.offer(num);
            smallNums.offer(largeNums.poll());
        }
    }
}
