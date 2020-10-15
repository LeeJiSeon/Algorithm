import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Sol17822 {
    static int N, M, T;
    static int[][] circle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int result = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        circle = new int[N+1][M];
        
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
                circle[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int a = 0 ; a < T ; a++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            
            if(!findadj())
                calcAvg();
        }
        
        for(int i = 1 ; i <= N ; i++)
            for(int j = 0 ; j < M ; j++)
                if(circle[i][j] != -1)
                    result += circle[i][j];
                    
        System.out.println(result);
        br.close();
    }
    
    private static void calcAvg() {
        int sum = 0, cnt = 0;
        double avg = 0;
        
        for(int i = 1 ; i <= N ; i++)
            for(int j = 0 ; j < M ; j++)
                if(circle[i][j] != -1) {
                    sum += circle[i][j];
                    cnt++;
                }
        avg = (double)sum / cnt;
        
        for(int i = 1 ; i <= N ; i++)
            for(int j = 0 ; j < M ; j++) {
                if(circle[i][j] == -1)  continue;
                if(circle[i][j] < avg)  circle[i][j]++;
                else if(circle[i][j] > avg) circle[i][j]--;
            }
    }

    private static void rotate(int x, int d, int k) {
        for(int i = x ; i <= N ; i += x){
            if(d == 0)  rotateclock(i, k);
            else    rotatereverse(i, k);
        }
    }

    private static void rotateclock(int r, int k) {
        for(int i = 0 ; i < k ; i++) {
            int pre = circle[r][M-1], next;
            for(int j = 0 ; j < M ; j++) {
                next = circle[r][j];
                circle[r][j] = pre;
                pre = next;
            }
        }
    }

    private static void rotatereverse(int r, int k) {
        for(int i = 0 ; i < k ; i++) {
            int pre = circle[r][0], next;
            for(int j = M-1 ; j >= 0 ; j--) {
                next = circle[r][j];
                circle[r][j] = pre;
                pre = next;
            }
        }
    }

    private static boolean findadj() {
        boolean isChange = false;
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(circle[i][j] != -1) {
                    int cnt = 0, pre = circle[i][j];
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j));
                    
                    while(!queue.isEmpty()) {
                        Node n = queue.poll();
                        
                        if(circle[n.x][n.y] == -1)
                            continue;
                        
                        cnt += findadjM(n, queue);
                        cnt += findadjN(n, queue);
                        
                        circle[n.x][n.y] = -1;
                    }
                    
                    if(cnt == 0)    circle[i][j] = pre;
                    else    isChange = true;
                }
            }
        }
        
        return isChange;
    }
    
    private static int findadjN(Node n, Queue<Node> queue) {
        int cnt = 0;
        
        if(n.x == 1) {
            if(circle[1][n.y] == circle[2][n.y]) {
                queue.offer(new Node(2, n.y));
                cnt++;
            }
        } else if(n.x == N) {
            if(circle[N][n.y] == circle[N-1][n.y]) {
                queue.offer(new Node(N-1, n.y));
                cnt++;
            }
        } else {
            if(circle[n.x][n.y] == circle[n.x-1][n.y]) {
                queue.offer(new Node(n.x-1, n.y));
                cnt++;
            }
            if(circle[n.x][n.y] == circle[n.x+1][n.y]) {
                queue.offer(new Node(n.x+1, n.y));
                cnt++;
            }
        }
        return cnt;
    }
    
    private static int findadjM(Node n, Queue<Node> queue) {
        int cnt = 0;
        
        if(n.y == 0) {
            if(circle[n.x][0] == circle[n.x][1]) {
                queue.offer(new Node(n.x, 1));
                cnt++;
            }
            if(circle[n.x][0] == circle[n.x][M-1]) {
                queue.offer(new Node(n.x, M-1));
                cnt++;
            }
        } else if(n.y == M-1) {
            if(circle[n.x][0] == circle[n.x][M-1]) {
                queue.offer(new Node(n.x, 0));
                cnt++;
            }
            if(circle[n.x][M-2] == circle[n.x][M-1]) {
                queue.offer(new Node(n.x, M-2));
                cnt++;
            }
        } else {
            if(circle[n.x][n.y] == circle[n.x][n.y-1]) {
                queue.offer(new Node(n.x, n.y-1));
                cnt++;
            }
            if(circle[n.x][n.y] == circle[n.x][n.y+1]) {
                queue.offer(new Node(n.x, n.y+1));
                cnt++;
            }
        }
        return cnt;
    }
}

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
