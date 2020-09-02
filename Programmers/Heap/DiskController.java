import java.util.*;
class DiskController {
    class Job {
        int request, work;
        
        Job(int request, int work) {
            this.request = request;
            this.work = work;
        }
    }
    
    public int solution(int[][] jobs) {
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.work - j2.work;
            }
        });
        
        for(int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }
        
        Collections.sort(waiting, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.request - j2.request;
            }
        });
        
        int answer = 0, index = 0;
        int time = waiting.peek().request;
        while(index < jobs.length) {
            while(!waiting.isEmpty() && waiting.peek().request <= time)
                pq.offer(waiting.pollFirst());
            
            if(!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.work;
                answer += time - job.request;
                index++;
            } else  time++;
        }
        
        return answer / index;
    }
}
