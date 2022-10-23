package com.ityca.week2;
//2104.子数组之和
public class demo10 {
    class Solution {
        public long subArrayRanges(int[] nums) {
            int n=nums.length;
            long res=0;
            //i为左指针，j为右指针
            for (int i=0;i<n;i++){
                //设置子数组的最大和最小值
                long max=Long.MIN_VALUE;
                long min=Long.MAX_VALUE;
                for (int j=i;j<n;j++){
                    max=Math.max(max,nums[j]);
                    min=Math.min(min,nums[j]);
                    res+=max-min;
                }
            }
            return res;
        }
    }
}
