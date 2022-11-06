package A_daily_topic.week9;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-11-06  09:05
 * @Description:
 *          241. 为运算表达式设计优先级
 *          https://leetcode.cn/problems/different-ways-to-add-parentheses/
 *          1678. 设计 Goal 解析器
 *          https://leetcode.cn/problems/goal-parser-interpretation/
 *          1920. 基于排列构建数组
 *          https://leetcode.cn/problems/build-array-from-permutation/
 */
public class day7 {
    class Solution {
        char[] chars;
        public List<Integer> diffWaysToCompute(String expression) {
            chars = expression.toCharArray();
            return dfs(0,chars.length - 1);
        }
        public List<Integer> dfs(int l, int r){
            List<Integer> res  = new ArrayList<>();
            for (int i = l;i <= r;i++){
                if (chars[i] <= '9' && chars[i] >= '0')continue;
                else {
                    List<Integer> l1 = dfs(l,i - 1);
                    List<Integer> r1 = dfs(i + 1,r);
                    for (Integer a : l1) {
                        for (Integer b : r1) {
                            int cur = 0;
                            if (chars[i] == '+')cur = a + b;
                            else if (chars[i] == '-')cur = a - b;
                            else cur = a * b;
                            res.add(cur);
                        }
                    }
                }
            }
            if (res.isEmpty()){
                int sum = 0;
                for (int i = l; i <= r; i++) sum = sum * 10 +chars[i] - '0';
                res.add(sum);
            }
            return res;
        }

        public String interpret(String command) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'G')sb.append('G');
                else if (command.charAt(i) == '('
                        && command.charAt(i + 1) == ')'){
                    sb.append('o');
                    i++;
                }
                else {
                    sb.append("al");
                    i += 3;
                }
            }
            return sb.toString();
        }

        public int[] buildArray(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0;i < nums.length;i++){
                res[i] = nums[nums[i]];
            }
            return res;
        }
    }
}