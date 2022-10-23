package A_daily_topic.week4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: yca
 * @Date: 2022/09/30/15:20
 * @Description:
 *          199. 二叉树的右视图
 *          https://leetcode.cn/problems/binary-tree-right-side-view/
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

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<Integer> ();
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            if (root == null) {
                return res;
            } else {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                int len = queue.size(), right = 0;
                for (int i = 0; i < len; ++i) {
                    TreeNode node = queue.poll();
                    right = node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(right);
            }
            return res;
        }
    }

}
