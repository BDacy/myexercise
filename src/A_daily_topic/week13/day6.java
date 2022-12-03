package A_daily_topic.week13;

/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-12-03  18:49
 * @Description:
 *          1796. 字符串中第二大的数字
 *          https://leetcode.cn/problems/second-largest-digit-in-a-string/
 *          321. 拼接最大数
 *          https://leetcode.cn/problems/create-maximum-number/
 */
public class day6 {
    class Solution {
        public int secondHighest(String s) {
            int first = -1;
            int second = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c <= '9' && c >= '0'){
                    if (first < c - '0'){
                        second = first;
                        first = c - '0';
                    }else if (second <= c - '0' && c - '0' != first){
                        second = c - '0';
                    }
                }
            }
            return second;
        }

//        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//            // 单调栈
//
//        }
//    }
    }
}