package A_daily_topic.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yca
 * @Date: 2022/09/24/11:38
 * @Description:
 *          138. 复制带随机指针的链表
 *          https://leetcode.cn/problems/copy-list-with-random-pointer/
 */
public class day6 {
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
            if (head == null) return null;
            Map<Node,Node> map = new HashMap<>();
            //除了random的直接复制
            Node old = head;
            Node newHead = new Node(head.val);
            Node newNode = newHead;
            map.put(old,newNode);
            while (old.next!=null){
                old = old.next;
                newNode.next = new Node(old.val);
                newNode = newNode.next;
                map.put(old,newNode);
            }
            //random的复制
            old = head;
            newNode = newHead;
            while (old!=null){
                Node random = old.random;
                if (random == null){
                    newNode.random = null;
                }else {
                    Node node = map.get(random);
                    newNode.random = node;
                }
                old = old.next;
                newNode = newNode.next;
            }
            return newHead;
        }
    }
}
