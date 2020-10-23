import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol9663 {
    static int n, ans = 0;
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());	
        pos = new int[n];

        for(int i = 0; i < n; i++) {
            pos[0] = i;
            dfs(1);
        }

        System.out.println(ans);
        br.close();
    }

    private static void dfs(int row) {
        if(row == n) {
            ans++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isPromising(row, i)) {
                pos[row] = i;
                dfs(row+1);
            }
        }
    }

    private static boolean isPromising(int row, int col) {
        for(int i = 0; i < row; i++) {
            if(pos[i] == col)   return false;
            if(row-i == Math.abs(col-pos[i]))   return false;
        }
        return true;
    }
}
