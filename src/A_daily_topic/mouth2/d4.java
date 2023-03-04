package A_daily_topic.mouth2;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-04  09:18
 * @Description:
 *          982. 按位与为零的三元组
 *          https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
 */
public class d4 {
    class Solution {
        public int countTriplets(int[] nums) {
            int[] cnts = new int[1 << 16];
            for (int k : nums) {
                for (int num : nums) {
                    cnts[k & num]++;
                }
            }

            int res = 0;
            for(int i = 0; i < (1 << 16); i++){
                for (int num : nums) {
                    if ((i & num) == 0) res += cnts[i];
                }
            }
            return res;
        }
    }
}