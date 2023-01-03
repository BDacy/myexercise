package A_daily_topic.week18;

/**
 * @BelongsPackage: A_daily_topic.week18
 * @Author: yca
 * @CreateTime: 2023-01-03  10:44
 * @Description:
 *          162. 寻找峰值
 *          https://leetcode.cn/problems/find-peak-element/
 *          2042. 检查句子中的数字是否递增
 *          https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 */
public class day2 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while(l < r){
                int mid = (l + r) >> 1;
                if(nums[mid] > nums[mid + 1]){
                    // 证明左侧有峰值
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean areNumbersAscending(String s) {
            String[] words = s.split(" ");
            int cur = -1;
            for(String word:words){
                boolean flag = true;// 是不是数字
                int num = 0;
                for(int i = 0; i < word.length();i++){
                    if(word.charAt(i) - '0' <= 9 && word.charAt(i) - '0' >= 0){
                        num *= 10;
                        num += word.charAt(i) - '0';
                    }else{
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    if(cur == -1)cur = num;
                    else if(cur < num){
                        cur = num;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
    }
}