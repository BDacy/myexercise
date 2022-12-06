package A_daily_topic.week14;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week14
 * @Author: yca
 * @CreateTime: 2022-12-06  10:01
 * @Description:
 *          210. 课程表 II
 *          https://leetcode.cn/problems/course-schedule-ii/
 *          1805. 字符串中不同整数的数目
 *
 */
public class day2 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses == 0) {
                return new int[0];
            }
            int[] inVal = new int[numCourses];//入度
            for (int[] prerequisite : prerequisites) {
                inVal[prerequisite[0]]++;
            }
            Queue<Integer> deque = new ArrayDeque<>();//添加入度为0的节点
            // 找出入度为0的节点放入
            for (int i = 0; i < inVal.length; i++) {
                if (inVal[i] == 0)deque.offer(i);//插入队尾
            }
            int count = 0;//记录可以学习课程数量
            int[] res = new int[numCourses];
            while (!deque.isEmpty()){
                int poll = deque.poll();//取出队首
                res[count++] = poll;
                //对应的入度减1
                for (int[] prerequisite : prerequisites) {
                    if (prerequisite[1] == poll) {
                        inVal[prerequisite[0]]--;
                        if (inVal[prerequisite[0]] == 0) deque.offer(prerequisite[0]);
                    }
                }
            }
            if (count == numCourses)return res;
            return new int[0];
        }

        public int numDifferentIntegers(String word) {
            Set<String> set = new HashSet<String>();
            int n = word.length(), p1 = 0, p2;
            while (true) {
                while (p1 < n && !Character.isDigit(word.charAt(p1))) {
                    p1++;
                }
                if (p1 == n) {
                    break;
                }
                p2 = p1;
                while (p2 < n && Character.isDigit(word.charAt(p2))) {
                    p2++;
                }
                while (p2 - p1 > 1 && word.charAt(p1) == '0') { // 去除前导 0
                    p1++;
                }
                set.add(word.substring(p1, p2));
                p1 = p2;
            }
            return set.size();
        }
    }
}