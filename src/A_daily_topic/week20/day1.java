package A_daily_topic.week20;

/**
 * @BelongsPackage: A_daily_topic.week20
 * @Author: yca
 * @CreateTime: 2023-01-16  14:10
 * @Description:
 *          222. 完全二叉树的节点个数
 *          https://leetcode.cn/problems/count-complete-tree-nodes/
 *          1813. 句子相似性 III
 *          https://leetcode.cn/problems/sentence-similarity-iii/
 */
public class day1 {
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
        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            int ld = depth(root.left);
            int rd = depth(root.right);
            if(ld == rd){
                return (1 << ld) + countNodes(root.right);
            }else{
                return (1 << rd) + countNodes(root.left);
            }
        }

        private int depth(TreeNode root){
            if(root == null) return 0;
            int cnt = 0;
            TreeNode cur = root;
            while(cur != null){
                cur = cur.left;
                cnt++;
            }
            return cnt;
        }

        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            // 相同
            if(sentence1.equals(sentence2))return true;
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            // s1更长
            if(s1.length < s2.length){
                String[] tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            // 前后匹配
            // 前匹配
            int left = 0;
            while(left < s2.length){
                if(!s1[left].equals(s2[left]))break;
                left++;
            }
            // 后匹配
            int right = 0;
            while(right < s2.length){
                if(!s1[s1.length - 1 - right].equals(s2[s2.length - 1 - right]))break;
                right++;
            }
            return left + right >= s2.length;
        }
    }
}