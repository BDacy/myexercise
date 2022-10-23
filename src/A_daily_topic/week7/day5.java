package A_daily_topic.week7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @BelongsPackage: A_daily_topic.week7
 * @Author: yca
 * @CreateTime: 2022-10-21  13:14
 * @Description:
 *          173. 二叉搜索树迭代器
 *          https://leetcode.cn/problems/binary-search-tree-iterator/
 */
public class day5 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class BSTIterator {
        public Deque<TreeNode> stack;
        public TreeNode cur;
        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            cur = root;
        }

        public int next() {
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}