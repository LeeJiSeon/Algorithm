import java.util.*;
class Sol14502 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map, copy;
    static List<Point> virusList = new ArrayList<>();
    static int max;
    static int[] cx = {-1, 1, 0, 0};
    static int[] cy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        copy = new int[N][M];
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2)
                    virusList.add(new Point(i, j));
            }
        setWall(0, 0);
        System.out.println(max);
    }

    static void setWall(int count, int start) {
        if(count == 3) {
            copyMap();
            for(Point p : virusList)
                spreadVirus(p.x, p.y);
            max = Math.max(max, countSafe());
            return;
        }
        for(int i = start ; i < N * M ; i++) {
            int nx = i / M;
            int ny = i % M;
            if(map[nx][ny] == 0) {
                map[nx][ny] = 1;
                setWall(count + 1, i + 1);
                map[nx][ny] = 0;
            }
        }
    }

    static void spreadVirus(int x, int y) {
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + cx[i];
            int ny = y + cy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }       
    }

    static void copyMap() {
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < M ; j++)
                copy[i][j] = map[i][j];
    }

    static int countSafe() {
        int count = 0;
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < M ; j++)
                if(copy[i][j] == 0)
                    count++;
        return count;
    }
}