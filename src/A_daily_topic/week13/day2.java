package A_daily_topic.week13;

import java.util.HashMap;

/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-11-29  09:08
 * @Description:
 *          208. 实现 Trie (前缀树)
 *          https://leetcode.cn/problems/implement-trie-prefix-tree/
 *          1758. 生成交替二进制字符串的最少操作数
 *          https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class day2 {
    //也可以使用数组
    class Trie {
        Node root;

        public Trie() {
            root = new Node(' ',new HashMap<>());
        }

        public void insert(String word) {
            int length = word.length();
            Node cur = root;
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (!cur.map.containsKey(c)) {
                    cur.map.put(c, new Node(c, new HashMap<>()));
                }
                cur = cur.map.get(c);
            }
            cur.flag = true;
        }

        public boolean search(String word) {
            int length = word.length();
            Node cur = root;
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (!cur.map.containsKey(c))return false;
                else {
                    cur = cur.map.get(c);
                }
            }
            return cur.flag;
        }

        public boolean startsWith(String prefix) {
            int length = prefix.length();
            Node cur = root;
            for (int i = 0; i < length; i++) {
                char c = prefix.charAt(i);
                if (!cur.map.containsKey(c))return false;
                else {
                    cur = cur.map.get(c);
                }
            }
            return true;
        }
        class Node{
            char c;
            HashMap<Character,Node> map;
            boolean flag = false;

            public Node(char c, HashMap<Character, Node> map) {
                this.c = c;
                this.map = map;
            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

    class Solution {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 强制化成：010101...
            if (c !=  '0' + (i % 2))cnt++;
        }
        return Math.min(cnt,s.length() - cnt);
    }
}
}