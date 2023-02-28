package A_daily_topic.mouth1;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-28  08:41
 * @Description:
 *          2363. 合并相似的物品
 *          https://leetcode.cn/problems/merge-similar-items/
 */
public class d28 {
    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            // 直接遍历 + hash表
            Map<Integer, Integer> map = new HashMap<>();

            for(int[] a : items1)
                map.put(a[0], a[1]);
            for(int[] b : items2){
                map.put(b[0], map.getOrDefault(b[0], 0) + b[1]);
            }
            // 按照key排序
            Set set = map.keySet();
            Object[] arr = set.toArray();
            Arrays.sort(arr);
            List<List<Integer>> res = new ArrayList<>();
            for(Object key : arr){
                int weight = map.get(key);
                List<Integer> tmp = new ArrayList<>();
                tmp.add((int)key);
                tmp.add(weight);
                res.add(tmp);
            }
            return res;
        }
    }
}