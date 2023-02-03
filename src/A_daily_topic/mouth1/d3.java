package A_daily_topic.mouth1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-03  13:10
 * @Description:
 *          1145. 二叉树着色游戏
 *          https://leetcode.cn/problems/binary-tree-coloring-game/
 *          剑指 Offer II 045. 二叉树最底层最左边的值
 *          https://leetcode.cn/problems/LwUNpT/
 */
public class d3 {

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
        // 直接封x节点的路，x节点的相邻的三棵子树，看看哪棵树节点树最多
        private int lcnt,rcnt,cnt;// 左，右，全部
        private int x;
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            this.x = x;
            cnt = dfs(root);
            int rest = cnt - lcnt - rcnt - 1;
            return Math.max(Math.max(rest, lcnt), rcnt) * 2 > cnt;
        }
        private int dfs(TreeNode root){
            if(root == null)return 0;
            if(root.val == x){
                lcnt = dfs(root.left);
                rcnt = dfs(root.right);
                return lcnt + rcnt + 1;
            }
            return dfs(root.left) + dfs(root.right) + 1;

        }

        public int findBottomLeftValue(TreeNode root) {
            // BFS,找出每层第一个，没有下一层时返回
            Queue<TreeNode> queue = new ArrayDeque<>();
            int res = root.val;
            queue.add(root);
            int cnt = 1;
            while(!queue.isEmpty()){
                int tmp = 0;
                res = queue.peek().val;
                for(int i = 0; i < cnt; i++){
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        queue.add(node.left);
                        tmp++;
                    }
                    if(node.right != null){
                        queue.add(node.right);
                        tmp++;
                    }
                }
                cnt = tmp;
            }
            return res;
        }
    }
}