package com.ityca.test21day;

import java.util.Arrays;

//34. 在排序数组中查找元素的第一个和最后一个位置
public class test1 {
    public static void main(String[] args) {
        int [] nums={1,4};
        int target=4;
        System.out.println(Arrays.toString(Solution.searchRange(nums,target)));
    }
    class Solution {
        public static int[] searchRange(int[] nums, int target) {
            int n=nums.length;
            if (n==0){
                int a[]={-1,-1};
                return a;
            }
            int index=search(nums,target);
            if (index==-1){
                int a[]={-1,-1};
                return a;
            }
            //设置左右指针,寻找与target相同的值返回对应下表
            int left=index-1;
            int right=index+1;
            while (left>=0){
                if (nums[left]!=nums[index])
                {
                    left++;
                    break;
                }

                left--;
            }
            while (right<n){
                if (nums[right]!=nums[index])
                {
                    right--;
                    break;
                }

                right++;
            }
            if (left<0)left=0;
            if (right==n)right=n-1;
            int[] res={left,right};
            return res;
        }

        private static int search(int[] nums, int target) {
            //二分查找target返回第一次查找到的下标
            int n=nums.length;
            int low=0;
            int high=n-1;
            int mid = 0;
            while (low<high){
                mid=(low+high)/2;
                if (nums[mid]<target){
                    low=mid+1;
                }else if(nums[mid]>target){
                    high=mid-1;
                }else {
                    return mid;
                }
            }
            if (nums[low]==target){
                return low;
            }
            return -1;
        }
    }
}
