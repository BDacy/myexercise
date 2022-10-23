package A_daily_topic.week6;

import java.util.List;

/**
 * @BelongsProject: Javasepro
 * @BelongsPackage: A_daily_topic.week6
 * @Author: yca
 * @CreateTime: 2022-10-14  17:24
 * @Description:
 *          238. 除自身以外数组的乘积
 *          https://leetcode.cn/problems/product-of-array-except-self/
 */
public class day5 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            //左右乘积列表
            int length = nums.length;
            int[] L = new int[length];
            int[] R = new int[length];
            int[] res = new int[length];
            //填充左右乘积列表
            int tmp = 1;
            for (int i = 0; i < length; i++) {
                L[i] = tmp;
                tmp *= nums[i];
            }
            tmp = 1;
            for (int i = length-1; i >= 0; i--){
                R[i] = tmp;
                tmp *= nums[i];
            }
            //计算结果
            for (int i = 0; i < length; i++) {
                res[i] = L[i]*R[i];
            }
            return res;
        }
    }
}