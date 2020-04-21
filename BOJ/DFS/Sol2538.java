import java.util.*;
class Sol2538 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int m, n;
    static int[][] area;
    static Stack<Point> stack = new Stack<>();
    static int count = 0;
    static int[] cx = {-1, 1, 0, 0};
    static int[] cy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        area = new int[m][n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < k ; i++) {
            int[] v = new int[4];
            for(int j = 0 ; j < 4 ; j++)
                v[j] = sc.nextInt();
            for(int j = v[0] ; j < v[2] ; j++)
                for(int l = v[1] ; l < v[3] ; l++)
                    area[l][j] = 1;
        }

        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++) {
                if(area[i][j] == 0) {
                    area[i][j] = 1;
                    count = 1;
                    dfs(new Point(i, j));
                    list.add(count);
                }
            }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list)
            System.out.print(i + " ");
    }

    static void dfs(Point point) {
        for(int i = 0 ; i < 4 ; i++) {
            int x = point.x + cx[i];
            int y = point.y + cy[i];
            if(x >= 0 && x < m && y >= 0 && y < n) 
                if(area[x][y] == 0) {
                    stack.add(new Point(x, y));
                    area[x][y] = 1;
                }
        }
        while(!stack.isEmpty()) {
            Point np = stack.pop();
            count++;
            dfs(np);
        }
    }
}