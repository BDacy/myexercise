package A_daily_topic.week17;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2022-12-30  08:50
 * @Description:
 *          225. 用队列实现栈
 *          https://leetcode.cn/problems/implement-stack-using-queues/
 *          855. 考场就座
 *          https://leetcode.cn/problems/exam-room/
 */
public class day5 {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int x) {
            queue2.add(x);
            while (!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

    class ExamRoom {
        private TreeSet<Integer> room;
        private int size;
        public ExamRoom(int n) {
            room = new TreeSet<>();
            size = n - 1;
        }

        public int seat() {
            // 下面的距离表示的是idx是要坐的座位时，idx到两边的距离
            int idx = 0;
            if (room.size() > 0){
                int dist = room.first();// 第一个元素到0的距离就是它本身，默认其为初始的最大距离
                Integer pre = null;
                // 遍历每个已经坐的座位，新座位从每两个座位最中间中选，选最大的那个
                for (Integer seat : room) {
                    if (pre != null){
                        int d = (seat - pre) >> 1;
                        if (d > dist){
                            dist = d;
                            idx = (seat + pre) >> 1;// 暂时最大距离的要选取的座位
                        }
                    }
                    pre = seat;
                }
                if (size - room.last() > dist){
                    idx = size;// 最后一个位置的判断
                }
            }
            room.add(idx);
            return idx;
        }

        public void leave(int p) {
            room.remove(p);
        }
    }

    /**
     * Your ExamRoom object will be instantiated and called as such:
     * ExamRoom obj = new ExamRoom(n);
     * int param_1 = obj.seat();
     * obj.leave(p);
     */
}