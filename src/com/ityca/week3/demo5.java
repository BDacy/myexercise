package com.ityca.week3;

import java.util.ArrayList;
import java.util.List;

//589. N 叉树的前序遍历
public class demo5 {
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res=new ArrayList<>();
            test(res,root);
            return res;
        }

        private void test(List<Integer> res, Node root) {
            if (root==null)return;
            res.add(root.val);
            for (Node child : root.children) {
                test(res,child);
            }
        }
    }
}
