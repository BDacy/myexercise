package A_daily_topic.week10;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week10
 * @Author: yca
 * @CreateTime: 2022-11-08  08:53
 * @Description:
 *          470. 用 Rand7() 实现 Rand10()
 *          https://leetcode.cn/problems/implement-rand10-using-rand7/
 *          1684. 统计一致字符串的数目
 *          https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *          2085. 统计出现过一次的公共字符串
 *          https://leetcode.cn/problems/count-common-words-with-one-occurrence/
 */
public class day2 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    class SolBase{
        public int rand7(){
            return new Random().nextInt(7);
        };
    }
    //  已知 rand_N() 可以等概率的生成[1, N]范围的随机数
    // 那么：
    // (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
    // 即实现了 rand_XY()
    class Solution extends SolBase {
        public int rand10() {
            while(true) {
                int a = rand7();
                int b = rand7();
                int num = (a-1)*7 + b; // rand 49
                if(num <= 40) return num % 10 + 1; // 拒绝采样

                a = num - 40; // rand 9
                b = rand7();
                num = (a-1)*7 + b; // rand 63
                if(num <= 60) return num % 10 + 1;

                a = num - 60; // rand 3
                b = rand7();
                num = (a-1)*7 + b; // rand 21
                if(num <= 20) return num % 10 + 1;
            }
        }
        public int countConsistentStrings(String allowed, String[] words) {
            int[] arr = new int[26];
            int cnt = 0;
            for (int i = 0; i < allowed.length(); i++) {
                arr[allowed.charAt(i) - 'a']++;
            }
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    if (arr[word.charAt(i) - 'a'] == 0){
                        cnt--;
                        break;
                    }
                }
                cnt++;
            }
            return cnt;
        }


        public static int countWords(String[] words1, String[] words2) {
            HashMap<String, Integer>counter1 = new HashMap<>();
            HashMap<String, Integer>counter2 = new HashMap<>();
            for(String s : words1){
                counter1.put(s, counter1.getOrDefault(s, 0) + 1);
            }
            for(String s : words2){
                counter2.put(s, counter2.getOrDefault(s, 0) + 1);
            }
            int ans = 0;
            for(String s : counter1.keySet()){
                if(counter1.get(s) == 1 && counter2.getOrDefault(s, 0) == 1){
                    ans ++;
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        System.out.println(Solution.countWords(new String[]{"a","ab"},new String[]{"a","a","a","ab"}));
    }
}