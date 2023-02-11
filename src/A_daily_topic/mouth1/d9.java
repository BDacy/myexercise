package A_daily_topic.mouth1;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-11  09:38
 * @Description:
 *          1797. 设计一个验证系统
 *          https://leetcode.cn/problems/design-authentication-manager/
 */
public class d9 {
    class AuthenticationManager {
        private int timeToLive;
        private Map<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if(map.containsKey(tokenId)){
                int time = map.get(tokenId);
                if(time > currentTime){
                    // 执行更新操作 否则啥都不做
                    map.put(tokenId, currentTime + timeToLive);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int cnt = 0;
            for(int time : map.values()){
                if(time > currentTime)cnt++;
            }
            return cnt;
        }
    }

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
}