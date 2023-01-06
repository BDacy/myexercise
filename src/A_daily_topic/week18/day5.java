package A_daily_topic.week18;

/**
 * @BelongsPackage: A_daily_topic.week18
 * @Author: yca
 * @CreateTime: 2023-01-06  10:09
 * @Description:
 *          203. 移除链表元素
 *          https://leetcode.cn/problems/remove-linked-list-elements/
 *          2180. 统计各位数字之和为偶数的整数个数
 *          https://leetcode.cn/problems/count-integers-with-even-digit-sum/
 */
public class day5 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if(head == null)return head;
            ListNode pre = new ListNode(0, head);
            ListNode start = pre;
            ListNode cur = head;
            while(cur != null){
                if(cur.val == val){
                    pre.next = cur.next;
                    cur = pre.next;
                }else{
                    pre = cur;
                    cur = cur.next;
                }
            }
            return start.next;
        }

        public int countEven(int num) {
            int r = num;
            int tmp = 0;
            while(num > 0){
                tmp += num % 10;
                num /= 10;
            }
            return tmp % 2 == 1 ? (r - 1) / 2 : r / 2;
        }
    }
}