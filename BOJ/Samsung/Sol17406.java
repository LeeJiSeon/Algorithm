import java.util.*;
public class Sol17406 {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, k;
    static int[][] arr, rot, copy;
    static int[] per;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n+1][m+1];
        rot = new int[k+1][3];
        per = new int[k];
        for(int i = 0 ; i < k ; i++)
            per[i] = i+1;
        for(int i = 1 ; i <= n ; i++)
            for(int j = 1 ; j <= m ; j++)
                arr[i][j] = sc.nextInt();
        for(int i = 1 ; i <= k ; i++)
            for(int j = 0 ; j < 3 ; j++)
                rot[i][j] = sc.nextInt();
        
        do {
            copy = new int[n+1][m+1];
            copyArr();
            for(int i = 0 ; i < k ; i++) {
                int r = rot[per[i]][0];
                int c = rot[per[i]][1];
                int s = rot[per[i]][2];
                Node start = new Node(r-s, c-s);
                Node end = new Node(r+s, c+s);
                rotate(start, end);
            }
            min = Math.min(min, calcSum());
        } while(nextPermutation());

        System.out.println(min);
        sc.close();
    }

    static int calcSum() {
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++) {
            int sum = 0;
            for(int j = 1 ; j <= m ; j++)
                sum += copy[i][j];
            min = Math.min(sum, min);
        }
        return min;
    }
    static void rotate(Node start, Node end) {
        while(start.x < end.x && start.y < end.y) {
            int idx = 0;
            int nx = start.x;
            int ny = start.y;
            int tmp = copy[nx][ny];
            do {
                nx += dx[idx];
                ny += dy[idx];
                tmp = move(tmp, nx, ny);
                if(nx == start.x && ny == end.y)    idx = 1;
                else if(nx == end.x && ny == end.y)    idx = 2;
                else if(nx == end.x && ny == start.y)    idx = 3;
            } while(nx != start.x || ny != start.y);
            start.x++;
            start.y++;
            end.x--;
            end.y--;
        }
    }

    static int move(int tmp, int i, int j) {
        int result = copy[i][j];
        copy[i][j] = tmp;
        return result;
    }

    static void copyArr() {
        for(int i = 1 ; i <= n ; i++)
            for(int j = 1 ; j <= m ; j++)
                copy[i][j] = arr[i][j];
    }
    static boolean nextPermutation() {
        int i = k-1;
        int j = k-1;
        while(i != 0 && per[i-1] > per[i])  i--;
        if(i == 0)  return false;

        while(per[i-1] > per[j])    j--;
        swap(i-1, j);

        j = k-1;
        while(i < j)    swap(i++, j--);

        return true;
    }

    static void swap(int i, int j) {
        int tmp = per[i];
        per[i] = per[j];
        per[j] = tmp;
    }
}