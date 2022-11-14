package A_daily_topic.week11;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-14  16:25
 * @Description:
 *          1008. 前序遍历构造二叉搜索树
 *          https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/
 *          805. 数组的均值分割
 *          https://leetcode.cn/problems/split-array-with-same-average/
 *
 */
public class day1 {

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
        public TreeNode bstFromPreorder(int[] preorder) {

            // 利用一个单调栈辅助构造
            TreeNode root = new TreeNode(preorder[0]);
            Deque<TreeNode> stack = new LinkedList<>();
            stack.addFirst(root);
            for (int i = 1; i < preorder.length; i++) {
                TreeNode cur = null;
                TreeNode son = new TreeNode(preorder[i]);
                while (!stack.isEmpty()){
                    if (stack.peekFirst().val < preorder[i]){
                        cur = stack.removeFirst();
                    }else {
                        if (cur != null) cur.right = son;
                        else stack.peekFirst().left = son;
                        break;
                    }
                }
                if (stack.isEmpty()) cur.right = son;

                stack.addFirst(son);
            }
            return root;
        }

        // 三叶姐 yyds
        public boolean splitArraySameAverage(int[] nums) {
            int n = nums.length, m = n / 2, sum = 0;
            for (int x : nums) sum += x;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int s = 0; s < (1 << m); s++) {
                int tot = 0, cnt = 0;
                for (int i = 0; i < m; i++) {
                    if (((s >> i) & 1) == 1) {
                        tot += nums[i]; cnt++;
                    }
                }
                Set<Integer> set = map.getOrDefault(tot, new HashSet<>());
                set.add(cnt);
                map.put(tot, set);
            }
            for (int s = 0; s < (1 << (n - m)); s++) {
                int tot = 0, cnt = 0;
                for (int i = 0; i < (n - m); i++) {
                    if (((s >> i) & 1) == 1) {
                        tot += nums[i + m]; cnt++;
                    }
                }
                for (int k = Math.max(1, cnt); k < n; k++) {
                    if (k * sum % n != 0) continue;
                    int t = k * sum / n;
                    if (!map.containsKey(t - tot)) continue;
                    if (!map.get(t - tot).contains(k - cnt)) continue;
                    return true;
                }
            }
            return false;
        }
    }
}