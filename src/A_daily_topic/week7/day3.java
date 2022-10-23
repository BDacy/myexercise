package A_daily_topic.week7;

import java.util.Stack;

/**
 * @BelongsPackage: A_daily_topic.week7
 * @Author: yca
 * @CreateTime: 2022-10-19  18:48
 * @Description:
 *          232. 用栈实现队列
 *          https://leetcode.cn/problems/implement-queue-using-stacks/
 */
public class day3 {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int size;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            size = 0;
        }

        public void push(int x) {
            if (size == 0) stack2.push(x);
            else {
                for (int i = 0; i < size; i++) {
                    Integer num = stack2.pop();
                    stack1.push(num);
                }
                stack2.push(x);
                for (int i = 0; i < size; i++) {
                    Integer num = stack1.pop();
                    stack2.push(num);
                }
            }
            size++;
        }

        public int pop() {
            size--;
            return stack2.pop();
        }

        public int peek() {
            return stack2.peek();
        }

        public boolean empty() {
            return size==0;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}