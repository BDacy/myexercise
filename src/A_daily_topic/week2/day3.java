package A_daily_topic.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: yca
 * @Date: 2022/09/14/9:26
 * @Description:
 *          94. 二叉树的中序遍历
 *          https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class day3 {
//    Definition for a binary tree node.
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
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list =new ArrayList<>();
            //维护一个栈来保存节点指针
            Stack<TreeNode> stack=new Stack<>();
            TreeNode cur = root;
            while (!stack.isEmpty()||cur!=null){
                //一直向左下深入
                while (cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
            return list;
        }
    }

}
