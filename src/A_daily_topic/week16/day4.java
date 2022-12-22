package A_daily_topic.week16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week16
 * @Author: yca
 * @CreateTime: 2022-12-22  08:29
 * @Description:
 *          1319. 连通网络的操作次数
 *          https://leetcode.cn/problems/number-of-operations-to-make-network-connected/
 *          1799. N 次操作后的最大分数和
 *          https://leetcode.cn/problems/maximize-score-after-n-operations/
 */
public class day4 {
    class Solution {
        Map<Integer, List<Integer>> map;
        boolean[] used;
        public int makeConnected(int n, int[][] connections) {
            // 深度优先搜索
            if (connections.length < n - 1)return -1;
            // 构图
            // k - 节点号，v - 该节点连的节点列表，表示边
            this.map = new HashMap<>();
            for (int[] connection : connections) {
                List<Integer> list = map.getOrDefault(connection[0], new ArrayList<>());
                list.add(connection[1]);
                map.put(connection[0], list);

                List<Integer> list1 = map.getOrDefault(connection[1], new ArrayList<>());
                list1.add(connection[0]);
                map.put(connection[1], list1);
            }
            this.used = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]){
                    dfs(i);
                    ans++;
                }
            }
            return ans - 1;
        }
        private void dfs(int x){
            used[x] = true;
            List<Integer> list = map.getOrDefault(x, new ArrayList<>());
            for (Integer node : list) {
                if (!used[node]){
                    dfs(node);
                }
            }

        }
    }
}