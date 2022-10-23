package com.ityca.week2;
//564. 寻找最近的回文数
//狗都不写
public class demo7 {
    public static void main(String[] args) {
        String str="1283";
        System.out.println(Solution.nearestPalindromic(str));
    }
    class Solution {
        public static String nearestPalindromic(String n) {
            //分多种情况来处理
            //转换成整数
            int num = Integer.parseInt(n);
            String res="";
            //位数只有1位
            if (n.length()==1){
                res=String.valueOf(num-1);
                //n-1输出
            } else if (num%Math.pow(10,n.length()-1)==0){
                //是10的幂
                res=Integer.toString(num-1);
                //n-1输出
            } else if (num+1==Math.pow(10,n.length())){
                //每一位都是9
                res=Integer.toString(num+2);
                //n+2输出
            } else if (num==Math.pow(10,n.length()-1)+1) {
                for (int i=0;i<n.length()-1;i++){
                    res+="9";
                };
            }else {
                //普遍情况,结果不会出现位数的变化
                //需要求出数的前后两种回文数，做差比较，选差值较小的那个
                //一种是直接选前一半覆盖后一半
                //另一种是将前一半的最后一个减1，在执行上述操作
                //如果是奇数个前一半指的是包括中间的那个值
                //分割数字
                char[] chars = n.toCharArray();
                int length=chars.length;
                for (int i=0;i<length/2;i++){
                    chars[length-1-i]=chars[i];
                }
                int temp1=Integer.parseInt(new String(chars));//第一种
                //第二种
                //中间数减1
                if (chars[(length-1)/2]=='0')
                    chars[(length-1)/2]+=1;
                else
                chars[(length-1)/2]-=1;
                for (int i=0;i<length/2;i++){
                    chars[length-1-i]=chars[i];
                }
                int temp2=Integer.parseInt(new String(chars));//第二种
                //第三种
                chars[(length-1)/2]+=2;
                for (int i=0;i<length/2;i++){
                    chars[length-1-i]=chars[i];
                }
                int temp3=Integer.parseInt(new String(chars));
                //作差取小值
                int a=Math.abs(temp1-num);
                int b=Math.abs(temp2-num);
                int c=Math.abs(temp3-num);
                if (a<b&&a!=0){
                    return Integer.toString(temp1);
                }else {
                    return Integer.toString(temp2);
                }
            }
            return res;
        }
    }
}
