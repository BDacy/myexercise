package A_daily_topic.mouth1;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-19  10:12
 * @Description:
 *          第 333 场周赛 好久没打了，试一试
 */
public class week333 {
    class Solution {
//        输入：nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
//        输出：[[1,6],[2,3],[3,2],[4,6]]
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            int l = 0;
            int r = 0;
            List<int[]> list = new ArrayList<>();
            int len1 = nums1.length;
            int len2 = nums2.length;
            while (l < len1 && r < len2){
                if (nums1[l][0] == nums2[r][0]){
                    list.add(new int[]{nums1[l][0], nums1[l][1] + nums2[r][1]});
                    l++;
                    r++;
                }else if (nums1[l][0] < nums2[r][0]){
                    list.add(new int[]{nums1[l][0], nums1[l][1]});
                    l++;
                }else {
                    list.add(new int[]{nums2[r][0], nums2[r][1]});
                    r++;
                }
            }
            if (l == len1){
                while (r < len2){
                    list.add(new int[]{nums2[r][0], nums2[r++][1]});
                }
            }else if (r == len2){
                while (l < len1){
                    list.add(new int[]{nums1[l][0], nums1[l++][1]});
                }
            }
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }
            return res;
        }

        // 无平方子集计数
        // 每次找离他最近的那个？
        public int minOperations(int n) {
            if (n == 0)return 0;
            int t = 0;
            int tmp = n;
            while (tmp > 0){
                tmp /= 2;
                t++;
            }
            int t1 = (int) Math.pow(2, t - 1);
            int t2 = (int) Math.pow(2, t);
            int next = Math.min(n - t1, t2 - n);
            return minOperations(next) + 1;
        }

        public int squareFreeSubsets(int[] nums) {
            int mod = 1000000007;
            HashSet<Integer> set = new HashSet<>();
            set.add(4);
            set.add(8);
            set.add(9);
            set.add(12);
            set.add(16);
            set.add(18);
            set.add(20);
            set.add(24);
            set.add(25);
            set.add(27);
            set.add(28);

            int n = nums.length;
            HashMap<Integer, Long> map = new HashMap<>();
            map.put(0, 1l);
            for(int i = 0; i < n; i++){
                if(set.contains(nums[i])){
                    continue;
                }

                int state = 0;
                int num = nums[i];
                for(int j = 2; j <= nums[i];){
                    if(num % j == 0){
                        state |= (1 << j);
                        num /= j;
                    }
                    else{
                        j++;
                    }
                }

                HashMap<Integer, Long> temp_map = new HashMap<>();
                for(int temp : map.keySet()){
                    if((temp & state) == 0){
                        temp_map.put((temp | state), map.get(temp));
                    }
                }

                for(int temp : temp_map.keySet()){
                    map.put(temp, (map.getOrDefault(temp, 0l) + temp_map.get(temp)) % mod);
                }
            }

            long result = 0;
            for(int temp : map.keySet()){
                result += map.get(temp);
            }

            return (int)((result - 1) % mod);
        }

//        [[4,0,2,0],
//         [0,3,0,1],
//         [2,0,2,0],
//         [0,1,0,1]]

        public int[][] lcp(char[] data) {
            int n = data.length;
            int[][] ans = new int[n + 1][n + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (data[i] != data[j]) {
                        ans[i][j] = ans[j][i] = 0;
                    } else {
                        ans[i][j] = ans[i + 1][j + 1] + 1;
                    }
                }
            }
            return ans;
        }

        public String findTheString(int[][] lcp) {
            int n = lcp.length;
            StringBuilder builder = new StringBuilder();
            char next = 'a';
            for (int i = 0; i < n; i++) {
                int minIndex = -1;
                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] > 0) {
                        minIndex = j;
                        break;
                    }
                }
                if (minIndex >= 0) {
                    builder.append(builder.charAt(minIndex));
                } else {
                    if (next <= 'z') {
                        builder.append(next++);
                    } else {
                        return "";
                    }
                }
            }
            char[] s = builder.toString().toCharArray();
            int[][] eval = lcp(s);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (eval[i][j] != lcp[i][j]) {
                        return "";
                    }
                }
            }
            return builder.toString();
        }
    }
}