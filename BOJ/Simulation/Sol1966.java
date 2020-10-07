import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int num, idx;
    Node(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Node n) {
        return n.num - this.num;
    }
}

class Sol1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 1;
            
            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0 ; j < N ; j++) {
                int weight = Integer.parseInt(st.nextToken());
                queue.offer(new Node(weight, j));
                pq.offer(new Node(weight, j));
            }
            
            while(true) {
                Node n = queue.poll();
                if(n.num == pq.peek().num) {
                    if(n.idx == M) {
                        System.out.println(cnt);
                        break;
                    }
                    pq.poll();
                    cnt++;
                } else {
                    queue.offer(n);
                }
            }
        }
        
        br.close();
    }
}
