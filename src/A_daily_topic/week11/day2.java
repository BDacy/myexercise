package A_daily_topic.week11;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-15  08:46
 * @Description:
 *          1710. 卡车上的最大单元数
 *          https://leetcode.cn/problems/maximum-units-on-a-truck/
 *          815. 公交路线
 *          https://leetcode.cn/problems/bus-routes/
 *          剑指 Offer 03. 数组中重复的数字
 *          https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?favorite=xb9nqhhg
 */
public class day2 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            int ans = 0;
            //根据装载单元数量排序
            Arrays.sort(boxTypes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            for (int i = 0; i < boxTypes.length; i++) {
                if (truckSize < boxTypes[i][0]){
                    ans += truckSize * boxTypes[i][1];
                    break;
                }
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
            return ans;
        }

        int[][] routes;
        int source;
        int target;
        public int numBusesToDestination(int[][] routes, int source, int target) {
            this.routes = routes;
            this.source = source;
            this.target = target;
            if (source == target) return 0;
            return bfs();
        }
        public int bfs(){
            // 记录每个班车可换乘的班车号
            Map<Integer, List<Integer>> map = new HashMap<>();
            // 存储经过的路线
            Deque<Integer> deque = new LinkedList<>();
            // 进入该路线使用的距离
            Map<Integer, Integer> m = new HashMap<>();
            // 遍历一遍数组，更新Map,deque,m;
            for (int i = 0; i < routes.length; i++) {
                for (int station : routes[i]) {
                    if (station == source){
                        deque.addLast(i);
                        m.put(i,1);
                    }
                    List<Integer> list = map.getOrDefault(station, new ArrayList<>());
                    list.add(i);
                    map.put(station,list);
                }
            }
            while (!deque.isEmpty()){
                int station = deque.pollFirst();
                int step = m.get(station);

                for (int i : routes[station]) {
                    if (i == target) return step;
                    List<Integer> list = map.get(i);
                    if (list == null) continue;
                    for (int nr : list) {
                        if (!m.containsKey(nr)) {
                            m.put(nr, step + 1);
                            deque.add(nr);
                        }
                    }
                }
            }
            return -1;
        }

        public int findRepeatNumber(int[] nums) {
            int i = 0;
            while(i < nums.length) {
                if(nums[i] == i) {
                    i++;
                    continue;
                }
                if(nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }
    }
}