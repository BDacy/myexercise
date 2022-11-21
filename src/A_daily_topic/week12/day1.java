package A_daily_topic.week12;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-21  10:18
 * @Description:
 *          154. 寻找旋转排序数组中的最小值 II
 *          https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 *          808. 分汤
 *          https://leetcode.cn/problems/soup-servings/
 */
public class day1 {
    class Solution {
        public int findMin(int[] nums) {
            // 利用二分查找
            int length = nums.length;
            int l = 0;
            int r = length - 1;
            while (l < r){
                int mid = l + r >> 1;
                if (nums[r] < nums[mid]){
                    l = mid + 1;
                }else if (nums[mid] < nums[r])
                    r = mid;
                else r--;
            }
            return nums[l];
        }

        // f[a][b] 表示分到（a,b）时的概率
        double[][] f = new double[200][200];
        public double soupServings(int n) {
            // 25ml一份，转化成份数
            n = (n + 24)/25;
            return n > 4801 ? 1 : dfs(n, n);
        }
        public double dfs(int a, int b){
            if (a <= 0 && b <= 0)return 0.5;
            if (a <= 0) return 1;
            if (b <= 0) return 0;
            if (f[a][b] > 0)return f[a][b];
            double ans = 0.25 * (dfs(a - 4,b) + dfs(a - 3, b - 1)
                                    + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
            f[a][b] = ans;
            return ans;
        }
    }
}