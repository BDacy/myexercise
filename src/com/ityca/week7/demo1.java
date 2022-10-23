package com.ityca.week7;
//面试题 02.07. 链表相交
public class demo1 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
     }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //计算两个链表的长度
            int cnt1=0;
            int cnt2=0;
            ListNode A=headA;
            ListNode B=headB;
            while (A!=null){
                A=A.next;
                cnt1++;
            }
            while (B!=null){
                B=B.next;
                cnt2++;
            }
            //计算差值
            A=headA;
            B=headB;
            int cc=cnt1-cnt2;
            if (cc<0)
                for (int i=0;i>cc;i--)
                    B=B.next;
            else
                for (int i=0;i<cc;i++)
                    A=A.next;
            //一起走
            while (A!=null){
                if (A==B)
                    return A;
                else{
                    A=A.next;
                    B=B.next;
                }
            }
            return null;
        }
    }
}
