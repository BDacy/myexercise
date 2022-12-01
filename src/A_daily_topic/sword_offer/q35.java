package A_daily_topic.sword_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-01  19:01
 * @Description:
 *          剑指 Offer 35. 复杂链表的复制
 *          https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?favorite=xb9nqhhg
 */
public class q35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null)return null;
            Node root = new Node(0);
            Node pre = root;
            Node cur = head;
            // K - 旧，V - 新
            Map<Node, Node> map = new HashMap<>();

            while(cur != null){
                pre.next = new Node(cur.val);
                pre = pre.next;
                map.put(cur, pre);
                cur = cur.next;
            }

            cur = head;
            pre = root.next;
            while(cur != null){
                Node node = map.get(cur.random);
                pre.random = node;
                pre = pre.next;
                cur = cur.next;
            }
            return root.next;
        }
    }
}