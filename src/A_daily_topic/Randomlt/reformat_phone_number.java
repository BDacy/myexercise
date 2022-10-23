package A_daily_topic.Randomlt;

/**
 * @Auther: yca
 * @Date: 2022/10/01/16:14
 * @Description:
 *          1694. 重新格式化电话号码
 *          https://leetcode.cn/problems/reformat-phone-number/
 */
public class reformat_phone_number {
    class Solution {
        public String reformatNumber(String number) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                if (c!=' '&&c!='-')
                    sb.append(c);
            }
            int length = sb.length();
            int t = 0;
            if (length%3==1){
                sb.insert(length-2,'-');
                length = sb.length();
                t = 5;
            }else if ((length%3)==0) t=3;
            else t=2;


            for (int i = 0;length-t-i>0;i+=3){
                sb.insert(length-t-i,'-');
            }
            return sb.toString();

        }
    }
}
