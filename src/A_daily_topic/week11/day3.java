package A_daily_topic.week11;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-16  10:19
 * @Description:
 *          155. 最小栈
 *          https://leetcode.cn/problems/min-stack/
 *          775. 全局倒置与局部倒置
 *          https://leetcode.cn/problems/global-and-local-inversions/
 *          剑指 Offer 04. 二维数组中的查找
 *          https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/?favorite=xb9nqhhg
 *          剑指 Offer 06. 从尾到头打印链表
 *          https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/?favorite=xb9nqhhg
 */
public class day3 {
    class MinStack {
        private final PriorityQueue<Integer> minList;
        private final List<Integer> stack;
        public MinStack() {
            minList = new PriorityQueue<>();
            stack = new LinkedList<>();
        }

        public void push(int val) {
            stack.add(val);
            minList.add(val);
        }

        public void pop() {
            Integer remove = stack.remove(stack.size() - 1);
            minList.remove(remove);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minList.element();
        }
    }

    class MinStack1 {
        //辅助栈，存放最小值
        private final Deque<Integer> minStack;
        private final List<Integer> stack;
        public MinStack1() {
            minStack = new LinkedList<>();
            stack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.add(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            minStack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            // 只考虑全局倒置但不是局部倒置的情况
            int max = -1;
            for (int i = 0; i < nums.length - 2; i++) {
                max = Math.max(max, nums[i]);
                if (max > nums[i + 2])return false;
            }
            return true;
        }
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0)return false;
            // 从二维数组的右上方开始出发，target比该数大往下走，比该数小，往左走
            int n = matrix.length;
            int m = matrix[0].length;
            int x = 0;
            int y = m - 1;
            while (x < n && y >= 0){
                if (target == matrix[x][y])return true;
                if (target > matrix[x][y])x++;
                else if (target < matrix[x][y])y--;
            }
            // 走超出边缘则没有匹配，返回false
            return false;
        }


        //Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        //也可以先反转链表再依次输出
        public int[] reversePrint(ListNode head) {
            int[] res;
            // 维护一个栈来存放，再依次输出
            Deque<Integer> stack = new LinkedList<>();
            ListNode cur = head;
            while (cur != null){
                stack.push(cur.val);
                cur = cur.next;
            }
            res = new int[stack.size()];
            int idx = 0;
            while (!stack.isEmpty()){
                res[idx++] = stack.pop();
            }
            return res;
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
}