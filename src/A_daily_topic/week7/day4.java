package A_daily_topic.week7;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @BelongsPackage: A_daily_topic.week7
 * @Author: yca
 * @CreateTime: 2022-10-20  09:45
 * @Description:
 *              380. O(1) 时间插入、删除和获取随机元素
 *              https://leetcode.cn/problems/insert-delete-getrandom-o1/
 */
public class day4 {
    class RandomizedSet {
        //用map进行存储,key:val, value:idx
        Random random;
        Map<Integer,Integer> map;
        int[] random_val;
        int index;
        public RandomizedSet() {
            random = new Random();
            map = new HashMap<>();
            random_val = new int[9999];
            index = 0;
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)){
                map.put(val,index);
                random_val[index] = val;
                index++;
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)){
                Integer cur = map.remove(val);
                //数组的最后一位移到删除的哪一位上去，然后数组的合法size减1
                if (cur != index-1){
                    map.put(random_val[index-1],cur);
                    random_val[cur] = random_val[index-1];
                }
                index--;
                return true;
            }
            return false;
        }

        public int getRandom() {
            return random_val[random.nextInt(index)];
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}