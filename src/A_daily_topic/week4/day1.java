package A_daily_topic.week4;

/**
 * @Auther: yca
 * @Date: 2022/09/26/16:41
 * @Description:
 *          292. Nim 游戏
 *          https://leetcode.cn/problems/nim-game/
 */
public class day1 {
    class Solution {
        public boolean canWinNim(int n) {
            //直接就是动态规划 ,但是栈溢出
            //所以用数学方法
            if (n%4==0)return false;
            else return true;
        }
    }
}
