package A_daily_topic.week14;

/**
 * @BelongsPackage: A_daily_topic.week14
 * @Author: yca
 * @CreateTime: 2022-12-11  09:09
 * @Description:
 *          110. 平衡二叉树
 *          https://leetcode.cn/problems/balanced-binary-tree/
 *          1827. 最少操作使数组递增
 *          https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
 */
public class day7 {

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
        public boolean isBalanced(TreeNode root) {
            if (root == null)return true;
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
        private int height(TreeNode root){
            if (root == null)return 0;
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public int minOperations(int[] nums) {
        // 遍历处理
        int ans = 0;
        int max = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= max){
                ans += max - nums[i];
                max++;
            }else {
                max = nums[i] + 1;
            }
        }
        return ans;
    }
}