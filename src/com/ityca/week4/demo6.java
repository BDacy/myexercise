package com.ityca.week4;
//606. 根据二叉树创建字符串
//题目解释就是一坨屎
public class demo6 {
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
        StringBuilder sb = new StringBuilder();
        public String tree2str(TreeNode root) {
            dfs(root);
            return sb.substring(1, sb.length() - 1);
        }
        void dfs(TreeNode root) {
            sb.append("(");
            sb.append(root.val);
            if (root.left != null) dfs(root.left);
            else if (root.right != null) sb.append("()");
            if (root.right != null) dfs(root.right);
            sb.append(")");
        }
    }
}
