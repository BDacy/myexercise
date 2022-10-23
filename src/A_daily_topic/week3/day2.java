package A_daily_topic.week3;

import java.util.Arrays;

/**
 * @Auther: yca
 * @Date: 2022/09/20/9:29
 * @Description:
 *          14. 最长公共前缀
 *          https://leetcode.cn/problems/longest-common-prefix/
 */
public class day2 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
//            String res = "";
//            if (strs==null)return res;
//            boolean flag=true;
//            int index=0;
//            while (flag){
//                if (strs[0].length()==index) break;
//                char c = strs[0].charAt(index);
//                for (int i=1;i<strs.length;i++){
//                    String str = strs[i];
//                    if (str.length()==index){
//                        flag=false;
//                        break;
//                    }
//                    char c1 = str.charAt(index);
//                    if (c!=c1){
//                        flag=false;
//                        break;
//                    }
//                }
//                index++;
//                if (flag)
//                res = res + c;
//            }
//            return res;
            Arrays.sort(strs);
            int length = strs[0].length();
            String res = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if (length == 0)break;
                String str = strs[i];
                for (int j = 0; j < length; j++) {
                    if (str.charAt(j)!=res.charAt(j))length=j;
                }
            }
            StringBuilder res1 = new StringBuilder();
            for (int i = 0; i < length; i++) {
                res1.append(strs[0].charAt(i));
            }
            return res1.toString();
        }
    }

}
