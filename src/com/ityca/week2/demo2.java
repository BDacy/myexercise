package com.ityca.week2;
//553. 最优除法
public class demo2 {
    public static void main(String[] args) {
        int[] nums={1000,100,10,2};
        System.out.println(Solution.optimalDivision(nums));
    }
    class Solution {
        public static String optimalDivision(int[] nums) {
            //输入: [1000,100,10,2]
            //输出: "1000/(100/10/2)"
            StringBuffer res = new StringBuffer();
            if(nums.length==1){
                res.append(nums[0]);
            }else if (nums.length==2){
                res.append(nums[0]+"/"+nums[1]);
            }else {
                res.append(nums[0]);
                res.append("/(");
                res.append(nums[1]);
                for (int i=2;i<nums.length;i++){
                    res.append("/");
                    res.append(nums[i]);
                }
                res.append(")");
            }
            return res.toString();
        }
    }
}
