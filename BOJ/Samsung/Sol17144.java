import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sol17144 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C;
    static int top, bottom;
    static int[][] map, tmp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ans = 0;
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        
        for(int i = 0 ; i < R ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    top = i - 1;
                    bottom = i;
                }
            }
        }
        
        for(int i = 0 ; i < T ; i++) {
            spread();
            cleanTop();
            cleanBottom();
        }
        
        for(int i = 0 ; i < R ; i++) 
            for(int j = 0 ; j < C ; j++) 
                if(map[i][j] > 0)
                    ans += map[i][j];
        
        System.out.println(ans);
        
        br.close();
    }
    
    private static void spread() {
        tmp = new int[R][C];
        
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(map[i][j] > 0) {
                    int weight = map[i][j] / 5;
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
                            continue;
                            
                        tmp[nx][ny] += weight;
                        map[i][j] -= weight;
                    }
                }
            }
        }
        
        for(int i = 0 ; i < R ; i++)
            for(int j = 0 ; j < C ; j++)
                map[i][j] += tmp[i][j];
    }

    private static void cleanTop() {
        int i = top;
        int j = 1;
        int pre = map[i][j], next;
        map[i][j] = 0;
        
        for(; j < C - 1 ; j++) {
            next = map[i][j+1];
            map[i][j+1] = pre;
            pre = next;
        }
        for(; i > 0 ; i--) {
            next = map[i-1][j];
            map[i-1][j] = pre;
            pre = next;
        }
        for(; j > 0 ; j--) {
            next = map[i][j-1];
            map[i][j-1] = pre;
            pre = next;
        }
        for(; i < top - 1 ; i++) {
            next = map[i+1][j];
            map[i+1][j] = pre;
            pre = next;
        }
        
    }
    
    private static void cleanBottom() {
        int i = bottom;
        int j = 1;
        int pre = map[i][j], next;
        map[i][j] = 0;
        
        for(; j < C - 1 ; j++) {
            next = map[i][j+1];
            map[i][j+1] = pre;
            pre = next;
        }
        for(; i < R - 1 ; i++) {
            next = map[i+1][j];
            map[i+1][j] = pre;
            pre = next;
        }
        for(; j > 0 ; j--) {
            next = map[i][j-1];
            map[i][j-1] = pre;
            pre = next;
        }
        for(; i > bottom + 1 ; i--) {
            next = map[i-1][j];
            map[i-1][j] = pre;
            pre = next;
        }
    }
}
