package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-01  19:21
 * @Description:
 *          剑指 Offer 36. 二叉搜索树与双向链表
 *          https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?favorite=xb9nqhhg
 */
public class q36 {
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
    class Solution {
        Node pre,head;
        public Node treeToDoublyList(Node root) {
            if (root == null)return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void dfs(Node root){
            if (root == null)return;
            dfs(root.left);
            if (pre == null)head = root;
            else pre.right = root;
            root.left = pre;
            pre = root;
            dfs(root.right);
        }
    }
}