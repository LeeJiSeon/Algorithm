import java.util.*;
class Sol2468 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] area, copy;
    static int n;
    static Stack<Point> stack = new Stack<>();
    static int[] cx = {-1, 1, 0, 0};
    static int[] cy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        area = new int[n][n];
        int max_h = 0;
        int max_area = 1;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++) {
                area[i][j] = sc.nextInt();
                max_h = Math.max(max_h, area[i][j]);
            }
        
        for(int i = 1 ; i <= max_h ; i++) {
            max_area = Math.max(max_area, countArea(i));
            
        }
        System.out.println(max_area);
    }

    static void copyArea(int h) {
        copy = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++) {
                if(area[i][j] <= h)
                    copy[i][j] = 1;
            }
    }

    static int countArea(int h) {
        copyArea(h);
        int count = 0;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++) {
                if(copy[i][j] == 0) {
                    dfs(new Point(i, j));
                    count++;
                }
            }
        return count;
    }

    static void dfs(Point point) {
        for(int i = 0 ; i < 4 ; i++) {
            int x = point.x + cx[i];
            int y = point.y + cy[i];
            if(x >= 0 && x < n && y >= 0 && y < n) {
                if(copy[x][y] == 0) {
                    copy[x][y] = 1;
                    stack.add(new Point(x, y));
                }
            }
        }
        while(!stack.isEmpty()) {
            Point p = stack.pop();
            dfs(p);
        }
    }
}