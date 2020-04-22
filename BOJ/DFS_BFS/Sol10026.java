import java.util.*;
class Sol10026 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static Stack<Point> stack = new Stack<>();
    static int[] cx = {-1, 1, 0, 0};
    static int[] cy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String[][] area = new String[n][n];
        String[][] copy = new String[n][n];
        boolean[][] check_a = new boolean[n][n];
        boolean[][] check_c = new boolean[n][n];
        int a = 0, c = 0;

        for(int i = 0 ; i < n ; i++) {
            area[i] = sc.next().split("");
            for(int j = 0 ; j < n ; j++) {
                if(area[i][j].equals("G"))
                    copy[i][j] = "R";
                else
                    copy[i][j] = area[i][j];
            }
        }

        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++) {
                if(!check_a[i][j]) {
                    check_a[i][j] = true;
                    a++;
                    dfs(new Point(i, j), check_a, area, area[i][j]);
                }
            }

        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++) {
                if(!check_c[i][j]) {
                    check_c[i][j] = true;
                    c++;
                    dfs(new Point(i, j), check_c, copy, copy[i][j]);
                }
            }
        
        System.out.println(a + " " + c);
    }

    static void dfs(Point point, boolean[][] check, String[][] area, String color) {
        for(int i = 0 ; i < 4 ; i++) {
            int x = point.x + cx[i];
            int y = point.y + cy[i];
            if(x >= 0 && x < n && y >= 0 && y < n)
                if(!check[x][y] && area[x][y].equals(color)) {
                    check[x][y] = true;
                    stack.add(new Point(x, y));
                }
        }
        while(!stack.isEmpty()) {
            Point p = stack.pop();
            dfs(p, check, area, color);
        }
    }
}