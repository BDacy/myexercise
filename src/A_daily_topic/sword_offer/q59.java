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

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

}