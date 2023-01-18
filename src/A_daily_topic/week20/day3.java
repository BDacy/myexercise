package A_daily_topic.week20;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week20
 * @Author: yca
 * @CreateTime: 2023-01-18  13:26
 * @Description:
 *          257. 二叉树的所有路径
 *          https://leetcode.cn/problems/binary-tree-paths/
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
        List<String> res;
        public List<String> binaryTreePaths(TreeNode root) {
            // dfs遍历
            res = new ArrayList<>();
            if(root.left == null && root.right == null){res.add(root.val + "");}
            if(root.left != null)dfs(root.left, root.val + "");
            if(root.right != null) dfs(root.right, root.val + "");
            return res;
        }
        private void dfs(TreeNode root, String s){
            if(root.left == null && root.right == null){
                res.add(s + "->" + root.val);
                return;
            }
            if(root.left != null){
                dfs(root.left, s + "->" + root.val);
            }
            if(root.right != null){
                dfs(root.right, s + "->" + root.val);
            }
        }
    }

    class MKAverage {

        private int m, k;
        private long s;
        private int size1, size3;
        private Deque<Integer> q = new ArrayDeque<>();
        private TreeMap<Integer, Integer> lo = new TreeMap<>();
        private TreeMap<Integer, Integer> mid = new TreeMap<>();
        private TreeMap<Integer, Integer> hi = new TreeMap<>();


        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            if (lo.isEmpty() || num <= lo.lastKey()) {
                lo.merge(num, 1, Integer::sum);
                ++size1;
            } else if (hi.isEmpty() || num >= hi.firstKey()) {
                hi.merge(num, 1, Integer::sum);
                ++size3;
            } else {
                mid.merge(num, 1, Integer::sum);
                s += num;
            }
            q.offer(num);
            if (q.size() > m) {
                int x = q.poll();
                if (lo.containsKey(x)) {
                    if (lo.merge(x, -1, Integer::sum) == 0) {
                        lo.remove(x);
                    }
                    --size1;
                } else if (hi.containsKey(x)) {
                    if (hi.merge(x, -1, Integer::sum) == 0) {
                        hi.remove(x);
                    }
                    --size3;
                } else {
                    if (mid.merge(x, -1, Integer::sum) == 0) {
                        mid.remove(x);
                    }
                    s -= x;
                }
            }
            for (; size1 > k; --size1) {
                int x = lo.lastKey();
                if (lo.merge(x, -1, Integer::sum) == 0) {
                    lo.remove(x);
                }
                mid.merge(x, 1, Integer::sum);
                s += x;
            }
            for (; size3 > k; --size3) {
                int x = hi.firstKey();
                if (hi.merge(x, -1, Integer::sum) == 0) {
                    hi.remove(x);
                }
                mid.merge(x, 1, Integer::sum);
                s += x;
            }
            for (; size1 < k && !mid.isEmpty(); ++size1) {
                int x = mid.firstKey();
                if (mid.merge(x, -1, Integer::sum) == 0) {
                    mid.remove(x);
                }
                s -= x;
                lo.merge(x, 1, Integer::sum);
            }
            for (; size3 < k && !mid.isEmpty(); ++size3) {
                int x = mid.lastKey();
                if (mid.merge(x, -1, Integer::sum) == 0) {
                    mid.remove(x);
                }
                s -= x;
                hi.merge(x, 1, Integer::sum);
            }
        }

        public int calculateMKAverage() {
            return q.size() < m ? -1 : (int) (s / (q.size() - k * 2));
        }
    }



/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */


}