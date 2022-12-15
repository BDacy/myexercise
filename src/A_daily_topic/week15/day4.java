package A_daily_topic.week15;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week15
 * @Author: yca
 * @CreateTime: 2022-12-15  10:55
 * @Description:
 *          332. 重新安排行程
 *          https://leetcode.cn/problems/reconstruct-itinerary/
 *          1945. 字符串转化后的各位数字之和
 *          https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 */
public class day4 {
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            // 因为逆序插入，所以用链表
            List<String> ans = new LinkedList<>();

            if (tickets == null || tickets.size() == 0)
                return ans;

            Map<String, PriorityQueue<String>> graph = new HashMap<>();

            for (List<String> pair : tickets) {
                // 因为涉及删除操作，我们用链表
                PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
                nbr.add(pair.get(1));
            }

            // 按目的顶点排序

            visit(graph, "JFK", ans);

            return ans;
        }

        // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
        private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {

            Stack<String> stack = new Stack<>();

            stack.push(src);

            while (!stack.isEmpty()) {
                PriorityQueue<String> nbr;

                while ((nbr = graph.get(stack.peek())) != null &&
                        nbr.size() > 0) {
                    stack.push(nbr.poll());
                }
                ans.add(0, stack.pop());
            }
        }

        public int getLucky(String s, int k) {
            int sum = 0;
            // 第一次转换
            for(int i = 0; i < s.length(); i++){
                int a = s.charAt(i) - 'a' + 1;
                if(a >= 10){
                    sum += a % 10;
                    sum += a / 10;
                }else sum += a;
            }
            for(int i = 1; i < k; i++){
                int tmp = 0;
                while(sum > 0){
                    int a = sum % 10;
                    tmp += a;
                    sum /= 10;
                }
                sum = tmp;
            }
            return sum;
        }
    }
}