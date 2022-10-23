package A_daily_topic.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yca
 * @Date: 2022/09/27/10:10
 * @Description:
 */
public class day2 {
    class Solution {
        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int counter = 0;
            map.put(counter, -1);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num == 1) {
                    counter++;
                } else {
                    counter--;
                }
                if (map.containsKey(counter)) {
                    int prevIndex = map.get(counter);
                    maxLength = Math.max(maxLength, i - prevIndex);
                } else {
                    map.put(counter, i);
                }
            }
            return maxLength;
        }
    }

}
