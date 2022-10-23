package com.ityca.day1;
//2016. 增量元素之间的最大差值
public class demo8 {
    public static void main(String[] args) {
        int []nums={7,1,5,4};
        System.out.println(Solution.maximumDifference(nums));
    }
    class Solution {
        public static int maximumDifference(int[] nums) {
            int max=-1;//设置最大差值
            int temp=0;
            int a=nums[0];
            for(int i=1;i<nums.length;i++){
                if (nums[i]>a){
                    temp=nums[i]-a;
                    if (temp>max){
                        max=temp;
                    }
                }else
                    a=nums[i];
            }
            return max;
        }
    }
}
