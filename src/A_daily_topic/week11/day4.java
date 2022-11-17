package A_daily_topic.week11;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-17  16:24
 * @Description:
 *          18. 四数之和
 *          https://leetcode.cn/problems/4sum/
 *          792. 匹配子序列的单词数
 *          https://leetcode.cn/problems/number-of-matching-subsequences/
 */
public class day4 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        int target = 1000000000;

        System.out.println(Solution.fourSum(nums,target));
    }
    class Solution {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            //如果数组长度小于4，则直接返回空
            if (nums.length < 4)return ans;

            // 从小到大排序
            Arrays.sort(nums);
            int length = nums.length;
            //确定第一个数
            for (int a = 0; a < length - 3; a++) {
                // 如果和前一个数相同则忽略
                if (a > 0 && nums[a] == nums[a - 1])continue;
                // 获取当前的最小值
                long min1 = (long)nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3];
                // target比最小值还小则跳过
                if (min1 > target)break;
                // 获取最大值
                long max1 = (long) nums[a] + nums[length - 3] + nums[length - 2] + nums[length - 1];
                // target比最大值还大则跳过
                if (max1 < target)continue;
                // 确定第二个数
                for (int b = a + 1; b < length - 2; b++) {
                    // 如果和前一个数相同则忽略
                    if ( b > a + 1 && nums[b] == nums[b - 1])continue;
                    // 最小值判断
                    long min2 = (long)nums[a] + nums[b] + nums[b + 1] +nums[b + 2];
                    if (min2 > target)break;

                    // 获取当前最大值
                    long max2 = (long)nums[a] + nums[b] + nums[length - 2] + nums[length - 1];
                    if (max2 < target)continue;

                    // 确定接下来的两个数 c d
                    int c = b + 1, d = length - 1;
                    while (c < d){
                        long cur = (long)nums[a] + nums[b] + nums[c] + nums[d];
                        if (cur == target){
                            ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                            c++;
                            d--;
                            while (c < d && nums[c] == nums[c - 1])c++;
                            while (c < d && nums[d] == nums[d + 1])d--;
                        }else if (cur > target) d--;
                        else c++;
                    }
                }
            }
            return ans;
        }

        public int numMatchingSubseq(String s, String[] words) {
            int ans = 0;
            // 对s字符串进行处理
            // k - 字符， v - 字符下标列表，递增
            Map<Character,List<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                }
                List<Integer> list = map.get(c);
                list.add(i);
            }
            // 对words中的每个word依次处理
            for (String word : words) {
                int length = word.length();
                if (length > s.length())continue;
                int minIdx = -1;
                boolean ok = true;
                int i;
                for (i = 0; i < length; i++) {
                    char c = word.charAt(i);
                    if (!map.containsKey(c)){
                        ok = false;
                        break;
                    }
                    List<Integer> list = map.get(c);
                    int l = 0;
                    int r = list.size() - 1;
                    while (l < r){
                        int mid = l + r >> 1;
                        if (list.get(mid) > minIdx)r = mid;
                        else l = mid + 1;
                    }
                    if (r < 0 || list.get(r) <= minIdx){
                        ok = false;
                        break;
                    }else minIdx = list.get(r);
                }
                if (ok)ans++;
            }
            return ans;
        }
    }
}