package A_daily_topic.week12;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-22  08:44
 * @Description:
 *          147. 对链表进行插入排序
 *          https://leetcode.cn/problems/insertion-sort-list/
 *          878. 第 N 个神奇数字
 *          https://leetcode.cn/problems/nth-magical-number/
 */
public class day2 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null)return head;
            // 使用指针模拟插入排序
            ListNode pre = new ListNode();
            ListNode root = pre;
            pre.next = head;
            while (pre.next != null){
                // 找出pre以后的最小值节点
                ListNode cur = pre.next;
                ListNode MinNode = cur;
                ListNode f = pre;
                while (cur.next != null){
                    if (cur.next.val <= MinNode.val){
                        MinNode = cur.next;
                        f = cur;
                    }
                    cur = cur.next;
                }
                // 将最小值节点插入到pre的前面
                f.next = MinNode.next;
                MinNode.next = pre.next;
                pre.next = MinNode;
                pre = MinNode;
            }
            return root.next;
        }

        public int nthMagicalNumber(int n, int a, int b) {
            int mod = (int) (1e9 + 7);
            int lcm = a * b / gcd(a, b);// 计算最小共倍数
            long l = 1;
            long r = (long) (a + b) * n;
            while (l < r){
                long mid = l + r >> 1;
                if (mid/a + mid/b - mid/lcm >= n){
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
            return (int) (l % mod);
        }
        private int gcd(int a, int b){
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}