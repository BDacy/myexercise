package A_daily_topic.week8;

import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-27  16:24
 * @Description:
 *          1239. 串联字符串的最大长度
 *          https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class day4 {
    class Solution {

        public int maxLength(List<String> arr) {
            int len = arr.size();
            int[] mask = new int[len];
            for (int i = 0; i < mask.length; i++) {
                mask[i] = this.mask(arr.get(i));
            }
            int ans = 0;
            for (int i = 1; i < (1 << len); i++) {
                int cur = 0;
                boolean ok = true;
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) != 0) {
                        if (mask[j] == -1) {
                            ok = false;
                            break;
                        }
                        if ((cur & mask[j]) == 0) {
                            cur |= mask[j];
                        } else {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok)
                    ans = Math.max(ans, Integer.bitCount(cur));
            }
            return ans;
        }

        private int mask(String string) {
            int ans = 0;
            for (int i = 0; i < string.length(); i++) {
                int pos = 1 << (string.charAt(i) - 'a');
                if ((ans & pos) == 0) {
                    ans |= pos;
                } else {
                    return -1;
                }
            }
            return ans;
        }

    }
}