package com.ityca.week3;

import java.util.ArrayList;

//1493. 删掉一个元素以后全为 1 的最长子数组
public class demo3 {
    public static void main(String[] args) {
        int [] nums={0,1,0};
        System.out.println(Solution.longestSubarray(nums));
    }
    class Solution {
        public static int longestSubarray(int[] nums) {
//            输入：nums = [0,1,1,1,0,1,1,0,1]
//            输出：5
            //存储零出现的位置
            ArrayList<Integer> list=new ArrayList<>();
            //扫描一遍数组
            if (nums[0]==1)list.add(-1);
            else list.add(0);
            int n=nums.length;
            for (int i=1;i<n;i++){
                if (nums[i]==0)
                    list.add(i);
            }
            if (nums[n-1]==1)list.add(n);
            //0,4,7,9
            //比较操作
            int size=list.size();
            int max=0;
            if (size==2){
                if (nums[0]==0&&nums[n-1]==0)
                    return n-2;
                else
                    return n-1;
            }
            for (int i=0;i<size-2;i++){
                int t=list.get(i+2)-list.get(i);
                if (t>max) {
                    max = t;
                }
            }
            if (max==0)return max;
            return max-2;
        }
    }
}
