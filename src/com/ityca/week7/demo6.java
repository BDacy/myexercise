package com.ityca.week7;

import java.util.HashSet;
import java.util.Set;

//202. 快乐数
public class demo6 {
    class Solution {
        public boolean isHappy(int n) {
            //无限循环的话，就会出现相同的数
            //也可以使用快慢指针，判断环的好方法
            Set<Integer> set=new HashSet<>();
            int num=n;
            while (true){
                num=getnext(num);
                if (set.contains(num)){
                    return false;
                }else if (num==1)
                    return true;
                else set.add(num);
            }
        }
        public int getnext(int num){
            int res = 0;
            while (num > 0) {
                int temp = num % 10;
                res += temp * temp;
                num = num / 10;
            }
            return res;
        }
    }
}
