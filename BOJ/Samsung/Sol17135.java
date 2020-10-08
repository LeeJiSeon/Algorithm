import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class Enemy implements Comparable<Enemy> {
    int x, y, dist;
    
    Enemy(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Enemy e) {
        if(e.dist == this.dist)
            return this.y - e.y;
        else
            return this.dist - e.dist;
    }
}


class Sol17135 {
    static int n, m, d, max = Integer.MIN_VALUE;
    static int[][] castle, copy;
    static int[] defense;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        defense = new int[3];
        castle = new int[n][m];
        copy = new int[n][m];
        
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++)
                castle[i][j] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        System.out.println(max);
        
        br.close();
    }
    
    private static void dfs(int start, int cnt) {
        if(cnt == 3) {
            int sum = 0;
            copyCastle();
            for(int i = 0 ; i < n ; i++) {
                sum += killEnemy();
                moveCastle();
            }
            max = Math.max(max, sum);
            return;
        }
        
        for(int i = start ; i < m ; i++) {
            defense[cnt] = i;
            dfs(start + 1, cnt + 1);
        }
    }
    
    private static void copyCastle() {
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++)
                copy[i][j] = castle[i][j];
    }
    
    private static void moveCastle() {
        for(int i = n - 2 ; i >= 0 ; i--)
            for(int j = 0 ; j < m ; j++)
                copy[i+1][j] = copy[i][j];
        for(int i = 0 ; i < m ; i++)
            copy[0][i] = 0;
    }
    
    private static int killEnemy() {
        int sum = 0;
        List<Enemy> list = new ArrayList<>();
        for(int i : defense) {
            PriorityQueue<Enemy> pq = new PriorityQueue<>();
            int dist = 0;
            for(int r = n-1 ; r >= 0 ; r--) {
                for(int c = 0 ; c < m ; c++) {
                    if(copy[r][c] == 1) {
                        dist = Math.abs(n - r) + Math.abs(i - c);
                        if(dist <= d)
                            pq.offer(new Enemy(r, c, dist));
                    }
                }
            }
            if(!pq.isEmpty())
                list.add(pq.poll());
        }
        
        for(Enemy e : list) {
            if(copy[e.x][e.y] == 1) {
                copy[e.x][e.y] = 0;
                sum++;
            }
        }
        
        return sum;
    }

}
