package A_daily_topic.weekGame;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.weekGame
 * @Author: yca
 * @CreateTime: 2022-11-20  10:28
 * @Description:
 */
public class w320 {
    class Solution {
        public int unequalTriplets(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k])
                            ans++;
                    }
                }
            }
            return ans;
        }


        // Definition for a binary tree node.
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<List<Integer>> ans = new ArrayList<>();
            for (Integer query : queries) {
                int max = -1;
                int min = 1000001;
                TreeNode cur = root;
                while (cur != null){
                    if (query == cur.val){
                        max = cur.val;
                        min = cur.val;
                        break;
                    }else if (query < cur.val){
                        max = cur.val;
                        cur = cur.left;
                    }else {
                        min = cur.val;
                        cur = cur.right;
                    }
                }
                List<Integer> list = new ArrayList<>();
                if (min == 1000001)min = -1;
                list.add(min);
                list.add(max);
                ans.add(list);
            }
            return ans;
        }

        public int beautifulPartitions(String s, int k, int minLength) {
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            set.add('2');
            set.add('3');
            set.add('5');
            set.add('7');
            int length = s.length();
            if (set.contains(s.charAt(length - 1)))return 0;
            if (!set.contains(s.charAt(0)))return 0;
            if (length < minLength)return 0;
            if (k == 1)return 1;
            int cnt = 0;
            int l = 0;
            int r = minLength - 1;
            while (r < length){
                if (r + 1 == length)break;
                if (!set.contains(chars[r]) && set.contains(chars[r + 1])){
                    l = r + 1;
                    r = l + minLength - 1;
                    cnt++;
                }else r++;
            }
            int res = 1;
            for (int i = 0;i < cnt - (k - 1); i++){
                res *= (cnt - i);
            }
            return res;
        }
    }
}