package A_daily_topic.mouth1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-20  09:47
 * @Description:
 *          2347. 最好的扑克手牌
 *          https://leetcode.cn/problems/best-poker-hand/
 *          17. 电话号码的字母组合
 *          https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 */
public class d20 {
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            // 四种情况从好到坏依次判断
            // 1. Flush
            boolean flag1 = true;
            char start = suits[0];
            for(int i = 1; i < 5; i++){
                if(start != suits[i]){
                    flag1 = false;
                    break;
                }
            }
            if(flag1)return "Flush";

            // 2. Three of a Kind or Pair or "High Card"
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < 5; i++){
                map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
            }
            int max = 0;
            for(int key : map.keySet()){
                int cnt = map.get(key);
                max = Math.max(max, cnt);
            }

            if(max >= 3)return "Three of a Kind";
            else if(max == 2)return "Pair";
            else return "High Card";


        }

        Map<Integer, char[]> map;
        public List<String> letterCombinations(String digits) {
            if(digits.length() == 0)return new ArrayList<String>();
            // 初始化
            map = new HashMap<>();
            char cur = 'a';
            for(int i = 2; i <= 9; i++){
                int size = 3;
                if(i == 7 || i == 9)size = 4;
                char[] tmp = new char[size];
                for(int j = 0; j < size; j++){
                    tmp[j] = cur++;
                }
                map.put(i, tmp);
            }

            List<String> res = new ArrayList<>();
            dfs(res, digits, 0, "");
            return res;
        }
        private void dfs(List<String> res, String digits, int idx, String cur){
            if(idx == digits.length()){
                res.add(cur);
                return;
            }
            int key = (int)(digits.charAt(idx) - '0');
            char[] chars = map.get(key);
            for(char c : chars){
                dfs(res, digits, idx + 1, cur + c);
            }
        }


    }
}