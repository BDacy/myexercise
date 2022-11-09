package A_daily_topic.week10;

import org.w3c.dom.Node;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week10
 * @Author: yca
 * @CreateTime: 2022-11-09  18:12
 * @Description: 273. 整数转换英文表示
 *              https://leetcode.cn/problems/integer-to-english-words/
 *              429. N 叉树的层序遍历
 *              https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 */
public class day3 {
    class Solution {
        //copy于三叶姐
        static String[] num2str_small = {
                "Zero",
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        static String[] num2str_medium = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        static String[] num2str_large = {
                "Billion", "Million", "Thousand", "",
        };

        String num2Str(int x) {
            String ans = "";
            if (x >= 100) {
                ans += num2str_small[x / 100] + " Hundred ";
                x %= 100;
            }
            if (x >= 20) {
                ans += num2str_medium[x / 10] + " ";
                x %= 10;
            }
            if (x != 0) {
                ans += num2str_small[x] + " ";
            }
            return ans;
        }

        public String numberToWords(int num) {
            if (num == 0) return num2str_small[num];
            StringBuilder ans = new StringBuilder();
            for (int i = (int) 1e9, j = 0; i > 0; i/=1000, j++) {
                if (num < i) continue;
                ans.append(num2Str(num / i)).append(num2str_large[j]).append(" ");
                num %= i;
            }
            while (ans.charAt(ans.length() - 1) == ' ') ans.deleteCharAt(ans.length() - 1);
            return ans.toString();
        }

    }

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

    class Solution1 {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null)return new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            //层序遍历，使用队列
            Deque<List<Node>> deque = new LinkedList<>();
            List<Node> cur = new LinkedList<>();
            cur.add(root);
            deque.addLast(cur);
            while (!deque.isEmpty()){
                List<Node> nodes = deque.pollFirst();
                List<Node> New = new LinkedList<>();
                List<Integer> Added = new LinkedList<>();
                for (Node node : nodes) {
                    Added.add(node.val);
                    if (node.children != null) New.addAll(node.children);
                }
                ans.add(Added);
                if (New.size() != 0)deque.addLast(New);
            }
            return ans;
        }
    }
}