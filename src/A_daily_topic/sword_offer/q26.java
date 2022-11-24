package A_daily_topic.sword_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-24  19:49
 * @Description:
 *          剑指 Offer 26. 树的子结构
 *          https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/?favorite=xb9nqhhg
 */
public class q26 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null)return false;
            if (A.val == B.val && check(A, B))return true;
            boolean i1 = false;
            boolean i2 = false;
            if (A.left != null)i1 = isSubStructure(A.left, B);
            if (A.right != null)i2 = isSubStructure(A.right, B);
            return i1 || i2;

//            //
//            Deque<TreeNode> deque = new LinkedList<>();
//            deque.addLast(A);
//            while (!deque.isEmpty()){
//                TreeNode node = deque.pollFirst();
//                if (node.val == B.val && check(node, B))return true;
//                if (node.left != null)deque.addLast(node.left);
//                if (node.right != null)deque.addLast(node.right);
//            }
        }
        public boolean check(TreeNode A, TreeNode B){
            if (A == null)return false;
            if (A.val == B.val){
                boolean i1 = true;
                boolean i2 = true;
                if (B.left != null)i1 = check(A.left, B.left);
                if (B.right != null)i2 = check(A.right, B.right);
                return i1 && i2;
            }
            return false;
        }
    }
}