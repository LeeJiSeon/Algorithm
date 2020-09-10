import java.util.*;
class BridgePassing {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = Integer.MAX_VALUE, right = 0;
        for(int stone : stones) {
            left = Math.min(left, stone);
            right = Math.max(right, stone);
        }
            
        while(left <= right) { 
            int mid = (left + right) / 2;
            
            if(isPossible(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else  right = mid - 1;
        }
        return answer;
    }
    
    private boolean isPossible(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int stone : stones) {
            if(stone - mid < 0)    cnt++;
            else    cnt = 0;
            if(cnt >= k)    return false;
        }
        return true;
    }
}
