package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-11  09:28
 * @Description:
 *          剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *          https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/?favorite=xb9nqhhg
 *          剑指 Offer 68 - II. 二叉树的最近公共祖先
 *          https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/?favorite=xb9nqhhg
 */
public class q68 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 遍历节点，出现几种情况
            // 1. 一左一右，目前节点为最近公共节点
            // 2. 目前节点为p或q则，当前节点就是结果
            // 3. 两个节点在同一侧， 往那一侧继续遍历
            TreeNode cur = root;
            int pval = p.val;
            int qval = q.val;
            while (cur != null){
                int val = cur.val;
                if (val == pval || val == qval
                        || (pval < val && val < qval)
                        || (qval < val && val < pval))return cur;
                else if (pval < val)cur = cur.left;
                else cur = cur.right;
            }
            return root;
        }
    }
    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null) return right;
            if(right == null) return left;
            return root;
        }
    }
}