package A_daily_topic.week18;

/**
 * @BelongsPackage: A_daily_topic.week18
 * @Author: yca
 * @CreateTime: 2023-01-07  22:46
 * @Description:
 *          260. 只出现一次的数字 III
 *          https://leetcode.cn/problems/single-number-iii/
 *          1658. 将 x 减到 0 的最小操作数
 *          https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class day6 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int tmp = 0;
            for(int num : nums){
                tmp ^= num;
            }
            int k = -1;
            // 得到的tmp是两个只出现一次的数字的异或值
            // 选取异或值为1的任意一位，表明该位两个值不一样
            for(int i = 0; i < 32; i++){
                if(((tmp >> i) & 1) == 1){
                    k = i;
                    break;
                }
            }
            int[] res = new int[2];
            for(int num : nums){
                // 将该位上的分成两组，为0的和为1的，全部异或，筛出那些出现两次的数字
                if(((num >> k) & 1) == 1)res[0] ^= num;
                else res[1] ^= num;
            }
            return res;
        }

        public int minOperations(int[] nums, int x) {
            int target = -x;
            for (int num : nums) target += num;
            if (target < 0) return -1; // 全部移除也无法满足要求
            int ans = -1;
            int left = 0;
            int sum = 0;
            int n = nums.length;
            for (int right = 0; right < n; ++right) {
                sum += nums[right];
                while (sum > target) sum -= nums[left++]; // 缩小子数组长度
                if (sum == target) ans = Math.max(ans, right - left + 1);
            }
            return ans < 0 ? -1 : n - ans;
        }
    }
}