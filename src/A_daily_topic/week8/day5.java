package A_daily_topic.week8;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-28  11:39
 * @Description:
 *          21. 合并两个有序链表
 *          https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class day5 {

   // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode();
            ListNode node = root;
            while (list1 != null && list2 != null){
                if (list1.val <= list2.val){
                    node.next = new ListNode(list1.val);
                    list1 = list1.next;

                }else {
                    node.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                node = node.next;
            }
            if (list1 == null)
                node.next = list2;
            else
                node.next = list1;
            return root.next;
        }
    }
}