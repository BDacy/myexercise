package A_daily_topic.week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: A_daily_topic.week7
 * @Author: yca
 * @CreateTime: 2022-10-18  14:52
 * @Description:
 *          218. 天际线问题
 *          https://leetcode.cn/problems/the-skyline-problem/
 */
public class day2 {
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>();

            List<int []> ps = new ArrayList<>();
            for (int[] building : buildings) {
                int l = building[0];
                int r = building[1];
                int h = building[2];
                ps.add(new int[]{l,-h});//-h表示左端点
                ps.add(new int[]{r,h});//h表示右边端点
            }
            //进行横坐标排序
            //先左端点再右端点，最后按高度,从小到大
            Collections.sort(ps,(a,b)->{
                if (a[0]!=b[0])return a[0]-b[0];
                else return a[1]-b[1];
            });

            //构造优先队列，大的放在前面
            PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b)->b-a);
            int prev = 0;
            PQ.add(prev);
            for (int[] p : ps) {
                int point = p[0];
                int height = p[1];
                if (height<0){
                    //如果是左端点,说明此边开始向右边延续
                    PQ.add(-height);
                }else {
                    //如果是右端点，说明此边终止
                    PQ.remove(height);
                }
                //取出当前最高点
                Integer peek = PQ.peek();
                if (peek!=prev){
                    List<Integer> list = new ArrayList<>();
                    list.add(point);
                    list.add(peek);
                    ans.add(list);
                    prev = peek;
                }
            }
            return ans;
        }
    }
}