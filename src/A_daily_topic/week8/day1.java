package A_daily_topic.week8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-24  16:59
 * @Description:
 *          621. 任务调度器
 *          https://leetcode.cn/problems/task-scheduler/
 */
public class day1 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            //tasks 的任务种类，是大写的字母
            int[] task_nums = new int[26];
            for (int i = 0; i < tasks.length; i++) {
                task_nums[tasks[i]-'A']++;
            }
            //从小到大排序
            Arrays.sort(task_nums);
            //从任务数量最多的任务种类开始的开始
            int time = (task_nums[25]-1)*(n+1)+1;
            for (int i = 24;i >= 0;i--){
                if (task_nums[i] == task_nums[25]) time++;
            }
            return Math.max(tasks.length,time);
        }
    }
}