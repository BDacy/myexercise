package com.ityca.week5;
//27. 移除元素
public class demo5 {
    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println(Solution.removeElement(nums,val));
    }
    class Solution {
        public static int removeElement(int[] nums, int val) {
            //双指针法，快慢指针
            int low=0;
            int fast=0;
            int n=nums.length;
            while (fast<n){
                if (nums[fast]!=val){
                    nums[low]=nums[fast];
                    low++;
                }
                fast++;
            }
            return low;
        }
    }
}
