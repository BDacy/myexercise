package com.ityca.week5;

import java.util.Arrays;

//34. 在排序数组中查找元素的第一个和最后一个位置
//        给定一个按照升序排列的整数数组 nums，和一个目标值 target。
//        找出给定目标值在数组中的开始位置和结束位置。
//        如果数组中不存在目标值 target，返回 [-1, -1]。
public class demo2 {
//    输入：nums = [5,7,7,8,8,10], target = 8
//    输出：[3,4]
public static void main(String[] args) {
    int[] nums={5,7,7,8,8,10};
    int target=6;
    System.out.println(Arrays.toString(Solution.searchRange(nums,target)));
}
class Solution {
    public static int[]  searchRange(int[] nums, int target) {
        //获取左边界
        int leftBorder = getLeftBorder(nums,target);
        //获取右边界
        int rightBorder = getRightBorder(nums,target);
        //对特殊情况的处理
        //找不到
        if(leftBorder==-2||rightBorder==-2) return new int[]{-1,-1};
        //正常情况
        if (rightBorder-leftBorder>=0)return new int[]{leftBorder,rightBorder};
        //其他
        return new int[]{-1,-1};

    }

    public static int getRightBorder(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int rightBorder=-2;//初始化右边界
        while (left<=right){
            int mid=left+(right-left)/2;//据说这样可以避免溢出
            if (nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
                rightBorder=mid;
            }
        }
        return rightBorder;
    }

    public static int getLeftBorder(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        int leftBorder=-2;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
                leftBorder=mid;
            }
        }
        return leftBorder;
    }
}
}
