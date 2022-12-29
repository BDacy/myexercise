package A_daily_topic.week17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2022-12-29  13:58
 * @Description:
 *          166. 分数到小数
 *          https://leetcode.cn/problems/fraction-to-recurring-decimal/
 *          2032. 至少在两个数组中出现的值
 *          https://leetcode.cn/problems/two-out-of-three/
 */
public class day4 {
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if(numerator == 0)return "0";
            boolean flag = false;
            long numerator1 = numerator;
            long denominator1 = denominator;
            if (numerator1 < 0){
                numerator1 = -numerator1;
                flag = true;
            }
            if (denominator1 < 0){
                denominator1 = -denominator1;
                flag = !flag;
            }
            StringBuilder res = new StringBuilder();
            // 获取整数部分
            res.append(numerator1 / denominator1);
            if (numerator1 % denominator1 == 0){
                if (flag)res.insert(0, '-');
                return res.toString();
            }
            res.append('.');
            long a = numerator1 % denominator1;
            // k - 数字， V - 索引
            Map<Long, Integer> map = new HashMap<>();
            List<Long> list = new ArrayList<>();

            while (a != 0){
                if (map.containsKey(a)){
                    int idx = map.get(a);
                    res.insert(res.length() - list.size() + idx, '(');
                    res.append(')');
                    break;
                }
                list.add(a);
                map.put(a, list.size() - 1);
                a *= 10;
                res.append(a / denominator1);
                a = a % denominator1;
            }
            if (flag)res.insert(0, '-');
            return res.toString();
        }

        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] nums = new int[101];
            for (int i : nums1) {
                nums[i] |= 1;
            }
            for (int i : nums2) {
                nums[i] |= 1 << 1;
            }
            for (int i : nums3) {
                nums[i] |= 1 << 2;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == 7 || num == 6 || num == 5 || num == 3)
                    res.add(i);
            }
            return res;
        }
    }
}