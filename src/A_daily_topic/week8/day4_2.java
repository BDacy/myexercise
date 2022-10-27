package A_daily_topic.week8;

import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-27  17:08
 * @Description:
 *          剑指 Offer II 100. 三角形中最小路径之和
 *          https://leetcode.cn/problems/IlPe0q/
 */
public class day4_2 {
//    class Solution {
//        List<List<Integer>> triangle;
//        public int minimumTotal(List<List<Integer>> triangle) {
//            this.triangle = triangle;
//            return dfs(0,0);
//        }
//        public int dfs(int layer,int idx){
//            if (layer == triangle.size()) return 0;
//            List<Integer> list = triangle.get(layer);
//            Integer integer = list.get(idx);
//            return Math.min(dfs(layer+1,idx),dfs(layer+1,idx+1))+integer;
//        }
//    }
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n =triangle.size();
        int [][] value = new int[n][n];
        value[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            value[i][0] = value[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                value[i][j] = Math.min(value[i - 1][j - 1],value[i - 1][j]) + triangle.get(i).get(j);
            }
            value[i][i] = value[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minValue = value[n - 1][0];
        for (int i = 1; i < n; i++) {
            minValue = Math.min(minValue,value[n - 1][i]);
        }
        return minValue;
    }
    }
}