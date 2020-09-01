import java.util.*;
class StationInstall {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int next = 1;
        List<Integer> required = new ArrayList<>();
        for(int s : stations) {
            if(next < s-w) {
                required.add((s-w) - next);
            }
            next = s + w + 1;
        }
        if(next <= n)
            required.add(n - next + 1);
        
        w = 2 * w + 1;
        for(int s : required) {
            answer += (s / w);
            if(s % w != 0)
                answer++;
        }

        return answer;
    }
}
