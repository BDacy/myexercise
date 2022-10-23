package com.ityca.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2055. 蜡烛之间的盘子
public class demo6 {
    public static void main(String[] args) {
        String s="***|**|*****|**||**|*";
        int[][]queries={{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(Arrays.toString(Solution.platesBetweenCandles(s,queries)));
    }
    class Solution {
        public static int[] platesBetweenCandles(String s, int[][] qs) {
            //转换字符数组
            char[] cs = s.toCharArray();
            //获取长度
            int n = cs.length, m = qs.length;
            int[] ans = new int[m], sum = new int[n + 1];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (cs[i] == '|') list.add(i);
                sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
            }
            if (list.size() == 0) return ans;
            for (int i = 0; i < m; i++) {
                int a = qs[i][0], b = qs[i][1];
                int c = -1, d = -1;
                // 找到 a 右边最近的蜡烛
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) >= a) r = mid;
                    else l = mid + 1;
                }
                if (list.get(r) >= a) c = list.get(r);
                else continue;
                // 找到 b 左边最近的蜡烛
                l = 0; r = list.size() - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (list.get(mid) <= b) l = mid;
                    else r = mid - 1;
                }
                if (list.get(r) <= b) d = list.get(r);
                else continue;
                if (c <= d) ans[i] = sum[d + 1] - sum[c];
            }
            return ans;
        }
    }
}
