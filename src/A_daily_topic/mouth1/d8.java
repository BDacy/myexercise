package A_daily_topic.mouth1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-10  21:11
 * @Description:
 *          1233. 删除子文件夹
 *          https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 */
public class d8 {
    // 字典树
    class Trie{
        Map<String, Trie> children = new HashMap<>();
        int fid = -1;

        public void insert(int fid, String f){
            Trie node = this;
            String[] split = f.split("/");
            for (int i = 0; i < split.length; i++) {
                String str = split[i];
                if (!node.children.containsKey(str))
                    node.children.put(str, new Trie());
                node = node.children.get(str);
            }
            // 最后节点处设为下标值
            node.fid = fid;
        }

        // 寻找从上到下找率先fid不为-1的节点 返回其fid值
        public List<Integer> search(){
            List<Integer> ans = new ArrayList<>();
            dfs(this, ans);
            return ans;
        }

        private void dfs(Trie root, List<Integer> ans){
            if (root.fid != -1){
                ans.add(root.fid);
                return;
            }
            for (String key : root.children.keySet()){
                Trie child = root.children.get(key);
                dfs(child, ans);
            }
        }
    }
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Trie root = new Trie();
            for (int i = 0; i < folder.length; i++) {
                String s = folder[i];
                root.insert(i, s);
            }
            List<String> ans = new ArrayList<>();
            for (Integer idx : root.search()) {
                ans.add(folder[idx]);
            }
            return ans;
        }
    }
}