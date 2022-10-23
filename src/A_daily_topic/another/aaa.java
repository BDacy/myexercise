package A_daily_topic.another;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yca
 * @Date: 2022/09/27/9:59
 * @Description:
 */
public class aaa {
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            Map<Character,Integer> map = new HashMap<>();
            if (s1.length()!=s2.length())return false;
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                map.put(c,map.get(c)==null?1:map.get(c)+1);
            }
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                if (!map.containsKey(c))return false;
                map.put(c,map.get(c)-1);
                if (map.get(c)==0)map.remove(c);
            }
            return true;
        }
    }
}
