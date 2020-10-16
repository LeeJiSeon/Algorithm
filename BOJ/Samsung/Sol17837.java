import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Sol17837 {
    static int N, K;
    static int[][] map;
    static List<Integer>[][] list;
    static Horse[] horse;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        list = new ArrayList[N+1][N+1];
        horse = new Horse[K+1];
        
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                list[i][j] = new ArrayList<>();
            }
        }
        
        for(int i = 1 ; i <= K ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            list[x][y].add(i);
            int idx = list[x][y].size() - 1;
            
            horse[i] = new Horse(x, y, d, idx);
        }
        
        
        //solve problem
        int count = 1;
        while(count <= 1000) {
            if(move())
                break;
            
            count++;
        }
        
        System.out.println(count <= 1000 ? count : -1);
        br.close();
    }
    
    private static boolean move() {
        for(int i = 1 ; i <= K ; i++) {
            Horse h = horse[i];
            int nx = h.x + dx[h.dir];
            int ny = h.y + dy[h.dir];
            
            if((nx <= 0 || nx > N || ny <= 0 || ny > N) || map[nx][ny] == 2) {
                h.dir = (h.dir % 2 == 0) ? h.dir-1 : h.dir+1;
                nx = h.x + dx[h.dir];
                ny = h.y + dy[h.dir];
                
                if((nx <= 0 || nx > N || ny <= 0 || ny > N) || map[nx][ny] == 2) {
                    continue;
                } else if(map[nx][ny] == 0) {
                    movewhite(h, nx, ny);
                } else if(map[nx][ny] == 1) {
                    movered(h, nx, ny);
                }
                
            } else if(map[nx][ny] == 0) {
                movewhite(h, nx, ny);
            } else if(map[nx][ny] == 1) {
                movered(h, nx, ny);
            }
            
            if(list[h.x][h.y].size() >= 4)
                return true;
        }
        
        return false;
    }
    
    private static void movered(Horse h, int nx, int ny) {
        int size = list[h.x][h.y].size();
        int nsize = list[nx][ny].size();
        int idx = h.idx, x = h.x, y = h.y;
        for(int i = size - 1 ; i >= idx ; i--) {
            int num = list[x][y].get(i);
            Horse tmp = horse[num];
            list[x][y].remove(i);
            list[nx][ny].add(num);
            tmp.x = nx;     tmp.y = ny;     tmp.idx = nsize++;
        }
    }
    
    private static void movewhite(Horse h, int nx, int ny) {
        int nsize = list[nx][ny].size();
        int idx = h.idx, x = h.x, y = h.y;
        while(list[x][y].size() > idx) {
            int num = list[x][y].get(idx);
            Horse tmp = horse[num];
            list[x][y].remove(idx);
            list[nx][ny].add(num);
            tmp.x = nx;     tmp.y = ny;     tmp.idx = nsize++;
        }
    }
}

class Horse {
    int x, y, dir, idx;
    
    Horse(int x, int y, int dir, int idx) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.idx = idx;
    }
}
