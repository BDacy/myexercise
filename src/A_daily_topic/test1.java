package A_daily_topic;

/**
 * @BelongsPackage: A_daily_topic
 * @Author: yca
 * @CreateTime: 2022-11-13  10:17
 * @Description:
 */
public class test1 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int minimumOperations(TreeNode root) {
            return 0;
        }


        //先求两个数的最大公约数（使用辗转相除法）
        public int getMaxCommonDivisor(int a,int b) {
            //定义一个交换站值
            int temp =0;
            while(a%b!=0) {
                temp = a%b;
                a = b;
                b =temp;
            }
            return b;
        }
        //求两个数的最小公倍数（两个数相乘   等于   这两个数的最大公约数和最小公倍数的 积）
        public int getMinCommonMultiple(int a,int b) {
            return a*b/getMaxCommonDivisor(a,b);
        }
        //求多个数的最小公倍数
        public int getMinMultiCommonMultiple(int[] arrays, int low, int high) {
            int val = arrays[low];
            //实现原理：拿前两个数的最小公约数和后一个数比较，求他们的公约数以此来推。。。
            for(int i = low + 1 ;i < high; i++) {
                val = getMinCommonMultiple(val,arrays[i]);
            }
            return val;
        }
        public int subarrayLCM(int[] nums, int k) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (getMinMultiCommonMultiple(nums,j,i) == k)res++;
                }
            }
            return res;
        }
    }
}