package A_daily_topic.sword_offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-01-10  11:24
 * @Description:
 *          面试题59 - II. 队列的最大值
 *          https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/?favorite=xb9nqhhg
 *          剑指 Offer 59 - I. 滑动窗口的最大值
 *          https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/?favorite=xb9nqhhg
 */
public class q59 {
    class MaxQueue {
        Deque<Integer> MaxDeque;
        Queue<Integer> queue;

        public MaxQueue() {
            MaxDeque = new ArrayDeque<>();
            queue = new ArrayDeque<>();
        }

        public int max_value() {
            return MaxDeque.isEmpty() ? -1 : MaxDeque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            if(MaxDeque.isEmpty())MaxDeque.addLast(value);
            else{
                while(!MaxDeque.isEmpty() && MaxDeque.peekLast() < value){
                    MaxDeque.pollLast();
                }
                MaxDeque.addLast(value);
            }
        }

        public int pop_front() {
            if(queue.isEmpty())return -1;
            int poll = queue.poll();
            if(MaxDeque.peekFirst() == poll){
                MaxDeque.pollFirst();
            }
            return poll;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 维护一个单调队列(递减)
        Deque<Integer> deque = new ArrayDeque<>();
        // 没有形成窗口是按照单调栈来维护
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])deque.pollLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < len; i++) {
            // 窗口向后移动一格，如果要跳出的数在队列的头，则弹出
            if (nums[i - k] == deque.peekFirst())deque.pollFirst();
            // 处理进队元素
            while (!deque.isEmpty() && deque.peekLast() < nums[i])deque.pollLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}


}