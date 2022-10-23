package com.ityca.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//590. N 叉树的后序遍历
public class demo4 {
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
        public List<Integer> postorder(Node root) {
            //后序遍历
            //先从左到右遍历子节点，再去取根节点
            //直接使用递归或者是栈的方式,这里采用递归的方式
            List<Integer> res=new ArrayList<>();
            test(res,root);
            return res;
        }

        private void test(List<Integer> res, Node root) {
            if (root==null)return;
//            if (root.children==null) {
//                res.add(root.val);
//                return;
//            }
            for (Node child : root.children) {
                test(res,child);
            }
            res.add(root.val);
            return;
        }
    }
}
