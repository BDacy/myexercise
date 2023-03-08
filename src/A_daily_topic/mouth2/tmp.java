package A_daily_topic.mouth2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-01  22:53
 * @Description:
 */
public class tmp {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        System.out.println(Solution.minWindow(s,t));
        String s1 = "tmmzuxt";
        System.out.println(Solution.lengthOfLongestSubstring(s1));
    }
    class Solution {
        public static int lengthOfLongestSubstring(String s) {
            // 滑动窗口？
            boolean[] visited = new boolean[256];
            int n = s.length();
            int l = 0;
            int max = 0;
            for(int r = 0; r < n; r++){
                char c = s.charAt(r);
                if(visited[c]){
                    // 找到左边界的 c使其可以向下一个字符移动
                    while(l < r && s.charAt(l) != c){
                        visited[s.charAt(l++)] = false;
                    }
                    l++;
                }else{
                    visited[c]= true;
                    max = Math.max(max, r - l + 1);
                }
            }
            return max;
        }
        public static String minWindow(String s, String t) {
            // 预处理，再滑动窗口
            int min = Integer.MAX_VALUE;
            String res = "";
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < t.length(); i++){
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            }
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    list.add(new int[]{(int)c, i});
                }
            }
            // 滑动窗口
            int l = 0;
            int r = 0;
            int n = list.size();
            while(r < n){
                int[] tmp = list.get(r); // 右边界对应的值
                int[] ltmp = list.get(l); // 左边界对应的值
                map.put((char)tmp[0], map.get((char)tmp[0]) + 1);
                r++;
                while(check(map)){
                    if(min > tmp[1] - ltmp[1] + 1){
                        // 更新最小值和res
                        min = tmp[1] - ltmp[1] + 1;
                        res = s.substring(ltmp[1], tmp[1] + 1);
                    }
                    // 左边界右移一格
                    map.put((char)ltmp[0], map.get((char)ltmp[0]) - 1);
                    // 更新左边界
                    ltmp = list.get(++l);
                }
            }
            return res;
        }
        private static boolean check(Map<Character, Integer> map){
            for(char key : map.keySet()){
                if(map.get(key) < 0)return false;
            }
            return true;
        }
    }
}