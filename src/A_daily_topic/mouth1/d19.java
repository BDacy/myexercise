package A_daily_topic.mouth1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-19  09:55
 * @Description:
 *          1792. 最大平均通过率
 *          https://leetcode.cn/problems/maximum-average-pass-ratio/
 */
public class d19 {
    class Solution {
        // 优先队列
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> {
                double t1 = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
                double t2 = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
                return t2 > t1 ? 1 : -1;
            });
            for (int[] a : classes) {
                queue.offer(new double[]{a[0], a[1]});
            }
            for (int i = 0; i < extraStudents; i++) {
                double[] poll = queue.poll();
                poll[0] += 1;
                poll[1] += 1;
                queue.offer(new double[]{poll[0], poll[1]});
            }

            double ans = 0;
            for (double[] aClass : queue){
                ans += aClass[0] / aClass[1];
            }
            return ans / classes.length;
        }
    }
}