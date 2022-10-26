package A_daily_topic.week8;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-26  17:50
 * @Description:
 *          862. 和至少为 K 的最短子数组
 *          https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 */
public class day3_1 {
    public static void main(String[] args) {
        int[] nums = {17985,-36292,-23941,80618,20594,-6181,9181,65796,-25716,66593,-6873,34062,29878,852,-4767,-36415,11783,8085,-41063,-39940,74284,66272,82385,51634,-48550,9028,-30777,86509,44623,9413,-38369,-1822,46408,35217,72635,-16560,85373,52105,39477,3852,45974,-21593,15481,47280,73889,-42981,54978,95169,-19615,93133,387303};
        System.out.println(Solution.shortestSubarray(nums,387303));
    }
    //非正确答案
    class Solution {
        public static int shortestSubarray(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            int[] pre_sum = new int[nums.length+1];
            int min_res =  2 * nums.length;
            pre_sum[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                pre_sum[i+1] = pre_sum[i] + nums[i];
            }
            for (int i = 0; i < pre_sum.length; i++) {
                for (int j = i - 1; j >= 0 ; j--) {
                    if (set.contains(j))break;
                    if (pre_sum[i] - pre_sum[j] >= k){
                        if (i - j < min_res){
                            set.add(j);
                            min_res = i-j;
                            break;
                        }
                    }
                }
            }
            if (min_res == 2*nums.length)return -1;
            return min_res;
        }
    }
}