package A_daily_topic.sword_offer;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  22:08
 * @Description:
 *          面试题45. 把数组排成最小的数
 *          https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class q45 {
    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            quickSort(strs, 0, strs.length - 1);
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }
        void quickSort(String[] strs, int l, int r) {
            if(l >= r) return;
            int i = l, j = r;
            String tmp = strs[i];
            while(i < j) {
                while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
                while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
                tmp = strs[i];
                strs[i] = strs[j];
                strs[j] = tmp;
            }
            strs[i] = strs[l];
            strs[l] = tmp;
            quickSort(strs, l, i - 1);
            quickSort(strs, i + 1, r);
        }
    }
    class Solution1 {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }
    }
}