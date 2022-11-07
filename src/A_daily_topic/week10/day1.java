package A_daily_topic.week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.week10
 * @Author: yca
 * @CreateTime: 2022-11-07  16:18
 * @Description:
 *          706. 设计哈希映射
 *          https://leetcode.cn/problems/design-hashmap/
 *          816. 模糊坐标
 *          https://leetcode.cn/problems/ambiguous-coordinates/
 */
public class day1 {
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    class MyHashMap {
        private class Entry{
            private final int key;
            private int value;

            public Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        private final int size = 1000;
        private final LinkedList<Entry>[] lists;
        public MyHashMap() {
            this.lists = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                lists[i] = new LinkedList<Entry>();
            }
        }

        public void put(int key, int value) {
            int hash = hash(key);
            for (Entry next : lists[hash]) {
                if (next.getKey() == key) {
                    next.setValue(value);
                    return;
                }
            }
            lists[hash].addLast(new Entry(key,value));
        }

        public int get(int key) {
            int hash = hash(key);
            for (Entry next : lists[hash]) {
                if (next.getKey() == key)
                    return next.getValue();
            }
            return -1;
        }

        public void remove(int key) {
            int hash = hash(key);
            lists[hash].removeIf(next -> next.getKey() == key);
        }
        private int hash(int key){
            return key % size;
        }
    }


    class Solution {
        String s;
        public List<String> ambiguousCoordinates(String str) {
            //去掉括号
            s = str.substring(1,str.length() - 1);
            int n = s.length();
            List<String> res = new ArrayList<>();
            // 枚举逗号
            for (int i = 0; i < n - 1; i++) {
                List<String> a = search(0, i),b = search(i + 1, n - 1);
                for (String s1 : a) {
                    for (String s2 : b) {
                        res.add("(" + s1 + ", " + s2 + ")");
                    }
                }
            }
            return res;
        }
        // 找小数点的位置
        public List<String> search(int l, int r){
            List<String> res = new ArrayList<>();
            if (l == r || s.charAt(l) != '0') res.add(s.substring(l, r + 1));
            for (int i = l; i < r; i++) { // 枚举小数点：在 i 后面追加小数点
                String a = s.substring(l, i + 1), b = s.substring(i + 1, r + 1);
                if (a.length() > 1 && a.charAt(0) == '0') continue;
                if (b.charAt(b.length() - 1) == '0') continue;
                res.add(a + "." + b);
            }
            return res;
        }
    }

}