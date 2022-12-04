package A_daily_topic.week13;

/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-12-04  09:20
 * @Description:
 *          1669. 合并两个链表
 *          https://leetcode.cn/problems/merge-in-between-linked-lists/
 *          1774. 最接近目标价格的甜点成本
 *          https://leetcode.cn/problems/closest-dessert-cost/
 */
public class day7 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode pre = list1;
            ListNode cur = pre;
            for (int i = 0; i < a; i++) {
                pre = cur;
                cur = cur.next;
            }
            // cur继续走b - a 步
            for (int i = 0; i < b - a + 1; i++) {
                cur = cur.next;
            }
            // 拼接list2
            pre.next = list2;
            pre = pre.next;
            while (pre.next != null){
                pre = pre.next;
            }
            pre.next = cur;
            return list1;
        }

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            // 使用动态规划
            boolean[] dp = new boolean[target + 10];
            int ans = Integer.MAX_VALUE;
            for (int baseCost : baseCosts) {
                if (baseCost > target)ans = Math.min(ans, baseCost);
                else dp[baseCost] = true;
            }
            for (int x : toppingCosts) {
                for (int i = 0; i < 2; i++) {// 选两次
                    for (int j = target; j >= 0; j--) {
                        if (dp[j] && j + x > target) ans = Math.min(ans, j + x); //计算大于的情况
                        if (j > x) dp[j] |= dp[j - x];
                    }
                }
            }
            //ans-V:目前获得与target的差距
            for (int i = 0; i <= ans - target && i <= target; i++) if (dp[target - i]) return target - i;
            return ans;
        }
    }
}