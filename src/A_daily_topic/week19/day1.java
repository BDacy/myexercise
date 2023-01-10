package A_daily_topic.week19;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-09  11:04
 * @Description:
 *          1806. 还原排列的最少操作步数
 *          https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 *          1631. 最小体力消耗路径
 *          https://leetcode.cn/problems/path-with-minimum-effort/
 */
public class day1 {
    // 使用并查集解决
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int idx = i * n + j;
                    if (i > 0)
                        edges.add(new int[]{idx - n, idx, Math.abs(heights[i - 1][j] - heights[i][j])});
                    if (j > 0)
                        edges.add(new int[]{idx - 1,idx, Math.abs(heights[i][j - 1] - heights[i][j])});
                }
            }
            // 排序，小的在前面
            edges.sort(new Comparator<int[]>() {
                public int compare(int[] edge1, int[] edge2) {
                    return edge1[2] - edge2[2];
                }
            });
            UnionFind uf = new UnionFind(m * n);
            int ans = 0;
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                int val = edge[2];
                uf.union(x, y);
                if (uf.connected(0, m * n - 1))return val;
            }
            return ans;
        }

        // 并查集模板？
        class UnionFind{
            int[] parent; // i的父节点
            int[] size; // 以i为根节点的集合数量
            int setCnt; // 连通量
            int n; // 节点的数量

            public UnionFind(int n) {
                this.parent = new int[n];
                this.size = new int[n];
                this.setCnt = n;
                this.n = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            // 查找 x 的父辈根节点
            public int find(int x){
                return parent[x] == x ? x : find(parent[x]);
            }

            /**
             * 连接 x 和 y节点
             * @param x -
             * @param y -
             * @return 如果x 和 y本身在一个集合不需要合并，则return fasle,如果不在一个集合进行合并，return true
             */
            public boolean union(int x, int y){
                int px = find(x);
                int py = find(y);
                if (px == py)return false;
                // 往集合更大的根节点合并
                if (size[px] < size[py]){
                    int tmp = px;
                    px = py;
                    py = tmp;
                }
                parent[py] = px;
                size[px] += size[py];
                setCnt--;
                return true;
            }

            /**
             *  x 与 y节点是否属于同一集合
             * @param x
             * @param y
             * @return
             */
            public boolean connected(int x, int y){
                x = find(x);
                y = find(y);
                return x == y;
            }
        }

        public int reinitializePermutation(int n) {
            if (n == 2) {
                return 1;
            }
            int step = 1, pow2 = 2;
            while (pow2 != 1) {
                step++;
                pow2 = pow2 * 2 % (n - 1);
            }
            return step;
        }

        // 模拟
        public int reinitializePermutation1(int n) {
            int[] cur = new int[n];
            int res = 0;
            for(int i = 0; i < n; i++){
                cur[i] = i;
            }
            while(true){
                int[] arr = new int[n];
                for(int i = 0; i < n; i++){
                    if(i % 2 == 0){
                        arr[i] = cur[i / 2];
                    }else{
                        arr[i] = cur[n / 2 + (i - 1) / 2];
                    }
                }
                cur = arr;
                res++;
                boolean flag = true;
                for(int i = 0; i < n; i++){
                    if(cur[i] != i){
                        flag = false;
                        break;
                    }
                }
                if(flag)break;
            }
            return res;
        }
    }
}