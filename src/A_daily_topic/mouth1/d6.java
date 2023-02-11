package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-10  21:29
 * @Description:
 *          2331. 计算布尔二叉树的值
 *          https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 */
public class d6 {

    // Definition for a binary tree node.
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
        public boolean evaluateTree(TreeNode root) {
            // 模拟计算
            if(root.left == null && root.right == null)return root.val == 1 ? true : false;
            if(root.val == 2){
                return evaluateTree(root.left) || evaluateTree(root.right);
            }else{
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}