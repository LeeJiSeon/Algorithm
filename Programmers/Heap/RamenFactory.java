import java.util.*;

class RamenFactory {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < k ; i++) {
            if(index < dates.length && i == dates[index])
                queue.offer(supplies[index++]);
            if(stock == 0) {
                stock += queue.poll();
                answer++;
            }
            stock--;
        }

        return answer;
    }
 }