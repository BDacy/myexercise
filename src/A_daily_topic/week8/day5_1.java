package A_daily_topic.week8;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-28  12:50
 * @Description:
 *          907. 子数组的最小值之和
 *          https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class day5_1 {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            //如果正常模拟的话，时间复杂度达到了O(n^3)
            //所以考虑每个元素的贡献
            int len = arr.length;
            int[] l = new int[arr.length];//l[i] 表示arr[i]左边比arr[i]更小的下标
            int[] r = new int[arr.length];//r[i] 表示arr[i]右边比arr[i]更大的下标
            Stack<Integer> stack = new Stack<Integer>();
            Arrays.fill(l,-1);
            Arrays.fill(r,len);
            int res = 0;
            for (int i = 0; i < len; i++) {
                //构造单调递减栈
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                    Integer pop = stack.pop();
                    r[pop] = i;
                }
                stack.add(i);
            }
            stack.clear();
            for (int i = len - 1; i >= 0; i--) {
                //构造单调递增栈
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    Integer pop = stack.pop();
                    l[pop] = i;
                }
                stack.add(i);
            }
            for (int i = 0; i < len; i++) {
                int a = r[i] - i;
                int b = i - l[i];
                res += a * b % (1e9+7) * arr[i] % (1e9+7);
                res %= (1e9+7);
            }
            return res;
        }
    }
}