package com.ityca.week5;

import java.util.HashSet;
import java.util.Set;

//653. 两数之和 IV - 输入 BST
public class demo1 {
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
          //设置全局变量，存放扫描过的节点
        Set<Integer> set=new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
            if (root==null)return false;
            //设置k-val值决定是否存在
            if (set.contains(k- root.val)) return true;
            //添加
            set.add(root.val);
            //继续查看左右子树,返回结果去或，有1则为1
            return findTarget(root.left,k)|findTarget(root.right,k);

        }
    }
}
