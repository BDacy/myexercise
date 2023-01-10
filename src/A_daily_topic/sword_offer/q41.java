package A_daily_topic.sword_offer;

import java.util.PriorityQueue;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-01-10  10:36
 * @Description:
 *          剑指 Offer 41. 数据流中的中位数
 *          https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/?favorite=xb9nqhhg
 */
public class q41 {
    class MedianFinder {
        PriorityQueue<Integer> A, B;
        /** initialize your data structure here. */
        public MedianFinder() {
            A = new PriorityQueue<>(); // 小顶堆，放后半部分数字
            B = new PriorityQueue<>((a,b) -> b - a);// 大顶堆 放前半部分数字
        }

        public void addNum(int num) {
            if (A.size() != B.size()){
                A.add(num);
                B.add(A.poll());
            }else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}