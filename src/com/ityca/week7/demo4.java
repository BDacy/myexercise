package com.ityca.week7;

import java.util.HashSet;
import java.util.Set;

//349. 两个数组的交集
public class demo4 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1==null||nums1.length==0|| null == nums2 ||nums2.length==0)
                return new int[0];
            Set<Integer> set1=new HashSet<>();
            Set<Integer> resset=new HashSet<>();
            //遍历第一个数组
            for (int i : nums1) {
                set1.add(i);
            }
            //获得结果交集
            for (int i : nums2) {
                if (set1.contains(i))
                    resset.add(i);
            }
            //将集合结果转换为数组
            int[] res=new int[resset.size()];
            int index=0;
            for (Integer integer : resset) {
                res[index++]=integer;
            }
            return res;
        }
    }
}
