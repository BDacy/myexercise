package A_daily_topic.week3;

import java.util.Stack;

/**
 * @Auther: yca
 * @Date: 2022/09/19/16:15
 * @Description:
 *      129. 求根节点到叶节点数字之和
 *      https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class day1 {
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
    class Solution {
        public int sumNumbers(TreeNode root) {
            //深度优先算法
            return dfs(root,0);
        }
        public int dfs(TreeNode root, int cur){
            if (root==null)return 0;
            if (root.left==null&&root.right==null){
                return cur*10+root.val;
            }else {
                return dfs(root.left,cur*10+root.val)+dfs(root.right,cur*10+root.val);
            }
        }
    }
}
