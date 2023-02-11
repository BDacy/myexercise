package A_daily_topic.mouth1;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-11  09:48
 * @Description:
 *          1604. 警告一小时内使用相同员工卡大于等于三次的人
 *          https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */
public class d7 {
    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            // 先将对应员工的打卡列表进行存储，再依次处理每个员工的打卡情况
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < keyName.length; i++) {
                String name = keyName[i];
                // 化成分钟
                int time = Integer.parseInt(keyTime[i].substring(0,2)) * 60
                        + Integer.parseInt(keyTime[i].substring(3));
                map.computeIfAbsent(name, k -> new ArrayList<>()).add(time);
            }
            List<String> ans = new ArrayList<>();
            // 对于每个员工的打卡列表进行处理
            for (String name : map.keySet()){
                List<Integer> list = map.get(name);

                int n = list.size();
                if (n > 2){
                    // 对列表进行排序
                    Collections.sort(list);
                    for (int i = 0; i < n - 2; i++) {
                        // 符合条件
                        if (list.get(i + 2) - list.get(i) <= 60){
                            ans.add(name);
                            break;
                        }
                    }
                }
            }
            // 结果按字典序升序排序
            Collections.sort(ans);
            return ans;
        }
    }
}