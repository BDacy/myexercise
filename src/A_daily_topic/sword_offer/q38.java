package A_daily_topic.sword_offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-01  19:42
 * @Description:
 *          剑指 Offer 38. 字符串的排列
 *          https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/?favorite=xb9nqhhg
 */
public class q38 {
    class Solution {
        List<String> res = new LinkedList<>();
        char[] c;
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
        void dfs(int x) {
            if(x == c.length - 1) {
                res.add(String.valueOf(c));      // 添加排列方案
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 重复，因此剪枝
                set.add(c[i]);
                swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1);                      // 开启固定第 x + 1 位字符
                swap(i, x);                      // 恢复交换
            }
        }
        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }
    }
}