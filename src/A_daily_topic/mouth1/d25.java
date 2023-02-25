package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-25  10:05
 * @Description:
 *          1247. 交换字符使得字符串相同
 *          https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
 */
public class d25 {
    class Solution {
        public int minimumSwap(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            int xy = 0;
            int yx = 0;
            if(len1 != len2)return -1;
            for(int i = 0; i < len1; i++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if(c1 == 'x' && c2 == 'y')xy++;
                else if(c1 == 'y' && c2 == 'x')yx++;
            }
            if((xy + yx) % 2 == 1)return -1;
            int res = 0;
            res += xy / 2 + yx / 2 + xy % 2 + yx % 2;
            return res;
        }
    }
}