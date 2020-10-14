import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol17822 {
    static int N, M, T;
    static int[][] circle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        circle = new int[N+1][M];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
                circle[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int a = 0 ; a < T ; a++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);

        }
    }

    private static void rotate(int x, int d, int k) {
        for(int i = x ; i <= N ; i += x){
            if(d == 0)  rotateclock(i, k);
            else    rotatereverse(i, k);
        }
    }

    private static void rotateclock(int r, int k) {
        for(int i = 0 ; i < k ; i++) {
            int pre = circle[r][M-1], next;
            for(int j = 0 ; j < M ; j++) {
                next = circle[r][j];
                circle[r][j] = pre;
                pre = next;
            }
        }
    }

    private static void rotatereverse(int r, int k) {
        for(int i = 0 ; i < k ; i++) {
            int pre = circle[r][0], next;
            for(int j = M-1 ; j >= 0 ; j--) {
                next = circle[r][j];
                circle[r][j] = pre;
                pre = next;
            }
        }
    }

    private static boolean findadj() {
        
        return true;
    }
}