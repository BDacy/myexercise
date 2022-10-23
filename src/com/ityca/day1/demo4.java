package com.ityca.day1;


import java.util.LinkedList;
import java.util.Queue;

//222. 完全二叉树的节点个数
public class demo4 {
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
          //仅限制完全二叉树
        public int countNodes1(TreeNode root){
            if (root==null)return 0;
            //比较左右子树的深度
            int ld=0;//左子树深度
            int rd=0;//右子树深度
            ld=countDepth(root.left);
            rd=countDepth(root.right);
            if(ld==rd){
                //左右子树深度相同
                //右子树为完全二叉树
                return countNodes1(root.right)+(1<<ld);
            }
            else{
                //左子树深度大于右子树
                //左子树为完全二叉树
                return countNodes1(root.left)+(1<<rd);
            }
        }
        public int countDepth(TreeNode root){
            //计算树的深度
            if (root==null)return 0;
            int cnt=0;
            TreeNode temp=root;
            //由于树为完全二叉树，叶子结点全部位于左侧
            //所以只要确定最左下的叶子结点的深度即可确定深度
            while (temp!=null){
                temp=temp.left;
                cnt++;
            }
            return cnt;
        }
          //只要是二叉树都可以用这个方法
        public int countNodes(TreeNode root) {
            if (root==null)return 0;
            int cnt=0;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            cnt++;
            while (!queue.isEmpty()){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                    cnt++;
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
