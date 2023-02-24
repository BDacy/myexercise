package A_daily_topic.mouth1;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-23  09:18
 * @Description:
 *          1238. 循环码排列
 *          https://leetcode.cn/problems/circular-permutation-in-binary-representation/
 */
public class d23 {
    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < 1 << n; i++) {
                ret.add((i >> 1) ^ i ^ start);
            }
            return ret;
        }
    }
}