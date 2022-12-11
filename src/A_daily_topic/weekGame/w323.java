package A_daily_topic.weekGame;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.weekGame
 * @Author: yca
 * @CreateTime: 2022-12-11  10:18
 * @Description:
 */
public class w323 {
    class Solution {
        public int deleteGreatestValue(int[][] grid) {
            int ans = 0;
            int n = grid.length;
            List<PriorityQueue<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
                for (int j = 0; j < grid[0].length; j++) {
                    queue.add(grid[i][j]);
                }
                list.add(queue);
            }
            for (int i = 0; i < grid[0].length; i++) {
                int max = 0;
                for (PriorityQueue<Integer> priorityQueue : list) {
                    int poll = priorityQueue.poll();
                    max = Math.max(max, poll);
                }
                ans += max;
            }
            return ans;
        }
        public int longestSquareStreak(int[] nums) {
            int ans = -1;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            Arrays.sort(nums);;
            for (int num : nums) {
                int cnt = 1;
                int cur = num;
                while (set.contains((int)Math.pow(cur, 2))){
                    cnt++;
                    cur = (int)Math.pow(cur, 2);
                }
                ans = Math.max(ans, cnt);
            }
            return ans == 1?-1:ans;
        }
        class Allocator {
            int size;
            int cnt;
            Map<Integer, List<int[]>> map;
            Map<Integer, Integer> offset;
            Map<Integer, Integer> spare;
            boolean[] val;
            public Allocator(int n) {
                size = n;
                cnt = size;
                map = new HashMap<>();
                offset = new HashMap<>();
                val = new boolean[n];
                spare = new HashMap<>();
                spare.put(0, size);
            }

            public int allocate(int size, int mID) {
                if (cnt < size)return -1;
                int idx = 0;
                while (idx < size){
                    if (val[idx]){
                        idx = offset.get(idx);
                    }else {
                        if (spare.get(idx) - idx >= size){
                            // 进行分配
                            val[idx] = true;
                            offset.put(idx, size + idx);
                            int tail = spare.get(idx);
                            spare.remove(idx);
                            if (tail != size + idx)spare.put(size + idx, tail);
                            //
                            List<int[]> list = map.getOrDefault(mID, new ArrayList<>());
                            list.add(new int[]{idx, size + idx});
                            map.put(mID,list);
                            cnt -= size;
                            return idx;
                        }
                    }
                }
                return -1;
            }

            public int free(int mID) {
                int sum = 0;
                List<int[]> list = map.get(mID);
                for (int[] ints : list) {
                    int tail = ints[1];
                    if (!val[tail]){
                        spare.put(ints[0], spare.get(tail));
                        spare.remove(tail);
                    }else {
                        spare.put(ints[0], tail);
                    }
                    offset.remove(ints[0]);
                    val[ints[0]] = false;
                    cnt += tail - ints[0];
                    sum += tail - ints[0];
                }
                return sum;
            }
        }

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
        static int[][] grid1;
        public static int[] maxPoints(int[][] grid, int[] queries) {
            grid1 = grid;
            int[] ans = new int[queries.length];
            int i = 0;
            for (int query : queries) {
                boolean[][] val = new boolean[grid.length][grid[0].length];
                ans[i++] = find(query, 0, 0 , val);
            }
            return ans;
        }
        private static int find(int query, int i, int j, boolean[][] val){
            if (i >= grid1.length || i < 0 || j >= grid1[0].length || j < 0)return 0;
            if (grid1[i][j] >= query)return 0;
            if (val[i][j])
                return 0;
            val[i][j] = true;
            return 1 + find(query, i + 1,j, val)//下
                    + find(query, i, j + 1, val)
            + find(query, i -1, j, val)
            + find(query, i, j - 1, val);
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] query = new int[]{5,6,2};
        System.out.println(Arrays.toString(Solution.maxPoints(grid, query)));
    }
}