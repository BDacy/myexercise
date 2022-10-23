package A_daily_topic.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yca
 * @Date: 2022/09/13/8:44
 * @Description:
 *          22. 括号生成
 *          https://leetcode.cn/problems/generate-parentheses/
 */
public class day2 {
    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
    }
    class Solution {
        static List<String> list=new ArrayList<>();
         static public List<String> generateParenthesis(int n) {
            aa(n,n,"");
            return list;
        }
         static public void aa(int left,int right,String str){
            //如果左括号剩余数量和右括号相同，下一个添加为左括号
            if (left == right && left!=0){
                left--;
                aa(left,right,str+"(");
            }else if (left == 0){
                if (right == 0){
                    list.add(str);
                }else {
                    right--;
                    aa(left,right,str+")");
                }
            }else if (right>left){
                aa(left-1,right,str+"(");
                aa(left,right-1,str+")");
            }
        }
    }

}
