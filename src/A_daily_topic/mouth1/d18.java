package A_daily_topic.mouth1;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-18  14:36
 * @Description:
 *          1237. 找出给定方程的正整数解
 *          https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/
 */
public class d18 {
     // This is the custom function interface.
     // You should not implement it, or speculate about its implementation
     class CustomFunction {
         // Returns f(x, y) for any given positive integers x and y.
         // Note that f(x, y) is increasing with respect to both x and y.
         // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         public int f(int x, int y){
             return 0;
         }
     };


    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int x = 1; x <= 1000; x++) {
                for (int y = 1; y <= 1000; y++) {
                    if (customfunction.f(x, y) == z) {
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(x);
                        pair.add(y);
                        res.add(pair);
                    }
                }
            }
            return res;
        }
    }
}