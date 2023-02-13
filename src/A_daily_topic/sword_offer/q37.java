package A_daily_topic.sword_offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  15:19
 * @Description:
 *          剑指 Offer 37. 序列化二叉树
 *          https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/?favorite=xb9nqhhg
 */
public class q37 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null)return "";
            // 1,2,3,null,null,4,5
            StringBuilder ans = new StringBuilder();
            Queue<TreeNode> queue = new ArrayDeque<>();

            queue.offer(root);
            ans.append(root.val);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    ans.append(",").append(node.left.val);
                }else ans.append(",null");

                if(node.right != null){
                    queue.offer(node.right);
                    ans.append(",").append(node.right.val);
                }else ans.append(",null");
            }
            return ans.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals(""))return null;
            Queue<TreeNode> queue = new ArrayDeque<>();
            String[] strs = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
            queue.offer(root);

            int len = strs.length;
            int idx = 1;
            while(!queue.isEmpty() && idx < len){
                TreeNode node = queue.poll();
                if(!strs[idx].equals("null")){
                    TreeNode tmp1 = new TreeNode(Integer.parseInt(strs[idx]));
                    queue.offer(tmp1);
                    node.left = tmp1;
                }
                idx++;
                if(idx >= len)break;
                if(!strs[idx].equals("null")){
                    TreeNode tmp2 = new TreeNode(Integer.parseInt(strs[idx]));
                    queue.offer(tmp2);
                    node.right = tmp2;
                }
                idx++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}