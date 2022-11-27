package A_daily_topic.weekGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.weekGame
 * @Author: yca
 * @CreateTime: 2022-11-26  22:05
 * @Description:
 */
public class double_w92 {
    class Solution {
        public int numberOfCuts(int n) {
            double v = Math.log(n) / Math.log(2);
            double floor = Math.floor(v);
            int i1 = n/2;
            if (n % 2 == 1)return n;
            else if (v == floor){
                return (int) floor;
            }
            else return i1;
        }

        public int[][] onesMinusZeros(int[][] grid) {
            int[][] diff = new int[grid.length][grid[0].length];
            int rowLen = grid.length;
            int colLen = grid[0].length;
            int[] onesRow = new int[rowLen];
            int[] onesCol = new int[colLen];
            int[] zerosRow = new int[rowLen];
            int[] zerosCol = new int[colLen];
            for (int i = 0; i < rowLen; i++) {
                int one = 0;
                int zero = 0;
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] == 1)one++;
                    else zero++;
                }
                onesRow[i] = one;
                zerosRow[i] = zero;
            }
            for (int i = 0; i < colLen; i++) {
                int one = 0;
                int zero = 0;
                for (int j = 0; j < rowLen; j++) {
                    if (grid[j][i] == 1)one++;
                    else zero++;
                }
                onesCol[i] = one;
                zerosCol[i] = zero;
            }
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen ; j++) {
                    diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
                }
            }
            return diff;
        }

        public int bestClosingTime(String customers) {
            char[] ca = customers.toCharArray();
            int n = ca.length, no[] = new int[n], yes[] = new int[n], pre = 0, res = 0;
            for (int i = 0; i != n; ++i) {
                if (ca[i] == 'N') ++pre;
                no[i] = pre;
            }
            pre = 0;
            for (int i = n - 1; i != -1; --i) {
                if (ca[i] == 'Y') ++pre;
                yes[i] = pre;
            }
            pre = yes[0];
            for (int i = 1; i != n; ++i) {
                int cur = no[i - 1] + yes[i];
                if (cur < pre) {
                    pre = cur;
                    res = i;
                }
            }
            return no[n - 1] < pre ? n : res;
        }
    }

}