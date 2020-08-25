import java.util.PriorityQueue;
import java.util.Collections;
class OvertimeWork {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : works)
            overtime.offer(i);
        for(int i = 0 ; i < n ; i++) {
            int max = overtime.poll();
            if(max == 0) break;
            overtime.offer(max - 1);
        }
        
        while(!overtime.isEmpty())
            answer += Math.pow(overtime.poll(), 2);
        return answer;
    }
}
