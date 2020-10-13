import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sol14891 {
    static char[][] wheel;
    static int[] rotateDir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        wheel = new char[4][8];

        for(int i = 0 ; i < 4 ; i++) {
            String input = br.readLine();
            for(int j = 0 ; j < 8 ; j++)
                wheel[i][j] = input.charAt(j);
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            rotateDir = new int[4];

            check(num, dir);
            rotate();
        }

        for(int i = 0 ; i < 4 ; i++) {
            if(wheel[i][0] == '1')
                sum += Math.pow(2, i);
        }
        
        System.out.println(sum);
        br.close();
    }

    private static void rotate() {
        for(int i = 0 ; i < 4 ; i++) {
            if(rotateDir[i] == 1) {
                char pre = wheel[i][7], next;
                for(int j = 0 ; j < 8 ; j++) {
                    next = wheel[i][j];
                    wheel[i][j] = pre;
                    pre = next;
                }
            } else if(rotateDir[i] == -1) {
                char pre = wheel[i][0], next;
                for(int j = 7 ; j >= 0 ; j--) {
                    next = wheel[i][j];
                    wheel[i][j] = pre;
                    pre = next;
                }
            }
        }
    }

    private static void check(int num, int dir) {
        rotateDir[num] = dir;

        int pre = num - 1;
        int next = num + 1;

        if(pre >= 0 && rotateDir[pre] == 0) {
            if(wheel[num][6] != wheel[pre][2])
                check(pre, dir * -1);
        }
        if(next <= 3 && rotateDir[next] == 0) {
            if(wheel[num][2] != wheel[next][6])
                check(next, dir * -1);
        }
    }
}