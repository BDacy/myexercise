package A_daily_topic.sword_offer;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-22  09:52
 * @Description:
 *          剑指 Offer 56 - I. 数组中数字出现的次数
 *          https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/?favorite=xb9nqhhg
 *          剑指 Offer 56 - II. 数组中数字出现的次数 II
 *          https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/?favorite=xb9nqhhg
 */
public class q56 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            // set排重
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)){
                    set.add(num);
                }else {
                    set.remove(num);
                }
            }
            int[] res = new int[2];
            int i = 0;
            for (Integer integer : set) {
                res[i++] = integer;
            }
            return res;
        }
        public int[] singleNumbers1(int[] nums) {
            // 排序
            int[] res = new int[2];
            int idx = 0;
            Arrays.sort(nums);
            int a = 0;
            int b = 1;
            while (b < nums.length){
                if (nums[a] == nums[b]){
                    a += 2;
                    b = a + 1;
                }else {
                    res[idx++] = nums[a];
                    a++;
                    b++;
                }
                if (idx == 2)break;
            }
            if (idx != 2)res[idx] = nums[nums.length - 1];
            return res;
        }

        public int singleNumber(int[] nums) {
            // 还是hashMap好啊
            // k - 数， v - 出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (!map.containsKey(num)){
                    map.put(num, 1);
                }else {
                    map.put(num, map.get(num) + 1);
                    if (map.get(num) == 3)map.remove(num);
                }
            }
            for (Integer x : map.keySet()) {
                return x;
            }
            return -1;
        }
        public int singleNumber1(int[] nums){
            // 排序
            Arrays.sort(nums);
            int a = 0;
            int b = 1;
            int c = 2;
            while (c < nums.length){
                if (nums[a] == nums[b] && nums[a] == nums[c] && nums[b] == nums[c]) {
                    a += 3;
                    b = a + 1;
                    c = b + 1;
                }else return nums[a];
            }
            return -1;
        }
    }
}