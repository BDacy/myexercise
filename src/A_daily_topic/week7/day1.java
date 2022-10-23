package A_daily_topic.week7;

/**
 * @BelongsPackage: A_daily_topic.week7
 * @Author: yca
 * @CreateTime: 2022-10-17  22:01
 * @Description:
 *          1448. 统计二叉树中好节点的数目
 *          https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
 */
public class day1 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        int cnt = 0;
        public int goodNodes(TreeNode root) {
            int max = Integer.MIN_VALUE;
            dfs(root,max);
            return cnt;
        }
        public void dfs(TreeNode root,int max){
            if (root == null)return;
            if (root.val >= max){
                max = root.val;
                cnt++;
            }
            dfs(root.left, max);
            dfs(root.right, max);
        }
    }
}
