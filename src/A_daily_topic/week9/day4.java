package A_daily_topic.week9;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-11-03  08:19
 * @Description:
 *          721. 账户合并
 *          https://leetcode.cn/problems/accounts-merge/
 *          1668. 最大重复子字符串
 *          https://leetcode.cn/problems/maximum-repeating-substring/
 */
public class day4 {

    class Solution {
        //k - 邮箱 v - 该邮箱的根，构造并查集
        Map<String,String> q = new HashMap<>();
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // k - 邮箱 v - 邮箱对应的账户
            Map<String,String> map = new HashMap<>();
            for (List<String> account : accounts) {
                String name = account.get(0);
                for (int i = 1; i < account.size(); i++) {
                    if (!q.containsKey(account.get(i))){
                        //没有则是自己的根
                        q.put(account.get(i),account.get(i));
                        map.put(account.get(i),name);
                    }
                    if (i > 1){
                        //并查集合并
                        q.put(find(account.get(i)),find(account.get(i - 1)));
                    }
                }
            }

            Map<String,List<String>> temp = new HashMap<>();
            for (String email : q.keySet()) {
                String root = find(email);
                if (!temp.containsKey(root))temp.put(root,new ArrayList<>());
                temp.get(root).add(email);
            }

            //temp的数据转换成双List中
            List<List<String>> res = new ArrayList<>();
            for (String root : temp.keySet()) {
                List<String> list = temp.get(root);
                Collections.sort(list);
                list.add(0,map.get(root));
                res.add(list);
            }
            return res;

        }
        private String find(String email){
            if (!q.get(email).equals(email)){
                //如果根不是自己，则询问自己的上一级
                q.put(email,find(q.get(email)));
            }
            return q.get(email);
        }

        public int maxRepeating(String sequence, String word) {
            int cnt = 0;
            while (sequence.contains(word.repeat(cnt))) {
                cnt++;
            }
            return cnt - 1;
        }
    }
}