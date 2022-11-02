package A_daily_topic.week9;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-11-02  19:05
 * @Description:
 *          面试题 10.01. 合并排序的数组
 *          https://leetcode.cn/problems/sorted-merge-lcci/
 *          1620. 网络信号最好的坐标
 *          https://leetcode.cn/problems/coordinate-with-maximum-network-quality/
 */
public class day3 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            if (B.length == 0) return;
            if (A.length == B.length)
                for (int i = 0; i < n; i++)
                    A[i] = B[i];
            int a = m - 1;
            int b = n - 1;
            for (int i = m + n - 1; i >= 0; i--) {
                if (a == -1||b == -1)break;
                if (A[a] > B[b]){
                    A[i] = A[a];
                    a--;
                }else {
                    A[i] = B[b];
                    b--;
                }
            }
            if (a == -1) for (int i = 0; i <= b; i++) A[i] = B[i];
        }

        public int[] bestCoordinate(int[][] towers, int k) {
            int[][] g = new int[110][110];
            int x = 0, y = 0, val = 0;
            for (int[] t : towers) {
                int a = t[0], b = t[1], q = t[2];
                for (int i = Math.max(0, a - k); i <= a + k; i++) {
                    for (int j = Math.max(0, b - k); j <= b + k; j++) {
                        double d = Math.sqrt((a - i) * (a - i) + (b - j) * (b - j));
                        if (d > k) continue;
                        g[i][j] += Math.floor(q / (1 + d));
                        if (g[i][j] > val) {
                            x = i; y = j; val = g[i][j];
                        } else if (g[i][j] == val && (i < x || (i == x && j < y))) {
                            x = i; y = j;
                        }
                    }
                }
            }
            return new int[]{x, y};
        }
    }
}