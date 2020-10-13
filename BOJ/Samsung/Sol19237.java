import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
    int x, y, current;
    int[][] direction = new int[5][4];
    
    Shark(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Info {
    int num, time;
    
    Info(int num, int time) {
        this.num = num;
        this.time = time;
    }
}

class Sol19237 {
    static int N, M, k;
    static Shark[] shark;
    static Info[][] map;
    static int[][] now;
    static int cnt;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int second = 0;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new Info[N][N];
        shark = new Shark[M+1];
        cnt = M;
        
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 0)
                    map[i][j] = new Info(0, -1);
                else {
                    map[i][j] = new Info(t, k);
                    shark[t] = new Shark(i, j);
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M ; i++)
            shark[i].current = Integer.parseInt(st.nextToken());
            
        for(int i = 1 ; i <= M ; i++) {
            for(int j = 1 ; j <= 4 ; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < 4 ; k++)
                    shark[i].direction[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        while(cnt > 1) {
            if(second >= 1000) {
                System.out.println(-1);
                return;
            }
            
            
            now = new int[N][N];
            for(int i = 1 ; i <= M ; i++) {
                if(shark[i].current == -1)
                    continue;
                    
                if(!move(i)) //냄새없는 칸으로 이동
                    rollback(i); //자신의 냄새가 있는 칸으로 이동
            }
            
            //냄새 시간 감소
            clean();
            
            second++;
        }
        
        System.out.println(second);
        br.close();
    }
    
    private static void clean() {
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < N ; j++) {
                if(map[i][j].time != -1)
                    map[i][j].time--;
                if(map[i][j].time == 0)
                    map[i][j] = new Info(0, -1);
            }
            
        for(int i = 1 ; i <= M ; i++) {
            if(shark[i].current == -1)
                continue;
            map[shark[i].x][shark[i].y] = new Info(i, k);
        }
    }
    
    private static void rollback(int sharknum) {
        Shark s = shark[sharknum];
        for(int a = 0 ; a < 4 ; a++) {
            int dir = s.direction[s.current][a];
            int nx = s.x + dx[dir];
            int ny = s.y + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            
            if(map[nx][ny].num != sharknum)
                continue;
            
            s.x = nx;   s.y = ny;
            s.current = dir;
            now[nx][ny] = sharknum;
            break;

        }
    }
    
    private static boolean move(int sharknum) {
        Shark s = shark[sharknum];
        for(int a = 0 ; a < 4 ; a++) {
            int dir = s.direction[s.current][a];
            int nx = s.x + dx[dir];
            int ny = s.y + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            
            if(map[nx][ny].num > 0)
                continue;
            
            if(now[nx][ny] == 0) {
                s.x = nx;   s.y = ny;
                s.current = dir;
                now[nx][ny] = sharknum;
            } else {
                s.current = -1;
                cnt--;
            }
            return true;
        }
        
        return false;
    }
}
