package com.ityca.week7;

import java.util.*;

public class demo7 {
    public static void main(String[] args) {
        int[]nums1={-1,-1};
        int[]nums2={-1,1};
        int[]nums3={-1,1};
        int[]nums4={1,-1};
        System.out.println(Solution.fourSumCount(nums1,nums2,nums3,nums4));
    }

    class Solution {
        //804. 唯一摩尔斯密码词
        public static int uniqueMorseRepresentations(String[] words) {
            //摩斯密码
            String[] list = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                    "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                    "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            //存放翻译好的密码集合
            Set<String> set = new HashSet<>();
            //对words进行翻译
            for (String word : words) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < word.length(); i++) {
                    stringBuffer.append(list[word.charAt(i) - 'a']);
                }
                set.add(stringBuffer.toString());
            }
            return set.size();
        }
        //1. 两数之和
        public static int[] twoSum(int[] nums, int target) {
            //利用哈希表
            int[] res=new int[2];
            if (nums.length==0||nums==null)
                return res;
            Map<Integer,Integer> map=new HashMap<>();
            for (int i=0;i<nums.length;i++){
                int temp=target-nums[i];
                if (map.containsKey(temp)){
                    res[0]=i;
                    res[1]=map.get(temp);
                    return res;
                }
                map.put(nums[i],i);
            }
            return res;
        }
        //454. 四数相加 II
        public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int cnt=0;
            //遍历AB,将它们的和作为key，出现次数作为value存储
            Map<Integer,Integer> map=new HashMap<>();
            for (int i : nums1) {
                for (int i1 : nums2) {
                    int temp=i+i1;
                    if (map.containsKey(temp))
                        map.put(temp,map.get(temp)+1);
                    else
                        map.put(temp,1);
                }
            }
            for (int i : nums3) {
                for (int i1 : nums4) {
                    int temp=i+i1;
                    if (map.containsKey(-temp))
                        cnt+=map.get(-temp);
                }
            }
            return cnt;
        }
        //383. 赎金信
        public boolean canConstruct(String ransomNote, String magazine) {
//            输入：ransomNote = "a", magazine = "b"
//            输出：false
            //由于只考虑字母，可以用数组代替map
            //map
            if (ransomNote.length()>magazine.length())
                return false;
            //对magazine进行存储
            Map<Character,Integer> map=new HashMap<>();
            for(int i=0;i<magazine.length();i++){
                char temp=magazine.charAt(i);
                if (map.containsKey(temp))
                    map.put(temp,map.get(temp)+1);
                else
                    map.put(temp,1);
            }
            //对 ransomNote 进行扫描
            for (int i=0;i<ransomNote.length();i++){
                char temp=ransomNote.charAt(i);
                if (map.containsKey(temp)&&map.get(temp)>0)
                    map.put(temp,map.get(temp)-1);
                else
                    return false;
            }
            return true;
        }
        //15. 三数之和
        public List<List<Integer>> threeSum(int[] nums) {
//            输入：nums = [-1,0,1,2,-1,-4]
//            输出：[[-1,-1,2],[-1,0,1]]
            List<List<Integer>> res=new ArrayList<>();
            if (nums.length<3)return res;
            //排序
            Arrays.sort(nums);
            for (int i=0;i<nums.length-2;i++){
                if (nums[i]>0) return res;
                if (i>0&&nums[i]==nums[i-1]) continue;
                int left=i+1;
                int right=nums.length-1;
                while (left<right){
                    int sum=nums[i]+nums[left]+nums[right];
                    if (sum==0) {
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        //去重
                        while (left<right&&nums[left]==nums[left+1]) left++;
                        while (left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum>0)
                        right--;
                    else
                        left++;
                }
            }
            return res;
        }
        //18. 四数之和
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j - 1] == nums[j]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (right > left) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum > target) {
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (right > left && nums[right] == nums[right - 1]) right--;
                            while (right > left && nums[left] == nums[left + 1]) left++;
                            left++;
                            right--;
                        }
                    }
                }
            }
            return result;
        }
    }
}
