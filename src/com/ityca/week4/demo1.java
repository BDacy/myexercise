package com.ityca.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//599. 两个列表的最小索引总和
public class demo1 {
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            int n1= list1.length;//list1的长度
            int n2= list2.length;//list2的长度
            //利用hash表，把list1的值给存储起来便于查询
            HashMap<String,Integer> map=new HashMap<>();
            for (int i=0;i<n1;i++){
                map.put(list1[i],i );
            }
            List<String> res=new ArrayList<>();
            //设置最小索引值
            int min=2000;
            //遍历list2，查看是否有list1的值与list2的值相同，并获取索引值
            for (int i=0;i<n2;i++){
                String s=list2[i];
                if (!map.containsKey(s))continue;
                if (map.get(s)+i<min){
                    res.clear();//发现新的最小值，清空结果列表
                    res.add(s);
                    min=map.get(s)+i;//更新最小值
                }else if (map.get(s)+i==min){
                    res.add(s);
                }
            }
            return res.toArray(new String[res.size()]);
        }
    }
}
