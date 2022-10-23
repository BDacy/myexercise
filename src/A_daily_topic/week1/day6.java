package A_daily_topic.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yca
 * @Date: 2022/09/10/14:12
 * @Description:
 *      347. 前 K 个高频元素
 *      https://leetcode.cn/problems/top-k-frequent-elements/
 *
 *      给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *      输入: nums = [1,1,1,2,2,3], k = 2
 *      输出: [1,2]
 */
public class day6 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            //遍历一边数组，存放到map中，再按value进行排序
            HashMap<Integer,Integer> map=new HashMap();
            for (int num : nums) {
                map.put(num,map.get(num)==null?1:(map.get(num)+1));
            }
            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());
            int[] res =new int[k];
            for (int i = 0; i < k; i++) {
                Map.Entry<Integer, Integer> entry = list.get(list.size() - i - 1);
                res[i]=entry.getKey();
            }
            return res;
        }
    }
}
