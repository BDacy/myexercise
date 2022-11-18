package A_daily_topic.week11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-18  10:49
 * @Description:
 *          106. 从中序与后序遍历序列构造二叉树
 *          https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *          891. 子序列宽度之和
 *          https://leetcode.cn/problems/sum-of-subsequence-widths/
 *          剑指 Offer 09. 用两个栈实现队列
 *          https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *          剑指 Offer 10- I. 斐波那契数列
 *          https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 *          剑指 Offer 10- II. 青蛙跳台阶问题
 *          https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/?favorite=xb9nqhhg
 */
public class day5 {

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
        // 记录inorder的k - 数字 v - 下标
        Map<Integer,Integer> map = new HashMap<>();
        int[] postorder;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 初始化map
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            this.postorder = postorder;
            return buildTreeNode(0,inorder.length - 1, 0, postorder.length - 1);

        }

        /**
         * 递归构造树
         * @param il 中序遍历的左边界
         * @param ir 中序遍历的右边界
         * @param pl 后序遍历的左边界
         * @param pr 后序遍历的右边界
         * @return 树根
         */
        private TreeNode buildTreeNode(int il, int ir, int pl, int pr){
            if (il > ir || pl > pr)return null;
            int rootVal = postorder[pr];
            TreeNode root = new TreeNode(rootVal);
            // 获取根节点在中序遍历的下标
            Integer rootIdx = map.get(rootVal);
            root.left = buildTreeNode(il, rootIdx - 1,pl, rootIdx - il + pl - 1 );
            root.right = buildTreeNode(rootIdx + 1,ir,pr - ir + rootIdx,pr -1);
            return root;
        }

        public int sumSubseqWidths(int[] nums) {
            Arrays.sort(nums); // 排序
            int mod = (int)1e9 + 7, n = nums.length;
            long result = 0;
            long[] pow = new long[n];
            pow[0] = 1;
            for (int i = 1; i < n; i++)
                pow[i] = (pow[i - 1] << 1) % mod; // 初始化2^n的值

            for (int i = 0; i < n; i++)
                result = (result + (pow[i] - pow[n-i-1]) * nums[i] % mod) % mod; // 计算总和
            return (int)result;
        }

        class CQueue {
            Stack<Integer> stack1;
            Stack<Integer> stack2;
            public CQueue() {
                stack1 = new Stack<>();
                stack2 = new Stack<>();
            }

            public void appendTail(int value) {
                stack1.add(value);
            }

            public int deleteHead() {
                if (!stack2.isEmpty()){
                    return stack2.pop();
                }
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                if (stack2.isEmpty())return -1;
                else return stack2.pop();
            }
        }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

        public int fib(int n) {
            int a = 0, b = 1, sum;
            for(int i = 0; i < n; i++){
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return a;
        }

        public int numWays(int n) {
            if (n == 0 || n == 1) return 1;
            if (n == 2) return 2;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % (int) (1e9+7);
            }
            return dp[n];
        }
    }
}