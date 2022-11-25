package A_daily_topic.week12;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-25  09:36
 * @Description:
 *          809. 情感丰富的文字
 *          https://leetcode.cn/problems/expressive-words/
 *          1401. 圆和矩形是否有重叠
 *          https://leetcode.cn/problems/circle-and-rectangle-overlapping/
 */
public class day5 {
    class Solution {
        public int expressiveWords(String s, String[] words) {
            int ans = 0;
            for (String word : words)
                if (check(s, word))ans++;
            return ans;
        }

        private boolean check(String s, String word){
            if (s.length() < word.length())return false;
            int i = 0,j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) != word.charAt(j))return false;
                char c = s.charAt(i);
                int cnti = 1;
                i++;
                while (i < s.length() && s.charAt(i) == c){
                    cnti++;
                    i++;
                }
                c = word.charAt(j);
                int cntj = 1;
                j++;
                while (j < word.length() && word.charAt(j) == c){
                    cntj++;
                    j++;
                }

                if (cnti < cntj)return false;
                if (cnti != cntj && cnti < 3)return false;
            }
            return i == s.length() && j == word.length();
        }

        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            // 考虑圆心和矩形的相对位置，考虑极限情况，画出边界，进行情况划分
            // 圆心在矩形内
            if (xCenter <= x2 && xCenter >= x1 && yCenter <= y2 && yCenter >= y1)return true;

            // 圆心在矩形四条边的方框
            // 左框
            if (xCenter <= x1 && xCenter >= x1 - radius && yCenter >= y1 && yCenter <= y2)return true;
            // 右框
            if (xCenter <= x2 + radius && xCenter >= x2 && yCenter >= y1 && yCenter <= y2)return true;
            // 上框
            if (xCenter <= x2 && xCenter >= x1 && yCenter >= y2 && yCenter <= y2 + radius)return true;
            // 下框
            if (xCenter <= x2 && xCenter >= x1 && yCenter >= y1 - radius && yCenter <= y1)return true;

            // 圆心在四个角当圆心的四分之一圆里
            // 左上
            if (distance(xCenter,x1,yCenter,y2) <= radius)return true;
            // 右上
            if (distance(xCenter,x2,yCenter,y2) <= radius)return true;
            // 左下
            if (distance(xCenter,x1,yCenter,y1) <= radius)return true;
            // 右下
            if (distance(xCenter,x2,yCenter,y1) <= radius)return true;

            return false;
        }
        private double distance(int x1,int x2,int y1,int y2){
            return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1 - y2, 2));
        }
    }
}