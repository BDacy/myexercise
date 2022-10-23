package A_daily_topic.week6;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week6
 * @Author: yca
 * @CreateTime: 2022-10-14  17:39
 * @Description:
 *          13. 罗马数字转整数
 *          https://leetcode.cn/problems/roman-to-integer/
 */
public class day4 {
    class Solution {
        public int romanToInt(String s) {
//            Map<Character,Integer> map = new HashMap();
//            //记录映射
//            map.put('I',1);
//            map.put('V',5);
//            map.put('X',10);
//            map.put('L',50);
//            map.put('C',100);
//            map.put('D',500);
//            map.put('M',1000);
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
//                res+=map.get(c);
                res+=getValue(c);
                if (i==0)continue;
                if ((c=='V'||c=='X')&&s.charAt(i-1)=='I')res-=2;
                if ((c=='L'||c=='C')&&s.charAt(i-1)=='X')res-=20;
                if ((c=='D'||c=='M')&&s.charAt(i-1)=='C')res-=200;
            }
            return res;
        }
        public int getValue(char c){
            return switch (c) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        }
    }
}