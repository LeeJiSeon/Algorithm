import java.util.*;
class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> spice = new PriorityQueue<>();
        for(int i : scoville)
            spice.offer(i);
        while(spice.size() > 1) {
            if(spice.peek() >= K)
                break;
            int new_scove = spice.poll() + spice.poll()*2;
            spice.offer(new_scove);
            answer++;
        }
        if(spice.size() == 1 && spice.peek() < K)
            return -1;
        return answer;
    }
}