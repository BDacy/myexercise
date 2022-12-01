package A_daily_topic.week13;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-12-01  18:36
 * @Description:
 *          112. 路径总和
 *          https://leetcode.cn/problems/path-sum/
 *          1779. 找到最近的有相同 X 或 Y 坐标的点
 *          https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */
public class day4 {

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
        int target;
        public boolean hasPathSum(TreeNode root, int targetSum) {
            this.target = targetSum;
            return dfs(root, 0);
        }
        private boolean dfs(TreeNode root,int cur){
            if (root == null)return false;
            int val = root.val;
            if (cur + val == target &&
                    root.left == null &&
                    root.right == null){
                return true;
            }
            if (dfs(root.left, cur + val))return true;
            else return dfs(root.right, cur + val);
        }

        public int nearestValidPoint(int x, int y, int[][] points) {
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < points.length; i++) {
                int a = points[i][0];
                int b = points[i][1];
                if (a == x || b == y){
                    int tmp = Math.abs(a - x) + Math.abs(b - y);
                    if (tmp < minVal){
                        minVal = tmp;
                        minIdx = i;
                    }
                }
            }
            return minIdx;
        }
    }
}