package A_daily_topic.week17;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2023-01-01  23:33
 * @Description:
 *          2351. 第一个出现两次的字母
 *          https://leetcode.cn/problems/first-letter-to-appear-twice/
 *          337. 打家劫舍 III
 *          https://leetcode.cn/problems/house-robber-iii/
 */
public class day7 {
    class Solution {
        public char repeatedCharacter(String s) {
            boolean[] val = new boolean[26];
            for(int i = 0;i < s.length(); i++){
                char c = s.charAt(i);
                if(val[c - 'a'])return c;
                val[c - 'a'] = true;
            }
            return 'a';
        }


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
        Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
        Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

        public int rob(TreeNode root) {
            dfs(root);
            return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            dfs(node.right);
            f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
            g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
        }
    }
}