package A_daily_topic.week12;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-24  18:50
 * @Description:
 *          1603. 设计停车系统
 *          https://leetcode.cn/problems/design-parking-system/
 *          795. 区间子数组个数
 *          https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 */
public class day4 {
    class ParkingSystem {
        private int big;
        private int medium;
        private int small;
        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && big > 0){
                big--;
                return true;
            }
            else if (carType == 2 && medium > 0){
                medium--;
                return true;
            }else if (carType == 3 && small > 0){
                small--;
                return true;
            }else return false;
        }
    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, ans = 0, start = -1, last = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > right) start = i;
            if (nums[i] >= left) last = i;
            ans += last - start;
        }
        return ans;
    }
    public int numSubarrayBoundedMax1(int[] nums, int left, int right){
        int n = nums.length;
        int ans = 0;
        for (int i = 0, j = -1, k = -1; i < n; i++) {
            if (nums[i] > right) k = i;
            else if (nums[i] < left){
                if (j > k) ans += j - k;
            }else {
                j = i;
                ans += j - k;
            }
        }
        return ans;
    }
}



}