package com.ityca.day1;


import java.util.Arrays;

//912. 排序数组
//编写快速排序算法，要求升序
public class demo3 {
    public static void main(String[] args) {
        int[] nums={5,2,3,1};
//        int[] nums={2,34,1,5,22,0,4,6,0};
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
        nums=Solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
    class Solution {
        public static int[] sortArray(int[] nums) {

            return nums = Quicksort(nums, 0, nums.length - 1);
        }

        public static int[] Quicksort(int[] nums,int left,int right) {
            int length=right-left+1;
            if (length<2)return nums;
            //记忆左右边界
            int low=left;
            int high=right;
            //记录最左边的数
            int temp=nums[left];
            int flag=1;//1为right，0为left
            while (left<right){
                if (flag==1){
                    if (nums[right]>temp)
                        right--;
                    else {
                        nums[left++]=nums[right];
                        flag=0;
                        continue;
                    }
                }
                else {
                    if(nums[left]<=temp)
                        left++;
                    else
                    {
                        nums[right--]=nums[left];
                        flag=1;
                    }
                    continue;
                }
            }
            nums[left]=temp;
            Quicksort(nums,low,left-1);
            Quicksort(nums,left+1,high);
            return nums;
        }
    }
}
