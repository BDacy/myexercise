package A_daily_topic.mouth2;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-02  09:36
 * @Description:
 *          面试题 05.02. 二进制数转字符串
 *          https://leetcode.cn/problems/bianry-number-to-string-lcci/
 */
public class d2 {
    class Solution {
        public String printBin(double num) {
            // 二进制转换
            StringBuilder res = new StringBuilder();
            res.append("0.");
            int cnt = 6;
            while(num > 0 && cnt > 0){
                num *= 2;
                if(num >= 1){
                    res.append('1');
                    num -= 1;
                }else res.append('0');
                cnt--;
            }
            return num == 0 ? res.toString() : "ERROR";
        }
    }
}