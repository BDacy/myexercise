package A_daily_topic.week13;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-11-30  10:18
 * @Description:
 *          313. 超级丑数
 *          https://leetcode.cn/problems/super-ugly-number/
 *          895. 最大频率栈
 *          https://leetcode.cn/problems/maximum-frequency-stack/
 */
public class day3 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(1);
            int idx = 0;
            while (n-- > 0){
                Integer poll = priorityQueue.poll();
                if (n == 0)return poll;
                for (int prime : primes) {
                    if (prime <= Integer.MAX_VALUE / poll)priorityQueue.add(poll * prime);
                    if (poll % prime == 0) break;
                }
            }
            return -1;
        }
    }
    class FreqStack {
        Map<Integer, Integer> cnts;// k - data，V - 次数
        Map<Integer,List<Integer>> buckets;// K - 次数， V - 该次数下有哪些data
        int max;//当前最大出现频率次数
        public FreqStack() {
            cnts = new HashMap<>();
            buckets = new HashMap<>();
            max = 0;
        }

        public void push(int val) {
            cnts.put(val,cnts.getOrDefault(val,0) + 1);
            int c = cnts.get(val);
            List<Integer> list = buckets.getOrDefault(c, new ArrayList<>());
            list.add(val);
            buckets.put(c,list);
            max = Math.max(max,cnts.get(val));
        }

        public int pop() {
            List<Integer> list = buckets.get(max);
            Integer ans = list.remove(list.size() - 1);
            if (list.size() == 0)max--;
            cnts.put(ans,cnts.get(ans) - 1);
            return ans;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}