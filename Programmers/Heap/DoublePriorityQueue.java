import java.util.*;
class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        int size = 0;
        for(String op : operations) {
            if(op.charAt(0) == 'I') {
                minQueue.add(Integer.parseInt(op.substring(2)));
                maxQueue.add(Integer.parseInt(op.substring(2)));
            } else {
                if(!minQueue.isEmpty()) {
                    if(Integer.parseInt(op.substring(2)) == 1) minQueue.remove(maxQueue.poll());
                    else    maxQueue.remove(minQueue.poll());
                }
            }
        }
        
        if(!minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }

        return answer;
    }
}
