package A_daily_topic.week1;

import java.util.Arrays;

/**
 * @Auther: yca
 * @Date: 2022/09/09/9:07
 * @Description:
 *          179. 最大数
 *          https://leetcode.cn/problems/largest-number/
 *          给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *          注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class day5 {
    public static void main(String[] args) {

    }
    class Solution {
        public String largestNumber(int[] nums) {
            /*
            输入：nums = [10,2]
            输出："210"
             */
            //算法要点：如果拼接结果 ab 要比 ba 好，那么我们会认为 a 应该放在 b 前面。
            int length = nums.length;
            String[] ss = new String[length];
            for (int i = 0; i < length; i++) {
                ss[i] = "" + nums[i];
            }
            //将ss[]进行排序
            Arrays.sort(ss,(a,b)->{
                String sa = a+b;
                String sb = b+a;
                return sb.compareTo(sa);
            });
            //打印输出
            StringBuilder result = new StringBuilder();
            for (String s : ss) {
                result.append(s);
            }
            if (ss[0].equals("0"))return "0";
            return result.toString();

        }
    }
}
