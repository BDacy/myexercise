package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-12  10:02
 * @Description:
 *          1138. 字母板上的路径
 *          https://leetcode.cn/problems/alphabet-board-path/
 */
public class d12 {
    class Solution {
        public String alphabetBoardPath(String target) {
            // 先上下再左右
            // 如果下一个是z则先左右再上下
            // 下一个字母的坐标可以被计算出来
            StringBuilder ans = new StringBuilder();
            int x = 0;
            int y = 0;
            for(int i = 0; i < target.length(); i++){
                char c = target.charAt(i);
                int idx = c - 'a';
                int ix = idx / 5;
                int iy = idx % 5;
                // 如果当前符合则直接加入
                if(ix == x && iy == y){
                    ans.append('!');
                    continue;
                }
                // 不符合则计算差值
                int dx = ix - x;
                int dy = iy - y;
                if(c == 'z'){
                    // 先上下
                    ans.append(String.valueOf(dy > 0 ? 'R' : 'L').repeat(Math.abs(dy)));
                    ans.append(String.valueOf(dx > 0 ? 'D' : 'U').repeat(Math.abs(dx)));
                }else{
                    // 先左右
                    ans.append(String.valueOf(dx > 0 ? 'D' : 'U').repeat(Math.abs(dx)));
                    ans.append(String.valueOf(dy > 0 ? 'R' : 'L').repeat(Math.abs(dy)));
                }
                ans.append('!');
                // 更新坐标
                x = ix;
                y = iy;
            }
            return ans.toString();
        }
    }
}