package A_daily_topic.week19;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-14  10:34
 * @Description:
 *          1157. 子数组中占绝大多数的元素
 *          https://leetcode.cn/problems/online-majority-element-in-subarray/
 */
public class day6 {
    class MajorityChecker {

        // 线段树，每个节点存放众数

        Map<Integer, List<Integer>> map;
        Node tree;
        public MajorityChecker(int[] arr) {
            map = new HashMap<>();
            tree = buildNodeTree(0, arr.length - 1, arr);
            for (int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            Pair pair = search(tree, left, right);
            if (pair.freq >= threshold) {
                return pair.val;
            }
            List<Integer> list = map.get(pair.val);
            int start = binaryStart(list, left), end = binaryEnd(list, right);
            if (end - start >= threshold) {
                return pair.val;
            }
            return -1;
        }

        //寻找下界，大于或者等于目标值
        public int binaryStart(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int m = (l + r) >> 1;
                if (target > list.get(m)) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
        //寻找上界，大于目标值一位
        public int binaryEnd(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int m = (l + r) >> 1;
                if (target < list.get(m)) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        // 建线段树
        public Node buildNodeTree(int start, int end, int[] nums){
            if (start == end)return new Node(new Pair(nums[start], 1),start,end);
            int mid = (start + end) >> 1;
            Node left = buildNodeTree(start, mid, nums),
                 right = buildNodeTree(mid + 1, end, nums);
            Node root = new Node(mergePair(left.pair, right.pair),start,end);
            root.left = left;
            root.right = right;
            return root;
        }

        // 搜索start - end之间的众数信息
        public Pair search(Node root, int start, int end){
            if (root.start >= start && root.end <= end)
                return root.pair;
            Pair res = new Pair(0, 0);
            int mid = (root.start + root.end) >> 1;
            if (start <= mid){// 左数还有
                res = mergePair(res, search(root.left, start, end));
            }
            if (end > mid)
                res = mergePair(res, search(root.right, start, end));
            return res;
        }

        // 摩尔投票计数
        public Pair mergePair(Pair a, Pair b){
            if(a.val == b.val)
                return new Pair(a.val, a.freq + b.freq);
            else if (a.freq > b.freq)
                return new Pair(a.val, a.freq - b.freq);
            else
                return new Pair(b.val, b.freq - a.freq);

        }
        // 节点信息
        public class Node{
            public Node left,right;
            Pair pair;
            int start;
            int end;

            public Node(Pair pair, int start, int end) {
                this.pair = pair;
                this.start = start;
                this.end = end;
            }
        }

        // 节点的众数信息
        public class Pair{
            int val;
            int freq;

            public Pair(int val, int freq) {
                this.val = val;
                this.freq = freq;
            }
        }
    }

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
}