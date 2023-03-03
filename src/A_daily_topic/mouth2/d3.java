package A_daily_topic.mouth2;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-03  08:32
 * @Description:
 * 大便题目
 *          1487. 保证文件名唯一
 *          https://leetcode.cn/problems/making-file-names-unique/
 */
public class d3 {
    class Solution {
        public String[] getFolderNames(String[] names) {
            Map<String, Integer> d = new HashMap<>();
            for (int i = 0; i < names.length; ++i) {
                if (d.containsKey(names[i])) {
                    int k = d.get(names[i]);
                    while (d.containsKey(names[i] + "(" + k + ")")) {
                        ++k;
                    }
                    d.put(names[i], k);
                    names[i] += "(" + k + ")";
                }
                d.put(names[i], 1);
            }
            return names;
        }
    }

}