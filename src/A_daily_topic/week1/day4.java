package A_daily_topic.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: yca
 * @Date: 2022/09/08/9:59
 * @Description:
 *          205. 同构字符串
 *          https://leetcode.cn/problems/isomorphic-strings/
 *  题目详情：
 *      给定两个字符串 s 和 t ，判断它们是否是同构的。
 *      如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 *      每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 *      不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class day4 {
    public static void main(String[] args) {

    }
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            //如果字符串的长度不同，则不同构
            if (s.length()!=t.length())
                return false;
            //用来存储映射关系
            HashMap<Character,Character> map=new HashMap<>();
            //存储被映射的字符
            List<Character> list=new ArrayList<>();

            //遍历字符串
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            for (int i = 0; i < schars.length; i++) {
                char a = schars[i];
                char b = tchars[i];
                Character character = map.get(a);
                if (character==null){
                    if (list.contains(b))return false;
                    map.put(a,b);
                    list.add(b);
                }else if (character!=b)
                    return false;
            }
            return true;
        }
    }
}
