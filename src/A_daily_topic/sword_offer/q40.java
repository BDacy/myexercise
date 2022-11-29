package A_daily_topic.sword_offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-29  09:41
 * @Description:
 */
public class q40 {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length <= k)return arr;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int j : arr) {
                priorityQueue.add(j);
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = priorityQueue.poll();
            }
            return ans;
        }
        public int[] getLeastNumbers1(int[] arr, int k) {
            if (arr.length <= k)return arr;
            Arrays.sort(arr);
            int[] ans = new int[k];
            for(int i=0;i<k;i++){
                ans[i] = arr[i];
            }
            return ans;
        }
    }
}