package A_daily_topic.week10;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week10
 * @Author: yca
 * @CreateTime: 2022-11-10  09:16
 * @Description:
 *          864. 获取所有钥匙的最短路径
 *          https://leetcode.cn/problems/shortest-path-to-get-all-keys/
 *          1813. 句子相似性 III
 *          https://leetcode.cn/problems/sentence-similarity-iii/
 */
public class day4 {
    class Solution {
        public int arraySign(int[] nums) {
            int a = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)return 0;
                if (nums[i] < 0)
                    a *= -1;
            }
            return a;
        }

        // 三叶姐yyds
        static int N = 35, K = 10, INF = 0x3f3f3f3f;
        static int[][][] dist = new int[N][N][1 << K];
        static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        public int shortestPathAllKeys(String[] g) {
            int n = g.length, m = g[0].length(), cnt = 0;
            Deque<int[]> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Arrays.fill(dist[i][j], INF);
                    char c = g[i].charAt(j);
                    if (c == '@') {
                        d.addLast(new int[]{i, j, 0});
                        dist[i][j][0] = 0;
                    } else if (c >= 'a' && c <= 'z') cnt++;
                }
            }
            while (!d.isEmpty()) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1], cur = info[2], step = dist[x][y][cur];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    char c = g[nx].charAt(ny);
                    if (c == '#') continue;
                    if ((c >= 'A' && c <= 'Z') && (cur >> (c - 'A') & 1) == 0) continue;
                    int ncur = cur;
                    if (c >= 'a' && c <= 'z') ncur |= 1 << (c - 'a');
                    if (ncur == (1 << cnt) - 1) return step + 1;
                    if (step + 1 >= dist[nx][ny][ncur]) continue;
                    dist[nx][ny][ncur] = step + 1;
                    d.addLast(new int[]{nx, ny, ncur});
                }
            }
            return -1;
        }

        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            if (sentence1.length() < sentence2.length())return areSentencesSimilar(sentence2,sentence1);
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            int left = 0;
            int right = 0;
            while (left < s2.length){
                if (!s2[(left)].equals(s1[(left)]))break;
                left++;
            }
            if (left == s2.length)return true;
            while (right < s2.length){
                if (!s2[s2.length - 1 - right].equals(s1[s1.length - 1 -right]))break;
                right++;
            }
            if (right == s2.length)return true;
            return left + right == s2.length;
        }
    }
}