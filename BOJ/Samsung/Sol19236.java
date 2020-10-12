import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish {
    int x, y, dir;
    boolean isAlive;
    
    Fish(int x, int y, int dir, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isAlive = isAlive;
    }
}

class Shark {
    int x, y, dir;
    
    Shark(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

class Sol19236 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] map = new int[4][4];
        Fish[] fish = new Fish[17];
        
        for(int i = 0 ; i < 4 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4 ; j++) {
                int f = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[i][j] = f;
                fish[f] = new Fish(i, j, d-1, true);
            }
        }
        
        int eat = map[0][0];
        fish[eat].isAlive = false;
        map[0][0] = -1;
        dfs(map, fish, new Shark(0, 0, fish[eat].dir), eat);
        
        System.out.println(max);
        
        br.close();
    }
    
    private static void dfs(int[][] map, Fish[] fish, Shark shark, int eat) {
        int[][] copymap = new int[4][4];
        Fish[] copyfish = new Fish[17];
        
        copy(copymap, copyfish, map, fish);
        
        moveFish(copymap, copyfish);
        
        //eat fish
        boolean flag = false;
        for(int i = 1 ; i <= 3 ; i++) {
            int nx = shark.x + i * dx[shark.dir];
            int ny = shark.y + i * dy[shark.dir];
            
            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
                break;
            
            int fishnum = copymap[nx][ny];
            if(fishnum > 0) {
                flag = true;
                
                copymap[shark.x][shark.y] = 0;
                copyfish[fishnum].isAlive = false;
                copymap[nx][ny] = -1;
                
                dfs(copymap, copyfish, new Shark(nx, ny, copyfish[fishnum].dir), eat + fishnum);
                copymap[nx][ny] = fishnum;
                copyfish[fishnum].isAlive = true;
                copymap[shark.x][shark.y] = -1;
            }
        }
        
        if(!flag)    max = Math.max(max, eat);
    }
    
    
    private static void moveFish(int[][] map, Fish[] fish) {
        //move fish
        for(int i = 1 ; i < 17 ; i++) {
            Fish f = fish[i];
            
            if(f.isAlive) {
                int nd = f.dir;
                
                for(int j = 0 ; j < 8 ; j++) {
                    
                    int nx = f.x + dx[nd];
                    int ny = f.y + dy[nd];
                    
                    if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || map[nx][ny] == -1) {
                        nd = nd + 1 == 8 ? 0 : nd + 1;
                        continue;
                    }
                    
                    if(map[nx][ny] == 0) {
                        map[f.x][f.y] = 0;
                        map[nx][ny] = i;
                        fish[i] = new Fish(nx, ny, nd, f.isAlive);
                        break;
                    } else {
                        map[f.x][f.y] = map[nx][ny];
                        fish[map[nx][ny]].x = f.x;
                        fish[map[nx][ny]].y = f.y;
                        map[nx][ny] = i;
                        fish[i] = new Fish(nx, ny, nd, f.isAlive);
                        break;
                    }
                    
                }
            } 
        }
    }
    
    private static void copy(int[][] copymap, Fish[] copyfish, int[][] map, Fish[] fish) {
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                copymap[i][j] = map[i][j];
                
        for(int i = 1 ; i < 17 ; i++)
            copyfish[i] = new Fish(fish[i].x, fish[i].y, fish[i].dir, fish[i].isAlive);
    }
    
}
