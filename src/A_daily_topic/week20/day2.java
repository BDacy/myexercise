package A_daily_topic.week20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsPackage: A_daily_topic.week20
 * @Author: yca
 * @CreateTime: 2023-01-17  16:11
 * @Description:
 *          150. 逆波兰表达式求值
 *          https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class day2 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            int a = 0;
            int b = 0;
            int c = 0;
            for(String s : tokens){
                switch(s){
                    case "+":
                        stack.addFirst(stack.pollFirst() + stack.pollFirst());
                        break;
                    case "-":
                        b = stack.pollFirst();
                        a = stack.pollFirst();
                        stack.addFirst(a - b);
                        break;
                    case "*":
                        stack.addFirst(stack.pollFirst() * stack.pollFirst());
                        break;
                    case "/":
                        b = stack.pollFirst();
                        a = stack.pollFirst();
                        stack.addFirst(a / b);
                        break;
                    default:
                        stack.addFirst(Integer.valueOf(s));
                        break;
                }
            }
            return stack.pollFirst();
        }


    }
    class Solution1 {
        public int countNicePairs(int[] nums) {
            int mod = (int) (1e9 + 7);
            int n = nums.length;
            // 获取另外一个rev数组并作差得到diff
            int[] diff = new int[n];
            for(int i = 0; i < n; i++){
                int tmp = nums[i];
                int in = 0;
                while(tmp > 0){
                    in *= 10;
                    in += tmp % 10;
                    tmp /= 10;
                }
                diff[i] = nums[i] - in;
            }
            // 排序
            Arrays.sort(diff);
            // 计数
            long cnt = 0;
            int left = 0;
            int right = 0;
            while(right < n){
                if(diff[left] != diff[right]){
                    cnt += count(right - left) % mod;
                    left = right;
                }
                right++;
            }
            if(diff[left] == diff[right - 1])cnt += count(right - left) % mod;
            return (int)(cnt % mod);
        }
        private long count(int x){
            if(x == 0 || x == 1)return 0;
            long res = 1;
            for(int i = 2; i < x;i++){
                res += i;
            }
            return res;
        }
    }
// 13 10 35 24 76
// 31 1  53 42 67
// -18 9  -18 -18 9
// -18 -18 -18 9 9

}