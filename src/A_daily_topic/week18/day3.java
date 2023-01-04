package A_daily_topic.week18;

/**
 * @BelongsPackage: A_daily_topic.week18
 * @Author: yca
 * @CreateTime: 2023-01-04  09:07
 * @Description:
 *          100. 相同的树
 *          https://leetcode.cn/problems/same-tree/
 *          1802. 有界数组中指定下标处的最大值
 *          https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 */
public class day3 {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if((p == null && q != null) || (p != null && q == null))return false;
            if(p == null && q == null)return true;
            if(p.val == q.val)return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            return false;
        }

        public int maxValue(int n, int index, int maxSum) {
            int lCount = index, rCount = n - 1 - index; // 山峰左右两侧的元素数量
            int l = 1, r = maxSum; // 二分查找的左右边界
            while(l <= r){
                int m = (l + r)/2;
                long sum = m + helper(m, lCount) + helper(m, rCount);
                if(sum > maxSum)r = --m;
                else l = ++m;
            }
            return l - 1; // 此时，l 代表数组和恰好大于 maxSum 时的数组和。
        }

        /*求山峰一侧的元素的和，max 为山峰大小，k 为某一侧的元素数量*/
        private long helper(int max, int k){
            if(max > k)return (long)k * (2 * max - 1 - k) / 2;
            else return (long)(max - 3) * max / 2 + k + 1;
        }
    }
}